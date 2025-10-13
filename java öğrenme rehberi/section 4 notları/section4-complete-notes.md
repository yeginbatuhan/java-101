# SECTION 4: Object-Oriented Programming Basics - TAM DERS NOTU

## İçindekiler
1. [Class ve Object Kavramları](#1-class-ve-object-kavramlari)
2. [JDK, JRE, JVM Mimarisi](#2-jdk-jre-jvm-mimarisi)
3. [Methods (Metodlar)](#3-methods-metodlar)
4. [Method Overloading](#4-method-overloading)
5. [Stack ve Heap Memory - Detaylı](#5-stack-ve-heap-memory-detayli)
6. [Mülakat Soruları](#6-mulakat-sorulari)
7. [Pratik Örnekler](#7-pratik-ornekler)

---

## 1. Class ve Object Kavramları

### 1.1 Temel Tanımlar

**Class (Sınıf):** Nesneler için blueprint/şablon. Laravel'deki Model veya Service class'larına benzer.

**Object (Nesne):** Class'tan üretilen gerçek örnekler/instance'lar.

### 1.2 Laravel vs Java Karşılaştırması

```php
// LARAVEL - User Model
class User extends Model
{
    public $name;
    public $email;
    
    public function getFullInfo()
    {
        return $this->name . ' - ' . $this->email;
    }
}

// Kullanımı
$user = new User();
$user->name = "Ahmet";
$user->email = "ahmet@example.com";
echo $user->getFullInfo();
```

```java
// JAVA - User Class
// Dosya: src/main/java/com/example/User.java
public class User {
    String name;
    String email;
    
    public String getFullInfo() {
        return name + " - " + email;
    }
}

// Kullanımı (Main.java)
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.name = "Ahmet";
        user.email = "ahmet@example.com";
        System.out.println(user.getFullInfo());
    }
}
```

### 1.3 Çoklu Nesne Oluşturma

```java
// Dosya: src/main/java/com/example/Student.java
public class Student {
    String name;
    int age;
    String studentId;
    
    public void displayInfo() {
        System.out.println("Öğrenci: " + name);
        System.out.println("Yaş: " + age);
        System.out.println("ID: " + studentId);
        System.out.println("---");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.name = "Ali Yılmaz";
        student1.age = 20;
        student1.studentId = "2024001";
        
        Student student2 = new Student();
        student2.name = "Ayşe Demir";
        student2.age = 22;
        student2.studentId = "2024002";
        
        student1.displayInfo();
        student2.displayInfo();
    }
}
```

---

## 2. JDK, JRE, JVM Mimarisi

### 2.1 Tanımlar

**JVM (Java Virtual Machine)**
- Bytecode'u çalıştıran sanal makina
- Platform bağımsızlık sağlar
- "Write Once, Run Anywhere" konsepti
- Laravel'deki **PHP-FPM/Interpreter**'a benzer

**JRE (Java Runtime Environment)**
- JVM + Core Libraries (java.lang, java.util vs)
- Sadece Java programlarını ÇALIŞTIRMAK için
- Development araçları YOK
- Laravel'deki **PHP Runtime**'a benzer

**JDK (Java Development Kit)**
- JRE + Development Tools (javac compiler, debugger, jdb)
- Java programları YAZMAK ve ÇALIŞTIRMAK için
- Laravel'deki **PHP + Composer + Laravel Installer**'ın toplamı

### 2.2 Çalışma Mimarisi Karşılaştırması

```
LARAVEL/PHP:
PHP Code (.php) 
    ↓
PHP Interpreter (php-fpm)
    ↓
Web Server (Nginx/Apache)
    ↓
Çalışan Uygulama

JAVA:
Java Code (.java)
    ↓
Java Compiler (javac) → Bytecode (.class)
    ↓
JVM (Java Virtual Machine)
    ↓
Çalışan Uygulama
```

### 2.3 Basit Analoji

```
JDK = Mutfak + Malzemeler + Tarifler (Yemek yapabilirsin)
JRE = Hazır Yemek + Tabak + Çatal (Sadece yiyebilirsin)
JVM = Mide (Yemeği sindiren sistem)
```

### 2.4 Karşılaştırma Tablosu

| Java | Laravel/PHP | Açıklama |
|------|-------------|----------|
| JDK | PHP + Composer + Laravel | Development ortamı |
| JRE | PHP Runtime | Sadece çalıştırma |
| JVM | PHP-FPM/Interpreter | Kod çalıştırıcı |
| .java | .php | Kaynak kod |
| .class | Opcache bytecode | Derlenmiş kod |

---

## 3. Methods (Metodlar)

### 3.1 Method Anatomisi

```java
// Dosya: src/main/java/com/example/MethodExample.java
public class MethodExample {
    
    // 1. Parametresiz, return'süz
    public void sayHello() {
        System.out.println("Merhaba!");
    }
    
    // 2. Parametreli, return'süz
    public void greet(String name) {
        System.out.println("Merhaba " + name);
    }
    
    // 3. Parametresiz, return'lü
    public String getMessage() {
        return "Bu bir mesajdır";
    }
    
    // 4. Parametreli, return'lü
    public int calculateSum(int a, int b) {
        return a + b;
    }
    
    // 5. Multiple parametre, return'lü
    public double calculateAverage(int num1, int num2, int num3) {
        return (num1 + num2 + num3) / 3.0;
    }
}
```

### 3.2 Pratik Örnek: Product Class

```java
// Dosya: src/main/java/com/example/Product.java
public class Product {
    String name;
    double price;
    int stock;
    String category;
    
    // Ürün bilgilerini göster
    public void displayProduct() {
        System.out.println("Ürün: " + name);
        System.out.println("Fiyat: " + price + " TL");
        System.out.println("Stok: " + stock);
        System.out.println("Kategori: " + category);
        System.out.println("---");
    }
    
    // İndirimli fiyat hesapla
    public double calculateDiscountPrice(double discountPercent) {
        double discount = price * (discountPercent / 100);
        return price - discount;
    }
    
    // Stok kontrolü
    public boolean isInStock() {
        return stock > 0;
    }
    
    // Stoktan düş
    public void decreaseStock(int amount) {
        if (stock >= amount) {
            stock -= amount;
            System.out.println(amount + " adet satıldı. Kalan: " + stock);
        } else {
            System.out.println("Yetersiz stok! Mevcut: " + stock);
        }
    }
    
    // KDV dahil fiyat
    public double getPriceWithTax() {
        double taxRate = 0.20;
        return price + (price * taxRate);
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Product laptop = new Product();
        laptop.name = "Lenovo ThinkPad";
        laptop.price = 25000;
        laptop.stock = 15;
        laptop.category = "Bilgisayar";
        
        laptop.displayProduct();
        
        double discounted = laptop.calculateDiscountPrice(10);
        System.out.println("%10 indirimli: " + discounted + " TL");
        
        laptop.decreaseStock(3);
        System.out.println("KDV'li fiyat: " + laptop.getPriceWithTax() + " TL");
    }
}
```

---

## 4. Method Overloading

### 4.1 Temel Konsept

**Method Overloading:** Aynı isimde ama farklı parametrelerle birden fazla method tanımlama.

**ÖNEMLİ:** PHP/Laravel'de bu özellik YOK! Java'ya özgü.

### 4.2 PHP vs Java

```php
// PHP'de YAPAMAYIZ - HATA VERİR
class Calculator {
    public function add($a, $b) {
        return $a + $b;
    }
    
    // HATA! Aynı isimde method tanımlayamazsın
    public function add($a, $b, $c) {
        return $a + $b + $c;
    }
}

// PHP çözümü: Optional parametreler
public function add($a, $b, $c = 0) {
    return $a + $b + $c;
}
```

```java
// JAVA'da Method Overloading
public class Calculator {
    
    // İki sayı topla
    public int add(int a, int b) {
        return a + b;
    }
    
    // Üç sayı topla (OVERLOADING!)
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // İki double topla (OVERLOADING!)
    public double add(double a, double b) {
        return a + b;
    }
    
    // Dört sayı topla (OVERLOADING!)
    public int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }
}

// Kullanımı
Calculator calc = new Calculator();
System.out.println(calc.add(5, 10));          // İki int
System.out.println(calc.add(5, 10, 15));      // Üç int
System.out.println(calc.add(5.5, 10.5));      // İki double
System.out.println(calc.add(1, 2, 3, 4));     // Dört int
```

### 4.3 Overloading Kuralları

```java
public class OverloadingRules {
    
    // ✅ GEÇERLİ - Farklı parametre SAYISI
    public void display(int a) { }
    public void display(int a, int b) { }
    
    // ✅ GEÇERLİ - Farklı parametre TİPİ
    public void show(int a) { }
    public void show(double a) { }
    public void show(String a) { }
    
    // ✅ GEÇERLİ - Farklı parametre SIRASI
    public void print(int a, String b) { }
    public void print(String a, int b) { }
    
    // ❌ GEÇERSİZ - Sadece return type farklı
    // public int calculate(int a) { return a; }
    // public double calculate(int a) { return a; } // HATA!
    
    // ❌ GEÇERSİZ - Sadece parametre ismi farklı
    // public void process(int num) { }
    // public void process(int number) { } // HATA!
}
```

### 4.4 🎯 MÜLAKAT SORUSU: Method Overloading

**Soru:** Aşağıdaki kodda kaç tane method overloading var ve hangi çağrı hangi method'u kullanır?

```java
public class Test {
    public void calculate(int a) { 
        System.out.println("Method 1");
    }
    
    public void calculate(double a) { 
        System.out.println("Method 2");
    }
    
    public void calculate(int a, int b) { 
        System.out.println("Method 3");
    }
    
    public int calculate(int a, double b) { 
        System.out.println("Method 4");
        return 0;
    }
}

// Çağrılar:
test.calculate(5);
test.calculate(5.5);
test.calculate(5, 10);
test.calculate(5, 10.5);
```

**Cevap:**
- 4 adet overloaded method var
- `test.calculate(5)` → Method 1 çağrılır (int)
- `test.calculate(5.5)` → Method 2 çağrılır (double)
- `test.calculate(5, 10)` → Method 3 çağrılır (int, int)
- `test.calculate(5, 10.5)` → Method 4 çağrılır (int, double)

### 4.5 Pratik Örnek: Area Calculator

```java
public class AreaCalculator {
    
    // Kare alanı
    public double calculateArea(double side) {
        System.out.println("Kare alanı");
        return side * side;
    }
    
    // Dikdörtgen alanı
    public double calculateArea(double length, double width) {
        System.out.println("Dikdörtgen alanı");
        return length * width;
    }
    
    // Daire alanı
    public double calculateArea(double radius, String shape) {
        if (shape.equals("circle")) {
            System.out.println("Daire alanı");
            return 3.14 * radius * radius;
        }
        return 0;
    }
}

// Kullanımı
AreaCalculator area = new AreaCalculator();
System.out.println("Kare: " + area.calculateArea(5));
System.out.println("Dikdörtgen: " + area.calculateArea(5, 10));
System.out.println("Daire: " + area.calculateArea(7, "circle"));
```

---

## 5. Stack ve Heap Memory - Detaylı

### 5.1 Temel Kavramlar

**Stack Memory:**
- Method çağrıları ve local değişkenler için
- LIFO (Last In First Out) mantığı
- Hızlı erişim
- Sınırlı boyut (genelde 1MB)
- Thread-safe (her thread'in kendi stack'i var)

**Heap Memory:**
- Objeler için (new ile oluşturulan her şey)
- Garbage Collector tarafından yönetilir
- Daha yavaş erişim
- Büyük boyut (sistem memory'sine göre)
- Tüm thread'ler paylaşır

### 5.2 Memory Yapısı

```
┌─────────────────────────────────────┐
│          HEAP (Objeler)             │
│  ┌──────────┐  ┌──────────┐        │
│  │ User obj │  │ User obj │        │
│  │ name="A" │  │ name="B" │        │
│  └──────────┘  └──────────┘        │
└─────────────────────────────────────┘

┌─────────────────────────────────────┐
│      STACK (Method Calls)           │
│  ┌────────────────────────┐         │
│  │ main()                 │         │
│  │ int num = 10           │         │
│  │ User u1 ───────────────┼────┐    │
│  └────────────────────────┘    │    │
│  ┌────────────────────────┐    │    │
│  │ calculateSum()         │    │    │
│  │ int x = 5              │    │    │
│  │ int y = 10             │    │    │
│  └────────────────────────┘    │    │
└────────────────────────────────┼────┘
                                 │
                    Heap'teki User objesine referans
```

### 5.3 Primitive vs Reference Types

```java
public class MemoryDemo {
    public static void main(String[] args) {
        // PRIMITIVE TYPES - STACK'te saklanır
        int age = 25;           // Stack'te
        double salary = 5000.0; // Stack'te
        boolean active = true;  // Stack'te
        char grade = 'A';       // Stack'te
        
        // REFERENCE TYPES - Heap'te saklanır, referans Stack'te
        String name = "Ali";    // "Ali" objesi Heap'te, name referansı Stack'te
        User user = new User(); // User objesi Heap'te, user referansı Stack'te
        int[] nums = {1,2,3};   // Array Heap'te, nums referansı Stack'te
    }
}
```

### 5.4 🎯 MÜLAKAT SORUSU: Stack vs Heap

**Soru:** Aşağıdaki kodda kaç tane object Heap'te oluşturulur ve Stack'te kaç tane referans var?

```java
public class Test {
    public static void main(String[] args) {
        int num = 10;
        User u1 = new User();
        User u2 = new User();
        User u3 = u1;
        u3.age = 25;
        
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
    }
}
```

**Cevap:**
- **Heap'te Object Sayısı:** 4 adet
  - 2 adet User object (u1 ve u2 için)
  - 2 adet String object (String pool'da "Hello" + new String ile oluşturulan)
- **Stack'te Referans Sayısı:** 7 adet
  - num (primitive, değer Stack'te)
  - u1, u2, u3 (User referansları)
  - s1, s2, s3 (String referansları)
- **Önemli:** u3 yeni object oluşturmaz, u1'in gösterdiği objeye işaret eder
- **Önemli:** s1 ve s2 aynı String pool objesine işaret eder

### 5.5 Reference Kopyalama vs Object Kopyalama

```java
public class ReferenceDemo {
    public static void main(String[] args) {
        // İlk object
        Person p1 = new Person();
        p1.name = "Ali";
        p1.age = 25;
        
        // Reference kopyalama (YENİ OBJECT OLUŞTURULMAZ!)
        Person p2 = p1;
        p2.age = 30;
        
        System.out.println(p1.age); // 30 (p1 ve p2 AYNI objeyi gösterir!)
        
        // Yeni object oluşturma
        Person p3 = new Person();
        p3.name = p1.name;  // Değerleri kopyala
        p3.age = p1.age;
        p3.age = 35;
        
        System.out.println(p1.age); // 30 (p3 FARKLI bir obje!)
    }
}
```

### 5.6 🎯 MÜLAKAT SORUSU: Reference vs Value

**Soru:** Aşağıdaki kod ne yazdırır?

```java
public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Ali";
        s1.marks = 80;
        
        Student s2 = s1;
        s2.marks = 90;
        
        changeStudent(s1);
        
        System.out.println(s1.marks);
        System.out.println(s2.marks);
    }
    
    public static void changeStudent(Student s) {
        s.marks = 100;
        s = new Student();
        s.marks = 50;
    }
}

class Student {
    String name;
    int marks;
}
```

**Cevap:** 100 ve 100

**Açıklama:**
1. `s1` ve `s2` aynı objeyi gösterir
2. `s2.marks = 90` → Her ikisi de 90 olur
3. `changeStudent(s1)` çağrılır:
   - `s.marks = 100` → Heap'teki obje değişir (s1 ve s2 için)
   - `s = new Student()` → Sadece local `s` referansı değişir, s1/s2 etkilenmez
   - `s.marks = 50` → Sadece yeni oluşturulan objeyi etkiler
4. Sonuç: s1 ve s2 hala aynı objeyi gösterir ve marks = 100

### 5.7 Method Call Stack

```java
public class StackFlowDemo {
    public static void main(String[] args) {
        System.out.println("main başladı");
        method1();
        System.out.println("main bitti");
    }
    
    public static void method1() {
        System.out.println("method1 başladı");
        method2();
        System.out.println("method1 bitti");
    }
    
    public static void method2() {
        System.out.println("method2 başladı");
        int result = 5 + 10;
        System.out.println("method2 bitti");
    }
}
```

**Stack Durumu:**

```
Step 1:                Step 2:                Step 3:
┌──────────┐          ┌──────────┐          ┌──────────┐
│ main()   │          │ method1()│          │ method2()│
└──────────┘          ├──────────┤          ├──────────┤
                      │ main()   │          │ method1()│
                      └──────────┘          ├──────────┤
                                            │ main()   │
                                            └──────────┘

Step 4:                Step 5:                Step 6:
┌──────────┐          ┌──────────┐          (Stack boş)
│ method1()│          │ main()   │
├──────────┤          └──────────┘
│ main()   │
└──────────┘
```

### 5.8 🎯 MÜLAKAT SORUSU: Memory Leak

**Soru:** Aşağıdaki kodda memory leak riski var mı? Neden?

```java
public class UserService {
    private static List<User> allUsers = new ArrayList<>();
    
    public void addUser(User user) {
        allUsers.add(user);
    }
    
    public void processUser(int userId) {
        User tempUser = new User();
        tempUser.id = userId;
        // tempUser ile işlem yap
    }
}
```

**Cevap:** Evet, `allUsers` static list'inde memory leak riski var.

**Açıklama:**
- `allUsers` static olduğu için program çalıştığı sürece memory'de kalır
- Her `addUser()` çağrısında list büyür ama hiç temizlenmez
- `tempUser` ise method bitince Garbage Collector tarafından temizlenir (sorun yok)

**Çözüm:**
```java
public void clearOldUsers() {
    allUsers.removeIf(user -> user.inactive);
}
```

### 5.9 Garbage Collection

```java
public class GCDemo {
    public static void main(String[] args) {
        // Object oluştur
        User user1 = new User();
        user1.name = "Ali";
        
        // Referansı null yap - Garbage Collector temizleyebilir
        user1 = null;
        
        // Yeni object oluştur, eski referansı kaybet
        User user2 = new User();
        user2 = new User(); // İlk User objesi GC için hazır
        
        // Manuel GC önerisi (garanti değil!)
        System.gc();
    }
}
```

### 5.10 String Pool (Özel Durum)

```java
public class StringPoolDemo {
    public static void main(String[] args) {
        // String pool'da oluşturulur
        String s1 = "Hello";
        String s2 = "Hello";
        
        System.out.println(s1 == s2); // true (aynı pool objesini gösterirler)
        
        // Heap'te yeni obje oluşturulur
        String s3 = new String("Hello");
        
        System.out.println(s1 == s3); // false (farklı objeler)
        System.out.println(s1.equals(s3)); // true (değerler aynı)
    }
}
```

---

## 6. Mülakat Soruları

### Soru 1: Class ve Object
**Soru:** Class ve Object arasındaki fark nedir? Örnek verin.

**Cevap:** Class bir blueprint/şablondur, Object ise bu şablondan oluşturulan gerçek örneklerdir.
```java
// Class (şablon)
class Car {
    String model;
    int year;
}

// Objects (örnekler)
Car car1 = new Car(); // 1. obje
Car car2 = new Car(); // 2. obje
```

### Soru 2: Method Overloading
**Soru:** Method Overloading nedir? Kuralları nelerdir?

**Cevap:** Aynı isimde farklı parametrelerle birden fazla method tanımlama.

**Kurallar:**
- Parametre sayısı VEYA parametre tipi farklı olmalı
- Sadece return type farklı olması yeterli DEĞİL
- Parametre isimleri farklı olması yeterli DEĞİL

```java
// Geçerli overloading
public void print(int a) { }
public void print(String a) { }
public void print(int a, int b) { }

// Geçersiz overloading
public int calculate(int a) { }
public double calculate(int a) { } // HATA!
```

### Soru 3: Stack vs Heap
**Soru:** Stack ve Heap memory arasındaki farklar nelerdir?

**Cevap:**

| Özellik | Stack | Heap |
|---------|-------|------|
| İçerik | Method çağrıları, local değişkenler, primitive tipler | Objeler (new ile oluşturulan) |
| Boyut | Küçük (1MB civarı) | Büyük (sistem RAM'ine göre) |
| Hız | Çok hızlı | Daha yavaş |
| Yönetim | Otomatik (method bitince temizlenir) | Garbage Collector |
| Thread | Her thread'in kendi stack'i | Tüm thread'ler paylaşır |

### Soru 4: JDK vs JRE vs JVM
**Soru:** JDK, JRE ve JVM nedir? Aralarındaki fark nedir?

**Cevap:**
- **JVM:** Bytecode'u çalıştıran sanal makina
- **JRE:** JVM + Kütüphaneler (sadece çalıştırma için)
- **JDK:** JRE + Geliştirme araçları (javac, debugger vs)

```
JDK = JRE + Development Tools
JRE = JVM + Libraries
JVM = Bytecode çalıştırıcı
```

### Soru 5: Reference Kopyalama
**Soru:** Aşağıdaki kod ne yazdırır?

```java
User u1 = new User();
u1.age = 20;

User u2 = u1;
u2.age = 30;

System.out.println(u1.age);
```

**Cevap:** 30

**Açıklama:** `u2 = u1` yeni obje oluşturmaz, u1'in gösterdiği objeye referans kopyalar. Her iki değişken de aynı objeyi gösterir.

### Soru 6: Method Overloading Seçimi
**Soru:** Aşağıdaki kodda hangi method çağrılır?

```java
public class Test {
    public void show(int a) {
        System.out.println("int");
    }
    
    public void show(double a) {
        System.out.println("double");
    }
    
    public void show(Integer a) {
        System.out.println("Integer");
    }
}

Test t = new Test();
t.show(5);
```

**Cevap:** "int" yazdırılır.

**Açıklama:** 5 primitive int olduğu için önce int parametreli method aranır ve bulunur. Wrapper class (Integer) auto-boxing gerektirir, bu yüzden tercih edilmez.

---

## 7. Pratik Örnekler

### 7.1 Banka Hesabı Örneği

```java
// Dosya: src/main/java/com/example/BankAccount.java
public class BankAccount {
    String accountNumber;
    String ownerName;
    double balance;
    
    // Para yatır
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " TL yatırıldı.");
            System.out.println("Güncel bakiye: " + balance + " TL");
        } else {
            System.out.println("Geçersiz tutar!");
        }
    }
    
    // Para çek
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(amount + " TL çekildi.");
            System.out.println("Güncel bakiye: " + balance + " TL");
            return true;
        } else {
            System.out.println("Yetersiz bakiye veya geçersiz tutar!");
            return false;
        }
    }
    
    // Para transfer et
    public boolean transfer(BankAccount targetAccount, double amount) {
        if (withdraw(amount)) {
            targetAccount.deposit(amount);
            System.out.println("Transfer başarılı: " + targetAccount.ownerName);
            return true;
        }
        return false;
    }
    
    // Bakiye göster
    public void displayBalance() {
        System.out.println("Hesap Sahibi: " + ownerName);
        System.out.println("Hesap No: " + accountNumber);
        System.out.println("Bakiye: " + balance + " TL");
        System.out.println("---");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        account1.accountNumber = "TR001";
        account1.ownerName = "Ali Yılmaz";
        account1.balance = 1000;
        
        BankAccount account2 = new BankAccount();
        account2.accountNumber = "TR002";
        account2.ownerName = "Ayşe Demir";
        account2.balance = 500;
        
        account1.displayBalance();
        account2.displayBalance();
        
        account1.deposit(500);
        account1.withdraw(200);
        account1.transfer(account2, 300);
        
        account1.displayBalance();
        account2.displayBalance();
    }
}
```

### 7.2 E-Ticaret Sepet Örneği

```java
// Dosya: src/main/java/com/example/ShoppingCart.java
public class ShoppingCart {
    String customerId;
    String[] productNames;
    double[] productPrices;
    int itemCount;
    
    // Constructor benzeri başlangıç
    public void initialize(int maxItems) {
        productNames = new String[maxItems];
        productPrices = new double[maxItems];
        itemCount = 0;
    }
    
    // Ürün ekle
    public void addProduct(String name, double price) {
        if (itemCount < productNames.length) {
            productNames[itemCount] = name;
            productPrices[itemCount] = price;
            itemCount++;
            System.out.println(name + " sepete eklendi.");
        } else {
            System.out.println("Sepet dolu!");
        }
    }
    
    // Toplam tutarı hesapla
    public double calculateTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += productPrices[i];
        }
        return total;
    }
    
    // İndirimli toplam
    public double calculateTotal(double discountPercent) {
        double total = calculateTotal();
        double discount = total * (discountPercent / 100);
        return total - discount;
    }
    
    // Kargo dahil fiyat
    public double calculateTotal(double discountPercent, double shippingFee) {
        return calculateTotal(discountPercent) + shippingFee;
    }
    
    // Sepeti göster
    public void displayCart() {
        System.out.println("=== SEPET ===");
        System.out.println("Müşteri: " + customerId);
        for (int i = 0; i < itemCount; i++) {
            System.out.println((i + 1) + ". " + productNames[i] + 
                             " - " + productPrices[i] + " TL");
        }
        System.out.println("Toplam: " + calculateTotal() + " TL");
        System.out.println("=============");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.initialize(10);
        cart.customerId = "C001";
        
        cart.addProduct("Laptop", 15000);
        cart.addProduct("Mouse", 250);
        cart.addProduct("Klavye", 500);
        
        cart.displayCart();
        
        System.out.println("\n%10 indirimli: " + cart.calculateTotal(10) + " TL");
        System.out.println("İndirim + Kargo: " + cart.calculateTotal(10, 50) + " TL");
    }
}
```

### 7.3 Öğrenci Yönetim Sistemi

```java
// Dosya: src/main/java/com/example/Student.java
public class Student {
    String studentId;
    String name;
    int age;
    double[] grades;
    int gradeCount;
    
    // Başlangıç
    public void initialize(String id, String studentName, int studentAge) {
        studentId = id;
        name = studentName;
        age = studentAge;
        grades = new double[10];
        gradeCount = 0;
    }
    
    // Not ekle
    public void addGrade(double grade) {
        if (gradeCount < grades.length && grade >= 0 && grade <= 100) {
            grades[gradeCount] = grade;
            gradeCount++;
            System.out.println("Not eklendi: " + grade);
        }
    }
    
    // Ortalama hesapla
    public double calculateAverage() {
        if (gradeCount == 0) return 0;
        
        double sum = 0;
        for (int i = 0; i < gradeCount; i++) {
            sum += grades[i];
        }
        return sum / gradeCount;
    }
    
    // Harf notu
    public String getLetterGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return "AA";
        else if (avg >= 80) return "BA";
        else if (avg >= 70) return "BB";
        else if (avg >= 60) return "CB";
        else if (avg >= 50) return "CC";
        else return "FF";
    }
    
    // Geçti mi?
    public boolean isPassed() {
        return calculateAverage() >= 50;
    }
    
    // En yüksek not
    public double getHighestGrade() {
        if (gradeCount == 0) return 0;
        
        double highest = grades[0];
        for (int i = 1; i < gradeCount; i++) {
            if (grades[i] > highest) {
                highest = grades[i];
            }
        }
        return highest;
    }
    
    // En düşük not
    public double getLowestGrade() {
        if (gradeCount == 0) return 0;
        
        double lowest = grades[0];
        for (int i = 1; i < gradeCount; i++) {
            if (grades[i] < lowest) {
                lowest = grades[i];
            }
        }
        return lowest;
    }
    
    // Öğrenci bilgilerini göster
    public void displayInfo() {
        System.out.println("=== ÖĞRENCİ BİLGİLERİ ===");
        System.out.println("ID: " + studentId);
        System.out.println("Ad: " + name);
        System.out.println("Yaş: " + age);
        System.out.println("Not Sayısı: " + gradeCount);
        System.out.println("Ortalama: " + calculateAverage());
        System.out.println("Harf Notu: " + getLetterGrade());
        System.out.println("En Yüksek: " + getHighestGrade());
        System.out.println("En Düşük: " + getLowestGrade());
        System.out.println("Durum: " + (isPassed() ? "Geçti" : "Kaldı"));
        System.out.println("========================");
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.initialize("2024001", "Ali Yılmaz", 20);
        
        student1.addGrade(85);
        student1.addGrade(90);
        student1.addGrade(78);
        student1.addGrade(92);
        student1.addGrade(88);
        
        student1.displayInfo();
        
        System.out.println("\n");
        
        Student student2 = new Student();
        student2.initialize("2024002", "Ayşe Demir", 21);
        
        student2.addGrade(45);
        student2.addGrade(50);
        student2.addGrade(38);
        
        student2.displayInfo();
    }
}
```

---

## 8. Öğrenci Sorular ve Cevaplar

### Test Soru 1
**Soru:** Aşağıdaki kodda hangi method çağrılır?

```java
Calculator calc = new Calculator();
System.out.println(calc.multiply(5, 3));

class Calculator {
    public int multiply(int a, int b) {
        return a * b;
    }
    
    public double multiply(double a, double b) {
        return a * b;
    }
}
```

**Öğrenci Cevabı:** D (Hata verir)

**Doğru Cevap:** B (15)

**Açıklama:** İki integer parametre gönderildiği için `int multiply(int, int)` method'u çağrılır ve 15 döner. Method overloading geçerlidir.

---

### Test Soru 2
**Soru:** Stack ve Heap ile ilgili hangisi YANLIŞ?

**Öğrenci Cevabı:** D (String değişkenleri stack'te saklanır) - DOĞRU

**Açıklama:** String bir object olduğu için heap'te saklanır. Sadece referansı stack'tedir.

---

### Test Soru 3
**Soru:** Aşağıdaki kodda kaç tane object oluşturulur?

```java
Person p1 = new Person();
Person p2 = new Person();
Person p3 = p1;
p3.age = 25;
```

**Öğrenci Cevabı:** 3

**Doğru Cevap:** 2

**Açıklama:** `p3 = p1` yeni obje oluşturmaz, sadece referans kopyalar. p1 ve p3 aynı objeyi gösterir.

---

### Test Soru 4
**Soru:** Method Overloading için hangisi GEÇERSİZ?

**Öğrenci Cevabı:** A

**Doğru Cevap:** B

```java
public int calculate(int a) { }
public double calculate(int a) { }
```

**Açıklama:** Sadece return type farklı olması yeterli değildir. Parametre sayısı veya tipi farklı olmalıdır.

---

### Test Soru 6
**Soru:** JDK, JRE ve JVM'i açıklayın.

**Öğrenci Cevabı:** 
- JVM = Java'nın çalıştığı sanal makina
- JRE = JVM + Java kütüphaneleri
- JDK = JRE + Java geliştirme araçları (debugger gibi)

**Değerlendirme:** Doğru tanımlar yapılmış.

---

## 9. Özet ve Karşılaştırma

### Laravel vs Java Özet Tablosu

| Özellik | Laravel/PHP | Java |
|---------|-------------|------|
| Class | `class User { }` | `public class User { }` |
| Object | `$user = new User();` | `User user = new User();` |
| Property | `public $name;` | `String name;` |
| Method | `public function getName()` | `public String getName()` |
| This | `$this->name` | `this.name` |
| Method Overloading | YOK | VAR |
| Memory | Otomatik | Stack + Heap |
| Garbage Collection | Otomatik | Otomatik ama farkında olmalısın |

### Önemli Notlar

1. **Method Overloading:** PHP'de yoktur, Java'ya özgü bir özelliktir
2. **Stack vs Heap:** Primitive tipler stack'te, objeler heap'te
3. **Reference Kopyalama:** `Person p2 = p1` yeni obje oluşturmaz
4. **JVM:** Java bytecode'u çalıştıran sanal makina
5. **Garbage Collector:** Kullanılmayan objeleri otomatik temizler

---

## 10. Çalıştırma Talimatları

### IntelliJ IDEA'da Proje Oluşturma

1. File > New > Project
2. Java seçin, JDK 17 veya üstü
3. Project name: "Section4Demo"
4. Create

### Class Oluşturma

1. src/main/java üzerinde sağ tık
2. New > Package > "com.example"
3. com.example üzerinde sağ tık
4. New > Java Class > "Main"

### Kodu Çalıştırma

1. Main.java içinde sağ tık
2. Run 'Main.main()'
3. Veya yeşil play butonuna tıkla
4. Terminal'de çıktıyı görürsün

### Terminal'den Çalıştırma

```bash
# Derleme
javac src/main/java/com/example/Main.java

# Çalıştırma
java -cp src/main/java com.example.Main
```

---

## Section 4 Tamamlandı! ✅

**Öğrendiğin Konular:**
- ✅ Class ve Object
- ✅ JDK, JRE, JVM
- ✅ Methods
- ✅ Method Overloading
- ✅ Stack ve Heap Memory
- ✅ Mülakat Soruları

**Bir Sonraki Section:** Section 5 - Arrays and Data Structures