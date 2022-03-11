package ownexceptionProject;

public class Bomba {
    private int litrosEnDeposito;
    private float precioLitro;
    private int cantidadServidaLitros;
    private float totalPesos;

    public Bomba() {
        this(1000);
    }
    public Bomba(int capacidadInicialLitros) {
        litrosEnDeposito = capacidadInicialLitros;
        precioLitro = 24.10F;
    }

    public void mostrar() {
        String show = "";
        show = show+"Cantidad de litros servida: "+cantidadServidaLitros+"\n" +
                "Cantidad de litros disponibles en el deposito: "+litrosEnDeposito +"\n"+
                "Costo total: $"+totalPesos;

        System.out.println(show);

        totalPesos = 0;
    }

    public void despachar(int litrosSolicitados) throws BombaException{
        if (litrosSolicitados<=litrosEnDeposito && litrosSolicitados>0) {
            //Litros dados == actualizacion de litros en deposito
            litrosEnDeposito = litrosEnDeposito - litrosSolicitados;

            //Litros solicitados y por lo tanto servidos
            cantidadServidaLitros = litrosSolicitados;

            //Precio
            totalPesos = litrosSolicitados*precioLitro;

            //Cuando se termina de bombear, se muestran los datos
            mostrar();

        } else if (litrosSolicitados<=0) {
            throw new BombaException("Los litros solicitados son negativos o es 0");
        } else {
            throw new BombaException("Los litros solicitados son mayores de los que hay en el deposito");
        }
    }

    public void despachar(float cantidadPesos) throws BombaException{
        //Despeje de la formula de litrosSolicitados * precioporlitro = precio
        int conversionLitrosSolicitados = Math.round(cantidadPesos/precioLitro);

        if (conversionLitrosSolicitados<=litrosEnDeposito && conversionLitrosSolicitados>0) {
            //Precio
            totalPesos = cantidadPesos;

            //Litros pedidos - litros en reserva = actualizacion de litros en deposito
            litrosEnDeposito = litrosEnDeposito-conversionLitrosSolicitados;

            //Litros servidos
            cantidadServidaLitros = conversionLitrosSolicitados;

            //Cuando se termina de bombear, se muestran los datos
            mostrar();
        } else if (conversionLitrosSolicitados<=0) {
            throw new BombaException("Los litros solicitados son negativos o es 0");
        } else {
            throw new BombaException("Los litros solicitados son mayores de los que hay en reserva");
        }
    }

}
