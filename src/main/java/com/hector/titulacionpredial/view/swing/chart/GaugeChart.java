package com.hector.titulacionpredial.view.swing.chart;

import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

/**
 * Componente gráfico de tipo medidor (gauge) semicircular.
 *
 * <p>
 * Dibuja un arco de progreso con gradiente de colores
 * y muestra el valor porcentual en el centro. Incluye
 * animación suave al actualizar el valor mediante
 * la librería TimingFramework.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class GaugeChart extends JComponent {

    private final Animator animator;
    private int gaugeSize = 10;
    private Color color1 = new Color(51, 71, 216);
    private Color color2 = new Color(237, 63, 63);
    private int value;
    private int maximum = 100;
    private float targetAnimate;
    private float currentAnimate;
    private float lastAnimate;

    /**
     * Crea un medidor semicircular con animación.
     */
    public GaugeChart() {
        setFont(new JLabel().getFont().deriveFont(0, 20));
        setPreferredSize(new Dimension(250, 220));
        setForeground(new Color(60, 60, 60));

        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                currentAnimate = (targetAnimate - lastAnimate) * fraction;
                currentAnimate += lastAnimate;
                value = (int) currentAnimate;
                repaint();
            }

            @Override
            public void end() {
                lastAnimate = currentAnimate;
            }
        };

        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
    }

    public int getGaugeSize() {
        return gaugeSize;
    }

    public void setGaugeSize(int gaugeSize) {
        this.gaugeSize = gaugeSize;
        repaint();
    }

    public Color getColor1() {
        return color1;
    }

    /**
     * Establece el primer color del gradiente.
     *
     * @param color1 primer color
     */
    public void setColor1(Color color1) {
        this.color1 = color1;
        repaint();
    }

    public Color getColor2() {
        return color2;
    }

    /**
     * Establece el segundo color del gradiente.
     *
     * @param color2 segundo color
     */
    public void setColor2(Color color2) {
        this.color2 = color2;
        repaint();
    }

    public int getValue() {
        return value;
    }

    /**
     * Establece el valor del medidor sin animación.
     *
     * @param value valor (se limita a 0 como mínimo)
     */
    public void setValue(int value) {
        if (animator.isRunning()) {
            animator.stop();
        }

        if (value < 0) {
            value = 0;
        }

        this.value = value;
        lastAnimate = getValueFixed();
        repaint();
    }

    public int getMaximum() {
        return maximum;
    }

    /**
     * Establece el valor máximo del medidor.
     *
     * @param maximum valor máximo
     */
    public void setMaximum(int maximum) {
        this.maximum = maximum;
        repaint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        float spaceBot = 0.15f;
        int width = getWidth();
        int height = getHeight();
        height += (int) (height * spaceBot);
        int size = Math.min(width, height) - (gaugeSize + 5);
        int centerSize = 20;
        int x = (width - size) / 2;
        int y = (height - size) / 2;
        int centerX = width / 2;
        int centerY = height / 2;
        int angleStart = -35;
        g2.setColor(new Color(240, 240, 240));
        g2.fillOval(centerX - centerSize / 2, centerY - centerSize / 2, centerSize, centerSize);
        g2.setStroke(new BasicStroke(gaugeSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER));

        Shape s = new Arc2D.Double(x, y, size, size, angleStart, 250, Arc2D.OPEN);
        g2.draw(s);
        double angle = getAngleOfValues();

        if (angle > 0) {
            s = new Arc2D.Double(x, y, size, size, angleStart + 250 - angle, angle, Arc2D.OPEN);
            GradientPaint gra = new GradientPaint(0, 0, color1, width, 0, color2);
            g2.setPaint(gra);
            g2.draw(s);
        }

        g2.setStroke(new BasicStroke(1f));

        double len = 20;
        double space = 250 / len;
        double start = angleStart + 7;
        double angleSize = ((double) size / 2) - gaugeSize;
        g2.setColor(new Color(200, 200, 200));
        for (int i = 1; i <= len; i++) {
            Point p = getLocation(start, angleSize);
            g2.fillOval(centerX + p.x - 2, centerY - p.y - 2, 4, 4);
            start += space;
        }

        double ang = angleStart + 250 - angle;
        g2.setColor(color2);

        Path2D p = new Path2D.Double();
        Point end = getLocation(ang, angleSize);
        Point right = getLocation(ang - 90, 5);
        Point left = getLocation(ang + 90, 5);
        p.moveTo(centerX + left.x, centerY - left.y);
        p.lineTo(centerX + end.x, centerY - end.y);
        p.lineTo(centerX + right.x, centerY - right.y);
        g2.fill(p);
        g2.fillOval(centerX - 5, centerY - 5, 10, 10);
        g2.setColor(new Color(240, 240, 240));
        g2.fillOval(centerX - 2, centerY - 2, 4, 4);
        drawText(g2, centerX, centerY, angleSize);
        super.paint(grphcs);
    }

    /**
     * Dibuja el texto porcentual centrado en el medidor.
     *
     * @param g2   contexto gráfico
     * @param x    coordenada X central
     * @param y    coordenada Y central
     * @param size radio del arco
     */
    private void drawText(Graphics2D g2, int x, int y, double size) {
        g2.setColor(getForeground());
        double max = maximum;
        double v = getValueFixed();
        double n = v / max * 100f;
        String text = (int) n + "%";
        FontMetrics ft = g2.getFontMetrics();
        Rectangle2D r2 = ft.getStringBounds(text, g2);
        g2.drawString(text, (int) (x - r2.getWidth() / 2), (int) (y + size - r2.getHeight()));
    }

    /**
     * Calcula el ángulo de arco correspondiente al valor actual.
     *
     * @return ángulo en grados
     */
    private double getAngleOfValues() {
        double max = maximum;
        double v = getValueFixed();
        double n = v / max * 100f;
        return n * 250f / 100f;
    }

    private int getValueFixed() {
        return value > maximum ? maximum : value;
    }

    /**
     * Calcula la posición XY en la circunferencia.
     *
     * @param angle ángulo en grados
     * @param size  radio
     * @return punto en la circunferencia
     */
    private Point getLocation(double angle, double size) {
        double x = Math.cos(Math.toRadians(angle)) * size;
        double y = Math.sin(Math.toRadians(angle)) * size;
        return new Point((int) x, (int) y);
    }

    /**
     * Establece el valor del medidor con animación.
     *
     * @param value valor objetivo
     */
    public void setValueWithAnimation(int value) {
        if (value < 0) {
            value = 0;
        }

        this.targetAnimate = value > maximum ? maximum : value;

        if (animator.isRunning()) {
            animator.stop();
        }

        animator.start();
    }

}
