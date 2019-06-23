package top.sl.tmpp.purchase.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.sl.tmpp.common.entity.Book;
import top.sl.tmpp.common.entity.BookStatus;
import top.sl.tmpp.common.mapper.BookMapper;
import top.sl.tmpp.common.mapper.BookStatusMapper;
import top.sl.tmpp.common.pojo.TBook;
import top.sl.tmpp.purchase.service.PurchaseService;

import java.util.Date;
import java.util.UUID;

/**
 * @author itning
 * @date 2019/6/23 15:11
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PurchaseServiceImpl implements PurchaseService {
    private final BookMapper bookMapper;
    private final BookStatusMapper bookStatusMapper;

    @Autowired
    public PurchaseServiceImpl(BookMapper bookMapper, BookStatusMapper bookStatusMapper) {
        this.bookMapper = bookMapper;
        this.bookStatusMapper = bookStatusMapper;
    }

    @Override
    public void saveBook(Book book) {
        String newId = UUID.randomUUID().toString().replace("-", "");
        book.setId(newId);
        //重置教务处购买样书
        book.setIsBuyBook("0");
        Date date = new Date();
        book.setGmtCreate(date);
        book.setGmtModified(date);

        BookStatus bookStatus = new BookStatus(newId, 0, date, date);

        bookMapper.insert(book);
        bookStatusMapper.insert(bookStatus);
    }

    @Override
    public PageInfo<TBook> getAllTeacherBooks(String loginUserId, String planId, int page, int size) {
        return PageHelper
                .startPage(page, size)
                .doSelectPageInfo(() -> bookMapper.selectTBooks(planId, loginUserId));
    }

    @Override
    public void upTeacherBook(Book book) {
        bookMapper.updateByPrimaryKeySelective(book);
    }
}
