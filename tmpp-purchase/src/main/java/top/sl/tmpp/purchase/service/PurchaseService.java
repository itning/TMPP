package top.sl.tmpp.purchase.service;

import com.github.pagehelper.PageInfo;
import top.sl.tmpp.common.entity.Book;
import top.sl.tmpp.common.pojo.TBook;

/**
 * @author itning
 * @date 2019/6/23 15:10
 */
public interface PurchaseService {
    /**
     * 保存购书计划
     *
     * @param book 购书计划
     */
    void saveBook(Book book);

    /**
     * 根据执行计划ID获取教师购书
     *
     * @param loginUserId 用户ID
     * @param planId      执行计划ID
     * @return 教师购书
     */
    PageInfo<TBook> getAllTeacherBooks(String loginUserId, String planId, int page, int size);

    /**
     * 修改购书
     *
     * @param book 购书
     */
    void upTeacherBook(Book book);
}
