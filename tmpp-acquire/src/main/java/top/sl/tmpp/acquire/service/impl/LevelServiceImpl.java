package top.sl.tmpp.acquire.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.sl.tmpp.common.entity.Level;
import top.sl.tmpp.common.entity.LevelExample;
import top.sl.tmpp.common.mapper.LevelMapper;
import top.sl.tmpp.acquire.service.LevelService;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/17 10:51
 */
@Service
public class LevelServiceImpl implements LevelService {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    private final LevelMapper levelMapper;

    public LevelServiceImpl(LevelMapper levelMapper) {
        this.levelMapper = levelMapper;
    }

    @Override
    public List<Level> getAllLevel() {
        LevelExample levelExample = new LevelExample();
        levelExample.createCriteria().andIdIsNotNull();
        List<Level> levels = levelMapper.selectByExample(levelExample);
        logger.debug("查询所有层次");
        return levels;
    }
}
