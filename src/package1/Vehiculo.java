package package1;

import ConecBD.BDconexion;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Vehiculo {

    private static int id;
    private String marca;
    private String modelo;
    private String descripcion;
    private String anio;
    private double precio;
    private boolean disponible;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, String descripcion, String anio, double precio, boolean disponible) {
        this.id = ++id;
        this.marca = marca;
        this.modelo = modelo;
        this.descripcion = descripcion;
        this.anio = anio;
        this.precio = precio;
        this.disponible = disponible;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Vehiculo.id = id;
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

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void agregarVehiculo(Scanner escaner, Vehiculo vehiculo) throws SQLException {

        System.out.println("Ingrese la marca: ");
        vehiculo.setMarca(escaner.next());

        System.out.println("Ingrese el modelo: ");
        vehiculo.setModelo(escaner.next());

        System.out.println("Ingrese el año: ");
        vehiculo.setAnio(escaner.next());

        System.out.println("Ingrese una breve descripcion: ");
        vehiculo.setDescripcion(escaner.next());

        while(true) {
            System.out.println("Ingrese el precio: ");
            if(escaner.hasNextDouble()) {
                vehiculo.setPrecio(escaner.nextDouble());
                break;
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
                escaner.next();
            }
        }

        String sql = "INSERT INTO `concesionaria`.`vehiculos` (`marca`,`modelo`,`descripcion`,`anio`,`precio`) VALUES ("+"'"+vehiculo.getMarca()+"'"+","+"'"+vehiculo.getModelo()+"'"+","+"'"+vehiculo.getDescripcion()+"'"+","+"'"+vehiculo.getAnio()+"'"+","+"'"+vehiculo.getPrecio()+"'"+")";

        Statement stmt = BDconexion.getConexion().createStatement();
        stmt.executeUpdate (sql);
        BDconexion.CloseConnection();
        System.out.println("Se guardo el vehiculo correctamente");
        vehiculo.setDisponible(true);

    }

    public void listarVehiculos() throws SQLException {

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        String sql = "SELECT * FROM vehiculos";

        Statement stmt = BDconexion.getConexion().createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        while (resultSet.next()) {
            String marca = resultSet.getString("marca");
            String modelo = resultSet.getString("modelo");
            String descripcion = resultSet.getString("descripcion");
            String anio = resultSet.getString("anio");
            double precio = resultSet.getDouble("precio");
            boolean disponible = resultSet.getBoolean("disponible");

            Vehiculo vehiculo1 = new Vehiculo(marca, modelo, descripcion, anio, precio, disponible);

            vehiculo1.setId(resultSet.getInt("id"));
            vehiculos.add(vehiculo1);
        }

        for (Vehiculo vehiculo1 : vehiculos) {
            System.out.println(vehiculo1);
        }
        BDconexion.CloseConnection();
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "id= '" + id + '\'' +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", anio='" + anio + '\'' +
                ", precio=" + precio +
                ", disponible=" + disponible +
                '}';
    }
}
