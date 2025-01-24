import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);

        String mensaje = """
                (1) - Dolar Americano [USD]
                (2) - Dolar Canadiense [CAD]
                (3) - Sol Peruano [PEN]
                (4) - Real Brasilero [BRL]
                (5) - Peso Argentino [ARS] 
                (6) - Peso Chileno [CLP]     
                (7) - Peso Colombiano [COP]   
                (8) - Salir  
                """;

        System.out.println("**************************************");
        System.out.println("Bienvenido al Conversor de Monedas");
        System.out.println(mensaje);
        System.out.println("**************************************");

        int base = 0;
        while (base < 1 || base > 8) {
            System.out.println("Elija la opción de moneda base a convertir:");
            base = lectura.nextInt();
            if (base == 8) {
                System.out.println("Gracias por usar el Conversor de Monedas. ¡Hasta pronto!");
                System.exit(0);
            }
            if (base < 1 || base > 8) {
                System.out.println("No es una opción válida. Por favor, intente de nuevo.");
            }
        }

        String monedaBase = getMoneda(base);

        int objetivo = 0;
        while (objetivo < 1 || objetivo > 8) {
            System.out.println("Elija la opción de moneda objetivo de conversión:");
            objetivo = lectura.nextInt();
            if (objetivo == 8) {
                System.out.println("Gracias por usar el Conversor de Monedas. ¡Hasta pronto!");
                System.exit(0);
            }
            if (objetivo < 1 || objetivo > 8) {
                System.out.println("No es una opción válida. Por favor, intente de nuevo.");
            }
        }

        String monedaObjetivo = getMoneda(objetivo);

        System.out.println("Inserte monto a convertir:");
        double monto = lectura.nextDouble();

        Solicitud solicitud = new Solicitud();
        solicitud.realizarSolicitud(monedaBase, monedaObjetivo, monto);
    }

    private static String getMoneda(int opcion) {
        return switch (opcion) {
            case 1 -> "USD";
            case 2 -> "CAD";
            case 3 -> "PEN";
            case 4 -> "BRL";
            case 5 -> "ARS";
            case 6 -> "CLP";
            case 7 -> "COP";
            default -> "";
        };
    }
}
