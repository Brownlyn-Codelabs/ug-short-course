package io.ugshortcourse.classes_and_inheritance;

/**
 * {@link Goat} is a type of {@link Animal}
 * Therefore it is a sub-class
 */
public class Goat extends Animal {

    @Override
    public boolean canBreath() {
        return true;
    }

    @Override
    public boolean canWalk() {
        return true;
    }

}
