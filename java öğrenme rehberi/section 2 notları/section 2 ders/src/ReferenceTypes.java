public class ReferenceTypes {
    public static void main(String[] args) {
        // String (Reference type)
        String message = "Merhaba Dünya";

        // Arrays (Reference type)
        int[] numbers = {1, 2, 3, 4, 5};

        // Objects (Reference type)
        String anotherMessage = new String("Java Öğreniyorum");

        System.out.println("Mesaj: " + message);
        System.out.println("İlk sayı: " + numbers[0]);
        System.out.println("Diğer mesaj: " + anotherMessage);
    }
}
