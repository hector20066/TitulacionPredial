package com.hector.titulacionpredial.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 * Generador de Manual de Usuario para TitulacionPredial
 * Crea un documento Word profesional con instrucciones completas
 */
public class ManualGenerator {

    private static final String OUTPUT_PATH = "MANUAL_USUARIO_TitulacionPredial.docx";
    private static final String COMPANY_NAME = "Gestionamos Urbano Rural S.A.S";
    private static final String APP_NAME = "TitulacionPredial";
    private static final String APP_VERSION = "1.0.0";

    public static void main(String[] args) {
        try {
            generateManual();
            System.out.println("✓ Manual generado exitosamente: " + OUTPUT_PATH);
        } catch (IOException e) {
            System.err.println("✗ Error al generar manual: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void generateManual() throws IOException {
        XWPFDocument document = new XWPFDocument();
        
        // Portada
        addCoverPage(document);
        addPageBreak(document);
        
        // Índice
        addTableOfContents(document);
        addPageBreak(document);
        
        // Introducción
        addIntroduction(document);
        addPageBreak(document);
        
        // Secciones principales
        addLoginSection(document);
        addPageBreak(document);
        
        addDashboardSection(document);
        addPageBreak(document);
        
        addBeneficiariesSection(document);
        addPageBreak(document);
        
        addPropertiesSection(document);
        addPageBreak(document);
        
        addResolutionsSection(document);
        addPageBreak(document);
        
        addUsersManagementSection(document);
        addPageBreak(document);
        
        addSettingsSection(document);
        addPageBreak(document);
        
        addAboutSection(document);
        addPageBreak(document);
        
        addFAQSection(document);
        addPageBreak(document);
        
        addTipsAndTricksSection(document);
        
        // Guardar documento
        try (FileOutputStream fos = new FileOutputStream(OUTPUT_PATH)) {
            document.write(fos);
        }
        document.close();
    }

    private static void setPageMargins(XWPFDocument doc) {
        // Márgenes configurados por defecto
        // CTSectPr sectPr = doc.getDocument().getBody().getSectPr();
        // CTPageMar pgMar = sectPr.isSetPgMar() ? sectPr.getPgMar() : sectPr.addNewPgMar();
    }

    private static void addCoverPage(XWPFDocument doc) {
        XWPFParagraph p;
        
        // Espacios
        for (int i = 0; i < 8; i++) {
            doc.createParagraph();
        }
        
        // Título principal
        p = doc.createParagraph();
        p.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = p.createRun();
        run.setText(APP_NAME);
        run.setFontSize(48);
        run.setBold(true);
        run.setColor("1F4788");
        
        // Subtítulo
        p = doc.createParagraph();
        p.setAlignment(ParagraphAlignment.CENTER);
        run = p.createRun();
        run.setText("Manual de Usuario");
        run.setFontSize(32);
        run.setColor("2E5FA3");
        run.addBreak();
        
        // Versión
        for (int i = 0; i < 3; i++) {
            doc.createParagraph();
        }
        
        p = doc.createParagraph();
        p.setAlignment(ParagraphAlignment.CENTER);
        run = p.createRun();
        run.setText("Versión " + APP_VERSION);
        run.setFontSize(14);
        
        // Empresa
        p = doc.createParagraph();
        p.setAlignment(ParagraphAlignment.CENTER);
        run = p.createRun();
        run.setText(COMPANY_NAME);
        run.setFontSize(12);
        
        // Gobernación
        p = doc.createParagraph();
        p.setAlignment(ParagraphAlignment.CENTER);
        run = p.createRun();
        run.setText("Gobernación de Córdoba - Colombia");
        run.setFontSize(12);
        
        // Fecha
        for (int i = 0; i < 3; i++) {
            doc.createParagraph();
        }
        
        p = doc.createParagraph();
        p.setAlignment(ParagraphAlignment.CENTER);
        run = p.createRun();
        run.setText("Fecha: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd MMMM yyyy")));
        run.setFontSize(11);
        run.setItalic(true);
    }

    private static void addTableOfContents(XWPFDocument doc) {
        XWPFParagraph p = doc.createParagraph();
        XWPFRun run = p.createRun();
        run.setText("ÍNDICE DE CONTENIDOS");
        run.setFontSize(18);
        run.setBold(true);
        run.setColor("1F4788");
        
        String[] sections = {
            "1. Introducción",
            "2. Panel de Autenticación (Login)",
            "3. Panel de Control (Dashboard)",
            "4. Gestión de Beneficiarios",
            "5. Gestión de Propiedades",
            "6. Generación de Resoluciones",
            "7. Gestión de Usuarios (Administrador)",
            "8. Configuración y Preferencias",
            "9. Acerca de la Aplicación",
            "10. Preguntas Frecuentes (FAQ)",
            "11. Consejos y Trucos"
        };
        
        for (String section : sections) {
            p = doc.createParagraph();
            p.setIndentationLeft(360);
            run = p.createRun();
            run.setText(section);
            run.setFontSize(11);
        }
    }

    private static void addIntroduction(XWPFDocument doc) {
        addHeading(doc, "1. INTRODUCCIÓN", 1);
        
        addParagraph(doc, "Bienvenido al sistema TitulacionPredial");
        
        addParagraph(doc, "TitulacionPredial es un sistema empresarial moderno e integrado para la gestión completa de procesos de titulación de propiedades prediales. Este software ha sido desarrollado específicamente para automatizar y optimizar los procesos de formalización de propiedad en la Gobernación de Córdoba, Colombia.");
        
        addHeading(doc, "Propósito del Manual", 2);
        addParagraph(doc, "Este manual proporciona instrucciones detalladas y paso a paso para todos los usuarios del sistema. Contiene información sobre cómo acceder, navegar y realizar todas las operaciones disponibles en la aplicación.");
        
        addHeading(doc, "¿A quién va dirigido?", 2);
        addParagraph(doc, "Este manual está diseñado para:");
        addBulletPoint(doc, "Administradores del sistema (Rol: ADMIN)");
        addBulletPoint(doc, "Empleados de la entidad (Rol: EMPLOYEE)");
        addBulletPoint(doc, "Consultores externos (Rol: CONSULTANT)");
        
        addHeading(doc, "Requisitos Previos", 2);
        addBulletPoint(doc, "Cuenta de usuario válida creada por el administrador");
        addBulletPoint(doc, "Contraseña proporcionada por el administrador");
        addBulletPoint(doc, "Acceso a una computadora con navegador web moderno");
        addBulletPoint(doc, "Conexión estable a internet");
        
        addHeading(doc, "Características Principales", 2);
        addBulletPoint(doc, "Registro y gestión de beneficiarios con soporte para cónyuges");
        addBulletPoint(doc, "Registro de propiedades con datos geográficos precisos");
        addBulletPoint(doc, "Generación automática de resoluciones en formato Word");
        addBulletPoint(doc, "Dashboard con estadísticas en tiempo real");
        addBulletPoint(doc, "Control de acceso basado en roles");
        addBulletPoint(doc, "Soporte para múltiples idiomas (Español e Inglés)");
        addBulletPoint(doc, "Exportación de datos a Excel");
        addBulletPoint(doc, "Búsqueda y filtrado avanzado");
    }

