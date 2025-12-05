package utils;

import io.restassured.response.Response;

import org.hamcrest.Matchers;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class AssertUtils {

    public static void assertStatusCode(Response response, int expectedStatus) {
        response.then().statusCode(expectedStatus);
    }

    public static void assertFieldEquals(Response response, String field, String expectedValue) {
        response.then().body(field, Matchers.equalTo(expectedValue));
    }

    public static void assertFieldNotEmptyObject(Response response, String field) {
        response.then().body(field, Matchers.not(Matchers.anEmptyMap()));
    }

    public static void assertUrlStartsWith(Response response, String field, String prefix) {
        String url = response.jsonPath().getString(field);

        if (url == null) {
            throw new AssertionError("O campo '" + field + "' é nulo. Não foi possível validar a URL.");
        }

        if (!url.startsWith(prefix)) {
            throw new AssertionError(
                    "A URL do campo '" + field + "' não inicia com '" + prefix + "'. Valor atual: " + url
            );
        }
    }

    public static void assertFieldsExist(Response response, String... fields) {

        for (String field : fields) {
            Object value = response.jsonPath().get(field);

            if (value == null) {
                throw new AssertionError("O campo '" + field + "' não foi encontrado no JSON de resposta.");
            }
        }
    }

}