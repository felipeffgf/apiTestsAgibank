package logic;

import io.restassured.response.Response;
import utils.YamlUtils;

import static io.restassured.RestAssured.given;

public class getImagemAleatoriaLogic {

    public static Response obterImagemAleatoria() {
        return given()
                .when()
                .get(YamlUtils.get("getImagemAleatoria.url"))
                .then()
                .extract()
                .response();
    }
}
