public class WhileExample {
    public static void main(String[] args) {
        // While loop
        int count = 0;
        while (count < 3) {
            System.out.println("Count: " + count);
            count++;
        }

        // Do-while loop (en az bir kez çalışır)
        int number = 10;
        do {
            System.out.println("Number: " + number);
            number--;
        } while (number > 5);
    }
}
