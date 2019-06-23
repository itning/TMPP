package top.sl.tmpp.review.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.sl.tmpp.common.mapper.BookMapper;
import top.sl.tmpp.common.mapper.BookStatusMapper;
import top.sl.tmpp.common.pojo.OReview;
import top.sl.tmpp.review.service.ReviewService;

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
}
