# TitulacionPredial 📋

## Sistema de Gestión de Formalización de Propiedad - Titulación Predial

[![Java](https://img.shields.io/badge/Java-11--25+-orange.svg)](https://www.java.com/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-C71A36.svg)](https://maven.apache.org/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-4479A1.svg)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-Proprietario-blue.svg)](#licencia)

**Formalización de la Propiedad** es una aplicación profesional de gestión de datos diseñada para facilitar la administración integral del programa de formalización de la propiedad de la Gobernación de Córdoba, operado por **Gestionamos Urbano Rural S.A.S** (NIT: 901264438).

Esta solución permite que los gestores de datos trabajen de forma productiva y eficiente, reduciendo significativamente el tiempo mediante procesos automatizados que reemplazan los archivos Excel masivos. Ofrece una interfaz intuitiva y moderna, perfecta para ser utilizada por cualquier persona sin requerir conocimientos técnicos avanzados.

### 📌 Información de la Versión
- **Versión Actual**: v1.0.0
- **Estado**: ✅ Versión estable lista para despliegue
- **Fecha de Lanzamiento**: 7 de abril de 2026
- **Última Actualización**: 23 de abril de 2026

---

## 📑 Tabla de Contenidos
- [Descripción General](#descripción-general)
- [Funcionalidades Principales](#funcionalidades-principales)
- [Requisitos del Sistema](#requisitos-del-sistema)
- [Instalación y Configuración](#instalación-y-configuración)
- [Uso de la Aplicación](#uso-de-la-aplicación)
- [Arquitectura del Proyecto](#arquitectura-del-proyecto)
- [Estructura del Modelo de Datos](#estructura-del-modelo-de-datos)
- [Tecnologías Utilizadas](#tecnologías-utilizadas)
- [Patrones de Diseño](#patrones-de-diseño)
- [Seguridad](#seguridad)
- [Desarrollo y Testing](#desarrollo-y-testing)
- [Despliegue](#despliegue)
- [Resolución de Problemas](#resolución-de-problemas)
- [Contribución](#contribución)
- [Autores y Contacto](#autores-y-contacto)
- [Licencia](#licencia)

---

## Descripción General

TitulacionPredial es un sistema empresarial que automatiza completamente la gestión de beneficiarios, propiedades y documentos relacionados con el programa de formalización de tierras. Su objetivo es eliminar la dependencia de archivos Excel masivos, proporcionando una solución centralizada, segura y escalable.

### Problema Resuelto
- ❌ Archivos Excel masivos sin control de versiones
- ❌ Riesgo de pérdida de datos
- ❌ Duplicidad de registros
- ❌ Procesos manuales lentos y propensos a errores
- ❌ Falta de auditoría y trazabilidad

### Solución Proporcionada
- ✅ Base de datos centralizada y segura
- ✅ Controles de integridad de datos
- ✅ Automatización de procesos
- ✅ Generación automática de documentos oficiales
- ✅ Auditoría completa y trazabilidad

---

## Funcionalidades Principales 🎯

### Gestión de Beneficiarios y Datos
- Registrar nuevos beneficiarios y predios con soporte para cónyuges (Casado/Unión Libre)
- Consultar información completa o resumida de beneficiarios
- Buscar beneficiarios por código, nombre o municipio
- Modificar información existente de beneficiarios y resoluciones
- Eliminar información de beneficiarios, cónyuges o predios
- Filtrado avanzado por municipio y estado

### Gestión de Propiedades
- Registro de propiedades con referencia catastral completa
- Registro de puntos geográficos con coordenadas N/E (máximo 4 por propiedad)
- Especificación de distancias y linderos
- Consulta detallada de propiedades y su asociación con beneficiarios

### Generación de Documentos
- Generación automática de resoluciones en formato Word (.docx)
- Inserción de datos FMI y notariales
- Plantillas personalizadas para documentos oficiales
- Exportación a archivos Excel con filtros avanzados
- Importación masiva de datos desde Excel

### Gestión de Usuarios y Seguridad
- Autenticación segura con encriptación BCrypt
- Tres niveles de acceso: Administrador, Empleado, Consultor
- Control de acceso por municipio asignado
- Cambio de contraseña con validación
- Gestión completa de cuentas de usuario

### Panel de Control (Dashboard)
- Visualización de estadísticas en tiempo real
- Gráficos de líneas (12 meses histórico)
- Gráficos de gauge para porcentajes
- Gráficos tipo dona para distribuciones
- Tarjetas interactivas con información resumida
- Actualización dinámica de datos

### Internacionalización
- Soporte multiidioma: Español e Inglés
- Cambio dinámico de idioma sin reinicio de aplicación
- Persistencia de preferencia de idioma del usuario
- Interfaz completamente traducida

### Configuración y Administración
- Gestión centralizada de preferencias
- Información de la empresa y versión
- Configuración de conexión a base de datos
- Logs de operaciones para auditoría

---

## Tecnologías Utilizadas ⚙️

### Backend & Framework
- **Lenguaje**: Java 11+ (JDK 25 recomendado)
- **Build Tool**: Apache Maven 3.6+
- **Arquitectura**: MVC (Model-View-Controller)
- **Patrón Principal**: Facades + DAOs + DTOs

### Base de Datos
- **SGBD**: MySQL 8.0+
- **Driver**: MySQL Connector/J 9.5.0
- **Pool de Conexiones**: HikariCP 7.0.2 
  - Máximo 10 conexiones simultáneas
  - Timeout: 30 segundos
  - Idle timeout: 10 minutos

### Interfaz de Usuario
- **Framework GUI**: Java Swing
- **Look & Feel**: FlatLaf 3.7 (diseño moderno y acorde)
- **Layout Manager**: MigLayout 5.3 (layouts flexibles y responsivos)
- **Animaciones**: TimingFramework 0.55 (transiciones suaves)
- **Componentes Personalizados**: 15+ componentes Swing customizados

### Generación de Documentos
- **Excel**: Apache POI 5.4.0 (lectura/escritura de .xlsx)
- **Word**: POI-TL 1.12.2 (plantillas dinámicas .docx)

### Seguridad
- **Encriptación de Contraseñas**: BCrypt (jbcrypt 0.4)
  - Salt automático
  - Función hash iterativa
  - Resistencia a ataques de fuerza bruta

### Logging
- **Framework**: SLF4J 2.0.17
  - API de logging flexible
  - Implementación: SLF4J Simple
  - Salida a consola y archivo

### Testing
- **Framework**: JUnit 5 (Jupiter) 5.11.4
- **Mocking**: Mockito 5.15.2
- **Cobertura**: 42 archivos de test

---

## Patrones de Diseño 🎨

La aplicación implementa varios patrones de diseño reconocidos:

### **Singleton** 🔒
- **Uso**: SessionManager, LanguageManager, DAOs, Facades
- **Propósito**: Garantizar una única instancia global
- **Ventaja**: Control centralizado de recursos compartidos

### **Builder** 🏗️
- **Uso**: Construcción de entidades, DTOs y controladores
- **Propósito**: Construcción fluida y flexible de objetos complejos
- **Ventaja**: Código más legible y mantenible

### **Observer** 👀
- **Uso**: Patrón observable para cambios de idioma
- **Propósito**: Desacoplar componentes que necesitan reaccionar a cambios
- **Ventaja**: Actualizaciones automáticas sin referencias circulares

### **Facade** 🪟
- **Uso**: 6 facades que abstraen acceso a datos
- **Propósito**: Simplificar interacción con subsistemas complejos
- **Ventaja**: Interfaz unificada hacia la capa de datos

### **Data Access Object (DAO)** 🗄️
- **Uso**: 6 DAOs para gestión de entidades (Beneficiary, Property, User, etc.)
- **Propósito**: Abstracción de acceso a datos
- **Ventaja**: Separación entre lógica y persistencia

### **Data Transfer Object (DTO)** 📦
- **Uso**: 32+ DTOs especializados para transferencia entre capas
- **Propósito**: Transportar datos sin exponer la estructura interna
- **Ventaja**: Flexibilidad en cambios de modelos

### **Strategy** 🎯
- **Uso**: Validación y filtrado flexible mediante utilidades
- **Propósito**: Encapsular algoritmos intercambiables
- **Ventaja**: Fácil extensión sin modificar código existente

### **MVC** 📐
- **Uso**: Separación clara entre Modelo, Vista y Controlador
- **Propósito**: Organización lógica de la aplicación
- **Ventaja**: Mantenimiento y testing simplificado

---

## Excepciones Personalizadas ⚠️

La aplicación implementa un sistema robusto y jerárquico de excepciones:

### Jerarquía de Excepciones

```
Exception
├── ApplicationException (Base personalizada)
│   ├── DAOException
│   │   ├── DataNotFoundException
│   │   │   ├── BeneficiaryNotFoundException
│   │   │   ├── PropertyNotFoundException
│   │   │   ├── ResolutionNotFoundException
│   │   │   ├── UserNotFoundException
│   │   │   └── SpouseNotFoundException
│   │   └── PersistenceException
│   │       ├── BeneficiaryPersistenceException
│   │       ├── PropertyPersistenceException
│   │       ├── ResolutionPersistenceException
│   │       ├── UserPersistenceException
│   │       ├── SpousePersistenceException
│   │       └── PointPersistenceException
│   └── ValidationException
│       ├── EmptyFieldException
│       ├── InvalidNumberInputException
│       └── MaxLengthExceededException
```

### Características

**Internacionalización**: 
Todos los mensajes de excepción están traducidos a Español e Inglés

**Información Detallada**:
Cada excepción proporciona contexto útil para debugging

**Manejo Seguro**:
Los mensajes de excepción no exponen información sensible en producción

```
TitulacionPredial/
├── ANALISIS_PROYECTO_v1.0.0.md          # Análisis técnico detallado del proyecto
├── CHANGELOG.md                          # Historial de cambios y versiones
├── DATABASE.sql                          # Script de base de datos
├── README.md                             # Este archivo
├── nbactions.xml                         # Configuración de NetBeans
├── pom.xml                               # Configuración de Maven
├── .gitignore                            # Configuración de Git
├── libs/                                 # Librerías externas
│   ├── README.md
│   ├── gradient-icon-font.jar
│   └── TimingFramework-0.55.jar
├── src/
│   ├── main/
│   │   ├── java/com/hector/titulacionpredial/
│   │   │   ├── app/                                                    # Punto de entrada de la aplicación
│   │   │   ├── controller/                                             # Controladores principales del sistema
│   │   │   │   ├── builder/                                            # Builders de controladores (14 clases)
│   │   │   │   └── panels/                                             # Controladores de paneles (11 clases)
│   │   │   ├── database/                                               # Gestión de conexiones BD (HikariCP)
│   │   │   ├── exception/                                              # Excepciones personalizadas jerárquicas
│   │   │   │   ├── dao/                                                # Excepciones de acceso a datos
│   │   │   │   │   ├── notfound/                                       # Excepciones cuando no existe registro (5)
│   │   │   │   │   └── persistence/                                    # Excepciones al guardar/actualizar (6)
│   │   │   │   └── validation/                                         # Excepciones de validación (4)
│   │   │   ├── facade/                                                 # Facades para abstracción de datos (6)
│   │   │   │   ├── impl/                                               # Implementaciones de facades
│   │   │   │   └── interfaces/                                         # Contratos de facades
│   │   │   ├── i18n/                                                   # Internacionalización y gestión de idiomas
│   │   │   ├── model/                                                  # Modelos de datos y lógica de negocio
│   │   │   │   ├── dao/                                                # Data Access Objects (6 DAOs)
│   │   │   │   │   ├── impl/                                           # Implementaciones de DAOs
│   │   │   │   │   └── interfaces/                                     # Contratos DAO
│   │   │   │   ├── dto/                                                # Data Transfer Objects (30+ DTOs)
│   │   │   │   │   ├── beneficiary/                                    # DTOs especializados
│   │   │   │   │   ├── property/                                       # DTOs especializados
│   │   │   │   │   ├── resolution/                                     # DTOs especializados
│   │   │   │   │   └── user/                                           # DTOs especializados
│   │   │   │   ├── entities/                                           # Entidades (7 clases base)
│   │   │   │   ├── enums/                                              # Enumeraciones (4: Role, MaritalStatus, Etc.)
│   │   │   │   └── security/                                           # Encriptación BCrypt de contraseñas
│   │   │   ├── observer/                                               # Patrón Observer para cambios de idioma
│   │   │   ├── service/                                                # Servicios de autenticación y lógica
│   │   │   ├── utils/                                                  # Utilidades (14 clases)
│   │   │   │   ├── generation/                                         # Generación Excel y Word
│   │   │   │   ├── managers/                                           # Gestores Singleton
│   │   │   │   ├── validation/                                         # Validaciones de datos
│   │   │   │   └── helpers/                                            # Herramientas auxiliares
│   │   │   └── view/                                                   # Vista (Swing)
│   │   │       ├── component/                                          # Componentes principales (4)
│   │   │       ├── content/                                            # Contenidos por rol (4 paneles + diálogos)
│   │   │       │   ├── dialogs/                                        # Diálogos auxiliares
│   │   │       │   └── panels/                                         # Paneles de funcionalidad (11 paneles)
│   │   │       ├── i18n/                                               # Recursos i18n (18 DTOs de textos)
│   │   │       └── swing/                                              # Componentes Swing personalizados
│   │   │           ├── button/                                         # Botones personalizados
│   │   │           ├── chart/                                          # Gráficos y tarjetas
│   │   │           ├── menu/                                           # Sistema de menú personalizado
│   │   │           ├── model/                                          # Modelos Swing
│   │   │           ├── panel/                                          # Paneles con bordes y sombras
│   │   │           ├── scroll/                                         # Barras de desplazamiento
│   │   │           ├── shadow/                                         # Efectos de sombra
│   │   │           └── system/                                         # Utilidades de sistema
│   │   └── resources/                                                  # Recursos de la aplicación
│   │       ├── config/                                                 # Propiedades de configuración
│   │       ├── i18n/                                                   # Internacionalización (Español/Inglés)
│   │       │   ├── app/                                                # Textos de la app
│   │       │   └── message/                                            # Mensajes del sistema
│   │       ├── image/                                                  # Recursos gráficos (35+ iconos)
│   │       ├── resolution/                                             # Plantillas Word
│   │       └── sql/                                                    # Scripts SQL (70+ consultas organizadas)
│   │           ├── beneficiary/                                        # Consultas de beneficiarios (16)
│   │           ├── point/                                              # Consultas geográficas (2)
│   │           ├── property/                                           # Consultas de propiedades (12)
│   │           ├── resolution/                                         # Consultas de resoluciones (7)
│   │           ├── spouse/                                             # Consultas de cónyuges (3)
│   │           └── user/                                               # Consultas de usuarios (6)
└── test/java/com/hector/titulacionpredial/                             # 42 test files
    ├── controller/                                                     # Tests de controladores
    │   └── panels/                                                     # Tests de paneles
    ├── exception/                                                      # Tests de excepciones
    │   ├── dao/                                                        # Tests DAO
    │   └── validation/                                                 # Tests de validación
    ├── facade/impl/                                                    # Tests de Facades (5 tests)
    ├── model/                                                          # Tests de modelos
    │   ├── dto/                                                        # Tests de DTOs (13 tests)
    │   ├── entities/                                                   # Tests de entidades (6 tests)
    │   └── enums/                                                      # Tests de enumeraciones (3 tests)
    ├── observer/                                                       # Tests de Observer
    ├── utils/                                                          # Tests de utilidades (4 tests)
    └── view/swing/                                                     # Tests de componentes Swing (6 tests)
└── target/                                                             # Directorio de compilación (Maven)
    ├── classes/
    ├── generated-sources/
    ├── generated-test-sources/
    ├── maven-archiver/
    ├── TitulacionPredial-1.0.0.jar                                     # JAR ejecutable
    └── ... (archivos de compilación)
```

### Resumen de la Estructura
| Componente | Cantidad | Descripción |
|------------|----------|-------------|
| **Archivos Java** | 256 | 214 código principal + 42 tests |
| **Paquetes** | 23 | Organizados por función |
| **Controladores** | 29+ | Punto de entrada de lógica |
| **Builders** | 14 | Construcción fluida de controladores |
| **Facades** | 6 | Abstracción de acceso a datos |
| **DAOs** | 6 | Gestión de persistencia |
| **DTOs** | 30+ | Transferencia de datos entre capas |
| **Entidades** | 7 | Modelos de negocio |
| **Excepciones** | 12 | Manejo robusto de errores |
| **Componentes Swing** | 15+ | Interfaz personalizada |
| **Consultas SQL** | 70+ | Scripts organizados por entidad |
| **Archivos i18n** | 38+ | Soporte multiidioma |
| **Test Files** | 42 | Cobertura completa |
---

## Requisitos del Sistema 🖥️

### Hardware
- **Procesador**: Intel Core i3 o equivalente (mínimo), i5+ recomendado
- **RAM**: 4 GB mínimo (8 GB recomendado para mejor rendimiento)
- **Almacenamiento**: 500 MB disponibles (1 GB recomendado para datos)
- **Pantalla**: Resolución mínima 1024x768 (1920x1080 recomendada)

### Software
- **Java**: Versión 11 o superior (Java 25 recomendada)
- **MySQL**: Versión 8.0 o superior
- **Sistema Operativo**: 
  - Windows 10/11+
  - macOS 10.12+
  - Linux (Ubuntu 18.04+, Fedora 28+, etc.)

---

## Instalación y Configuración 🚀

### Paso 1: Verificar Requisitos Previos

Antes de comenzar, verifica que todos los requisitos están instalados:

```bash
# Verificar Java (debe ser versión 11+)
java -version

# Verificar Maven (debe ser versión 3.6+)
mvn -version

# Verificar MySQL (debe ser versión 8.0+)
mysql --version
```

**Ejemplo de salida esperada:**
```
openjdk version "25" 2024-09-17
Java(TM) SE Runtime Environment (build 25+37-2930)

Apache Maven 3.8.1
Maven home: /opt/maven
Java version: 25

mysql  Ver 8.0.35-0ubuntu0.22.04.1 for Linux on x86_64
```

### Paso 2: Preparar la Base de Datos

#### Opción A: MySQL instalado en el sistema
```bash
# Conectarse como usuario root
mysql -u root -p

# En el prompt de MySQL, ejecutar:
source DATABASE.sql;

# Verificar que se creó la base de datos
SHOW DATABASES;
```

#### Opción B: Archivo SQL
```bash
# Ejecutar el script desde la línea de comandos
mysql -u root -p < DATABASE.sql

# Crear usuario específico para la aplicación (opcional pero recomendado)
mysql -u root -p -e "CREATE USER 'titulacionpredial'@'localhost' IDENTIFIED BY 'password_seguro';"
mysql -u root -p -e "GRANT ALL PRIVILEGES ON TitulacionPredial.* TO 'titulacionpredial'@'localhost';"
mysql -u root -p -e "FLUSH PRIVILEGES;"
```

### Paso 3: Descargar el Proyecto

```bash
# Opción A: Si está en un repositorio Git
git clone https://github.com/hector20066/TitulacionPredial.git
cd TitulacionPredial

# Opción B: Descargar como ZIP y extraer
# (Luego navegar a la carpeta descomprimida)
```

### Paso 4: Compilación y Empaquetado

```bash
# Navegar al directorio del proyecto
cd TitulacionPredial

# Limpiar compilaciones anteriores
mvn clean

# Compilar y empaquetar el proyecto
mvn package -DskipTests

# Si deseas ejecutar los tests (opcional)
mvn clean package

# El JAR ejecutable se creará en: target/TitulacionPredial-1.0.0.jar
```

### Paso 5: Ejecutar la Aplicación

```bash
# Ejecución básica
java -jar target/TitulacionPredial-1.0.0.jar

# Ejecución con más memoria (si es necesario)
java -Xmx2G -jar target/TitulacionPredial-1.0.0.jar

# Ejecución en background (Linux/Mac)
nohup java -jar target/TitulacionPredial-1.0.0.jar &
```

### Paso 6: Configuración Inicial

Al ejecutar la aplicación por primera vez:

1. **Pantalla de Bienvenida**: Se te solicitará:
   - Usuario administrador inicial (recomendado: admin)
   - Contraseña (debe tener mínimo 8 caracteres)
   - Preferencia de idioma (Español o Inglés)

2. **Primera Sesión**:
   - Inicia con las credenciales creadas
   - Navega a "Gestión de Usuarios" para crear más usuarios
   - Asigna roles (Administrador, Empleado, Consultor) y municipios

3. **Configuración de Municipios**:
   - Define los municipios disponibles para el sistema
   - Asigna municipios a cada usuario según su responsabilidad

---

## Uso de la Aplicación 📱

### Flujo de Trabajo Principal

```
Login → Dashboard → Seleccionar Función → Procesar Datos → Generar Reportes
```

### Roles de Usuario y Permisos

| Rol | Registrar | Modificar | Consultar | Generar Documentos | Administrar |
|-----|-----------|-----------|-----------|-------------------|-------------|
| **Administrador** | ✅ | ✅ | ✅ | ✅ | ✅ |
| **Empleado** | ✅ | ✅ | ✅ | ✅ | ❌ |
| **Consultor** | ❌ | ❌ | ✅ | ❌ | ❌ |

### Procesos Típicos

#### 1. Registrar un Nuevo Beneficiario
```
Inicio → Gestión de Beneficiarios → Nuevo Beneficiario
→ Completar Formulario → Guardar
→ Opcional: Agregar Cónyuge y Propiedades
```

#### 2. Importar Datos desde Excel
```
Inicio → Importación/Exportación → Importar Beneficiarios
→ Seleccionar Archivo Excel → Validar Datos
→ Resolver Errores (si hay) → Confirmar Importación
```

#### 3. Generar Resolución
```
Gestión de Beneficiarios → Seleccionar Beneficiario
→ Propiedades → Seleccionar Propiedad
→ Generar Resolución → Descargar Documento Word
```

#### 4. Exportar Reportes
```
Reportes → Seleccionar Tipo de Reporte
→ Aplicar Filtros (Municipio, Rango de Fechas)
→ Exportar a Excel → Descargar Archivo
```

---

## Arquitectura del Proyecto 🏗️

### Diagrama General de Capas

```
┌─────────────────────────────────────┐
│     CAPA DE PRESENTACIÓN (View)     │
│  - Componentes Swing Personalizados │
│  - Interfaz de Usuario              │
│  - Internacionalización             │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│  CAPA DE CONTROLADORES (Controller)  │
│  - Coordinación de eventos          │
│  - Builders de controladores        │
│  - Gestión de paneles               │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│   CAPA DE SERVICIOS (Service)       │
│  - Lógica de autenticación          │
│  - Servicios de negocio             │
│  - Validaciones                     │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│    CAPA DE ACCESO A DATOS           │
│  - DAOs (Data Access Objects)       │
│  - Facades (Abstracción)            │
│  - Pool de conexiones (HikariCP)    │
└──────────────┬──────────────────────┘
               │
┌──────────────▼──────────────────────┐
│   BASE DE DATOS (MySQL)             │
│  - Tablas de datos                  │
│  - Índices                          │
│  - Consultas optimizadas            │
└─────────────────────────────────────┘
```

### Componentes Principales

#### **View (Presentación)**
- `LogIn.java`: Pantalla de autenticación
- Paneles especializados por función
- Componentes Swing personalizados (Chart, Card, Panel redondeado, etc.)

#### **Controller (Controladores)**
- `Coordinator.java`: Coordinador principal
- `ControllerLogin.java`: Gestión de login
- Builders para construir controladores específicos
- Controladores de paneles para cada sección

#### **Model (Modelos)**
- Entidades: Beneficiary, Property, Resolution, User, etc.
- DTOs: Objetos de transferencia de datos
- Enumeraciones: Role, MaritalStatus, etc.

#### **Service (Servicios)**
- `LoginService.java`: Autenticación y validación
- Servicios de lógica de negocio
- Validaciones personalizadas

#### **Facade (Abstracción)**
- 6 Facades que abstraen la complejidad de DAOs
- Interfaz simplificada para controladores
- Manejo centralizado de excepciones

#### **DAO (Acceso a Datos)**
- 6 DAOs para entidades principales
- CRUD (Create, Read, Update, Delete)
- Consultas SQL organizadas

#### **Database (Conexiones)**
- Pool de conexiones HikariCP
- Gestión de conexiones segura
- Configuración centralizada

#### **Utils (Utilidades)**
- Generadores de Excel y Word
- Validadores de datos
- Gestores Singleton
- Herramientas auxiliares

#### **Observer (Patrón Observer)**
- Sistema para cambios de idioma
- Actualización de interfaz sin acoplamiento
- Notificaciones de cambios

---

---

## Estructura del Modelo de Datos 🗂️

### Entidades Principales
- **Beneficiary**: Persona beneficiaria del programa
- **Spouse**: Cónyuge del beneficiario (si aplica)
- **Property**: Propiedad o predio del beneficiario
- **Point**: Puntos geográficos de la propiedad (máximo 4)
- **Resolution**: Documento de resolución generado
- **User**: Usuario del sistema

### Enumeraciones
- **Role**: ADMIN, EMPLOYEE, READER
- **MaritalStatus**: SINGLE, MARRIED, FREE_UNION, WIDOWED, DIVORCED
- **Department**: CORDOBA
- **Municipalities**: MONTERIA, SAHAGUN (extensible)

### Diagrama Relacional (Simplificado)

```
┌─────────────┐         ┌──────────────┐
│  User       │         │  Beneficiary │
├─────────────┤      ┌──┤──────────────┤
│ id          │      │  │ id           │
│ username    │      │  │ code         │
│ password    │      │  │ name         │
│ role        │      │  │ email        │
│ municipality│      │  │ phone        │
└─────────────┘      │  │ maritalStatus
                     │  │ user_id      │
                     │  └──────────────┘
                     │         │
    ┌────────────────┤         │
    │                │         │
┌───▼─────────┐  ┌───▼──────────────┐
│ Property    │  │ Spouse           │
├─────────────┤  ├──────────────────┤
│ id          │  │ id               │
│ cadastral   │  │ name             │
│ location    │  │ maritalStatus    │
│ beneficiary │  │ beneficiary_id   │
└────┬────────┘  └──────────────────┘
     │
     │
┌────▼──────┐
│ Point      │
├────────────┤
│ id         │
│ latitude   │
│ longitude  │
│ distance   │
│ property_id
└────────────┘
```

---

## Seguridad 🔐
```

### Problema: Interfaz gráfica no se ve correctamente

**Síntomas**: Botones cortados, textos ilegibles

**Soluciones**:
1. Verificar resolución de pantalla (mínimo 1024x768)
2. Actualizar drivers de video
3. En Linux, especificar ambiente gráfico:
   ```bash
   export DISPLAY=:0
   java -jar TitulacionPredial-1.0.0.jar
   ```

### Problema: Datos no se guardan

**Síntomas**: Los registros se pierden después de cerrar

**Soluciones**:
1. Verifica que MySQL está corriendo
2. Comprueba permisos de usuario en base de datos
3. Revisa logs para mensajes de error:
   ```bash
   tail -n 50 logs/error.log
   ```

### Logs y Debugging

Para habilitar logs detallados, modifica `logback.xml`:
```xml
<root level="DEBUG">
    <appender-ref ref="STDOUT" />
    <appender-ref ref="FILE" />
</root>
```

---

## Contribución 🤝

### Reportar Bugs

Si encuentras un error, por favor proporciona:
1. Descripción clara del problema
2. Pasos para reproducir
3. Versión de la aplicación y sistema operativo
4. Logs relevantes (si es posible)

### Solicitar Características

Para sugerir nuevas características:
1. Describe el caso de uso
2. Explica el beneficio esperado
3. Proporciona ejemplos si es posible

### Proceso de Contribución

1. Fork del repositorio
2. Crear rama feature (`git checkout -b feature/NuevaFuncionalidad`)
3. Commit de cambios (`git commit -am 'Agrega nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/NuevaFuncionalidad`)
5. Pull Request con descripción detallada

### Estándares de Código

- Seguir convenciones de nombres de Java
- Documentar métodos públicos con Javadoc
- Mantener cobertura de tests >80%
- Ejecutar tests antes de hacer commit: `mvn test`

---

## Autores y Contacto 👥

### Desarrolladores Principales
- **Ing. Hector Acevedo** 
  - Email: hectorluisacevedocontreras00@gmail.com
  - Rol: Arquitecto y Desarrollador Principal

- **Ing. Juan Bohórquez**
  - Email: juanpablobohorquez0713@gmail.com
  - Rol: Desarrollador

---

## Licencia 📜

Este proyecto es **software propietario** desarrollado para la Gobernación de Córdoba.

**Términos de Uso**:
- ✅ Uso autorizado por la Gobernación de Córdoba
- ✅ Distribución interna permitida
- ❌ Redistribución externa prohibida
- ❌ Modificación sin autorización prohibida
- ❌ Venta o comercialización prohibida

Para términos legales completos, contacta a la empresa desarrolladora.

**Derechos de Autor**: © 2026 Gestionamos Urbano Rural S.A.S. Todos los derechos reservados.

---

## Recursos Adicionales 📚

### Documentación Interna
- [ANALISIS_PROYECTO_v1.0.0.md](ANALISIS_PROYECTO_v1.0.0.md) - Análisis técnico detallado
- [CHANGELOG.md](CHANGELOG.md) - Historial de versiones y cambios
- [DATABASE.sql](DATABASE.sql) - Script de base de datos

### Referencias Externas
- [Java Documentation](https://docs.oracle.com/en/java/)
- [Apache Maven Guide](https://maven.apache.org/guides/)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [Swing Tutorial](https://docs.oracle.com/javase/tutorial/uiswing/)

### Herramientas Útiles
- [Visual Studio Code](https://code.visualstudio.com/) - Editor recomendado
- [NetBeans IDE](https://netbeans.apache.org/) - IDE alternativo
- [MySQL Workbench](https://www.mysql.com/products/workbench/) - Gestor de BD
- [Git](https://git-scm.com/) - Control de versiones

---

## Información del Proyecto 📋

| Aspecto | Detalle                                          |
|--------|--------------------------------------------------|
| **Nombre** | TitulacionPredial                                |
| **Descripción** | Sistema de Gestión de Formalización de Propiedad |
| **Versión Actual** | 1.0.0                                            |
| **Fecha de Lanzamiento** | 23 de abril de 2026                              |
| **Última Actualización** | 23 de abril de 2026                              |
| **Estado** | ✅ Versión estable lista para despliegue          |
| **Empresa** | Gestionamos Urbano Rural S.A.S                   |
| **NIT** | 901264438                                        |
| **Ámbito** | Gobernación de Córdoba, Colombia                 |
| **Lenguaje Principal** | Java 11+ (Java 25)                               |
| **Base de Datos** | MySQL 8.0+                                       |

---

## ¿Preguntas o Comentarios?

Si tienes preguntas sobre este proyecto, no dudes en:
1. Consultar la documentación técnica (ANALISIS_PROYECTO_v1.0.0.md)
2. Revisar el CHANGELOG para actualizaciones recientes
3. Contactar al equipo de desarrollo
4. Crear un issue en el repositorio

---

**Última actualización: 23 de abril de 2026**

---






