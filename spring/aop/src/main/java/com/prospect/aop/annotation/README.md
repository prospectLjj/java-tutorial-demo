参考：https://blog.csdn.net/mu_wind/article/details/102758005

aop，关注的不是业务本身，是代码中与业务不相关，属于系统的其他范畴（如，日志，统计，权限校验等）

aop中的概念

切面：
切入点：是指明拦截的定义方式（通过execution=com.xxx.xxx.* 或者 @annotation(com.xxx.xxx.注解)）
连接点：被拦截到的点（方法，spring中只支持方法切入）。
通知：在连接点要执行的动作
    时机：前置、后置、异常、最终、环绕
目标对象：要被代理的对象（该对象中包含了连接点）
织入：将切入应用到目标，并导致代理对象创建的过程
引入：在运行期为类动态的添加一些字段或方法


## 代理方式
JDK和cglib(默认策略有AopProxyFactory根据AdvisedSupport对象的配置来决定，默认策略是如果目标对象实现接口，
    则使用JDK动态代理结束，否则使用cglib)