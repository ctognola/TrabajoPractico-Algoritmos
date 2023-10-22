import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LectorCSV {
    private Map<String, List<String>> columnas;
    private List<String> etiquetasColumnas;

    public LectorCSV() {
        columnas = new HashMap<>();
        etiquetasColumnas = new ArrayList<>();
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
                    etiquetasColumnas = Arrays.asList("nombres", "apellidos", "edades");
                    for (String etiqueta : etiquetasColumnas) {
                        columnas.put(etiqueta, new ArrayList<>());
                    }
                    primeraLinea = false;
                } else {
                    for (int i = 0; i < datosDeLinea.length; i++) {
                        columnas.get(etiquetasColumnas.get(i)).add(datosDeLinea[i]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void ordenarPorColumna(String nombreColumna) {
        if (columnas.containsKey(nombreColumna)) {
            List<String> columna = columnas.get(nombreColumna);
            columna.sort(Comparator.naturalOrder()); // Ordenar en orden ascendente
        }
    }
    public void visualizarDatos() {
    	// Ordenar los datos por la columna "nombres" en orden ascendente
    	ordenarPorColumna("nombres");

    	    // Imprimir las etiquetas de columna con separadores
    	    for (String etiquetaColumna : etiquetasColumnas) {
    	        System.out.print(etiquetaColumna + "\t|");
    	    }
    	    System.out.println();

    	    int numRows = etiquetasColumnas.isEmpty() ? 0 : columnas.get(etiquetasColumnas.get(0)).size();
    	    for (int i = 0; i < numRows; i++) {
    	        System.out.print(columnas.get("nombres").get(i) + " \t|");
    	        // Ajustar el tamaño de la columna "apellidos"
    	        int anchoColumnaApellidos = columnas.get("apellidos").get(i).length();
    	        String apellidosAlineados = String.format("%1$-" + anchoColumnaApellidos + "s", columnas.get("apellidos").get(i));
    	        System.out.print(apellidosAlineados + "\t|");

    	        // Ajustar el tamaño de la columna "edades"
    	        int anchoColumnaEdades = String.valueOf(columnas.get("edades").get(i)).length();
    	        String edadesAlineados = String.format("%1$-" + anchoColumnaEdades + "s", columnas.get("edades").get(i));
    	        System.out.print(edadesAlineados + "\t|");
    	        System.out.println();
    	    }
    	}

    public List<String> getColumna(String nombreColumna) {
        if (columnas.containsKey(nombreColumna)) {
            return columnas.get(nombreColumna);
        }
        return new ArrayList<>(); // Devolver una lista vacía si no se encuentra la columna
    }
}
