# Hepsiburada Test Otomasyonu API

Bu README dosyası, Hepsiburada'nın API test otomasyonu projesi için gerekli bilgileri içermektedir. Kullanıcıları bilgilendirmek amacıyla aşağıdaki adımlar ve talimatlar sunulmuştur.

## Kurulum

* Proje RestAssured üzerinde geliştirilmiştir ve kullanılmak üzere tasarlanmıştır.

## Kullanım

1. **Post Request Çalıştırma:**
   * `src/test/resources/features/Hbapi.feature` dosyası açılır.
   * Run butonu tıklanarak stepler çalıştırılabilir.
   * 'Get' isteğinde elde edilen 'value', 'Post' isteğinde kullanılacağı için birbirlerine bağlı şekilde yapılmıştır.
   
## Projenin İçeriği

1. **Constant Package Hakkında**
   * `src/test/java/constant/APIConstants.java` dosyası, proje için temel URL ve endpoint'leri içerir.

2. **Model Package Hakkında**
   * `src/test/java/model/AuthorizationValue.java` ve `src/test/java/model/Languagerequest.java` dosyaları açılır.
   * Request içersinde gönderilen body alanının fieldları tanımlanmıştır.
   
3. **Reuqest Package  Hakkında**
   * `src/test/java/request/ApiRequestHandler.java` ve `src/test/java/request/RequestApiService.java` dosyaları, API isteklerini yönetmek için kullanılır.
   * `ApiRequestHandler.java`: Bu dosyada HTTP yöntemleri (post, get vb.) tanımlanmıştır. Bu yöntemler diğer isteklerde kullanılmak üzere tasarlanmıştır.
   * `RequestApiService.java`: Bu dosyada, `ApiRequestHandler.java` dosyasındaki yöntemler ilgili isteğe göre kullanılır. 
   `APIConstants.java` dosyasında tanımlanan baseUrl ve endpoint'e göre istek atılacak URL de burada belirlenir. Ayrıca, header için gerekli olan alanlar da burada eklenir.
   
4. **Steps Package Hakkında**
   * `src/test/java/steps/Commonsteps.java` açılır.
   * Bu dosyada ilgili Cucumber tanımlamaları yapılmıştır.
   
5. **Store Package Hakkında**
   * `src/test/java/store/LanguageStore.java` açılır.
   * Bu dosyada, request göndermek için oluşturulan ilgili alanlara değer eklenmesi sağlanır. Bu değerler, API isteklerinde kullanılacak olan verilere karşılık gelir.

## Yazar

Talha Beğendi
