package Main.Model;

import Main.Attributes.Gender;
import lombok.Getter;


@Getter
public abstract class Human {
    private String name;
    private Gender gender;
    private int age;

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name shouldn't be null");
        }
        this.name = name;
    }

    public void setGender(Gender gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender shouldn't be null");
        }
        this.gender = gender;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age must >= 0");
        }
        this.age = age;
    }

    public Human() {

    }

    public Human(String name, Gender gender, int age) {
        if (name == null) {
            throw new IllegalArgumentException("Name shouldn't be null");
        }
        if (gender == null) {
            throw new IllegalArgumentException("Gender shouldn't be null");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age must >= 0");
        }
        this.name = name;
        this.gender = gender;
        this.age = age;
    }
}