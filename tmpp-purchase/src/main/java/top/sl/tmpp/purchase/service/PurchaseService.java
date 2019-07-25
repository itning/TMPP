package top.sl.tmpp.purchase.service;

import com.github.pagehelper.PageInfo;
import top.sl.tmpp.common.pojo.BookDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author itning
 * @date 2019/6/23 15:10
 */
public interface PurchaseService {
    /**
     * 购买、修改书
     *
     * @param loginUserId       登录用户ID
     * @param executePlanId     执行计划ID
     * @param courseCode        课程代码
     * @param isbn              书籍ISBN
     * @param textBookName      书名
     * @param textBookCategory  教材类别
     * @param press             出版社
     * @param author            作者
     * @param unitPrice         单价
     * @param teacherBookNumber 教师样书数量
     * @param discount          折扣
     * @param awardInformation  获奖信息和丛书名称
     * @param publicationDate   出版日期
     * @param subscriber        订阅人
     * @param subscriberTel     联系电话
     * @param bookId            图书ID（传入不为NULL则修改）
     */
    void buyBook(String loginUserId, String executePlanId, String courseCode, String isbn, String textBookName, Boolean textBookCategory,
                 String press, String author, BigDecimal unitPrice, Integer teacherBookNumber, BigDecimal discount,
                 String awardInformation, Date publicationDate, String subscriber, String subscriberTel, String bookId);

    /**
     * 教师提交修改不买书
     *
     * @param loginUserId   登录用户ID
     * @param executePlanId 执行计划ID
     * @param courseCode    课程代码
     * @param reason        不买原因
     * @param bookId        图书ID（传入不为NULL则修改）
     */
    void notBuyBook(String loginUserId, String executePlanId, String courseCode, String reason, String bookId);

    /**
     * 根据执行计划ID获取教师购书
     *
     * @param loginUserId   用户ID
     * @param executePlanId 执行计划ID
     * @param page          页数
     * @param size          数量
     * @return 教师购书
     */
    PageInfo<BookDTO> getAllTeacherBooks(String loginUserId, String executePlanId, int page, int size);
}
