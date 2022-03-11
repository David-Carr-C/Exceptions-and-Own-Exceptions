package exceptions.example.file;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class ExampleExceptionFile {
    public ExampleExceptionFile() {

    }

    public void readFile() throws FileNotFoundException, IOException {
        //String path = "."+getClass().getClassLoader().getResource("").getPath();
        //path = path+"exceptions/example/file/readme.txt";
        //System.out.println(path);                         //   <- Otra forma de obtener el path
        //File file = new File("/src/exceptions/example/file/readme.txt");    <- no se tiene que apuntar al directorio de src, sino al de out
        File file = new File("./readme.txt");    //Ni idea... estoy apuntando hacia la carpeta principal del proyecto
        System.out.println(file.getCanonicalPath());
        FileReader fileReader = new FileReader(file.getCanonicalPath());         //En linux es CanonicalPath
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
                                            //Read hasta EOF
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }
}

class Main {
    public static void main(String[] args) {
        ExampleExceptionFile exampleExceptionFile = new ExampleExceptionFile();
        try {
            exampleExceptionFile.readFile();
        } catch (FileNotFoundException e) {//Tiene que ser en el orden en el que aparezca throws
            e.printStackTrace();
            System.out.println(e);
            System.out.println("No se encontro el archivo!");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Ocurrio una exception al momento de extraer la informacion del archivo");
        }

        System.out.println("end");

    }
}
