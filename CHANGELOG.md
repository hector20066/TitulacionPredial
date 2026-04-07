# Changelog

Este proyecto sigue Versionado Semantico (SemVer)

## [Unreleased]
### Planned
- Agregar funcionalidad de generación de reportes avanzados (PDF, gráficos)
- Implementar sistema de auditoría detallada con historial de cambios
- Agregar nuevos temas visuales (Dark Mode, temas de color personalizados)
- Extender soporte a más municipios y departamentos
- Implementar sincronización offline/online de datos
- API REST para integraciones externas

---

## [1.0.0] - 2026-04-07

### Added

#### Gestión de Beneficiarios
- Sistema completo de registro de beneficiarios con validación de datos
- Registro automático de cónyuges para estados civiles: Casado y Unión Libre
- Búsqueda avanzada de beneficiarios por código, nombre y municipio
- Consulta detallada e información resumida de beneficiarios
- Filtrado de beneficiarios por municipio y estado
- Edición y modificación de información de beneficiarios

#### Gestión de Propiedades
- Registro de propiedades con referencia catastral completa
- Registro de puntos geográficos (máximo 4 por propiedad) con coordenadas N/E
- Especificación de distancias y linderos de propiedades
- Consulta detallada de propiedades y su asociación con beneficiarios
- Edición y modificación de información de propiedades

#### Gestión de Resoluciones
- Generación automática de resoluciones en formato Word (.docx)
- Plantillas dinámicas para documentos oficiales
- Inserción automática de datos FMI y notariales
- Modificación y edición de resoluciones existentes
- Consulta y búsqueda de resoluciones

#### Importación y Exportación de Datos
- Importación masiva de beneficiarios desde archivos Excel
- Importación masiva de propiedades desde archivos Excel
- Exportación de datos a Excel con filtros avanzados
- Exportación de reportes con información completa o resumida
- Validación de datos durante importación con reportes de errores

#### Autenticación y Autorización
- Sistema seguro de autenticación con encriptación BCrypt
- Tres niveles de rol de usuario: Administrador, Empleado, Consultor
- Control de acceso granular basado en roles
- Filtrado de datos según municipio asignado al usuario
- Gestión de sesiones de usuario

#### Gestión de Usuarios
- Registro de nuevos usuarios del sistema
- Asignación de roles y municipios por usuario
- Cambio de contraseña con validación de seguridad
- Modificación de información de usuario
- Eliminación de cuentas de usuario
- Listado y búsqueda de usuarios

#### Panel de Control (Dashboard)
- Visualización de estadísticas en tiempo real
- Gráfico de líneas con histórico de 12 meses
- Gráfico tipo gauge para visualización de porcentajes
- Gráfico de dona para distribuciones
- Tarjetas interactivas con información resumida
- Actualización dinámica de datos sin recargar
- Conteo de registros (beneficiarios, propiedades, resoluciones)

#### Internacionalización
- Soporte completo de dos idiomas: Español e Inglés
- Cambio dinámico de idioma sin necesidad de reiniciar la aplicación
- Persistencia de preferencia de idioma del usuario
- Interfaz completamente traducida (menús, botones, mensajes)
- Patrón Observer implementado para actualizaciones en tiempo real

#### Interfaz de Usuario
- Diseño moderno y minimalista con FlatLaf
- Componentes personalizados (RoundedPanel, ShadowPanel, ButtonAction, Card, GaugeChart)
- Navegación intuitiva entre paneles
- Diálogos informativos y de confirmación
- Validación visual de formularios
- Soporte para operaciones asincrónicas con SwingWorker

#### Seguridad
- Encriptación BCrypt para contraseñas de usuarios
- Salt automático en cada hash de contraseña
- Validación exhaustiva de entrada de datos
- Filtrado de datos según roles y municipios asignados
- Pool de conexiones seguro (HikariCP) con timeout configurado
- Manejo robusto de excepciones con mensajes seguros

#### Sistema de Excepciones
- Jerarquía completa de excepciones personalizadas
- Excepciones específicas para cada entidad (Beneficiary, Property, Resolution, etc.)
- Excepciones de validación de entrada (EmptyField, InvalidNumber, MaxLength)
- Mensajes internacionalizados en todas las excepciones
- Cadena de causas para facilitar debugging

