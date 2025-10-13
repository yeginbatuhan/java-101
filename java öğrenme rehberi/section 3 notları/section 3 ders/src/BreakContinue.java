public class BreakContinue {
    public static void main(String[] args) {

        // BREAK - Laravel'de break; ile aynı
        System.out.println("BREAK örneği:");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break; // Loop'u tamamen sonlandır
            }
            System.out.println(i);
        }
        // Çıktı: 1, 2, 3, 4 (5'te durur)

        System.out.println("\nCONTINUE örneği:");
        // CONTINUE - Laravel'de continue; ile aynı  
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue; // Bu iterasyonu atla, sonraki döngüye geç
            }
            System.out.println(i);
        }
        // Çıktı: 1, 2, 4, 5 (3'ü atlar)

        // NESTED LOOP'ta BREAK/CONTINUE
        System.out.println("\nNested loop'ta break:");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 2) {
                    break; // Sadece iç loop'u sonlandırır
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }
    }
}
