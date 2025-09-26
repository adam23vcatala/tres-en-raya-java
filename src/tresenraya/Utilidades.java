package tresenraya;

public class Utilidades {

    private EntradaSalidaDatos esd = new EntradaSalidaDatos();

    public void menu() {
        boolean continuar = true;
        do {
            mostrarMenu();
            int opcion = esd.introducirValorEnteroPositivo();
            switch (opcion) {
                case 1: // CONFIGURACIÓN
                    break;
                case 2: // JUGAR
                    break;
                case 3: // HISTORIAL
                    break;
                case 4: // SALIR
                    continuar = false;
                default:
                    esd.mostrarCadena("¡Opción no válida!");
            }
        } while (continuar);
    }

    public void mostrarMenu() {
        esd.mostrarCadena("MENÚ\n"
                + "\t1. Configuración\n"
                + "\t2. Jugar\n"
                + "\t3. Mostrar partidas anteriores\n"
                + "\t4. Salir\n"
                + "Elige una opción: ");
    }
}
