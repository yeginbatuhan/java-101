public class LoopOptimization {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        // 1. INDEX'e ihtiyaç varsa - klasik for loop kullan
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + ": " + numbers[i]);
        }

        // 2. Sadece elemanları dolaşacaksan - enhanced for loop
        for (int number : numbers) {
            System.out.println("Number: " + number);
        }

        // 3. Koşul kontrollü döngü - while loop
        int count = 0;
        while (count < 3) {
            System.out.println("Count: " + count);
            count++;
        }

        // 4. En az bir kez çalışması gereken - do-while
        int input;
        do {
            input = 5; // Simulated user input
            System.out.println("Input: " + input);
        } while (input < 1 || input > 10);
    }
}
