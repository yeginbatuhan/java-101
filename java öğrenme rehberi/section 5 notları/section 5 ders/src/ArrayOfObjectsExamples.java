class Student {
    int id;
    String name;
    int age;
    double grade;

    // Constructor
    public Student(int id, String name, int age, double grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Display metodu
    public void display() {
        System.out.println("ID: " + id + ", İsim: " + name +
                ", Yaş: " + age + ", Not: " + grade);
    }
}

public class ArrayOfObjectsExamples {

    /**
     * Örnek 1: Basit Object Array Oluşturma
     */
    public static void example1_BasicObjectArray() {
        System.out.println("=== ÖRNEK 1: BASİT OBJECT ARRAY ===\n");

        // Adım 1: Student türünde 3 elemanlı array oluştur
        Student[] students = new Student[3];

        System.out.println("Array oluşturuldu, boyut: " + students.length);
        System.out.println("Şu anda tüm elemanlar null: " + students[0]);

        // Adım 2: Her eleman için Student nesnesi oluştur
        students[0] = new Student(1, "Ali", 20, 85.5);
        students[1] = new Student(2, "Veli", 21, 90.0);
        students[2] = new Student(3, "Ayşe", 19, 88.5);

        System.out.println("\nNesneler oluşturuldu ve array'e atandı\n");

        // Adım 3: Array'i yazdır
        System.out.println("Öğrenci Listesi:");
        for(int i = 0; i < students.length; i++) {
            System.out.print((i+1) + ". ");
            students[i].display();
        }

        System.out.println();
    }

    /**
     * Örnek 2: Foreach ile Object Array
     */
    public static void example2_ForeachObjects() {
        System.out.println("=== ÖRNEK 2: FOREACH İLE OBJECT ARRAY ===\n");

        // Doğrudan değerlerle oluşturma
        Student[] students = {
                new Student(1, "Ali", 20, 85.5),
                new Student(2, "Veli", 21, 90.0),
                new Student(3, "Ayşe", 19, 88.5),
                new Student(4, "Mehmet", 22, 75.0),
                new Student(5, "Zeynep", 20, 92.5)
        };

        System.out.println("Toplam öğrenci sayısı: " + students.length);
        System.out.println("\nForeach ile yazdırma:\n");

        // Her öğrenci için
        for(Student student : students) {
            student.display();
        }

        System.out.println();
    }

    /**
     * Örnek 3: Object Array ile Hesaplamalar
     */
    public static void example3_CalculationsWithObjects() {
        System.out.println("=== ÖRNEK 3: HESAPLAMALAR ===\n");

        Student[] students = {
                new Student(1, "Ali", 20, 85.5),
                new Student(2, "Veli", 21, 90.0),
                new Student(3, "Ayşe", 19, 88.5),
                new Student(4, "Mehmet", 22, 75.0),
                new Student(5, "Zeynep", 20, 92.5)
        };

        // Ortalama not hesapla
        double totalGrade = 0.0;
        for(Student student : students) {
            totalGrade += student.grade;
        }
        double average = totalGrade / students.length;

        System.out.printf("Sınıf not ortalaması: %.2f\n\n", average);

        // En yüksek notu bul
        Student topStudent = students[0];
        for(Student student : students) {
            if(student.grade > topStudent.grade) {
                topStudent = student;
            }
        }

        System.out.println("En başarılı öğrenci:");
        topStudent.display();

        // Ortalamanın üzerindeki öğrenciler
        System.out.println("\nOrtalamanın üzerindeki öğrenciler:");
        for(Student student : students) {
            if(student.grade > average) {
                student.display();
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        example1_BasicObjectArray();
        // example2_ForeachObjects();
        // example3_CalculationsWithObjects();
    }
}