public class Literals {
    public static void main(String[] args) {
        // Integer Literals
        int decimal = 42;           // Decimal
        int binary = 0b101010;      // Binary (42)
        int octal = 052;           // Octal (42)
        int hex = 0x2A;             // Hexadecimal (42)

        // Floating Literals
        double scientific = 1.23e2;  // 123.0 (Scientific notation)
        float floatNum = 3.14f;      // Float literal (f suffix)

        // Character Literals
        char letter = 'A';           // Single quotes
        char unicode = '\u0041';     // Unicode (A)
        char escape = '\n';          // Escape sequence

        // String Literals
        String text = "Java String"; // Double quotes

        // Boolean Literals
        boolean isTrue = true;
        boolean isFalse = false;

        System.out.println("Decimal: " + decimal);
        System.out.println("Binary: " + binary);
        System.out.println("Hex: " + hex);
        System.out.println("Scientific: " + scientific);
    }
}