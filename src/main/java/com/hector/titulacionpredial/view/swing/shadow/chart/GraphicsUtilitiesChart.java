package com.hector.titulacionpredial.view.swing.shadow.chart;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.IOException;
import java.net.URL;

/**
 * Specific graphics utilities for graphics components and cards.
 *
 * <p>
 * It provides {@link BufferedImage} manipulation functionalities similar
 * to {@link com.hector.titulacionpredial.view.swing.shadow.GraphicsUtilities},
 * optimized for rendering shadows on cards.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class GraphicsUtilitiesChart {

    /**
     * Private builder to avoid instantiation.
     */
    private GraphicsUtilitiesChart() {

    }

    /**
     * It obtains the system's default graphical configuration.
     *
     * @return graphical configuration
     */
    private static GraphicsConfiguration getGraphicsConfiguration() {
        return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
    }

    /**
     * Create an image compatible with the color model of the source image.
     *
     * @param image reference image
     * @return new compatible image
     */
    public static BufferedImage createColorModelCompatibleImage(BufferedImage image) {
        ColorModel cm = image.getColorModel();
        return new BufferedImage(cm, cm.createCompatibleWritableRaster(image.getWidth(), image.getHeight()),
                cm.isAlphaPremultiplied(), null);
    }

    /**
     * Create a compatible image with the same dimensions.
     *
     * @param image reference image
     * @return new compatible image
     */
    public static BufferedImage createCompatibleImage(BufferedImage image) {
        return createCompatibleImage(image, image.getWidth(), image.getHeight());
    }

    /**
     * Create an image compatible with specific dimensions.
     *
     * @param image  reference image
     * @param width  width
     * @param height height
     * @return new compatible image
     */
    public static BufferedImage createCompatibleImage(BufferedImage image, int width, int height) {
        return getGraphicsConfiguration().createCompatibleImage(width, height, image.getTransparency());
    }

    /**
     * Create an opaque image compatible with the given dimensions.
     *
     * @param width  width
     * @param height height
     * @return new compatible image
     */
    public static BufferedImage createCompatibleImage(int width, int height) {
        return getGraphicsConfiguration().createCompatibleImage(width, height);
    }

    /**
     * Creates a compatible translucent image.
     *
     * @param width  width
     * @param height height
     * @return translucent image
     */
    public static BufferedImage createCompatibleTranslucentImage(int width, int height) {
        return getGraphicsConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
    }

    /**
     * It loads an image from a resource and converts it to a
     * compatible format.
     *
     * @param resource Resource URL
     * @return compatible image
     * @throws IOException if a read error occurs
     */
    public static BufferedImage loadCompatibleImage(URL resource) throws IOException {
        BufferedImage image = ImageIO.read(resource);
        return toCompatibleImage(image);
    }

    /**
     * Convert an image to a format compatible with the system.
     *
     * @param image image to convert
     * @return compatible image
     */
    public static BufferedImage toCompatibleImage(BufferedImage image) {
        if (image.getColorModel().equals(getGraphicsConfiguration().getColorModel())) {
            return image;
        }

        BufferedImage compatibleImage
                = getGraphicsConfiguration().createCompatibleImage(
                image.getWidth(), image.getHeight(),
                image.getTransparency());

        Graphics g = compatibleImage.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return compatibleImage;
    }

    /**
     * Create a quick thumbnail while maintaining the proportions.
     *
     * @param image   Image source
     * @param newSize maximum size
     * @return thumbnail image
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

        BufferedImage temp = createCompatibleImage(image, width, height);
        Graphics2D g2 = temp.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, 0, 0, temp.getWidth(), temp.getHeight(), null);
        g2.dispose();

        return temp;
    }

    /**
     * Create a quick thumbnail with specific dimensions.
     *
     * @param image     Image source
     * @param newWidth  new width
     * @param newHeight new height
     * @return thumbnail image
     */
    public static BufferedImage createThumbnailFast(BufferedImage image, int newWidth, int newHeight) {
        if (newWidth >= image.getWidth() || newHeight >= image.getHeight()) {
            throw new IllegalArgumentException("newWidth and newHeight cannot"
                    + " be greater than the image"
                    + " dimensions");
        } else if (newWidth <= 0 || newHeight <= 0) {
            throw new IllegalArgumentException("newWidth and newHeight must" + " be greater than 0");
        }

        BufferedImage temp = createCompatibleImage(image, newWidth, newHeight);
        Graphics2D g2 = temp.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(image, 0, 0, temp.getWidth(), temp.getHeight(), null);
        g2.dispose();

        return temp;
    }

    /**
     * Create a high-quality miniature while maintaining the proportions.
     *
     * @param image   Image source
     * @param newSize maximum size
     * @return thumbnail image
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

            BufferedImage temp = createCompatibleImage(image, width, height);
            Graphics2D g2 = temp.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(thumb, 0, 0, temp.getWidth(), temp.getHeight(), null);
            g2.dispose();

            thumb = temp;
        } while (newSize != (isWidthGreater ? width : height));

        return thumb;
    }

    /**
     * Create a high-quality miniature with specific dimensions.
     *
     * @param image     Image source
     * @param newWidth  new width
     * @param newHeight new height
     * @return thumbnail image
     */
    public static BufferedImage createThumbnail(BufferedImage image, int newWidth, int newHeight) {
        int width = image.getWidth();
        int height = image.getHeight();

        if (newWidth >= width || newHeight >= height) {
            throw new IllegalArgumentException("newWidth and newHeight cannot"
                    + " be greater than the image"
                    + " dimensions");
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

            BufferedImage temp = createCompatibleImage(image, width, height);
            Graphics2D g2 = temp.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(thumb, 0, 0, temp.getWidth(), temp.getHeight(), null);
            g2.dispose();

            thumb = temp;
        } while (width != newWidth || height != newHeight);

        return thumb;
    }

    /**
     * Gets the pixels of a region as an ARGB array.
     *
     * @param img    Image source
     * @param x      X coordinate
     * @param y      Y coordinate
     * @param w      width
     * @param h      height
     * @param pixels destination array ({@code null} for new)
     * @return pixel array
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
     * Sets the pixels in a region of the image.
     *
     * @param img    target image
     * @param x      X coordinate
     * @param y      Y coordinate
     * @param w      width
     * @param h      height
     * @param pixels ARGB pixel array
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
