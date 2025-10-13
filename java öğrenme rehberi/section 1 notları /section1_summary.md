# Section 1: Course Introduction - Detaylı Öğrenme Notları

## 1. Java Ekosistemi Temel Kavramları

### JDK, JRE, JVM Nedir?

**JVM (Java Virtual Machine):**
- Java kodunu çalıştıran sanal makine
- "Write Once, Run Anywhere" prensibinin temeli
- Laravel'deki PHP interpreter'ının Java karşılığı

**JRE (Java Runtime Environment):**
- JVM + Java kütüphaneleri
- Sadece Java uygulamalarını çalıştırmak için gerekli
- Laravel'deki PHP runtime'ına benzer

**JDK (Java Development Kit):**
- JRE + geliştirme araçları (javac compiler, debugger)
- Geliştirme için gerekli tam paket
- Laravel'deki PHP + Composer + geliştirme araçları kombinasyonu

### Maven vs Composer Karşılaştırması

| Özellik | Laravel (Composer) | Spring Boot (Maven) |
|---------|-------------------|-------------------|
| **Dependency Dosyası** | composer.json | pom.xml |
| **Install Komutu** | `composer install` | `mvn install` |
| **Dependency Ekleme** | `composer require package` | pom.xml'e manuel ekleme |
| **Autoloader** | vendor/autoload.php | Maven otomatik |

**Laravel composer.json örneği:**
```json
{
    "name": "my-app",
    "require": {
        "laravel/framework": "^10.0",
        "guzzlehttp/guzzle": "^7.2"
    }
}
```

**Spring Boot pom.xml örneği:**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0">
    <groupId>com.example</groupId>
    <artifactId>my-app</artifactId>
    <version>1.0.0</version>
    
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>3.2.1</version>
        </dependency>
    </dependencies>
</project>
```

## 2. Spring vs Spring Boot

### Spring Framework (Eski Yöntem)
- Çok fazla XML konfigürasyonu
- Manuel bean tanımlamaları
- Karmaşık setup süreci

**Örnek XML Konfigürasyonu:**
```xml
<beans>
    <bean id="userService" class="com.example.UserService">
        <property name="userRepository" ref="userRepository"/>
    </bean>
    <bean id="userRepository" class="com.example.UserRepository"/>
</beans>
```

### Spring Boot (Modern Yöntem)
- Auto-configuration (otomatik konfigürasyon)
- Annotation-based configuration
- Minimal kod ile maksimum sonuç

**Spring Boot ile aynı işlem:**
```java
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}

@Repository
public class UserRepository {
    // Implementation
}
```

## 3. Auto-Configuration Kavramı

### Database Configuration
**Laravel .env:**
```env
DB_CONNECTION=mysql
DB_HOST=127.0.0.1
DB_PORT=3306
DB_DATABASE=laravel
DB_USERNAME=root
DB_PASSWORD=
```

**Spring Boot application.properties:**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=password
```

Her iki framework'te de konfigürasyon yazdıktan sonra otomatik connection oluşuyor.

### Dependency Injection Karşılaştırması

**Laravel Service Container:**
```php
class UserController {
    public function __construct(UserService $userService) {
        $this->userService = $userService; // Laravel otomatik inject eder
    }
}
```

**Spring Boot IoC Container:**
```java
@RestController
public class UserController {
    @Autowired
    private UserService userService; // Spring Boot otomatik inject eder
}
```

## 4. Embedded Server Konsepti

### Laravel Development Server
```bash
php artisan serve # Ayrı komut ile server başlatılır
# Output: Laravel development server started: http://127.0.0.1:8000
```

### Spring Boot Embedded Server
```java
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        // Embedded Tomcat otomatik başlar
    }
}
```

**Nasıl çalıştırılır:**
1. **IDE ile:** main() method yanındaki yeşil ▶️ play butonuna tık
2. **Terminal ile:** `mvn spring-boot:run`

**Çıktı:**
```
Started Application in 2.847 seconds
Tomcat started on port(s): 8080 (http)
```

## 5. Component Scanning Mekanizması

### Spring Boot Otomatik Tarama

```java
@SpringBootApplication  // 3 annotation içerir:
// @ComponentScan - Paket taraması
// @EnableAutoConfiguration - Otomatik konfigürasyon  
// @Configuration - Konfigürasyon sınıfı
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

**Dosya yapısı:**
```
src/main/java/com/example/demo/
├── Application.java          (@SpringBootApplication)
├── HelloController.java      (@RestController) ← Otomatik bulunur
└── UserController.java       (@RestController) ← Otomatik bulunur
```

Spring Boot başlarken `com.example.demo` paketini ve alt paketlerini tarar, `@RestController` olan sınıfları otomatik kayıt eder.

## 6. Proje Yapısı Karşılaştırması

### Laravel Proje Yapısı
```
my-laravel-app/
├── app/
│   ├── Http/Controllers/
│   ├── Models/
│   ├── Services/
│   └── Providers/
├── config/
├── database/
├── routes/
│   ├── web.php
│   └── api.php
├── resources/views/
└── composer.json
```

### Spring Boot Proje Yapısı
```
my-spring-app/
├── src/
│   ├── main/
│   │   ├── java/com/example/app/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   ├── model/
│   │   │   └── Application.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   └── test/
└── pom.xml
```

## 7. Routing Yaklaşımları

### Spring Boot Default Yaklaşımı
Her controller kendi route'larını tanımlar:

```java
@RestController
@RequestMapping("/api")
public class UserController {
    
