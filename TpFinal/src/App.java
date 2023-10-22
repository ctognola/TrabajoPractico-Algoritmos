public class App {
        public static void main(String[] args) {
        Object[][] m1 = {
            {0.9, "lala", 90, false},
            {44, 55, 66, 77}
        };
        String[] cols = {"A", "B", "C", "D"};
        String[] filas = {"x", "y"};
        Matriz<Object> miMatriz = new Matriz<>(m1, cols, filas);
        // Matriz<Integer> miMatriz = Matriz.crearDesdeMatriz(m1);
        miMatriz.setCelda(0, 0, 9);
        System.out.println(miMatriz);
        System.out.println(miMatriz.getCelda("y", "C"));

        System.out.println("El nro. de filas es: " + miMatriz.CantDeFilas());
        System.out.println("Las etiquetas de las filas son: " + miMatriz.EtiquetaDeFilas());
        System.out.println("El nro. de columnas es: " + miMatriz.CantDeColumnas());
        System.out.println("Las etiquetas de las columnas son: " + miMatriz.EtiquetaDeColumnas());
        System.out.println("Los tipos de datos de las columnas son: " + miMatriz.obtenerNombresTiposDeDatosColumnas());



    }
}
