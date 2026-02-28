# 🚀 Training Spring Validation

Aplicação de treinamento técnico com foco no Spring Validation

## 🎯 Sobre o Projeto

Este projeto é uma aplicação desenvolvida para demonstrar a validação de dados usando o framework Spring. Ele serve como um treinamento prático sobre como implementar validações eficazes em aplicações Java, garantindo que os dados fornecidos pelo usuário estejam em conformidade com as regras que foram definidas utilizando a especificação **Jakarta Bean Validation (JSR-303/JSR-349)**.

## 🛠️ Tecnologias Utilizadas

- Java 25
- Spring Boot
- Spring Validation
- Maven
- H2 Database (para testes)
- Lombok
- JUnit (para testes automatizados)

## 🗂️ Estrutura de Pastas
```
trainning-spring-validation/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           └── validation/
│   │   │               ├── controller/
│   │   │               ├── model/
│   │   │               ├── repository/
│   │   │               └── service/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
└── pom.xml
```

## 🛤️ Endpoints

Esses são os principais endpoints definidos no controlador `PersonalContactResource.java`:

| Método | Endpoint                     | Descrição                              |
|--------|------------------------------|----------------------------------------|
| `GET`  | `/api/personal-contacts`     | Obtém a lista de contatos pessoais.    |
| `GET`  | `/api/personal-contacts/{id}`| Obtém um contato pessoal específico.    |
| `POST` | `/api/personal-contacts`     | Cria um novo contato pessoal.          |
| `PUT`  | `/api/personal-contacts/{id}`| Atualiza um contato pessoal existente.  |
| `DELETE`| `/api/personal-contacts/{id}`| Remove um contato pessoal.              |

## ⚙️ Instruções para executar localmente o projeto

1. **Clone o repositório**
   ```bash
   git clone https://github.com/eritonsgomes/trainning-spring-validation.git
   cd trainning-spring-validation
   ```

2. **Compile o projeto**
   ```bash
   mvn clean install
   ```

3. **Execute a aplicação**
   ```bash
   mvn spring-boot:run
   ```
4. **Acesse a aplicação em**
   [http://localhost:8080](http://localhost:8080)


## ✅ Executando Testes

Para executar os testes automatizados, use o seguinte comando:

```bash
mvn test
```

## :pencil: Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para fazer um fork do projeto e enviar um pull request.

## 📄 Licença
Este projeto está sob a licença MIT. Consulte o arquivo LICENSE para mais detalhes.

Sinta-se à vontade para ajustar qualquer seção conforme necessário!
