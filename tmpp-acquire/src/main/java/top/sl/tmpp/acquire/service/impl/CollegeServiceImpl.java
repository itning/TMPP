package top.sl.tmpp.acquire.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.sl.tmpp.common.entity.Colleges;
import top.sl.tmpp.common.entity.CollegesExample;
import top.sl.tmpp.common.mapper.CollegesMapper;
import top.sl.tmpp.acquire.service.CollegeService;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/17 11:08
 */
@Service
public class CollegeServiceImpl implements CollegeService {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    private final CollegesMapper collegesMapper;

    public CollegeServiceImpl(CollegesMapper collegesMapper) {
        this.collegesMapper = collegesMapper;
    }

    @Override
    public List<Colleges> getAllCollege() {
        CollegesExample collegesExample = new CollegesExample();
        collegesExample.createCriteria().andIdIsNotNull();
        List<Colleges> colleges = collegesMapper.selectByExample(collegesExample);
        logger.debug("获取所有学院");
        return colleges;
    }
}
