# GUÍA DE CORRECCIONES JAVADOC - TitulacionPredial

## Problemas Encontrados y Correcciones Recomendadas

### 1. MÉTODOS PRIVADOS SIN DOCUMENTACIÓN

#### Patrón Común: `connectEvents()`
Aparece en todos los controladores.

**Ubicaciones**:
- ControllerLogin.java:76
- ControllerContentUser.java:58
- ControllerRegisterBeneficiary.java:113
- ControllerViewBeneficiaries.java:107
- ControllerGenerateResolution.java:90
- ControllerRegisterProperty.java:107
- ControllerSeeProperties.java:100
- ControllerSeeResolutions.java:89
- ControllerModifyResolution.java:82
- ControllerRegisterUsers.java:46

**Corrección**:
```java
/**
 * Connect all form events to their respective action methods.
 * 
 * <p>
 * This method registers listeners for buttons, fields, and other
 * interactive components to enable user interactions.
 * </p>
 */
private void connectEvents() {
    // implementation
}
```

---

### 2. MÉTODOS CRÍTICOS SIN @param

#### ControllerGenerateResolution.java - doInBackground()

**Problema**: 14 parámetros, CERO documentados

**Ubicación**: Línea 215

**Firma actual**:
```java
private void doInBackground(int numResolution, LocalDate executory, String act, 
                            String publicWriting, LocalDate notification, String fmi, 
                            String notary, int propertyCode, String beneficiaryName,
                            String idBeneficiaries, String address, String cadastralId, 
                            String area, String path)
```

**Corrección**:
```java
/**
 * Execute the resolution generation in a background thread.
 *
 * <p>
 * Verify that there is no duplicate resolution, retrieve the
 * associated beneficiaries, persist the resolution, and generate
 * the document.
 * </p>
 *
 * @param numResolution   resolution number to register
 * @param executory       date of resolution execution
 * @param act             act number
 * @param publicWriting   public deed number
 * @param notification    notification date
 * @param fmi             Real Estate Registration Folio
 * @param notary          notary name
 * @param propertyCode    associated property code
 * @param beneficiaryName beneficiary full name
 * @param idBeneficiaries beneficiary ID numbers (space-dash separated)
 * @param address         property address
 * @param cadastralId     cadastral certificate
 * @param area            property area in square meters
 * @param path            save path for generated document
 */
private void doInBackground(int numResolution, LocalDate executory, String act, 
                            String publicWriting, LocalDate notification, String fmi, 
                            String notary, int propertyCode, String beneficiaryName,
                            String idBeneficiaries, String address, String cadastralId, 
                            String area, String path) { ... }
```

---

#### ControllerRegisterBeneficiary.java - doInBackgroundModify()

**Problema**: 8 parámetros, solo 3 documentados

**Ubicación**: Línea 220

**Corrección**:
```java
/**
 * Execute the beneficiary modification in a background thread.
 *
 * <p>
 * In addition to updating the beneficiary's data, it manages
 * the removal of the spouse if the marital status changed to
 * one that does not require it.
 * </p>
 *
 * @param fullName           beneficiary full name
 * @param id                 national identity number
 * @param expeditionLocation place of ID expedition
 * @param codeBeneficiaries  beneficiary tracking code
 * @param phone              contact phone number
 * @param maritalStatus      new marital status
 * @param affectation        affectation notes
 * @param modifyCode         beneficiary code to modify
 */
private void doInBackgroundModify(String fullName, String id, String expeditionLocation, 
                                  String codeBeneficiaries, long phone, 
                                  MaritalStatus maritalStatus, String affectation,
                                  int modifyCode)
```

---

### 3. MÉTODOS PÚBLICOS SIN DOCUMENTACIÓN

#### ControllerContentReader.java

**Ubicación**: Línea 86 y 97

**Problema**: Métodos públicos sin JavaDoc

**Corrección**:
```java
/**
 * Hide delete and modify buttons for read-only access mode.
 * 
 * <p>
 * Disables user modification capabilities by hiding action buttons
 * from beneficiaries, properties, and resolutions lists.
 * </p>
 */
public void hideButtons() { ... }

/**
 * Prepare the user interface for read-only mode.
 * 
 * <p>
 * Hides all interactive buttons to display data in view-only mode.
 * </p>
 */
public void prepareUI() { ... }
```

---

#### GraphicsUtilitiesChart.java

**Ubicación**: Línea 320+ y 357+

**Corrección**:
```java
/**
 * Extract pixels from a buffered image in the specified region.
 *
 * @param img    source image
 * @param x      x-coordinate of the region
 * @param y      y-coordinate of the region
 * @param w      width of the region
 * @param h      height of the region
 * @param pixels array to store pixel values (or null for new allocation)
 * @return array of extracted pixel values
 */
public static int[] getPixels(BufferedImage img, int x, int y, int w, int h, int[] pixels) { ... }

/**
 * Set pixels in a buffered image at the specified region.
 *
 * @param img    target image
 * @param x      x-coordinate of the region
 * @param y      y-coordinate of the region
 * @param w      width of the region
 * @param h      height of the region
 * @param pixels array of pixel values to set
 */
public static void setPixels(BufferedImage img, int x, int y, int w, int h, int[] pixels) { ... }
```

