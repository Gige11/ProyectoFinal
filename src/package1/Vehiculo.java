package package1;

import java.time.LocalDate;

public class Vehiculo {

    private static int id;
    private String marca;
    private String modelo;
    private String descripcion;
    private String anio;
    private double precio;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, String descripcion, String anio, double precio) {
        this.id = ++id;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.anio = anio;
        this.precio = precio;
    }

    public static int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
