package exceptions.examples;

import java.util.Scanner;

public class ExampleFinallyVsThrow {
    public int getSomething() throws Exception {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        throw new Exception();

        //return number; <- Esto ya no es alcanzable, pero se tiene que regresar un dato?????
    }

    public static void main(String[] args) throws Exception {
        ExampleFinallyVsThrow example = new ExampleFinallyVsThrow();
        try {
            example.getSomething();
        } catch (Exception e) {
            e.printStackTrace();

            //Detenemos el programa, perooooo
            throw new Exception();
        } finally {
            System.out.println("Este codigo es alcanzable");
            //En el statement finally podemos seguir haciendo codigo aunque en catch se haya detenido la ejecucion
            //y aunque vaya a deternse la ejecucion del metodo por usar throw
        }

        System.out.println("Esto ya no es alcanzable, throw detiene la ejecucion");


    }
}
