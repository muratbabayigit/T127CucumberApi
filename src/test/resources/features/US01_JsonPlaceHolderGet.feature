Feature:
@Api
  Scenario: TC JSONPLACEHOLDER GET TEST

    Given kullanici "jPHUrl" base Url adresine gider
    Then kullanici "posts/44" parametrelerini kullanir
    And kullanici GET request gonderip gelen response kaydeder
    Then kullanici status kodunun 200 oldugunu test eder
    Then kullanici content type degerinin "application/json; charset=utf-8" oldugunu test eder
    Then kullanici donen cevapta userid degerinin 5 oldugunu test eder
    And kullanici donen cevapta title degerinin "optio dolor molestias sit" oldugunu test eder

