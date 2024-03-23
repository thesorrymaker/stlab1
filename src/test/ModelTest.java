package test;

import Main.Attributes.Behavior;
import Main.Attributes.Gender;
import Main.Model.Arthur;
import Main.Model.elder;
import org.junit.jupiter.api.*;

public class ModelTest {
    @BeforeEach
    void init() {
        Arthur h1 = new Arthur("Peter", Gender.MALE, 28);
        Arthur h2 = new Arthur("Tom", Gender.MALE, 19);
        Arthur h3 = new Arthur("Alice", Gender.FEMALE, 23);

        elder d1 = new elder("Doll", Gender.FEMALE, 8);
        elder d2 = new elder("Fill", Gender.MALE, 10);
        elder d3 = new elder("Lili", Gender.FEMALE, 12);


        Behavior play = new Behavior("Play");
        Behavior swim = new Behavior("Swim");
        Behavior jump = new Behavior("Jump");


        d1.learn(play);
        d2.learn(swim);
        d3.learn(jump);
    }

    @Nested
    class ClassTest {
        @Test
        @DisplayName("Test for constructor")
        void testConstructor() {
            System.out.println("Testing constructor of Arthur");
            Exception e1 = Assertions.assertThrows(IllegalArgumentException.class, () -> new Arthur(null, Gender.NONE, 1));
            Assertions.assertEquals("Name shouldn't be null", e1.getMessage());

            Exception e2 = Assertions.assertThrows(IllegalArgumentException.class, () -> new Arthur("TestName", null, 1));
            Assertions.assertEquals("Gender shouldn't be null", e2.getMessage());

            Exception e3 = Assertions.assertThrows(IllegalArgumentException.class, () -> new Arthur("TestName", Gender.NONE, -1));
            Assertions.assertEquals("Age must >= 0", e3.getMessage());
            System.out.println("Test done");
            System.out.println();

            System.out.println("Testing constructor of elder");
            Exception e4 = Assertions.assertThrows(IllegalArgumentException.class, () -> new elder(null, Gender.NONE, 1));
            Assertions.assertEquals("Name shouldn't be null", e4.getMessage());

            Exception e5 = Assertions.assertThrows(IllegalArgumentException.class, () -> new elder("TestName", null, 1));
            Assertions.assertEquals("Gender shouldn't be null", e5.getMessage());

            Exception e6 = Assertions.assertThrows(IllegalArgumentException.class, () -> new elder("TestName", Gender.NONE, -1));
            Assertions.assertEquals("Age must >= 0", e6.getMessage());
            System.out.println("Test done");
            System.out.println();

            System.out.println();

            System.out.println("Testing constructor of Behavior");
            Exception e8 = Assertions.assertThrows(IllegalArgumentException.class, () -> new Behavior(null));
            Assertions.assertEquals("Name shouldn't be null", e8.getMessage());

            System.out.println("Test done");
            System.out.println();
        }

        @Test
        @DisplayName("Test for setter")
        void testSetter() {
            System.out.println("Testing setter of Arthur");

            Arthur h = new Arthur();

            Exception e1 = Assertions.assertThrows(IllegalArgumentException.class, () -> h.setName(null));
            Assertions.assertEquals("Name shouldn't be null", e1.getMessage());

            Exception e2 = Assertions.assertThrows(IllegalArgumentException.class, () -> h.setGender(null));
            Assertions.assertEquals("Gender shouldn't be null", e2.getMessage());

            Exception e3 = Assertions.assertThrows(IllegalArgumentException.class, () -> h.setAge(-1));
            Assertions.assertEquals("Age must >= 0", e3.getMessage());

            System.out.println("Test done");
            System.out.println();
            System.out.println("Testing setter of elder");

            elder d = new elder();

            Exception e4 = Assertions.assertThrows(IllegalArgumentException.class, () -> d.setName(null));
            Assertions.assertEquals("Name shouldn't be null", e4.getMessage());

            Exception e5 = Assertions.assertThrows(IllegalArgumentException.class, () -> d.setGender(null));
            Assertions.assertEquals("Gender shouldn't be null", e5.getMessage());

            Exception e6 = Assertions.assertThrows(IllegalArgumentException.class, () -> d.setAge(-1));
            Assertions.assertEquals("Age must >= 0", e6.getMessage());

            System.out.println("Test done");
            System.out.println();

            System.out.println();
            System.out.println("Testing setter of Behavior");

            Behavior b = new Behavior();
            Exception e9 = Assertions.assertThrows(IllegalArgumentException.class, () -> b.setName(null));
            Assertions.assertEquals("Name shouldn't be null", e9.getMessage());

            System.out.println("Test done");
            System.out.println();
        }
    }

    @Nested
    class FunctionTest {

        @Test
        @DisplayName("Test for learn()")
        void testLearn() {
            System.out.println("Testing learn() of Arthur");

            Arthur h = new Arthur("TestArthur", Gender.NONE, 18);
            Exception e1 = Assertions.assertThrows(IllegalArgumentException.class, () -> h.learn(null));
            Assertions.assertEquals("Behavior can't be null", e1.getMessage());

            System.out.println("Test done");
            System.out.println();

            System.out.println("Testing learn() of Arthur");

            elder d = new elder("Testelder", Gender.NONE, 18);
            Exception e2 = Assertions.assertThrows(IllegalArgumentException.class, () -> d.learn(null));
            Assertions.assertEquals("Behavior can't be null", e2.getMessage());

            System.out.println("Test done");
            System.out.println();
        }
    }


}