package top.sl.tmpp.review.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sl.tmpp.common.entity.Book;
import top.sl.tmpp.common.entity.BookStatus;
import top.sl.tmpp.common.mapper.BookMapper;
import top.sl.tmpp.common.mapper.BookStatusMapper;
import top.sl.tmpp.common.pojo.AReview;
import top.sl.tmpp.common.pojo.OReview;
import top.sl.tmpp.review.service.ReviewService;

import java.util.Date;

/**
 * @author itning
 * @date 2019/6/23 11:46
 */
@Service
public class ReviewServiceImpl implements ReviewService {
    private final BookMapper bookMapper;
    private final BookStatusMapper bookStatusMapper;

    @Autowired
    public ReviewServiceImpl(BookMapper bookMapper, BookStatusMapper bookStatusMapper) {
        this.bookMapper = bookMapper;
        this.bookStatusMapper = bookStatusMapper;
    }

    @Override
    public PageInfo<OReview> getOReviews(String planId, int page, int size) {
        return PageHelper
                .startPage(page, size)
                .doSelectPageInfo(() -> bookMapper.selectOReviews(planId));
    }

    @Override
    public PageInfo<AReview> getAReviews(String planId, int page, int size) {
        return PageHelper
                .startPage(page, size)
                .doSelectPageInfo(() -> bookMapper.selectAReviews(planId));
    }

    @Override
    public void isByBook(String id, String is) {
        Book book = new Book();
        book.setId(id);
        book.setIsBuyBook(is);
        book.setGmtModified(new Date());
        bookMapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public void oAllPassed(String planId) {
        bookMapper.selectStatusAndIdOReview(planId)
                .stream()
                //只要没审核的
                .filter(oReview -> oReview.getStatus() == 0)
                .map(oReview -> {
                    BookStatus bookStatus = new BookStatus();
                    bookStatus.setId(oReview.getId());
                    bookStatus.setStatus(1);
                    bookStatus.setGmtModified(new Date());
                    return bookStatus;
                })
                .forEach(bookStatusMapper::updateByPrimaryKeySelective);
    }

    @Override
    public void aAllPassed(String planId) {
        bookMapper.selectStatusAndIdOReview(planId)
                .stream()
                //只要没审核的
                .filter(oReview -> oReview.getStatus() == 0)
                .map(oReview -> {
                    BookStatus bookStatus = new BookStatus();
                    bookStatus.setId(oReview.getId());
                    bookStatus.setStatus(2);
                    bookStatus.setGmtModified(new Date());
                    return bookStatus;
                })
                .forEach(bookStatusMapper::updateByPrimaryKeySelective);
    }

    @Override
    public void oTurnDown(String id) {
        BookStatus bookStatus = new BookStatus();
        bookStatus.setId(id);
        bookStatus.setStatus(3);
        bookStatus.setGmtModified(new Date());
        bookStatusMapper.updateByPrimaryKeySelective(bookStatus);
    }

    @Override
    public void aTurnDown(String id) {
        BookStatus bookStatus = new BookStatus();
        bookStatus.setId(id);
        bookStatus.setStatus(4);
        bookStatus.setGmtModified(new Date());
        bookStatusMapper.updateByPrimaryKeySelective(bookStatus);
    }
}
