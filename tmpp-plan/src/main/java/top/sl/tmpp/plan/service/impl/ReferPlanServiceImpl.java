package top.sl.tmpp.plan.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import top.sl.tmpp.common.entity.Colleges;
import top.sl.tmpp.common.entity.CollegesExample;
import top.sl.tmpp.common.entity.ExecutePlan;
import top.sl.tmpp.common.entity.Plan;
import top.sl.tmpp.common.mapper.CollegesMapper;
import top.sl.tmpp.common.mapper.ExecutePlanMapper;
import top.sl.tmpp.common.mapper.PlanMapper;
import top.sl.tmpp.plan.exception.AddPlanException;
import top.sl.tmpp.plan.service.ReferPlanService;
import top.sl.tmpp.plan.util.FileUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author ShuLu
 * @date 2019/6/17 13:46
 */
@Service
public class ReferPlanServiceImpl implements ReferPlanService {
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
    private final PlanMapper planMapper;
    private final ExecutePlanMapper executePlanMapper;
    private final CollegesMapper collegesMapper;

    public ReferPlanServiceImpl(PlanMapper planMapper, ExecutePlanMapper executePlanMapper, CollegesMapper collegesMapper) {
        this.planMapper = planMapper;
        this.executePlanMapper = executePlanMapper;
        this.collegesMapper = collegesMapper;
    }

    @Override
    public void referPlan(String year, int term, String teachingDepartment, String educationalLevel, String fileId) {
        File excelFile = new File(System.getProperty("java.io.tmpdir")+File.separator+fileId);
        try {
            InputStream in = new FileInputStream(excelFile);
            List<List<String>> list = FileUtil.getBankListByExcel(in, excelFile.getName());
            String id = UUID.randomUUID().toString().replace("-", "");
            ExecutePlan executePlan = new ExecutePlan(id, year, term, educationalLevel, null, new Date(), teachingDepartment,fileId.split(".")[1], Files.readAllBytes(excelFile.toPath()));
            executePlanMapper.insert(executePlan);
            logger.debug("添加执行计划成功");
            String collegesId = null;
            String useSchoolYear = null;
            try {
                for (int i = 0; list.size() > i; i++) {
                    if (i == 0) {
                        CollegesExample collegesExample = new CollegesExample();
                        collegesExample.createCriteria().andNameEqualTo(list.get(i).get(13));
                        List<Colleges> colleges = collegesMapper.selectByExample(collegesExample);
                        collegesId = colleges.get(i).getId();
                        useSchoolYear = list.get(i).get(4);
                    }else if (i > 1) {
                        Plan plan = new Plan(UUID.randomUUID().toString().replace("-", "")
                                , collegesId
                                , teachingDepartment
                                , "考试".equals(list.get(i).get(5)) ? 0 : 1
                                , useSchoolYear
                                , list.get(i).get(7)
                                , Integer.parseInt(list.get(i).get(8).split("\\.")[0])
                                , list.get(i).get(9)
                                , null
                                , new Date()
                                , id);
                        planMapper.insert(plan);
                    }
                }
            } catch (NumberFormatException e) {
                throw new AddPlanException("添加计划异常", HttpStatus.ACCEPTED);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public ExecutePlan downloadExecutePlan(String id) {
        return null;
    }
}
