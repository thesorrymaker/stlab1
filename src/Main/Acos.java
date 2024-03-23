package Main;

public class Acos {
    public static double acos(double x) {
        if (x > 1 || x < -1) {
            throw new IllegalArgumentException("The domain of arcsin is [-1,1].");
        }
        double numerator = 1;
        double denominator = 2;

        double e = 1;
        double n = 2;
        double arccos = Math.PI / 2 - x;
        if (x == 1) {
            arccos = 0;
        } else if (x == -1) {
            arccos = Math.PI;
        } else {
            while (Math.abs(e) > 0.00000001) {
                e = (numerator * Math.pow(x, 2 * n - 1)) / (denominator * (2 * n - 1));
                numerator = numerator * (2 * n - 1);
                denominator = denominator * 2 * n;
                arccos = arccos - e;
                n++;

            }
        }
        return arccos;
    }
}