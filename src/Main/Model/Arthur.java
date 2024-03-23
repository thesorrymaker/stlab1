package Main.Model;

import Main.Attributes.Behavior;
import Main.Attributes.Gender;
import lombok.Getter;

import java.util.ArrayList;

public class Arthur extends Human {

    @Getter
    private static ArrayList<Behavior> behaviors = new ArrayList<>();

    public Arthur() {
        super();
    }

    public Arthur(String name, Gender gender, int age) {
        super(name, gender, age);
    }


    public static void setBehaviors(ArrayList<Behavior> behaviors) {
        Arthur.behaviors = behaviors;
    }


    public void learn(Behavior b) {
        if (b == null) {
            throw new IllegalArgumentException("Behavior can't be null");
        }
        Arthur.behaviors.add(b);
    }

}