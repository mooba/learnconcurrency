package site.pengcheng.designpattern.factory.di;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengchengbai
 * @description
 * @date 2020/4/25 5:02 下午
 */
public class BeanDefinition {
    private String id;
    private String className;
    private boolean lazyInit = false;
    private List<ConstructorArg> constructorArgs = new ArrayList<>();
    private ScopeEnum scope = ScopeEnum.SINGLETON;

    public BeanDefinition(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public boolean isSingleton() { return scope.equals(ScopeEnum.SINGLETON); }


    public String getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public List<ConstructorArg> getConstructorArgs() {
        return constructorArgs;
    }

    public ScopeEnum getScope() {
        return scope;
    }
}
