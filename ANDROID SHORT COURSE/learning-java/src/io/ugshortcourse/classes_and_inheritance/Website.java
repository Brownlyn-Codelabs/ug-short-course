package io.ugshortcourse.classes_and_inheritance;

public class Website {
    String webName;
    int webAge;

    //Parameterized Constructor
    Website(String webName, int webAge) {
        this.webName = webName;
        this.webAge = webAge;
    }

    //No-Arg Constructor
    Website() {
        this.webName = "DefaultWebName";
        this.webAge = 4;
    }

    public static void main(String[] args) {
        //Creating objects
        Website obj1 = new Website("ugshortcourse", 5);
        Website obj2 = new Website("google", 18);
        Website obj3 = new Website();

        //Accessing object data through reference
        System.out.println(obj1.webName + " " + obj1.webAge);
        System.out.println(obj2.webName + " " + obj2.webAge);
        System.out.println(obj3.webName + " " + obj3.webAge);
    }

}
