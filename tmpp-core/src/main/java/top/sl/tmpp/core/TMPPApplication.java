package top.sl.tmpp.core;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ShuLu
 */
@SpringBootApplication(scanBasePackages = "top.sl.tmpp")
@MapperScan("top.sl.tmpp.common.mapper")
public class TMPPApplication {
    private static final Logger logger = LoggerFactory.getLogger(TMPPApplication.class);

    public static void main(String[] args) {
        logger.info("MYSQL::url: {}", System.getenv("MYSQL_URL"));
        logger.info("MYSQL::username: {}", System.getenv("MYSQL_USERNAME"));
        logger.info("MYSQL::password: {}", System.getenv("MYSQL_PASSWORD"));
        SpringApplication.run(TMPPApplication.class, args);
    }
}
