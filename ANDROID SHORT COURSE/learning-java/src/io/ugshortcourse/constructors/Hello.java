package io.ugshortcourse.constructors;

public class Hello {
    String name;

    //No-Arg constructor
    Hello() {
        this.name = "UG Short Course for Android";
    }

    public static void main(String[] args) {

        //how does a constructor work?
        Hello obj = new Hello();
        System.out.println(obj.name);
    }
}
