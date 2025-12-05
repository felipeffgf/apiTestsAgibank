package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import logic.getImagemAleatoriaLogic;
import utils.AssertUtils;

public class getImagemAleatoriaStep {

    private Response response;

    @When("eu chamo a API de imagem aleatória")
    public void eu_chamo_api_imagem_aleatoria() {
        response = getImagemAleatoriaLogic.obterImagemAleatoria();
    }

    @Then("o status code da imagem aleatória deve ser {int}")
    public void o_status_code_da_imagem_aleatoria_deve_ser(Integer statusCode) {
        AssertUtils.assertStatusCode(response, statusCode);
    }

    @Then("o campo {string} deve conter uma URL iniciando com {string}")
    public void validar_url(String field, String prefix) {
        AssertUtils.assertUrlStartsWith(response, field, prefix);
    }

    @Then("o JSON de imagem aleatória deve conter os campos {string} e {string}")
    public void json_deve_conter_campos(String campo1, String campo2) {
        AssertUtils.assertFieldsExist(response, campo1, campo2);
    }

    @Then("o campo {string} da imagem aleatória deve ser {string}")
    public void validar_campo_status(String campo, String valorEsperado) {
        AssertUtils.assertFieldEquals(response, campo, valorEsperado);
    }
}
