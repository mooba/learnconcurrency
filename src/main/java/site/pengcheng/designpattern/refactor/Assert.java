package site.pengcheng.designpattern.refactor;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/10 12:12 上午
 */

public class Assert {
    public static void assertEquals(Long expectedValue, Long actualValue) {
        if (actualValue != expectedValue) {
            String message = String.format(
                    "Test failed, expected: %d, actual: %d.", expectedValue, actualValue);
            System.out.println(message);
        } else {
            System.out.println("Test succeeded.");
        }
    }


    public static boolean assertNull(Integer actualValue) {
        boolean isNull = actualValue == null;
        if (isNull) {
            System.out.println("Test succeeded.");
        } else {
            System.out.println("Test failed, the value is not null:" + actualValue);
        }
        return isNull;
    }


    public static void assertTrue(Boolean actualValue) {
        if (actualValue == null || !actualValue) {
            System.out.println("Test failed, the value is not null:" + actualValue);
        } else {
            System.out.println("Test succeeded.");
        }
    }


    public static void assertFalse(Boolean actualValue) {
        if (actualValue == null || actualValue) {
            System.out.println("Test failed, the value is not null:" + actualValue);
        } else {
            System.out.println("Test succeeded.");
        }
    }
}




