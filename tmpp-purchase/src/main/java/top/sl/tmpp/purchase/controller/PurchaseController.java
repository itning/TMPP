package top.sl.tmpp.purchase.controller;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import top.sl.tmpp.common.entity.LoginUser;
import top.sl.tmpp.common.pojo.BookDTO;
import top.sl.tmpp.common.util.RestModel;
import top.sl.tmpp.purchase.service.PurchaseService;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 购书
 *
 * @author itning
 * @date 2019/6/23 15:01
 */
@RestController
public class PurchaseController {
    private static final Logger logger = LoggerFactory.getLogger(PurchaseController.class);

    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        dateFormat.setLenient(false);
        //true:允许输入空值，false:不能为空值
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 提交购书信息
     *
     * @param loginUser         登录的用户
     * @param executePlanId     执行计划ID
     * @param isbn              书籍ISBN
     * @param isBookPurchase    该门课程是否购买数据
     * @param courseCode        课程代码
     * @param reason            不购买的原因
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
     * @return ResponseEntity
     */
    @PostMapping("/book_purchase_information")
    public ResponseEntity<?> bookPurchaseInformation(LoginUser loginUser,
                                                     @RequestParam String executePlanId,
                                                     @RequestParam Boolean isBookPurchase,
                                                     @RequestParam String courseCode,
                                                     String reason,
                                                     String isbn,
                                                     String textBookName,
                                                     Boolean textBookCategory,
                                                     String press,
                                                     String author,
                                                     BigDecimal unitPrice,
                                                     Integer teacherBookNumber,
                                                     BigDecimal discount,
                                                     String awardInformation,
                                                     Date publicationDate,
                                                     String subscriber,
                                                     String subscriberTel) {
        logger.debug("login user: {}", loginUser);
        logger.debug("is Book Purchase {}", isBookPurchase);
        if (isBookPurchase) {
            //买书
            purchaseService.buyBook(loginUser.getId(), executePlanId, courseCode, isbn, textBookName, textBookCategory, press, author, unitPrice, teacherBookNumber, discount, awardInformation, publicationDate, subscriber, subscriberTel, null);
        } else {
            purchaseService.notBuyBook(loginUser.getId(), executePlanId, courseCode, reason, null);
        }
        return RestModel.created("操作购书计划成功", null);
    }

    /**
     * 我的购书
     *
     * @param loginUser     登录的用户
     * @param executePlanId 执行计划ID
     * @param page          页码
     * @param size          数量
     * @return ResponseEntity
     */
    @GetMapping("/purchase_book/{executePlanId}")
    public ResponseEntity<?> purchaseBook(LoginUser loginUser,
                                          @PathVariable String executePlanId,
                                          @RequestParam(required = false, defaultValue = "1") int page,
                                          @RequestParam(required = false, defaultValue = "50") int size) {
        PageInfo<BookDTO> books = purchaseService.getAllTeacherBooks(loginUser.getId(), executePlanId, page, size);
        return RestModel.ok(books);
    }

    /**
     * 修改购书
     *
     * @param loginUser         登录的用户
     * @param bookId            图书ID
     * @param executePlanId     执行计划ID
     * @param isbn              书籍ISBN
     * @param isBookPurchase    该门课程是否购买数据
     * @param courseCode        课程代码
     * @param reason            不购买的原因
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
     * @return ResponseEntity
     */
    @PatchMapping("/purchase")
    public ResponseEntity<?> purchase(LoginUser loginUser,
                                      @RequestParam String executePlanId,
                                      @RequestParam Boolean isBookPurchase,
                                      @RequestParam String courseCode,
                                      @RequestParam String bookId,
                                      String reason,
                                      String isbn,
                                      String textBookName,
                                      Boolean textBookCategory,
                                      String press,
                                      String author,
                                      BigDecimal unitPrice,
                                      Integer teacherBookNumber,
                                      BigDecimal discount,
                                      String awardInformation,
                                      Date publicationDate,
                                      String subscriber,
                                      String subscriberTel) {
        logger.debug("login user: {}", loginUser);
        logger.debug("is Book Purchase {}", isBookPurchase);
        if (isBookPurchase) {
            //买书
            purchaseService.buyBook(loginUser.getId(), executePlanId, courseCode, isbn, textBookName, textBookCategory, press, author, unitPrice, teacherBookNumber, discount, awardInformation, publicationDate, subscriber, subscriberTel, bookId);
        } else {
            purchaseService.notBuyBook(loginUser.getId(), executePlanId, courseCode, reason, bookId);
        }
        return RestModel.noContent();
    }
}