    private static void addLoginSection(XWPFDocument doc) {
        addHeading(doc, "2. PANEL DE AUTENTICACIÓN (LOGIN)", 1);
        
        addParagraph(doc, "El panel de autenticación es la primera pantalla que verá al abrir la aplicación. Aquí deberá ingresar sus credenciales para acceder al sistema.");
        
        addHeading(doc, "2.1 Componentes de la Pantalla de Login", 2);
        
        XWPFTable table = doc.createTable(4, 2);
        table.setWidth("100%");
        XWPFTableRow headerRow = table.getRow(0);
        setCellText(headerRow.getCell(0), "Componente", true);
        setCellText(headerRow.getCell(1), "Descripción", true);
        
        setCellText(table.getRow(1).getCell(0), "Campo Usuario");
        setCellText(table.getRow(1).getCell(1), "Ingrese el nombre de usuario proporcionado por su administrador");
        
        setCellText(table.getRow(2).getCell(0), "Campo Contraseña");
        setCellText(table.getRow(2).getCell(1), "Ingrese su contraseña (es sensible a mayúsculas y minúsculas)");
        
        setCellText(table.getRow(3).getCell(0), "Combo Municipio");
        setCellText(table.getRow(3).getCell(1), "Seleccione el municipio con el cual desea trabajar en esta sesión");
        
        addHeading(doc, "2.2 Pasos para Iniciar Sesión", 2);
        addNumberedStep(doc, "Abre la aplicación TitulacionPredial");
        addNumberedStep(doc, "En el campo 'Usuario', ingresa tu nombre de usuario");
        addNumberedStep(doc, "En el campo 'Contraseña', ingresa tu contraseña");
        addNumberedStep(doc, "Selecciona el municipio en el cual vas a trabajar");
        addNumberedStep(doc, "Haz clic en el botón 'Iniciar Sesión'");
        addNumberedStep(doc, "Si las credenciales son correctas, serás redirigido al panel principal");
        
        addHeading(doc, "2.3 Validaciones y Mensajes de Error", 2);
        addBulletPoint(doc, "Usuario no existe: Verifica que hayas ingresado correctamente el nombre de usuario");
        addBulletPoint(doc, "Contraseña incorrecta: Verifica que la contraseña sea correcta (recuerda que es sensible a mayúsculas)");
        addBulletPoint(doc, "Campos vacíos: Todos los campos deben estar completos antes de hacer clic en 'Iniciar Sesión'");
        
        addHeading(doc, "2.4 Recuperación de Contraseña", 2);
        addParagraph(doc, "Si olvidaste tu contraseña, contacta con el administrador del sistema. El administrador puede resetear tu contraseña y proporcionarte una contraseña temporal para acceder nuevamente.");
        
        addHeading(doc, "2.5 Importante: Protege tu Contraseña", 2);
        addBulletPoint(doc, "Nunca compartas tu contraseña con otros usuarios");
        addBulletPoint(doc, "No escribas tu contraseña en documentos físicos");
        addBulletPoint(doc, "Usa una contraseña fuerte y única para esta aplicación");
        addBulletPoint(doc, "Cambia tu contraseña regularmente desde la sección de Configuración");
    }

    private static void addDashboardSection(XWPFDocument doc) {
        addHeading(doc, "3. PANEL DE CONTROL (DASHBOARD)", 1);
        
        addParagraph(doc, "Después de iniciar sesión exitosamente, serás redirigido al Panel de Control o Dashboard. Este panel te proporciona una vista general de toda la información del sistema con estadísticas en tiempo real.");
        
        addHeading(doc, "3.1 Componentes del Dashboard", 2);
        
        addHeading(doc, "3.1.1 Tarjetas de Métricas Principales", 3);
        addParagraph(doc, "En la parte superior del dashboard encontrarás tres tarjetas principales que muestran:");
        addBulletPoint(doc, "Total de Beneficiarios: Número total de beneficiarios registrados en el sistema");
        addBulletPoint(doc, "Total de Propiedades: Número total de propiedades registradas");
        addBulletPoint(doc, "Total de Resoluciones: Número total de resoluciones generadas");
        
        addParagraph(doc, "Estas métricas se actualizan automáticamente cada vez que se registra nueva información en el sistema.");
        
        addHeading(doc, "3.1.2 Gráfico de Líneas - Histórico de Beneficiarios", 3);
        addParagraph(doc, "Muestra el número de beneficiarios registrados durante los últimos 12 meses. Este gráfico permite identificar tendencias y picos de actividad en el registro de nuevos beneficiarios.");
        
        addHeading(doc, "3.1.3 Indicadores Visuales (Gauge Charts)", 3);
        addParagraph(doc, "Dos medidores circulares que muestran en porcentaje:");
        addBulletPoint(doc, "% Beneficiarios con propiedad asignada");
        addBulletPoint(doc, "% Propiedades con resoluciones generadas");
        
        addHeading(doc, "3.1.4 Gráfico de Dona - Distribución de Datos", 3);
        addParagraph(doc, "Muestra la distribución visual de datos en categorías específicas del sistema.");
        
        addHeading(doc, "3.2 Actualización de Datos", 2);
        addParagraph(doc, "El dashboard se actualiza automáticamente cada vez que:");
        addBulletPoint(doc, "Se registra un nuevo beneficiario");
        addBulletPoint(doc, "Se registra una nueva propiedad");
        addBulletPoint(doc, "Se genera una resolución");
        addBulletPoint(doc, "Se edita o elimina información del sistema");
        
        addHeading(doc, "3.3 Filtrado por Municipio", 2);
        addParagraph(doc, "Si tu rol de usuario permite trabajar con múltiples municipios, los datos del dashboard mostrarán información filtrada según el municipio seleccionado en la sesión actual.");
        
        addHeading(doc, "3.4 Acciones desde el Dashboard", 2);
        addBulletPoint(doc, "Hacer clic en las tarjetas de métricas puede abrir un detalle específico");
        addBulletPoint(doc, "Utilizar el menú superior para navegar a otras secciones del sistema");
        addBulletPoint(doc, "Exportar datos de los gráficos a archivos Excel");
    }

