package logic;

import io.restassured.response.Response;
import utils.YamlUtils;
import static io.restassured.RestAssured.given;

public class getListaTodasRacasLogic {

    public static Response listarTodasAsRacas() {
        return given()
                .when()
                .get(YamlUtils.get("getListaTodasRacas.url"))
                .then()
                .extract()
                .response();
    }
}