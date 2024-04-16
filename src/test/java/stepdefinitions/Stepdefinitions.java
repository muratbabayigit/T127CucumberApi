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

import java.sql.Connection;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class Stepdefinitions {
    String endpoint;
    Response response;
    JsonPath resJP;
    JSONObject postRequestBody;


    @Given("kullanici {string} base Url adresine gider")
    public void kullanici_base_url_adresine_gider(String baseUrl) {
        endpoint = ConfigReader.getProperty(baseUrl);


    }

    @Then("kullanici {string} parametrelerini kullanir")
    public void kullanici_parametrelerini_kullanir(String pathParams) {
        endpoint = endpoint + "/" + pathParams;


    }



    @Then("kullanici GET request gonderip gelen response kaydeder")
    public void kullanici_get_request_gonderip_gelen_response_kaydeder() {
        response = given().when().get(endpoint);


    }


    @Then("kullanici status kodunun {int} oldugunu test eder")
    public void kullanici_status_kodunun_oldugunu_test_eder(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());

    }

    @Then("kullanici content type degerinin {string} oldugunu test eder")
    public void kullanici_content_type_degerinin_oldugunu_test_eder(String contentType) {
        assertEquals(contentType, response.getContentType());


    }

    @Then("kullanici donen cevapta userid degerinin {int} oldugunu test eder")
    public void kullaniciDonenCevaptaUseridDegerininOldugunuTestEder(int value) {
        resJP = response.jsonPath();
        assertEquals(value, resJP.getInt("userId"));


    }

    @Then("kullanici donen cevapta title degerinin {string} oldugunu test eder")
    public void kullanici_donen_cevapta_title_degerinin_oldugunu_test_eder(String value) {
        assertEquals(value, resJP.getString("title"));

    }

    @Given("kullanici {string} path parametresini kullanir")
    public void kullanici_path_parametresini_kullanir(String pathparam) {
        endpoint=endpoint+"/"+pathparam; //+"/?"+key+"?"+key2;  //Bu tanımlama manuel eklemedir.


    }



    @Then("donen response'un attribute degerlerinin {string},{string},{int} {int} oldugunu test eder")
    public void donenResponseUnAttributeDegerlerininOldugunuTestEder(String title, String body, Integer userId, Integer id) {
        resJP=response.jsonPath();
        assertEquals(title,resJP.getString("title"));
        assertEquals(body,resJP.getString("body"));
        assertEquals(userId,(Integer)resJP.getInt("userId"));
        assertEquals(id,(Integer) resJP.getInt("id"));

    }



    @Then("Post request gonderir ve donen respons'u kaydeder")
    public void post_request_gonderir_ve_donen_respons_u_kaydeder() {
        response=given().when().body(postRequestBody.toString()).contentType(ContentType.JSON).put(endpoint);
        //put demeden once .header("Authorization","apikey 5ce8BgifHKqNjeo1RV9n5D:3xqG2GwaHpvFx8KAhRTBvo")
        response.prettyPrint();
    }

    @Then("donen respons'un content type degerinin {string} oldugunu")
    public void donen_respons_un_content_type_degerinin_oldugunu(String ctype) {
        assertEquals(ctype,response.contentType());
    }
    @Then("donen response'un {string} header degerinin {string} oldugunu")
    public void donen_response_un_header_degerinin_oldugunu(String headerAttribute, String value) {
        assertEquals(value,response.header(headerAttribute));
    }



    @Then("Post request icin {string},{string} {int} {int} bilgileri ile request body olusturur")
    public void postRequestIcinBilgileriIleRequestBodyOlusturur(String title, String body, int userId, int id) {
        postRequestBody =new JSONObject();
        postRequestBody.put("title",title);
        postRequestBody.put("body",body);
        postRequestBody.put("userId",userId);
        postRequestBody.put("id",id);
    }

    @Then("donen response'un status degerinin {int} oldugunu")
    public void donenResponseUnStatusDegerininOldugunu(int scode) {
        assertEquals(scode,response.statusCode());
    }
}