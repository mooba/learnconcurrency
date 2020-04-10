package site.pengcheng.designpattern.refactor;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/10 5:46 下午
 */
public class BaseCustomException extends RuntimeException {
    public BaseCustomException() {
        super();
    }

    public BaseCustomException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BaseCustomException(String msg) {
        super(msg);
    }

    public BaseCustomException(Throwable cause) {
        super(cause);
    }
}
