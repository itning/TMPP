package top.sl.tmpp.purchase.controller;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.sl.tmpp.common.entity.Book;
import top.sl.tmpp.common.entity.LoginUser;
import top.sl.tmpp.common.pojo.TBook;
import top.sl.tmpp.common.util.RestModel;
import top.sl.tmpp.purchase.service.PurchaseService;

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

    /**
     * 提交购书信息
     *
     * @param loginUser 登录的用户
     * @param book      购书信息
     * @return ResponseEntity
     */
    @PostMapping("/book_purchase_information")
    public ResponseEntity<?> bookPurchaseInformation(LoginUser loginUser, Book book) {
        logger.debug("login user: {}", loginUser);
        logger.debug("save book info: {}", book);
        book.setLoginUserId(loginUser.getId());
        purchaseService.saveBook(book);
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
        PageInfo<TBook> books = purchaseService.getAllTeacherBooks(loginUser.getId(), executePlanId, page, size);
        return RestModel.ok(books);
    }

    /**
     * 修改购书
     *
     * @param loginUser 登录的用户
     * @param book      修改的图书
     * @return ResponseEntity
     */
    @PatchMapping("/purchase")
    public ResponseEntity<?> purchase(LoginUser loginUser, Book book) {
        purchaseService.upTeacherBook(book, loginUser);
        return RestModel.noContent();
    }
}
