# Methods Without JavaDoc - Comprehensive Analysis Report

**Total Java Files Scanned:** 207  
**Total Methods Without JavaDoc:** 1386  
**Generated:** 30 de marzo de 2026

---

## Executive Summary

A comprehensive scan of all 207 Java files in the source codebase identified **1386 methods** that are missing JavaDoc comments. These include public, private, and protected methods. The analysis prioritized controller classes as requested.

### Distribution Summary
- **Controller-related files:** ~130 methods without JavaDoc (primary focus)
- **DAO/Service implementation files:** ~200+ methods without JavaDoc
- **View/UI components:** ~400+ methods without JavaDoc
- **Utility classes:** ~100+ methods without JavaDoc
- **Entity/DTO classes:** ~600+ methods without JavaDoc

### Top 20 Files with Missing JavaDoc (by count)
1. `view/swing/chart/BarChart.java` - 19 methods
2. `view/swing/chart/PieChart.java` - 18 methods
3. `model/entities/Beneficiary.java` - 16 methods
4. `model/dto/property/DTOPropertyDetails.java` - 16 methods
5. `model/dto/beneficiary/DTOBeneficiaryDetails.java` - 15 methods
6. `controller/builder/ControllerLoginBuilder.java` - 15 methods
7. `controller/builder/ControllerContentAdminBuilder.java` - 15 methods
8. `view/content/ContentAdmin.java` - 12 methods
9. `view/content/ContentLogin.java` - 12 methods
10. `view/content/panels/RegisterUsers.java` - 12 methods

(See detailed breakdown at end of report)

---

## CONTROLLER FILES - DETAILED LIST

### Root Controller Files

#### `com/hector/titulacionpredial/controller/ControllerContentAdmin.java`
- **Line 135** | PUBLIC | `public void updateLanguage()`
- **Line 156** | PRIVATE | `private void logout()`

#### `com/hector/titulacionpredial/controller/ControllerContentReader.java`
- **Line 55** | PRIVATE | `private void selectedMenu(int index, int indexSubMenu)`
- **Line 74** | PUBLIC | `public void updateLanguage()`
- **Line 78** | PUBLIC | `public void hideButtons()`
- **Line 86** | PUBLIC | `public void prepareUI()`
- **Line 94** | PRIVATE | `private void logout()`

#### `com/hector/titulacionpredial/controller/ControllerContentUser.java`
- **Line 106** | PUBLIC | `public void updateLanguage()`
- **Line 110** | PRIVATE | `private void logout()`

#### `com/hector/titulacionpredial/controller/ControllerLogin.java`
- **Line 62** | PUBLIC | `public void setRole(Role role)`
- **Line 66** | PUBLIC | `public Role getRole()`
- **Line 70** | PUBLIC | `public JPanel jpl_Content()`
- **Line 78** | PRIVATE | `private void connectEvents()`
- **Line 90** | PUBLIC | `public void mousePressed(MouseEvent e)`
- **Line 97** | PUBLIC | `public void mousePressed(MouseEvent e)`
- **Line 104** | PUBLIC | `public void updateLanguage()`
- **Line 108** | PRIVATE | `private void logIn()`
- **Line 134** | PRIVATE | `private void prepareUI()`
- **Line 139** | PRIVATE | `private void executeLoginWorker(String user, String plainPasswd)`
- **Line 142** | PROTECTED | `protected Role doInBackground() throws DAOException`
- **Line 147** | PUBLIC | `public void done()`
- **Line 170** | PRIVATE | `private void handledLoginResult(Role role)`
- **Line 188** | PRIVATE | `private void startSessionAdmin()`
- **Line 199** | PRIVATE | `private void startSessionUser()`
- **Line 234** | PRIVATE | `private Municipalities extractMunicipalityFromMode(String mode)`
- **Line 242** | PRIVATE | `private void resetLogIn()`
- **Line 247** | PRIVATE | `private void mousePressedPassword()`
- **Line 259** | PRIVATE | `private void mousePressedUser()`
- **Line 271** | PRIVATE | `private void seePassword()`

---

### Controller Builder Files (`com/hector/titulacionpredial/controller/builder/`)

