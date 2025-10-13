public class NumberGuessGame {
    public static void main(String[] args) {
        int targetNumber = 7; // Simulated random number
        int guess = 0;
        int attempts = 0;
        int maxAttempts = 3;

        // Laravel'de while($attempts < $maxAttempts) gibi
        while (attempts < maxAttempts) {
            attempts++;

            // Simulated user input (gerçekte Scanner kullanırdık)
            guess = (attempts == 1) ? 5 : (attempts == 2) ? 8 : 7;

            System.out.println("Tahmin " + attempts + ": " + guess);

            if (guess == targetNumber) {
                System.out.println("Tebrikler! " + attempts + " denemede buldunuz!");
                break; // Oyunu sonlandır
            } else if (guess < targetNumber) {
                System.out.println("Daha yüksek bir sayı deneyin!");
            } else {
                System.out.println("Daha düşük bir sayı deneyin!");
            }

            if (attempts == maxAttempts) {
                System.out.println("Oyun bitti! Doğru sayı: " + targetNumber);
            }
        }
    }
}
