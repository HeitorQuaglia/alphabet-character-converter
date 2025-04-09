# Alphabet Character Converter

> Possivelmente o projeto mais **overengineered** que você já se deparou para converter um número entre 1 e 26 em uma letra do alfabeto.

---

## O que é isso?

Uma API REST em Quarkus que converte:

```
GET /alphabet/1 → "A"
GET /alphabet/26 → "Z"
```

Só isso?

**Não.**

Aqui temos:

- Arquitetura Hexagonal (Ports & Adapters)
- Princípios SOLID e Object Calisthenics
- Value Objects imutáveis para letras e posições
- Enum com mapeamento inteligente
- Fábricas para erro e resposta
- Casos de uso nomeados com intenção
- Testes unitários, integração e cobertura Jacoco
- Build nativo com GraalVM
- Dockerfile multi-stage com usuário não-root
- Health checks declarados no `docker-compose`
- E mais...

Tudo isso para resolver um problema que o Java nativo faz com:

```java
(char)('A' + n - 1)
```

Mas qual a graça nisso?

---

## Filosofia

> O caminho do desenvolvedor sênior é saber quando **não** usar tudo isso.  
> O caminho do entusiasta é usar **de propósito**, só pra ver até onde dá.

Este repositório é um exercício real de engenharia exagerada aplicada com seriedade.

---

## Como rodar localmente

Requisitos:

- Java 17+
- Docker

### 1. Build nativo com Docker:

```bash
docker compose up --build
```

A API estará disponível em:

```
GET http://localhost:8080/alphabet/1
```

### 2. Health Checks:

| Tipo       | Endpoint                     |
|------------|------------------------------|
| Geral      | `http://localhost:8080/q/health` |
| Liveness   | `http://localhost:8080/q/live`   |
| Readiness  | `http://localhost:8080/q/ready`  |

---

## Testes e cobertura

```bash
./gradlew test jacocoTestReport
```

Relatório em:  
`build/reports/jacoco/test/html/index.html`

---

## Exemplos de uso

```bash
curl http://localhost:8080/alphabet/3
# → { "letter": "C" }
```

```bash
curl http://localhost:8080/alphabet/0
# → { "error": "Invalid position: 0. Must be between 1 and 26." }
```

---

## Segurança

- Imagem UBI minimal (≈ 14MB)
- Binário estático
- Executando como usuário `quarkus` (não-root)
- Sem dependência externa ou banco de dados

---

## Contribua com exageros

Pull requests que adicionem **camadas desnecessárias**, **padrões de design irrelevantes** ou **anotações inúteis** são bem-vindas — mas devem seguir os princípios do projeto com **100% de testes e cobertura**.

---

## Feito para fins educacionais

Este projeto não tem propósito prático.  
É só **elegância desnecessária em estado puro**.

> Porque às vezes... a melhor forma de aprender é ir longe demais de propósito.

---