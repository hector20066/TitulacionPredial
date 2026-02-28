package com.hector.titulacionpredial.view.swing.chart.blankchart;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.util.List;

/**
 * Interfaz de renderizado para el gráfico base ({@link BlankPlotChart}).
 *
 * <p>
 * Define el contrato para dibujar las series de datos
 * sobre el área de trazado del gráfico.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see BlankPlotChart
 * @since 1.0
 */
public interface BlankPlotChartRender {

    /**
     * Obtiene el texto de la etiqueta para un índice dado.
     *
     * @param index índice de la serie
     * @return texto de la etiqueta
     */
    String getLabelText(int index);

    /**
     * Renderiza una serie de datos sobre el área de trazado.
     *
     * @param chart gráfico base
     * @param g2    contexto gráfico 2D
     * @param size  dimensiones del área de la serie
     * @param index índice de la serie
     */
    void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index);

    /**
     * Renderiza una serie de datos acumulando trazados en la lista.
     *
     * @param chart gráfico base
     * @param g2    contexto gráfico 2D
     * @param size  dimensiones del área de la serie
     * @param index índice de la serie
     * @param gra   lista de trazados acumulados
     */
    void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index, List<Path2D.Double> gra);

    /**
     * Gestiona el movimiento del mouse sobre el gráfico.
     *
     * @param chart gráfico base
     * @param evt   evento del mouse
     * @param g2    contexto gráfico 2D
     * @param size  dimensiones del área de la serie
     * @param index índice de la serie
     * @return {@code true} si el mouse se encuentra sobre una serie
     */
    boolean mouseMoving(BlankPlotChart chart, MouseEvent evt, Graphics2D g2, SeriesSize size, int index);

    /**
     * Renderiza los trazados gráficos acumulados.
     *
     * @param g2  contexto gráfico 2D
     * @param gra lista de trazados a dibujar
     */
    void renderGraphics(Graphics2D g2, List<Path2D.Double> gra);

    /**
     * Obtiene el número máximo de elementos en la leyenda.
     *
     * @return cantidad máxima de leyendas
     */
    int getMaxLegend();

}
