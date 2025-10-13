# Section 2: Java Fundamentals - Test Soruları ve Detaylı Cevapları

## Soru 1: Static Keyword Nedir?

### Günlük Hayat Örneği: Okul Sınıfı

Bir okul sınıfını düşünelim. Bu sınıfta öğrenciler var:

**Normal (Instance) Değişkenler - Her öğrencinin kendine ait bilgileri:**
- Her öğrencinin kendine ait adı var
- Her öğrencinin kendine ait numarası var
- Her öğrencinin kendine ait notu var

**Static Değişkenler - Tüm sınıfın ortak bilgileri:**
- Sınıftaki toplam öğrenci sayısı (herkese ortak)
- Okulun adı (herkese ortak)
- Sınıf öğretmeninin adı (herkese ortak)

### Java Kodla Açıklama

```java
public class Ogrenci {
    // Instance variables - her öğrenci için ayrı
    private String ad;
    private int numara;
    private double not;
    
    // Static variables - tüm öğrenciler için ortak
    private static int toplamOgrenciSayisi = 0;
    private static String okulAdi = "Atatürk İlkokulu";
    private static String sinifOgretmeni = "Ayşe Öğretmen";
    
    // Constructor (Yapıcı method)
    public Ogrenci(String ad, int numara, double not) {
        this.ad = ad;           // Bu öğrenciye özel
        this.numara = numara;   // Bu öğrenciye özel
        this.not = not;         // Bu öğrenciye özel
        
        toplamOgrenciSayisi++;  // Ortak sayacı artır
    }
    
    // Instance method - öğrenci bilgilerini göster
    public void bilgileriGoster() {
        System.out.println("Ad: " + ad);
        System.out.println("Numara: " + numara);
        System.out.println("Not: " + not);
        System.out.println("Okul: " + okulAdi);
        System.out.println("Öğretmen: " + sinifOgretmeni);
        System.out.println("Toplam Öğrenci: " + toplamOgrenciSayisi);
    }
    
    // Static method - sınıf bilgilerini göster
    public static void sinifBilgisi() {
        System.out.println("Okul: " + okulAdi);
        System.out.println("Öğretmen: " + sinifOgretmeni);
        System.out.println("Toplam Öğrenci: " + toplamOgrenciSayisi);
        // System.out.println("Ad: " + ad); // HATA! Static method'dan instance variable'a erişemez
    }
    
    public static void main(String[] args) {
        // İlk başta öğrenci yok
        System.out.println("Başlangıç öğrenci sayısı: " + Ogrenci.toplamOgrenciSayisi);
        
        // Öğrenciler oluşturalım
        Ogrenci ali = new Ogrenci("Ali Veli", 123, 85.5);
        Ogrenci ayse = new Ogrenci("Ayşe Fatma", 124, 92.0);
        Ogrenci mehmet = new Ogrenci("Mehmet Can", 125, 78.5);
        
        // Her öğrencinin kendi bilgileri
        System.out.println("\n=== ALİ'NİN BİLGİLERİ ===");
        ali.bilgileriGoster();
        
        System.out.println("\n=== AYŞE'NİN BİLGİLERİ ===");
        ayse.bilgileriGoster();
        
        // Sınıf bilgilerini static method ile göster
        System.out.println("\n=== SINIF BİLGİSİ ===");
        Ogrenci.sinifBilgisi();  // Class name ile çağırdık
    }
}
```

### Memory'de Nasıl Saklanır?

```
HEAP MEMORY (Her öğrenci için ayrı nesneler):
├── ali nesnesi
│   ├── ad = "Ali Veli"
│   ├── numara = 123
│   └── not = 85.5
├── ayse nesnesi
│   ├── ad = "Ayşe Fatma"  
│   ├── numara = 124
│   └── not = 92.0
└── mehmet nesnesi
    ├── ad = "Mehmet Can"
    ├── numara = 125
    └── not = 78.5

METHOD AREA (Tüm öğrenciler paylaşır):
├── toplamOgrenciSayisi = 3
├── okulAdi = "Atatürk İlkokulu"
└── sinifOgretmeni = "Ayşe Öğretmen"
```

