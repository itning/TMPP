package top.sl.tmpp.common.mapper;

import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.common.entity.Book;
import top.sl.tmpp.common.entity.BookExample;
import top.sl.tmpp.common.pojo.OReview;

import java.util.List;

public interface BookMapper {
    long countByExample(BookExample example);

    int deleteByExample(BookExample example);

    int deleteByPrimaryKey(String id);

    int insert(Book record);

    int insertSelective(Book record);

    List<Book> selectByExample(BookExample example);

    Book selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);

    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> selectMyBook(@Param("loginUserId") String loginUserId, @Param("executePlanId") String executePlanId);

    List<OReview> selectOReviews(@Param("executePlanId") String executePlanId);

    List<Book> selectAllByExecutePlanId(@Param("executePlanId") String executePlanId);

    List<Book> selectIdAndStatus(@Param("executePlanId") String executePlanId);

    List<Book> selectByPlanId(@Param("planId") String planId);
}