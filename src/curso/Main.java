package curso;

import curso.servicios.AlumnoServicio;
import curso.servicios.ProfesorServicio;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in).useDelimiter("\n");

        AlumnoServicio alumnoServicio = new AlumnoServicio();

        System.out.println("Que quiere hacer ?");
        System.out.println("1- Crear Alumno");
        System.out.println("2- Editar Alumno");
        System.out.println("3- Eliminar Alumno");

        int opcion = scan.nextInt();

        switch (opcion) {
            case 1:

                System.out.println("Ingrese el documento del alumno");

                Integer documento = scan.nextInt();

                System.out.println("Ingrese el nombre");

                String nombre = scan.next();

                System.out.println("Ingrese el apellido");

                String apellido = scan.next();

                System.out.println("Ingrese la edad");

                Integer edad = scan.nextInt();

                alumnoServicio.crearAlumno(documento, nombre, apellido, edad);

                break;

            case 2:

                System.out.println("Ingrese el documento del alumno");

                Integer documento2 = scan.nextInt();

                System.out.println("Ingrese el nombre");

                String nombre2 = scan.next();
                
                alumnoServicio.editarAlumno(documento2, nombre2);

                break;    
            default:
                throw new AssertionError();
        }

    }

}
