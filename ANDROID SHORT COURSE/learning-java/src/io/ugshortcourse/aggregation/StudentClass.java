package io.ugshortcourse.aggregation;

/**
 * For example consider two classes Student class and Address class. Every student has an address so the relationship
 * between student and address is a Has-A relationship. But if you consider its vice versa then it would not make any
 * sense as an Address does not need to have a Student necessarily. Lets write this example in a java program.
 * <p>
 * <p>
 * Student Has-A Address
 * <p>
 * The example shows the Aggregation between Student and Address classes.
 * You can see that in Student class I have declared a property of type Address to obtain student address.
 * Its a typical example of Aggregation in Java.
 */
public class StudentClass {
    int rollNum;
    String studentName;
    //Creating HAS-A relationship with Address class
    Address studentAddr;

    StudentClass(int roll, String name, Address addr) {
        this.rollNum = roll;
        this.studentName = name;
        this.studentAddr = addr;
    }

    public static void main(String args[]) {
        Address ad = new Address(55, "Agra", "UP", "India");
        StudentClass obj = new StudentClass(123, "Chaitanya", ad);
        System.out.println(obj.rollNum);
        System.out.println(obj.studentName);
        System.out.println(obj.studentAddr.streetNum);
        System.out.println(obj.studentAddr.city);
        System.out.println(obj.studentAddr.state);
        System.out.println(obj.studentAddr.country);
    }
}