package io.github.zhangzheace;

public aspect LogAspect{
    pointcut logPointcut()
        :execution(* io.github.zhangzheace.*.*(..));
    after():logPointcut()
    {
        System.out.println("模拟记录日志...");
    }
}
