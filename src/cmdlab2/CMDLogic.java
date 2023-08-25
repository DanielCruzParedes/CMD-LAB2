package cmdlab2;

import java.io.File;
import java.io.IOException;

public class CMDLogic {
    
    private File mifile = null;

    void setFile(String direccion) {
        mifile = new File(direccion);
    }
    
    boolean crearFile() throws IOException {
        return mifile.createNewFile();
    }

    boolean crearFolder() {
        return mifile.mkdirs();
    }
    
    
    
    
    
    
    
}
