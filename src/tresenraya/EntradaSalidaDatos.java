package tresenraya;

import java.util.Scanner;

public class EntradaSalidaDatos {
    private Scanner sc = new Scanner(System.in);
    
    public int introducirValorEnteroPositivo() {
        boolean valido = false;
        int valor = 0;
        while (!valido) {            
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor < 0) {
                    sc.nextLine();
                    mostrarCadena("¡Tiene que ser un valor positivo!");
                } else {
                    sc.nextLine();
                    valido = true;
                }
            } else {
                sc.nextLine();
                mostrarCadena("¡Tiene que ser un valor entero!");
            }
        }
        return valor;
    }
    
    public String introducirCadena() {
        String cadena = sc.nextLine();
        return cadena;
    }
    
    public void mostrarCadena(String cad) {
        System.out.println(cad);
    }
}
