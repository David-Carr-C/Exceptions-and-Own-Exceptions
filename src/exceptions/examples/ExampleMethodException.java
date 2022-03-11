package exceptions.examples;

public class ExampleMethodException {

    private static int getAge(String age) throws NumberFormatException{
        int edad = Integer.parseInt(age);

        return edad;
    }


    public static void main(String[] args) {
        try {
            System.out.println(getAge("21"));
            System.out.println(getAge("hola"));
            System.out.println(getAge("100"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e);
        }
        System.out.println("Bye bye!");
    }
}
