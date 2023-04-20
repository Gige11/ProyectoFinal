package package2;

import package1.Cliente;
import package1.Vehiculo;
import package1.Vendedor;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner escaner = new Scanner(System.in);
        int opcion;

       do {

           System.out.println("  Concesionaria");
           System.out.println("-----------------");
           System.out.println("Opciones: ");
           System.out.println("0- Salir");
           System.out.println("1- Registrar cliente");
           System.out.println("2- Registrar vendedor");
           System.out.println("3- Registrar vehiculo");
           System.out.println("4- Mostrar clientes");
           System.out.println("5- Mostrar vendedores");
           System.out.println("6- Mostrar vehiculos");

           opcion = escaner.nextInt();

           switch (opcion){

               case 1:

                   Cliente cliente = new Cliente();
                   cliente.agregarCliente(escaner,cliente);
                   opcion = Continuar(escaner,opcion);
                   break;

               case 2:

                   Vendedor vendedor = new Vendedor();
                   vendedor.agregarVendedor(escaner,vendedor);
                   opcion = Continuar(escaner,opcion);
                   break;

               case 3:

                   Vehiculo vehiculo = new Vehiculo();
                   vehiculo.agregarVehiculo(escaner,vehiculo);
                   opcion = Continuar(escaner,opcion);
                   break;

               case 4:

                   Cliente cliente1 = new Cliente();
                   cliente1.listarClientes();
                   opcion = Continuar(escaner,opcion);
                   break;

               case 5:

                   Vendedor vendedor1 = new Vendedor();
                   vendedor1.listarVendedores();
                   opcion = Continuar(escaner,opcion);
                   break;

               case 6:

                   Vehiculo vehiculo1 = new Vehiculo();
                   vehiculo1.listarVehiculos();
                   opcion = Continuar(escaner,opcion);
                   break;
           }
       }while (opcion != 0);
    }

    public static int Continuar(Scanner escaner, int opcion){
        System.out.println("\n Desea realizar otra operacion? y/n");
        String seguir = escaner.next();
        if(seguir.equals("n")){
            opcion = 0;
        }
        return  opcion;
    }
}
