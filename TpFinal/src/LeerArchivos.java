import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class LeerArchivos {
	public void leer() {
		StringBuilder sb = new StringBuilder();
		Path filePath = Paths.get("C:\\Users\\M\\Desktop\\TrabajoFinal\\leer.txt");
		try {
			BufferedReader br = Files.newBufferedReader(filePath);
			String linea;
			
			//Lee las lineas hasta que llegue a null
			while((linea = br.readLine()) != null) {
				sb.append(linea).append("\n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sb);
	}
}
