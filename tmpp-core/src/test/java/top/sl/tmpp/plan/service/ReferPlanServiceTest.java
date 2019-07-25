package top.sl.tmpp.plan.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.sl.tmpp.core.TMPPApplication;

/**
 * @author ShuLu
 * @date 2019/6/17 12:18
 */
@SpringBootTest(classes = TMPPApplication.class)
@RunWith(SpringRunner.class)
public class ReferPlanServiceTest {
    @Autowired
    private ReferPlanService referPlanService;

    @Test
    public void referPlan() {
        referPlanService.referPlan("2017-2018", false, "1", "1", "执行计划模板.xlsx");
    }

    @Test
    public void downloadExecutePlan() {
    }

    @Test
    public void removeExecutePlan() {
        referPlanService.removeExecutePlan("f6f495bdfa644609ab9a33a6c6ce66e8");
    }

}
