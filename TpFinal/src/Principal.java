import java.util.List;

public class Principal {
    public static void main(String[] args) {
        // Crear una instancia de LectorCSV
        LectorCSV lectorCSV = new LectorCSV();
        
        // Leer el archivo CSV
        lectorCSV.leerCSV();

        // Visualizar los datos
        lectorCSV.visualizarDatos();
/* 
        // Obtener cualquier columna por su nombre
        List<String> columnaPersonalizada = lectorCSV.getColumna("nombre_de_columna_personalizada");
        System.out.println("Columna Personalizada:");
        for (String valor : columnaPersonalizada) {
            System.out.println(valor);
        }
*/
    }
}
