package MS_Infrastructure.MS_Tools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MS_ExoMunicion {
    private static final String FILE = "MS_storage/MS_Datafiles/ExoMunision.txt";

    public static boolean hayMunicion(String tipoArma) {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.contains(tipoArma)) {
                    return true;
                }
            }
        } catch (IOException e) {
            MS_CMD.print("ERROR : Lectura ExoMunision");
        }

        return false;
    }
}
