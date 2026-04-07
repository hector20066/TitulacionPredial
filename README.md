# TitulacionPredial

## Formalización de la Propiedad - Titulación Predial

**Formalización de la Propiedad** es una aplicación de gestión de datos diseñada para beneficiarios del programa de formalización de la propiedad de la Gobernación de Córdoba, operado por **Gestionamos Urbano Rural S.A.S** (NIT: 901264438).

Esta solución permite que los gestores de datos trabajen de forma productiva, ahorrando tiempo mediante procesos automatizados que reemplazan los archivos Excel masivos. Ofrece una interfaz intuitiva y moderna, perfecta para ser utilizada por cualquier persona sin requerir conocimientos técnicos avanzados.

### Versión Actual
- **v1.0.0** - Primera versión estable (2026-04-07)

---

## Funcionalidades Principales

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

## Tecnologías Utilizadas

### Backend & Framework
- **Lenguaje**: Java 11+
- **Build Tool**: Apache Maven 3.6+
- **Arquitectura**: MVC (Model-View-Controller)

### Base de Datos
- **SGBD**: MySQL 8.0+
- **Driver**: MySQL Connector/J 9.5.0
- **Pool de Conexiones**: HikariCP 7.0.2 (máximo 10 conexiones, timeout 30s)

### Interfaz de Usuario
- **Framework GUI**: Swing (Java)
- **Look & Feel**: FlatLaf 3.7 (diseño moderno y acorde)
- **Layout Manager**: MigLayout 5.3 (layouts flexibles)
- **Animaciones**: TimingFramework 0.55
- **Componentes Personalizados**: 15+ componentes Swing customizados

### Generación de Documentos
- **Excel**: Apache POI 5.4.0 (lectura/escritura)
- **Word**: POI-TL 1.12.2 (plantillas dinámicas)

### Seguridad
- **Encriptación**: BCrypt (jbcrypt 0.4) con salt automático

### Logging
- **Framework**: SLF4J 2.0.17 (API + implementación)

### Patrones de Diseño Implementados
- **Singleton**: SessionManager, LanguageManager, DAOs, Facades (una única instancia global)
- **Builder**: Construcción fluida de entidades, DTOs y controladores
- **Observer**: Patrón observable para cambios de idioma sin acoplamiento
- **Facade**: 6 facades que abstraen acceso a datos y lógica de negocio
- **Data Access Object (DAO)**: 6 DAOs para gestión de datos (Beneficiario, Propiedad, Usuario, etc.)
- **Data Transfer Object (DTO)**: 32+ DTOs especializados para transferencia entre capas
- **Strategy**: Validación y filtrado flexible mediante utilidades
- **MVC**: Separación clara entre Modelo, Vista y Controlador

---

## Estructura del Proyecto

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

## Requisitos del Sistema

### Hardware
- Procesador: Mínimo Intel Core i3 o equivalente
- RAM: 4 GB mínimo (8 GB recomendado)
- Almacenamiento: 500 MB disponibles

### Software
- **Java**: Versión 11 o superior
- **MySQL**: Versión 8.0 o superior
- **Sistema Operativo**: Windows 10+, macOS, o Linux (con soporte gráfico X11/Wayland)

---

## Instalación y Configuración

### 1. Prerrequisitos
Asegúrate de tener instalado:
```bash
java -version      # Verificar Java 11+
mvn -version       # Verificar Maven 3.6+
mysql --version    # Verificar MySQL 8.0+
```

### 2. Base de Datos
Ejecuta el script SQL proporcionado para crear la estructura de la base de datos:
```bash
mysql -u root -p < DATABASE.sql
```

### 3. Compilación y Empaquetado
```bash
# Clonar o descargar el proyecto
cd TitulacionPredial

# Compilar y empaquetar
mvn clean package

# El JAR ejecutable estará en: target/TitulacionPredial-1.0.0.jar
```

### 4. Ejecución
```bash
java -jar target/TitulacionPredial-1.0.0.jar
```

