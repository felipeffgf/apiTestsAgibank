package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import logic.getArrayImagensPorRacaLogic;
import utils.AssertUtils;

public class getArrayImagensPorRacaStep {

    private Response response;

    @When("eu realizo uma chamada GET para {string}")
    public void eu_realizo_uma_chamada_get_para(String breed) {
        response = getArrayImagensPorRacaLogic.listarImagensPorRaca(breed);
    }

    @Then("o status code da busca por raça deve ser {int}")
    public void o_status_code_da_busca_por_raca_deve_ser(Integer statusCode) {
        AssertUtils.assertStatusCode(response, statusCode);
    }

    @Then("o campo {string} deve ser uma lista de URLs")
    public void o_campo_deve_ser_uma_lista_de_urls(String field) {
        getArrayImagensPorRacaLogic.validarListaDeURLs(response, field);
    }
}
