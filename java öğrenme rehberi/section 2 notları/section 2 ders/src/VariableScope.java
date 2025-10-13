public class VariableScope {

    // Class level variable (Instance variable)
    private String companyName = "TechCorp";

    // Class level variable (Static variable)
    private static int employeeCount = 0;

    public static void main(String[] args) {
        // Method level variable (Local variable)
        double baseSalary = 3000.0;
        double bonus = 500.0;

        // Block level variable
        if (bonus > 0) {
            double totalSalary = baseSalary + bonus;
            System.out.println("Toplam Maaş: " + totalSalary);
            // totalSalary sadece bu blok içinde geçerli
        }

        // System.out.println(totalSalary); // HATA! Scope dışında
    }
}
