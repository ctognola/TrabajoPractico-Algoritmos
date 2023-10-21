import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LectorCSV {
    private List<String> columnas;
    private List<List<String>> datos;

    public LectorCSV() {
        columnas = new ArrayList<>();
        datos = new ArrayList<>();
    }

    public void leerCSV() {
        Path filePath = Paths.get("C:\\Users\\M\\Desktop\\TrabajoFinal\\leer.csv");
        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = br.readLine()) != null) {
                String[] datosDeLinea = linea.split(",");

                if (primeraLinea) {
                    // Si es la primera línea, se asume que son las etiquetas de columna
                    for (String dato : datosDeLinea) {
                        columnas.add(dato);
                        datos.add(new ArrayList<>());
                    }
                    primeraLinea = false;
                } else {
                    for (int i = 0; i < datosDeLinea.length; i++) {
                        datos.get(i).add(datosDeLinea[i]);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getColumna(String nombreColumna) {
        List<String> columna = new ArrayList<>();
        int indice = columnas.indexOf(nombreColumna);
        if (indice != -1) {
            columna = datos.get(indice);
        }
        return columna;
    }
}