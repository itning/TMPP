package top.sl.tmpp.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sl.tmpp.common.entity.Book;
import top.sl.tmpp.common.entity.LoginUser;
import top.sl.tmpp.common.exception.EmptyParameterException;
import top.sl.tmpp.common.exception.IdNotFoundException;
import top.sl.tmpp.common.exception.PermissionException;
import top.sl.tmpp.common.mapper.BookMapper;
import top.sl.tmpp.common.pojo.TBook;
import top.sl.tmpp.common.util.ObjectUtils;
import top.sl.tmpp.purchase.service.PurchaseService;

import java.util.Date;
import java.util.UUID;

/**
 * @author itning
 * @date 2019/6/23 15:11
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final BookMapper bookMapper;

    @Autowired
    public PurchaseServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public void saveBook(Book book) {
        book.setId(UUID.randomUUID().toString().replace("-", ""));
        //重置教务处购买样书
        book.setIsBuyBook(false);
        book.setStatus(0);
        Date date = new Date();
        book.setGmtCreate(date);
        book.setGmtModified(date);
        if (book.getIsBookPurchase() == null) {
            throw new EmptyParameterException("是否购买为空");
        }
        if (book.getIsBookPurchase()) {
            //教师买书
            ObjectUtils.checkObjectFieldsNotEmpty(book, "reason");
        } else {
            //教师不买
            if (StringUtils.isAnyBlank(book.getReason(), book.getCourseId(), book.getLoginUserId())) {
                throw new EmptyParameterException("原因为空");
            }
        }
        bookMapper.insert(book);
    }


    @Override
    public PageInfo<TBook> getAllTeacherBooks(String loginUserId, String executePlanId, int page, int size) {
        return PageHelper
                .startPage(page, size)
                .doSelectPageInfo(() -> bookMapper.selectMyBook(loginUserId, executePlanId));
    }

    @Override
    public void upTeacherBook(Book book, LoginUser loginUser) {
        if (book.getIsBookPurchase() == null) {
            throw new EmptyParameterException("是否购买为空");
        }
        if (!book.getIsBookPurchase()) {
            //教师不买
            if (StringUtils.isAnyBlank(book.getReason(), book.getCourseId(), book.getLoginUserId())) {
                throw new EmptyParameterException("原因为空");
            }
        }
        Book b = bookMapper.selectByPrimaryKey(book.getId());
        if (b == null) {
            throw new IdNotFoundException(book.getId());
        } else {
            if (!loginUser.getId().equals(b.getLoginUserId())) {
                throw new PermissionException();
            }
        }
        bookMapper.updateByPrimaryKeySelective(book);
    }
}
