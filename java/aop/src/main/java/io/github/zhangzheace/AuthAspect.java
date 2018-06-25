package io.github.zhangzheace;

public aspect AuthAspect{
    before():execution(* io.github.zhangzheace.*.*(..))
    {
        System.out.println("模拟进行权限检查...");
    }
}
