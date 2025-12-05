Feature: Listar imagens de uma raça

  Scenario: Validar retorno de imagens para uma raça válida
    When eu realizo uma chamada GET para "hound"
    Then o status code da busca por raça deve ser 200
    And o campo "message" deve ser uma lista de URLs