package io.ugshortcourse.static_objects;

/**
 * Implementation of static variables and methods
 * As you can see that both the static variables were initialized before we accessed them in the main method.
 * <p>
 * OUTPUT
 * ob1 integer:99
 * ob1 String:I'm Object1
 * ob2 integer:99
 * ob2 STring:I'm Object2
 */
public class JavaExample {
    //Static integer variable
    static int var1 = 77;
    //non-static string variable
    String var2;

    private static String str = "BeginnersBook";

    //Static class
    static class MyNestedClass{
        //non-static method
        public void disp() {

            /* If you make the str variable of outer class
             * non-static then you will get compilation error
             * because: a nested static class cannot access non-
             * static members of the outer class.
             */
            System.out.println(str);
        }

    }

    public static void main(String args[]) {
        JavaExample ob1 = new JavaExample();
        JavaExample ob2 = new JavaExample();
        /* static variables can be accessed directly without
         * any instances. Just to demonstrate that static variables
         * are shared, I am accessing them using objects so that
         * we can check that the changes made to static variables
         * by one object, reflects when we access them using other
         * objects
         */
        //Assigning the value to static variable using object ob1
        ob1.var1 = 88;
        ob1.var2 = "I'm Object1";
        /* This will overwrite the value of var1 because var1 has a single
         * copy shared among both the objects.
         */
        ob2.var1 = 99;
        ob2.var2 = "I'm Object2";
        System.out.println("ob1 integer:" + ob1.var1);
        System.out.println("ob1 String:" + ob1.var2);
        System.out.println("ob2 integer:" + ob2.var1);
        System.out.println("ob2 String:" + ob2.var2);

        /* To create instance of nested class we didn't need the outer
         * class instance but for a regular nested class you would need
         * to create an instance of outer class first
         */
        JavaExample.MyNestedClass obj = new JavaExample.MyNestedClass();
        obj.disp();
    }
}