### Laravel ile Karşılaştırma

```php
// PHP - Laravel'de static kullanımı
class User extends Model {
    // Instance properties
    protected $name;
    protected $email;
    
    // Static property - tüm User class'ı için ortak
    private static $totalUserCount = 0;
    
    public function __construct($name, $email) {
        $this->name = $name;
        $this->email = $email;
        self::$totalUserCount++;
    }
    
    // Static method
    public static function getTotalUsers() {
        return self::$totalUserCount;
    }
}

// Kullanım
$user1 = new User("Ali", "ali@example.com");
$user2 = new User("Ayşe", "ayse@example.com");

echo User::getTotalUsers(); // 2
```

---

## Soru 2: Object Casting Neden Gerekli?

### Günlük Hayat Örneği: Kimlik Kartı

Düşünün ki elinizde sadece bir sayı var: **25**

Bu sayıyla ilgili bilgi almak istiyorsunuz:
- Bu hangi tür bir sayı? (yaş mı, fiyat mı, sıcaklık mı?)
- Nasıl bir kimliği var?

Ama sayının kendisi size kimlik bilgisi veremez. Önce onu bir "kimlik kartına" koymanız gerekir.

### Java'da Primitive vs Object Farkı

```java
public class TipKontrolu {
    public static void main(String[] args) {
        // Primitive (Ham veri - kimlik kartı yok)
        int yas = 25;
        double maas = 5000.50;
        boolean aktif = true;
        
        // Bu ÇALIŞMAZ - primitive'lerin kimlik kartı yok
        // System.out.println(yas.getClass());    // HATA!
        // System.out.println(maas.getClass());   // HATA!
        // System.out.println(aktif.getClass());  // HATA!
        
        // Object (Kimlik kartı olan veri)
        String isim = "Ali";
        Integer yasObject = 25;  // Integer wrapper class
        
        // Bu ÇALIŞIR - object'lerin kimlik kartı var
        System.out.println(isim.getClass().getSimpleName());    // String
        System.out.println(yasObject.getClass().getSimpleName()); // Integer
        
        // Primitive'i Object'e çevirerek kimlik kartı verelim
        System.out.println("=== PRİMİTİVE'LERİ OBJECT'E ÇEVİRME ===");
        
        // Manuel casting (kimlik kartı verme)
        Object yasKimlikli = (Object) yas;
        Object maasKimlikli = (Object) maas;
        Object aktifKimlikli = (Object) aktif;
        
        // Şimdi kimlik bilgilerine erişebiliriz
        System.out.println("yas'ın tipi: " + yasKimlikli.getClass().getSimpleName());
        System.out.println("maas'ın tipi: " + maasKimlikli.getClass().getSimpleName());
        System.out.println("aktif'in tipi: " + aktifKimlikli.getClass().getSimpleName());
        
        // Tek satırda yapılan işlem açıklaması:
        System.out.println("\n=== TEK SATIRDA YAPILAN İŞLEM ===");
        System.out.println("yas tipi: " + ((Object)yas).getClass().getSimpleName());
        
        // Adım adım açıklama:
        // 1. (Object)yas        → yas'ı Object'e cast et (kimlik kartı ver)
        // 2. .getClass()        → Kimlik kartından sınıf bilgisini al
        // 3. .getSimpleName()   → Sınıf adının sadece basit kısmını al
    }
}
```

### Autoboxing Açıklaması

Java otomatik olarak primitive'leri wrapper class'lara çevirir:

```java
public class AutoboxingOrnegi {
    public static void main(String[] args) {
        // Manuel boxing (eski yöntem)
        int primitiveInt = 42;
        Integer wrapperInt = Integer.valueOf(primitiveInt);  // int → Integer
        
        // Autoboxing (otomatik - modern yöntem)
        Integer otomatikWrapper = primitiveInt;  // Java otomatik çevirir
        
        // Unboxing (wrapper → primitive)
        int geriPrimitive = otomatikWrapper;  // Integer → int
        
        System.out.println("Primitive: " + primitiveInt);
        System.out.println("Wrapper: " + wrapperInt.getClass().getSimpleName());
        System.out.println("Otomatik wrapper: " + otomatikWrapper.getClass().getSimpleName());
        
        // Object casting ile tip kontrolü
        System.out.println("Primitive'in wrapper tipi: " + ((Object)primitiveInt).getClass().getSimpleName());
    }
}
```

