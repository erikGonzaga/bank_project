package utils;

import org.apache.commons.lang3.StringUtils;

public class numberUtil {

    public static boolean isNumber(String value) {
        return StringUtils.isNotBlank(value) && value.matches("\\d+");
    }
}
