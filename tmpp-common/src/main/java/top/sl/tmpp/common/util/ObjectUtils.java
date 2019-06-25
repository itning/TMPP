package top.sl.tmpp.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import top.sl.tmpp.common.exception.BaseException;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author ShuLu
 * @date 2019/6/24 15:46
 */
public class ObjectUtils {
    /**
     * 检查对象中的属性不为null，String不为空
     *
     * @param t                对象
     * @param ignoreFieldsName 忽略属性
     * @param <T>              对象
     */
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

    /**
     * 检查字符串不为空
     *
     * @param str 字符串
     * @return 如果不为空返回<code>{@link Optional#empty}</code>，为空返回数组索引
     */
    public static Optional<Integer> checkStringIsNotBlank(String... str) {
        int i = 0;
        for (String s : str) {
            if (StringUtils.isBlank(s)) {
                return Optional.of(i);
            }
            i++;
        }
        return Optional.empty();
    }

    /**
     * 检查对象不为空
     *
     * @param t        对象
     * @param supplier 为空抛的异常
     * @param <T>      对象
     * @return 对象
     */
    public static <T> T checkNotNull(T t, Supplier<? extends BaseException> supplier) {
        if (t == null) {
            throw supplier.get();
        }
        return t;
    }

    /**
     * 将字符串转换为int，小数直接截取整数部分
     *
     * @param want     字符串
     * @param supplier 转换失败抛的异常
     * @return int
     */
    public static int toInt(String want, Supplier<? extends BaseException> supplier) {
        int i = want.indexOf(".");
        try {
            if (i == 1) {
                return Integer.parseInt(want);
            } else {
                return Integer.parseInt(want.substring(0, i));
            }
        } catch (NumberFormatException e) {
            throw supplier.get();
        }
    }
}
