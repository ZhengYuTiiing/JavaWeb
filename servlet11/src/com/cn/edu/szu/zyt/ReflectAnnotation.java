package com.cn.edu.szu.zyt;

import jakarta.servlet.annotation.WebServlet;

public class ReflectAnnotation {
    //这个给想拿到HelloServlet这个类的注解
    public static void main(String[] args) throws ClassNotFoundException {
        //使用反射机制
        Class<?> welcomeSwrvletClass = Class.forName("com.cn.edu.szu.zyt.HelloServlet");

        //先判断类上有没有该注解
        boolean annotationPresent = welcomeSwrvletClass.isAnnotationPresent(WebServlet.class);
        System.out.println(annotationPresent);
        if(annotationPresent){
            //获取注解对象
            WebServlet annotation = welcomeSwrvletClass.getAnnotation(WebServlet.class);
            //获取注解对象的属性值
            String[] value = annotation.value();
            for (int i = 0; i < value.length; i++) {
                System.out.println(value[i]);
            }
        }
    }
}
