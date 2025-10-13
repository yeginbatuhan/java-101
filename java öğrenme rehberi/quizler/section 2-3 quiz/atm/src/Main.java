//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;
public class Main {
    private static final int PARA_YATIR = 1;
    private static final int PARA_CEK = 2;
    private static final int BAKIYE_SORGULA = 3;
    private static final int ISLEM_GECMISI = 4;
    private static final int CIKIS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Customer[] customers = new Customer[2];

        customers[0] = new Customer("27385598434", "1234", "Batuhan", "Yegin", 0, 0);
        customers[1] = new Customer("47107561034", "2344", "Hatice Nur", "KAYA", 0, 0);
        System.out.println("******HOŞGELDİNİZ*******");
        System.out.println("\nLütfen TC Kimlik Giriniz");
        long tcno = scanner.nextLong();
        scanner.nextLine();
        String tcnoCover = Long.toString(tcno);
        for (int i = 0; i < customers.length; i++) {
            if (tcnoCover.equals(customers[i].tcno)) {
                System.out.println("\nMerhaba " + customers[i].ad + " " + customers[i].soyad + "Lütfen Şifrenizi Giriniz");
                int parola = scanner.nextInt();
                scanner.nextLine();
                String parolaCover = Integer.toString(parola);
                if (parolaCover.equals(customers[i].parola)) {
                    boolean devam = true;
                    while (devam) {
                        System.out.println("\nŞifre Doğru Hangi İşlemi Yapmak İstiyorsunuz ?");
                        System.out.println(PARA_YATIR + " - Para Yatır");
                        System.out.println(PARA_CEK + " - Para Çek");
                        System.out.println(BAKIYE_SORGULA + " - Bakiye Sorgula");
                        System.out.println(ISLEM_GECMISI + " - İşlem Geçmişi");
                        System.out.println(CIKIS + " - Çıkış");
                        int islemNo = scanner.nextInt();
                        scanner.nextLine();
                        switch (islemNo) {
                            case PARA_YATIR:
                                System.out.println("\nGüncel Bakiye :" + customers[i].bakiye);
                                System.out.print("\nYatırmak istediğiniz tutarı giriniz: ");
                                int yatirilacakTutar = scanner.nextInt();
                                scanner.nextLine();
                                customers[i].bakiye += yatirilacakTutar;

                                System.out.println("\nGüncel Bakiye :" + customers[i].bakiye);
                                customers[i].islemGecmisi++;
                                break;

                            case PARA_CEK:
                                System.out.println("\nGüncel Bakiye :" + customers[i].bakiye);
                                System.out.print("\nÇekmek istediğiniz tutarı giriniz: ");
                                int cekilecekTutar = scanner.nextInt();
                                scanner.nextLine();
                                if (cekilecekTutar <= customers[i].bakiye && cekilecekTutar >= 0) {
                                    customers[i].bakiye -= cekilecekTutar;
                                    System.out.println("\nGüncel Bakiye :" + customers[i].bakiye);
                                    customers[i].islemGecmisi++;
                                } else {
                                    System.out.println("Geçersiz İşlem");
                                }
                                break;

                            case BAKIYE_SORGULA:
                                System.out.println("\nGüncel Bakiye :" + customers[i].bakiye);
                                break;

                            case ISLEM_GECMISI:
                                System.out.println("\nİslem Geçmiş Adeti :" + customers[i].islemGecmisi);
                                break;

                            case CIKIS:
                                System.out.println("İyi günler dileriz!");
                                devam = false;
                                break;

                            default:
                                System.out.println("Geçersiz işlem numarası!");
                                break;
                        }

                    }

                }


            }
        }

        scanner.close();
    }
}