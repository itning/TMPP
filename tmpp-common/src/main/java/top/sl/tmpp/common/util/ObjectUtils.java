package top.sl.tmpp.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import top.sl.tmpp.common.exception.BaseException;

import java.lang.reflect.Field;

/**
 * @author ShuLu
 * @date 2019/6/24 15:46
 */
public class ObjectUtils {
    public static <T> void checkObjectFieldsNotEmpty(T t, String... ignoreFieldsName) {
        try {
            Field[] fields = t.getClass().getDeclaredFields();
            a:
            for (Field field : fields) {
                for (String ignore : ignoreFieldsName) {
                    if (ignore.equals(field.getName())) {
                        continue a;
                    }
                }
                field.setAccessible(true);
                Object o = field.get(t);
                if (null == o) {
                    throw new BaseException(field.getName() + " 为空", HttpStatus.BAD_REQUEST) {
                    };
                } else if (o instanceof CharSequence) {
                    if (StringUtils.isBlank((CharSequence) o)) {
                        throw new BaseException(field.getName() + " 为空", HttpStatus.BAD_REQUEST) {
                        };
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new BaseException(e.getMessage(), HttpStatus.BAD_REQUEST) {
            };
        }
    }
}
