package top.sl.tmpp.common.mapper;

import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.common.entity.Course;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(String id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> selectAllFromExecutePlanId(@Param("execute_plan_id") String executePlanId);

    List<Course> selectAll();

    String selectIdByCourseCode(@Param("courseCode") String courseCode);

    List<Course> selectAllByCourseId(@Param("courseId") String courseId);
}