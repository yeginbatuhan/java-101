public class TypeConversion {
    public static void main(String[] args) {
        // Implicit Conversion (Widening)
        byte byteValue = 42;
        int intValue = byteValue;        // byte → int (otomatik)
        double doubleValue = intValue;   // int → double (otomatik)

        System.out.println("Byte: " + byteValue);
        System.out.println("Int: " + intValue);
        System.out.println("Double: " + doubleValue);

        // Explicit Conversion (Narrowing) - CASTING
        double largeNumber = 123.789;
        int intNumber = (int) largeNumber;  // double → int (manuel)
        byte byteNumber = (byte) intNumber; // int → byte (manuel)

        System.out.println("Büyük sayı: " + largeNumber);
        System.out.println("Int'e cast: " + intNumber);      // 123 (ondalık kısmı kesilir)
        System.out.println("Byte'a cast: " + byteNumber);     // 123

        // String Conversions
        String numberString = "123";
        int parsedInt = Integer.parseInt(numberString);
        double parsedDouble = Double.parseDouble("123.45");

        System.out.println("String'den int: " + parsedInt);
        System.out.println("String'den double: " + parsedDouble);

        // Int to String
        int number = 456;
        String stringNumber = String.valueOf(number);
        String anotherWay = Integer.toString(number);

        System.out.println("Int'den String: " + stringNumber);
        System.out.println("Başka yol: " + anotherWay);
    }
}
