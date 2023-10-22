import java.util.List;

public class Principal {
    public static void main(String[] args) {
        // Crear una instancia de LectorCSV
    	 LectorCSV lectorCSV = new LectorCSV();
    	 lectorCSV.ordenarPorColumna("nombre");
         // Leer el archivo CSV
         lectorCSV.leerCSV();
         
         // Visualizar los datos
         lectorCSV.visualizarDatos();
         
        // Obtener la columna "Nombre"
        List<String> columnaNombre = lectorCSV.getColumna("nombres");
        System.out.println("Columna Nombre:");
        for (String valor : columnaNombre) {
            System.out.println(valor);
        }

        
     // Obtener la columna "Edad"
        List<String> columnaApellidos = lectorCSV.getColumna("apellidos");
        System.out.println("Columna Apellidos:");
        for (String valor : columnaApellidos) {
            System.out.println(valor);
        }
  
        
        
        
        // Obtener la columna "Edad"
        List<String> columnaEdad = lectorCSV.getColumna("edades");
        System.out.println("Columna Edad:");
        for (String valor : columnaEdad) {
            System.out.println(valor);
        }
  

    }
}
