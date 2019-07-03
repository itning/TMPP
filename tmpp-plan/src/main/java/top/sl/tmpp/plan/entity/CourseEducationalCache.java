package top.sl.tmpp.plan.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import top.sl.tmpp.plan.exception.ApiException;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author itning
 * @date 2019/7/3 8:55
 */
public class CourseEducationalCache {
    private static final Logger logger = LoggerFactory.getLogger(CourseEducationalCache.class);
    private static Map<String, String> courseMap;
    private static RestTemplate restTemplate;

    static {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        //ms
        factory.setReadTimeout(5000);
        //ms
        factory.setConnectTimeout(5000);
        restTemplate = new RestTemplate(factory);
        refreshCourseMap();
    }

    public static void refreshCourseMap() {
        ResponseEntity<CourseEducational> responseEntity = restTemplate.getForEntity("http://www.greathiit.com/api/getCourseEducational", CourseEducational.class);
        CourseEducational body = responseEntity.getBody();
        if (body == null || body.getResult() == null) {
            throw new ApiException("API获取课程信息失败");
        }
        courseMap = body.getResult().parallelStream().collect(Collectors.toMap(CourseEducational.ResultBean::getCursNum, CourseEducational.ResultBean::getCursName));
        logger.debug("course map size: {}", courseMap.size());
    }

    public static Optional<String> getCourseName(String courseCode) {
        return Optional.ofNullable(courseMap.get(courseCode));
    }
}
