package cmdlab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CMDLogic {

    public File currentFolder = null;

    public File previousFile = currentFolder.getParentFile();

    //Mfile
    boolean crearFile() throws IOException {
        return currentFolder.createNewFile();
    }

    //Cd
    void setFile(String direccion) {
        currentFolder = new File(direccion);
    }

    //Mkdir
    boolean crearFolder() {
        return currentFolder.mkdirs();
    }

    //Rm
    boolean eliminarArchivo() {
        return currentFolder.delete();
    }

    //<...>
    File regresar() {
        File previousFile = currentFolder.getParentFile();
        return currentFolder = previousFile;
    }

    Date date = new Date();
    LocalTime tiempo = LocalTime.now();

    public String toStringFecha() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(date);
    }

    public String toStringTiempo() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        return tiempo.format(formato);
    }

    public void Dir() {
        if (currentFolder.isDirectory()) {
            //imprime el nombre del folder actual
            System.out.println("Folder Actual: " + currentFolder.getName());

            //Mostrar contenido
            for (File child : currentFolder.listFiles()) {
                // Si es Directory se indica
                if (child.isDirectory()) {
                    System.out.print("<DIR>\t");
                }
                //Imprime el nombre del archivo o folder
                System.out.println(child.getName());
            }

        }
    }

    public boolean exists() throws FileNotFoundException {
        return currentFolder.exists() && currentFolder.isFile() && currentFolder.canRead() && currentFolder.canWrite();
    }

    public void write(String contenido) throws FileNotFoundException {
        if (exists()) {
            try {
                FileWriter escritor = new FileWriter(currentFolder);
                escritor.write(contenido);
                escritor.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String read() throws FileNotFoundException {
        if (exists()) {
            try {
                FileReader lector = new FileReader(currentFolder);
                StringBuilder contenido = null;

                int character;
                while ((character = lector.read()) != -1) {
                    contenido.append((char) character);
                }
                lector.close();
                return contenido.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public String readFile(String direccion) throws FileNotFoundException {
        setFile(direccion);
        if (exists()) {
            try {
                FileReader lector = new FileReader(currentFolder);
                StringBuilder contenido = null;

                int character;
                while ((character = lector.read()) != -1) {
                    contenido.append((char) character);
                }
                lector.close();
                return contenido.toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

}