    private static void addBeneficiariesSection(XWPFDocument doc) {
        addHeading(doc, "4. GESTIÓN DE BENEFICIARIOS", 1);
        
        addParagraph(doc, "Los beneficiarios son las personas que se benefician del programa de titulación predial. En esta sección aprenderás cómo registrar, buscar, editar y ver beneficiarios en el sistema.");
        
        addHeading(doc, "4.1 Registrar Nuevo Beneficiario", 2);
        
        addHeading(doc, "Pasos para Registrar un Beneficiario:", 3);
        addNumberedStep(doc, "Desde el menú principal, selecciona la opción 'Registrar Beneficiario'");
        addNumberedStep(doc, "Se abrirá un formulario con los siguientes campos a completar:");
        
        addHeading(doc, "Campos del Formulario:", 3);
        XWPFTable table = doc.createTable(11, 2);
        table.setWidth("100%");
        XWPFTableRow headerRow = table.getRow(0);
        setCellText(headerRow.getCell(0), "Campo", true);
        setCellText(headerRow.getCell(1), "Descripción", true);
        
        fillBeneficiaryTable(table);
        
        addHeading(doc, "Instrucciones Específicas:", 3);
        addParagraph(doc, "• Código: Este campo se genera automáticamente. No necesitas ingresarlo.");
        addParagraph(doc, "• Tipo de Identificación: Selecciona el tipo (CC = Cédula de Ciudadanía, TI = Tarjeta de Identidad, CE = Cédula de Extranjería, PP = Pasaporte)");
        addParagraph(doc, "• Número de Identificación: Debe ser único en el sistema. No puedes registrar dos beneficiarios con el mismo número.");
        addParagraph(doc, "• Municipio: Selecciona el municipio donde reside el beneficiario.");
        addParagraph(doc, "• Estado Civil: Es muy importante seleccionar correctamente el estado civil:");
        
        addBulletPoint(doc, "Si seleccionas 'Soltero', 'Divorciado' o 'Viudo': No se mostrarán campos para el cónyuge");
        addBulletPoint(doc, "Si seleccionas 'Casado' o 'Unión Libre': Se habilitarán campos para registrar datos del cónyuge");
        
        addNumberedStep(doc, "Completa todos los campos marcados como requeridos (*)");
        addNumberedStep(doc, "Si el beneficiario está casado o en unión libre:");
        addBulletPoint(doc, "Haz clic en el botón 'Agregar Cónyuge'");
        addBulletPoint(doc, "Se abrirá un diálogo para ingresar los datos del cónyuge");
        addBulletPoint(doc, "Ingresa el nombre, apellidos, tipo y número de identificación del cónyuge");
        addBulletPoint(doc, "Haz clic en 'Guardar' para confirmar");
        
        addNumberedStep(doc, "Una vez completado el formulario, haz clic en el botón 'Registrar Beneficiario'");
        addNumberedStep(doc, "Si todo es correcto, verás un mensaje de éxito");
        addNumberedStep(doc, "El nuevo beneficiario estará disponible en la lista de beneficiarios");
        addNumberedStep(doc, "Para registrar otro beneficiario, haz clic en 'Limpiar Formulario' para vaciar los campos");
        
        addHeading(doc, "4.2 Ver y Buscar Beneficiarios", 2);
        addParagraph(doc, "Para ver el listado de todos los beneficiarios registrados:");
        
        addNumberedStep(doc, "Desde el menú principal, selecciona 'Ver Beneficiarios'");
        addNumberedStep(doc, "Se mostrará una tabla con todos los beneficiarios del sistema");
        addNumberedStep(doc, "La tabla muestra columnas con: Código, ID, Nombre Completo, Municipio, Estado Civil, y Acciones");
        
        addHeading(doc, "4.2.1 Búsqueda de Beneficiarios:", 3);
        addParagraph(doc, "Existen tres formas de buscar beneficiarios:");
        addBulletPoint(doc, "Por Número de ID: Ingresa el número de identificación en el campo de búsqueda");
        addBulletPoint(doc, "Por Código: Ingresa el código asignado automáticamente al beneficiario");
        addBulletPoint(doc, "Por Nombre: Ingresa el nombre completo o parte del mismo");
        
        addParagraph(doc, "La búsqueda es en tiempo real: conforme escribes, la tabla se filtra automáticamente.");
        
        addHeading(doc, "4.2.2 Acciones en la Tabla:", 3);
        addParagraph(doc, "Para cada beneficiario en la tabla, tendrás disponibles los siguientes botones:");
        
        addBulletPoint(doc, "✏️ Editar: Abre el formulario de edición con los datos del beneficiario pre-cargados");
        addBulletPoint(doc, "🗑️ Eliminar: Elimina el beneficiario del sistema (se pedirá confirmación)");
        addBulletPoint(doc, "👤 Ver Perfil: Abre una ventana con toda la información del beneficiario, incluyendo su cónyuge (si tiene), propiedades asociadas, y resoluciones");
        addBulletPoint(doc, "📊 Exportar Excel: Descarga un archivo Excel con los datos del beneficiario");
        
        addHeading(doc, "4.3 Editar Beneficiario", 2);
        addNumberedStep(doc, "En la tabla de beneficiarios, busca el beneficiario que deseas editar");
        addNumberedStep(doc, "Haz clic en el botón '✏️ Editar'");
        addNumberedStep(doc, "Se abrirá el formulario de edición con todos los datos del beneficiario");
        addNumberedStep(doc, "Modifica los campos que necesites cambiar");
        addNumberedStep(doc, "Haz clic en el botón 'Guardar Cambios' o 'Actualizar Beneficiario'");
        addNumberedStep(doc, "Verás un mensaje de confirmación cuando se haya actualizado correctamente");
        
        addHeading(doc, "4.4 Eliminar Beneficiario", 2);
        addNumberedStep(doc, "En la tabla de beneficiarios, busca el beneficiario que deseas eliminar");
        addNumberedStep(doc, "Haz clic en el botón '🗑️ Eliminar'");
        addNumberedStep(doc, "Se mostrará un diálogo de confirmación");
        addNumberedStep(doc, "Haz clic en 'Aceptar' para confirmar la eliminación o 'Cancelar' para deshacer");
        addNumberedStep(doc, "Una vez eliminado, el beneficiario no aparecerá más en la lista");
        
        addHeading(doc, "4.5 Ver Perfil Completo de Beneficiario", 2);
        addParagraph(doc, "El perfil completo muestra toda la información relacionada con un beneficiario:");
        
        addBulletPoint(doc, "Datos personales completos");
        addBulletPoint(doc, "Información del cónyuge (si aplica)");
        addBulletPoint(doc, "Lista de propiedades asociadas");
        addBulletPoint(doc, "Resoluciones generadas");
        addBulletPoint(doc, "Documentos adjuntos");
        
        addHeading(doc, "4.6 Validaciones Importantes", 2);
        addBulletPoint(doc, "Número de ID único: No se puede registrar otro beneficiario con el mismo número de identificación");
        addBulletPoint(doc, "Campos requeridos: Todos los campos marcados con asterisco (*) deben ser completados");
        addBulletPoint(doc, "Formato de datos: Los datos deben cumplir con los formatos especificados (ej: números para ID)");
        addBulletPoint(doc, "Municipio válido: Debes seleccionar un municipio de la lista desplegable");
    }

