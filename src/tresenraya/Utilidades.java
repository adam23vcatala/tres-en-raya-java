package tresenraya;

public class Utilidades {

    private EntradaSalidaDatos esd = new EntradaSalidaDatos();

    public void menu() {
        boolean continuar = true;
        Configuracion conf = new Configuracion();
        Juego j = new Juego();
        do {
            mostrarMenu();
            int opcion = esd.introducirValorEnteroPositivo();
            switch (opcion) {
                case 1: // CONFIGURACIÓN
                    conf.ajustes();
                    break;
                case 2: // JUGAR
                    esd.mostrarCadena("Introduce tu nombre: ");
                    String nombre = esd.introducirCadena();
                    j.jugar(nombre);
                    break;
                case 3: // HISTORIAL
                    conf.registros();
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