### Gerçek Hayat Kullanım Alanı

```java
public class GenericMethod {
    // Generic method - herhangi bir Object alabilir
    public static void tipiBilgisiVer(Object veri) {
        System.out.println("Veri: " + veri);
        System.out.println("Tip: " + veri.getClass().getSimpleName());
        System.out.println("Paket: " + veri.getClass().getPackage().getName());
        System.out.println("---");
    }
    
    public static void main(String[] args) {
        // Farklı primitive'leri test et
        tipiBilgisiVer(25);        // int → Integer (autoboxing)
        tipiBilgisiVer(3.14);      // double → Double (autoboxing)
        tipiBilgisiVer(true);      // boolean → Boolean (autoboxing)
        tipiBilgisiVer("Ali");     // String (zaten object)
        
        // Array test
        int[] sayilar = {1, 2, 3};
        tipiBilgisiVer(sayilar);   // Array objesi
    }
}
```

---

## Soru 3: Type Conversion (Tip Dönüşümü)

### Günlük Hayat Örneği: Para Bozdurma

Tip dönüşümü, para bozdurma gibidir:

**Implicit (Otomatik) Conversion:** Küçük parayı büyüğe bozdurma
- 1 TL'yi 100 kuruşa çevirmek → Değer kaybı yok, otomatik
- byte'ı int'e çevirmek → Değer kaybı yok, otomatik

**Explicit (Manuel) Conversion:** Büyük parayı küçüğe bozdurma  
- 150 kuruşu 1 TL 50 kuruşa çevirmek → Dikkat gerekir, manuel
- double'ı int'e çevirmek → Ondalık kısmı kaybolur, manuel

### Java'da Type Conversion Örnekleri

```java
public class TipDonusumu {
    public static void main(String[] args) {
        // === IMPLİCİT CONVERSION (Otomatik - Güvenli) ===
        System.out.println("=== OTOMATİK DÖNÜŞÜM ===");
        
        // Küçük → Büyük (Değer kaybı yok)
        byte kucukSayi = 10;
        int ortaSayi = kucukSayi;        // byte → int (otomatik)
        long buyukSayi = ortaSayi;       // int → long (otomatik)
        double ondalikSayi = buyukSayi;  // long → double (otomatik)
        
        System.out.println("byte: " + kucukSayi);
        System.out.println("int: " + ortaSayi);
        System.out.println("long: " + buyukSayi);
        System.out.println("double: " + ondalikSayi);
        
        // === EXPLİCİT CONVERSION (Manuel - Riskli) ===
        System.out.println("\n=== MANUEL DÖNÜŞÜM ===");
        
        // Büyük → Küçük (Değer kaybı olabilir)
        double buyukOndalik = 123.789;
        int kesilmisInt = (int) buyukOndalik;     // 123 (ondalık kesilir)
        byte kesilenByte = (byte) kesilmisInt;    // 123
        
        System.out.println("Orijinal double: " + buyukOndalik);
        System.out.println("int'e cast: " + kesilmisInt);
        System.out.println("byte'a cast: " + kesilenByte);
        
        // Overflow durumu
        int buyukIntDegeri = 300;
        byte overflowByte = (byte) buyukIntDegeri; // 44 (300 - 256 = 44)
        System.out.println("Overflow örneği - 300 → byte: " + overflowByte);
        
        // === STRING DÖNÜŞÜMÜ ===
        System.out.println("\n=== STRING DÖNÜŞÜMÜ ===");
        
        // String → Number (Manuel parse gerekli)
        String sayiString = "123";
        String ondalikString = "456.78";
        
        int parsedInt = Integer.parseInt(sayiString);
        double parsedDouble = Double.parseDouble(ondalikString);
        
        System.out.println("String'den int: " + parsedInt);
        System.out.println("String'den double: " + parsedDouble);
        
        // Number → String
        int sayi = 789;
        String sayiKelime = String.valueOf(sayi);
        String sayiKelime2 = Integer.toString(sayi);
        
        System.out.println("int'den String (valueOf): " + sayiKelime);
        System.out.println("int'den String (toString): " + sayiKelime2);
        
        // === GÜVENLE DÖNÜŞÜM ===
        System.out.println("\n=== GÜVENLİ DÖNÜŞÜM ===");
        
        String kullaniciGirdisi = "123abc"; // Geçersiz sayı
        
        try {
            int gecerliSayi = Integer.parseInt(kullaniciGirdisi);
            System.out.println("Geçerli sayı: " + gecerliSayi);
        } catch (NumberFormatException e) {
            System.out.println("Hata: '" + kullaniciGirdisi + "' geçerli bir sayı değil!");
        }
    }
}
```

