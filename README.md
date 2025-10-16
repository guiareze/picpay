# 📦 PicPay

> Resolução do desafio técnico do PicPay para aplicar conceitos de Clean Architecture, boas práticas de desenvolvimento e tecnologias modernas do ecossistema Java/Spring.

---

## 🚀 Tecnologias

- ✅ Java 25+
- ✅ Spring Boot 3.5.6
- ✅ Spring Web
- ✅ Spring Data JPA
- ✅ Maven
- ✅ Docker

---

### 💡 Questões interessantes implementadas neste projeto

* 🧩 Desenvolvido com boas práticas e seguindo arquitetura hexagonal: Separação clara entre domínio, aplicação, infraestrutura e interfaces externas, facilitando manutenção e testes.
* 🔄 Controle transacional de atualizações em banco de dados: Operações críticas, como transferências, são protegidas por transações para garantir integridade dos dados.
* 🌐 Integrações com serviços externos usando RestClient: Comunicação moderna e segura com APIs externas, aproveitando recursos do Spring.
* 📨 Serviço de notificação assíncrono: Envio de notificações desacoplado do fluxo principal, melhorando performance e escalabilidade.

---

## 🔧 Instalação

### Pré-requisitos:
- Java 25 ou superior
- Maven
- Docker

### Clonar o projeto:
```bash
git https://github.com/guiareze/persons.git
cd persons
````

### Rodar localmente:

```bash
./mvnw spring-boot:run
```

> A aplicação estará disponível em:
> 📍 `http://localhost:8080`

---

## 🧪 Exemplos de Endpoints

### 👤 Criar usuário

```http
POST /user
Content-Type: application/json
```

Entrada:
```json
{
  "name": "João Silva Pereira",
  "document": "12345678902",
  "email": "joao.silva2@email.com",
  "password": "senhaSegura123",
  "category": "COMMOM"
}
```

Resposta:
```json
{
  "id": 6,
  "name": "João Silva Pereira",
  "document": "12345678902",
  "email": "joao.silva2@email.com",
  "category": "COMMOM"
}
```

---

### 🏦 Criar conta

```http
POST /account
Content-Type: application/json
```

Entrada:
```json
{
  "userId": 6,
  "amount": 200
}
```

Resposta:
```json
{
    "id": 6,
    "userId": 6,
    "amount": 200
}
```

---

### 💰 Depositar em conta

```http
POST /account/{accountId}/deposit
Content-Type: application/json
```

Entrada:
```json
{
  "userId": 6,
  "amount": 1000
}
```

Resposta:
```json
{
  "id": 6,
  "userId": 6,
  "amount": 1200.00
}
```

---

### 🔄 Realizar transferência

```http
POST /transfer
Content-Type: application/json
```

Entrada:
```json
{
  "payer": 1,
  "payee": 2,
  "value": 10
}
```

Resposta:  
`204 No Content` (transferência realizada com sucesso)

---

## 🗂️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/br/com/guiareze/picpay/
│   │   ├── controller/
│   │   ├── core/
│   │   ├── persistence/
│   │   ├── rest/
│   │   └── PicpayApplication.java
│   └── resources/
│       ├── application.yml
```

---

## 🐳 Docker

### Build da imagem:

```bash
cd docker
docker-compose up
```

---

## 🧰 Variáveis de Ambiente (exemplo)

| Nome                    | Padrão               | Descrição                    |
| ----------------------- | -------------------- | ---------------------------- |
| `SERVER_PORT`           | `8080`               | Porta em que a API irá rodar |

---

## 📘 Documentação

Acesse a documentação Swagger (se habilitada) em:

```
http://localhost:8080/swagger-ui.html
```

---

## 🔗 Links Úteis

- [Repositório GitHub do desafio técnico](https://github.com/PicPay/picpay-desafio-backend)

---