package com.hector.titulacionpredial.view.swing.chart.blankchart;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Componente base para gráficos con ejes coordenados.
 *
 * <p>
 * Dibuja los ejes X e Y con etiquetas, líneas de cuadrícula
 * y proporciona el área de trazado para que el renderizador
 * ({@link BlankPlotChartRender}) dibuje las series de datos.
 * Utiliza {@link NiceScale} para calcular las divisiones
 * de los ejes.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see BlankPlotChartRender
 * @see NiceScale
 * @since 1.0
 */
public class BlankPlotChart extends JComponent {

    private final DecimalFormat format = new DecimalFormat("#,##0.##");
    private NiceScale niceScale;
    private double maxValues;
    private double minValues;
    private int labelCount;
    private String valuesFormat = "#,##0.##";
    private BlankPlotChartRender blankPlotChatRender;

    /**
     * Crea el componente de ejes coordenados con valores por defecto.
     */
    public BlankPlotChart() {
        setBackground(Color.WHITE);
        setOpaque(false);
        setForeground(new Color(45, 106, 79));
        setBorder(new EmptyBorder(35, 10, 10, 10));
        init();
    }

    public NiceScale getNiceScale() {
        return niceScale;
    }


    public void setNiceScale(NiceScale niceScale) {
        this.niceScale = niceScale;
    }

    public double getMaxValues() {
        return maxValues;
    }

    /**
     * Establece el valor máximo y recalcula la escala.
     *
     * @param maxValues valor máximo
     */
    public void setMaxValues(double maxValues) {
        this.maxValues = maxValues;
        niceScale.setMax(maxValues);
        repaint();
    }

    public double getMinValues() {
        return minValues;
    }

    public void setMinValues(double minValues) {
        this.minValues = minValues;
    }

    public int getLabelCount() {
        return labelCount;
    }

    public void setLabelCount(int labelCount) {
        this.labelCount = labelCount;
    }

    public String getValuesFormat() {
        return valuesFormat;
    }

    /**
     * Establece el patrón de formato de los valores.
     *
     * @param valuesFormat patrón {@link DecimalFormat}
     */
    public void setValuesFormat(String valuesFormat) {
        this.valuesFormat = valuesFormat;
        format.applyPattern(valuesFormat);
    }

    public BlankPlotChartRender getBlankPlotChatRender() {
        return blankPlotChatRender;
    }

    public void setBlankPlotChatRender(BlankPlotChartRender blankPlotChatRender) {
        this.blankPlotChatRender = blankPlotChatRender;
    }

