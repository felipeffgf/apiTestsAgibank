Feature: Obter imagem aleatória de qualquer raça

  Scenario: Validar retorno com status 200 e campo message contendo URL
    When eu chamo a API de imagem aleatória
    Then o status code da imagem aleatória deve ser 200
    And o campo "message" deve conter uma URL iniciando com "https://"

  Scenario: Validar estrutura do JSON retornado
    When eu chamo a API de imagem aleatória
    Then o JSON de imagem aleatória deve conter os campos "message" e "status"
    And o campo "status" da imagem aleatória deve ser "success"
