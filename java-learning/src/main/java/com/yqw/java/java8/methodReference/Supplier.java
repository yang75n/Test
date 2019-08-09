package com.yqw.java.java8.methodReference;


/**
 * 方法引用通过方法的名字来指向一个方法。
 * <p>
 * 方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
 * <p>
 * 方法引用使用一对冒号 :: 。
 * <p>
 * 下面，我们在 Car 类中定义了 4 个方法作为例子来区分 Java 中 4 种不同方法的引用。
 *
 * @param <T>
 */

@FunctionalInterface
public interface Supplier<T> {
    T get();
}

class Car {
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
}