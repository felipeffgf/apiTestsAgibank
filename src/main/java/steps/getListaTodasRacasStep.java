package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import logic.getListaTodasRacasLogic;
import utils.AssertUtils;

public class getListaTodasRacasStep {

    public static Response response;

    @When("eu realizo uma requisição GET na lista de todas as raças")
    public void eu_realizo_um_get_na_lista_de_todas_as_racas() {
        response = getListaTodasRacasLogic.listarTodasAsRacas();
    }

    @Then("o status code deve ser {int}")
    public void o_status_code_deve_ser(Integer statusCode) {
        AssertUtils.assertStatusCode(response, statusCode);
    }

    @Then("o campo {string} deve ser {string}")
    public void o_campo_deve_ser(String status, String success) {
        AssertUtils.assertFieldEquals(response, status, success);
    }

    @Then("o campo {string} deve ser um objeto não vazio")
    public void o_campo_deve_ser_um_objeto_nao_vazio(String message) {
        AssertUtils.assertFieldNotEmptyObject(response, message);
    }
}