## Laboratorio - DIO Project

Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring Boot, seguindo o tutorial.

### Utilização

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/api/v1/people
```

São necessários os seguintes pré-requisitos para a execução:

* Java 11 ou versões superiores.
* Maven 3.8.1 ou versões superiores.

### Modificações Pessoais

* Adição do Swagger - Utilizar http://localhost:8080/swagger-ui/
* Estrutura de pacotes inspirado nas camadas de DDD (Domain Drive Design)
```
└───lab
    └───hadil
        └───dio
            └───person
                ├───domain
                │   ├───dto
                │   │   ├───request
                │   │   └───response
                │   ├───entity
                │   └───enums
                ├───infra
                │   └───data
                │       ├───exception
                │       ├───mapper
                │       └───repository
                ├───restAPI
                │   ├───config
                │   └───controller
                └───service
```

