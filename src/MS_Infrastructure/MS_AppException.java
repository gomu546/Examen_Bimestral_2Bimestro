//  © 2K26 ❱──💀──❰ pat_mic ? code is life : life is code
package MS_Infrastructure;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import MS_Infrastructure.MS_Tools.MS_CMDColor;

public class MS_AppException extends Exception {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public MS_AppException(String showMsg) {
        super((showMsg == null || showMsg.isBlank()) ? MS_AppConfig.MSG_DEFAULT_ERROR : showMsg);
        saveLogFile(null, null, null);
    }

    public MS_AppException(String showMsg, Exception e, Class<?> clase, String metodo) {
        super((showMsg == null || showMsg.isBlank()) ? MS_AppConfig.MSG_DEFAULT_ERROR : showMsg);
        saveLogFile(e.getMessage(), clase, metodo);
    }

    private void saveLogFile(String logMsg, Class<?> clase, String metodo) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String className = (clase == null) ? MS_AppConfig.MSG_DEFAULT_CLASS : clase.getSimpleName();
        String methodName = (metodo == null) ? MS_AppConfig.MSG_DEFAULT_METHOD : metodo;
        logMsg = (logMsg == null || logMsg.isBlank()) ? MS_AppConfig.MSG_DEFAULT_ERROR : logMsg;
        logMsg = String.format("╭─💀─ SHOW ❱❱ %s \n╰──── LOG  ❱❱ %s | %s.%s | %s", getMessage(), timestamp, className,
                methodName, logMsg);

        try (PrintWriter writer = new PrintWriter(new FileWriter(MS_AppConfig.getLOGFILE(), true))) {
            System.err.println(MS_CMDColor.BLUE + logMsg);
            writer.println(logMsg);
        } catch (Exception e) {
            System.err.println(MS_CMDColor.RED + "[AppException.saveLogFile] ❱ " + e.getMessage());
        } finally {
            System.out.println(MS_CMDColor.RESET);
        }
    }
}