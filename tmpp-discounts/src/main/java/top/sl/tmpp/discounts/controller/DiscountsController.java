package top.sl.tmpp.discounts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import top.sl.tmpp.discounts.service.DiscountsService;
import top.sl.tmpp.common.entity.Discounts;
import top.sl.tmpp.common.util.RestModel;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author 11578
 */
@RestController
public class DiscountsController {
    private final DiscountsService discountsService;
    private Logger log = LoggerFactory.getLogger(DiscountsController.class);

    public DiscountsController(DiscountsService discountsService) {
        this.discountsService = discountsService;
    }

    @PostMapping("/discount")
    public RestModel saveDiscount(BigDecimal discount) {
        discountsService.save(discount);
        log.debug("添加折扣成功");
        return new RestModel(201, "添加折扣成功");
    }

    @GetMapping("/discounts")
    public RestModel<List<Discounts>> getAllDiscount() {
        List<Discounts> discounts = discountsService.getAllDiscount();
        log.debug("查找所有折扣成功");
        return new RestModel<>(200, "查询成功", discounts);
    }

    @DeleteMapping("/discount")
    public RestModel remove(String id) {
        discountsService.remove(id);
        log.debug("删除成功");
        return new RestModel(204,"删除折扣成功");
    }
    @PatchMapping("/discount")
    public RestModel modify(String id,BigDecimal discount){
        discountsService.modify(id,discount);
        log.debug("修改折扣成功");
        return new RestModel(204,"修改折扣成功");
    }
}
