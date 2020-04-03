package site.pengcheng.designpattern.ifelse;

/**
 * @author pengchengbai
 * @description 按照策略模式的指导思想，需要创建一个所谓的策略上下文类
 * @date 2020/4/2 11:36 上午
 */
public class RoleContext {
    private RoleOperation roleOperation;

    public RoleContext(RoleOperation roleOperation) {
        this.roleOperation = roleOperation;
    }

    /**
     * 把具体的的操作代理给不同的策略
     * @return
     */
    public String execuote() {
        return roleOperation.op();
    }
}
