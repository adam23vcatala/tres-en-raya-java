package tresenraya;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Juego {

    private EntradaSalidaDatos esd = new EntradaSalidaDatos();
    static char[][] tablero = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    public void jugar(String nombre) {
        boolean jugadorTurno = true;
        imprimirTablero();
        if (jugadorTurno) {
            esd.mostrarCadena("¡" + nombre + ", es tu turno! Inserta una fila y una columna: ");
            int row = esd.introducirValorEnteroPositivo();
            int col = esd.introducirValorEnteroPositivo();
            if (tablero[row][col] == ' ') {
                tablero[row][col] = 'X';
                jugadorTurno = false;
            } else {
                System.out.println("¡La casilla está ocupada o no es válida!");
            }
        } else {
            int[][] jugadaIA = null;
            try {
                jugadaIA = ejecutarIA();
            } catch (Exception ex) {
                esd.mostrarCadena(ex.getMessage());
            }
            // tablero[jugadaIA[0]][jugadaIA[1]] = 'O';
        }
    }

    private static void imprimirTablero() {
        System.out.println("Tablero:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("-----");
            }
        }
    }

    private static boolean tableroLleno() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    
    private static int [][] ejecutarIA() throws IOException, InterruptedException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(tablero[i][j]);
            }
        }
        ProcessBuilder pb = new ProcessBuilder("java", "tresenraya.JugadorIA", sb.toString());
        pb.redirectErrorStream(true);
        Process proceso = pb.start();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
        String linea = reader.readLine();
        proceso.waitFor();
        
        String[] parts = linea.split(",");
        return new int [Integer.parseInt(parts[0])][Integer.parseInt(parts[1])];
    }
}
