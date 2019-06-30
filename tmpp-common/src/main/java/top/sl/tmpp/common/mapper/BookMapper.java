package top.sl.tmpp.common.mapper;

import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.common.entity.Book;
import top.sl.tmpp.common.pojo.OReview;
import top.sl.tmpp.common.pojo.TBook;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(String id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<TBook> selectMyBook(@Param("loginUserId") String loginUserId, @Param("executePlanId") String executePlanId);

    List<OReview> selectOReviews(@Param("executePlanId") String executePlanId);

    List<Book> selectAllByExecutePlanId(@Param("executePlanId") String executePlanId);

    List<Book> selectIdAndStatus(@Param("executePlanId") String executePlanId);

    List<Book> selectByPlanId(@Param("planId") String planId);
}