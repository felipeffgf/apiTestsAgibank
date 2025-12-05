Tecnologias utilizadas

- Java 11
- Maven
- Rest Assured
- Cucumber JVM
- JUnit
- Allure Framework

1 Clonar o repositório

```
git clone <URL_DO_REPOSITORIO>
cd <nome-do-projeto>
```

2️ Verificar se você possui Java 11 instalado

Execute:

```
java -version
```

O esperado é algo como:

```
openjdk version "11.x.x"
```

Caso não tenha, instale o JDK 11 antes de continuar.

3 Instalar dependências e compilar

```
mvn clean install
```

4️ Executar os testes

Existem duas formas:

✔ Via Maven:
mvn test

✔ Ou rodando o arquivo TestRunner pela IDE:
src/test/java/TestRunner.java

5️ Gerar o relatório Allure

Após a execução dos testes:

```
mvn allure:serve
```

Isso abrirá o relatório automaticamente no navegador.
