package exceptions.examples;

public class ExampleOwnException extends Exception{
    public ExampleOwnException (String message) {
        super(message);
    }
}

class Main {
    public static void main(String[] args) throws ExampleOwnException {
        try {
            int a = Integer.parseInt("hola");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //throw new ExampleOwnException("Ha introducido erronameante la String como input"); //throw detiene la ejecucion, hay que tener cuidado
        }

        //Nuevo codigo añadido
        example();
    }

    //Nuevo codigo añadido
    private static void example() {
        Person person = new Person("Daniela");
        try {
            person.setAge(10);
        } catch (ExampleOwnException e) {
            e.printStackTrace();//Esta exception es capaz de cachar multiples exceptions de su mismo tipo puesto en el metodo al que se intenta acceder
        }
        System.out.println(person.getAge());
    }
}

//Nuevo codigo añadido
class Person {
    private String name;
    private int age;

    public Person (String name) {
        this.name = name;
    }

    public void setAge(int age) throws ExampleOwnException{
        if (age<18) {
            throw new ExampleOwnException("Edad no permitida!");
        } else if (age==18) {
            throw new ExampleOwnException("Necesitas tener veinte años");
        }
        this.age = age; //No se llega hasta este statement porque throw detiene el metodo
    }
//Cuando throw detiene el metodo, puede stoppear el programa en seco si le pone en el main
    public int getAge() {
        return age;
    }
}