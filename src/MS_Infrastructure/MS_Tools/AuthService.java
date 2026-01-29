//  © 2K26 ❱──💀──❰ pat_mic ? code is life : life is code
package MS_Infrastructure.MS_Tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.IOException;

public class AuthService {

    private static final String USUARIO_VALIDO = "patmic";
    private static final String CLAVE_VALIDA = "123";
    private static final int MAX_INTENTOS = 3;
    private static final String LOG_FILE = "MS_Storage/MS_Logs/ExoTracer.txt";

    public static boolean autenticar() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int intento = 0;

        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║     MS_EXOBOT - AUTENTICACIÓN  ║");
        System.out.println("╚════════════════════════════════╝\n");

        while (intento < MAX_INTENTOS) {
            intento++;
            System.out.print("Ingrese cédula: ");
            String cedula = "";
            try {
                cedula = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.print("Ingrese clave: ");
            String clave = "";
            try {
                clave = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (validarCredenciales(cedula, clave)) {
                registrarLog("GOOD : Acceso concedido");
                System.out.println("\n✓ Acceso concedido. Bienvenido!\n");
                return true;
            } else {
                int intentosRestantes = MAX_INTENTOS - intento;
                System.out.println("✗ Credenciales inválidas. Intentos restantes: " + intentosRestantes + "\n");
                registrarLog("ERROR: Acceso denegado. Intento " + intento);
            }
        }

        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("║  Máximo de intentos excedido   ║");
        System.out.println("║  Aplicación cerrada            ║");
        System.out.println("╚════════════════════════════════╝\n");
        registrarLog("ERROR: Acceso denegado. Máximo de intentos excedido");
        return false;
    }

    private static boolean validarCredenciales(String cedula, String clave) {
        return USUARIO_VALIDO.equals(cedula) && CLAVE_VALIDA.equals(clave);
    }

    private static void registrarLog(String mensaje) {
        try (FileWriter fw = new FileWriter(LOG_FILE, true)) {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            fw.write("[" + timestamp + "] " + mensaje + "\n");
            fw.flush();
        } catch (IOException e) {
            System.err.println("ERROR al escribir en log: " + e.getMessage());
        }
    }
}
