package io.ugshortcourse.static_objects;

/**
 * Implementation of static methods
 */
public class SimpleStaticExample {
    // This is a static method
    static void myMethod()
    {
        System.out.println("myMethod");
    }

    public static void main(String[] args)
    {
        /* You can see that we are calling this
         * method without creating any object.
         */
        myMethod();
    }
}