    /**
     * Inicializa la escala por defecto y el listener del mouse.
     */
    private void init() {
        initValues(0, 10);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent me) {
                mouseMove((Graphics2D) getGraphics(), me);
            }
        });
    }

    /**
     * Inicializa la escala con un rango de valores.
     *
     * @param minValues valor mínimo
     * @param maxValues valor máximo
     */
    public void initValues(double minValues, double maxValues) {
        this.minValues = minValues;
        this.maxValues = maxValues;
        niceScale = new NiceScale(minValues, maxValues);
        repaint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (niceScale != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
            createLine(g2);
            createValues(g2);
            createLabelText(g2);
            renderSeries(g2);
        }
    }

    /**
     * Dibuja las líneas horizontales de la cuadrícula.
     *
     * @param g2 contexto gráfico
     */
    public void createLine(Graphics2D g2) {
        g2.setColor(new Color(150, 150, 150, 20));
        Insets insets = getInsets();
        double textHeight = getLabelTextHeight(g2);
        double height = getHeight() - (insets.top + insets.bottom) - textHeight;
        double space = height / niceScale.getMaxTicks();
        double locationY = insets.bottom + textHeight;
        double textWidth = getMaxValuesTextWidth(g2);
        double spaceText = 5;

        for (int i = 0; i <= niceScale.getMaxTicks(); i++) {
            int y = (int) (getHeight() - locationY);
            g2.drawLine((int) (insets.left + textWidth + spaceText), y, getWidth() - insets.right, y);
            locationY += space;
        }
    }

    /**
     * Dibuja los valores numéricos del eje Y.
     *
     * @param g2 contexto gráfico
     */
    private void createValues(Graphics2D g2) {
        g2.setColor(getForeground());
        Insets insets = getInsets();
        double textHeight = getLabelTextHeight(g2);
        double height = getHeight() - (insets.top + insets.bottom) - textHeight;
        double space = height / niceScale.getMaxTicks();
        double valuesCount = niceScale.getNiceMin();
        double locationY = insets.bottom + textHeight;
        FontMetrics ft = g2.getFontMetrics();

        for (int i = 0; i <= niceScale.getMaxTicks(); i++) {
            String text = format.format(valuesCount);
            Rectangle2D r2 = ft.getStringBounds(text, g2);
            double stringY = r2.getCenterY() * -1;
            double y = getHeight() - locationY + stringY;
            g2.drawString(text, insets.left, (int) y);
            locationY += space;
            valuesCount += niceScale.getTickSpacing();
        }
    }

    /**
     * Dibuja las etiquetas de texto del eje X.
     *
     * @param g2 contexto gráfico
     */
    private void createLabelText(Graphics2D g2) {
        if (labelCount > 0) {
            Insets insets = getInsets();
            double textWidth = getMaxValuesTextWidth(g2);
            double spaceText = 5;
            double width = getWidth() - insets.left - insets.right - textWidth - spaceText;
            double space = width / labelCount;
            double locationX = insets.left + textWidth + spaceText;
            double locationText = getHeight() - insets.bottom + 5;
            FontMetrics ft = g2.getFontMetrics();

            for (int i = 0; i < labelCount; i++) {
                double centerX = ((locationX + space / 2));
                g2.setColor(getForeground());
                String text = getChartText(i);
                Rectangle2D r2 = ft.getStringBounds(text, g2);
                double textX = centerX - r2.getWidth() / 2;
                g2.drawString(text, (int) textX, (int) locationText);
                locationX += space;
            }
        }
    }

    /**
     * Renderiza las series de datos usando el renderizador delegado.
     *
     * @param g2 contexto gráfico
     */
    private void renderSeries(Graphics2D g2) {
        if (blankPlotChatRender != null) {
            Insets insets = getInsets();
            double textWidth = getMaxValuesTextWidth(g2);
            double textHeight = getLabelTextHeight(g2);
            double spaceText = 5;
            double width = getWidth() - insets.left - insets.right - textWidth - spaceText;
            double height = getHeight() - insets.top - insets.bottom - textHeight;
            double space = width / labelCount;
            double locationX = insets.left + textWidth + spaceText;

            for (int i = 0; i < labelCount; i++) {
                blankPlotChatRender.renderSeries(this, g2, getRectangle(i, height, space, locationX, insets.top), i);
            }

            List<Path2D.Double> gra = initGra(blankPlotChatRender.getMaxLegend());

            for (int i = 0; i < labelCount; i++) {
                blankPlotChatRender.renderSeries(this, g2, getRectangle(i, height, space, locationX, insets.top), i, gra);
            }

            blankPlotChatRender.renderGraphics(g2, gra);
        }
    }

    /**
     * Crea la lista de rutas gráficas para las series.
     *
     * @param size cantidad de series
     * @return lista de {@link Path2D.Double} vacías
     */
    private List<Path2D.Double> initGra(int size) {
        List<Path2D.Double> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(new Path2D.Double());
        }

        return list;
    }

    /**
     * Procesa el movimiento del mouse para tooltips interactivos.
     *
     * @param g2  contexto gráfico
     * @param evt evento del mouse
     */
    private void mouseMove(Graphics2D g2, MouseEvent evt) {
        if (blankPlotChatRender != null) {
            Insets insets = getInsets();
            double textWidth = getMaxValuesTextWidth(g2);
            double textHeight = getLabelTextHeight(g2);
            double spaceText = 5;
            double width = getWidth() - insets.left - insets.right - textWidth - spaceText;
            double height = getHeight() - insets.top - insets.bottom - textHeight;
            double space = width / labelCount;
            double locationX = insets.left + textWidth + spaceText;

            for (int i = 0; i < labelCount; i++) {
                boolean stop = blankPlotChatRender.mouseMoving(this, evt, g2, getRectangle(i, height, space, locationX, insets.top), i);

                if (stop) {
                    break;
                }
            }
        }
    }

    /**
     * Calcula el ancho máximo de las etiquetas del eje Y.
     *
     * @param g2 contexto gráfico
     * @return ancho máximo en píxeles
     */
    private double getMaxValuesTextWidth(Graphics2D g2) {
        double width = 0;
        FontMetrics ft = g2.getFontMetrics();
        double valuesCount = niceScale.getNiceMin();

        for (int i = 0; i <= niceScale.getMaxTicks(); i++) {
            String text = format.format(valuesCount);
            Rectangle2D r2 = ft.getStringBounds(text, g2);
            double w = r2.getWidth();

            if (w > width) {
                width = w;
            }

            valuesCount += niceScale.getTickSpacing();
        }

        return width;
    }

    /**
     * Obtiene la altura del texto de una etiqueta.
     *
     * @param g2 contexto gráfico
     * @return altura en píxeles
     */
    private int getLabelTextHeight(Graphics2D g2) {
        FontMetrics ft = g2.getFontMetrics();
        return ft.getHeight();
    }

    /**
     * Obtiene el texto de la etiqueta para un índice.
     *
     * @param index índice de la categoría
     * @return texto de la etiqueta
     */
    private String getChartText(int index) {
        if (blankPlotChatRender != null) {
            return blankPlotChatRender.getLabelText(index);
        } else {
            return "Label";
        }
    }

    /**
     * Calcula el rectángulo de una serie en el área de trazado.
     *
     * @param index  índice de la serie
     * @param height altura del área de trazado
     * @param space  ancho por categoría
     * @param startX posición X inicial
     * @param startY posición Y inicial
     * @return área de la serie
     */
    public SeriesSize getRectangle(int index, double height, double space, double startX, double startY) {
        double x = startX + space * index;
        return new SeriesSize(x, startY + 1, space, height);
    }

    /**
     * Convierte un valor de datos a píxeles dentro del área de trazado.
     *
     * @param values valor del dato
     * @param height altura disponible en píxeles
     * @return posición en píxeles
     */
    public double getSeriesValuesOf(double values, double height) {
        double max = niceScale.getTickSpacing() * niceScale.getMaxTicks();
        double percentValues = values * 100d / max;
        return height * percentValues / 100d;
    }

}