    private static void addPropertiesSection(XWPFDocument doc) {
        addHeading(doc, "5. GESTIÓN DE PROPIEDADES", 1);
        
        addParagraph(doc, "Las propiedades representan los predios sobre los cuales se está realizando el proceso de titulación. En esta sección aprenderás cómo registrar, buscar, editar y visualizar propiedades.");
        
        addHeading(doc, "5.1 Registrar Nueva Propiedad", 2);
        addParagraph(doc, "Para registrar una nueva propiedad en el sistema:");
        
        addNumberedStep(doc, "Desde el menú principal, selecciona 'Registrar Propiedad'");
        addNumberedStep(doc, "Se abrirá un formulario con los campos a completar");
        addNumberedStep(doc, "Completa la información básica de la propiedad");
        addNumberedStep(doc, "Agrega los puntos geográficos (máximo 4)");
        addNumberedStep(doc, "Haz clic en 'Registrar Propiedad' para guardar");
        
        addHeading(doc, "5.1.1 Campos del Formulario:", 3);
        
        XWPFTable table = doc.createTable(11, 2);
        table.setWidth("100%");
        XWPFTableRow headerRow = table.getRow(0);
        setCellText(headerRow.getCell(0), "Campo", true);
        setCellText(headerRow.getCell(1), "Descripción", true);
        
        setCellText(table.getRow(1).getCell(0), "Código");
        setCellText(table.getRow(1).getCell(1), "Se genera automáticamente (lectura)");
        
        setCellText(table.getRow(2).getCell(0), "Referencia Catastral");
        setCellText(table.getRow(2).getCell(1), "Identificación única del predio en el catastro. Debe ser única en el sistema");
        
        setCellText(table.getRow(3).getCell(0), "Área");
        setCellText(table.getRow(3).getCell(1), "Área total de la propiedad en metros cuadrados (número decimal)");
        
        setCellText(table.getRow(4).getCell(0), "Departamento");
        setCellText(table.getRow(4).getCell(1), "Departamento donde se encuentra la propiedad (normalmente Córdoba)");
        
        setCellText(table.getRow(5).getCell(0), "Municipio");
        setCellText(table.getRow(5).getCell(1), "Municipio específico donde está ubicada la propiedad");
        
        setCellText(table.getRow(6).getCell(0), "Barrio/Vereda");
        setCellText(table.getRow(6).getCell(1), "Nombre del barrio urbano o vereda rural");
        
        setCellText(table.getRow(7).getCell(0), "Dirección");
        setCellText(table.getRow(7).getCell(1), "Dirección física de la propiedad (calle, número, etc.)");
        
        setCellText(table.getRow(8).getCell(0), "Linderos");
        setCellText(table.getRow(8).getCell(1), "Descripción de los límites con propiedades vecinas");
        
        setCellText(table.getRow(9).getCell(0), "Distancias");
        setCellText(table.getRow(9).getCell(1), "Distancias a puntos de referencia o entre linderos");
        
        setCellText(table.getRow(10).getCell(0), "Publicación");
        setCellText(table.getRow(10).getCell(1), "Referencia de publicación catastral");
        
        addHeading(doc, "5.1.2 Agregar Puntos Geográficos:", 3);
        addParagraph(doc, "Cada propiedad puede tener hasta 4 puntos geográficos que definen sus límites exactos. Para cada punto necesitas:");
        
        addBulletPoint(doc, "Número de Punto: Del 1 al 4");
        addBulletPoint(doc, "Coordenada N (Latitud): Formato numérico con decimales");
        addBulletPoint(doc, "Coordenada E (Longitud): Formato numérico con decimales");
        addBulletPoint(doc, "Distancia: Distancia al siguiente punto");
        addBulletPoint(doc, "Lindero: Descripción de lo que limita en ese punto");
        
        addNumberedStep(doc, "En el formulario, haz clic en 'Agregar Punto'");
        addNumberedStep(doc, "Ingresa los datos del punto geográfico");
        addNumberedStep(doc, "Puedes agregar hasta 4 puntos");
        addNumberedStep(doc, "Para eliminar un punto, haz clic en 'Eliminar Punto'");
        
        addHeading(doc, "5.2 Ver y Buscar Propiedades", 2);
        addNumberedStep(doc, "Desde el menú, selecciona 'Ver Propiedades'");
        addNumberedStep(doc, "Se mostrará una tabla con todas las propiedades registradas");
        addNumberedStep(doc, "Puedes buscar propiedades usando el campo de búsqueda");
        
        addHeading(doc, "5.2.1 Opciones de Búsqueda:", 3);
        addBulletPoint(doc, "Por Referencia Catastral");
        addBulletPoint(doc, "Por Municipio");
        addBulletPoint(doc, "Por Código de Propiedad");
        
        addHeading(doc, "5.2.2 Acciones en la Tabla:", 3);
        addBulletPoint(doc, "✏️ Editar: Abre el formulario para editar la propiedad");
        addBulletPoint(doc, "🗑️ Eliminar: Elimina la propiedad (requiere confirmación)");
        addBulletPoint(doc, "📄 Generar Resolución: Abre el panel para crear una resolución para esta propiedad");
        addBulletPoint(doc, "📋 Ver Detalles: Muestra toda la información completa de la propiedad");
        
        addHeading(doc, "5.3 Ver Detalles de Propiedad", 2);
        addParagraph(doc, "La vista de detalles muestra:");
        addBulletPoint(doc, "Información completa de la propiedad");
        addBulletPoint(doc, "Todos los puntos geográficos registrados");
        addBulletPoint(doc, "Beneficiarios asociados");
        addBulletPoint(doc, "Resoluciones generadas");
        addBulletPoint(doc, "Mapa visual con los puntos geográficos");
        
        addHeading(doc, "5.4 Editar Propiedad", 2);
        addNumberedStep(doc, "En la tabla de propiedades, busca la que deseas editar");
        addNumberedStep(doc, "Haz clic en '✏️ Editar'");
        addNumberedStep(doc, "Modifica los campos necesarios");
        addNumberedStep(doc, "Haz clic en 'Guardar Cambios'");
        
        addHeading(doc, "5.5 Validaciones Importantes", 2);
        addBulletPoint(doc, "Referencia Catastral única: No puede haber dos propiedades con la misma referencia");
        addBulletPoint(doc, "Área válida: Debe ser un número positivo");
        addBulletPoint(doc, "Puntos geográficos: Máximo 4 puntos por propiedad");
        addBulletPoint(doc, "Coordenadas válidas: Deben ser números con formato de latitud/longitud válidos");
    }

    private static void addResolutionsSection(XWPFDocument doc) {
        addHeading(doc, "6. GENERACIÓN Y GESTIÓN DE RESOLUCIONES", 1);
        
        addParagraph(doc, "Las resoluciones son documentos legales que formalizan la titulación de propiedades. El sistema puede generar automáticamente documentos Word con toda la información necesaria.");
        
        addHeading(doc, "6.1 Generar Nueva Resolución", 2);
        addParagraph(doc, "Para generar una nueva resolución:");
        
        addNumberedStep(doc, "Desde el menú, selecciona 'Generar Resolución'");
        addNumberedStep(doc, "Se abrirá un formulario con los campos para la resolución");
        addNumberedStep(doc, "Completa todos los datos requeridos");
        addNumberedStep(doc, "Haz clic en 'Generar Resolución'");
        addNumberedStep(doc, "El sistema creará un documento Word y lo descargará automáticamente");
        
        addHeading(doc, "6.1.1 Campos del Formulario:", 3);
        
        XWPFTable table = doc.createTable(9, 2);
        table.setWidth("100%");
        XWPFTableRow headerRow = table.getRow(0);
        setCellText(headerRow.getCell(0), "Campo", true);
        setCellText(headerRow.getCell(1), "Descripción", true);
        
        setCellText(table.getRow(1).getCell(0), "Número de Resolución");
        setCellText(table.getRow(1).getCell(1), "Número único e identificador de la resolución. Debe ser único en todo el sistema");
        
        setCellText(table.getRow(2).getCell(0), "Beneficiario");
        setCellText(table.getRow(2).getCell(1), "Selecciona el beneficiario para el cual se genera la resolución");
        
        setCellText(table.getRow(3).getCell(0), "Propiedad");
        setCellText(table.getRow(3).getCell(1), "La propiedad se auto-completa basada en el beneficiario seleccionado");
        
        setCellText(table.getRow(4).getCell(0), "Datos FMI");
        setCellText(table.getRow(4).getCell(1), "Información del Fondo de Modernización del Interior (datos administrativos)");
        
        setCellText(table.getRow(5).getCell(0), "Acto");
        setCellText(table.getRow(5).getCell(1), "Descripción del acto legal que se formaliza en la resolución");
        
        setCellText(table.getRow(6).getCell(0), "Escritura Pública");
        setCellText(table.getRow(6).getCell(1), "Número de escritura pública ante notario que respalda el acto");
        
        setCellText(table.getRow(7).getCell(0), "Notaría");
        setCellText(table.getRow(7).getCell(1), "Nombre y datos de la notaría que autoriza la escritura pública");
        
        setCellText(table.getRow(8).getCell(0), "Fechas (Notificación/Ejecutoria)");
        setCellText(table.getRow(8).getCell(1), "Fechas de notificación y cuando la resolución se hace ejecutoria");
        
        addHeading(doc, "6.1.2 Botones Disponibles:", 3);
        addBulletPoint(doc, "Generar Resolución: Crea el documento Word y lo descarga");
        addBulletPoint(doc, "Guardar en BD: Solo registra sin generar documento Word");
        addBulletPoint(doc, "Cancelar: Cierra el formulario sin guardar");
        
        addHeading(doc, "6.2 Documento Word Generado", 2);
        addParagraph(doc, "Cuando generas una resolución, el sistema automáticamente:");
        addBulletPoint(doc, "Crea un archivo Word (.docx) con plantilla profesional");
        addBulletPoint(doc, "Completa todos los datos de la resolución");
        addBulletPoint(doc, "Inserta información del beneficiario y propiedad");
        addBulletPoint(doc, "Añade información legal y notarial");
        addBulletPoint(doc, "Incluye formato y firma necesarios");
        addBulletPoint(doc, "Descarga el archivo automáticamente a tu computadora");
        
        addParagraph(doc, "El archivo descargado puede ser abierto con Microsoft Word o cualquier editor compatible con documentos .docx.");
        
        addHeading(doc, "6.3 Ver y Buscar Resoluciones", 2);
        addNumberedStep(doc, "Desde el menú, selecciona 'Ver Resoluciones'");
        addNumberedStep(doc, "Se mostrará una tabla con todas las resoluciones generadas");
        addNumberedStep(doc, "Puedes buscar resoluciones usando diversos criterios");
        
        addHeading(doc, "6.3.1 Opciones de Búsqueda:", 3);
        addBulletPoint(doc, "Por Número de Resolución");
        addBulletPoint(doc, "Por Beneficiario");
        addBulletPoint(doc, "Por Propiedad");
        addBulletPoint(doc, "Por Rango de Fechas");
        
        addHeading(doc, "6.3.2 Acciones en la Tabla:", 3);
        addBulletPoint(doc, "✏️ Modificar: Abre el formulario para editar la resolución");
        addBulletPoint(doc, "🗑️ Eliminar: Elimina la resolución del sistema");
        addBulletPoint(doc, "📄 Ver Documento: Descarga el archivo Word de la resolución");
        addBulletPoint(doc, "📊 Exportar: Descarga un archivo Excel con los datos");
        
        addHeading(doc, "6.4 Modificar Resolución", 2);
        addNumberedStep(doc, "En la tabla de resoluciones, busca la que deseas modificar");
        addNumberedStep(doc, "Haz clic en '✏️ Modificar'");
        addNumberedStep(doc, "Se abrirá el formulario con los datos actuales");
        addNumberedStep(doc, "Realiza los cambios necesarios");
        addNumberedStep(doc, "Haz clic en 'Guardar Cambios'");
        addNumberedStep(doc, "Puedes hacer clic en 'Regenerar Documento' para crear un nuevo archivo Word con los datos actualizados");
        
        addHeading(doc, "6.5 Eliminar Resolución", 2);
        addParagraph(doc, "Para eliminar una resolución:");
        addNumberedStep(doc, "En la tabla de resoluciones, busca la que deseas eliminar");
        addNumberedStep(doc, "Haz clic en '🗑️ Eliminar'");
        addNumberedStep(doc, "Se mostrará una confirmación");
        addNumberedStep(doc, "Haz clic en 'Aceptar' para confirmar la eliminación");
        
        addHeading(doc, "6.6 Validaciones Importantes", 2);
        addBulletPoint(doc, "Número de Resolución único: No puede haber dos resoluciones con el mismo número");
        addBulletPoint(doc, "Beneficiario válido: El beneficiario debe existir en el sistema");
        addBulletPoint(doc, "Fechas válidas: Las fechas deben estar en formato correcto y ser coherentes");
        addBulletPoint(doc, "Campos requeridos: Todos los campos marcados con asterisco deben completarse");
    }

