package top.sl.tmpp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sl.tmpp.service.DiscountsService;
import top.sl.tmpp.util.RestModel;

import java.math.BigDecimal;

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
    public RestModel saveDiscount(BigDecimal discount){
        discountsService.save(discount);
        log.debug("添加折扣成功");
        return new RestModel(201, "添加折扣成功", null);
    }
}
