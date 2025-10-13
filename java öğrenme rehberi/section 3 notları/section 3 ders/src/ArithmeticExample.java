public class ArithmeticExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        System.out.println("Toplama: " + (a + b));      // 13
        System.out.println("Çıkarma: " + (a - b));      // 7
        System.out.println("Çarpma: " + (a * b));       // 30
        System.out.println("Bölme: " + (a / b));        // 3 (int bölme)
        System.out.println("Mod: " + (a % b));          // 1

        double c = 10.0;
        double d = 3.0;
        System.out.println("Double bölme: " + (c / d)); // 3.3333...
    }
}