#### `ControllerContentAdminBuilder.java` - 15 methods without JavaDoc
- Line 120 | PUBLIC | `withViewRegisterUsers(...)`
- Line 125 | PUBLIC | `witViewManageUsers(...)`
- Line 206 | PUBLIC | `ContentAdmin getContent()`
- Line 210 | PUBLIC | `Dashboard getDashboard()`
- Line 214 | PUBLIC | `RegisterBeneficiary getRegisterBeneficiary()`
- Line 218 | PUBLIC | `RegisterProperty getRegisterProperty()`
- Line 222 | PUBLIC | `ViewBeneficiaries getViewBeneficiaries()`
- Line 226 | PUBLIC | `SeeProperties getSeeProperties()`
- Line 230 | PUBLIC | `SeeResolutions getSeeResolutions()`
- Line 234 | PUBLIC | `RegisterUsers getRegisterUsers()`
- Line 238 | PUBLIC | `ManageUsers getManageUsers()`
- Line 242 | PUBLIC | `Settings getSettings()`
- Line 246 | PUBLIC | `Subject getSubject()`
- Line 250 | PUBLIC | `LanguageSubject getLanguageSubject()`
- Line 254 | PUBLIC | `LanguageManager getLang()`

#### `ControllerContentUserBuilder.java` - 13 methods without JavaDoc
- Line 185 | PUBLIC | `ContentUser getContent()`
- Line 189 | PUBLIC | `Dashboard getDashboard()`
- Line 193 | PUBLIC | `RegisterBeneficiary getRegisterBeneficiary()`
- Line 197 | PUBLIC | `RegisterProperty getRegisterProperty()`
- Line 201 | PUBLIC | `ViewBeneficiaries getViewBeneficiaries()`
- Line 205 | PUBLIC | `SeeProperties getSeeProperties()`
- Line 209 | PUBLIC | `SeeResolutions getSeeResolutions()`
- Line 213 | PUBLIC | `Settings getSettings()`
- Line 217 | PUBLIC | `Subject getSubject()`
- Line 221 | PUBLIC | `LanguageSubject getLanguageSubject()`
- Line 225 | PUBLIC | `LanguageManager getLang()`
- Line 229 | PUBLIC | `About getAbout()`
- Line 233 | PUBLIC | `ContentLogin getContentLogin()`

#### `ControllerDashboardBuilder.java` - 4 methods without JavaDoc
- Line 81 | PUBLIC | `Dashboard getDashboard()`
- Line 85 | PUBLIC | `Subject getSubject()`
- Line 89 | PUBLIC | `LanguageSubject getLanguageSubject()`
- Line 93 | PUBLIC | `LanguageManager getLang()`

#### `ControllerGenerateResolutionBuilder.java` - 4 methods without JavaDoc
- Line 81 | PUBLIC | `GenerateResolution getGenerateResolution()`
- Line 85 | PUBLIC | `Subject getSubject()`
- Line 89 | PUBLIC | `LanguageSubject getLanguageSubject()`
- Line 93 | PUBLIC | `LanguageManager getLang()`

#### `ControllerLoginBuilder.java` - 15 methods without JavaDoc
- Line 29 | PUBLIC | `withViewLogin(ContentLogin login)`
- Line 34 | PUBLIC | `withContentAdmin(ContentAdmin contentAdmin)`
- Line 39 | PUBLIC | `withContentUser(ContentUser contentUser)`
- Line 44 | PUBLIC | `withContentReader(ContentReader contentReader)`
- Line 49 | PUBLIC | `withDashboard(Dashboard dashboard)`
- Line 54 | PUBLIC | `withSubject(Subject subject)`
- Line 59 | PUBLIC | `withLanguageManager(LanguageManager lang)`
- Line 64 | PUBLIC | `withControllerContentReader(...)`
- Line 69 | PUBLIC | `withLanguageSubject(LanguageSubject languageSubject)`
- Line 74 | PUBLIC | `ControllerLogin build()`
- Line 78 | PUBLIC | `ContentLogin getLogin()`
- Line 82 | PUBLIC | `ContentAdmin getContentAdmin()`
- Line 86 | PUBLIC | `ContentUser getContentUser()`
- Line 90 | PUBLIC | `ContentReader getContentReader()`
- Line 94 | PUBLIC | `Dashboard getDashboard()`

