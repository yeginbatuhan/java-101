public class LoopExample {
    public static void main(String[] args) {
        // Klasik for loop
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration: " + i);
        }

        // Array ile for loop
        String[] fruits = {"apple", "banana", "orange"};
        for (int i = 0; i < fruits.length; i++) {
            System.out.println(fruits[i]);
        }

        // Enhanced for loop (foreach)
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }
    }
}
