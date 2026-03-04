# TitulacionPredial

## Formalizacion de la Propiedad - Titulacion Predial

**Formalizacion de la Propiedad** es una aplicacion diseñada para gestionar de manera eficiente los datos de beneficiarios
afiliados al programa de formalizacion de la propiedad de la gobernacion de Córdoba, perteneciente a la empresa
**Gestionamos Urbano Rural S.A.S** con NIT: 901264438.

Gracias a **Formalizacion de la Propiedad** quien este a cargo de la gestion de datos de los beneficiarios podra trabajar de forma productiva ahorrando tiempo con procesos automatizados,
esto evita el uso de archivos excel masivos que dificultan mucho la correcta gestion de la informacion, ofreciendo una interfaz intuitiva perfecta para que cualquier persona la use de forma adecuada.

---

## Funcionalidades Principales

Una vez se inicia el programa quien este a cargo de su uso puede:

- Registar nuevos beneficiarios y predios, si el nuevo beneficiario presenta estado civil: Casado o Union libre entonces tambien se registran los datos de su conyuge.
- Consultar la informacion completa de uno o muchos beneficiarios, informacion resumida de uno o muchos beneficiarios y la informacion completa de un predio y a que beneficiario esta asociado dicho predio.
- Modificar informacion existente de un beneficiario o una resolucion.
- Eliminar la informacion de un beneficiario, conyuge o predio.
- Generar resolucion con la informacion del beneficiario, predio y de la misma resolucion
- Exportar archivo Excel

---

## Tecnologias Usadas

- **Lenguajes de programacion:**
    - Java
- **Apache Maven**
- **Arquitectura MVC**
- **Patrones de Diseño:**
    - DAO
    - Facade
    - Observer
    - Singleton
    - Builder

---

## Estructura del Proyecto

```text
TitulacionPredial/
├── CHANGELOG.md
├── DATABASE.sql
├── pom.xml
├── README.md
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── hector
│   │   │           └── titulacionpredial
│   │   │               ├── app
│   │   │               │   └── Main.java
│   │   │               ├── controller
│   │   │               │   ├── builder
│   │   │               │   └── panels
│   │   │               ├── database
│   │   │               ├── exception
│   │   │               │   ├── dao
│   │   │               │   │   ├── notfound
│   │   │               │   │   └── persistence
│   │   │               │   └── validation
│   │   │               ├── facade
│   │   │               │   ├── impl
│   │   │               │   └── interfaces
│   │   │               ├── i18n
│   │   │               ├── model
│   │   │               │   ├── dao
│   │   │               │   │   ├── impl
│   │   │               │   │   └── interfaces
│   │   │               │   ├── dto
│   │   │               │   │   ├── beneficiary
│   │   │               │   │   ├── property
│   │   │               │   │   └── resolution
│   │   │               │   ├── entities
│   │   │               │   └── enums
│   │   │               ├── observer
│   │   │               ├── utils
│   │   │               └── view
│   │   │                   ├── component
│   │   │                   ├── content
│   │   │                   │   ├── dialogs
│   │   │                   │   └── panels
│   │   │                   ├── i18n
│   │   │                   │   └── dto
│   │   │                   │       ├── dialogs
│   │   │                   │       └── panels
│   │   │                   └── swing
│   │   │                       ├── button
│   │   │                       ├── chart
│   │   │                       │   └── blankchart
│   │   │                       ├── menu
│   │   │                       ├── model
│   │   │                       ├── panel
│   │   │                       ├── scroll
│   │   │                       ├── shadow
│   │   │                       │   ├── chart
│   │   │                       └── system
│   │   └── resources
│   │       ├── config
│   │       ├── i18n
│   │       │   ├── app
│   │       │   └── message
│   │       ├── image
│   │       ├── resolution
│   │       │   └── MINUTA - RES FISCALES.docx
│   │       └── sql
│   │           ├── beneficiary
│   │           ├── point
│   │           ├── property
│   │           ├── resolution
│   │           └── spouse
│   └── test
│       └── java
│           └── com
│               └── hector
│                   └── titulacionpredial
│                       ├── exception
│                       │   ├── dao
│                       │   └── validation
│                       ├── facade
│                       │   └── impl
│                       ├── model
│                       │   ├── dto
│                       │   │   ├── beneficiary
│                       │   │   ├── property
│                       │   │   └── resolution
│                       │   ├── entities
│                       │   └── enums
│                       ├── observer
│                       ├── utils
│                       └── view
│                           └── swing
│                               ├── chart
│                               ├── menu
│                               ├── model
│                               └── shadow
└── target
    └── TitulacionPredial-1.0.0.jar


```
---

##  Objetivo

Facilitar la gestion de información de beneficiarios inscritos en el programa, evitando conflictos con el manejo de grandes cantidades de datos haciendo uso de arhivos excel masivos.

Automatizar procesos como la generación de una resolución, evitando que quien este a cargo de su uso no deba editar una platilla manualmente, 
tambien puede exportar un archivo excel con todos los registros de la base de datos para llevar el control de la cantidad de beneficiarios que se tienen actualmente en el sistema y asi
tener un mejor orden de la información.


--- 

## Autores

Ing. Hector Acevedo

Ing. Juan Bohorquez

---

**Versión:** 1.0

**Fecha de Lanzamiento:** Undefined

**Estado:** En desarrollo




