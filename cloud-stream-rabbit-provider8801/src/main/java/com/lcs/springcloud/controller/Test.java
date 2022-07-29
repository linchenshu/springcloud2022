package com.lcs.springcloud.controller;

/**
 * @author linchenshu
 * @date 2022/7/20 9:59
 **/
public class Test {
    private static int age = 18;
    private static String name = "zhangsan";
    int ge;

    static String getInfo(){
        return name +":" +age;
    }

    String getInfo2(){
        return this.name +":" +this.age;
    }

    public static void main(String[] args) {
        System.out.println(getInfo());
        System.out.println(new Test().getInfo2());
    }

    public Test() {
    }

    public Test(int ge) {
        this.ge = ge;
    }
}