### Laravel vs Java Karşılaştırması

```php
// PHP - Laravel'de tip dönüşümü (gevşek)
$sayiString = "123";
$sayi = 456;

// Otomatik dönüşüm
$sonuc1 = $sayiString + $sayi;  // "123" + 456 = 579 (otomatik)
$sonuc2 = $sayiString . $sayi;  // "123" . 456 = "123456" (concat)

// Manuel dönüşüm
$intDeger = (int) $sayiString;    // 123
$floatDeger = (float) "123.45";   // 123.45
$stringDeger = (string) $sayi;    // "456"

echo "PHP otomatik: " . $sonuc1 . "\n";
echo "PHP manuel int: " . $intDeger . "\n";
```

```java
// Java'da aynı işlemler (sıkı tip kontrolü)
String sayiString = "123";
int sayi = 456;

// Otomatik dönüşüm YOK - compile hatası
// int sonuc1 = sayiString + sayi; // HATA!

// Manuel dönüşüm GEREKLİ
int parsedString = Integer.parseInt(sayiString);
int sonuc1 = parsedString + sayi;  // 579

String stringDeger = String.valueOf(sayi);     // "456"
String concat = sayiString + stringDeger;      // "123456"

System.out.println("Java manuel: " + sonuc1);
System.out.println("Java string: " + stringDeger);
```

---

## Soru 4: Memory Yönetimi

### Günlük Hayat Örneği: Ofis Binası

Java'nın memory yapısını bir ofis binası gibi düşünelim:

