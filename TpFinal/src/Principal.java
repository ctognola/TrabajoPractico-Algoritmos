import java.util.List;

public class Principal {
    public static void main(String[] args) {
        // Crear una instancia de LectorCSV
        LectorCSV lectorCSV = new LectorCSV();
        
        // Leer el archivo CSV
        lectorCSV.leerCSV();

        // Obtener la columna "Nombre"
        List<String> columnaNombre = lectorCSV.getColumna("nombre");
        System.out.println("Columna Nombre:");
        for (String valor : columnaNombre) {
            System.out.println(valor);
        }

        // Obtener la columna "Edad"
        List<String> columnaEdad = lectorCSV.getColumna("edad");
        System.out.println("Columna Edad:");
        for (String valor : columnaEdad) {
            System.out.println(valor);
        }
    }
}
