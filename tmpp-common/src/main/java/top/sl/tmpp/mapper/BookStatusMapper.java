package top.sl.tmpp.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.sl.tmpp.entity.BookStatus;
import top.sl.tmpp.entity.BookStatusExample;

public interface BookStatusMapper {
    long countByExample(BookStatusExample example);

    int deleteByExample(BookStatusExample example);

    int deleteByPrimaryKey(String id);

    int insert(BookStatus record);

    int insertSelective(BookStatus record);

    List<BookStatus> selectByExample(BookStatusExample example);

    BookStatus selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") BookStatus record, @Param("example") BookStatusExample example);

    int updateByExample(@Param("record") BookStatus record, @Param("example") BookStatusExample example);

    int updateByPrimaryKeySelective(BookStatus record);

    int updateByPrimaryKey(BookStatus record);
}