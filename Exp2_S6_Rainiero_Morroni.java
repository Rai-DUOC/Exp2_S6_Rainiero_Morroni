package exp2_s6_rainiero_morroni;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rai
 */
public class Exp2_S6_Rainiero_Morroni {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Crear sistema completo para la reserva y venta de entradas en el Teatro Moro.
        Debe incluir la seleccion de la ubicación del asiento, la cantidad de entradas a comprar, 
        manejo de la venta e impresión de boleta.
         */

        Scanner sca = new Scanner(System.in);
        int opcion = 0;
        boolean opcionValida;

        /*
        5 asientos por sector. 15 asientos en total.
        Posicion 0-4: VIP; Posicion 5-9: Platea; Posicion 10-15: Palco.
         */
        boolean[] asientosReservados = new boolean[15];

        System.out.println("¡Bienvenido a Teatro Moro!");
        System.out.println(""); //Linea en blanco.

        do {
            opcionValida = false;
            System.out.println("        Menu Principal");
            System.out.println("Ingrese el numero de una opcion para continuar:");
            System.out.println("1. Comprar Entradas.");
            System.out.println("2. Revisar nuestros descuentos.");
            System.out.println("3. Salir.");
            System.out.println("");//Linea en blanco.
            System.out.println("Valores entradas Publico General");
            System.out.println("Sector VIP: $30.000.-"); //Precio 1
            System.out.println("Sector Platea: $20.000.-"); //Precio 2
            System.out.println("Sector Palco: $10.000.-"); //Precio 3
            System.out.println("");//Linea en blanco.

            // Validacion try-catch para evitar que el programa caiga al ingresar una opcion diferente a un numero.            
            try {
                opcion = sca.nextInt();
                opcionValida = true;
            } catch (InputMismatchException e) {
                sca.next(); //Entrada para evitar bucle infinito.
                System.out.println(""); //Linea en blanco.
            }
            //PUNTO DE DEPURACION PARA EVALUAR EL FUNCIONAMIENTO DEL MODULO TRY-CATCH. 

            if (opcionValida = true) {
                switch (opcion) {
                    case 1:
                        System.out.println("Accediendo a la seccion de compra de entradas...");

                        int cantidadEntradas = 0;
                        boolean cantidadValida = false;

                        do {
                            System.out.println("Ingrese el numero de entradas que desea comprar:");
                            System.out.println("---Maximo 5 entradas por compra---");
                            try {
                                cantidadEntradas = sca.nextInt();
                                if (cantidadEntradas > 0 && cantidadEntradas <= 5) {
                                    cantidadValida = true;
                                } else {
                                    System.out.println("Ingrese un numero de entradas valido (Entre 1 y 5).");
                                    System.out.println(""); //Linea en blanco.
                                }
                            } catch (InputMismatchException e) {
                                sca.next(); //Entrada para evitar bucle infinito.
                                System.out.println(""); //Linea en blanco.
                            }
                        } while (!cantidadValida);

                        List<String> resumenEntradas = new ArrayList<>();
                        double valorTotalCompra = 0;
                        double precioFinalEntrada;
                        int i;
                        for (i = 1; i <= cantidadEntradas; i++) {
                            System.out.println("--------------------------------------");
                            System.out.println("Entrada #" + i + ".");
                            System.out.println("            MAPA DE ASIENTOS");
                            System.out.println(""); //Linea en blanco.
                            System.out.println("                                  [ESCENARIO]");
                            System.out.println("                                 A  B  C  D  E");
                            System.out.println("Sector 1 - VIP:                 [1][2][3][4][5]");
                            System.out.println("Sector 2 - Platea:              [1][2][3][4][5]");
                            System.out.println("Sector 3 - Palco:               [1][2][3][4][5]");
                            System.out.println("");//Linea en blanco.

                            int sector = 0;
                            boolean sectorValido;

                            do {
                                System.out.println("Seleccione el SECTOR deseado para la entrada #" + i + ":");
                                System.out.println("1. Sector 1 - VIP");
                                System.out.println("2. Sector 2 - Platea");
                                System.out.println("3. Sector 3 - Palco");
                                System.out.println("Ingrese el numero del sector (1-3): ");

                                try {
                                    sector = sca.nextInt();
                                    sectorValido = true;
                                } catch (InputMismatchException e) {
                                    sca.next(); //Entrada para evitar bucle infinito.
                                    System.out.println(""); //Linea en blanco.
                                }

                                if (sectorValido = true && (sector < 1 || sector > 3)) {
                                    System.out.println("Ingrese un sector valido (1-3):");
                                    System.out.println(""); //Linea en blanco.
                                }
                            } while (sector < 1 || sector > 3);

                            int numeroAsiento = 0;
                            boolean asientoValido = false;
                            int estadoAsiento = - 1; //Variable para guardar estado del asiento en el array.

                            do {
                                System.out.println("Seleccione el ASIENTO deseado del sector " + sector + " para la entrada # " + i + ".");
                                System.out.println("1. Asiento 1");
                                System.out.println("2. Asiento 2");
                                System.out.println("3. Asiento 3");
                                System.out.println("4. Asiento 4");
                                System.out.println("5. Asiento 5");
                                System.out.println("Ingrese el numero del asiento (1-5): ");

                                try {
                                    numeroAsiento = sca.nextInt();
                                    asientoValido = true;
                                    estadoAsiento = (sector - 1) * 5 + (numeroAsiento - 1);

                                    if (estadoAsiento >= 0 && estadoAsiento < asientosReservados.length && asientosReservados[estadoAsiento]) {
                                        System.out.println("Asiento no disponible. Por favor, seleccione otro asiento.");
                                        System.out.println(""); //Linea en blanco.
                                        asientoValido = false;
                                    }
                                } catch (InputMismatchException e) {
                                    sca.next(); //Entrada para evitar bucle infinito.
                                    System.out.println(""); //Linea en blanco.                                
                                }

                                if (asientoValido && (numeroAsiento < 1 || numeroAsiento > 5)) {
                                    System.out.println("Ingrese un asiento valido (1-5):");
                                    System.out.println(""); //Linea en blanco.
                                    asientoValido = false;
                                }

                            } while (!asientoValido);

                            if (estadoAsiento >= 0 && estadoAsiento < asientosReservados.length) {
                                asientosReservados[estadoAsiento] = true; //Para marcar el asiento valido como seleccionado.
                            }
                            //PUNTO DE DEPURACION PARA EVALUAR LA CORRECTA RESERVA DEL ASIENTO.

                            int edad = 0;
                            boolean edadValida = false;
                            double descuento = 0;
                            // 10% descuento Estudiantes (0-17 años).
                            // 15% descuento Tercera Edad (>59 años).

                            do {
                                System.out.println(""); //Linea en blanco.
                                System.out.println("Ingrese la EDAD del espectador #" + i + " , para aplicar nuestros descuentos: ");
                                try {
                                    edad = sca.nextInt();
                                    if (edad >= 0 && edad <= 120) {
                                        edadValida = true;
                                    } else {
                                        System.out.println("Edad no valida. Ingrese una edad entre 0 y 120 años.");
                                        System.out.println(""); //Linea en blanco.
                                    }
                                } catch (InputMismatchException e) {
                                    sca.next(); //Entrada para evitar bucle infinito.
                                    System.out.println("Edad no valida. Ingrese una edad entre 0 y 120 años.");
                                    System.out.println(""); //Linea en blanco.
                                }
                            } while (!edadValida);

                            double precioBaseSector = 0;
                            String nombreSector = "";

                            if (sector == 1) {
                                precioBaseSector = 30000;
                                nombreSector = "VIP";
                            } else if (sector == 2) {
                                precioBaseSector = 20000;
                                nombreSector = "Platea";
                            } else if (sector == 3) {
                                precioBaseSector = 10000;
                                nombreSector = "Palco";
                            }

                            if (edad >= 0 && edad <= 17) {
                                descuento = 0.1; // 10% de descuento
                                System.out.println("Descuento del 10% aplicado.");
                                System.out.println(""); //Linea en blanco.
                            } else if (edad >= 60 && edad <= 120) {
                                descuento = 0.15; // 15% de descuento
                                System.out.println("Descuento del 15% aplicado.");
                                System.out.println(""); //Linea en blanco.
                            } else {
                                System.out.println("No se aplica ningun descuento.");
                                System.out.println(""); //Linea en blanco.
                            }
                            //PUNTO DE DEPURACION PARA EVALUAR LA CORRECTA ENTRADA DEL RANGO DE EDAD.

                            precioFinalEntrada = precioBaseSector * (1 - descuento);
                            valorTotalCompra = valorTotalCompra + precioFinalEntrada;
                            
                            //Logica para resumir compra en la impresion de boleta.
                            String detalleEntrada = "Entrada #" + i + ": Sector " + nombreSector + ", Asiento " + numeroAsiento + ", Precio: $" + precioFinalEntrada;
                            resumenEntradas.add(detalleEntrada);

                            System.out.println("Entrada #" + i + ": Asiento " + numeroAsiento + " del sector " + nombreSector + ".");
                            System.out.println("Precio base: $" + precioBaseSector);
                            System.out.println("Precio final: $" + precioFinalEntrada);
                            System.out.println(""); //Linea en blanco.

                        }
                        System.out.println("--------------------Boleta de compra--------------------");
                        System.out.println("-----------------------Teatro Moro----------------------");
                        System.out.println("--------------------Venta de Tickets--------------------");
                        System.out.println("--------------------------------------------------------");
                        for (String detalle : resumenEntradas) {
                            System.out.println(detalle);
                        }       
                        System.out.println("--------------------------------------------------------");                        
                        System.out.println("Total a pagar $: " + valorTotalCompra);
                        System.out.println("--------------------------------------------------------"); 
                        System.out.println(""); //Linea en blanco.
                        System.out.println("¡Gracias por su compra, disfrute su funcion!");
                        System.out.println(""); //Linea en blanco.
                        break;

                    case 2:
                        System.out.println("Accediendo a la seccion de promociones...");
                        System.out.println("Estudiantes: ¡10% de descuento!");
                        System.out.println("Tercera edad: ¡15% de descuento!");
                        System.out.println("Menores de 2 años: Entrada liberada.");
                        System.out.println(""); //Linea en blanco
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        System.out.println("¡Vuelva pronto!");
                        break;
                    default:
                        System.out.println("Opcion ingresada no valida. Por favor, intente nuevamente.");
                        System.out.println(""); //Linea en blanco.
                }
            }

        } while (opcion != 3);
    }
}
