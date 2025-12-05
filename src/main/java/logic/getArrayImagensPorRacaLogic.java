package logic;

import io.restassured.response.Response;
import utils.YamlUtils;
import java.util.List;

import static io.restassured.RestAssured.given;

public class getArrayImagensPorRacaLogic {

    public static Response listarImagensPorRaca(String breed) {
        String url = YamlUtils.get("getArrayImagensPorRaca.url");

        return given()
                .when()
                .get(url)
                .then()
                .extract()
                .response();
    }

    public static void validarListaDeURLs(Response response, String field) {
        List<String> urls = response.jsonPath().getList(field);

        if (urls == null || urls.isEmpty()) {
            throw new AssertionError("A lista está vazia!");
        }

        for (String url : urls) {
            if (!url.startsWith("https://")) {
                throw new AssertionError("URL inválida encontrada: " + url);
            }
        }
    }
}