    private static void addUsersManagementSection(XWPFDocument doc) {
        addHeading(doc, "7. GESTIÓN DE USUARIOS (ADMINISTRADOR)", 1);
        
        addParagraph(doc, "Nota importante: Las funciones de gestión de usuarios solo están disponibles para usuarios con rol de ADMINISTRADOR (ADMIN).");
        
        addHeading(doc, "7.1 Roles y Permisos en el Sistema", 2);
        
        addHeading(doc, "7.1.1 ADMINISTRADOR (ADMIN)", 3);
        addBulletPoint(doc, "Acceso total a todas las funcionalidades");
        addBulletPoint(doc, "Puede crear, editar y eliminar usuarios");
        addBulletPoint(doc, "Puede asignar roles a otros usuarios");
        addBulletPoint(doc, "Ver datos de todos los municipios sin restricción");
        addBulletPoint(doc, "Acceso a reportes y estadísticas globales");
        
        addHeading(doc, "7.1.2 EMPLEADO (EMPLOYEE)", 3);
        addBulletPoint(doc, "Puede registrar beneficiarios");
        addBulletPoint(doc, "Puede registrar propiedades");
        addBulletPoint(doc, "Puede generar resoluciones");
        addBulletPoint(doc, "Acceso limitado al municipio asignado");
        addBulletPoint(doc, "No puede crear usuarios");
        addBulletPoint(doc, "Puede editar su propia información y contraseña");
        
        addHeading(doc, "7.1.3 CONSULTOR (CONSULTANT)", 3);
        addBulletPoint(doc, "Solo lectura de beneficiarios");
        addBulletPoint(doc, "Solo lectura de propiedades");
        addBulletPoint(doc, "Solo lectura de resoluciones");
        addBulletPoint(doc, "Acceso limitado al municipio asignado");
        addBulletPoint(doc, "No puede crear ni modificar datos");
        addBulletPoint(doc, "Puede cambiar su propia contraseña");
        
        addHeading(doc, "7.2 Registrar Nuevo Usuario", 2);
        addNumberedStep(doc, "Desde el menú, selecciona 'Registrar Usuario' (solo para ADMIN)");
        addNumberedStep(doc, "Se abrirá el formulario de registro");
        addNumberedStep(doc, "Completa todos los campos requeridos");
        addNumberedStep(doc, "Haz clic en 'Registrar Usuario'");
        
        addHeading(doc, "7.2.1 Campos del Formulario:", 3);
        
        XWPFTable table = doc.createTable(7, 2);
        table.setWidth("100%");
        XWPFTableRow headerRow = table.getRow(0);
        setCellText(headerRow.getCell(0), "Campo", true);
        setCellText(headerRow.getCell(1), "Descripción", true);
        
        setCellText(table.getRow(1).getCell(0), "Nombre Completo");
        setCellText(table.getRow(1).getCell(1), "Nombre y apellidos completos del nuevo usuario");
        
        setCellText(table.getRow(2).getCell(0), "Usuario");
        setCellText(table.getRow(2).getCell(1), "Nombre de usuario único. Debe ser único en el sistema. Será usado para iniciar sesión");
        
        setCellText(table.getRow(3).getCell(0), "Contraseña");
        setCellText(table.getRow(3).getCell(1), "Contraseña inicial del usuario. Debe tener al menos 8 caracteres, mayúsculas y números");
        
        setCellText(table.getRow(4).getCell(0), "Confirmar Contraseña");
        setCellText(table.getRow(4).getCell(1), "Repite la contraseña. Debe coincidir exactamente");
        
        setCellText(table.getRow(5).getCell(0), "Rol");
        setCellText(table.getRow(5).getCell(1), "Asigna el rol: ADMIN, EMPLOYEE o CONSULTANT");
        
        setCellText(table.getRow(6).getCell(0), "Municipio");
        setCellText(table.getRow(6).getCell(1), "Municipio al cual se asigna el usuario. Importante para limitar acceso a datos");
        
        addHeading(doc, "7.2.2 Requisitos de Contraseña:", 3);
        addBulletPoint(doc, "Mínimo 8 caracteres");
        addBulletPoint(doc, "Al menos una mayúscula (A-Z)");
        addBulletPoint(doc, "Al menos un número (0-9)");
        addBulletPoint(doc, "Puede incluir caracteres especiales para mayor seguridad");
        
        addHeading(doc, "7.3 Gestionar Usuarios Existentes", 2);
        addNumberedStep(doc, "Desde el menú, selecciona 'Gestionar Usuarios' (solo para ADMIN)");
        addNumberedStep(doc, "Se mostrará una tabla con todos los usuarios del sistema");
        addNumberedStep(doc, "Puedes buscar usuarios por nombre de usuario o nombre completo");
        
        addHeading(doc, "7.3.1 Acciones Disponibles:", 3);
        addBulletPoint(doc, "✏️ Editar: Modifica el rol y municipio asignado del usuario");
        addBulletPoint(doc, "🗑️ Eliminar: Elimina el usuario del sistema");
        addBulletPoint(doc, "🔑 Resetear Contraseña: Genera una contraseña temporal que el usuario deberá cambiar");
        addBulletPoint(doc, "🔒 Desactivar/🔓 Activar: Toggle para activar o desactivar la cuenta del usuario");
        
        addHeading(doc, "7.4 Editar Usuario", 2);
        addNumberedStep(doc, "En la tabla de usuarios, busca el usuario que deseas editar");
        addNumberedStep(doc, "Haz clic en '✏️ Editar'");
        addNumberedStep(doc, "Puedes cambiar el rol y el municipio asignado");
        addNumberedStep(doc, "Haz clic en 'Guardar Cambios'");
        
        addHeading(doc, "7.5 Resetear Contraseña de Usuario", 2);
        addParagraph(doc, "Si un usuario olvida su contraseña o necesita una nueva:");
        addNumberedStep(doc, "En la tabla de usuarios, busca el usuario");
        addNumberedStep(doc, "Haz clic en '🔑 Resetear Contraseña'");
        addNumberedStep(doc, "El sistema genera una contraseña temporal");
        addNumberedStep(doc, "Comunica la contraseña temporal al usuario");
        addNumberedStep(doc, "El usuario deberá cambiarla en su próxima sesión");
        
        addHeading(doc, "7.6 Eliminar Usuario", 2);
        addNumberedStep(doc, "En la tabla de usuarios, busca el usuario que deseas eliminar");
        addNumberedStep(doc, "Haz clic en '🗑️ Eliminar'");
        addNumberedStep(doc, "Se mostrará una confirmación");
        addNumberedStep(doc, "Haz clic en 'Aceptar' para confirmar la eliminación");
        addNumberedStep(doc, "El usuario será eliminado del sistema y no podrá acceder más");
        
        addHeading(doc, "7.7 Desactivar/Activar Cuenta de Usuario", 2);
        addParagraph(doc, "Puedes desactivar temporalmente una cuenta sin eliminarla:");
        addNumberedStep(doc, "En la tabla de usuarios, busca el usuario");
        addNumberedStep(doc, "Haz clic en '🔒 Desactivar' para bloquear el acceso");
        addNumberedStep(doc, "El usuario no podrá iniciar sesión hasta que sea reactivado");
        addNumberedStep(doc, "Haz clic en '🔓 Activar' para permitir acceso nuevamente");
    }

