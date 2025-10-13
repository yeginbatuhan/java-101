# SECTION 2: Java Fundamentals - Tam Ders Notu

## 1. Java'ya Giriş

### Java Nedir?
Java, platform bağımsız ve nesne yönelimli bir programlama dilidir. "Write Once, Run Anywhere" (Bir kez yaz, her yerde çalıştır) felsefesini benimser.

**Laravel ile Karşılaştırma:**
- **PHP**: Web odaklı, sunucu tarafında çalışan, interpreted
- **Java**: Platform bağımsız, kurumsal uygulamalar için, compiled + interpreted

### Java Nasıl Çalışır?

```
Java Kaynak (.java) → Java Derleyici (javac) → Bytecode (.class) → JVM → Makine Kodu
```

**PHP ile Karşılaştırma:**
```
PHP Kaynak (.php) → PHP Engine → Direkt Çalıştırma
Java Kaynak (.java) → Derleyici → Bytecode → JVM → Çalıştırma
```

## 2. JDK, JRE ve JVM Kavramları

### Temel Yapı
```
JDK (Java Development Kit) = Geliştirme araçları + JRE
JRE (Java Runtime Environment) = Çalıştırma ortamı + JVM + Kütüphaneler  
JVM (Java Virtual Machine) = Java kodunu çalıştıran sanal makine
```

### Kurulum
- **Windows**: https://adoptium.net/ adresinden OpenJDK 17+
- **Mac**: `brew install openjdk@17`
- **Linux**: `sudo apt install openjdk-17-jdk`

### Environment Variables
```bash
export JAVA_HOME=/path/to/java
export PATH=$JAVA_HOME/bin:$PATH
```

### Kontrol
```bash
java -version
javac -version
```

## 3. İlk Java Programı

### Dosya Yapısı
**Dosya: `src/Main.java`**
```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Merhaba Java Dünyası!");
    }
}
```

### Çalıştırma
**IDE'de:**
1. Main.java dosyasına sağ tık
2. "Run 'Main.main()'" seçin

**Terminal'de:**
```bash
javac src/Main.java  # Derleme
java -cp src Main    # Çalıştırma
```

## 4. Değişkenler (Variables)

### Değişken Tanımlama
```java
// Tanımlama
int yas;
String isim;

// Başlatma
yas = 25;
isim = "Ali";

// Tanımlama + Başlatma
double maas = 5000.50;
boolean aktif = true;
```

**Laravel Karşılaştırması:**
```php
// PHP - Dynamic typing
$yas = 25;
$isim = "Ali";

// Java - Static typing
int yas = 25;
String isim = "Ali";
```

### Değişken Kapsamları (Variable Scope)

#### Instance Variables (Örnek Değişkenleri)
```java
public class Calisan {
    private String sirketAdi = "TechCorp";  // Her nesne için ayrı kopya
    private int yas;                        // Her nesne için ayrı kopya
}
```

#### Static Variables (Sınıf Değişkenleri)
```java
public class Calisan {
    private static int calisanSayisi = 0;   // Tüm sınıf için tek kopya
    private static String sirketAdi = "TechCorp";  // Tüm sınıf için tek kopya
}
```

#### Local Variables (Yerel Değişkenler)
```java
public void maasHesapla() {
    double temelMaas = 3000.0;  // Method seviyesinde
    double bonus = 500.0;       // Method seviyesinde
}
```

### Static vs Non-Static Farkı

**Memory'de Nasıl Saklanır:**
```
HEAP MEMORY (Her nesne için ayrı):
├── Nesne 1 (emp1)
│   ├── isim = "Ali"
│   └── yas = 25
└── Nesne 2 (emp2)  
    ├── isim = "Ayşe"
    └── yas = 30

METHOD AREA (Tüm nesneler paylaşır):
├── calisanSayisi = 2
└── sirketAdi = "TechCorp"
```

## 5. Veri Tipleri (Data Types)

### Primitive (Temel) Veri Tipleri

#### Tam Sayı Tipleri
```java
byte kucukSayi = 127;           // -128 to 127
short ortaSayi = 32767;         // -32,768 to 32,767  
int normalSayi = 2147483647;    // -2^31 to 2^31-1
long buyukSayi = 9223372036854775807L; // -2^63 to 2^63-1
```

#### Ondalık Sayı Tipleri
```java
float ondalik = 3.14f;          // 32-bit IEEE 754
double hassasOndalik = 3.14159265359; // 64-bit IEEE 754
```

#### Karakter ve Boolean
```java
char harf = 'A';                // Tek karakter
boolean dogruMu = true;         // true veya false
```

### Reference (Referans) Veri Tipleri
```java
String mesaj = "Merhaba Dünya";     // String objesi
int[] sayilar = {1, 2, 3, 4, 5};   // Array objesi
```

**Laravel Karşılaştırması:**
```php
// PHP - Gevşek tipli
$sayi = 42;           // PHP otomatik tip belirler
$ondalik = 3.14;      // PHP otomatik tip belirler

// Java - Sıkı tipli
int sayi = 42;        // Açık tip belirtimi
double ondalik = 3.14; // Açık tip belirtimi
```

## 6. Literals (Değişmez Değerler)

