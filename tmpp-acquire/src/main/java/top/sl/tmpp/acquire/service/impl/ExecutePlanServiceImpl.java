package top.sl.tmpp.acquire.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.sl.tmpp.acquire.service.ExecutePlanService;
import top.sl.tmpp.common.entity.ExecutePlan;
import top.sl.tmpp.common.mapper.ExecutePlanMapper;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/22 17:01
 */
@Service
public class ExecutePlanServiceImpl implements ExecutePlanService {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

    private final ExecutePlanMapper executePlanMapper;

    public ExecutePlanServiceImpl(ExecutePlanMapper executePlanMapper) {
        this.executePlanMapper = executePlanMapper;
    }

    @Override
    public List<ExecutePlan> getAllExecutePlan() {
        return null;
    }
}
