package top.sl.tmpp.acquire.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.sl.tmpp.common.entity.Colleges;
import top.sl.tmpp.acquire.service.CollegeService;
import top.sl.tmpp.acquire.service.impl.DepartmentServiceImpl;
import top.sl.tmpp.common.util.RestModel;

import java.util.List;


/**
 * @author ShuLu
 * @date 2019/6/17 11:08
 */
@RestController
public class CollegeController {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    private final CollegeService collegeService;

    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }
    @GetMapping("/colleges")
    public ResponseEntity<?> getAllCollege(){
        List<Colleges> colleges = collegeService.getAllCollege();
        logger.debug("查询所有学院成功");
        return RestModel.ok(colleges);
    }
}
