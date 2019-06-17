package top.sl.tmpp.acquire.service;

import top.sl.tmpp.common.entity.Level;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/17 10:51
 */
public interface LevelService {
    /**
     * 获取所有层次
     * @return
     */
    List<Level> getAllLevel();
}
