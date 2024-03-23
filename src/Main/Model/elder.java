package Main.Model;

import Main.Attributes.Behavior;
import Main.Attributes.Gender;
import lombok.Getter;

import java.util.ArrayList;

public class elder extends Human {

    @Getter
    private static ArrayList<Behavior> behaviors = new ArrayList<>();

    public elder() {
        super();
    }

    public elder(String name, Gender gender, int age) {
        super(name, gender, age);
    }


    public static void setBehaviors(ArrayList<Behavior> behaviors) {
        elder.behaviors = behaviors;
    }


    public void learn(Behavior b) {
        if (b == null) {
            throw new IllegalArgumentException("Behavior can't be null");
        }
        elder.behaviors.add(b);
    }

}