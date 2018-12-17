package com.test.classLoader;

class Grandpa {
    static {
        System.out.println("爷爷在静态代码块");
    }

    {
        System.out.println("爷爷在普通代码块");
    }

    public Grandpa() {
        System.out.println("我是爷爷~");
    }
}

class Father extends Grandpa {
    static {
        System.out.println("爸爸在静态代码块");
    }

    {
        System.out.println("爸爸在普通代码块");
    }


    public static int factor = 25;


    public Father() {
        System.out.println("我是爸爸~");
    }
}

class Son extends Father {
    static {
        System.out.println("儿子在静态代码块");
    }

    {
        System.out.println("儿子在普通代码块");
    }

    // public static int factor = 25;

    public Son() {
        System.out.println("我是儿子~");
    }
}

public class InitializationDemo {
    static {
        System.out.println("Demo在静态代码块");
    }

    {
        System.out.println("Demo在普通代码块");
    }

    public InitializationDemo() {
        System.out.println("我是Demo~");
    }

    public static void main(String[] args) {
        System.out.println("爸爸的岁数:" + new Son().factor); //入口

        //   System.out.println("爸爸的岁数2:" + new Son().factor);

        System.out.println("爸爸的岁数3：" + Son.factor);

    }

}