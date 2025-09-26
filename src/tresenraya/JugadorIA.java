package tresenraya;

public class JugadorIA {

    public static void main(String[] args) {
        char[] tablero = args[0].toCharArray();
        for (int i = 0; i < 9; i++) {
            if (tablero[i] == ' ') {
                int fila = i / 3;
                int col = i % 3;
                System.out.println(fila + "," + col);
            }
        }
    }
    
}
