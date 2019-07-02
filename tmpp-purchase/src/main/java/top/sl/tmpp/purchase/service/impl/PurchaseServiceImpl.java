package top.sl.tmpp.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sl.tmpp.common.entity.Book;
import top.sl.tmpp.common.entity.Plan;
import top.sl.tmpp.common.entity.PlanBook;
import top.sl.tmpp.common.exception.EmptyParameterException;
import top.sl.tmpp.common.mapper.BookMapper;
import top.sl.tmpp.common.mapper.PlanBookMapper;
import top.sl.tmpp.common.mapper.PlanMapper;
import top.sl.tmpp.common.pojo.BookDTO;
import top.sl.tmpp.common.util.ObjectUtils;
import top.sl.tmpp.purchase.service.PurchaseService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * @author itning
 * @date 2019/6/23 15:11
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final BookMapper bookMapper;
    private final PlanMapper planMapper;
    private final PlanBookMapper planBookMapper;

    @Autowired
    public PurchaseServiceImpl(BookMapper bookMapper, PlanMapper planMapper, PlanBookMapper planBookMapper) {
        this.bookMapper = bookMapper;
        this.planMapper = planMapper;
        this.planBookMapper = planBookMapper;
    }

    @Override
    public void buyBook(String loginUserId, String executePlanId, String courseCode, String isbn, String textBookName, Boolean textBookCategory,
                        String press, String author, BigDecimal unitPrice, Integer teacherBookNumber, BigDecimal discount,
                        String awardInformation, Date publicationDate, String subscriber, String subscriberTel, String bookId) {
        checkTel(subscriberTel);
        Book book = new Book();
        book.setId(bookId);
        book.setIsbn(isbn);
        book.setTextBookName(textBookName);
        book.setTextBookCategory(textBookCategory);
        book.setPress(press);
        book.setAuthor(author);
        book.setUnitPrice(unitPrice);
        book.setTeacherBookNumber(teacherBookNumber);
        book.setDiscount(discount);
        book.setAwardInformation(awardInformation);
        book.setPublicationDate(publicationDate);
        book.setSubscriber(subscriber);
        book.setSubscriberTel(subscriberTel);
        book.setIsBookPurchase(true);
        book.setLoginUserId(loginUserId);
        book.setExecutePlanId(executePlanId);
        book.setStatus(0);
        //教务处购买样书默认false
        book.setIsBuyBook(false);
        Date date = new Date();
        book.setGmtModified(date);
        book.setGmtCreate(date);
        if (bookId == null) {
            //新增图书
            book.setId(UUID.randomUUID().toString().replace("-", ""));
            ObjectUtils.checkObjectFieldsNotEmpty(book, "reason", "isBuyBook");
            saveBookInfo(executePlanId, courseCode, book.getId(), book);
        } else {
            //修改图书
            ObjectUtils.checkObjectFieldsNotEmpty(book, "reason", "isBuyBook");
            bookMapper.updateByPrimaryKey(book);
        }

    }

    /**
     * 检查电话号码正确性
     *
     * @param tel 电话号
     */
    private void checkTel(String tel) {
        long telLong = NumberUtils.toLong(tel);
        if (telLong == 0L) {
            throw new EmptyParameterException("手机号不正确");
        }
        if (tel.length() != 11) {
            throw new EmptyParameterException("手机号长度不正确，输入了" + tel.length() + "位");
        }
        if (!tel.startsWith("1")) {
            throw new EmptyParameterException("手机号不正确");
        }
    }

    @Override
    public void notBuyBook(String loginUserId, String executePlanId, String courseCode, String reason, String bookId) {
        if (StringUtils.isAnyBlank(reason, courseCode, executePlanId)) {
            throw new EmptyParameterException("原因或课程代码或执行计划ID为空");
        }
        Book book = new Book();
        book.setId(bookId);
        book.setIsBookPurchase(false);
        book.setReason(reason);
        book.setLoginUserId(loginUserId);
        book.setExecutePlanId(executePlanId);
        //0: 未审核
        book.setStatus(0);
        //教务处购买样书默认false
        book.setIsBuyBook(false);
        Date date = new Date();
        book.setGmtModified(date);
        book.setGmtCreate(date);
        if (bookId == null) {
            book.setId(UUID.randomUUID().toString().replace("-", ""));
            saveBookInfo(executePlanId, courseCode, book.getId(), book);
        } else {
            bookMapper.updateByPrimaryKey(book);
        }
    }

    /**
     * 新增图书
     *
     * @param executePlanId 执行计划ID
     * @param courseCode    课程代码
     * @param newBookId     图书ID
     * @param book          {@link Book}
     */
    private void saveBookInfo(String executePlanId, String courseCode, String newBookId, Book book) {
        bookMapper.insertSelective(book);
        planMapper.selectByExecutePlanIdAndCourseCode(executePlanId, courseCode)
                .stream()
                .map(Plan::getId)
                .forEach(planId -> planBookMapper.insert(new PlanBook(planId, newBookId)));
    }


    @Override
    public PageInfo<BookDTO> getAllTeacherBooks(String loginUserId, String executePlanId, int page, int size) {
        return PageHelper
                .startPage(page, size)
                .doSelectPageInfo(() -> bookMapper.selectMyBook(loginUserId, executePlanId));
    }
}