    @GetMapping("/users")     // /api/users
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
    
    @PostMapping("/users")    // /api/users (POST)
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }
}
```

### Laravel Tarzı Router Pattern (Önerilen Yaklaşım)

**routes/ApiRoutes.java:**
```java
@RestController
@RequestMapping("/api")
public class ApiRoutes {
    
    @Autowired
    private UserController userController;
    
    @Autowired
    private PostController postController;
    
    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        return userController.getAllUsers();
    }
    
    @GetMapping("/posts")
    public ResponseEntity<?> getPosts() {
        return postController.getAllPosts();
    }
}
```

**routes/WebRoutes.java:**
```java
@Controller
@RequestMapping("/")
public class WebRoutes {
    
    @GetMapping("/")
    public String home() {
        return "home"; // Thymeleaf template name
    }
    
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
```

### Functional Router Pattern (İleri Seviye)
```java
@Configuration
public class RouteConfig {
    
    @Bean
    public RouterFunction<ServerResponse> apiRoutes() {
        return RouterFunctions
            .route(GET("/api/users"), userHandler::getAllUsers)
            .andRoute(POST("/api/users"), userHandler::createUser)
            .andRoute(GET("/api/posts"), postHandler::getAllPosts);
    }
}
```

## 8. Production-Ready Features

### Laravel'de Hazır Gelen Özellikler
- Cache: `php artisan cache:clear`
- Logs: `storage/logs/laravel.log`
- Queue: `php artisan queue:work`
- Health check: Custom yazılır

### Spring Boot'ta Otomatik Gelen Özellikler
- Health checks: `/actuator/health`
- Metrics: `/actuator/metrics`
- Environment info: `/actuator/env`
- Application info: `/actuator/info`

Bu endpoint'ler hiç kod yazmadan otomatik gelir.

## 9. İlk Spring Boot Uygulaması

### Tam Çalışan Örnek

**Application.java:**
```java
package com.example.demo;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

**HelloController.java:**
```java
package com.example.demo;

@RestController
public class HelloController {
    
    @GetMapping("/")
    public String home() {
        return "Ana sayfa";
    }
    
    @GetMapping("/hello")
    public String hello() {
        return "Merhaba Spring Boot!";
    }
    
    @GetMapping("/api/users")
    public String users() {
        return "Kullanıcılar listesi";
    }
}
```

### Test Adımları
1. Kodu çalıştır: `mvn spring-boot:run` veya IDE'de play buton
2. Tarayıcıda test et:
   - `http://localhost:8080/` → "Ana sayfa"
   - `http://localhost:8080/hello` → "Merhaba Spring Boot!"
   - `http://localhost:8080/api/users` → "Kullanıcılar listesi"

## 10. Spring Initializr

### Yeni Proje Oluşturma

**Laravel'de:**
```bash
composer create-project laravel/laravel my-project
```

**Spring Boot'ta:**
1. https://start.spring.io adresine git
2. Dependencies seç (Web, JPA, Security vs)
3. Zip dosyasını indir ve aç

**CLI ile:**
```bash
spring init --dependencies=web,jpa my-project
```

## 11. Önemli Karşılaştırma Tablosu

| Özellik | Laravel | Spring Boot |
|---------|---------|-------------|
| **Dil** | PHP | Java |
| **Dependency Management** | Composer | Maven/Gradle |
| **Auto-Configuration** | Service Providers | Auto-Configuration |
| **Routing** | routes/web.php, api.php | Annotations (@GetMapping) |
| **Dependency Injection** | Service Container | IoC Container |
| **ORM** | Eloquent | JPA/Hibernate |
| **Template Engine** | Blade | Thymeleaf |
| **Server** | php artisan serve | Embedded Tomcat |
| **Hot Reload** | Dosya değişikliği | DevTools ile |

## 12. Section 1 Temel Çıkarımlar

1. **Java ekosistemi PHP'den daha kompleks** ancak daha güçlü enterprise features sunar
2. **Maven = Composer** ancak daha verbose XML yapısı var
3. **Spring Boot auto-configuration** Laravel'in service provider sistemine benzer
4. **Embedded server** concept Laravel'den farklı, uygulama ile server birleşik
5. **Component scanning** Laravel'in service discovery sistemine benzer
6. **Router pattern yaklaşımı** Laravel developer'lar için daha familiar

## 13. Sonraki Adımlar

Section 2'de öğreneceğimiz konular:
- JDK kurulumu ve konfigürasyonu
- IntelliJ IDEA setup
- İlk Java kodunu yazma
- Java syntax temelları
- Variables ve data types
- Type conversion

**Hazır mısın Section 2'ye geçmeye?**