#### `ControllerManageUsersBuilder.java` - 9 methods without JavaDoc
- Line 19 | PUBLIC | `withViewManageUsers(ManageUsers manageUsers)`
- Line 24 | PUBLIC | `withLanguageManager(LanguageManager lang)`
- Line 29 | PUBLIC | `withSubject(Subject subject)`
- Line 34 | PUBLIC | `withLanguageSubject(LanguageSubject languageSubject)`
- Line 39 | PUBLIC | `ControllerManageUsers build()`
- Line 43 | PUBLIC | `ManageUsers getManageUsers()`
- Line 47 | PUBLIC | `LanguageManager getLang()`
- Line 51 | PUBLIC | `Subject getSubject()`
- Line 55 | PUBLIC | `LanguageSubject getLanguageSubject()`

#### `ControllerModifyResolutionBuilder.java` - 7 methods without JavaDoc
- Line 53 | PUBLIC | `withControllerLogin(ControllerLogin controllerLogin)`
- Line 101 | PUBLIC | `ModifyResolution getModifyResolution()`
- Line 105 | PUBLIC | `ControllerLogin getControllerLogin()`
- Line 109 | PUBLIC | `SeeResolutions getSeeResolutions()`
- Line 113 | PUBLIC | `Subject getSubject()`
- Line 117 | PUBLIC | `LanguageSubject getLanguageSubject()`
- Line 121 | PUBLIC | `LanguageManager getLang()`

#### `ControllerRegisterBeneficiaryBuilder.java` - 7 methods without JavaDoc
- Line 53 | PUBLIC | `withControllerLogin(ControllerLogin controllerLogin)`
- Line 101 | PUBLIC | `RegisterBeneficiary getRegisterBeneficiary()`
- Line 105 | PUBLIC | `ViewBeneficiaries getViewBeneficiaries()`
- Line 109 | PUBLIC | `ControllerLogin getControllerLogin()`
- Line 113 | PUBLIC | `Subject getSubject()`
- Line 117 | PUBLIC | `LanguageSubject getLanguageSubject()`
- Line 121 | PUBLIC | `LanguageManager getLang()`

#### `ControllerRegisterPropertyBuilder.java` - 4 methods without JavaDoc
- Line 81 | PUBLIC | `RegisterProperty getRegisterProperty()`
- Line 85 | PUBLIC | `Subject getSubject()`
- Line 89 | PUBLIC | `LanguageSubject getLanguageSubject()`
- Line 93 | PUBLIC | `LanguageManager getLang()`

#### `ControllerRegisterUsersBuilder.java` - 9 methods without JavaDoc
- Line 20 | PUBLIC | `withViewRegisterUsers(RegisterUsers registerUsers)`
- Line 25 | PUBLIC | `withLanguageManager(LanguageManager lang)`
- Line 30 | PUBLIC | `withSubject(Subject subject)`
- Line 35 | PUBLIC | `withLanguageSubject(LanguageSubject languageSubject)`
- Line 40 | PUBLIC | `ControllerRegisterUsers build()`
- Line 44 | PUBLIC | `RegisterUsers getRegisterUsers()`
- Line 48 | PUBLIC | `LanguageManager getLang()`
- Line 52 | PUBLIC | `Subject getSubject()`
- Line 56 | PUBLIC | `LanguageSubject getLanguageSubject()`

#### `ControllerSeePropertiesBuilder.java` - 7 methods without JavaDoc
- Line 53 | PUBLIC | `withControllerLogin(ControllerLogin controllerLogin)`
- Line 100 | PUBLIC | `GenerateResolution getGenerateResolution()`
- Line 104 | PUBLIC | `SeeProperties getSeeProperties()`
- Line 108 | PUBLIC | `ControllerLogin getControllerLogin()`
- Line 112 | PUBLIC | `Subject getSubject()`
- Line 116 | PUBLIC | `LanguageSubject getLanguageSubject()`
- Line 120 | PUBLIC | `LanguageManager getLang()`

#### `ControllerSeeResolutionsBuilder.java` - 7 methods without JavaDoc
- Line 53 | PUBLIC | `withControllerLogin(ControllerLogin controllerLogin)`
- Line 100 | PUBLIC | `ModifyResolution getModifyResolution()`
- Line 104 | PUBLIC | `SeeResolutions getSeeResolutions()`
- Line 108 | PUBLIC | `ControllerLogin getControllerLogin()`
- Line 112 | PUBLIC | `Subject getSubject()`
- Line 116 | PUBLIC | `LanguageSubject getLanguageSubject()`
- Line 120 | PUBLIC | `LanguageManager getLang()`

