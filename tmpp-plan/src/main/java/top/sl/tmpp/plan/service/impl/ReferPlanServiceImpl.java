package top.sl.tmpp.plan.service.impl;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.sl.tmpp.common.entity.Course;
import top.sl.tmpp.common.entity.ExecutePlan;
import top.sl.tmpp.common.entity.Plan;
import top.sl.tmpp.common.mapper.*;
import top.sl.tmpp.common.util.ObjectUtils;
import top.sl.tmpp.plan.exception.ExcelReadException;
import top.sl.tmpp.plan.exception.FileException;
import top.sl.tmpp.plan.service.ReferPlanService;
import top.sl.tmpp.plan.util.FileUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static top.sl.tmpp.common.util.ObjectUtils.checkNotNull;


/**
 * @author ShuLu
 * @date 2019/6/17 13:46
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ReferPlanServiceImpl implements ReferPlanService {
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
    private final PlanMapper planMapper;
    private final ExecutePlanMapper executePlanMapper;
    private final CollegesMapper collegesMapper;
    private final BookMapper bookMapper;
    private final CourseMapper courseMapper;

    public ReferPlanServiceImpl(PlanMapper planMapper, ExecutePlanMapper executePlanMapper, CollegesMapper collegesMapper, BookMapper bookMapper, CourseMapper courseMapper) {
        this.planMapper = planMapper;
        this.executePlanMapper = executePlanMapper;
        this.collegesMapper = collegesMapper;
        this.bookMapper = bookMapper;
        this.courseMapper = courseMapper;
    }

    @Override
    public void referPlan(String year, boolean term, String teachingDepartment, String educationalLevel, String fileId) {
        String fileName = System.getProperty("java.io.tmpdir") + File.separator + fileId;
        File file = new File(fileName);
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            Workbook workbook = FileUtil.getWorkbook(fileInputStream, fileName);
            if (workbook.getNumberOfSheets() < 1) {
                throw new FileException("工作簿数量错误：" + workbook.getNumberOfSheets(), HttpStatus.BAD_REQUEST);
            }
            Sheet sheet = workbook.getSheetAt(0);
            logger.debug("获取到最后的行数->{}", sheet.getLastRowNum());

            String newExecutePlanId = UUID.randomUUID().toString().replace("-", "");

            ExecutePlan executePlan = new ExecutePlan();
            executePlan.setId(newExecutePlanId);
            executePlan.setYear(year);
            executePlan.setTerm(term);
            executePlan.setGrade(ObjectUtils.toInt(getCellValue(sheet.getRow(1), 1), () -> new ExcelReadException(1, 1)));
            executePlan.setStatus(false);
            executePlan.setFileType(fileId.substring(fileId.indexOf(".") + 1));
            executePlan.setLevelId(educationalLevel);
            executePlan.setDepartmentId(teachingDepartment);
            Date d = new Date();
            executePlan.setGmtModified(d);
            executePlan.setGmtCreate(d);
            byte[] bytes = FileUtils.readFileToByteArray(file);
            executePlan.setFile(bytes);

            List<Plan> planList = new ArrayList<>(sheet.getLastRowNum());
            for (int rowIndex = 3; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                logger.debug("开始获取第{}行", rowIndex);
                Row row = sheet.getRow(rowIndex);

                String collegeName = getCellValue(row, 1);
                String startPro = getCellValue(row, 2);
                String courseCode = getCellValue(row, 3);
                String courseName = getCellValue(row, 4);
                String type = getCellValue(row, 5);
                String clazz = getCellValue(row, 6);
                String clazzNumber = getCellValue(row, 7);
                String teacher = getCellValue(row, 8);
                String remark = getCellValue(row, 9);
                //检查关键字段不为空
                checkCellNoneBlank(rowIndex, collegeName, startPro, courseCode, courseName, type, clazz, clazzNumber, teacher);

                final int tempRowIndex = rowIndex;

                //学院ID
                String collegeId = checkNotNull(collegesMapper.selectIdByName(collegeName), () -> new ExcelReadException(tempRowIndex + 1, 2, "学院不存在"));
                //人数
                int clazzNum = ObjectUtils.toInt(clazzNumber, () -> new ExcelReadException(tempRowIndex + 1, 8, "人数错误"));
                //课程ID
                String courseId = getIdOrInsertCourseByCode(courseCode, courseName);

                Plan plan = new Plan();
                plan.setId(UUID.randomUUID().toString().replace("-", ""));
                plan.setCollegesId(collegeId);
                plan.setStartPro(startPro);
                plan.setCourseId(courseId);
                plan.setType(false);
                plan.setClazz(clazz);
                plan.setClazzNumber(clazzNum);
                plan.setTeacher(teacher);
                plan.setRemark(remark);
                plan.setExecutePlanId(newExecutePlanId);
                Date date = new Date();
                plan.setGmtCreate(date);
                plan.setGmtModified(date);
                planList.add(plan);
            }

            executePlanMapper.insert(executePlan);
            planList.forEach(planMapper::insert);
        } catch (FileNotFoundException e) {
            throw new FileException("文件丢失，请重新上传", HttpStatus.NOT_FOUND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ExecutePlan downloadExecutePlan(String id) {
        ExecutePlan executePlan = executePlanMapper.selectFileById(id);
        logger.debug("查询执行计划成功");
        return executePlan;
    }

    @Override
    public void removeExecutePlan(String id) {
       /* if (id==null){
            throw new NoPlanException("未查找到执行计划",HttpStatus.NOT_FOUND);
        }
        try {
            logger.debug("删除执行计划相关计划");
            PlanExample planExample = new PlanExample();
            planExample.createCriteria().andExecutePlanIdEqualTo(id);
            List<Plan> plans = planMapper.selectByExample(planExample);
            plans.forEach(plan -> {
                logger.debug("删除执行计划相关书籍计划");
                BookExample bookExample = new BookExample();
                bookExample.createCriteria().andPlanIdEqualTo(plan.getId());
                bookMapper.deleteByExample(bookExample);
            });
            planMapper.deleteByExample(planExample);
            logger.debug("删除执行计划");
            executePlanMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw e;
        }*/
    }

    /**
     * 获取单元格中的数据
     *
     * @param row     行
     * @param cellNum 单元格号
     * @return 该单元格的数据
     */
    private String getCellValue(Row row, int cellNum) {
        String stringCellValue = null;
        Cell cell;
        if ((cell = row.getCell(cellNum)) != null) {
            try {
                stringCellValue = cell.getStringCellValue();
            } catch (IllegalStateException e) {
                logger.debug("getCellValue::CellNum->" + cellNum + "<-尝试获取String类型数据失败");
                try {
                    logger.debug("getCellValue::CellNum->" + cellNum + "<-尝试获取Double类型数据");
                    stringCellValue = String.valueOf(cell.getNumericCellValue());
                } catch (IllegalStateException e1) {
                    try {
                        logger.debug("getCellValue::CellNum->" + cellNum + "<-尝试获取Boolean类型数据");
                        stringCellValue = String.valueOf(cell.getBooleanCellValue());
                    } catch (IllegalStateException e2) {
                        try {
                            logger.debug("getCellValue::CellNum->" + cellNum + "<-尝试获取Date类型数据");
                            stringCellValue = String.valueOf(cell.getDateCellValue());
                        } catch (IllegalStateException e3) {
                            logger.warn("getCellValue::CellNum->" + cellNum + "<-未知类型数据->" + e3.getMessage());
                        }
                    }
                }
            } finally {
                logger.debug("getCellValue::第" + cellNum + "格获取到的数据为->" + stringCellValue);
            }
        } else {
            logger.debug("getCellValue::第" + cellNum + "格为空");
        }
        return stringCellValue;
    }

    /**
     * 根据课程代码获取课程ID，不存在则新增
     *
     * @param courseCode 课程代码
     * @param courseName 课程名
     * @return 课程ID
     */
    private String getIdOrInsertCourseByCode(String courseCode, String courseName) {
        String id = courseMapper.selectIdByCourseCode(courseCode);
        if (id == null) {
            String courseId = UUID.randomUUID().toString().replace("-", "");
            Course course = new Course();
            course.setId(courseId);
            course.setName(courseName);
            course.setCode(courseCode);
            Date date = new Date();
            course.setGmtModified(date);
            course.setGmtCreate(date);
            courseMapper.insert(course);
            return courseId;
        }
        return id;
    }

    /**
     * 检查单元格不为空
     *
     * @param rowIndex 行索引
     * @param cells    单元格数据
     * @throws ExcelReadException 如果单元格数据为空
     */
    private void checkCellNoneBlank(int rowIndex, String... cells) {
        Optional<Integer> optional = ObjectUtils.checkStringIsNotBlank(cells);
        if (optional.isPresent()) {
            throw new ExcelReadException(rowIndex + 1, optional.get() + 2);
        }
    }
}
