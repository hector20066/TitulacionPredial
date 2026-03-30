# Plan Completo de Correcciones JavaDoc - TitulacionPredial

## Escala del Proyecto
- **207 archivos Java**
- **~173 problemas identificados**
- **Carpetas principales**: model/, facade/, controller/, view/, service/, utils/, etc.

## Estrategia por Fases

### FASE 1: CONTROLADORES CRÍTICOS (Prioridad 1)
Archivos que tienen múltiples métodos sin documentación:

**1. ControllerContentReader.java** ✓ COMPLETADO
- ✓ Clase documentada
- ✓ Constructor documentado
- ✓ hideButtons() documentado
- ✓ prepareUI() documentado
- ✓ selectedMenu() documentado
- ✓ logout() documentado
- ✓ updateLanguage() documentado

**2. ControllerContentAdmin.java** (PRÓXIMO)
- Necesita: Documentación de clase mejorada
- Métodos a documentar: hideButtons(), prepareUI(), logout(), selectMenu()

**3. Coordinador.java** (SIGUIENTE)
- Verificar que todos los métodos tengan @param
- Verificar que no haya @param extras

### FASE 2: CONTROLADORES EN PANELS (Prioridad 2)
- ControllerRegisterBeneficiary.java (~17 métodos)
- ControllerRegisterProperty.java (~19 métodos)
- ControllerViewBeneficiaries.java (~19 métodos)
- ControllerGenerateResolution.java (14 @param faltantes)
- ControllerSeeProperties.java (~11 métodos)
- ControllerSeeResolutions.java (~9 métodos)
- ControllerLogin.java (~11 métodos)

### FASE 3: UTILITARIOS Y SERVICIOS (Prioridad 3)
- GraphicsUtilitiesChart.java (2 métodos públicos sin doc)
- MessageUtils.java (métodos input/output)
- Otros utilitarios en utils/

### FASE 4: MODELOS DTO Y ENTITIES
- Verificar que todos los métodos no-getter/setter tengan @param correcto
- DTOBeneficiaryDetails (Builder y métodos)
- DTOs de propiedades, resoluciones, etc.

### FASE 5: EXCEPCIONES Y RESTO
- Verificar excepciones (DAO, Validation)
- Interfaces Facade
- Clases auxiliares

## Métodos SIN Documentar Encontrados Mayoritariamente

### Patrones Comunes:
1. `connectEvents()` - Aparece sin documentación ~10 veces
2. `selectedMenu() / selectMenu()` - Sin @param
3. `hideButtons() / prepareUI()` - Sin documentación ~15 veces
4. `logout() / initialize()` - Sin documentación ~10 veces
5. Métodos privados en builders - Sin documentación

## Checklist de Correcciones

### Para CADA método a documentar:
- [ ] ¿Tiene comentario JavaDoc /** ... */
- [ ] ¿Describe qué hace el método?
- [ ] ¿Tiene @param por CADA parámetro?
- [ ] ¿El nombre de @param coincide con el parámetro real?
- [ ] ¿Tiene @return si es necesario?
- [ ] ¿Tiene @throws si lanza excepciones?
- [ ] ¿Excepto para get/set?

### Para CADA clase a documentar:
- [ ] ¿Tiene comentario JavaDoc /** ... */
- [ ] ¿Describe qué es la clase?
- [ ] ¿Tiene @author?
- [ ] ¿Tiene @since?
- [ ] ¿Tiene descripción del propósito?

## Verificación Final

Después de completar todas las correcciones:
```bash
# Compilar
mvn clean compile

# Verificar javadoc
mvn javadoc:javadoc

# Revisar problemas
find src/main/java -name "*.java" -exec grep -L "^[[:space:]]*/\*\*" {} \;
```

---

**Última actualización**: 2026-03-30
**Estado**: En progreso - Fase 1 iniciada
