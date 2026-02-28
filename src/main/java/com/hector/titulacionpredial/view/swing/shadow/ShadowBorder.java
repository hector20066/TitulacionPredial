package com.hector.titulacionpredial.view.swing.shadow;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;

/**
 * Singleton para la creación de bordes con efecto de sombra.
 *
 * <p>
 * Genera imágenes de sombra interior ({@code createShadowIn})
 * y exterior ({@code createShadowOut}) utilizando
 * {@link ShadowRenderer}. Define el enum {@code ShadowType}
 * para distinguir entre ambos tipos.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @see ShadowRenderer
 * @since 1.0
 */
public class ShadowBorder {

    /**
     * Instancia única del singleton.
     */
    private static ShadowBorder instance;

    /**
     * Constructor privado para evitar instanciación externa.
     */
    private ShadowBorder() {

    }

    /**
     * Obtiene la instancia única de {@code ShadowBorder}.
     *
     * @return instancia singleton
     */
    public static ShadowBorder getInstance() {
        if (instance == null) {
            instance = new ShadowBorder();
        }

        return instance;
    }

    /**
     * Crea una imagen con sombra interior a partir de las dimensiones del componente.
     *
     * @param com    componente de referencia
     * @param border tamaño del borde de sombra
     * @param radius radio de las esquinas
     * @return imagen con sombra interior
     */
    public BufferedImage createShadowIn(Component com, int border, int radius) {
        return createShadowIn(com.getWidth(), com.getHeight(), border, radius, com.getBackground());
    }

    /**
     * Divide el área en una forma triangular para separar
     * las zonas de sombra.
     *
     * @param width  ancho del área
     * @param height alto del área
     * @return forma triangular
     */
    private Shape split(int width, int height) {
        Path2D.Float p = new Path2D.Float();
        p.moveTo(width, 0);
        p.lineTo(width, height);
        p.lineTo(0, height);

        return p;
    }

    /**
     * Crea una imagen con sombra exterior a partir de las dimensiones del componente.
     *
     * @param com    componente de referencia
     * @param border tamaño del borde de sombra
     * @param radius radio de las esquinas
     * @return imagen con sombra exterior
     */
    public BufferedImage createShadowOut(Component com, int border, int radius) {
        return createShadowOut(com.getWidth(), com.getHeight(), border, radius, com.getBackground());
    }

    /**
     * Crea una imagen con sombra interior con dimensiones y color específicos.
     *
     * @param width  ancho de la imagen
     * @param height alto de la imagen
     * @param border tamaño del borde
     * @param radius radio de las esquinas
     * @param color  color de fondo
     * @return imagen con sombra interior
     */
    public BufferedImage createShadowIn(int width, int height, int border, int radius, Color color) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x = border;
        int y = border;
        int size = radius;

        g2.setColor(color);
        g2.fillRoundRect(x, y, width, height, border, border);

        Shape s = new RoundRectangle2D.Double(x, y, width - border * 2, height - border * 2, size, size);
        Area area = new Area(new Rectangle(0, 0, width - border, height - border));
        area.subtract(new Area(s));
        area.subtract(new Area(split(width, height)));

        g2.drawImage(new ShadowRenderer(border, 0.4f, new Color(89, 69, 137)).createShadow(createImage(width, height, area)), -border, -border, null);

        Shape s_w = new RoundRectangle2D.Double(x, y, width - border * 2, height - border * 2, size, size);
        Area area_w = new Area(new Rectangle(0, 0, width, height));
        area_w.subtract(new Area(s_w));
        area_w.intersect(new Area(split(width, height)));

        g2.drawImage(new ShadowRenderer(border, 1f, new Color(255, 255, 255)).createShadow(createImage(width, height, area_w)), -border, -border, null);
        g2.fill(area);
        g2.fill(area_w);
        g2.setComposite(AlphaComposite.Clear);

        Shape cut = new RoundRectangle2D.Double(x, y, width - border * 2, height - border * 2, size, size);
        Area bg = new Area(new Rectangle(0, 0, width, height));
        bg.subtract(new Area(cut));

        g2.fill(bg);
        g2.dispose();

        return img;
    }

    /**
     * Crea una imagen con sombra exterior con dimensiones y color específicos.
     *
     * @param width  ancho de la imagen
     * @param height alto de la imagen
     * @param border tamaño del borde
     * @param radius radio de las esquinas
     * @param color  color de fondo
     * @return imagen con sombra exterior
     */
    public BufferedImage createShadowOut(int width, int height, int border, int radius, Color color) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int x = 0;
        int y = 0;
        int size = radius;

        g2.drawImage(new ShadowRenderer(border, 1f, new Color(255, 255, 255)).createShadow(createImage(x, y, width - border * 2, height - border * 2, size)), 0, 0, null);
        g2.drawImage(new ShadowRenderer(border, 0.4f, new Color(89, 69, 137)).createShadow(createImage(x, y, width - border * 3, height - border * 3, size)), border, border, null);
        g2.setColor(color);
        g2.fillRoundRect(x + border, y + border, width - border * 2, height - border * 2, size, size);
        g2.dispose();

        return img;
    }

    /**
     * Crea una imagen auxiliar a partir de un área recortada.
     *
     * @param width  ancho de la imagen
     * @param height alto de la imagen
     * @param area   área a rellenar
     * @return imagen con el área rellena
     */
    private BufferedImage createImage(int width, int height, Area area) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fill(area);

        return img;
    }

    /**
     * Crea una imagen auxiliar con un rectángulo redondeado.
     *
     * @param x      coordenada X
     * @param y      coordenada Y
     * @param width  ancho del rectángulo
     * @param height alto del rectángulo
     * @param size   radio de las esquinas
     * @return imagen con el rectángulo relleno
     */
    private BufferedImage createImage(int x, int y, int width, int height, int size) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(x, y, width, height, size, size);

        return img;
    }

    /**
     * Enumeración que define los tipos de sombra.
     */
    public enum ShadowType {

        IN_SHADOW,
        OUT_SHADOW

    }

}
