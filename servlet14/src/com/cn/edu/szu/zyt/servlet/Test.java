package com.cn.edu.szu.zyt.servlet;

public class Test {
    public static void main(String[] args) {
        System.out.println("main begin");
        m1();
        System.out.println("main end");
    }
    private  static void m1(){
        System.out.println("m1 begin");
        m2();
        System.out.println("m1 end");
    }
    private  static void m2(){
        System.out.println("m2 begin");
        m3();
        System.out.println("m2 end");
    }
    private  static void m3(){
        System.out.println("loading");
    }
}
