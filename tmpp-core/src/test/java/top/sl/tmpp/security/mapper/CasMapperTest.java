package top.sl.tmpp.security.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.sl.tmpp.common.entity.AdminResource;
import top.sl.tmpp.common.mapper.CasMapper;
import top.sl.tmpp.core.TMPPApplication;

import java.util.List;

/**
 * @author itning
 * @date 2019/6/29 19:29
 */
@SpringBootTest(classes = TMPPApplication.class)
@RunWith(SpringRunner.class)
public class CasMapperTest {
    @Autowired
    private CasMapper casMapper;

    @Test
    public void getResourcesByUserName() {
        List<AdminResource> list = casMapper.getResourcesByUserName("0002");
        System.out.println(list.size());
        list.forEach(System.out::println);
    }
}
