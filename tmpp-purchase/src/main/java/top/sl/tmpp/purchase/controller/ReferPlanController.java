package top.sl.tmpp.purchase.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sl.tmpp.common.util.RestModel;
import top.sl.tmpp.purchase.service.ReferPlanService;
import top.sl.tmpp.purchase.util.FileUtil;

/**
 * @author ShuLu
 * @date 2019/6/17 13:46
 */
@RestController
public class ReferPlanController {
    private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
    private final ReferPlanService referPlanService;

    public ReferPlanController(ReferPlanService referPlanService) {
        this.referPlanService = referPlanService;
    }

    @PostMapping("/plan")
    public ResponseEntity<?> plan(String fileId) {
        referPlanService.referPlan("1", 1, "1", "1", fileId);
        return RestModel.ok(null);
    }
}
