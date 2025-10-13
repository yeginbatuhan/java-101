public class EmployeeSystem {
    public static void main(String[] args) {
        // Employee data
        String firstName = "Ahmet";
        String lastName = "Yılmaz";
        int age = 28;
        double baseSalary = 4000.0;
        boolean isFullTime = true;
        char department = 'I'; // IT department

        // Calculations
        double bonus = isFullTime ? baseSalary * 0.1 : 0;
        double totalSalary = baseSalary + bonus;
        String fullName = firstName + " " + lastName;

        // Type conversions for display
        String ageText = "Yaş: " + String.valueOf(age);
        String salaryText = "Maaş: " + String.valueOf(totalSalary) + " TL";

        // Display employee info
        System.out.println("=== ÇALIŞAN BİLGİ SİSTEMİ ===");
        System.out.println("Ad Soyad: " + fullName);
        System.out.println(ageText);
        System.out.println("Departman: " + department + " (IT)");
        System.out.println("Tam Zamanlı: " + (isFullTime ? "Evet" : "Hayır"));
        System.out.println("Temel Maaş: " + baseSalary + " TL");
        System.out.println("Bonus: " + bonus + " TL");
        System.out.println(salaryText);

        // Variable types demonstration
        System.out.println("\n=== VERİ TİPLERİ ===");
        System.out.println("firstName tipi: " + ((Object)firstName).getClass().getSimpleName());
        System.out.println("age tipi: " + ((Object)age).getClass().getSimpleName());
        System.out.println("baseSalary tipi: " + ((Object)baseSalary).getClass().getSimpleName());
        System.out.println("isFullTime tipi: " + ((Object)isFullTime).getClass().getSimpleName());
    }
}
