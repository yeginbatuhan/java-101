public class ConversionBestPractices {
    public static void main(String[] args) {
        // Güvenli dönüşüm kontrolü
        String userInput = "123abc";

        try {
            int number = Integer.parseInt(userInput);
            System.out.println("Geçerli sayı: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Geçersiz sayı formatı: " + userInput);
        }

        // Overflow kontrolü
        long bigNumber = 2147483648L;  // int max değerinden büyük

        if (bigNumber <= Integer.MAX_VALUE && bigNumber >= Integer.MIN_VALUE) {
            int safeInt = (int) bigNumber;
            System.out.println("Güvenli dönüşüm: " + safeInt);
        } else {
            System.out.println("Sayı int aralığının dışında: " + bigNumber);
        }
    }
}
