package top.sl.tmpp.export.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.sl.tmpp.common.mapper.ExportMapper;
import top.sl.tmpp.core.TMPPApplication;

/**
 * @author ShuLu
 * @date 2019/6/29 16:19
 */
@SpringBootTest(classes = TMPPApplication.class)
@RunWith(SpringRunner.class)
public class ExportMapperTest {
    @Autowired
    private ExportMapper exportMapper;

    @Test
    public void selectBookMaterials() {
        exportMapper.selectBookMaterials("2017-2018", null, null, false);
    }
}
