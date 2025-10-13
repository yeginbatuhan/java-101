public class ControlFlowExample {
    public static void main(String[] args) {
        int score = 85;
        String userRole = "admin";

        // Basit if-else (Laravel'deki gibi)
        if (score >= 90) {
            System.out.println("A+ aldınız");
        } else if (score >= 80) {
            System.out.println("A aldınız");
        } else if (score >= 70) {
            System.out.println("B aldınız");
        } else {
            System.out.println("Geçemediniz");
        }

        // String karşılaştırma (Laravel'den farklı!)
        if (userRole.equals("admin")) {  // == değil, .equals() kullan!
            System.out.println("Admin paneline hoş geldiniz");
        }

        // Ternary operator
        String message = (score >= 60) ? "Geçti" : "Kaldı";
        System.out.println(message);
    }
}
