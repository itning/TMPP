package top.sl.tmpp.review.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sl.tmpp.common.entity.Book;
import top.sl.tmpp.common.mapper.BookMapper;
import top.sl.tmpp.common.pojo.BookDTO;
import top.sl.tmpp.review.service.ReviewService;

import java.util.Date;

/**
 * @author itning
 * @date 2019/6/23 11:46
 */
@Service
public class ReviewServiceImpl implements ReviewService {
    private final BookMapper bookMapper;

    @Autowired
    public ReviewServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public PageInfo<BookDTO> getDirectorReview(String executePlanId, int page, int size) {
        return PageHelper
                .startPage(page, size)
                .doSelectPageInfo(() -> bookMapper.selectReviews(executePlanId));
    }

    @Override
    public PageInfo<BookDTO> getMyReview(String executePlanId, int page, int size) {
        return PageHelper
                .startPage(page, size)
                .doSelectPageInfo(() -> bookMapper.selectAllByExecutePlanId(executePlanId));
    }

    @Override
    public void isByBook(String id, boolean is) {
        Book book = new Book();
        book.setId(id);
        book.setIsBuyBook(is);
        book.setGmtModified(new Date());
        bookMapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public void oAllPassed(String executePlanId) {
        bookMapper.selectIdAndStatus(executePlanId)
                .stream()
                //办公室主任全部审核通过 只要没审核的
                .filter(book -> book.getStatus() == 0)
                .map(book -> {
                    Book b = new Book();
                    b.setId(book.getId());
                    b.setStatus(1);
                    b.setGmtModified(new Date());
                    return b;
                })
                .forEach(bookMapper::updateByPrimaryKeySelective);
    }

    @Override
    public void aAllPassed(String executePlanId) {
        bookMapper.selectIdAndStatus(executePlanId)
                .stream()
                //教务处全部审核通过 办公室主任审核通过的
                .filter(book -> book.getStatus() == 1)
                .map(book -> {
                    Book b = new Book();
                    b.setId(book.getId());
                    b.setStatus(2);
                    b.setGmtModified(new Date());
                    return b;
                })
                .forEach(bookMapper::updateByPrimaryKeySelective);
    }

    @Override
    public void oTurnDown(String id) {
        Book book = new Book();
        book.setId(id);
        book.setStatus(3);
        book.setGmtModified(new Date());
        bookMapper.updateByPrimaryKeySelective(book);
    }

    @Override
    public void aTurnDown(String id) {
        Book book = new Book();
        book.setId(id);
        book.setStatus(4);
        book.setGmtModified(new Date());
        bookMapper.updateByPrimaryKeySelective(book);
    }
}
