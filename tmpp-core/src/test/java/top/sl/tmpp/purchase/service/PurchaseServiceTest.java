package top.sl.tmpp.purchase.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.sl.tmpp.common.entity.Book;
import top.sl.tmpp.core.TMPPApplication;

@SpringBootTest(classes = TMPPApplication.class)
@RunWith(SpringRunner.class)
public class PurchaseServiceTest {
    @Autowired
    private PurchaseService purchaseService;

    @org.junit.Test
    public void saveBook() {
        Book book = new Book();
//        book.setIsbn("9787547240502");
//        book.setTextBookName("逻辑思维训练大脑提高记忆力学习力书籍");
//        book.setTextBookCategory(false);
//        book.setPress("吉林文史出版社");
//        book.setAuthor("好多人");
//        book.setUnitPrice(new BigDecimal("39.80"));
//        book.setTeacherBookNumber(2);
//        book.setDiscountId("1");
//        book.setAwardInformation("什么什么");
//        book.setPublicationDate(new Date());
//        book.setSubscriber("订阅");
//        book.setSubscriberTel("17645458836");
        book.setIsBookPurchase(false);
        book.setReason("不想买");
        book.setLoginUserId("0002");
        book.setCourseId("1");
        purchaseService.saveBook("", book);
    }

    @org.junit.Test
    public void getAllTeacherBooks() {

    }

    @org.junit.Test
    public void upTeacherBook() {
    }
}