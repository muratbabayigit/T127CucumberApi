Feature:
@Api
  Scenario: TC JSONPLACEHOLDER GET TEST

    Given kullanici "jPHUrl" base Url adresine gider
    Then kullanici "posts/90" parametrelerini kullanir
    And kullanici GET request gonderip gelen response kaydeder
    Then kullanici status kodunun 200 oldugunu test eder
    Then kullanici content type degerinin "application/json; charset=utf-8" oldugunu test eder
    Then kullanici donen cevapta userid degerinin 9 oldugunu test eder
    And kullanici donen cevapta title degerinin "ad iusto omnis odit dolor voluptatibus" oldugunu test eder

