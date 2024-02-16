package com.cn.edu.szu.zyt;

/**
 * • 模板类通常是一个抽象类
 *
 */
public abstract class Person {
    /**
     * 模板方法当中定义核心算法骨架, 方法通常是final的（但也可以不是final的）
     */
    public final void Day(){
        qichuang();
        xishu();
        chizaofan();
        dosome();
        chiwanfan();
        shuijiao();

    }
    public void qichuang(){System.out.println("起床");}
    public void xishu(){System.out.println("洗漱");}
    public void chizaofan(){System.out.println("吃早饭");}
    //• 抽象方法就是不确定实现的方法，这个不确定怎么实现的事儿交给子类去做。
    public abstract void dosome();
    public void chiwanfan(){System.out.println("吃晚饭呢");}
    public void shuijiao(){System.out.println("睡觉");}
}
