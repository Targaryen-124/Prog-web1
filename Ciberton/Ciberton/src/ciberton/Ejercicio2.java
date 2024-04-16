package ciberton;


/**
 *
 * @author Hector Bustillo
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */

        public static void main(String[] args) {
            String inputFile = "C:/Users/Hector Bustillo/Desktop/cyber.txt";

            try {
                encriptarYMostrar(inputFile);
            } catch (IOException e) {
                System.err.println("Error al procesar el archivo: " + e.getMessage());
            }
        }

        private static void encriptarYMostrar(String inputFile) throws IOException {
            Map<Character, String> mapaEncriptacion = new HashMap<>();
            mapaEncriptacion.put('y', "&");
            mapaEncriptacion.put('r', "(");
            mapaEncriptacion.put('a', "}");
            mapaEncriptacion.put('e', "{");
            mapaEncriptacion.put('i', ")");
            mapaEncriptacion.put('o', "%");
            mapaEncriptacion.put('u', "!");
            mapaEncriptacion.put('p', "*");
            mapaEncriptacion.put('l', "#");
            mapaEncriptacion.put('s', "b");
            mapaEncriptacion.put('n', "/");
            mapaEncriptacion.put(' ', "[");
            mapaEncriptacion.put('b', "-.");

            try ( BufferedReader br = new BufferedReader(new FileReader(inputFile))) {

                int caracter;
                while ((caracter = br.read()) != -1) {
                    char charActual = (char) caracter;
                    String encriptado = mapaEncriptacion.getOrDefault(Character.toLowerCase(charActual), String.valueOf(charActual));
                    System.out.print(encriptado.charAt(0));
                }

            }
        }
}