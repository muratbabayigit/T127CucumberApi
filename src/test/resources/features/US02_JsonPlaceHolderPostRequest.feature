Feature: JSONPLACEHOLDER POST REQUEST

  Scenario: JsonPlaceHolder Post request

    Given kullanici "jPHUrl" base Url adresine gider
    And kullanici "posts/70" parametrelerini kullanir
    Then Post request icin "Ahmet","Merhaba" 10 70 bilgileri ile request body olusturur
    Then Post request gonderir ve donen respons'u kaydeder
    Then donen response'un status degerinin 200 oldugunu
    Then donen respons'un content type degerinin "application/json; charset=utf-8" oldugunu
    Then donen response'un "Connection" header degerinin "keep-alive" oldugunu
    Then donen response'un attribute degerlerinin "Ahmet","Merhaba",10 70 oldugunu test eder


