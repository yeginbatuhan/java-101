public class DataTypes {
    public static void main(String[] args) {
        // Integer Types
        byte smallNumber = 127;           // -128 to 127
        short mediumNumber = 32767;       // -32,768 to 32,767  
        int regularNumber = 2147483647;   // -2^31 to 2^31-1
        long bigNumber = 9223372036854775807L; // -2^63 to 2^63-1

        // Floating Point Types
        float decimal = 3.14f;            // 32-bit IEEE 754
        double preciseDecimal = 3.14159265359; // 64-bit IEEE 754

        // Character and Boolean
        char letter = 'A';                // Single character
        boolean isTrue = true;            // true or false

        // Display all
        System.out.println("Byte: " + smallNumber);
        System.out.println("Short: " + mediumNumber);
        System.out.println("Int: " + regularNumber);
        System.out.println("Long: " + bigNumber);
        System.out.println("Float: " + decimal);
        System.out.println("Double: " + preciseDecimal);
        System.out.println("Char: " + letter);
        System.out.println("Boolean: " + isTrue);
    }
}
