
# API Beneficiario

Projeto feito como desafio para a empresa Ekan.


## &emsp; Tecnologias utilizadas
* Java 8
* Spring Boot
* Spring Data
* Spring Security
* MySQL
* Swagger

## Como rodar o projeto

Primeiramente clone o projeto

use git clone ********

então abra o projeto na sua IDE de preferencia (no meu caso usei o Intellij).

abra o projeto apartir do arquivo POM.xml.

depois que o maven baixar todas as dependencias rode o projeto.

O projeto usa Mysql com db e cria 

no file aaplication.properties mude a url, username e password para o seu bd.

as tabelas são geradas automaticamente caso elas não existam.

e ao rodar pela o projeto pela primeira vez o usuario admin sera criado.
* username = admin
* password = 12345




## Swagger

Este projeto utiliza o Swagger para mostrar seus Endpoints.

o link para o swagger é http://localhost:8080/swagger-ui/index.html#/

para utilizar os endpoints é necessario primeiro fazer um novo usuario no endpoint Authentication/createNewUser ou utlizaro o usuario admin.

Então use o endpoint Authentication/login para fazer o seu login, o endpoint ira retornar um json contendo o accessToken.

Com o accessToken va ate o botão de Authorize e insira apenas o valor do token, e clique no botão Authorize.

Agora você podera utilizar todas os endpoints livremente por 5 minutos.


## Autores

- [@Luizfelipelacerda](https://github.com/Luizfelipelacerda)