#### Testing
- Suite de 42 tests implementados
- Tests de autenticación (Login)
- Tests de dashboard (Carga de tarjetas, gráficos, actualización)
- Tests de gestión de usuarios (CRUD, cambio de contraseña, eliminación)
- Tests de validación de excepciones
- Reportes de Surefire Maven
- Cobertura de funcionalidades principales

#### Configuración
- Gestión centralizada de preferencias de aplicación
- Archivo de configuración para conexión a base de datos
- Información de versión y empresa
- Configuración de pool de conexiones
- Perseverancia de configuraciones del usuario

#### Componentes de Base de Datos
- Modelo relacional normalizado con 6 tablas principales
- Consultas SQL optimizadas para cada entidad
- Índices en campos de búsqueda frecuente
- Validaciones en base de datos
- Script de inicialización (DATABASE.sql)

### Changed

#### Arquitectura
- Implementado patrón MVC completo y separación clara de responsabilidades
- Uso extensivo de Singleton para gestores centrales (SessionManager, LanguageManager)
- Patrón Builder para construcción fluida de entidades y DTOs
- 6 Facades para abstracción de acceso a datos
- Patrón Observer para sistema de cambio de idioma

#### Estructura del Proyecto
- Migración completa a Maven como gestor de dependencias y construcción
- Estructura de directorios de Maven: src/main/java, src/main/resources, src/test/java
- Separación clara entre código principal y código de prueba
- Organización de recursos: config, i18n, images, sql, resoluciones

#### Gestión de Dependencias
- Centralización de todas las dependencias en pom.xml
- Versiones específicas bloqueadas para reproducibilidad
- Dependencias agrupadas por funcionalidad (BD, UI, Logging, etc.)

### Removed

- (N/A para versión inicial)

### Security

- Implementación de encriptación BCrypt con salt automático para todas las contraseñas
- Validación rigorosa de entrada de datos en todos los formularios
- Control de acceso basado en roles (RBAC) en todos los endpoints
- Filtrado obligatorio de datos por municipio asignado
- Uso de HikariCP para conexiones seguras a base de datos con timeout
- Preparación de sentencias SQL para prevenir inyección SQL
- Mensajes de error seguros sin exposición de detalles internos

### Technical Details

#### Estadísticas del Proyecto
- **Archivos Java**: 256 (214 código + 42 tests)
- **Paquetes**: 23
- **Entidades**: 7
- **DTOs**: 32+
- **Excepciones Personalizadas**: 12
- **DAOs**: 6
- **Facades**: 6
- **Controladores**: 29+
- **Componentes Swing**: 15+
- **Líneas de Código Estimadas**: ~35,000+
- **Idiomas Soportados**: 2 (Español, Inglés)

#### Stack Tecnológico
- **Backend**: Java 11+, Maven 3.6+, MVC Architecture
- **Base de Datos**: MySQL 8.0+, HikariCP 7.0.2
- **UI**: Swing, FlatLaf 3.7, MigLayout 5.3, TimingFramework 0.55
- **Documentos**: Apache POI 5.4.0, POI-TL 1.12.2
- **Seguridad**: BCrypt (jbcrypt 0.4)
- **Logging**: SLF4J 2.0.17
- **Testing**: JUnit (Maven Surefire)

#### Patrones de Diseño Implementados
1. **Singleton**: SessionManager, LanguageManager, DAOs, Facades
2. **Builder**: Entidades, DTOs, Controladores
3. **Observer**: LanguageObserver para cambio dinámico de idioma
4. **Facade**: 6 Facades para abstracción de datos
5. **DAO**: 6 DAOs para acceso a datos
6. **DTO**: 32+ DTOs para transferencia entre capas
7. **Strategy**: ValidationUtils, FilterUtils
8. **MVC**: Separación clara M-V-C

---

**Fecha de Lanzamiento**: 7 de abril de 2026  
**Versión Actual**: 1.0.0  
**Estado**: Versión estable lista para despliegue  
**Empresa**: Gestionamos Urbano Rural S.A.S  
**NIT**: 901264438
