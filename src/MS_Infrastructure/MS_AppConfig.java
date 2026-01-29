//  © 2K26 ❱──💀──❰ pat_mic ? code is life : life is code
package MS_Infrastructure;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import MS_Infrastructure.MS_Tools.MS_CMD;

public abstract class MS_AppConfig {

    private static final Properties props = new Properties();

    private static final String APP_PROPERTIES = "app.properties";
    private static final String KEY_DB_NAME = "db.File";
    private static final String KEY_FILE_LOG = "df.logFile";
    private static final String KEY_RES_IMG_MAIN = "res.img.Main";
    private static final String KEY_RES_IMG_LOGO = "res.img.Logo";
    private static final String KEY_RES_IMG_SPLASH = "res.img.Splash";

    // Configuración dinámica (filesystem)
    public static String getDATABASE() {
        return getProperty(KEY_DB_NAME);
    }

    public static String getLOGFILE() {
        return getProperty(KEY_FILE_LOG);
    }

    // Recursos empaquetados (classpath)
    public static URL getImgMain() {
        return getAppResource(KEY_RES_IMG_MAIN);
    }

    public static URL getImgLogo() {
        return getAppResource(KEY_RES_IMG_LOGO);
    }

    public static URL getImgSplash() {
        return getAppResource(KEY_RES_IMG_SPLASH);
    }

    // Mensajes
    public static final String MSG_DEFAULT_ERROR = "Ups! Error inesperado. Por favor, contacte al administrador del sistema.";
    public static final String MSG_DEFAULT_CLASS = "undefined";
    public static final String MSG_DEFAULT_METHOD = "undefined";

    // 🔥 CARGA CORRECTA DEL PROPERTIES (AQUÍ ESTABA EL BUG)
    static {
        try (InputStream in = MS_AppConfig.class
                .getClassLoader()
                .getResourceAsStream(APP_PROPERTIES)) {

            if (in == null) {
                throw new RuntimeException("app.properties no encontrado en el classpath");
            }

            props.load(in);
            MS_CMD.print("AppConfig ❱❱ app.properties cargado correctamente");

        } catch (Exception e) {
            MS_CMD.print("ERROR al cargar ❱❱ " + e.getMessage());
        }
    }

    private MS_AppConfig() {
    }

    static String getProperty(String key) {
        String value = props.getProperty(key);

        MS_CMD.print("AppConfig ❱❱ " + APP_PROPERTIES + "." + key + " : " + value);

        if (value == null) {
            MS_CMD.print("ERROR ❱❱ Propiedad no encontrada: " + key);
        }

        return value;
    }

    static URL getAppResource(String key) {
        String path = getProperty(key);
        if (path == null)
            return null;

        // 🔑 Regla clara: recursos SIEMPRE con /
        if (!path.startsWith("/")) {
            path = "/" + path;
        }

        URL res = MS_AppConfig.class.getResource(path);

        if (res == null) {
            MS_CMD.print("ERROR ❱❱ Recurso no encontrado en classpath: " + path);
        }

        return res;
    }
}
