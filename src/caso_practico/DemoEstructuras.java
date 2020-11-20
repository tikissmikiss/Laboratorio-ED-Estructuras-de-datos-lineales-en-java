package caso_practico;

import caso_practico.blackjack.Baraja;
import caso_practico.blackjack.Carta;
import caso_practico.blackjack.Controlador;
import caso_practico.blackjack.Jugador;
import caso_practico.blackjack.Print;
import cola.Cola;
import pila.Pila;

public class DemoEstructuras {
    private static int nJugadores = 1;
    private static Cola<Jugador> jugCola;
    private static Pila<Carta> pilaDescartes;
    private static Jugador crupier;
    private static Baraja mazo;

    public static void main(String[] args) {
        Controlador ctrl = Controlador.iniciarUI();
        int numRondas = 500;
        int numeroPalos = 4;
        int numeroFiguras = 13;
        int numeroBarajas = 4;

        System.out.println();
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                 Lista - Pila - Cola                   ┃");
        System.out.println("┠───────────────────────────────────────────────────────┨");
        System.out.println("┃ Demostración de uso práctico de estructuras de datos. ┃");
        System.out.println("┃                                     por: José Herce   ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.println();

        System.out.println("Se va a simular una partida de una variación de Blackjack.");
        System.out.println("La variación consiste en que el Crupier no juega su mano ");
        System.out.println("contra todos los jugadores al mismo tiempo, si no que ");
        System.out.println("jugará una mano contra cada jugador, de modo que los ");
        System.out.println("jugadores esperan en fila su turno. Esto será un reflejo ");
        System.out.println("más práctico del uso del TDA cola.");
        System.out.println("");

        System.out.println("Crear la cola de jugadores");
        jugCola = new Cola<>();
        for (int i = 1; i <= nJugadores; i++)
            jugCola.encolar(new Jugador("Jugador_" + i));
        // System.out.println("Imprimir cola de jugadores");
        jugCola.print();

        System.out.println();
        System.out.println("Crear Crupier");
        crupier = new Jugador("Crupier");
        System.out.println(crupier);

        System.out.println("");
        System.out.println("Crear mazo: La baraja está construida internamente por una ");
        System.out.println("cola de cartas, de modo que solo se puede sacar cartas por un ");
        System.out.println("lado y no se pueden volver a meter. ");
        System.out.println("");
        mazo = new Baraja(numeroPalos, numeroFiguras, numeroBarajas);
        System.out.println(mazo);

        System.out.println();
        System.out.println("Mezclar mazo: Para mezclar las cartas, el mazo utiliza ");
        System.out.println("internamente una lista doblemente enlazada auxiliar para ");
        System.out.println("mezclar las cartas en dos tiempos:");
        System.out.println(" 1- Se desencolan las cartas de una en una y se van insertando ");
        System.out.println("    en una posición aleatoria dentro de la longitud de la lista ");
        System.out.println("    auxiliar.");
        System.out.println("    Esto hace que todas las cartas del mazo queden desordenadas");
        System.out.println("    en la lista.");
        System.out.println(" 2- Se encolan de nuevo las cartas en el mazo desde la lista ");
        System.out.println("    auxiliar. Ahora las cartas se van recuperando de la lista ");
        System.out.println("    de una en una, desde una posición aleatoria dentro de su longitud.");
        System.out.println("    Esto además de devolver las cartas al mazo consigue que se haga ");
        System.out.println("    con grado de mezclado mayor.");
        System.out.println("");

        mazo.mezclar();
        System.out.println(mazo);

        System.out.println("");
        System.out.println("Crear pila de descartes: Al terminar la mano, las cartas jugadas");
        System.out.println("se apilarán aquí, hasta que en el mazo queden menos de 10 cartas, ");
        System.out.println("en cuyo caso se reintroducirán en el mazo y se volverá a mezclar.");
        pilaDescartes = new Pila<>();

        System.out.println();
        System.out.println(">>>> Comienza la partida <<<<");
        for (int ronda = 1; ronda <= numRondas; ronda++) {
            for (int i = 0; i < jugCola.getLength(); i++) {

                System.out.println();
                System.out.println("- Se saca un jugador de la cola para jugar la ronda");
                Jugador jugador = jugCola.desencolar();

                System.out.println();
                System.out.println("- Repartir cartas: Se sacan 2 cartas del mazo descubiertas ");
                System.out.println("  para el jugador y 2 para el Crupier, una cubierta y otra ");
                System.out.println("  descubierta.");
                System.out.println();

                jugador.recibirCarta(mazo.darCarta(Carta.VISIBLE));
                jugador.recibirCarta(mazo.darCarta(Carta.VISIBLE));
                crupier.recibirCarta(mazo.darCarta(Carta.VISIBLE));
                crupier.recibirCarta(mazo.darCarta(Carta.CUBIERTA));

                // si crupier tiene blackjack gana
                System.out.println("- Comprobar si Crupier tiene blackjack: ");
                System.out.println("  Si tiene 21 de dadas gana. ");
                if (crupier.getPuntuacion(true) == 21) {
                    System.out.println();
                    System.out.println("- El crupier descubre su carta");
                    crupier.getCima().setVisibilidad(Carta.VISIBLE);

                    printMesa(ronda, jugador);
                    jugador.resetPuntuacion();
                } else {
                    // El jugador pide si <= 15 (58% de pasarse aproximadamente)
                    int maxToPlay = 15;
                    boolean plantado = false;
                    while (!plantado) {
                        printMesa(ronda, jugador);

                        System.out.println();
                        System.out.println("- Juega " + jugador);
                        if (jugador.getPuntMin() <= maxToPlay) {
                            jugador.recibirCarta(mazo.darCarta(Carta.VISIBLE));
                        } else {
                            plantado = true;
                            System.out.println(" Se planta con " + jugador.getPuntuacion() + " puntos");
                        }

                    }

                    System.out.println();
                    System.out.println("- El crupier descubre su carta");
                    crupier.getCima().setVisibilidad(Carta.VISIBLE);

                    // El crupier no arriesga. Pide si va perdiendo
                    plantado = false;
                    while (!plantado) {
                        printMesa(ronda, jugador);

                        System.out.println();
                        System.out.println("- Juega " + crupier);
                        if (jugador.getPuntuacion() <= 21 && jugador.getPuntuacion() > crupier.getPuntuacion()
                                && crupier.getPuntMin() < 21) {
                            crupier.recibirCarta(mazo.darCarta(Carta.VISIBLE));
                        } else {
                            plantado = true;
                            System.out.println(" Se planta con " + crupier.getPuntuacion() + " puntos");
                        }

                    }

                }

                System.out.println();
                System.out.println(comprobarGanador(jugador));

                System.out.println();
                System.out.println("- " + jugador.getNombre() + " vuelve a la cola de jugadores");
                jugCola.encolar(jugador);

                System.out.println();
                System.out.println("Para imprimir el marcador se imprime la cola de jugadores");
                System.out.println("Cola de jugadores:");
                jugCola.print();
                System.out.println("           >   " + crupier + " <");

                System.out.println();
                System.out.println("- Retirar cartas de la mesa. Para ello se sacan las cartas ");
                System.out.println("  de las pilas del crupier y del jugador y se apilan en la ");
                System.out.println("  pila de descarte");

                while (!jugador.getMano().isVacia() || !crupier.getMano().isVacia()) {
                    if (!jugador.getMano().isVacia())
                        pilaDescartes.apilar(jugador.getMano().desapilar());
                    if (!crupier.getMano().isVacia())
                        pilaDescartes.apilar(crupier.getMano().desapilar());
                }

                System.out.println("");
                System.out.println("- Comprobar si quedan cartas suficientes en el mazo. ");
                System.out.println("  Para ello se mira el tamaño de la pila.");
                System.out.println("    Quedan " + mazo.getLength() + " cartas en el mazo.");
                if (mazo.getLength() < 10) {

                    System.out.println("");
                    System.out.println("- Reincorporar la pila de descartes en el mazo y volver ");
                    System.out.println("  a mezclar. Para hacer esto se desopilan las cartas de ");
                    System.out.println("  la pila de descartes una por una, y se meten en el mazo, ");
                    System.out.println("  en el que internamente usa una cola de cartas. El proceso ");
                    System.out.println("  de mezclar ya se ha explicado. ");

                    while (!pilaDescartes.isVacia()) {
                        mazo.meterCarta(pilaDescartes.desapilar());
                    }
                    mazo.mezclar();
                }

            }
        }

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        ctrl.iniciarPartida(6);

    }

    private static String comprobarGanador(Jugador jugador) {
        int pntJug = jugador.getPuntuacion();
        int pntCru = crupier.getPuntuacion();
        if (pntJug == pntCru) {
            // crupier.addWin();
            // return " >>> Empate es victoria para el Crupier <<<";
            return " >>> Empate <<<";
        }
        if (pntCru > 21 || (pntCru < 21 && pntJug > pntCru && pntJug < 21)) {
            jugador.addWin();
            return " >>> Gana " + jugador + " <<<";
        }
        crupier.addWin();
        return " >>> Gana " + crupier + " <<<";
    }

    private static void printMesa(int ronda, Jugador jugador) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃ Ronda " + ronda + "  ┃  " + jugador.getNombre());
        System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
        System.out.println("┃ Cartas mazo: " + mazo.getLength());
        System.out.println("┠───────────────────────────────────────────────────────┨");
        System.out.println("┃ Mano " + crupier.getNombre() + "     >>> " + stringPuntuacion(crupier) + " <<<");
        System.out.println(crupier.toStringMano());
        System.out.println("┠───────────────────────────────────────────────────────┨");
        System.out.println("┃ Mano " + jugador.getNombre() + "   >>> " + stringPuntuacion(jugador) + " <<<");
        System.out.println(jugador.toStringMano());
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }

    private static String stringPuntuacion(Jugador jugador) {
        int p = jugador.getPuntuacion();
        return p == 21 ? p + " Blackjack" : p + "";
    }

    private static void setJugadores() {
        for (int i = 1; i <= nJugadores; i++) {
            jugCola.encolar(new Jugador("Jugador_" + i));
        }
    }

}
