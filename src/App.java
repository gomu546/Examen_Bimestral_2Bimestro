import MS_App.MS_DesktopApp.Forms.MS_ExoTrooper;
import MS_DataAccess.MS_Helpers.DatabaseInitializer;
import MS_Infrastructure.MS_Tools.AuthService;
import MS_Infrastructure.MS_AppException;

public class App {
    public static void main(String[] args) {
        try {
            // Autenticar usuario
            if (!AuthService.autenticar()) {
                System.exit(1);
            }

            // Inicializar base de datos
            DatabaseInitializer.initializeDatabase();

            java.awt.EventQueue.invokeLater(() -> {
                new MS_ExoTrooper().setVisible(true);
            });
        } catch (MS_AppException e) {
            System.err.println("ERROR: No se pudo inicializar la base de datos");
            e.printStackTrace();
        }
    }
}