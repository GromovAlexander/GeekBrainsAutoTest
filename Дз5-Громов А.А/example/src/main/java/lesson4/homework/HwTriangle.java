package lesson4.homework;

public class HwTriangle {

    public boolean triangleArea(int a, int b, int c) {
        double p = (a + b + c) / 2f;
        double s = p * (p - a) * (p - b) * (p - c);
        double ploshad = Math.sqrt(s);
        if (a <= 0) {
            return false;
        }
        if (b <= 0) {
            return false;
        }
        if (c <= 0) {
            return false;
        }
        if (ploshad > 0) {
            return true;
        } else return false;
    }
}
