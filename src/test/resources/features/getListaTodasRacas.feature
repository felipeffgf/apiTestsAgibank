Feature: Listar todas as raças de cães

  Scenario: Validar retorno com status 200 e campo message
    When eu realizo uma requisição GET na lista de todas as raças
    Then o status code deve ser 200
    And o campo "status" deve ser "success"
    And o campo "message" deve ser um objeto não vazio