### 5. Configuración Inicial
Al primer inicio, la aplicación solicitará:
- Usuario administrador inicial
- Preferencia de idioma (Español/Inglés)

---

## Estructura del Modelo de Datos

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

---

## Excepciones Personalizadas

La aplicación implementa un sistema robusto de excepciones organizadas jerárquicamente:

### Excepciones de Acceso a Datos (DAOException)
- **DataNotFoundException**: Cuando un registro no existe
- **PersistenceException**: Cuando hay errores al guardar datos
- Variantes específicas: BeneficiaryNotFoundException, PropertyPersistenceException, etc.

### Excepciones de Validación (InvalidInputException)
- EmptyFieldException
- InvalidNumberInputException
- MaxLengthExceededException

Todas las excepciones incluyen mensajes internacionalizados para mejor experiencia del usuario.

---

## Seguridad

### Autenticación y Autorización
- Contraseñas encriptadas con **BCrypt** con salt automático
- Sistema de roles de tres niveles
- Control de acceso granular por municipio asignado
- Sesión única por usuario

### Controles de Seguridad
- Validación de entrada en todos los formularios
- Filtrado de datos según rol y municipio
- Logs de operaciones sensibles
- Pool de conexiones seguro con timeout

---

## Desarrollo y Testing

### Suite de Tests
- **42 archivos de test** implementados
- Cobertura de controladores principales (Login, Dashboard, Gestión de Usuarios)
- Tests de validación de jerarquía de excepciones
- Reportes de Surefire Maven

### Ejecutar Tests
```bash
mvn test
```

### Generar Reporte de Tests
```bash
mvn surefire-report:report
```

---

## Componentes Personalizados Swing

La aplicación incluye 15+ componentes personalizados:
- **RoundedPanel**: Paneles con bordes redondeados
- **ShadowPanel**: Paneles con efecto de sombra
- **ButtonAction**: Botones con estilos personalizados
- **Card**: Tarjetas informativas interactivas
- **GaugeChart**: Gráficos tipo gauge (velocímetro)
- **LineChart**: Gráficos de líneas con series múltiples
- Componentes de menú, scroll y navegación optimizados

---

## Internacionalización (i18n)

### Idiomas Soportados
- **Español (ES)**: Idioma por defecto
- **Inglés (EN)**: Alternativo completo

### Características i18n
- Cambio dinámico sin reinicio de la aplicación
- Persistencia de preferencia de idioma
- Patrón Observer para actualización de interfaz
- ResourceBundles para archivos de propiedades traducidas

---

## Contribución y Soporte

Para reportar bugs, solicitar características o contribuir al proyecto, por favor contacta a los autores.

---

## Objetivo del Proyecto

Facilitar la gestión integral de información de beneficiarios inscritos en el programa de formalización de la propiedad, evitando conflictos derivados del manejo de grandes volúmenes de datos en archivos Excel masivos.

### Procesos Automatizados
- Generación automática de resoluciones oficiales
- Exportación e importación de datos en Excel
- Búsqueda y filtrado avanzado
- Generación de reportes y estadísticas

### Ventajas
- Interfaz intuitiva y fácil de usar
- Reducción de tiempo en procesamiento de datos
- Mayor precisión en registros
- Control centralizado de información
- Auditoría completa de operaciones

---

## Autores

- **Ing. Hector Acevedo**
- **Ing. Juan Bohorquez**

---

## Información del Proyecto

- **Nombre**: TitulacionPredial
- **Descripción**: Sistema de Gestión de Formalización de Propiedad
- **Versión Actual**: 1.0.0
- **Fecha de Lanzamiento**: 7 de abril de 2026
- **Estado**: Versión estable lista para despliegue
- **Licencia**: (Especificar según corresponda)
- **Empresa**: Gestionamos Urbano Rural S.A.S (NIT: 901264438)
- **Ámbito**: Gobernación de Córdoba, Colombia






