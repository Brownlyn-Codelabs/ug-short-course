package io.ugshortcourse.constructors;

public class MyConstructorExample {

    public static void main(String[] args) {
        //The compiler creates a default constructor for classes which do not define their own constructors
        MyConstructorExample example = new MyConstructorExample();
        System.out.println(example);
    }
}
