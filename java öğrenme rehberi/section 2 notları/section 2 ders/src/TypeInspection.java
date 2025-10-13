public class TypeInspection {
    public static void main(String[] args) {
        // Primitive değişkenler
        int age = 25;
        double salary = 5000.50;
        boolean isActive = true;
        char grade = 'A';

        // Adım adım açıklama:

        // Adım 1: Primitive int'i Object'e cast et
        Object ageAsObject = (Object) age;  // Boxing: int → Integer → Object

        // Adım 2: Object'in gerçek sınıfını al
        Class<?> ageClass = ageAsObject.getClass();

        // Adım 3: Sınıf adının sadece basit kısmını al
        String ageClassName = ageClass.getSimpleName();

        System.out.println("age değişkeninin tipi: " + ageClassName);

        // Tek satırda yapılan işlem:
        System.out.println("salary tipi: " + ((Object)salary).getClass().getSimpleName());
        System.out.println("isActive tipi: " + ((Object)isActive).getClass().getSimpleName());
        System.out.println("grade tipi: " + ((Object)grade).getClass().getSimpleName());

        // Autoboxing açıklaması
        System.out.println("\n=== AUTOBOXING AÇIKLAMASI ===");

        // Manuel boxing
        Integer ageBoxed = Integer.valueOf(age);  // int → Integer
        System.out.println("Manuel boxing: " + ageBoxed.getClass().getSimpleName());

        // Automatic boxing (Java otomatik yapar)
        Object ageAutoBoxed = age;  // Java otomatik olarak Integer'a çevirir
        System.out.println("Auto boxing: " + ageAutoBoxed.getClass().getSimpleName());

        // Neden Object'e cast ediyoruz?
        // Çünkü primitive'ler direkt .getClass() method'una sahip değil
        // System.out.println(age.getClass()); // HATA! primitive'ler method'a sahip değil

        // Reference types için cast gerekmez
        String name = "Ali";
        System.out.println("String tipi: " + name.getClass().getSimpleName());

        // Array için örnek
        int[] numbers = {1, 2, 3};
        System.out.println("Array tipi: " + numbers.getClass().getSimpleName());
    }
}
