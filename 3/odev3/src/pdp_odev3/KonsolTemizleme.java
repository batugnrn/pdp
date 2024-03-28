package pdp_odev3;

import java.io.IOException;

public class KonsolTemizleme {

	
	public static void temizle() {
		try {
            String os = System.getProperty("os.name").toLowerCase();

            ProcessBuilder processBuilder;
            if (os.contains("win")) {
                // Windows işletim sistemi için
                processBuilder = new ProcessBuilder("cmd", "/c", "cls");
            } else {
                // Linux veya macOS için
                processBuilder = new ProcessBuilder("clear");
            }

            Process process = processBuilder.inheritIO().start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
			
	}
}
