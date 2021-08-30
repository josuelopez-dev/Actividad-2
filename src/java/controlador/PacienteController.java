package controlador;

import conexion.Conexion;
import dao.PacienteDao;
import java.sql.Date;
import java.util.Scanner;
import modelo.Paciente;

public class PacienteController {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Paciente pac = new Paciente(0);
        Conexion conn = new Conexion();
        PacienteDao pacd = new PacienteDao(conn);
        String opc;
        System.out.println("====================================");
        System.out.println("BIENVENIDO A VETERINARIA DON GATO");
        System.out.println("====================================");       

        do {
            System.out.println("\n¿ Qué acciones desea realizar ?");
            System.out.println("g => Guardar \nl => listar registros \nb => buscar \nx => salir");
            opc = scan.next();

            switch (opc) {
                case "g":
                    System.out.println("Ingrese el nombre de la mascota: ");
                    pac.setAliasMascota(scan.next());
                    System.out.println("Ingrese la especie: ");
                    pac.setEspecie(scan.next());
                    System.out.println("Ingrese la raza: ");
                    pac.setRaza(scan.next());
                    System.out.println("Ingrese el color pelo: ");
                    pac.setColorPelo(scan.next());
                    System.out.println("Ingrese la fecha de nacimiento (yyyy-MM-dd): ");
                    pac.setFechaNacimiento(Date.valueOf(scan.next()));

                    boolean respuesta = pacd.insertar(pac);

                    if (respuesta) {
                        System.out.println("Registro con éxito");
                    } else {
                        System.out.println("Falló el registro");
                    }
                    break;

                case "l":
                    for (Paciente pac1 : pacd.selectAll()) {
                        System.out.println("\n IdMascota => " + pac1.getIdMascota()
                                + " \n AliasMascota => " + pac1.getAliasMascota()
                                + " \n Especie => " + pac1.getEspecie()
                                + " \n Raza => " + pac1.getRaza()
                                + " \n ColorPelo => " + pac1.getColorPelo()
                                + " \n FechaNacimiento => " + pac1.getFechaNacimiento());

                    }
                    break;

                case "b":

                    System.out.println("Ingrese id de registro a consultar: ");
                    for (Paciente pac1 : pacd.selectById(scan.nextInt())) {
                        System.out.println("\n IdMascota => " + pac1.getIdMascota()
                                + " \n AliasMascota => " + pac1.getAliasMascota()
                                + " \n Especie => " + pac1.getEspecie()
                                + " \n Raza => " + pac1.getRaza()
                                + " \n ColorPelo => " + pac1.getColorPelo()
                                + " \n FechaNacimiento => " + pac1.getFechaNacimiento());
                    }

                    break;

                default:
                    break;
            }
        } while (!opc.equalsIgnoreCase("x"));

    }
}
