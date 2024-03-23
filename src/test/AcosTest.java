package test;

import Main.Acos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class AcosTest {
    final double EPS = 1.0E-5;
    private final Acos cal = new Acos();

    public AcosTest() {
    }

    @DisplayName("Test for arccos")
    @ParameterizedTest
    @ValueSource(doubles = {-1.0, -0.95, -0.9, -0.75, -0.5, -0.4, -0.25, 0.0, 0.25, 0.4, 0.5, 0.75, 0.9, 0.95, 1.0})
    public void testArccos(double x) {
        double actual = cal.acos(x);
        double except = Math.acos(x);
        Assertions.assertEquals(actual, except, EPS);
    }

    @DisplayName("Test for exception")
    @ParameterizedTest
    @ValueSource(doubles = {2.0, -2.0})
    public void checkIllegalArguments(double x) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cal.acos(x);
        });
    }
}