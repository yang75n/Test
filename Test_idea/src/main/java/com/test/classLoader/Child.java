package com.test.classLoader;

public class Child extends Father1 {

    static {
        System.out.println("child-->static");
    }

    private int n = 20;

    {
        System.out.println("Child Non-Static");
        n = 30;
    }

    public int x = 200;//father里面也有一个x

    public Child() {
        this("The other constructor");
        System.out.println("child constructor body: " + n);
    }

    public Child(String s) {
        System.out.println(s);
    }

    public void age() {
        System.out.println("age=" + n);
    }

    public void printX() {
        System.out.println("x=" + x);
    }

    public static void main(String[] args) {
        new Child().printX();
    }
}

class Father1 {

    static {
        //System.out.println("n+"+n);
        //当n定义在下面时，会提示Cannot reference a field before it is defined，
        //所以必须把n定义移到上面才可以输出
        System.out.println("super-->static");
    }

    public static int n = 10;
    public int x = 100;

    public Father1() {
        System.out.println("super's x=" + x);
        age();
    }

    {
        System.out.println("Father Non-Static");
    }

    public void age() {
        System.out.println("nothing");
    }
}