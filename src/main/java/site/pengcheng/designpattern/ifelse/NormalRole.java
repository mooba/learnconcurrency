package site.pengcheng.designpattern.ifelse;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/2 11:27 上午
 */
public class NormalRole implements RoleOperation {
    private String roleName;

    public NormalRole(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String op() {
        return null;
    }
}
