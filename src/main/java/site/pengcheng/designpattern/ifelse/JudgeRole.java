package site.pengcheng.designpattern.ifelse;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/2 10:02 上午
 */
public class JudgeRole {
    
    public static void main(String[] args) {
        JudgeRole judgeRole = new JudgeRole();
        String op = judgeRole.judge1("ROLE_ROOT_ADMIN");
        System.out.println(op);
    }

    /**
     * 使用枚举
     * @param roleName
     */
    public String judge1(String roleName) {
        return RoleEnum.valueOf(roleName).op();
    }


    /**
     * @description 使用工厂模式
    */
    public String judge2(String roleName) {
        return RoleFactory.getRole(roleName).op();
    }


    public String judge3(String roleName) {
        RoleOperation roleOperation = RoleFactory.getRole(roleName);
        RoleContext roleContext = new RoleContext(roleOperation);
        return roleContext.execuote();
    }
}
