package top.sl.tmpp.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

/**
 * @author ShuLu
 */
@SpringBootApplication(scanBasePackages = "top.sl.tmpp")
@MapperScan("top.sl.tmpp.mapper")
public class TMPPApplication {
    public static void main(String[] args) {
        SpringApplication.run(TMPPApplication.class, args);
    }
}