    private static void addSettingsSection(XWPFDocument doc) {
        addHeading(doc, "8. CONFIGURACIÓN Y PREFERENCIAS", 1);
        
        addParagraph(doc, "En la sección de Configuración, puedes personalizar tus preferencias y cambiar información de tu cuenta.");
        
        addNumberedStep(doc, "Desde el menú principal, selecciona 'Configuración' o 'Settings'");
        addNumberedStep(doc, "Se abrirá el panel de configuración con varias opciones");
        
        addHeading(doc, "8.1 Cambiar Idioma", 2);
        addParagraph(doc, "El sistema soporta dos idiomas: Español e Inglés. Puedes cambiar el idioma dinámicamente sin necesidad de reiniciar la aplicación.");
        
        addNumberedStep(doc, "En la sección de Configuración, encuentra la opción 'Idioma' o 'Language'");
        addNumberedStep(doc, "Selecciona entre 'Español' e 'English'");
        addNumberedStep(doc, "El cambio se aplica inmediatamente");
        addNumberedStep(doc, "Tu preferencia de idioma se guarda automáticamente");
        addNumberedStep(doc, "En tu próxima sesión, el sistema cargará en el idioma que seleccionaste");
        
        addHeading(doc, "8.2 Cambiar Contraseña", 2);
        addParagraph(doc, "Es recomendable cambiar tu contraseña regularmente por seguridad.");
        
        addNumberedStep(doc, "En la sección de Configuración, selecciona 'Cambiar Contraseña'");
        addNumberedStep(doc, "Se abrirá un formulario con los campos:");
        addBulletPoint(doc, "Contraseña Actual: Ingresa tu contraseña actual para validación");
        addBulletPoint(doc, "Nueva Contraseña: Ingresa la nueva contraseña que deseas");
        addBulletPoint(doc, "Confirmar Nueva Contraseña: Repite la nueva contraseña");
        
        addNumberedStep(doc, "Haz clic en 'Guardar Cambios'");
        addNumberedStep(doc, "Si la contraseña actual es correcta, tu nueva contraseña se guardará");
        addNumberedStep(doc, "En tu próxima sesión, deberás usar la nueva contraseña");
        
        addHeading(doc, "8.2.1 Requisitos para Nueva Contraseña:", 3);
        addBulletPoint(doc, "Mínimo 8 caracteres");
        addBulletPoint(doc, "Al menos una mayúscula");
        addBulletPoint(doc, "Al menos un número");
        addBulletPoint(doc, "Recomendado: Incluir caracteres especiales");
        addBulletPoint(doc, "Debe ser diferente a tu contraseña anterior");
        
        addHeading(doc, "8.3 Ver Información de tu Cuenta", 2);
        addParagraph(doc, "Puedes ver la información de tu perfil actual:");
        addBulletPoint(doc, "Nombre Completo: Tu nombre registrado en el sistema");
        addBulletPoint(doc, "Usuario: Tu nombre de usuario para iniciar sesión");
        addBulletPoint(doc, "Rol: Tu rol en el sistema (ADMIN, EMPLOYEE o CONSULTANT)");
        addBulletPoint(doc, "Municipio Asignado: El municipio o municipios que puedes administrar");
        addBulletPoint(doc, "Fecha de Última Actualización: Cuándo se modificó por última vez tu información");
        
        addHeading(doc, "8.4 Preferencias Visuales", 2);
        addBulletPoint(doc, "Tema: Puedes seleccionar diferentes temas visuales (si están disponibles)");
        addBulletPoint(doc, "Tamaño de Fuente: Ajusta el tamaño del texto para mejor legibilidad");
        addBulletPoint(doc, "Colores: Personaliza los colores de la interfaz según tu preferencia");
        
        addHeading(doc, "8.5 Cerrar Sesión", 2);
        addParagraph(doc, "Para cerrar tu sesión actual:");
        addNumberedStep(doc, "En la sección de Configuración, busca el botón 'Cerrar Sesión'");
        addNumberedStep(doc, "Haz clic en 'Cerrar Sesión'");
        addNumberedStep(doc, "Serás redirigido al panel de login");
        addNumberedStep(doc, "Puedes iniciar sesión nuevamente con tus credenciales");
        
        addParagraph(doc, "IMPORTANTE: Siempre cierra sesión cuando termines de usar la aplicación, especialmente si estás usando una computadora compartida.");
    }

    private static void addAboutSection(XWPFDocument doc) {
        addHeading(doc, "9. ACERCA DE LA APLICACIÓN", 1);
        
        addParagraph(doc, "La sección 'Acerca de' proporciona información importante sobre la aplicación.");
        
        addHeading(doc, "9.1 Acceder a la Sección About", 2);
        addNumberedStep(doc, "Desde el menú principal, selecciona 'Acerca de' o 'About'");
        addNumberedStep(doc, "Se abrirá una ventana con información sobre la aplicación");
        
        addHeading(doc, "9.2 Información Disponible", 2);
        addBulletPoint(doc, "Nombre de la Aplicación: TitulacionPredial");
        addBulletPoint(doc, "Versión Actual: 1.0.0");
        addBulletPoint(doc, "Autor: Ing. Hector Acevedo");
        addBulletPoint(doc, "Fecha de Lanzamiento: 7 de abril de 2026");
        addBulletPoint(doc, "Última Actualización: 23 de abril de 2026");
        addBulletPoint(doc, "Descripción del Proyecto");
        addBulletPoint(doc, "Propósito del Sistema");
        addBulletPoint(doc, "Contacto/Email de Soporte");
        addBulletPoint(doc, "Licencia: Proprietaria");
        addBulletPoint(doc, "Organización: Gestionamos Urbano Rural S.A.S");
        
        addHeading(doc, "9.3 Licencia", 2);
        addParagraph(doc, "TitulacionPredial es un software propietario. Todos los derechos están reservados. El uso no autorizado está prohibido.");
    }

