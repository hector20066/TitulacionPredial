package com.hector.titulacionpredial.view.swing.shadow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.net.URL;

/**
 * Utilidades para manipulación de imágenes {@link BufferedImage}.
 *
 * <p>
 * Proporciona métodos para crear imágenes compatibles con
 * la configuración gráfica del sistema, generar miniaturas
 * y acceder directamente a los píxeles del raster para
 * optimizar el rendimiento.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class GraphicsUtilities {

    /**
     * Constructor privado para evitar instanciación.
     */
    private GraphicsUtilities() {

    }

    /**
     * Obtiene la configuración gráfica predeterminada del sistema.
     *
     * @return configuración gráfica
     */
    private static GraphicsConfiguration getGraphicsConfiguration() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
    }

    /**
     * Crea una imagen compatible con el modelo de color de la imagen fuente.
     *
     * @param image imagen de referencia
     * @return nueva imagen compatible
     */
    public static BufferedImage createColorModelCompatibleImage(BufferedImage image) {
        ColorModel cm = image.getColorModel();
        return new BufferedImage(cm, cm.createCompatibleWritableRaster(image.getWidth(), image.getHeight()), cm.isAlphaPremultiplied(), null);
    }

    /**
     * Crea una imagen compatible con las mismas dimensiones.
     *
     * @param image imagen de referencia
     * @return nueva imagen compatible
     */
    public static BufferedImage createCompatibleImage(BufferedImage image) {
        return createCompatibleImage(image, image.getWidth(), image.getHeight());
    }

    /**
     * Crea una imagen compatible con dimensiones específicas.
     *
     * @param image  imagen de referencia
     * @param width  ancho
     * @param height alto
     * @return nueva imagen compatible
     */
    public static BufferedImage createCompatibleImage(BufferedImage image, int width, int height) {
        return getGraphicsConfiguration().createCompatibleImage(width, height, image.getTransparency());
    }

    /**
     * Crea una imagen opaca compatible con las dimensiones dadas.
     *
     * @param width  ancho
     * @param height alto
     * @return nueva imagen compatible
     */
    public static BufferedImage createCompatibleImage(int width, int height) {
        return getGraphicsConfiguration().createCompatibleImage(width, height);
    }

    /**
     * Crea una imagen translúcida compatible con las dimensiones dadas.
     *
     * @param width  ancho
     * @param height alto
     * @return nueva imagen translúcida
     */
    public static BufferedImage createCompatibleTranslucentImage(int width, int height) {
        return getGraphicsConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
    }

    /**
     * Carga una imagen desde un recurso y la convierte a formato compatible.
     *
     * @param resource URL del recurso
     * @return imagen compatible
     * @throws IOException si ocurre un error al leer el recurso
     */
    public static BufferedImage loadCompatibleImage(URL resource) throws IOException {
        BufferedImage image = ImageIO.read(resource);
        return toCompatibleImage(image);
    }

    /**
     * Convierte una imagen al formato compatible con el sistema gráfico.
     *
     * @param image imagen a convertir
     * @return imagen compatible
     */
    public static BufferedImage toCompatibleImage(BufferedImage image) {
        if (image.getColorModel().equals(getGraphicsConfiguration().getColorModel())) {
            return image;
        }

        BufferedImage compatibleImage = getGraphicsConfiguration().createCompatibleImage(image.getWidth(), image.getHeight(), image.getTransparency());
        Graphics g = compatibleImage.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return compatibleImage;
    }

    /**
     * Crea una miniatura rápida manteniendo la proporción.
     *
     * @param image   imagen fuente
     * @param newSize tamaño máximo (ancho o alto)
     * @return imagen miniatura
     */
    public static BufferedImage createThumbnailFast(BufferedImage image, int newSize) {
        float ratio;
        int width = image.getWidth();
        int height = image.getHeight();

        if (width > height) {
            if (newSize >= width) {
                throw new IllegalArgumentException("newSize must be lower than" + " the image width");
            } else if (newSize <= 0) {
                throw new IllegalArgumentException("newSize must" + " be greater than 0");
            }

            ratio = (float) width / (float) height;
            width = newSize;
            height = (int) (newSize / ratio);
        } else {
            if (newSize >= height) {
                throw new IllegalArgumentException("newSize must be lower than" + " the image height");
            } else if (newSize <= 0) {
                throw new IllegalArgumentException("newSize must" + " be greater than 0");
            }

            ratio = (float) height / (float) width;
            height = newSize;
            width = (int) (newSize / ratio);
        }

        return getBufferedImage(image, width, height);
    }

    /**
     * Crea una miniatura rápida con dimensiones específicas.
     *
     * @param image     imagen fuente
     * @param newWidth  nuevo ancho
     * @param newHeight nuevo alto
     * @return imagen miniatura
     */
    public static BufferedImage createThumbnailFast(BufferedImage image, int newWidth, int newHeight) {
        if (newWidth >= image.getWidth() || newHeight >= image.getHeight()) {
            throw new IllegalArgumentException("newWidth and newHeight cannot" + " be greater than the image" + " dimensions");
        } else if (newWidth <= 0 || newHeight <= 0) {
            throw new IllegalArgumentException("newWidth and newHeight must" + " be greater than 0");
        }

        return getBufferedImage(image, newWidth, newHeight);
    }

    /**
     * Escala la imagen a las dimensiones dadas con interpolación bilineal.
     *
     * @param image  imagen fuente
     * @param width  nuevo ancho
     * @param height nuevo alto
     * @return imagen escalada
     */
    private static BufferedImage getBufferedImage(BufferedImage image, int width, int height) {
        BufferedImage temp = createCompatibleImage(image, width, height);
        Graphics2D g2 = temp.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, 0, 0, temp.getWidth(), temp.getHeight(), null);
        g2.dispose();

        return temp;
    }

    /**
     * Crea una miniatura de alta calidad manteniendo la proporción.
     *
     * @param image   imagen fuente
     * @param newSize tamaño máximo (ancho o alto)
     * @return imagen miniatura
     */
    public static BufferedImage createThumbnail(BufferedImage image, int newSize) {
        int width = image.getWidth();
        int height = image.getHeight();
        boolean isWidthGreater = width > height;

        if (isWidthGreater) {
            if (newSize >= width) {
                throw new IllegalArgumentException("newSize must be lower than" + " the image width");
            }
        } else if (newSize >= height) {
            throw new IllegalArgumentException("newSize must be lower than" + " the image height");
        }

        if (newSize <= 0) {
            throw new IllegalArgumentException("newSize must" + " be greater than 0");
        }

        float ratioWH = (float) width / (float) height;
        float ratioHW = (float) height / (float) width;
        BufferedImage thumb = image;

        do {
            if (isWidthGreater) {
                width /= 2;

                if (width < newSize) {
                    width = newSize;
                }

                height = (int) (width / ratioWH);
            } else {
                height /= 2;

                if (height < newSize) {
                    height = newSize;
                }

                width = (int) (height / ratioHW);
            }

            thumb = getBufferedImage(image, width, height, thumb);
        } while (newSize != (isWidthGreater ? width : height));

        return thumb;
    }

    /**
     * Crea una miniatura de alta calidad con dimensiones específicas.
     *
     * @param image     imagen fuente
     * @param newWidth  nuevo ancho
     * @param newHeight nuevo alto
     * @return imagen miniatura
     */
    public static BufferedImage createThumbnail(BufferedImage image, int newWidth, int newHeight) {
        int width = image.getWidth();
        int height = image.getHeight();

        if (newWidth >= width || newHeight >= height) {
            throw new IllegalArgumentException("newWidth and newHeight cannot" + " be greater than the image" + " dimensions");
        } else if (newWidth <= 0 || newHeight <= 0) {
            throw new IllegalArgumentException("newWidth and newHeight must" + " be greater than 0");
        }

        BufferedImage thumb = image;

        do {
            if (width > newWidth) {
                width /= 2;

                if (width < newWidth) {
                    width = newWidth;
                }
            }

            if (height > newHeight) {
                height /= 2;

                if (height < newHeight) {
                    height = newHeight;
                }
            }

            thumb = getBufferedImage(image, width, height, thumb);
        } while (width != newWidth || height != newHeight);

        return thumb;
    }

    /**
     * Escala progresivamente la imagen con interpolación bilineal.
     *
     * @param image  imagen fuente
     * @param width  nuevo ancho
     * @param height nuevo alto
     * @param thumb  imagen intermedia acumulada
     * @return imagen escalada
     */
    private static BufferedImage getBufferedImage(BufferedImage image, int width, int height, BufferedImage thumb) {
        BufferedImage temp = createCompatibleImage(image, width, height);
        Graphics2D g2 = temp.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(thumb, 0, 0, temp.getWidth(), temp.getHeight(), null);
        g2.dispose();
        thumb = temp;

        return thumb;
    }

    /**
     * Obtiene los píxeles de una región de la imagen como un arreglo de enteros ARGB.
     *
     * @param img    imagen fuente
     * @param x      coordenada X
     * @param y      coordenada Y
     * @param w      ancho de la región
     * @param h      alto de la región
     * @param pixels arreglo destino ({@code null} para crear uno nuevo)
     * @return arreglo de píxeles ARGB
     */
    public static int[] getPixels(BufferedImage img, int x, int y, int w, int h, int[] pixels) {
        if (w == 0 || h == 0) {
            return new int[0];
        }

        if (pixels == null) {
            pixels = new int[w * h];
        } else if (pixels.length < w * h) {
            throw new IllegalArgumentException("pixels array must have a length" + " >= w*h");
        }

        int imageType = img.getType();

        if (imageType == BufferedImage.TYPE_INT_ARGB || imageType == BufferedImage.TYPE_INT_RGB) {
            Raster raster = img.getRaster();
            return (int[]) raster.getDataElements(x, y, w, h, pixels);
        }

        return img.getRGB(x, y, w, h, pixels, 0, w);
    }

    /**
     * Establece los píxeles en una región de la imagen.
     *
     * @param img    imagen destino
     * @param x      coordenada X
     * @param y      coordenada Y
     * @param w      ancho de la región
     * @param h      alto de la región
     * @param pixels arreglo de píxeles ARGB
     */
    public static void setPixels(BufferedImage img, int x, int y, int w, int h, int[] pixels) {
        if (pixels == null || w == 0 || h == 0) {
            return;
        } else if (pixels.length < w * h) {
            throw new IllegalArgumentException("pixels array must have a length" + " >= w*h");
        }

        int imageType = img.getType();

        if (imageType == BufferedImage.TYPE_INT_ARGB || imageType == BufferedImage.TYPE_INT_RGB) {
            WritableRaster raster = img.getRaster();
            raster.setDataElements(x, y, w, h, pixels);
        } else {
            img.setRGB(x, y, w, h, pixels, 0, w);
        }
    }

}
