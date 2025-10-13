// Calculator.java dosyası (src/main/java klasörüne kaydet)

// IMPORT STATEMENT - Laravel'de "use" komutuna benzer
// Laravel'de: use App\Services\InputService; gibi
import java.util.Scanner;  // Scanner class'ını kullanabilmek için import ediyoruz

// CLASS DEFINITION - Laravel'de class Calculator gibi
public class Calculator {

    // INSTANCE VARIABLE (Sınıf değişkeni) 
    // Laravel'de: private $scanner; gibi bir property tanımlamak
    // Bu değişken class'ın tüm methodlarında kullanılabilir
    private Scanner scanner;

    // CONSTRUCTOR (Yapıcı Method)
    // Laravel'de: public function __construct() { ... } ile aynı
    // Class'tan yeni bir nesne oluşturulduğunda otomatik çalışır
    // new Calculator() dediğimizde bu method çalışır
    public Calculator() {
        // "this" keyword'ü Laravel'de $this ile aynı
        // Mevcut nesnenin kendi özelliklerine erişmek için kullanılır
        // Laravel'de: $this->scanner = new InputService(); gibi
        this.scanner = new Scanner(System.in);  // Klavyeden giriş almak için Scanner nesnesi
    }

    // PUBLIC METHOD - Laravel'de public function start() gibi
    // Dışarıdan erişilebilir method (API endpoint gibi düşün)
    public void start() {
        // BOOLEAN VARİABLE - Laravel'de $running = true; gibi
        boolean running = true;

        // WHILE LOOP - Laravel'de while($running) { ... } ile aynı
        while (running) {
            // CONSOLE OUTPUT - Laravel'de echo veya dd() gibi
            // System.out.println() Laravel'de echo "\n=== HESAP MAKİNESİ ===\n"; gibi
            System.out.println("\n=== HESAP MAKİNESİ ===");
            System.out.println("1. Toplama");
            System.out.println("2. Çıkarma");
            System.out.println("3. Çarpma");
            System.out.println("4. Bölme");
            System.out.println("5. Çıkış");
            System.out.print("Seçiminiz: ");  // println yerine print (satır sonu yok)

            // USER INPUT - Laravel'de $choice = (int)$request->input('choice'); gibi
            // scanner.nextInt() klavyeden integer değer okur
            int choice = scanner.nextInt();

            // EARLY RETURN PATTERN - Laravel'de if kondition return response(); gibi
            if (choice == 5) {
                running = false;  // Loop'u sonlandırmak için flag'i false yap
                System.out.println("Çıkış yapılıyor...");
                continue;  // Laravel'de return; gibi, loop'un geri kalanını atla
            }

            // KULLANICI GİRİŞİ ALMA - Laravel'de validation'dan sonra input alma gibi
            System.out.print("Birinci sayı: ");
            double num1 = scanner.nextDouble();  // Laravel'de (float)$request->input('num1');

            System.out.print("İkinci sayı: ");
            double num2 = scanner.nextDouble();  // Laravel'de (float)$request->input('num2');

            // PRIVATE METHOD ÇAĞIRMA - Laravel'de $this->performOperation() gibi
            // Başka bir method'u çağırıyoruz (service method pattern)
            double result = performOperation(choice, num1, num2);

            // NaN CHECK - Laravel'de null check gibi
            // Double.isNaN() Laravel'de is_null($result) ile benzer
            // NaN = "Not a Number", geçersiz matematiksel işlem sonucu
            if (!Double.isNaN(result)) {  // ! işareti Laravel'de ! is_null() gibi
                System.out.println("Sonuç: " + result);
            }
        }

        // RESOURCE CLEANUP - Laravel'de otomatik, Java'da manuel
        // Laravel'de connection'lar otomatik kapanır, Java'da manuel kapatmamız gerekir
        scanner.close();  // Memory leak'i önlemek için Scanner'ı kapat
    }

    // PRIVATE METHOD - Laravel'de private function performOperation() gibi
    // Sadece bu class içinden erişilebilir (internal business logic)
    // Laravel'de service class'larda sıkça kullandığın pattern
    private double performOperation(int operation, double num1, double num2) {

        // SWITCH STATEMENT - Laravel'de switch case veya match expression gibi
        switch (operation) {
            case 1:
                return num1 + num2;  // Laravel'de return $num1 + $num2;

            case 2:
                return num1 - num2;

            case 3:
                return num1 * num2;

            case 4:
                // VALIDATION CHECK - Laravel'de validation rule gibi
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    // ERROR HANDLING - Laravel'de throw new Exception() gibi
                    System.out.println("Hata: Sıfıra bölme!");
                    // Double.NaN Laravel'de null return etmek gibi (error state)
                    return Double.NaN;  // "Not a Number" - geçersiz sonuç göstergesi
                }

            default:
                // DEFAULT CASE - Laravel'de default case veya else gibi
                System.out.println("Geçersiz işlem!");
                return Double.NaN;  // Laravel'de null veya exception
        }
    }

    // MAIN METHOD - Laravel'de routes/web.php'deki route tanımı gibi
    // Java uygulamasının giriş noktası (entry point)
    // Laravel'de Route::get('/', [CalculatorController::class, 'index']); gibi
    public static void main(String[] args) {
        // OBJECT INSTANTIATION - Laravel'de $calc = new Calculator(); gibi
        // Constructor'ı çağırarak yeni nesne oluştur
        Calculator calc = new Calculator();

        // METHOD CALL - Laravel'de $calc->start(); gibi
        calc.start();  // Calculator'ı başlat
    }
}