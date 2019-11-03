package provatrabalho;

import java.util.Formatter;

public class LogWriter {

    public static boolean writeFileTXT(String text) throws Exception {
        Formatter output;

        try {
            output = new Formatter("src/logs/exceptions.txt");
            output.format(text);
            if (output != null) {
                output.close();
            }
            return true;
        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }
}
