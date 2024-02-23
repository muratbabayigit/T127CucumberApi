package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;

public class Stepdefinitions {
    String endpoint;
    Response response;
    JsonPath resJP;




    @Given("kullanici {string} base Url adresine gider")
    public void kullanici_base_url_adresine_gider(String jPHUrl) {
        endpoint= ConfigReader.getProperty(jPHUrl);


    }
    @Then("kullanici {string} parametrelerini kullanir")
    public void kullanici_parametrelerini_kullanir(String pathParams) {
        endpoint=endpoint+"/"+pathParams;


    }
    @Then("kullanici GET request gonderip gelen response kaydeder")
    public void kullanici_get_request_gonderip_gelen_response_kaydeder() {
        response=given().when().get(endpoint);


    }


    @Then("kullanici status kodunun {int} oldugunu test eder")
    public void kullanici_status_kodunun_oldugunu_test_eder(int statusCode) {
        Assert.assertEquals(statusCode,response.getStatusCode());

    }
    @Then("kullanici content type degerinin {string} oldugunu test eder")
    public void kullanici_content_type_degerinin_oldugunu_test_eder(String contentType) {
        Assert.assertEquals(contentType,response.getContentType());


    }
    @Then("kullanici donen cevapta userid degerinin {int} oldugunu test eder")
    public void kullaniciDonenCevaptaUseridDegerininOldugunuTestEder(int value) {
        resJP=response.jsonPath();
        Assert.assertEquals(value,resJP.getInt("userId"));


    }
    @Then("kullanici donen cevapta title degerinin {string} oldugunu test eder")
    public void kullanici_donen_cevapta_title_degerinin_oldugunu_test_eder(String value) {
        Assert.assertEquals(value,resJP.getString("title"));

    }


}
