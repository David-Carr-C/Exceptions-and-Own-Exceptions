package exceptions.examples;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExampleException {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            int age = scanner.nextInt();
        }catch (InputMismatchException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e);
        }

        System.out.println("El programa continua...");
        System.out.println("El manejo de errores permite manipular la exception y no detener el programa por esto");


    }
}
