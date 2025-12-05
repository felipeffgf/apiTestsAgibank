# **1. Dependências obrigatórias no `pom.xml`**

Faça um clone do repositório
```
git clone <url-do-repo>
cd <nome-do-projeto>
git checkout master
```

Agora apenas faça uma instalação limpa das dependencias Maven

```
mvn clean install
```

---

# **2. Criar arquivo `allure.properties`**

Crie o arquivo:

```
src/test/resources/allure.properties
```

Conteúdo recomendado:

```
allure.results.directory=target/allure-results
allure.link.issue.pattern=https://meu-jira.com/browse/{} 
allure.link.tms.pattern=https://meu-tms.com/tests/{}
```

Se você não usa Jira/TMS, deixe apenas:

```
allure.results.directory=target/allure-results
```

---

# **3. Configurar o Runner (o seu está OK)**

O seu runner está **correto** para Allure:

```java
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"steps"},
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json"
        },
        monochrome = true
)
public class TestRunner { }
```

O plugin:

```
"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
```

É o que gera os arquivos `.json` no `target/allure-results`.

---

# **4. Estrutura de pastas recomendada**

```
/src
  /test
    /java
      /steps
      /logic
      /utils
      TestRunner.java
    /resources
      /features
      allure.properties
pom.xml
```

---

# **5. Rodar os testes + gerar relatório**

### 🔹 1) Executar testes:

```
mvn clean test
```

Isso cria o diretório:

```
target/allure-results
```

---

### 🔹 2) Gerar o relatório Allure:

```
allure serve target/allure-results
```

Isso abre o relatório no navegador.
