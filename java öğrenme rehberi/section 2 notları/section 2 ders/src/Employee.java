public class Employee {
    // Instance variable (Non-static) - Her object için ayrı kopya
    private String name;
    private int age;

    // Static variable (Class variable) - Tüm sınıf için tek kopya
    private static int totalEmployeeCount = 0;
    private static String companyName = "TechCorp";

    // Constructor
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
        totalEmployeeCount++; // Her yeni çalışan oluşturulduğunda artar
    }

    // Instance method
    public void displayInfo() {
        System.out.println("Çalışan: " + name + ", Yaş: " + age);
        System.out.println("Şirket: " + companyName);
        System.out.println("Toplam Çalışan: " + totalEmployeeCount);
    }

    // Static method - sadece static değişkenlere erişebilir
    public static void displayCompanyInfo() {
        System.out.println("Şirket Adı: " + companyName);
        System.out.println("Toplam Çalışan Sayısı: " + totalEmployeeCount);
        // System.out.println(name); // HATA! Static method'dan instance variable'a erişemez
    }

    public static void main(String[] args) {
        // Static değişkene sınıf adıyla erişim
        System.out.println("Başlangıç çalışan sayısı: " + Employee.totalEmployeeCount);

        // Employee objeleri oluştur
        Employee emp1 = new Employee("Ali", 25);
        Employee emp2 = new Employee("Ayşe", 30);
        Employee emp3 = new Employee("Mehmet", 28);

        // Her object için ayrı instance variables
        emp1.displayInfo();
        System.out.println("---");
        emp2.displayInfo();
        System.out.println("---");
        emp3.displayInfo();

        System.out.println("\n=== STATIC METHOD ÇAĞRISI ===");
        // Static method'u sınıf adıyla çağır
        Employee.displayCompanyInfo();
    }
}
