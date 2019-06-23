package top.sl.tmpp.review.controller;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.sl.tmpp.common.pojo.AReview;
import top.sl.tmpp.common.pojo.OReview;
import top.sl.tmpp.common.util.RestModel;
import top.sl.tmpp.review.service.ReviewService;

/**
 * 审核
 *
 * @author itning
 * @date 2019/6/23 11:14
 */
@RestController
public class ReviewController {
    private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * 办公室主任全部审核通过
     *
     * @param planId 执行计划id
     * @return ResponseEntity
     */
    @PostMapping("/all_passed")
    public ResponseEntity<?> allPassed(@RequestParam String planId) {
        reviewService.oAllPassed(planId);
        return RestModel.created("办公室主任全部审核通过", null);
    }

    /**
     * 教务处全部审核通过
     *
     * @param planId 执行计划id
     * @return ResponseEntity
     */
    @PostMapping("/examination_passed")
    public ResponseEntity<?> examinationPassed(@RequestParam String planId) {
        reviewService.aAllPassed(planId);
        return RestModel.created("全部审核通过", null);
    }

    /**
     * 教务处驳回
     *
     * @param id 购书计划id
     * @return ResponseEntity
     */
    @PostMapping("/turn_down")
    public ResponseEntity<?> turnDown(@RequestParam String id) {
        reviewService.aTurnDown(id);
        return RestModel.created("驳回操作成功", null);
    }

    /**
     * 办公室主任驳回
     *
     * @param id 购书计划id
     * @return ResponseEntity
     */
    @PostMapping("/office_turn_down")
    public ResponseEntity<?> officeTurnDown(@RequestParam String id) {
        reviewService.oTurnDown(id);
        return RestModel.created("驳回操作成功", null);
    }

    /**
     * 教务处是否购买样书
     *
     * @param id        购书计划id
     * @param isBuyBook 是否购买样书（是：1，否：0）
     * @return ResponseEntity
     */
    @PostMapping("/buy_sample_book")
    public ResponseEntity<?> buySampleBook(@RequestParam String id, @RequestParam String isBuyBook) {
        reviewService.isByBook(id, isBuyBook);
        return RestModel.created("操作成功", null);
    }

    /**
     * 教务处我的审核
     *
     * @param planId 执行计划id
     * @param page   页码
     * @param size   数量
     * @return ResponseEntity
     */
    @GetMapping("/my_review")
    public ResponseEntity<?> myReview(@RequestParam String planId,
                                   @RequestParam(required = false, defaultValue = "1") int page,
                                   @RequestParam(required = false, defaultValue = "50") int size) {
        logger.debug("my_review params: {} {} {}", planId, page, size);
        PageInfo<AReview> oReviews = reviewService.getAReviews(planId, page, size);
        return RestModel.ok(oReviews);
    }

    /**
     * 办公室主任我的审核
     *
     * @param planId 执行计划id
     * @param page   页码
     * @param size   数量
     * @return ResponseEntity
     */
    @GetMapping("/director_review")
    public ResponseEntity<?> directorReview(@RequestParam String planId,
                                         @RequestParam(required = false, defaultValue = "1") int page,
                                         @RequestParam(required = false, defaultValue = "50") int size) {
        logger.debug("director_review params: {} {} {}", planId, page, size);
        PageInfo<OReview> oReviews = reviewService.getOReviews(planId, page, size);
        return RestModel.ok(oReviews);
    }
}
