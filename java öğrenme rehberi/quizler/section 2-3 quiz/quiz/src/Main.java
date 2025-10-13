
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tüm soruları array'de tut
        Soru[] sorular = new Soru[15];

        // Soruları oluştur
        sorular[0] = new Soru("Türkiye'nin başkenti neresidir?", "İstanbul", "Ankara", "İzmir", "Antalya", "b");
        sorular[1] = new Soru("2 + 2 kaç eder?", "3", "4", "5", "6", "b");
        sorular[2] = new Soru("Dünyanın en büyük okyanusu hangisidir?", "Atlantik Okyanusu", "Hint Okyanusu", "Pasifik Okyanusu", "Arktik Okyanusu", "c");
        sorular[3] = new Soru("Python bir programlama dili midir?", "Hayır", "Evet", "Sadece bir kütüphane", "Web tarayıcısı", "b");
        sorular[4] = new Soru("Güneş sistemimizde kaç gezegen vardır?", "8", "9", "7", "10", "a");
        sorular[5] = new Soru("Hangi hayvan 'dünyanın kralı' olarak bilinir?", "Aslan", "Kaplan", "Fil", "Kartal", "a");
        sorular[6] = new Soru("Matematikte π (pi) neyi temsil eder?", "Karekök", "Çevrenin çapına oranı", "Bir dairenin alanı", "Logaritma", "b");
        sorular[7] = new Soru("İlk bilgisayar virüsü ne zaman yazılmıştır?", "1986", "1970", "1990", "2000", "a");
        sorular[8] = new Soru("En uzun nehir hangisidir?", "Nil Nehri", "Amazon Nehri", "Mississippi Nehri", "Yangtze Nehri", "a");
        sorular[9] = new Soru("Java programlama dilinin yaratıcısı kimdir?", "James Gosling", "Linus Torvalds", "Bill Gates", "Guido van Rossum", "a");
        sorular[10] = new Soru("Bir yılda kaç gün vardır?", "365", "366", "360", "364", "a");
        sorular[11] = new Soru("Einstein'ın ünlü denklemi nedir?", "E=mc²", "F=ma", "V=IR", "PV=nRT", "a");
        sorular[12] = new Soru("En yüksek dağ hangisidir?", "Everest", "K2", "Kangchenjunga", "Lhotse", "a");
        sorular[13] = new Soru("HTML neyin kısaltmasıdır?", "HyperText Markup Language", "High Tech Modern Language", "Home Tool Markup Language", "Hyper Transfer Markup Language", "a");
        sorular[14] = new Soru("Ay, Dünya'dan ne kadar uzakta bulunur?", "384.400 km", "150 milyon km", "1.5 milyon km", "100.000 km", "a");

        int dogruCevapSayisi = 0;
        int yanlisCevapSayisi = 0;
        // HOŞGELDİNİZ mesajı
        System.out.println("HOŞGELDİNİZ");
        System.out.println("\nKaç soru cevaplamak istiyorsunuz? :");
        int adet = scanner.nextInt();
        scanner.nextLine();
        if (adet <= 15 && adet >= 1) {
            for (int i = 0; i < adet; i++) {
                System.out.println("Soru " + (i + 1) + ":" + sorular[i].soruMetni + "\nA :" + sorular[i].sikA + "\nB :" + sorular[i].sikB + "\nC :" + sorular[i].sikC + "\nD :" + sorular[i].sikD);
                System.out.print("Cevabınız (A/B/C/D): ");
                String cevap = scanner.nextLine().toUpperCase();
                String dogruSik = sorular[i].dogruCevap.toUpperCase();
                if (cevap.equals(dogruSik)) {
                    System.out.println("DOĞRU");
                    dogruCevapSayisi ++;

                } else {
                    System.out.println("YANLIŞ");
                    yanlisCevapSayisi ++;
                }
            }
            System.out.println("Doğru Cevap Sayınız :"+ dogruCevapSayisi);
            System.out.println("Yanlış Cevap Sayınız :"+ yanlisCevapSayisi);

        } else {
            System.out.println("Geçersiz Değer , değer 1 ve 15 arasında olmalıdır.");
        }
        scanner.close();
    }
}