# User Service
## Desafio Técnico

User service é um serviço criado especialmente para o teste Desafio Técnico Desenvolvedor Full Stack da boletoflex.

## Funcionalidades

- Listar todos os usuarios
- Buscar um usuario pelo id
- Salvar usuario
 

## Bibliotecas

User service utiliza algumas tecnologias em seu funcionamento:

- Java - Linguagem utilizada
- MySQL - Banco de dados
- Maven - Integração do projeto
- Common-lang - Auxiliares de texto
- Lombok - Redução de código
- Springfox Swagger2 - Criação de documentação via Swagger
- Flyway - Versionamento e gerenciamento do banco de dados

## Instalação

User Service necessita do [Maven] para executar.

Suba o banco de dados via Docker.

```sh
cd user-service
docker-compose up -d
```

Para iniciar a aplicação.

```sh
mvn spring-boot:run
```

Após o início da aplicação, será disponibilizada

```sh
localhost:8080
```


[//]: # 
   [Maven]: <https://maven.apache.org/>