    private static void addFAQSection(XWPFDocument doc) {
        addHeading(doc, "10. PREGUNTAS FRECUENTES (FAQ)", 1);
        
        addHeading(doc, "10.1 Autenticación y Acceso", 2);
        
        addHeading(doc, "¿Qué debo hacer si olvido mi contraseña?", 3);
        addParagraph(doc, "Contacta con el administrador del sistema. Él puede resetear tu contraseña y darte una temporal. Luego deberás cambiarla en tu próxima sesión desde la sección de Configuración.");
        
        addHeading(doc, "¿Puedo usar la misma contraseña en múltiples ocasiones?", 3);
        addParagraph(doc, "No, el sistema requiere que cambies tu contraseña regularmente. Intenta usar contraseñas únicas y fuertes cada vez.");
        
        addHeading(doc, "¿Qué es el municipio en el login?", 3);
        addParagraph(doc, "Es el municipio con el que trabajarás en esa sesión. Según tu rol de usuario, podrás tener acceso a uno o más municipios. La selección determina qué datos verás.");
        
        addHeading(doc, "10.2 Gestión de Beneficiarios", 2);
        
        addHeading(doc, "¿Puedo registrar un beneficiario sin cónyuge?", 3);
        addParagraph(doc, "Sí, puedes registrar beneficiarios solteros, divorciados o viudos sin necesidad de ingresar datos de cónyuge. Solo aparecen los campos de cónyuge si seleccionas 'Casado' o 'Unión Libre'.");
        
        addHeading(doc, "¿Qué pasa si intento registrar dos beneficiarios con el mismo número de ID?", 3);
        addParagraph(doc, "El sistema lo rechazará. El número de identificación debe ser único en todo el sistema. Si crees que hay un duplicado, contacta al administrador.");
        
        addHeading(doc, "¿Puedo editar un beneficiario después de registrarlo?", 3);
        addParagraph(doc, "Sí, puedes editar beneficiarios. Busca el beneficiario en la lista de 'Ver Beneficiarios' y haz clic en el botón 'Editar'.");
        
        addHeading(doc, "¿Puedo eliminar un beneficiario?", 3);
        addParagraph(doc, "Sí, pero ten cuidado porque esta acción no se puede deshacer. Se te pedirá confirmación antes de eliminar. Se recomienda estar seguro antes de ejecutar esta acción.");
        
        addHeading(doc, "10.3 Gestión de Propiedades", 2);
        
        addHeading(doc, "¿Cuántos puntos geográficos puedo agregar?", 3);
        addParagraph(doc, "Máximo 4 puntos por propiedad. Esto es suficiente para definir los límites de la mayoría de predios.");
        
        addHeading(doc, "¿Qué son las coordenadas N y E?", 3);
        addParagraph(doc, "N es la latitud (coordenada Norte) y E es la longitud (coordenada Este). Son números que definen la posición geográfica exacta. Puedes obtenerlos de mapas como Google Maps.");
        
        addHeading(doc, "¿Qué es la Referencia Catastral?", 3);
        addParagraph(doc, "Es el identificador único del predio asignado por el catastro municipal o departamental. Cada propiedad debe tener una referencia catastral única.");
        
        addHeading(doc, "10.4 Resoluciones", 2);
        
        addHeading(doc, "¿Cómo descargo el documento de resolución?", 3);
        addParagraph(doc, "Cuando generas una resolución, el archivo Word se descarga automáticamente. Busca el archivo en tu carpeta de descargas. Si deseas volver a descargar después, ve a 'Ver Resoluciones' y haz clic en '📄 Ver Documento'.");
        
        addHeading(doc, "¿Puedo modificar el contenido del documento Word generado?", 3);
        addParagraph(doc, "Sí, una vez descargado, puedes abrir el archivo en Microsoft Word y editarlo. Sin embargo, se recomienda modificar los datos desde el sistema primero y luego regenerar el documento.");
        
        addHeading(doc, "¿Qué diferencia hay entre 'Generar Resolución' y 'Guardar en BD'?", 3);
        addParagraph(doc, "Generar Resolución: Crea el documento Word Y lo guarda en la BD, luego lo descarga. Guardar en BD: Solo guarda en la BD sin crear documento. Se usa cuando solo quieres registrar datos sin generar documento aún.");
        
        addHeading(doc, "10.5 Gestión de Usuarios (Solo ADMIN)", 2);
        
        addHeading(doc, "¿Cuál es la diferencia entre ADMIN, EMPLOYEE y CONSULTANT?", 3);
        addParagraph(doc, "ADMIN: Acceso total a todo. EMPLOYEE: Puede registrar datos pero acceso limitado al municipio. CONSULTANT: Solo lectura (no puede modificar datos). Los tres tienen restricciones según el municipio asignado.");
        
        addHeading(doc, "¿Qué es una contraseña temporal?", 3);
        addParagraph(doc, "Cuando reseteas la contraseña de un usuario, el sistema genera una temporal. El usuario debe cambiarla en su próximo login desde Configuración.");
        
        addHeading(doc, "¿Puedo tener dos usuarios con el mismo nombre?", 3);
        addParagraph(doc, "El nombre puede ser igual, pero el nombre de usuario debe ser único. Es el nombre de usuario (username) el que debe ser diferente.");
        
        addHeading(doc, "10.6 Dashboard y Reportes", 2);
        
        addHeading(doc, "¿Por qué mi dashboard muestra datos de otros municipios?", 3);
        addParagraph(doc, "Si eres ADMIN, verás datos de todos los municipios. Si eres EMPLOYEE o CONSULTANT, solo ves datos del municipio asignado a tu usuario.");
        
        addHeading(doc, "¿Con qué frecuencia se actualiza el dashboard?", 3);
        addParagraph(doc, "El dashboard se actualiza en tiempo real cada vez que se registra nueva información en el sistema.");
        
        addHeading(doc, "10.7 Errores y Problemas Comunes", 2);
        
        addHeading(doc, "¿Qué hago si la aplicación se congela?", 3);
        addParagraph(doc, "Espera unos segundos, ya que las operaciones pueden tomar tiempo. Si persiste, cierra la aplicación y vuelve a abrir. Si el problema continúa, contacta al soporte.");
        
        addHeading(doc, "¿Por qué mi búsqueda no encuentra resultados?", 3);
        addParagraph(doc, "Verifica la ortografía de tu búsqueda. Recuerda que depende del municipio asignado a tu usuario. Si eres EMPLOYEE o CONSULTANT, solo verás datos de tu municipio.");
        
        addHeading(doc, "¿Qué significa 'Acceso Denegado'?", 3);
        addParagraph(doc, "Significa que tu rol de usuario no tiene permisos para realizar esa acción. Solo ADMIN puede realizar ciertas operaciones. Contacta con el administrador si necesitas acceso a una función específica.");
    }

