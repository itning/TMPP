package top.sl.tmpp.purchase.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.sl.tmpp.purchase.service.ReferPlanService;
import top.sl.tmpp.purchase.util.FileUtil;

/**
 * @author ShuLu
 * @date 2019/6/17 13:46
 */
@Service
public class ReferPlanServiceImpl implements ReferPlanService {
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);

    @Override
    public void referPlan(String year, int term, String teachingDepartment, String educationalLevel, String fileId) {

    }
}