### Literal Türleri
```java
// Tam Sayı Literals
int decimal = 42;           // Onluk
int binary = 0b101010;      // İkilik (42)
int octal = 0o52;           // Sekizlik (42)  
int hex = 0x2A;             // Onaltılık (42)

// Ondalık Literals
double bilimsel = 1.23e2;   // 123.0 (Bilimsel notasyon)
float floatSayi = 3.14f;    // Float literal (f eki)

// Karakter Literals  
char harf = 'A';            // Tek tırnak
char unicode = '\u0041';    // Unicode (A)
char kacis = '\n';          // Kaçış karakteri

// String Literals
String metin = "Java String"; // Çift tırnak

// Boolean Literals
boolean dogru = true;
boolean yanlis = false;
```

## 7. Tip Dönüşümü (Type Conversion)

### Otomatik Dönüşüm (Implicit Conversion)
```java
byte byteValue = 42;
int intValue = byteValue;        // byte → int (otomatik)
double doubleValue = intValue;   // int → double (otomatik)
```

### Manuel Dönüşüm (Explicit Conversion - Casting)
```java
double buyukSayi = 123.789;
int intSayi = (int) buyukSayi;  // double → int (manuel)
byte byteSayi = (byte) intSayi; // int → byte (manuel)
```

### String Dönüşümleri
```java
// String'den sayıya
String sayiString = "123";
int parseEdilen = Integer.parseInt(sayiString);
double parseEdilenDouble = Double.parseDouble("123.45");

// Sayıdan String'e
int sayi = 456;
String stringSayi = String.valueOf(sayi);
String baskaYol = Integer.toString(sayi);
```

**Laravel Karşılaştırması:**
```php
// PHP - Otomatik tip dönüşümü
$sayi = "123";
$sonuc = $sayi + 10;  // "123" otomatik int olur

// Java - Manuel tip dönüşümü zorunlu
String sayiString = "123";
int sonuc = Integer.parseInt(sayiString) + 10;
```

## 8. Tip Kontrolü ve Casting Açıklaması

### Primitive Tiplerin Tip Kontrolü
```java
int yas = 25;

// Bu ÇALIŞMAZ - primitive'ler method'a sahip değil
// System.out.println(yas.getClass()); // HATA!

// Bu ÇALIŞIR - Object'e cast ederek method'a erişim
System.out.println(((Object)yas).getClass().getSimpleName());
```

### Autoboxing ve Unboxing
```java
// Autoboxing: primitive → wrapper class
int primitiveInt = 42;
Integer wrapperInt = primitiveInt;  // int → Integer otomatik

// Unboxing: wrapper class → primitive  
Integer wrapperInt2 = 42;
int primitiveInt2 = wrapperInt2;    // Integer → int otomatik
```

### Syntax Açıklaması: ((Object)age).getClass().getSimpleName()
```java
int yas = 25;

// Adım adım:
Object yasAsObject = (Object) yas;           // 1. Boxing: int → Integer → Object
Class<?> yasClass = yasAsObject.getClass();  // 2. Sınıf bilgisini al
String yasSinifAdi = yasClass.getSimpleName(); // 3. Basit sınıf adını al

// Tek satırda:
String tip = ((Object)yas).getClass().getSimpleName();
```

## 9. Memory Management

### Stack vs Heap
- **Stack**: Primitive değişkenler ve method referansları
- **Heap**: Nesneler ve diziler
- **Method Area**: Static değişkenler ve class bilgileri
- **Garbage Collection**: Otomatik bellek temizleme

## 10. Best Practices ve Common Pitfalls

### Performance Considerations
- Primitive types > Wrapper classes (performans açısından)
- String concatenation yerine StringBuilder kullanın
- Gereksiz boxing/unboxing'den kaçının

### Yaygın Hatalar
1. **Integer Overflow**: `int max = Integer.MAX_VALUE + 1; // Negatif değer!`
2. **Floating Point Precision**: `double sonuc = 0.1 + 0.2; // 0.30000000000000004`
3. **String Comparison**: `==` yerine `.equals()` kullanın

## 11. Pratik Örnekler

### Çalışan Bilgi Sistemi
```java
public class CalisanSistemi {
    public static void main(String[] args) {
        // Çalışan bilgileri
        String ad = "Ahmet";
        String soyad = "Yılmaz";
        int yas = 28;
        double temelMaas = 4000.0;
        boolean tamZamanli = true;
        char departman = 'I'; // IT departmanı
        
        // Hesaplamalar
        double bonus = tamZamanli ? temelMaas * 0.1 : 0;
        double toplamMaas = temelMaas + bonus;
        String tamAd = ad + " " + soyad;
        
        // Bilgileri göster
        System.out.println("=== ÇALIŞAN BİLGİ SİSTEMİ ===");
        System.out.println("Ad Soyad: " + tamAd);
        System.out.println("Yaş: " + yas);
        System.out.println("Departman: " + departman + " (IT)");
        System.out.println("Tam Zamanlı: " + (tamZamanli ? "Evet" : "Hayır"));
        System.out.println("Temel Maaş: " + temelMaas + " TL");
        System.out.println("Bonus: " + bonus + " TL");
        System.out.println("Toplam Maaş: " + toplamMaas + " TL");
    }
}
```

## Özet

Java, statik tipli bir dil olarak PHP'den farklıdır. Değişken türlerini önceden belirtmek zorundayız. Static keyword ile sınıf seviyesinde paylaşılan değişkenler oluşturabiliriz. Tip dönüşümleri manuel olarak yapılmalı ve primitive türlerin tip kontrolü için casting gereklidir.