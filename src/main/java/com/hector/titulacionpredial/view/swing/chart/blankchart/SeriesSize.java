package com.hector.titulacionpredial.view.swing.chart.blankchart;

/**
 * Modelo de datos que almacena el tamaño de una serie
 * del gráfico.
 *
 * <p>
 * Contiene la posición (startX, startY) y las dimensiones
 * (width, height) del área de cada serie para el renderizado.
 * </p>
 *
 * @author Ing. Hector Acevedo
 * @since 1.0
 */
public class SeriesSize {
    
    private double x;
    private double y;
    private double width;
    private double height;

    public SeriesSize(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public SeriesSize(){

    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }
    
}
