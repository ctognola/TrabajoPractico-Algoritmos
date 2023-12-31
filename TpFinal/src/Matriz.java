import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Matriz<T> {
    List<List<T>> columnas;
    Map<String, Integer> colLabels;
    Map<String, Integer> rowLabels;

    public Matriz(int cantidadColumnas) {
        if (cantidadColumnas < 1)
            throw new IllegalArgumentException("La longitud de columnas debe ser mayor a 0.");
        
        columnas = new ArrayList<>();
        colLabels = new HashMap<>();
        rowLabels = new HashMap<>();
        for(int j=0; j < cantidadColumnas; j++) {
            columnas.add(j, new ArrayList<>());
            colLabels.put(String.valueOf(j), j);
        }
    }

    public Matriz(int cantidadColumnas, String[] etiquetas) {
        this(cantidadColumnas);
        if (cantidadColumnas != etiquetas.length)
            throw new IllegalArgumentException("La longitud de etiquetas no coincide.");
        setEtiquetasColumnas(etiquetas);
    }

    public Matriz(T[][] matriz) {
        this(matriz[0].length);
        inicializarDesdeMatriz(matriz);
    }

    public Matriz(T[][] matriz, String[] etiquetasColumnas) {
        this(matriz[0].length, etiquetasColumnas);
        inicializarDesdeMatriz(matriz);
    }

    public Matriz(T[][] matriz, String[] etiquetasColumnas, String[] etiquetasFilas) {
        this(matriz, etiquetasColumnas);
        if (columnas.get(0).size() != etiquetasFilas.length)
            throw new IllegalArgumentException("La longitud de etiquetas de filas no coincide.");
        setEtiquetasFilas(etiquetasFilas);
    }

    public void setEtiquetasFilas(String[] etiquetas) {
        rowLabels.clear();
        for(int i=0; i < columnas.get(0).size(); i++) {
            rowLabels.put(etiquetas[i], i);
        }
    }

    public void setEtiquetasColumnas(String[] etiquetas) {
        colLabels.clear();
        for(int j=0; j < columnas.size(); j++) {
            colLabels.put(etiquetas[j], j);
        }
    }

    private void inicializarDesdeMatriz(T[][] matriz) {
        for(int j=0; j < columnas.size(); j++) {
            for(int i=0; i < matriz.length; i++) {
                columnas.get(j).add(i, matriz[i][j]);
            }
        }
        for(int i=0; i < columnas.get(0).size(); i++) {
            rowLabels.put(String.valueOf(i), i);
        }
    }

    public static <T> Matriz<T> crearDesdeMatriz(T[][] matriz) {
        return new Matriz<>(matriz);
    }

    public T getCelda(String fila, String columna) {
        return columnas.get(colLabels.get(columna)).get(rowLabels.get(fila)); // columnas[columna][fila]
    }

    public void setCelda(int fila, int columna, T valor) {
        columnas.get(columna).set(fila, valor);
    }


    @Override
    public String toString() {
        String out = "  | ";
        String sep = " | ";
        for(String label : colLabels.keySet()) {
            out += label + sep;
        }
        out += "\n";
        for(String fila : rowLabels.keySet()) {
            out += fila + sep;
            for(String columna : colLabels.keySet()) {
                out += getCelda(fila, columna);
                out += sep;
            }
            out += "\n";
        }
        return out;
    }

    public Integer CantDeFilas() {
        
        return rowLabels.size();

    }

    public Integer CantDeColumnas() {
        
        return colLabels.size();

    }

    public String EtiquetaDeFilas() {

        String etiquetas_filas = "";

        for(String elemento: rowLabels.keySet()) {

            etiquetas_filas += (elemento + ", ");
        }

        if(etiquetas_filas.length() > 1)

            etiquetas_filas = etiquetas_filas.substring(0, etiquetas_filas.length() - 2);

        return etiquetas_filas;

    }
    public String EtiquetaDeColumnas() {

        String etiquetas_columnas= "";

        for(String elemento: colLabels.keySet()){

            etiquetas_columnas += (elemento + ", ");
        }

        if(etiquetas_columnas.length() >1)
        
            etiquetas_columnas = etiquetas_columnas.substring(0, etiquetas_columnas.length() - 2);

        return etiquetas_columnas;    

    }

    public List<Class<?>> obtenerTiposDeDatosColumnas() {
        List<Class<?>> tiposDeDatosColumnas = new ArrayList<>();
        for (List<T> columna : columnas) {
            if (!columna.isEmpty()) {
                Class<?> tipo = columna.get(0).getClass();
                tiposDeDatosColumnas.add(tipo);
            }
        }
        return tiposDeDatosColumnas;
    }

    public List<String> obtenerNombresTiposDeDatosColumnas() {
        List<Class<?>> tiposDeDatosColumnas = obtenerTiposDeDatosColumnas();
        List<String> nombresTiposDeDatosColumnas = new ArrayList<>();
        for (Class<?> tipo : tiposDeDatosColumnas) {
            nombresTiposDeDatosColumnas.add(tipo.getSimpleName());
        }
        return nombresTiposDeDatosColumnas;
    }


}

