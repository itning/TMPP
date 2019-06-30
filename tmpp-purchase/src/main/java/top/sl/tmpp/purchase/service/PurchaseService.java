package top.sl.tmpp.purchase.service;

import com.github.pagehelper.PageInfo;
import top.sl.tmpp.common.entity.Book;
import top.sl.tmpp.common.entity.LoginUser;
import top.sl.tmpp.common.pojo.TBook;

/**
 * @author itning
 * @date 2019/6/23 15:10
 */
public interface PurchaseService {
    /**
     * 保存购书计划
     *
     * @param executePlanId 执行计划ID
     * @param book          购书计划
     */
    void saveBook(String executePlanId, Book book);

    /**
     * 根据执行计划ID获取教师购书
     *
     * @param loginUserId   用户ID
     * @param executePlanId 执行计划ID
     * @param page          页数
     * @param size          数量
     * @return 教师购书
     */
    PageInfo<TBook> getAllTeacherBooks(String loginUserId, String executePlanId, int page, int size);

    /**
     * 修改购书
     *
     * @param book      购书
     * @param loginUser 登录的用户
     */
    void upTeacherBook(Book book, LoginUser loginUser);
}
