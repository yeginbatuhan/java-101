# Section 3: Java Operators and Control Flow - Detaylı Ders Notları

## İçindekiler
1. [Operatörler (Operators)](#operatörler-operators)
2. [Kontrol Akışı (Control Flow)](#kontrol-akışı-control-flow)
3. [Döngüler (Loops)](#döngüler-loops)
4. [Gelişmiş Konular](#gelişmiş-konular)
5. [Gerçek Hayat Örnekleri](#gerçek-hayat-örnekleri)

---

## Operatörler (Operators)

### 1. Aritmetik Operatörler

Java'da matematik işlemleri yapmanızı sağlar. Laravel'de PHP ile yaptığınız hesaplamaların Java karşılığıdır.

#### Temel Operatörler
```java
// BankAccount.java - Banka hesabı örneği
public class BankAccount {
    public static void main(String[] args) {
        double balance = 1000.0;
        double deposit = 250.0;
        double withdrawal = 150.0;
        double interestRate = 0.03; // %3 faiz
        
        // Toplama: Para yatırma
        balance = balance + deposit;
        System.out.println("Para yatırdıktan sonra bakiye: " + balance); // 1250.0
        
        // Çıkarma: Para çekme
        balance = balance - withdrawal;
        System.out.println("Para çektikten sonra bakiye: " + balance); // 1100.0
        
        // Çarpma: Faiz hesaplama
        double monthlyInterest = balance * interestRate;
        System.out.println("Aylık faiz: " + monthlyInterest); // 33.0
        
        // Bölme: Günlük ortalama harcama
        double dailySpending = withdrawal / 30;
        System.out.println("Günlük ortalama: " + dailySpending); // 5.0
        
        // Mod: Kalan işlem - ATM'de kalan para kontrolü
        int atmWithdrawal = 270;
        int billDenomination = 50; // 50 TL'lik banknotlar
        int remainingAmount = atmWithdrawal % billDenomination;
        System.out.println("ATM'de verilemeyen miktar: " + remainingAmount); // 20
    }
}
```

#### Laravel Karşılaştırması
```php
// Laravel BankService
class BankService 
{
    public function calculateMonthlyInterest($balance, $rate)
    {
        return $balance * $rate; // Java: balance * interestRate
    }
    
    public function checkAtmCompatibility($amount)
    {
        $billDenomination = 50;
        $remainder = $amount % $billDenomination; // Java: amount % billDenomination
        
        return [
            'can_withdraw' => $remainder === 0,
            'max_amount' => $amount - $remainder,
            'remaining' => $remainder
        ];
    }
}
```

### 2. İlişkisel Operatörler

Değerleri karşılaştırmak için kullanılır. Laravel'de validation rules ve conditional logic'te sıkça kullanırsınız.

```java
// ShoppingCart.java - E-ticaret sepet kontrolü
public class ShoppingCart {
    public static void main(String[] args) {
        double totalAmount = 850.0;
        double freeShippingLimit = 500.0;
        int customerAge = 17;
        int legalAge = 18;
        String membershipType = "premium";
        
        // Büyüktür: Ücretsiz kargo kontrolü
        if (totalAmount > freeShippingLimit) {
            System.out.println("Ücretsiz kargo hakkınız var!");
        }
        
        // Küçüktür: Yaş kontrolü
        if (customerAge < legalAge) {
            System.out.println("Bu ürünü satın alamazsınız (yaş sınırı)");
        }
        
        // Eşittir: Üyelik tipi kontrolü (DİKKAT: String için .equals() kullan!)
        if (membershipType.equals("premium")) {
            System.out.println("Premium üye indirimi uygulandı!");
        }
        
        // Eşit değildir
        if (!membershipType.equals("basic")) {
            System.out.println("Özel kampanyalardan yararlanabilirsiniz");
        }
        
        // Büyük eşittir: Minimum sipariş kontrolü
        double minimumOrder = 100.0;
        if (totalAmount >= minimumOrder) {
            System.out.println("Minimum sipariş tutarını karşıladınız");
        }
    }
}
```

#### Laravel Karşılaştırması
```php
// Laravel ShoppingCartController
class ShoppingCartController extends Controller
{
    public function checkEligibility(Request $request)
    {
        $totalAmount = $request->total_amount;
        $customerAge = auth()->user()->age;
        $membershipType = auth()->user()->membership_type;
        
        $rules = [
            'free_shipping' => $totalAmount > 500,
            'age_restricted' => $customerAge >= 18,
            'premium_member' => $membershipType === 'premium', // PHP'de === strict comparison
            'minimum_order' => $totalAmount >= 100
        ];
        
        return response()->json($rules);
    }
}
```

### 3. Mantıksal Operatörler

Birden fazla koşulu birleştirmek için kullanılır. Laravel'de middleware ve authorization'da çok kullanırsınız.

```java
// UserPermissions.java - Kullanıcı yetki kontrolü
public class UserPermissions {
    public static void main(String[] args) {
        boolean isAdmin = false;
        boolean isManager = true;
        boolean isActive = true;
        int workExperience = 3;
        boolean hasSpecialPermission = true;
        
        // AND (&&): Her iki koşul da doğru olmalı
        if (isManager && isActive) {
            System.out.println("Manager paneline erişim izni verildi");
        }
        
        // OR (||): En az bir koşul doğru olmalı  
        if (isAdmin || (isManager && workExperience >= 2)) {
            System.out.println("Rapor sayfasına erişebilirsiniz");
        }
        
        // NOT (!): Koşulu tersine çevirir
        if (!isActive) {
            System.out.println("Hesabınız askıya alınmış");
        } else {
            System.out.println("Hesabınız aktif");
        }
        
        // Karmaşık mantık: Gerçek hayat senaryosu
        boolean canDeleteRecord = (isAdmin) || 
                                 (isManager && workExperience >= 5) || 
                                 (hasSpecialPermission && isActive);
        
        if (canDeleteRecord) {
            System.out.println("Kayıt silme yetkisine sahipsiniz");
        } else {
            System.out.println("Bu işlem için yetkiniz bulunmuyor");
        }
    }
}
```

#### Laravel Karşılaştırması
```php
// Laravel Authorization Policy
class RecordPolicy
{
    public function delete(User $user)
    {
        return $user->is_admin || 
               ($user->is_manager && $user->work_experience >= 5) ||
               ($user->has_special_permission && $user->is_active);
    }
}

// Middleware'de kullanım
class CheckPermissions
{
    public function handle($request, Closure $next)
    {
        $user = auth()->user();
        
        if ($user->is_manager && $user->is_active) {
            return $next($request);
        }
        
        return response('Unauthorized', 403);
    }
}
```

---

## Kontrol Akışı (Control Flow)

### 1. If-Else Statements

Koşullu dallanma için kullanılır. Laravel'de controller logic ve blade template'lerde sıkça kullanırsınız.

```java
// GradeCalculator.java - Not hesaplama sistemi
public class GradeCalculator {
    public static void main(String[] args) {
        int midtermScore = 75;
        int finalScore = 85;
        int homeworkAverage = 90;
        double attendance = 0.85; // %85 devam
        
        // Ağırlıklı not hesaplama
        double totalScore = (midtermScore * 0.3) + (finalScore * 0.5) + (homeworkAverage * 0.2);
        
        String letterGrade;
        String status;
        
        // Çoklu if-else: Not sistemi
        if (totalScore >= 90) {
            letterGrade = "AA";
            status = "Mükemmel";
        } else if (totalScore >= 85) {
            letterGrade = "BA";
            status = "Çok İyi";
        } else if (totalScore >= 80) {
            letterGrade = "BB";
            status = "İyi";
        } else if (totalScore >= 75) {
            letterGrade = "CB";
            status = "Orta";
        } else if (totalScore >= 60) {
            letterGrade = "CC";
            status = "Geçer";
        } else {
            letterGrade = "FF";
            status = "Başarısız";
        }
        
        // Devam koşulu kontrolü
        if (attendance < 0.7) {
            letterGrade = "FF";
            status = "Devamsızlık nedeniyle başarısız";
        }
        
        System.out.println("Toplam Puan: " + totalScore);
        System.out.println("Harf Notu: " + letterGrade);
        System.out.println("Durum: " + status);
        
        // Ternary operator: Kısa koşullu atama
        String passStatus = (totalScore >= 60 && attendance >= 0.7) ? "GEÇTİ" : "KALDI";
        System.out.println("Sonuç: " + passStatus);
    }
}
```

#### Laravel Karşılaştırması
```php
// Laravel GradeService
class GradeService
{
    public function calculateGrade($midterm, $final, $homework, $attendance)
    {
        $totalScore = ($midterm * 0.3) + ($final * 0.5) + ($homework * 0.2);
        
        if ($attendance < 0.7) {
            return [
                'letter_grade' => 'FF',
                'status' => 'Devamsızlık nedeniyle başarısız',
                'total_score' => $totalScore
            ];
        }
        
        $result = match(true) {
            $totalScore >= 90 => ['letter_grade' => 'AA', 'status' => 'Mükemmel'],
            $totalScore >= 85 => ['letter_grade' => 'BA', 'status' => 'Çok İyi'],
            $totalScore >= 80 => ['letter_grade' => 'BB', 'status' => 'İyi'],
            $totalScore >= 75 => ['letter_grade' => 'CB', 'status' => 'Orta'],
            $totalScore >= 60 => ['letter_grade' => 'CC', 'status' => 'Geçer'],
            default => ['letter_grade' => 'FF', 'status' => 'Başarısız']
        };
        
        $result['total_score'] = $totalScore;
        $result['pass_status'] = ($totalScore >= 60 && $attendance >= 0.7) ? 'GEÇTİ' : 'KALDI';
        
        return $result;
    }
}
```

### 2. Switch Statement

Çoklu koşul kontrolü için optimize edilmiş yapı. Laravel'de route handling ve state management'ta kullanırsınız.

```java
// OrderProcessor.java - Sipariş durumu yönetimi
public class OrderProcessor {
    public static void main(String[] args) {
        String orderStatus = "shipped";
        int orderId = 12345;
        
        // Klasik switch
        switch (orderStatus) {
            case "pending":
                System.out.println("Sipariş #" + orderId + " onay bekliyor");
                System.out.println("İşlem süresi: 1-2 saat");
                break;
                
            case "confirmed":
                System.out.println("Sipariş #" + orderId + " onaylandı");
                System.out.println("Hazırlanma süresi: 2-3 gün");
                break;
                
            case "preparing":
                System.out.println("Sipariş #" + orderId + " hazırlanıyor");
                System.out.println("Kargo için paketleniyor");
                break;
                
            case "shipped":
                System.out.println("Sipariş #" + orderId + " kargoya verildi");
                System.out.println("Tahmini teslimat: 1-2 gün");
                break;
                
            case "delivered":
                System.out.println("Sipariş #" + orderId + " teslim edildi");
                System.out.println("Değerlendirme yapabilirsiniz");
                break;
                
            case "cancelled":
                System.out.println("Sipariş #" + orderId + " iptal edildi");
                System.out.println("İade işlemi başlatıldı");
                break;
                
            default:
                System.out.println("Bilinmeyen sipariş durumu");
        }
        
        // Modern switch expression (Java 14+)
        String customerMessage = switch (orderStatus) {
            case "pending" -> "Siparişiniz onay bekliyor";
            case "confirmed", "preparing" -> "Siparişiniz hazırlanıyor";
            case "shipped" -> "Siparişiniz yolda";
            case "delivered" -> "Siparişiniz teslim edildi";
            case "cancelled" -> "Siparişiniz iptal edildi";
            default -> "Durum bilgisi bulunamadı";
        };
        
        System.out.println("Müşteri mesajı: " + customerMessage);
        
        // Sipariş durumuna göre müşteri eylemi
        boolean canCancel = switch (orderStatus) {
            case "pending", "confirmed" -> true;
            case "preparing", "shipped", "delivered", "cancelled" -> false;
            default -> false;
        };
        
        if (canCancel) {
            System.out.println("Siparişi iptal edebilirsiniz");
        } else {
            System.out.println("Sipariş iptal edilemez");
        }
    }
}
```

#### Laravel Karşılaştırması
```php
// Laravel OrderService
class OrderService
{
    public function getOrderInfo($orderId, $status)
    {
        $info = match($status) {
            'pending' => [
                'message' => "Sipariş #$orderId onay bekliyor",
                'duration' => '1-2 saat',
                'can_cancel' => true
            ],
            'confirmed' => [
                'message' => "Sipariş #$orderId onaylandı", 
                'duration' => '2-3 gün',
                'can_cancel' => true
            ],
            'preparing' => [
                'message' => "Sipariş #$orderId hazırlanıyor",
                'duration' => 'Kargo için paketleniyor',
                'can_cancel' => false
            ],
            'shipped' => [
                'message' => "Sipariş #$orderId kargoya verildi",
                'duration' => '1-2 gün',
                'can_cancel' => false
            ],
            'delivered' => [
                'message' => "Sipariş #$orderId teslim edildi",
                'duration' => 'Değerlendirme yapabilirsiniz',
                'can_cancel' => false
            ],
            'cancelled' => [
                'message' => "Sipariş #$orderId iptal edildi",
                'duration' => 'İade işlemi başlatıldı',
                'can_cancel' => false
            ],
            default => [
                'message' => 'Bilinmeyen sipariş durumu',
                'duration' => '',
                'can_cancel' => false
            ]
        };
        
        return $info;
    }
}

// Controller'da kullanım
public function show(Order $order)
{
    $orderInfo = $this->orderService->getOrderInfo($order->id, $order->status);
    return response()->json($orderInfo);
}
```

---

## Döngüler (Loops)

### 1. For Loop

Belirli sayıda tekrar için kullanılır. Laravel'de collection iteration ve data processing'te sıkça kullanırsınız.

```java
// SalesReport.java - Satış raporu oluşturma
public class SalesReport {
    public static void main(String[] args) {
        // Aylık satış verileri
        double[] monthlySales = {45000, 52000, 48000, 61000, 55000, 58000};
        String[] months = {"Ocak", "Şubat", "Mart", "Nisan", "Mayıs", "Haziran"};
        
        double totalSales = 0;
        double maxSales = 0;
        String bestMonth = "";
        
        System.out.println("=== AYLIK SATIŞ RAPORU ===");
        
        // Klasik for loop: Index'e ihtiyaç olduğunda
        for (int i = 0; i < monthlySales.length; i++) {
            double currentSales = monthlySales[i];
            totalSales += currentSales;
            
            // En yüksek satışı bul
            if (currentSales > maxSales) {
                maxSales = currentSales;
                bestMonth = months[i];
            }
            
            // Aylık rapor
            System.out.printf("%s: %.2f TL%n", months[i], currentSales);
            
            // Hedef karşılaştırması
            double target = 50000;
            if (currentSales >= target) {
                System.out.println("  ✓ Hedef aşıldı!");
            } else {
                double shortage = target - currentSales;
                System.out.printf("  ✗ Hedefe %.2f TL eksik%n", shortage);
            }
        }
        
        // Enhanced for loop: Sadece elemanları dolaşırken
        System.out.println("\n=== PERFORMANS ANALİZİ ===");
        double average = totalSales / monthlySales.length;
        
        for (double sales : monthlySales) {
            if (sales > average) {
                System.out.printf("%.2f TL - Ortalamanın üzerinde%n", sales);
            } else {
                System.out.printf("%.2f TL - Ortalamanın altında%n", sales);
            }
        }
        
        System.out.printf("%nToplam Satış: %.2f TL%n", totalSales);
        System.out.printf("Ortalama: %.2f TL%n", average);
        System.out.printf("En İyi Ay: %s (%.2f TL)%n", bestMonth, maxSales);
    }
}
```

#### Laravel Karşılaştırması
```php
// Laravel SalesController
class SalesController extends Controller
{
    public function generateReport()
    {
        $monthlySales = [45000, 52000, 48000, 61000, 55000, 58000];
        $months = ['Ocak', 'Şubat', 'Mart', 'Nisan', 'Mayıs', 'Haziran'];
        $target = 50000;
        
        $report = [];
        $totalSales = 0;
        $maxSales = 0;
        $bestMonth = '';
        
        // Index'li foreach (Java'daki klasik for loop gibi)
        foreach ($monthlySales as $index => $sales) {
            $totalSales += $sales;
            
            if ($sales > $maxSales) {
                $maxSales = $sales;
                $bestMonth = $months[$index];
            }
            
            $report[] = [
                'month' => $months[$index],
                'sales' => $sales,
                'target_met' => $sales >= $target,
                'shortage' => $sales < $target ? $target - $sales : 0
            ];
        }
        
        // Collection methods (Laravel'e özgü)
        $salesCollection = collect($monthlySales);
        $average = $salesCollection->average();
        
        $performanceAnalysis = $salesCollection->map(function ($sales) use ($average) {
            return [
                'sales' => $sales,
                'performance' => $sales > $average ? 'above_average' : 'below_average'
            ];
        });
        
        return response()->json([
            'monthly_report' => $report,
            'summary' => [
                'total_sales' => $totalSales,
                'average' => $average,
                'best_month' => $bestMonth,
                'max_sales' => $maxSales
            ],
            'performance_analysis' => $performanceAnalysis
        ]);
    }
}
```

### 2. While ve Do-While Loops

Koşul tabanlı tekrar için kullanılır. Laravel'de data processing ve external API calls'ta kullanırsınız.

```java
// ATMSimulator.java - ATM para çekme simülasyonu
import java.util.Scanner;

public class ATMSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double accountBalance = 5000.0;
        double dailyLimit = 2000.0;
        double dailyWithdrawn = 0.0;
        boolean sessionActive = true;
        int attemptCount = 0;
        int maxAttempts = 3;
        
        System.out.println("=== ATM'ye Hoş Geldiniz ===");
        
        // Do-while: En az bir kez çalışması gereken işlemler
        String pin;
        boolean pinCorrect = false;
        do {
            System.out.print("PIN kodunuzu giriniz: ");
            pin = scanner.nextLine();
            attemptCount++;
            
            if (pin.equals("1234")) {
                pinCorrect = true;
                System.out.println("PIN doğru. Giriş başarılı!");
            } else {
                System.out.println("Yanlış PIN! Kalan deneme: " + (maxAttempts - attemptCount));
                if (attemptCount >= maxAttempts) {
                    System.out.println("Maksimum deneme sayısına ulaştınız. Kartınız bloke edildi.");
                    return;
                }
            }
        } while (!pinCorrect && attemptCount < maxAttempts);
        
        // While loop: İşlem menüsü
        while (sessionActive) {
            System.out.println("\n=== İŞLEM MENÜSÜ ===");
            System.out.println("1. Bakiye Sorgula");
            System.out.println("2. Para Çek");
            System.out.println("3. Günlük Limit Sorgula");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminiz: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.printf("Güncel bakiyeniz: %.2f TL%n", accountBalance);
                    break;
                    
                case 2:
                    System.out.print("Çekmek istediğiniz miktar: ");
                    double withdrawAmount = scanner.nextDouble();
                    
                    // Çoklu kontrol sistemi
                    if (withdrawAmount <= 0) {
                        System.out.println("Geçersiz miktar!");
                    } else if (withdrawAmount > accountBalance) {
                        System.out.println("Yetersiz bakiye!");
                    } else if ((dailyWithdrawn + withdrawAmount) > dailyLimit) {
                        double remainingLimit = dailyLimit - dailyWithdrawn;
                        System.out.printf("Günlük limit aşıldı! Kalan limit: %.2f TL%n", remainingLimit);
                    } else if (withdrawAmount % 50 != 0) {
                        System.out.println("50 TL'nin katları şeklinde para çekebilirsiniz!");
                    } else {
                        accountBalance -= withdrawAmount;
                        dailyWithdrawn += withdrawAmount;
                        System.out.printf("%.2f TL çekildi. Kalan bakiye: %.2f TL%n", 
                                        withdrawAmount, accountBalance);
                    }
                    break;
                    
                case 3:
                    double remainingDailyLimit = dailyLimit - dailyWithdrawn;
                    System.out.printf("Günlük limit: %.2f TL%n", dailyLimit);
                    System.out.printf("Bugün çekilen: %.2f TL%n", dailyWithdrawn);
                    System.out.printf("Kalan limit: %.2f TL%n", remainingDailyLimit);
                    break;
                    
                case 4:
                    sessionActive = false;
                    System.out.println("İyi günler dileriz!");
                    break;
                    
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
        
        scanner.close();
    }
}
```

#### Laravel Karşılaştırması
```php
// Laravel ATMService
class ATMService
{
    public function authenticateUser($pin, $attemptCount = 0)
    {
        $maxAttempts = 3;
        
        // Do-while mantığı (recursive approach)
        if ($pin !== '1234') {
            $attemptCount++;
            
            if ($attemptCount >= $maxAttempts) {
                return ['success' => false, 'message' => 'Kart bloke edildi'];
            }
            
            return [
                'success' => false, 
                'message' => 'Yanlış PIN',
                'remaining_attempts' => $maxAttempts - $attemptCount
            ];
        }
        
        return ['success' => true, 'message' => 'Giriş başarılı'];
    }
    
    public function processWithdrawal($amount, $accountBalance, $dailyWithdrawn, $dailyLimit)
    {
        // Validation chain (Java'daki if-else chain gibi)
        $validations = [
            'amount_positive' => $amount > 0,
            'sufficient_balance' => $amount <= $accountBalance,
            'within_daily_limit' => ($dailyWithdrawn + $amount) <= $dailyLimit,
            'correct_denomination' => ($amount % 50) === 0
        ];
        
        foreach ($validations as $rule => $passed) {
            if (!$passed) {
                return match($rule) {
                    'amount_positive' => ['success' => false, 'message' => 'Geçersiz miktar'],
                    'sufficient_balance' => ['success' => false, 'message' => 'Yetersiz bakiye'],
                    'within_daily_limit' => ['success' => false, 'message' => 'Günlük limit aşıldı'],
                    'correct_denomination' => ['success' => false, 'message' => '50 TL katları şeklinde çekin']
                };
            }
        }
        
        return [
            'success' => true,
            'new_balance' => $accountBalance - $amount,
            'daily_withdrawn' => $dailyWithdrawn + $amount,
            'message' => "₺{$amount} çekildi"
        ];
    }
}
```

---

## Gelişmiş Konular

### 1. Break ve Continue

Döngü kontrolü için kullanılır. Laravel'de complex data processing'te sıkça kullanırsınız.

```java
// InventoryManager.java - Stok yönetimi sistemi
public class InventoryManager {
    public static void main(String[] args) {
        // Ürün kodları ve stok miktarları
        String[] productCodes = {"LAP001", "PHN002", "TAB003", "MON004", "KEY005", "MOU006"};
        int[] stockLevels = {5, 0, 15, 0, 8, 3};
        int[] minStockLevels = {10, 5, 20, 8, 12, 5};
        
        System.out.println("=== STOK KONTROL RAPORU ===");
        
        // CONTINUE örneği: Stokta olan ürünleri kontrol et
        System.out.println("\n1. Stokta Bulunan Ürünler:");
        for (int i = 0; i < productCodes.length; i++) {
            if (stockLevels[i] == 0) {
                continue; // Stokta olmayan ürünleri atla
            }
            
            System.out.printf("Ürün: %s, Stok: %d adet%n", productCodes[i], stockLevels[i]);
            
            // Minimum stok kontrolü
            if (stockLevels[i] < minStockLevels[i]) {
                int needed = minStockLevels[i] - stockLevels[i];
                System.out.printf("  ⚠️ Uyarı: %d adet sipariş edilmeli%n", needed);
            }
        }
        
        // BREAK örneği: İlk kritik stok durumunu bul
        System.out.println("\n2. Kritik Stok Analizi:");
        boolean criticalStockFound = false;
        
        for (int i = 0; i < productCodes.length; i++) {
            if (stockLevels[i] == 0) {
                System.out.printf("🚨 KRİTİK: %s ürünü tükendi!%n", productCodes[i]);
                System.out.println("Acil sipariş gerekli - İşlem durduruldu");
                criticalStockFound = true;
                break; // İlk kritik durumda döngüyü sonlandır
            }
        }
        
        if (!criticalStockFound) {
            System.out.println("✅ Kritik stok durumu tespit edilmedi");
        }
        
        // Nested loop ile BREAK/CONTINUE
        System.out.println("\n3. Kategori Bazlı Analiz:");
        String[] categories = {"Elektronik", "Aksesuar"};
        String[][] categoryProducts = {
            {"LAP001", "PHN002", "TAB003", "MON004"}, // Elektronik
            {"KEY005", "MOU006"}                       // Aksesuar
        };
        
        for (int cat = 0; cat < categories.length; cat++) {
            System.out.println("\nKategori: " + categories[cat]);
            boolean categoryHasStock = false;
            
            for (int prod = 0; prod < categoryProducts[cat].length; prod++) {
                String productCode = categoryProducts[cat][prod];
                
                // Ürün indexini bul
                int productIndex = -1;
                for (int i = 0; i < productCodes.length; i++) {
                    if (productCodes[i].equals(productCode)) {
                        productIndex = i;
                        break; // Ürün bulundu, arama döngüsünü sonlandır
                    }
                }
                
                if (productIndex == -1) {
                    continue; // Ürün bulunamadı, sonraki ürüne geç
                }
                
                int stock = stockLevels[productIndex];
                if (stock > 0) {
                    categoryHasStock = true;
                    System.out.printf("  %s: %d adet%n", productCode, stock);
                }
            }
            
            if (!categoryHasStock) {
                System.out.println("  ⚠️ Bu kategoride stokta ürün yok!");
            }
        }
    }
}
```

#### Laravel Karşılaştırması
```php
// Laravel InventoryService
class InventoryService
{
    public function generateStockReport($products)
    {
        $report = [];
        
        // Continue logic with Collection
        $inStockProducts = collect($products)
            ->filter(fn($product) => $product['stock_level'] > 0) // continue logic
            ->map(function ($product) {
                $warning = null;
                if ($product['stock_level'] < $product['min_stock']) {
                    $needed = $product['min_stock'] - $product['stock_level'];
                    $warning = "Sipariş gerekli: {$needed} adet";
                }
                
                return [
                    'code' => $product['code'],
                    'stock' => $product['stock_level'],
                    'warning' => $warning
                ];
            });
        
        // Break logic - first critical stock
        $criticalProduct = collect($products)
            ->first(fn($product) => $product['stock_level'] === 0); // first() break gibi çalışır
        
        return [
            'in_stock_products' => $inStockProducts,
            'critical_stock' => $criticalProduct,
            'has_critical' => !is_null($criticalProduct)
        ];
    }
}
```

### 2. Nested Loops (İç İçe Döngüler)

Çok boyutlu veri işleme için kullanılır. Laravel'de complex data transformation'larda kullanırsınız.

```java
// SeatReservation.java - Sinema koltuk rezervasyon sistemi
public class SeatReservation {
    public static void main(String[] args) {
        // Sinema salonu haritası (0=boş, 1=dolu, 2=rezerve)
        int[][] cinema = {
            {0, 1, 0, 0, 1, 0, 0, 1},  // A sırası
            {1, 1, 0, 0, 0, 0, 1, 1},  // B sırası  
            {0, 0, 0, 1, 1, 0, 0, 0},  // C sırası
            {0, 0, 0, 0, 0, 0, 0, 0},  // D sırası
            {1, 0, 0, 0, 0, 0, 0, 1}   // E sırası
        };
        
        char[] rowLabels = {'A', 'B', 'C', 'D', 'E'};
        
        System.out.println("=== SİNEMA KOLTUK DURUMİ ===");
        System.out.println("0=Boş  1=Dolu  2=Rezerve");
        System.out.println();
        
        // Koltuk haritasını göster
        System.out.print("   ");
        for (int col = 1; col <= cinema[0].length; col++) {
            System.out.printf("%2d ", col);
        }
        System.out.println();
        
        for (int row = 0; row < cinema.length; row++) {
            System.out.printf("%c: ", rowLabels[row]);
            for (int col = 0; col < cinema[row].length; col++) {
                System.out.printf("%2d ", cinema[row][col]);
            }
            System.out.println();
        }
        
        // Boş koltuk sayısı hesapla
        int emptySeats = 0;
        int totalSeats = 0;
        
        for (int row = 0; row < cinema.length; row++) {
            for (int col = 0; col < cinema[row].length; col++) {
                totalSeats++;
                if (cinema[row][col] == 0) {
                    emptySeats++;
                }
            }
        }
        
        System.out.printf("\nToplam koltuk: %d%n", totalSeats);
        System.out.printf("Boş koltuk: %d%n", emptySeats);
        System.out.printf("Doluluk oranı: %.1f%%%n", 
                         ((double)(totalSeats - emptySeats) / totalSeats) * 100);
        
        // En iyi boş koltuk kombinasyonlarını bul (yan yana 2 koltuk)
        System.out.println("\n=== YAN YANA BOŞ KOLTUKLAR ===");
        boolean foundPair = false;
        
        for (int row = 0; row < cinema.length; row++) {
            for (int col = 0; col < cinema[row].length - 1; col++) {
                if (cinema[row][col] == 0 && cinema[row][col + 1] == 0) {
                    System.out.printf("%c%d-%c%d çifti müsait%n", 
                                    rowLabels[row], col + 1, 
                                    rowLabels[row], col + 2);
                    foundPair = true;
                }
            }
        }
        
        if (!foundPair) {
            System.out.println("Yan yana boş koltuk bulunamadı");
        }
        
        // VIP bölge kontrol (ilk 2 sıra)
        System.out.println("\n=== VIP BÖLGE (A-B Sırası) ===");
        int vipEmpty = 0;
        
        for (int row = 0; row < 2; row++) { // Sadece ilk 2 sıra
            for (int col = 0; col < cinema[row].length; col++) {
                if (cinema[row][col] == 0) {
                    System.out.printf("VIP koltuk müsait: %c%d%n", 
                                    rowLabels[row], col + 1);
                    vipEmpty++;
                }
            }
        }
        
        System.out.printf("VIP bölgede %d boş koltuk%n", vipEmpty);
    }
}
```

#### Laravel Karşılaştırması
```php
// Laravel CinemaService
class CinemaService
{
    public function analyzeSeatMap($cinema, $rowLabels)
    {
        $analysis = [
            'seat_map' => [],
            'statistics' => [],
            'available_pairs' => [],
            'vip_seats' => []
        ];
        
        $emptySeats = 0;
        $totalSeats = 0;
        
        // Nested foreach (Java'daki nested for gibi)
        foreach ($cinema as $rowIndex => $row) {
            $rowData = [];
            
            foreach ($row as $colIndex => $seat) {
                $totalSeats++;
                if ($seat === 0) {
                    $emptySeats++;
                }
                
                $rowData[] = [
                    'position' => $rowLabels[$rowIndex] . ($colIndex + 1),
                    'status' => match($seat) {
                        0 => 'empty',
                        1 => 'occupied', 
                        2 => 'reserved'
                    }
                ];
            }
            
            $analysis['seat_map'][$rowLabels[$rowIndex]] = $rowData;
        }
        
        // Laravel Collection ile yan yana koltuk bulma
        foreach ($cinema as $rowIndex => $row) {
            $pairs = collect($row)
                ->sliding(2) // 2'li gruplar oluştur
                ->map(fn($pair, $index) => [
                    'seats' => $pair->toArray(),
                    'positions' => [
                        $rowLabels[$rowIndex] . ($index + 1),
                        $rowLabels[$rowIndex] . ($index + 2)
                    ]
                ])
                ->filter(fn($pair) => $pair['seats'][0] === 0 && $pair['seats'][1] === 0)
                ->values();
            
            $analysis['available_pairs'] = array_merge(
                $analysis['available_pairs'], 
                $pairs->toArray()
            );
        }
        
        // VIP analizi (ilk 2 sıra)
        $vipRows = array_slice($cinema, 0, 2);
        foreach ($vipRows as $rowIndex => $row) {
            foreach ($row as $colIndex => $seat) {
                if ($seat === 0) {
                    $analysis['vip_seats'][] = $rowLabels[$rowIndex] . ($colIndex + 1);
                }
            }
        }
        
        $analysis['statistics'] = [
            'total_seats' => $totalSeats,
            'empty_seats' => $emptySeats,
            'occupancy_rate' => round(($totalSeats - $emptySeats) / $totalSeats * 100, 1)
        ];
        
        return $analysis;
    }
}
```

---

## Gerçek Hayat Örnekleri

### 1. E-ticaret Sipariş Sistemi

```java
// OrderValidation.java - Sipariş doğrulama sistemi
public class OrderValidation {
    public static void main(String[] args) {
        // Müşteri bilgileri
        int customerAge = 16;
        boolean isVerified = true;
        double accountBalance = 1500.0;
        String membershipLevel = "gold";
        
        // Sipariş bilgileri
        double orderTotal = 850.0;
        String[] orderedItems = {"laptop", "mouse", "keyboard", "alcohol"};
        int[] quantities = {1, 2, 1, 1};
        double[] prices = {750.0, 25.0, 50.0, 25.0};
        boolean hasRestrictedItems = false;
        
        System.out.println("=== SİPARİŞ DOĞRULAMA SİSTEMİ ===");
        
        // Yaş kısıtlı ürün kontrolü
        String[] restrictedItems = {"alcohol", "cigarette", "knife"};
        
        for (String orderedItem : orderedItems) {
            for (String restrictedItem : restrictedItems) {
                if (orderedItem.equals(restrictedItem)) {
                    hasRestrictedItems = true;
                    System.out.println("⚠️ Yaş kısıtlı ürün tespit edildi: " + orderedItem);
                    break; // İç döngüyü sonlandır
                }
            }
        }
        
        // Sipariş validasyonu
        boolean canProceed = true;
        
        // Yaş kontrolü
        if (hasRestrictedItems && customerAge < 18) {
            System.out.println("❌ Sipariş reddedildi: Yaş kısıtı (18+)");
            canProceed = false;
        }
        
        // Hesap doğrulama kontrolü
        if (!isVerified) {
            System.out.println("❌ Sipariş reddedildi: Hesap doğrulanmamış");
            canProceed = false;
        }
        
        // Bakiye kontrolü
        if (orderTotal > accountBalance) {
            System.out.println("❌ Sipariş reddedildi: Yetersiz bakiye");
            System.out.printf("Eksik miktar: %.2f TL%n", orderTotal - accountBalance);
            canProceed = false;
        }
        
        if (canProceed) {
            // İndirim hesaplama
            double discount = 0;
            switch (membershipLevel) {
                case "bronze":
                    discount = 0.05; // %5
                    break;
                case "silver":
                    discount = 0.10; // %10
                    break;
                case "gold":
                    discount = 0.15; // %15
                    break;
                case "platinum":
                    discount = 0.20; // %20
                    break;
                default:
                    discount = 0;
            }
            
            double discountAmount = orderTotal * discount;
            double finalTotal = orderTotal - discountAmount;
            
            System.out.println("✅ Sipariş onaylandı!");
            System.out.printf("Ara toplam: %.2f TL%n", orderTotal);
            System.out.printf("%s üye indirimi (%%%.0f): -%.2f TL%n", 
                            membershipLevel.toUpperCase(), discount * 100, discountAmount);
            System.out.printf("Ödenecek tutar: %.2f TL%n", finalTotal);
            System.out.printf("Kalan bakiye: %.2f TL%n", accountBalance - finalTotal);
        }
    }
}
```

### 2. Öğrenci Not Sistemi

```java
// StudentGradeSystem.java - Kapsamlı not sistemi
public class StudentGradeSystem {
    public static void main(String[] args) {
        // Öğrenci verileri
        String[] studentNames = {"Ali Veli", "Ayşe Kaya", "Mehmet Demir", "Fatma Şahin"};
        int[][] examScores = {
            {85, 90, 78, 88}, // Ali'nin notları (4 sınav)
            {92, 85, 95, 90}, // Ayşe'nin notları
            {70, 75, 68, 72}, // Mehmet'in notları
            {88, 92, 85, 90}  // Fatma'nın notları
        };
        
        double[] weights = {0.20, 0.25, 0.25, 0.30}; // Sınav ağırlıkları
        String[] examNames = {"Vize 1", "Vize 2", "Proje", "Final"};
        
        System.out.println("=== ÖĞRENCİ NOT SİSTEMİ ===");
        
        double classTotal = 0;
        int passingStudents = 0;
        double highestGrade = 0;
        String topStudent = "";
        
        // Her öğrenci için hesaplama
        for (int student = 0; student < studentNames.length; student++) {
            System.out.printf("\n%s:%n", studentNames[student]);
            
            double weightedTotal = 0;
            boolean hasFailingGrade = false;
            
            // Ağırlıklı not hesaplama
            for (int exam = 0; exam < examScores[student].length; exam++) {
                int score = examScores[student][exam];
                double weightedScore = score * weights[exam];
                weightedTotal += weightedScore;
                
                System.out.printf("  %s: %d (Ağırlık: %%%.0f)%n", 
                                examNames[exam], score, weights[exam] * 100);
                
                // Kritik başarısızlık kontrolü (herhangi bir sınavdan 50 altı)
                if (score < 50) {
                    hasFailingGrade = true;
                }
            }
            
            // Final notu ve harf notu belirleme
            String letterGrade;
            String status;
            
            if (hasFailingGrade) {
                letterGrade = "FF";
                status = "Başarısız (Kritik not)";
            } else if (weightedTotal >= 90) {
                letterGrade = "AA";
                status = "Pekiyi";
                passingStudents++;
            } else if (weightedTotal >= 85) {
                letterGrade = "BA";
                status = "İyi";
                passingStudents++;
            } else if (weightedTotal >= 80) {
                letterGrade = "BB";
                status = "İyi";
                passingStudents++;
            } else if (weightedTotal >= 75) {
                letterGrade = "CB";
                status = "Orta";
                passingStudents++;
            } else if (weightedTotal >= 60) {
                letterGrade = "CC";
                status = "Geçer";
                passingStudents++;
            } else {
                letterGrade = "FF";
                status = "Başarısız";
            }
            
            System.out.printf("  Ağırlıklı Ortalama: %.2f%n", weightedTotal);
            System.out.printf("  Harf Notu: %s (%s)%n", letterGrade, status);
            
            classTotal += weightedTotal;
            
            // En yüksek notu takip et
            if (weightedTotal > highestGrade && !hasFailingGrade) {
                highestGrade = weightedTotal;
                topStudent = studentNames[student];
            }
        }
        
        // Sınıf istatistikleri
        double classAverage = classTotal / studentNames.length;
        double passRate = ((double) passingStudents / studentNames.length) * 100;
        
        System.out.println("\n=== SINIF İSTATİSTİKLERİ ===");
        System.out.printf("Sınıf Ortalaması: %.2f%n", classAverage);
        System.out.printf("Geçme Oranı: %.1f%% (%d/%d)%n", 
                         passRate, passingStudents, studentNames.length);
        System.out.printf("En Başarılı Öğrenci: %s (%.2f)%n", topStudent, highestGrade);
        
        // Performans analizi
        if (classAverage >= 80) {
            System.out.println("📊 Sınıf Performansı: Mükemmel");
        } else if (classAverage >= 70) {
            System.out.println("📊 Sınıf Performansı: İyi");
        } else if (classAverage >= 60) {
            System.out.println("📊 Sınıf Performansı: Orta");
        } else {
            System.out.println("📊 Sınıf Performansı: Geliştirilmeli");
        }
    }
}
```

#### Laravel Karşılaştırması
```php
// Laravel GradeService
class GradeService
{
    public function calculateClassGrades($students, $examScores, $weights, $examNames)
    {
        $results = [];
        $classTotal = 0;
        $passingStudents = 0;
        $highestGrade = 0;
        $topStudent = '';
        
        foreach ($students as $studentIndex => $studentName) {
            $studentScores = $examScores[$studentIndex];
            $weightedTotal = 0;
            $hasFailingGrade = false;
            
            $examDetails = [];
            foreach ($studentScores as $examIndex => $score) {
                $weightedScore = $score * $weights[$examIndex];
                $weightedTotal += $weightedScore;
                
                $examDetails[] = [
                    'exam' => $examNames[$examIndex],
                    'score' => $score,
                    'weight' => $weights[$examIndex] * 100
                ];
                
                if ($score < 50) {
                    $hasFailingGrade = true;
                }
            }
            
            $gradeInfo = $this->determineLetterGrade($weightedTotal, $hasFailingGrade);
            
            if ($gradeInfo['passed']) {
                $passingStudents++;
            }
            
            $classTotal += $weightedTotal;
            
            if ($weightedTotal > $highestGrade && !$hasFailingGrade) {
                $highestGrade = $weightedTotal;
                $topStudent = $studentName;
            }
            
            $results[] = [
                'name' => $studentName,
                'exam_details' => $examDetails,
                'weighted_total' => $weightedTotal,
                'letter_grade' => $gradeInfo['letter'],
                'status' => $gradeInfo['status'],
                'passed' => $gradeInfo['passed']
            ];
        }
        
        $classAverage = $classTotal / count($students);
        $passRate = ($passingStudents / count($students)) * 100;
        
        return [
            'student_results' => $results,
            'class_statistics' => [
                'average' => $classAverage,
                'pass_rate' => $passRate,
                'passing_students' => $passingStudents,
                'total_students' => count($students),
                'top_student' => $topStudent,
                'highest_grade' => $highestGrade,
                'performance_level' => $this->getPerformanceLevel($classAverage)
            ]
        ];
    }
    
    private function determineLetterGrade($weightedTotal, $hasFailingGrade)
    {
        if ($hasFailingGrade) {
            return ['letter' => 'FF', 'status' => 'Başarısız (Kritik not)', 'passed' => false];
        }
        
        return match(true) {
            $weightedTotal >= 90 => ['letter' => 'AA', 'status' => 'Pekiyi', 'passed' => true],
            $weightedTotal >= 85 => ['letter' => 'BA', 'status' => 'İyi', 'passed' => true],
            $weightedTotal >= 80 => ['letter' => 'BB', 'status' => 'İyi', 'passed' => true],
            $weightedTotal >= 75 => ['letter' => 'CB', 'status' => 'Orta', 'passed' => true],
            $weightedTotal >= 60 => ['letter' => 'CC', 'status' => 'Geçer', 'passed' => true],
            default => ['letter' => 'FF', 'status' => 'Başarısız', 'passed' => false]
        };
    }
}
```

---

## ÖZET ve BEST PRACTICES

### Java vs Laravel Temel Farklar

| Konu | Java | Laravel/PHP |
|------|------|-------------|
| **String Karşılaştırma** | `.equals()` kullan | `===` kullan |
| **Integer Division** | `5/3 = 1` | `5/3 = 1.666...` |
| **Döngü Syntax** | `for(int i=0; i<length; i++)` | `foreach($array as $item)` |
| **Switch Modern** | `switch() { case -> }` | `match()` |
| **Array Length** | `array.length` | `count($array)` |

### Performans İpuçları

1. **Enhanced for loop** normal for loop'tan genelde daha hızlı
2. **String comparison** için `==` değil `.equals()` kullan
3. **Break/continue** ile gereksiz iterasyonları önle
4. **Nested loop'lar** performans sorununa yol açabilir, dikkatli kullan

### Gerçek Projede Kullanım

- **Validation logic**: If-else chains
- **Data processing**: Loops + break/continue  
- **State management**: Switch statements
- **Business rules**: Complex conditional logic
- **Report generation**: Nested loops
- **User input**: Do-while loops

Bu konuları Laravel deneyimiye paralel olarak öğrendin. Section 4'te Object-Oriented Programming'e geçeceğiz.
                