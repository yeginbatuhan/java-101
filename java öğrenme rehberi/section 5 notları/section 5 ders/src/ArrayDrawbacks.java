public class ArrayDrawbacks {

    /**
     * SORUN 1: Sabit Boyut - Değiştirilemez
     */
    public static void problem1_FixedSize() {
        System.out.println("=== SORUN 1: SABİT BOYUT ===\n");

        // 3 elemanlı array oluşturduk
        int[] numbers = new int[3];
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;

        System.out.println("İlk array uzunluğu: " + numbers.length);
        System.out.println("Elemanlar: " + numbers[0] + ", " + numbers[1] + ", " + numbers[2]);

        // PROBLEM: 4. eleman eklemek istiyoruz ama YAPAMIYORUZ!
        // numbers[3] = 40; // ArrayIndexOutOfBoundsException hatası verir!

        System.out.println("\nYeni eleman eklemek için YENİ ARRAY oluşturmalıyız:");

        // Yeni, daha büyük bir array oluştur
        int[] newNumbers = new int[4];

        // Eski array'in elemanlarını kopyala
        for(int i = 0; i < numbers.length; i++) {
            newNumbers[i] = numbers[i];
        }

        // Yeni elemanı ekle
        newNumbers[3] = 40;

        System.out.println("Yeni array uzunluğu: " + newNumbers.length);
        System.out.print("Yeni elemanlar: ");
        for(int num : newNumbers) {
            System.out.print(num + " ");
        }
        System.out.println("\n");

        // Bu çok verimsiz bir yöntem!
        System.out.println("⚠️ SORUN: Her eleman eklemek için yeni array oluşturmak gerekiyor!");
        System.out.println("⚠️ Bu çok yavaş ve bellek israfıdır!\n");
    }

    /**
     * SORUN 2: Eleman Silme Zorluğu
     */
    public static void problem2_RemovalDifficulty() {
        System.out.println("=== SORUN 2: ELEMAN SİLME ZORLUĞU ===\n");

        String[] students = {"Ali", "Veli", "Ayşe", "Mehmet", "Zeynep"};

        System.out.println("Başlangıç listesi:");
        for(int i = 0; i < students.length; i++) {
            System.out.println(i + ": " + students[i]);
        }

        // PROBLEM: "Ayşe"yi (index 2) silmek istiyoruz
        System.out.println("\n'Ayşe'yi silmek istiyoruz...");

        // Yöntem 1: Null atama (kötü çözüm)
        students[2] = null;

        System.out.println("\nNull atama sonrası:");
        for(int i = 0; i < students.length; i++) {
            System.out.println(i + ": " + students[i]);
        }

        System.out.println("\n⚠️ SORUN: Null değer kaldı, array boyutu değişmedi!");
        System.out.println("⚠️ Boşluk oluştu ve bu kullanışsız!\n");

        // Yöntem 2: Kaydırma ve yeni array (doğru ama zahmetli)
        System.out.println("Doğru yöntem: Yeni array oluşturup kopyalama");

        String[] originalStudents = {"Ali", "Veli", "Ayşe", "Mehmet", "Zeynep"};
        int removeIndex = 2;

        String[] newStudents = new String[originalStudents.length - 1];

        int newIndex = 0;
        for(int i = 0; i < originalStudents.length; i++) {
            if(i != removeIndex) {
                newStudents[newIndex] = originalStudents[i];
                newIndex++;
            }
        }

        System.out.println("Yeni liste:");
        for(int i = 0; i < newStudents.length; i++) {
            System.out.println(i + ": " + newStudents[i]);
        }

        System.out.println("\n⚠️ SORUN: Tek eleman silmek için bu kadar kod yazmak gerekiyor!\n");
    }

    /**
     * SORUN 3: Tip Güvenliği Kısıtı
     */
    public static void problem3_TypeRestriction() {
        System.out.println("=== SORUN 3: TEK TİP KISITI ===\n");

        // Integer array - sadece int tutabilir
        int[] numbers = {1, 2, 3, 4, 5};

        // String array - sadece String tutabilir
        String[] names = {"Ali", "Veli", "Ayşe"};

        System.out.println("Integer array:");
        for(int num : numbers) {
            System.out.print(num + " ");
        }

        System.out.println("\n\nString array:");
        for(String name : names) {
            System.out.print(name + " ");
        }

        // PROBLEM: Karışık veri tutamıyoruz!
        System.out.println("\n\n⚠️ SORUN: Bir array'de hem sayı hem string tutamıyoruz!");

        // Çözüm: Object array (ama tip güvenliği kaybediyoruz)
        Object[] mixed = {1, "Ali", 3.14, true};

        System.out.println("\nObject array ile karışık veri:");
        for(Object obj : mixed) {
            System.out.print(obj + " (" + obj.getClass().getSimpleName() + ") ");
        }

        System.out.println("\n\n⚠️ YENİ SORUN: Object kullanınca tip kontrolü kaybettik!");
        System.out.println("⚠️ Her elemanın tipini kontrol etmek zorundayız!\n");

        // Tip kontrolü yapmak zorunda kalıyoruz
        for(Object obj : mixed) {
            if(obj instanceof Integer) {
                int num = (Integer) obj;
                System.out.println(num + " bir integer");
            } else if(obj instanceof String) {
                String str = (String) obj;
                System.out.println(str + " bir string");
            }
        }

        System.out.println();
    }

    /**
     * SORUN 4: Hazır Metot Eksikliği
     */
    public static void problem4_LackOfMethods() {
        System.out.println("=== SORUN 4: HAZIR METOT EKSİKLİĞİ ===\n");

        int[] numbers = {5, 2, 8, 1, 9, 3};

        System.out.println("Orijinal array:");
        for(int num : numbers) {
            System.out.print(num + " ");
        }

        // PROBLEM 1: Eleman aramak için manuel kod
        System.out.println("\n\nEleman aramak için manuel kod yazmalıyız:");
        int searchValue = 8;
        boolean found = false;
        int foundIndex = -1;

        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == searchValue) {
                found = true;
                foundIndex = i;
                break;
            }
        }

        if(found) {
            System.out.println(searchValue + " bulundu, index: " + foundIndex);
        } else {
            System.out.println(searchValue + " bulunamadı");
        }

        // PROBLEM 2: Sıralamak için Arrays.sort() kullanmalıyız
        System.out.println("\nSıralamak için Arrays.sort() import etmeliyiz:");
        java.util.Arrays.sort(numbers);

        System.out.print("Sıralanmış: ");
        for(int num : numbers) {
            System.out.print(num + " ");
        }

        // PROBLEM 3: Ters çevirmek için manuel kod
        System.out.println("\n\nTers çevirmek için manuel kod:");
        int[] reversed = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            reversed[i] = numbers[numbers.length - 1 - i];
        }

        System.out.print("Ters çevrilmiş: ");
        for(int num : reversed) {
            System.out.print(num + " ");
        }

        System.out.println("\n\n⚠️ SORUN: Basit işlemler için bile ekstra kod yazmak gerekiyor!");
        System.out.println("⚠️ PHP'deki array_reverse(), array_search() gibi fonksiyonlar yok!\n");
    }

    /**
     * SORUN 5: Dinamik Boyutlandırma İmkansız
     */
    public static void problem5_DynamicGrowth() {
        System.out.println("=== SORUN 5: DİNAMİK BOYUTLANDIRMA İMKANSIZ ===\n");

        // Senaryо: Kullanıcıdan sürekli input alıyoruz
        // Kaç tane input geleceğini bilmiyoruz

        System.out.println("Senaryo: Kullanıcıdan bilinmeyen sayıda input alıyoruz\n");

        // Çözüm 1: Çok büyük array oluştur (kötü çözüm)
        int[] inputs1 = new int[1000]; // Belki 1000 yeter?
        int count1 = 0;

        System.out.println("Kötü Çözüm: Çok büyük array (1000 eleman)");
        System.out.println("⚠️ Bellek israfı: Sadece 5 eleman kullansan bile 1000 yer ayrılır!\n");

        // Çözüm 2: Her seferinde yeni array oluştur (çok kötü çözüm)
        System.out.println("Daha Kötü Çözüm: Her yeni eleman için yeni array oluştur");

        int[] inputs2 = new int[1];
        inputs2[0] = 10;
        System.out.println("1. eleman eklendi");

        // 2. eleman için yeni array
        int[] temp = new int[2];
        for(int i = 0; i < inputs2.length; i++) {
            temp[i] = inputs2[i];
        }
        temp[1] = 20;
        inputs2 = temp;
        System.out.println("2. eleman eklendi");

        // 3. eleman için yine yeni array
        temp = new int[3];
        for(int i = 0; i < inputs2.length; i++) {
            temp[i] = inputs2[i];
        }
        temp[2] = 30;
        inputs2 = temp;
        System.out.println("3. eleman eklendi");

        System.out.println("\n⚠️ Her eleman eklemek için array kopyalama!");
        System.out.println("⚠️ 1000 eleman eklemek istersen 1000 kere array kopyalama!");
        System.out.println("⚠️ Bu çok yavaş ve verimsiz!\n");
    }

    /**
     * ÇÖZÜM: ArrayList kullan (bir sonraki bölümde göreceğiz)
     */
    public static void solution_ArrayList() {
        System.out.println("=== ÇÖZÜM: ARRAYLIST KULLAN ===\n");

        System.out.println("Array'lerin tüm bu sorunlarını çözmek için");
        System.out.println("Java'da ArrayList, LinkedList gibi Collections var!\n");

        System.out.println("ArrayList özellikleri:");
        System.out.println("✅ Dinamik boyut - istediğin kadar eleman ekle");
        System.out.println("✅ Kolay ekleme - add() metodu var");
        System.out.println("✅ Kolay silme - remove() metodu var");
        System.out.println("✅ Hazır metotlar - contains(), indexOf(), sort() vs.");
        System.out.println("✅ Tip güvenliği - Generic kullanımı ile");

        System.out.println("\nÖrnek ArrayList kullanımı:");
        System.out.println("ArrayList<String> list = new ArrayList<>();");
        System.out.println("list.add(\"Ali\");");
        System.out.println("list.add(\"Veli\");");
        System.out.println("list.remove(0);");
        System.out.println("list.contains(\"Ali\");");

        System.out.println("\nBunu Section 14'te detaylı göreceğiz!\n");
    }

    /**
     * Özet: Ne zaman Array, ne zaman ArrayList?
     */
    public static void summary_WhenToUseArray() {
        System.out.println("=== NE ZAMAN ARRAY, NE ZAMAN ARRAYLIST? ===\n");

        System.out.println("ARRAY KULLAN:");
        System.out.println("✅ Boyut kesin olarak belli ve değişmeyecekse");
        System.out.println("✅ Performans kritik ise (array daha hızlı)");
        System.out.println("✅ Primitive tipler için (int, double, char vs.)");
        System.out.println("✅ Multidimensional veri yapıları (matris, tablo)");

        System.out.println("\nÖrnekler:");
        System.out.println("- Satranç tahtası (8x8 sabit)");
        System.out.println("- RGB değerleri (3 eleman: kırmızı, yeşil, mavi)");
        System.out.println("- Haftanın günleri (7 gün sabit)");
        System.out.println("- Coordinate sistemi (x, y, z)");

        System.out.println("\n" + "=".repeat(50));

        System.out.println("\nARRAYLIST KULLAN:");
        System.out.println("✅ Boyut önceden belli değilse");
        System.out.println("✅ Sık sık ekleme/silme yapılacaksa");
        System.out.println("✅ Hazır metotlara ihtiyaç varsa");
        System.out.println("✅ Dinamik veri yönetimi gerekiyorsa");

        System.out.println("\nÖrnekler:");
        System.out.println("- Kullanıcı listesi (sürekli değişir)");
        System.out.println("- Alışveriş sepeti (ürünler eklenir/çıkarılır)");
        System.out.println("- Log kayıtları (sürekli büyür)");
        System.out.println("- Search sonuçları (kaç tane olacağı belli değil)");

        System.out.println();
    }

    public static void main(String[] args) {
        // Tüm sorunları görmek için hepsini çalıştır

        problem1_FixedSize();
        // problem2_RemovalDifficulty();
        // problem3_TypeRestriction();
        // problem4_LackOfMethods();
        // problem5_DynamicGrowth();
        // solution_ArrayList();
        // summary_WhenToUseArray();
    }
}
