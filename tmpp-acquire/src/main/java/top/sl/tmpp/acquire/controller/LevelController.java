package top.sl.tmpp.acquire.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sl.tmpp.common.entity.Level;
import top.sl.tmpp.common.util.RestModel;
import top.sl.tmpp.acquire.service.LevelService;
import top.sl.tmpp.acquire.service.impl.DepartmentServiceImpl;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/17 10:51
 */
@RestController
public class LevelController {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }
    @GetMapping("/educational_levels")
    public ResponseEntity<?> getAllLevel(){
        List<Level> levels = levelService.getAllLevel();
        logger.debug("获取所有 层次成功");
        return RestModel.ok(levels);
    }
}
