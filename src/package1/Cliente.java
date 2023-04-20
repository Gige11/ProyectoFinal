package package1;

import ConecBD.BDconexion;
import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    private static int id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String dni;
    private String telefono;
    private String email;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String fechaNacimiento, String dni, String telefono, String email) {
        this.id = ++id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }



    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Cliente.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void agregarCliente(Scanner escaner, Cliente cliente) throws SQLException {


        System.out.println("Ingrese el nombre: ");
        cliente.setNombre(escaner.next());

        System.out.println("Ingrese el apellido: ");
        cliente.setApellido(escaner.next());

        System.out.println("Ingrese la fecha de nacimiento (dd/mm/yyyy): ");
        cliente.setFechaNacimiento(escaner.next());

        System.out.println("Ingrese el Dni");
        cliente.setDni(escaner.next());

        System.out.println("Ingrese el telefono: ");
        cliente.setTelefono(escaner.next());

        System.out.println("Ingrese el email: ");
        cliente.setEmail(escaner.next());

        String sql = "INSERT INTO `concesionaria`.`clientes` (`nombre`,`apellido`,`fecha_nacimiento`,`dni`,`telefono`,`email`) VALUES ("+"'"+cliente.getNombre()+"'"+","+"'"+cliente.getApellido()+"'"+","+"'"+cliente.getFechaNacimiento()+"'"+","+"'"+cliente.getDni()+"'"+","+"'"+cliente.getTelefono()+"'"+","+"'"+cliente.getEmail()+"'"+")";
        Statement stmt = BDconexion.getConexion().createStatement();
        stmt.executeUpdate (sql);
        BDconexion.CloseConnection();
        System.out.println("Se guardo el cliente correctamente");

    }

    public void listarClientes() throws SQLException {
        ArrayList<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes";

        Statement stmt = BDconexion.getConexion().createStatement();
        ResultSet resultSet = stmt.executeQuery(sql);

        while (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            String fechaNacimiento = resultSet.getString("fecha_nacimiento");
            String dni = resultSet.getString("dni");
            String Telefono = resultSet.getString("telefono");
            String email = resultSet.getString("email");
            Cliente cliente1 = new Cliente( nombre, apellido, fechaNacimiento,dni, Telefono,email);

            cliente1.setId(resultSet.getInt("id"));
            clientes.add(cliente1);
        }

        for (Cliente cliente1 : clientes) {
            System.out.println(cliente1);
        }
        BDconexion.CloseConnection();
    }

    @Override

    public String toString() {
        return
                "id= '" + id + '\'' +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", dni='" + dni + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'';
    }
}
