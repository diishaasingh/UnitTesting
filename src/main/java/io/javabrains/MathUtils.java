package io.javabrains;

public class MathUtils {
    private Adder adder;

    public MathUtils(Adder adder) {
        this.adder = adder;
    }
    public MathUtils() {
 
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        int result = 0;
        for (int i = 0; i < b; i++) {
            result += adder.add(result, a);
        }
        return result;
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public double computeCircleArea(double radius) {
        return Math.PI * radius * radius;
    }
}
