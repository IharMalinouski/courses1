import com.google.gson.Gson;
import object.InfoList;
import object.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@Test
public class test {
    public void test1() {
        given()
                .when()
                .log().all()
                .get("https://catalog.onliner.by/sdapi/pogoda/api/now")
                .then()
                .log().all()
                .statusCode(200)
                .body("city", equalTo("Минске"));
    }

    public void asat() {
        String body = given()
                .when()
                .get("https://brest.rabota.by/shards/vacancies_of_the_day")
                .then()
                .log().all()
                .extract().body().asString();

        System.out.println(body);

        InfoList infoList =  new Gson().fromJson(body, InfoList.class);
        String fsdf = infoList.getVacancies().get(0).getCompany().getVisibleName();
        System.out.println(fsdf);

        Assert.assertEquals("Доминоспицца", fsdf);
    }

    public void test() {
        //https://reqres.in/api/users

        User user = User.builder()
                .name("morpheus")
                .job("leader")
                .build();

        given().log().all()
                .body(user)
                .when().log().all()
                .post("https://reqres.in/api/users")
                .then().log().all()
                .statusCode(201);

    }

}
