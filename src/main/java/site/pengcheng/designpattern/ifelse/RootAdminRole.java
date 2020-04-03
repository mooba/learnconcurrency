package site.pengcheng.designpattern.ifelse;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/2 11:25 上午
 */
public class RootAdminRole implements RoleOperation {
    private String roleName;

    public RootAdminRole(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String op() {
        return roleName + " has AAA permission";
    }
}
