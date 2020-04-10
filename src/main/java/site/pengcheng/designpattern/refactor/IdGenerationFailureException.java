package site.pengcheng.designpattern.refactor;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/10 5:45 下午
 */
public class IdGenerationFailureException extends BaseCustomException {

    public IdGenerationFailureException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
