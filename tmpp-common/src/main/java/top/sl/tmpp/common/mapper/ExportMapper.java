package top.sl.tmpp.common.mapper;

import top.sl.tmpp.common.pojo.PurchasingMaterials;
import top.sl.tmpp.common.pojo.StudentReceiveBook;

import java.util.List;

/**
 * @author ShuLu
 * @date 2019/6/26 14:12
 */
public interface ExportMapper {
    /**
     * 导出采购教材汇总表
     *
     * @return PurchasingMaterials集合
     */
    List<PurchasingMaterials> getPurchasingMaterials(String executePlanId);

    String selectYear(String executePlanId);

    String selectTerm(String executePlanId);

    List<String> selectClazz(String executePlanId);

    List<StudentReceiveBook> selectStudentReceiveBooks(String clazz);
}