#### `ControllerSettingsBuilder.java` - 3 methods without JavaDoc
- Line 67 | PUBLIC | `Settings getSettings()`
- Line 71 | PUBLIC | `LanguageSubject getLanguageSubject()`
- Line 75 | PUBLIC | `LanguageManager getLang()`

#### `ControllerViewBeneficiariesBuilder.java` - 7 methods without JavaDoc
- Line 53 | PUBLIC | `withControllerLogin(ControllerLogin controllerLogin)`
- Line 100 | PUBLIC | `RegisterBeneficiary getRegisterBeneficiary()`
- Line 104 | PUBLIC | `ViewBeneficiaries getViewBeneficiaries()`
- Line 108 | PUBLIC | `ControllerLogin getControllerLogin()`
- Line 112 | PUBLIC | `Subject getSubject()`
- Line 116 | PUBLIC | `LanguageSubject getLanguageSubject()`
- Line 120 | PUBLIC | `LanguageManager getLang()`

---

### Controller Panel Files (`com/hector/titulacionpredial/controller/panels/`)

#### `ControllerDashboard.java` - 2 methods without JavaDoc
- Line 70 | PUBLIC | `public void update()`
- Line 169 | PUBLIC | `public void updateLanguage()`

#### `ControllerGenerateResolution.java` - 1 method without JavaDoc
- Line 97 | PUBLIC | `public void updateLanguage()`

#### `ControllerManageUsers.java` - 7 methods without JavaDoc
- Line 44 | PUBLIC | `public void update()`
- Line 56 | PUBLIC | `public void updateLanguage()`
- Line 61 | PUBLIC | `public void modifyAccount(DTOUserDetails account)`
- Line 77 | PUBLIC | `public void deleteAccount(int id, JPanel panel)`
- Line 88 | PRIVATE | `private void actionForSuccess()`
- Line 93 | PRIVATE | `private void actionForSuccess(boolean success)`
- Line 102 | PRIVATE | `private void loadData(List<DTOUserDetails> listUsers)`

#### `ControllerModifyResolution.java` - 1 method without JavaDoc
- Line 96 | PUBLIC | `public void updateLanguage()`

#### `ControllerRegisterBeneficiary.java` - 4 methods without JavaDoc
- Line 111 | PUBLIC | `public void updateLanguage()`
- Line 244 | PRIVATE | `private void register()`
- Line 386 | PRIVATE | `private void addBeneficiaries()`
- Line 472 | PRIVATE | `private void cleanUIAddBeneficiaries()`

#### `ControllerRegisterProperty.java` - 5 methods without JavaDoc
- Line 110 | PUBLIC | `public void updateLanguage()`
- Line 360 | PRIVATE | `private void prepareUISearch()`
- Line 367 | PRIVATE | `private void doInBackGroundSearch(String beneficiariesCode)`
- Line 399 | PRIVATE | `private void importExcelData()`
- Line 422 | PRIVATE | `private void loadInFields(List<List<String>> data)`

#### `ControllerRegisterUsers.java` - 9 methods without JavaDoc
- Line 47 | PRIVATE | `private void connectEvents()`
- Line 53 | PUBLIC | `public void updateLanguage()`
- Line 69 | PRIVATE | `private void createAccount()`
- Line 96 | PRIVATE | `private boolean isInvalidData(String... fields)`
- Line 106 | PRIVATE | `private void prepareUI()`
- Line 111 | PRIVATE | `private void doInBackground(String name, int id, String user, ...)`
- Line 125 | PRIVATE | `private void invokeLater()`
- Line 132 | PRIVATE | `private void resetUI()`
- Line 137 | PRIVATE | `private void seePassword()`

#### `ControllerSeeProperties.java` - 7 methods without JavaDoc
- Line 106 | PUBLIC | `public void update()`
- Line 121 | PUBLIC | `public void updateLanguage()`
- Line 359 | PUBLIC | `public void insertUpdate(DocumentEvent e)`
- Line 364 | PUBLIC | `public void removeUpdate(DocumentEvent e)`
- Line 369 | PUBLIC | `public void changedUpdate(DocumentEvent e)`
- Line 382 | PUBLIC | `public void focusLost(FocusEvent e)`
- Line 391 | PUBLIC | `public void mouseClicked(MouseEvent e)`

