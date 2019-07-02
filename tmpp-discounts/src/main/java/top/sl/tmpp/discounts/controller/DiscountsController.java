package top.sl.tmpp.discounts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.sl.tmpp.common.entity.Discounts;
import top.sl.tmpp.common.entity.LoginUser;
import top.sl.tmpp.common.util.RestModel;
import top.sl.tmpp.discounts.service.DiscountsService;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ShuLu
 */
@RestController
public class DiscountsController {
    private static final Logger logger = LoggerFactory.getLogger(DiscountsController.class);

    private final DiscountsService discountsService;

    @Autowired
    public DiscountsController(DiscountsService discountsService) {
        this.discountsService = discountsService;
    }

    /**
     * 添加折扣
     *
     * @param discount 折扣数量
     * @return {@link ResponseEntity} {@link RestModel}
     */
    @PostMapping("/discount")
    public ResponseEntity<?> saveDiscount(@RequestParam("discount") BigDecimal discount, LoginUser loginUser) {
        discountsService.save(discount);
        logger.debug("添加折扣成功");
        return RestModel.created("添加折扣成功", null);
    }

    /**
     * 获取所有折扣信息
     *
     * @return {@link ResponseEntity} {@link RestModel}
     */
    @GetMapping("/discounts")
    public ResponseEntity<?> getAllDiscount(LoginUser loginUser) {
        List<Discounts> discounts = discountsService.getAllDiscount();
        logger.debug("查找所有折扣成功");
        return RestModel.ok(discounts);
    }

    /**
     * 删除折扣信息
     *
     * @param id 折扣ID
     * @return {@link ResponseEntity} {@link RestModel}
     */
    @DeleteMapping("/discount")
    public ResponseEntity<?> remove(@RequestParam("id") String id, LoginUser loginUser) {
        discountsService.remove(id);
        logger.debug("删除成功");
        return RestModel.noContent();
    }

    /**
     * 修改折扣
     *
     * @param id       折扣ID
     * @param discount 折扣数
     * @return {@link ResponseEntity} {@link RestModel}
     */
    @PatchMapping("/discount")
    public ResponseEntity<?> modify(@RequestParam("id") String id, @RequestParam("discount") BigDecimal discount, LoginUser loginUser) {
        discountsService.modify(id, discount);
        logger.debug("修改折扣成功");
        return RestModel.noContent();
    }
}
