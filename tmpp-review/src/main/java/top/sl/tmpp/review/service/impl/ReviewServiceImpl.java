package top.sl.tmpp.review.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.sl.tmpp.common.entity.Book;
import top.sl.tmpp.common.entity.ExecutePlan;
import top.sl.tmpp.common.exception.IdNotFoundException;
import top.sl.tmpp.common.exception.IllegalParameterException;
import top.sl.tmpp.common.mapper.BookMapper;
import top.sl.tmpp.common.mapper.ExecutePlanMapper;
import top.sl.tmpp.common.mapper.PlanMapper;
import top.sl.tmpp.common.pojo.BookDTO;
import top.sl.tmpp.review.service.ReviewService;

import java.util.Date;
import java.util.Objects;

/**
 * @author itning
 * @date 2019/6/23 11:46
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ReviewServiceImpl implements ReviewService {
    private final BookMapper bookMapper;
    private final PlanMapper planMapper;
    private final ExecutePlanMapper executePlanMapper;

    @Autowired
    public ReviewServiceImpl(BookMapper bookMapper, PlanMapper planMapper, ExecutePlanMapper executePlanMapper) {
        this.bookMapper = bookMapper;
        this.planMapper = planMapper;
        this.executePlanMapper = executePlanMapper;
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
        Book b = bookMapper.selectByPrimaryKey(id);
        if (b == null) {
            throw new IdNotFoundException(id);
        }
        if (!b.getIsBookPurchase()) {
            throw new IllegalParameterException("教师未购书，教务处无法购买样书");
        }
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
        //获取null的数量
        long count = planMapper.selectAllByExecutePlanGroupByBookId(executePlanId).stream().filter(Objects::isNull).count();
        if (count == 0L) {
            long l = bookMapper.countByExecutePlanAndStatusNot2(executePlanId);
            if (l == 0L) {
                //全是教务处审核通过
                ExecutePlan executePlan = new ExecutePlan();
                executePlan.setId(executePlanId);
                executePlan.setStatus(true);
                executePlan.setGmtModified(new Date());
                executePlanMapper.updateByPrimaryKeySelective(executePlan);
            }
        }
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