#### `ControllerSeeResolutions.java` - 7 methods without JavaDoc
- Line 105 | PUBLIC | `public void update()`
- Line 120 | PUBLIC | `public void updateLanguage()`
- Line 261 | PUBLIC | `public void insertUpdate(DocumentEvent e)`
- Line 266 | PUBLIC | `public void removeUpdate(DocumentEvent e)`
- Line 271 | PUBLIC | `public void changedUpdate(DocumentEvent e)`
- Line 284 | PUBLIC | `public void focusLost(FocusEvent e)`
- Line 293 | PUBLIC | `public void mouseClicked(MouseEvent e)`

#### `ControllerSettings.java` - 1 method without JavaDoc
- Line 62 | PUBLIC | `public void updateLanguage()`

#### `ControllerViewBeneficiaries.java` - 9 methods without JavaDoc
- Line 112 | PUBLIC | `public void update()`
- Line 127 | PUBLIC | `public void updateLanguage()`
- Line 372 | PROTECTED | `protected DTOBeneficiarySimpleDetails doInBackground() throws DAOException`
- Line 377 | PROTECTED | `protected void done()`
- Line 441 | PUBLIC | `public void insertUpdate(DocumentEvent e)`
- Line 446 | PUBLIC | `public void removeUpdate(DocumentEvent e)`
- Line 451 | PUBLIC | `public void changedUpdate(DocumentEvent e)`
- Line 464 | PUBLIC | `public void focusLost(FocusEvent e)`
- Line 473 | PUBLIC | `public void mouseClicked(MouseEvent e)`

---

## NON-CONTROLLER FILES - SUMMARY BY CATEGORY

### Facade Implementation Files (40 methods)
- BeneficiaryImplFacade: 15 methods
- ResolutionImplFacade: 6 methods
- PropertyImplFacade: 10 methods
- UsersImplFacade: 6 methods
- SpouseImplFacade: 3 methods
- PointImplFacade: 2 methods

### DAO Implementation Files (60+ methods)
- DAOBeneficiaryImpl: 21 methods
- DAOPropertyImpl: 10 methods
- DAOResolutionImpl: 6 methods
- DAOUserImpl: 7 methods
- DAOSpouseImpl: 3 methods
- DAOPointImpl: 2 methods

### Entity Classes (50+ methods)
- Beneficiary: 16 methods
- Person: 10 methods
- User: 11 methods
- Spouse: 2 methods

### DTO Classes (120+ methods)
- DTOBeneficiaryDetails: 15 methods
- DTOPropertyDetails: 16 methods
- DTOResolutionDetails: 7 methods
- DTOBeneficiary: 7 methods
- DTOUser: 2 methods
- DTOSpouse: 4 methods
- (And 30+ other DTO classes with 1-6 methods each)

### View/UI Component Files (400+ methods)
- BarChart: 19 methods
- PieChart: 18 methods
- Various Swing components: 100+ methods
- Content panels: 50+ methods
- Dialog windows: 20+ methods

### Utility Classes (50+ methods)
- DialogUtils: 2 methods
- MessageUtils: 1 method
- FilterUtils: 1 method
- (And other utilities)

---

## RECOMMENDATIONS

### Priority 1 (Controller Classes)
Focus JavaDoc additions on:
1. **ControllerLogin.java** - 20 methods (critical authentication entry point)
2. **All Builder classes** - ~100 methods (builder pattern implementation)
3. **All Panel Controller classes** - ~50 methods (business logic controllers)

### Priority 2 (Core Business Logic)
1. **Facade implementations** - 40 methods
2. **DAO implementations** - 60+ methods
3. **Entity classes** - 50+ methods

### Priority 3 (Data Transfer Objects)
- DTO classes - 120+ methods (getter/setter methods can have brief JavaDoc)

### Priority 4 (UI Components)
- Chart classes - 40+ methods
- Swing components - 200+ methods
- Dialog/Panel components - 100+ methods

---

## FULL DETAILED REPORT FILE

For complete details including every method, line number, and visibility level, see:
- `javadoc_analysis_results.txt` (full report)

---

*Report generated on 30 de marzo de 2026*
*Analysis tools: Python regex-based source code parser*
