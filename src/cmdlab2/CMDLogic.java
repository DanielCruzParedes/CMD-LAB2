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

    public File previousFile;
    public String info;

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
    public void eliminarArchivo(String direccion) {
        setFile(direccion);
        File[] contenido = currentFolder.listFiles();
        if (currentFolder.isDirectory()) {

            if (contenido != null) {
                for (File ar : contenido) {
                    eliminarArchivo(ar.getAbsolutePath());
                }
            }
        }

        while (!currentFolder.delete()) {
            System.out.println("No se pudo eliminar: " + currentFolder.getAbsolutePath());
            currentFolder = regresar();
            contenido = currentFolder.listFiles();
        }
    }

    //<...>
    File regresar() {

        previousFile = currentFolder.getParentFile();
        setFile(previousFile.getAbsolutePath());
        return previousFile;
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
            info = "Folder Actual: " + currentFolder.getName() + "\n";
            //Mostrar contenido
            for (File child : currentFolder.listFiles()) {
                // Si es Directory se indica
                if (child.isDirectory()) {
                    info = info + "<DIR>\t";
                }
                //Imprime el nombre del archivo o folder
                info = info + child.getName();
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
        StringBuilder contenido = new StringBuilder();
        setFile(direccion);
        if (exists()) {
            try {
                FileReader lector = new FileReader(currentFolder);

                int character;
                while ((character = lector.read()) != -1) {
                    
                    contenido.append((char) character);
                }
                lector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return contenido.toString();
    }
    
    }
