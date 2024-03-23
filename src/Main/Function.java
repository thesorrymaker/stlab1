package Main;

public class Function {
    public final static double PI = Math.PI;

    public static double arccos(double x) {
        if (x > 1 || x < -1) {
            throw new IllegalArgumentException("The domain of arccos is [-1,1].");
        } else {
            double i = 0;
            double j = PI;
            double result = (i + j) / 2;
            double judge = Math.cos(result) - x;
            while (Math.abs(judge) > 1e-20) {
                result = (i + j) / 2;
                if (Math.cos(result) - x > 0) {
                    j = result;
                } else {
                    i = result;
                }

                judge = Math.cos(result) - x;
            }
            return result;
        }
    }
    /*public static void main (String[] args){
        double x = 0.5; // 待求解的x值
        double result = arccos(x); // 调用二分法求解反余弦函数
        System.out.println("arccos(" + x + ") = " + result);
    }*/
}
