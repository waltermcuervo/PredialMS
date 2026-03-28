# PredialMS

Microservicio que permite generar la consulta del estado de un predio o cuenta catastral.

## 🛠️ Tecnologías utilizadas

- **Java 25**
- **Spring Boot 4.0.5** (Web, Data JPA, Validation)
- **Oracle Database 23** (ojdbc11)
- **Lombok** para reducir el código repetitivo (boilerplate)
- **Springdoc OpenAPI** para la documentación de la API (Swagger UI)
- **Maven 3.9.11** para la gestión de dependencias

## ⚙️ Configuración

Las propiedades principales de la base de datos y la aplicación se configuran en el archivo `src/main/resources/application.properties`:

```properties
spring.application.name=consulta-ms
server.port=8080

# Configuración de la base de datos Oracle
spring.datasource.url=jdbc:oracle:thin:@localhost:1521/FREEPDB1
spring.datasource.username=TOL
spring.datasource.password=admin123
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
```


## 🚀 Cómo ejecutar la aplicación

1. Clonar el repositorio.
   ```bash
   https://github.com/waltermcuervo/PredialMS/tree/release
   ```
   
2. Navegar al directorio raíz del proyecto:
   ```bash
   cd PredialMS
   ```
3. Compilar el proyecto y descarga las dependencias utilizando Maven:
   ```bash
   mvn clean install
   ```
4. Ejecutar la aplicación:
   ```bash
   mvn spring-boot:run
   ```

La aplicación se iniciará por defecto en el puerto `8080`.

## 📖 Endpoints de la API

### Consultar Estado de Cuenta Predial

- **URL:** `/catastro/consultar-cuenta`
- **Método HTTP:** `GET`
- **Cuerpo de la petición (Request Body):**

```json
{
   "codCatastral":"01-01-0001-0010-000",
   "tipoDocumento":"cc",
   "numDocumento":"1049654321"
}
```

- **Respuesta Exitosa (Response):**

```json
{
   "nombre": "Walter Silva",
   "valorDeuda": 0,
   "estado": "al día",
   "contribuyente": {
      "codCatastral": "01-01-0001-0010-000",
      "tipoDocumento": "cc",
      "numDocumento": "1049654321"
   },
   "fechaConsulta": "2026-03-28T17:43:16.4892702"
}
```

## 📚 Documentación Swagger

http://localhost:8080/swagger-ui/index.html
