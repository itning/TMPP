package top.sl.tmpp.common.mapper;

import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.common.entity.Book;
import top.sl.tmpp.common.pojo.BookDTO;
import top.sl.tmpp.common.pojo.BookReviewDTO;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(String id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<BookDTO> selectMyBook(@Param("loginUserId") String loginUserId, @Param("executePlanId") String executePlanId);

    List<BookDTO> selectReviews(@Param("executePlanId") String executePlanId);

    List<BookReviewDTO> selectAllByExecutePlanId(@Param("executePlanId") String executePlanId);

    List<Book> selectIdAndStatus(@Param("executePlanId") String executePlanId);

    List<Book> selectByPlanId(@Param("planId") String planId);
}