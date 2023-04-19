package package2;

import ConecBD.BDconexion;
import package1.Cliente;
import package1.Vehiculo;
import package1.Vendedor;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        System.out.println("  Concesionaria");
        System.out.println("-----------------");
        System.out.println("Opciones: ");
        System.out.println("0- Salir");
        System.out.println("1- Registrar cliente");
        System.out.println("2- Registrar vendedor");
        System.out.println("3- Registrar vehiculo");

        Scanner escaner = new Scanner(System.in);
        int opcion = escaner.nextInt();

        switch (opcion){

            case 1:
                Cliente cliente = new Cliente();

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

                String sqlCliente = "INSERT INTO `concesionaria`.`clientes` (`nombre`,`apellido`,`fecha_nacimiento`,`dni`,`telefono`,`email`) VALUES ("+"'"+cliente.getNombre()+"'"+","+"'"+cliente.getApellido()+"'"+","+"'"+cliente.getFechaNacimiento()+"'"+","+"'"+cliente.getDni()+"'"+","+"'"+cliente.getTelefono()+"'"+","+"'"+cliente.getEmail()+"'"+")";
                Statement stmtCliente = BDconexion.getConexion().createStatement();
                stmtCliente.executeUpdate (sqlCliente);
                BDconexion.CloseConnection();
                System.out.println("Se guardo el cliente correctamente");

                break;

            case 2:

                Vendedor vendedor = new Vendedor();

                System.out.println("Ingrese el nombre: ");
                vendedor.setNombre(escaner.next());

                System.out.println("Ingrese el apellido: ");
                vendedor.setApellido(escaner.next());

                System.out.println("Ingrese la fecha de nacimiento (dd/mm/yyyy): ");
                vendedor.setFechaNacimiento(escaner.next());

                System.out.println("Ingrese el Dni");
                vendedor.setDni(escaner.next());

                String sqlVendedor = "INSERT INTO `concesionaria`.`vendedores` (`nombre`,`apellido`,`fecha_nacimiento`,`dni`) VALUES ("+"'"+vendedor.getNombre()+"'"+","+"'"+vendedor.getApellido()+"'"+","+"'"+vendedor.getFechaNacimiento()+"'"+","+"'"+vendedor.getDni()+"'"+")";
                Statement stmtVendedor = BDconexion.getConexion().createStatement();
                stmtVendedor.executeUpdate (sqlVendedor);
                BDconexion.CloseConnection();
                System.out.println("Se guardo el vendedor correctamente");

                break;  

            case 3:

                Vehiculo vehiculo = new Vehiculo();

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
                        escaner.next(); // consume la entrada no válida
                    }
                }

                String sqlVehiculo = "INSERT INTO `concesionaria`.`vehiculos` (`marca`,`modelo`,`descripcion`,`anio`,`precio`) VALUES ("+"'"+vehiculo.getMarca()+"'"+","+"'"+vehiculo.getModelo()+"'"+","+"'"+vehiculo.getDescripcion()+"'"+","+"'"+vehiculo.getAnio()+"'"+","+"'"+vehiculo.getPrecio()+"'"+")";

                Statement stmtVehiculo = BDconexion.getConexion().createStatement();
                stmtVehiculo.executeUpdate (sqlVehiculo);
                BDconexion.CloseConnection();
                System.out.println("Se guardo el vehiculo correctamente");

                break;
        }
    }
}
