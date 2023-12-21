# Prueba técnica Muruna

## Descripción
Este proyecto se desarrolló como prueba de conocimientos para postular a la empresa Muruna, fue desarrollado con Java 14, utilizando SpringBoot como framework, con una base de datos volátil HSQLDB y en el editor de código IntelliJ idea.

## Requisitos Previos
Antes de comenzar, asegúrese de tener instalados los siguientes requisitos:
* Java 14
* HSQLDB
* IntelliJ (puede usar eclipse o vscode si lo desea)

## Configuración del Proyecto
A continuación se detallan los pasos necesarios para configurar y ejecutar el proyecto en un entorno local.

Clonar el Repositorio:

```bash
Copy code
    git clone https://github.com/eaviles95/Muruna.git
```
## Configurar la Base de Datos:
Para efectos de este ejercicio, la base de datos viene configurada para funcionar, ya que es una base de datos embebida.

## Ejecutar el Proyecto:
Para probar la aplicación es necesario compilar la aplicación con las dependencias que tiene el archivo pom.xml, luego 
debe generar una configuración de spring boot, con la que finalmente podrá levantar la aplicación accionando el botón Run de IntelliJ.
Para probar los endpoints, puede acceder al siguiente enlace:

```swagger
Copy code
    http://localhost:8081/swagger-ui.html#
```

## Estructura del Proyecto
La estructura del proyecto es la siguiente:

```lua
Copy code

|-- src/
|   |-- main/
|       |-- java/
|       |-- cl.muruna.back/
|           |--config/
|           |--controller/
|           |--dto/
|           |-- exception/
|           |-- model/
|           |-- repository/
|           |-- service/
|           |-- swagger/
|           |-- util/
|       |-- resources/
|   |-- test
|-- ...
```
## Probar endpoints
Todo esto corresponde a si se prueba a través de Swagger.
* Register:
```Json
{
  "createdAt": "2023-12-12T05:51:49.487Z",
  "updatedAt": "2023-12-12T05:51:49.487Z",
  "name": "Juan Rodriguez",
  "mail": "juan@rodriguez.org",
  "password": "hunterds2A.-",
  "phones": [
    {
      "number": "1234567",
      "cityCode": "1",
      "countryCode": "57"
    }
  ]
}
```

* Authenticate:
```Json
{
  "mail": "juan@rodriguez.org",
  "name": "Juan Rodriguez",
  "password": "hunterds2A.-"
}
```
* Get all users:
Solo basta ejecutarlo presionando el botón Execute.
* Delete user:
Basta con poner el UUID del usuario.
* Update user:
```Json
{
    "id": "Cambiar al UUID que corresponda",
    "name": "Juan Rodriguez",
    "mail": "rodriguez@rodriguesz.org",
    "password": "hunterds2A.-",
    "createdAt": "2023-12-12T06:18:44.408-03:00",
    "updatedAt": "2023-12-12T06:20:34.619-03:00",
    "phones": [
      {
        "id": 2,
        "number": "1234167",
        "cityCode": "1",
        "countryCode": "57"
      },
      {
        "id": 1,
        "number": "1234567",
        "cityCode": "1",
        "countryCode": "57"
      }
    ]
  }

```
* update Is Active:
  Corresponde a un soft delete, en donde se actualiza un valor booleano. Se requiere el UUID y el valor en true o false.

## Contacto
Para preguntas o comentarios, comuníquese con enrique.a.aviles.m@gmail.com.
