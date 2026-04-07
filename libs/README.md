# Instalación de librerías locales en Maven

Este proyecto utiliza algunas librerías externas que no están disponibles en repositorios públicos de Maven, por lo que es necesario instalarlas manualmente en el repositorio local.

## Requisitos

* Tener Maven instalado y configurado en el sistema.
* Tener acceso a la terminal (Linux o Windows).

---

## Ubicación de las librerías

Las librerías se encuentran dentro del proyecto en la siguiente ruta:

```
TitulacionPredial/libs
```

Archivos incluidos:

* `TimingFramework-0.55.jar`
* `gradient-icon-font.jar`

---

# Instalación en Linux (Recomendado)

## 1. Ir a la carpeta de librerías

```bash
cd TitulacionPredial/libs
```

## 2. Instalar TimingFramework

```bash
mvn install:install-file \
-Dfile=TimingFramework-0.55.jar \
-DgroupId=org.jdesktop \
-DartifactId=timingframework \
-Dversion=0.55 \
-Dpackaging=jar
```

## 3. Instalar gradient-icon-font

```bash
mvn install:install-file \
-Dfile=gradient-icon-font.jar \
-DgroupId=com.custom.ui \
-DartifactId=gradient-icon-font \
-Dversion=1.0 \
-Dpackaging=jar
```

---

# Instalación en Windows

## 1. Ir a la carpeta de librerías

Abrir CMD o PowerShell y ejecutar:

```bat
cd TitulacionPredial\libs
```

## 2. Instalar TimingFramework

```bat
mvn install:install-file -Dfile=TimingFramework-0.55.jar -DgroupId=org.jdesktop -DartifactId=timingframework -Dversion=0.55 -Dpackaging=jar
```

## 3. Instalar gradient-icon-font

```bat
mvn install:install-file -Dfile=gradient-icon-font.jar -DgroupId=com.custom.ui -DartifactId=gradient-icon-font -Dversion=1.0 -Dpackaging=jar
```

---

## Verificación

Después de instalar ambas librerías, ejecutar en la raíz del proyecto:

```bash
mvn clean install
```

Si todo está correcto, Maven debería compilar el proyecto sin errores de dependencias.

---

## Notas importantes

* Los valores de `groupId`, `artifactId` y `version` deben coincidir exactamente con los definidos en el `pom.xml`.
* No cambiar los nombres de los archivos `.jar`.
* Este proceso solo se realiza una vez por equipo.
* Las librerías se almacenan en el repositorio local de Maven (`.m2/repository`).

---

## Dependencias en el pom.xml

Estas son las dependencias utilizadas en el proyecto:

```xml
<dependency>
    <groupId>org.jdesktop</groupId>
    <artifactId>timingframework</artifactId>
    <version>0.55</version>
</dependency>

<dependency>
    <groupId>com.custom.ui</groupId>
    <artifactId>gradient-icon-font</artifactId>
    <version>1.0</version>
</dependency>
```

---

Con esto, cualquier persona que clone el proyecto podrá instalar correctamente las librerías

