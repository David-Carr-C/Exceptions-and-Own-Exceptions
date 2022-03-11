package ownexceptions;

public class Blueprint extends Exception {
    //public static final long serialVersionUID = 700L; ??

    public Blueprint(String message) {
        super(message);
    }
}

class Main {
    public static void main(String[] args) throws Blueprint {
        throw new Blueprint("Hello");

        /**
         * Ya no se puede poner mas codigo abajo de throw
         *
         *
         * Una de las cosas que podemos hacer para evitar esto, es el uso de If y else para
         * esquivar que el programa pare por completo, o no poner throws en el menu principal, sino que en los
         * metodos que se invoquen desde aqui, para posteriormente usar try/catch y hace no hacer  que el programa pare
         * */
    }
}