---

### 4. MÉTODOS QUE RETORNAN VALORES SIN @return

#### ControllerViewBeneficiaries.java - resolveSearch()

**Ubicación**: Línea 393

**Corrección**:
```java
/**
 * Determine the search type according to the parameter and
 * invoke the corresponding facade method.
 *
 * @param param search criteria (numeric ID/code or name)
 * @return DTO of the beneficiary found, or {@code null} if not found
 * @throws DAOException if an error occurs in the query
 */
private DTOBeneficiarySimpleDetails resolveSearch(String param) throws DAOException { ... }
```

---

### 5. MÉTODOS CON VARARGS SIN DOCUMENTACIÓN

#### ControllerRegisterBeneficiary.java - isInvalidData()

**Ubicación**: Línea 444

**Corrección**:
```java
/**
 * Check if any of the provided fields are blank.
 *
 * @param fields variable number of string fields to validate
 * @return {@code true} if at least one field is blank, {@code false} otherwise
 */
private boolean isInvalidData(String... fields) { ... }
```

---

## LISTA DE VERIFICACIÓN PARA CORRECCIONES

### Fase 1: Métodos Críticos (Completar primero)
- [ ] ControllerGenerateResolution.doInBackground() - añadir 14 @param
- [ ] ControllerRegisterBeneficiary.doInBackgroundModify() - completar 8 @param
- [ ] ControllerContentReader.hideButtons() - añadir JavaDoc completo
- [ ] ControllerContentReader.prepareUI() - añadir JavaDoc completo
- [ ] GraphicsUtilitiesChart.getPixels() - añadir JavaDoc completo
- [ ] GraphicsUtilitiesChart.setPixels() - añadir JavaDoc completo
- [ ] MessageUtils.inputDialog() - añadir JavaDoc completo

### Fase 2: Métodos Privados Comunes (Patrón)
- [ ] Todos los `connectEvents()` - usar plantilla
- [ ] Todos los `logout()` - usar plantilla
- [ ] Todos los `prepareUI()` - usar plantilla
- [ ] Todos los `resetButton()` - usar plantilla

### Fase 3: Métodos Que Retornan Valores
- [ ] Revisar todos los métodos con `@return` faltante
- [ ] Añadir `@throws` donde sea necesario

### Fase 4: Métodos con Parámetros
- [ ] Completar todos los @param
- [ ] Documentar varargs
- [ ] Añadir descripciones detalladas de cada parámetro

---

## PLANTILLAS RECOMENDADAS

### Template 1: Método privado sin parámetros
```java
/**
 * Description of what the method does.
 * 
 * <p>
 * Additional details if relevant.
 * </p>
 */
private void methodName() { ... }
```

### Template 2: Método privado con parámetros que no retorna
```java
/**
 * Description.
 *
 * @param param1 description of param1
 * @param param2 description of param2
 */
private void methodName(Type param1, Type param2) { ... }
```

### Template 3: Método que retorna valor
```java
/**
 * Description.
 *
 * @param param parameter description
 * @return what is returned and when null
 * @throws ExceptionType when this exception occurs
 */
private ReturnType methodName(Type param) throws ExceptionType { ... }
```

### Template 4: Método complejo (múltiples parámetros)
```java
/**
 * Main description.
 *
 * <p>
 * Detailed explanation with implementation notes.
 * </p>
 *
 * @param param1 first parameter
 * @param param2 second parameter
 * @param param3 third parameter
 * @return description of return value
 * @throws ExceptionType1 when this happens
 * @throws ExceptionType2 when that happens
 */
private ReturnType methodName(Type param1, Type param2, Type param3) 
    throws ExceptionType1, ExceptionType2 { ... }
```

---

## ARCHIVOS QUE NECESITAN CORRECCIONES INMEDIATAS

1. **ControllerGenerateResolution.java** (6 métodos)
2. **ControllerRegisterBeneficiary.java** (17 métodos)
3. **ControllerRegisterProperty.java** (19 métodos)
4. **ControllerViewBeneficiaries.java** (19 métodos)
5. **ControllerSeeProperties.java** (11 métodos)
6. **ControllerSeeResolutions.java** (9 métodos)
7. **ControllerLogin.java** (11 métodos)
8. **ControllerModifyResolution.java** (5 métodos)
9. **GraphicsUtilitiesChart.java** (2 métodos públicos)
10. **MessageUtils.java** (1 método público)

---

**Total de correcciones recomendadas**: ~113 documentos JavaDoc

