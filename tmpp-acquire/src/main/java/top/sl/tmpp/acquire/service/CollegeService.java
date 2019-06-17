package top.sl.tmpp.acquire.service;

import top.sl.tmpp.common.entity.Colleges;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/17 11:08
 */
public interface CollegeService {
    /**
     * 获取所有学院
     * @return colleges
     */
    List<Colleges> getAllCollege();
}