**STACK (Yığın) - Bireysel Masalar:**
- Her çalışanın kendi masası (method'lar)
- Masada çalıştığı dosyalar (local değişkenler)
- Masa küçük, hızlı erişim
- Çalışan gidince masa temizlenir

**HEAP (Yığın) - Depo/Arşiv:**
- Büyük ortak depo alanı (nesneler)
- Şirketin tüm dosyaları (objects, arrays)
- Büyük ama yavaş erişim
- Temizlik görevlisi periyodik temizler (Garbage Collector)

**METHOD AREA - Şirket Yönetim Katı:**
- Şirket politikaları (static değişkenler)
- Şirket yapısı bilgileri (class definitions)
- Herkes erişebilir ama değişiklik nadir

### Java Memory Örnekleri

```java
public class MemoryYonetimi {
    // METHOD AREA'da saklanır (static)
    private static int sirketCalisanSayisi = 0;
    private static String sirketAdi = "TechCorp";
    
    // Instance variables - HEAP'te saklanır (nesne oluşturulduğunda)
    private String calisanAdi;
    private int calisanID;
    
    public MemoryYonetimi(String ad, int id) {
        // Constructor parametreleri - STACK'te
        this.calisanAdi = ad;    // HEAP'teki nesnenin field'ına atama
        this.calisanID = id;     // HEAP'teki nesnenin field'ına atama
        sirketCalisanSayisi++;   // METHOD AREA'daki static değişkeni artır
    }
    
    public void maasHesapla() {
        // Local variables - STACK'te saklanır
        double temelMaas = 5000.0;           // STACK
        double performansBonus = 1000.0;     // STACK
        boolean zamliMi = true;              // STACK
        
        // String literal - HEAP'te (String Pool'da)
        String departman = "IT";             // STACK'te referans, HEAP'te nesne
        
        // Array - HEAP'te, referans STACK'te
        double[] maasGecmisi = {4000, 4500, 5000}; // STACK'te referans, HEAP'te array
        
        // Block scope
        if (zamliMi) {
            double ekstraZam = 500.0;        // STACK (sadece bu blokta)
            double toplamMaas = temelMaas + performansBonus + ekstraZam; // STACK
            
            System.out.println("Toplam maaş: " + toplamMaas);
            // ekstraZam ve toplamMaas burada yok olur
        }
        
        // System.out.println(ekstraZam); // HATA! Scope dışında
        
        // Method sonunda tüm local değişkenler STACK'ten silinir
        System.out.println("Çalışan: " + calisanAdi + " (ID: " + calisanID + ")");
    }
    
    public static void main(String[] args) {
        // main method'u da STACK'te çalışır
        
        // Local variables - STACK'te
        int toplamCalisan = 3;               // STACK
        String projeAdi = "E-Ticaret";       // STACK'te referans, HEAP'te String
        
        // Object creation - HEAP'te
        MemoryYonetimi calisan1 = new MemoryYonetimi("Ali Veli", 101);
        MemoryYonetimi calisan2 = new MemoryYonetimi("Ayşe Demir", 102);
        MemoryYonetimi calisan3 = new MemoryYonetimi("Mehmet Kaya", 103);
        
        // Method çağrıları - her biri yeni STACK frame oluşturur
        calisan1.maasHesapla();
        calisan2.maasHesapla();
        calisan3.maasHesapla();
        
        // Static değişkene erişim - METHOD AREA'dan
        System.out.println("Toplam çalışan: " + sirketCalisanSayisi);
        System.out.println("Şirket adı: " + sirketAdi);
    }
}
```

### Memory Alanlarının Detaylı Açıklaması

```java
public class DetayliMemoryOrnegi {
    public static void ornekMetod() {
        // === STACK MEMORY ===
        // - Method parametreleri
        // - Local değişkenler  
        // - Method çağrı bilgileri
        // - Primitive değişkenler direkt değerleri
        // - Object referansları (adres bilgisi)
        
        int yas = 25;                    // STACK: direkt değer
        String isim = "Ali";             // STACK: referans, HEAP: "Ali" String nesnesi
        double maas = 5000.50;           // STACK: direkt değer
        boolean aktif = true;            // STACK: direkt değer
        
        // === HEAP MEMORY ===
        // - Tüm nesneler (objects)
        // - Arrays
        // - String literals
        // - Instance variables
        
        StringBuilder sb = new StringBuilder("Merhaba"); // HEAP: StringBuilder nesnesi
        int[] sayilar = {1, 2, 3, 4, 5};                // HEAP: array nesnesi
        String[] isimler = {"Ali", "Ayşe", "Mehmet"};   // HEAP: array + String nesneleri
        
        // === METHOD AREA (METASPACE) ===
        // - Class definitions
        // - Static değişkenler
        // - Method kodları
        // - Constant Pool
        
        System.out.println("Memory alanları gösterildi");
    }
}
```

### Memory Kullanımı Tablosu

| Değişken Türü | Konum | Açıklama | Örnek |
|---------------|-------|----------|-------|
| `int yas = 25;` | **STACK** | Primitive, local değişken | Method içinde tanımlı |
| `static int calisanSayisi = 0;` | **METHOD AREA** | Static değişken | Sınıf seviyesi |
| `String isim = "Ali";` | **STACK (ref) + HEAP (obj)** | Referans STACK'te, nesne HEAP'te | Object reference |
| Method içi local değişkenler | **STACK** | Method çağrısı süresince | Method bitince silinir |

---

## Soru 5: Java vs PHP (Laravel) Temel Farkları

### Variable Declaration Farkları

#### PHP (Laravel) - Dynamic Typing
```php
// Tip belirtmeye gerek yok
$isim = "Ali";              // PHP otomatik string olarak algılar
$yas = 25;                  // PHP otomatik integer olarak algılar
$maas = 5000.50;            // PHP otomatik float olarak algılar
$aktif = true;              // PHP otomatik boolean olarak algılar

// Aynı değişken farklı tip alabilir
$deger = "Merhaba";         // string
$deger = 42;                // integer (aynı değişken)
$deger = true;              // boolean (aynı değişken)

// Laravel'de örnek
$user = User::find(1);      // Model instance
$user = "Ali Veli";         // String (aynı değişken farklı tip)
```

#### Java - Static Typing
```java
// Tip belirtmek ZORUNLU
String isim = "Ali";        // String type açık belirtilmeli
int yas = 25;               // int type açık belirtilmeli
double maas = 5000.50;      // double type açık belirtilmeli
boolean aktif = true;       // boolean type açık belirtilmeli

// Tip değiştirilemez
String deger = "Merhaba";   // String
// deger = 42;              // HATA! String sadece String alabilir
// deger = true;            // HATA! Tip uyumsuzluğu

// Java'da doğru yaklaşım
String stringDeger = "Merhaba";
int intDeger = 42;
boolean booleanDeger = true;
```

### Type Safety Farkları

#### PHP - Gevşek Tip Kontrolü
```php
// Otomatik tip dönüşümü
$sayi1 = "10";              // string
$sayi2 = 20;                // integer
$sonuc = $sayi1 + $sayi2;   // 30 (PHP otomatik "10"ı integera çevirir)

// Laravel Route'da
Route::get('/user/{id}', function($id) {
    // $id string olarak gelir ama işlem yapabiliriz
    $userId = $id + 1;      // PHP otomatik dönüştürür
    return User::find($userId);
});

// Weak typing sorunu
$toplam = "5 elma" + "3 portakal";  // 8 (PHP sadece sayıları alır)
```

#### Java - Sıkı Tip Kontrolü
```java
// Manuel tip dönüşümü zorunlu
String sayi1 = "10";        // String
int sayi2 = 20;             // int
// int sonuc = sayi1 + sayi2; // HATA! Tip uyumsuzluğu

// Doğru yaklaşım
int parsedSayi1 = Integer.parseInt(sayi1);
int sonuc = parsedSayi1 + sayi2;  // 30

// Spring Boot'ta örnek
@GetMapping("/user/{id}")
public User getUser(@PathVariable int id) {  // id otomatik integer olur
    int nextUserId = id + 1;  // Güvenli işlem
    return userRepository.findById(nextUserId);
}

// Compile-time hata kontrolü
// String toplam = "5 elma" + 3; // HATA! String + int yapılamaz
String toplam = "5 elma" + String.valueOf(3); // "5 elma3"
```

### Memory Management Farkları

#### PHP Memory Management
```php
// PHP - Reference counting + Cycle collector
$user = new User();         // Memory'ye nesne oluşturur
$user->name = "Ali";
$user->email = "ali@test.com";

// Değişkeni null yapınca hemen temizlenir
$user = null;               // Reference count 0 olur, hemen temizlenir

// Laravel'de
$users = User::all();       // Collection oluşturur
$users = null;              // PHP hemen temizler

// Circular reference sorunu (PHP 5.3+ çözülür)
$a = new stdClass();
$b = new stdClass();
$a->b = $b;
$b->a = $a;                 // Circular reference
$a = $b = null;             // Cycle collector temizler
```

#### Java Memory Management
```java
// Java - Garbage Collection (Mark and Sweep)
User user = new User();     // Heap'te nesne oluşturur
user.setName("Ali");
user.setEmail("ali@test.com");

// Değişkeni null yapınca hemen temizlenmez
user = null;                // Sadece reference silinir
// Nesne hala Heap'te durur, GC çalışana kadar

// Garbage Collection belirsiz zamanda çalışır
System.gc();                // GC'yi çalıştırmaya teşvik eder (garanti değil)

// Memory leak örneği
List<User> users = new ArrayList<>();
for (int i = 0; i < 1000000; i++) {
    users.add(new User("User" + i));  // Memory'de birikir
}
// users = null; // Bu satır olmazsa memory leak!
```

### Gerçek Dünya Karşılaştırması

#### PHP (Laravel) - Web İsteği İşleme
```php
// routes/web.php
Route::post('/calculate-salary', function(Request $request) {
    // PHP otomatik tip dön