    private static void addTipsAndTricksSection(XWPFDocument doc) {
        addHeading(doc, "11. CONSEJOS Y TRUCOS", 1);
        
        addHeading(doc, "11.1 Productividad", 2);
        
        addHeading(doc, "💡 Usa búsqueda avanzada", 3);
        addParagraph(doc, "En lugar de desplazarse por largas listas, usa los filtros y búsquedas para encontrar rápidamente lo que necesitas. Búsqueda por ID, código o nombre es más rápido.");
        
        addHeading(doc, "💡 Aprovecha la exportación a Excel", 3);
        addParagraph(doc, "Puedes exportar listados completos a Excel para análisis, informes o respaldo de información. Usa Excel para crear tablas y gráficos personalizados.");
        
        addHeading(doc, "💡 Cambia el idioma según tus necesidades", 3);
        addParagraph(doc, "Si necesitas trabajar en inglés, puedes cambiar el idioma desde Configuración sin reiniciar la aplicación.");
        
        addHeading(doc, "💡 Prepara la información antes de registrar", 3);
        addParagraph(doc, "Ten lista toda la información del beneficiario o propiedad antes de comenzar a registrar. Esto evita errores y acelera el proceso.");
        
        addHeading(doc, "11.2 Seguridad", 2);
        
        addHeading(doc, "🔒 Cierra siempre sesión", 3);
        addParagraph(doc, "Especialmente si usas computadoras compartidas, siempre cierra sesión desde Configuración cuando termines de trabajar.");
        
        addHeading(doc, "🔒 Usa contraseñas fuertes", 3);
        addParagraph(doc, "Una contraseña fuerte debe tener al menos 8 caracteres, mayúsculas, números y caracteres especiales si es posible. Evita usar información personal obvias.");
        
        addHeading(doc, "🔒 Cambia tu contraseña regularmente", 3);
        addParagraph(doc, "Se recomienda cambiar tu contraseña cada 3-6 meses. Ve a Configuración > Cambiar Contraseña cuando sea necesario.");
        
        addHeading(doc, "🔒 No compartas tu contraseña", 3);
        addParagraph(doc, "Nunca le digas tu contraseña a otros, ni siquiera a otros administradores. El sistema no solicita contraseña por email o chat.");
        
        addHeading(doc, "11.3 Gestión de Datos", 2);
        
        addHeading(doc, "📊 Valida datos antes de registrar", 3);
        addParagraph(doc, "Asegúrate de que los datos sean correctos antes de hacer clic en 'Registrar'. Una vez guardados, la información debe editarse cuidadosamente.");
        
        addHeading(doc, "📊 Usa las validaciones del sistema", 3);
        addParagraph(doc, "El sistema te advierte sobre duplicados, datos inválidos, etc. Lee estos mensajes con atención.");
        
        addHeading(doc, "📊 Haz respaldos de datos importantes", 3);
        addParagraph(doc, "Exporta regularmente listas de beneficiarios y propiedades a Excel como respaldo. Esto te protege contra pérdidas accidentales.");
        
        addHeading(doc, "📊 Documenta cambios importantes", 3);
        addParagraph(doc, "Si editas o eliminas información importante, anota el motivo y fecha. Esto es útil para auditoría y seguimiento.");
        
        addHeading(doc, "11.4 Uso del Dashboard", 2);
        
        addHeading(doc, "📈 Monitorea tendencias", 3);
        addParagraph(doc, "Usa los gráficos del dashboard para identificar tendencias en registros y completar metas mensuales o anuales.");
        
        addHeading(doc, "📈 Identifica métricas importantes", 3);
        addParagraph(doc, "Presta atención a los porcentajes de beneficiarios con propiedad asignada. Esto te ayuda a priorizar trabajo pendiente.");
        
        addHeading(doc, "11.5 Resoluciones", 2);
        
        addHeading(doc, "📄 Revisa antes de descargar", 3);
        addParagraph(doc, "Antes de generar un documento de resolución, asegúrate de que todos los datos sean correctos. Una vez descargado, deberás regenerar si hay cambios.");
        
        addHeading(doc, "📄 Organiza descargas", 3);
        addParagraph(doc, "Crea una carpeta con fecha o número de resolución para organizar tus documentos descargados. Esto facilita la búsqueda después.");
        
        addHeading(doc, "📄 Guarda documentos importantes", 3);
        addParagraph(doc, "No confíes solo en la carpeta de Descargas. Copia documentos de resolución a una carpeta segura del servidor o unidad de respaldo.");
        
        addHeading(doc, "11.6 Soporte y Ayuda", 2);
        
        addHeading(doc, "❓ Lee este manual primero", 3);
        addParagraph(doc, "Si tienes una pregunta, primero busca en este manual. Probablemente encontrarás la respuesta aquí.");
        
        addHeading(doc, "❓ Contacta con el administrador", 3);
        addParagraph(doc, "Si necesitas ayuda técnica o acceso a funciones específicas, contacta con el administrador del sistema.");
        
        addHeading(doc, "❓ Documenta el problema", 3);
        addParagraph(doc, "Si hay un error, anota exactamente qué sucedió, cuándo sucedió, y qué acción estabas realizando. Esto ayuda a resolver el problema más rápido.");
        
        // Sección final
        addHeading(doc, "11.7 Conclusión", 2);
        addParagraph(doc, "TitulacionPredial es una herramienta poderosa diseñada para automatizar procesos complejos. Con estos consejos y el conocimiento de este manual, estarás en la mejor posición para utilizarla efectivamente. ¡Éxito en tu trabajo!");
    }

    // Métodos auxiliares
    private static void addHeading(XWPFDocument doc, String text, int level) {
        XWPFParagraph p = doc.createParagraph();
        XWPFRun run = p.createRun();
        run.setText(text);
        run.setBold(true);
        
        if (level == 1) {
            run.setFontSize(20);
            run.setColor("1F4788");
            p.setSpacingBefore(240);
            p.setSpacingAfter(120);
        } else if (level == 2) {
            run.setFontSize(16);
            run.setColor("2E5FA3");
            p.setSpacingBefore(180);
            p.setSpacingAfter(100);
        } else if (level == 3) {
            run.setFontSize(13);
            run.setColor("3D6BA3");
            p.setSpacingBefore(120);
            p.setSpacingAfter(80);
        }
    }

    private static void addParagraph(XWPFDocument doc, String text) {
        XWPFParagraph p = doc.createParagraph();
        XWPFRun run = p.createRun();
        run.setText(text);
        run.setFontSize(11);
        p.setSpacingAfter(100);
    }

    private static void addBulletPoint(XWPFDocument doc, String text) {
        XWPFParagraph p = doc.createParagraph();
        p.setNumID(BigInteger.valueOf(1));
        XWPFRun run = p.createRun();
        run.setText(text);
        run.setFontSize(11);
        p.setIndentationLeft(360);
        p.setSpacingAfter(60);
    }

    private static void addNumberedStep(XWPFDocument doc, String text) {
        XWPFParagraph p = doc.createParagraph();
        XWPFRun run = p.createRun();
        run.setText(text);
        run.setFontSize(11);
        p.setIndentationLeft(360);
        p.setSpacingAfter(60);
    }

    private static void addPageBreak(XWPFDocument doc) {
        XWPFParagraph p = doc.createParagraph();
        p.createRun().addBreak(BreakType.PAGE);
    }

    private static void setCellText(XWPFTableCell cell, String text) {
        setCellText(cell, text, false);
    }

    private static void setCellText(XWPFTableCell cell, String text, boolean bold) {
        if (cell.getParagraphs().isEmpty()) {
            cell.addParagraph();
        }
        XWPFParagraph p = cell.getParagraphs().get(0);
        XWPFRun run = p.createRun();
        run.setText(text);
        run.setFontSize(10);
        if (bold) {
            run.setBold(true);
            run.setColor("FFFFFF");
            cell.setColor("1F4788");
        }
    }

    private static void fillBeneficiaryTable(XWPFTable table) {
        setCellText(table.getRow(1).getCell(0), "Código");
        setCellText(table.getRow(1).getCell(1), "Auto-generado (lectura)");
        
        setCellText(table.getRow(2).getCell(0), "Nombre");
        setCellText(table.getRow(2).getCell(1), "Nombre del beneficiario (requerido)");
        
        setCellText(table.getRow(3).getCell(0), "Apellidos");
        setCellText(table.getRow(3).getCell(1), "Apellidos del beneficiario (requerido)");
        
        setCellText(table.getRow(4).getCell(0), "Tipo de Identificación");
        setCellText(table.getRow(4).getCell(1), "CC, TI, CE o PP (requerido)");
        
        setCellText(table.getRow(5).getCell(0), "Número de Identificación");
        setCellText(table.getRow(5).getCell(1), "Debe ser único en el sistema (requerido)");
        
        setCellText(table.getRow(6).getCell(0), "Departamento");
        setCellText(table.getRow(6).getCell(1), "Córdoba (normalmente)");
        
        setCellText(table.getRow(7).getCell(0), "Municipio");
        setCellText(table.getRow(7).getCell(1), "Municipio de residencia (requerido)");
        
        setCellText(table.getRow(8).getCell(0), "Dirección");
        setCellText(table.getRow(8).getCell(1), "Dirección completa (requerido)");
        
        setCellText(table.getRow(9).getCell(0), "Estado Civil");
        setCellText(table.getRow(9).getCell(1), "Soltero, Casado, Unión Libre, Divorciado o Viudo");
        
        setCellText(table.getRow(10).getCell(0), "Cónyuge");
        setCellText(table.getRow(10).getCell(1), "Se activa si está Casado o en Unión Libre");
    }
}
