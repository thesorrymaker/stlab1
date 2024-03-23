package test;

import Main.Function;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.FunctionUtils;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class FunctionTest {
    final double EPS = 1.0e-5;
    private final Function cal = new Function();

    @DisplayName("Test for arccos")
    @ParameterizedTest
    @ValueSource(doubles = {-1,-0.95, -0.9, -0.75, -0.5,-0.4, -0.25, 0, 0.25,0.4, 0.5, 0.75,0.9, 0.95, 1})
    public void testArccos(double x){
        double actual = cal.arccos(x);
        double except = Math.acos(x);
        Assertions.assertEquals(actual, except, EPS);
    }

    @DisplayName("Test for exception")
    @ParameterizedTest
    @ValueSource(doubles = {2, -2})
    public void checkIllegalArguments(double x){
        assertThrows(IllegalArgumentException.class, ()->{cal.arccos(x);});
    }

}