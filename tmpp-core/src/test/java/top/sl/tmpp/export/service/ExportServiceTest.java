package top.sl.tmpp.export.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.sl.tmpp.core.TMPPApplication;

/**
 * @author ShuLu
 * @date 2019/6/26 14:32
 */
@SpringBootTest(classes = TMPPApplication.class)
@RunWith(SpringRunner.class)
public class ExportServiceTest {
    @Autowired
    private ExportService exportService;
    @Test
    public void procurementTable(){
        //exportService.procurementTable("ccf4c148bcef4d7592b34ca0a3bcd586");
    }
    @Test
    public void studentClassBookTable()  {
        //exportService.studentClassBookTable("ccf4c148bcef4d7592b34ca0a3bcd586");
    }
}
