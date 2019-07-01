package top.sl.tmpp.review.service;

import com.github.pagehelper.PageInfo;
import top.sl.tmpp.common.entity.Book;
import top.sl.tmpp.common.pojo.BookDTO;


/**
 * @author itning
 * @date 2019/6/23 11:35
 */
public interface ReviewService {
    /**
     * 办公室主任我的审核
     *
     * @param executePlanId 执行计划id
     * @param page          页数
     * @param size          每页大小
     * @return {@link PageInfo}
     */
    PageInfo<BookDTO> getDirectorReview(String executePlanId, int page, int size);

    /**
     * 教务处我的审核
     *
     * @param executePlanId 执行计划id
     * @param page          页数
     * @param size          每页大小
     * @return {@link PageInfo}
     */
    PageInfo<Book> getMyReview(String executePlanId, int page, int size);

    /**
     * 教务处是否购买样书
     *
     * @param id 购书计划id
     * @param is 是1 否0
     */
    void isByBook(String id, boolean is);

    /**
     * 办公室主任全部审核通过
     *
     * @param executePlanId 执行计划ID
     */
    void oAllPassed(String executePlanId);

    /**
     * 教务处全部审核通过
     *
     * @param executePlanId 执行计划ID
     */
    void aAllPassed(String executePlanId);

    /**
     * 办公室主任驳回
     *
     * @param id 购书计划id
     */
    void oTurnDown(String id);

    /**
     * 教务处驳回
     *
     * @param id 购书计划id
     */
    void aTurnDown(String id);
}
