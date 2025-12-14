# Parameta Technical Test – Commons Module

Shared **Java 17 / Spring Boot 4** library used by the Parameta Technical Test services (REST and SOAP).  
It centralizes **DTOs, entities, repositories, security (JWT), mappers, exceptions, and utilities** to keep both applications consistent and avoid duplicated code.

---

## ✨ What’s inside

### Core building blocks
- **DTOs**: request/response and domain transfer models (e.g., `EmployeeDTO`, `ResponseGeneralDTO`, `SystemParameterDTO`)
- **Entities (JPA)**: database mapping for the technical test schema (e.g., `employee`, `administrator_user`, `system_parameter`, `blacklist_token`)
- **Repositories**: Spring Data JPA repositories for shared persistence access
- **Mappers (MapStruct)**: clean conversion between entities and DTOs
- **Security foundation**
  - `JwtService` (token generation/validation/claims extraction)
  - `JWTAuthenticationFilter`
  - `TokenBlacklistService` + blacklist repository (logout/revocation)
  - `ApplicationConfig` (AuthenticationProvider, UserDetailsService, PasswordEncoder)
- **Exception layer**
  - `GlobalExceptionHandler`
  - `CustomAuthenticationEntryPoint`
  - `CustomAccessDeniedHandler`
  - `MensajePersonalizadoException`
- **Shared utilities**
  - `GeneralUtil` (safe getters, converters, date parsing, date diff helpers)
  - `TokenStatusEnum` helpers for token validation flows
- **AWS**
  - `AwsS3Config` provides a shared `S3Client` bean

---

## 🧩 How it’s used

This module is meant to be added as a **dependency** in:
- The **REST API** project (controllers + services)
- The **SOAP service** project (SOAP endpoints + persistence)

So both apps share:
- same DTOs + entities
- same repositories (where applicable)
- same security/token logic
- same error handling style
- same utility methods

---

## 📦 Maven coordinates

```xml
<dependency>
  <groupId>co.parameta</groupId>
  <artifactId>technical.test.commons</artifactId>
  <version>0.0.54</version>
</dependency>
````

This artifact is published to **GitHub Packages** (`commons-employee`).

---

## 🔐 GitHub Packages setup (consumer projects)

### 1) Add GitHub Packages repository

In your consumer project `pom.xml`:

```xml
<repositories>
  <repository>
    <id>github</id>
    <url>https://maven.pkg.github.com/parameta-technical-test/commons-employee</url>
  </repository>
</repositories>
```

### 2) Configure `settings.xml`

Create or update `~/.m2/settings.xml`:

```xml
<settings>
  <servers>
    <server>
      <id>github</id>
      <username>${env.GITHUB_USER}</username>
      <password>${env.GITHUB_TOKEN}</password>
    </server>
  </servers>
</settings>
```

> Use a GitHub token with **read:packages** permission.

---

## 🚀 Build & publish (this repository)

### Build

```bash
mvn clean verify
```

### Generate artifacts

The build produces:

* `commons-0.0.54.jar`
* `commons-0.0.54-sources.jar` (maven-source-plugin)
* `commons-0.0.54-javadoc.jar` (maven-javadoc-plugin)

### Deploy to GitHub Packages

```bash
mvn clean deploy
```

---

## ⚙️ Configuration (environment-driven)

This module follows **12-Factor** configuration: values are loaded from environment variables and an optional `.env` file:

```yaml
spring:
  config:
    import: optional:file:.env[.properties]
```

### Required env vars (commonly used by services depending on this module)

#### App

* `SPRING_APPLICATION_NAME`

#### Datasource (Oracle/MySQL compatible)

* `SPRING_DATASOURCE_DRIVER_CLASS_NAME`
* `SPRING_DATASOURCE_URL`
* `SPRING_DATASOURCE_USERNAME`
* `SPRING_DATASOURCE_PASSWORD`

Optional (defaults shown):

* `SPRING_DATASOURCE_HIKARI_MAXIMUM_POOL_SIZE=3`
* `SPRING_DATASOURCE_HIKARI_MINIMUM_IDLE=1`
* `SPRING_DATASOURCE_HIKARI_IDLE_TIMEOUT=60000`
* `SPRING_DATASOURCE_HIKARI_MAX_LIFETIME=180000`
* `SPRING_DATASOURCE_HIKARI_CONNECTION_TIMEOUT=10000`

#### JPA / Hibernate

* `SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.OracleDialect`
* `SPRING_JPA_HIBERNATE_DDL_AUTO=none`
* `SPRING_JPA_SHOW_SQL=true`
* `SPRING_JPA_PROPERTIES_HIBERNATE_FORMAT_SQL=true`
* `SPRING_JPA_PROPERTIES_HIBERNATE_JDBC_TIME_ZONE=UTC`

#### Server

* `SERVER_PORT=8001`

#### Jackson / Timezone

* `JACKSON_TIMEZONE=America/Bogota`

#### Management / Actuator

* `MANAGEMENT_ENDPOINTS_WEB_EXPOSURE_INCLUDE=*`
* `MANAGEMENT_ENDPOINT_HEALTH_SHOW_DETAILS=always`
* `MANAGEMENT_ENDPOINT_HEALTH_PROBES_ENABLED=true`
* `MANAGEMENT_HEALTH_LIVENESSSTATE_ENABLED=true`
* `MANAGEMENT_HEALTH_READINESSSTATE_ENABLED=true`

#### Logging

* `LOGGING_FOLDER_PATH=./logs/`
* `LOGGING_MAX_FILE_SIZE=10MB`
* `LOGGING_TIMEZONE=America/Bogota`

#### JWT

* `JWT_SECRET` *(Base64URL recommended for HS512 usage in jjwt)*

#### AWS (S3)

* `AWS_REGION`
* `AWS_NAME_BUCKET`

---

## 🔐 Security notes

This module provides the base security pieces used by the REST app:

* JWT creation and validation with `jjwt`
* Token revocation via blacklist persistence (`blacklist_token`)
* Authentication wiring via `ApplicationConfig`:

    * `UserDetailsService` loads users from DB by email
    * `BCryptPasswordEncoder` for password verification

---

## 🧾 License

Apache License 2.0 (as declared in `pom.xml`).

---

## 👤 Author

**Brahian Alexander Caceres Guevara**
GitHub: `bcaceres19`
Email: `bacg20044@gmail.com`

