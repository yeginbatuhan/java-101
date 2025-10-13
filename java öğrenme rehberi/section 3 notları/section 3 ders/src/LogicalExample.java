public class LogicalExample {
    public static void main(String[] args) {
        boolean isAdmin = true;
        boolean isActive = true;
        int age = 25;

        // AND operatörü
        if (isAdmin && isActive) {
            System.out.println("Admin ve aktif kullanıcı");
        }

        // OR operatörü  
        if (age > 18 || isAdmin) {
            System.out.println("Erişim izni var");
        }

        // NOT operatörü
        if (!isActive) {
            System.out.println("Kullanıcı pasif");
        }

        // Karmaşık mantık
        if ((age >= 18 && isActive) || isAdmin) {
            System.out.println("Sistem erişimi onaylandı");
        }
    }
}
