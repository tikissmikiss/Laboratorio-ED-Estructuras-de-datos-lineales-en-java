package caso_practico;

import caso_practico.blackjack.Baraja;
import caso_practico.blackjack.Carta;
import caso_practico.blackjack.Jugador;
import caso_practico.blackjack.UI;
import cola.Cola;
import pila.Pila;

public class DemoEstructuras {
    private static final int NUM_JUGADORES = 6;
    private static final int NUM_RONDAS = 2;
    private static final int NUMERO_PALOS = 4;
    private static final int NUMERO_FIGURAS = 13;
    private static final int NUMERO_BARAJAS = 1;
    private static Cola<Jugador> jugCola;
    private static Pila<Carta> pilaDescartes;
    public static Jugador crupier;
    public static Baraja mazo;

    public static void main(final String[] args) {
        // El jugador pide si <= 15 (58% de pasarse aproximadamente)
        final int maxToPlay = 15;

        UI.textoCabecera();

        System.out.println("Crear la cola de jugadores");
        jugCola = new Cola<>();
        for (int i = 1; i <= NUM_JUGADORES; i++)
            jugCola.encolar(new Jugador("Jugador_" + i));
        System.out.println("Imprimir cola de jugadores");
        jugCola.print();

        System.out.println("\nCrear Crupier");
        crupier = new Jugador("Crupier");
        System.out.println(crupier);

        UI.textoCrearMazo();
        mazo = new Baraja(NUMERO_PALOS, NUMERO_FIGURAS, NUMERO_BARAJAS);
        System.out.println("Imprimir mazo: Internamente utiliza el toString de una cola");
        System.out.println(mazo);

        UI.textoMezclarMazo();
        mazo.mezclar();
        System.out.println("Imprimir mazo mezclado:");
        System.out.println(mazo);

        UI.textoCrearPilaDescartes();
        pilaDescartes = new Pila<>();

        System.out.println("\n>>>> Comienza la partida <<<<");
        for (int ronda = 1; ronda <= NUM_RONDAS; ronda++) {
            for (int i = 0; i < jugCola.getLength(); i++) {

                System.out.println("\n- Se saca un jugador de la cola para jugar la ronda");
                final Jugador jugador = jugCola.desencolar();

                UI.textoRepartirCartas();
                jugador.recibirCarta(mazo.darCarta(Carta.VISIBLE));
                jugador.recibirCarta(mazo.darCarta(Carta.VISIBLE));
                crupier.recibirCarta(mazo.darCarta(Carta.VISIBLE));
                crupier.recibirCarta(mazo.darCarta(Carta.CUBIERTA));

                UI.textoComprobarBlackjackCrupier();
                if (crupier.getPuntuacion(true) == 21) {
                    UI.comprobarBJCrupier(ronda, jugador);
                } else {
                    UI.trunoJugador(maxToPlay, ronda, jugador);
                    UI.turnoCrupier(ronda, jugador);
                }

                UI.mostrarGanador(jugador);

                UI.textoReencolarJugador(jugador);
                jugCola.encolar(jugador);

                UI.textoImpresionMarcador();
                jugCola.print();
                System.out.println("           >   " + crupier + " <");

                UI.textoDescartarCartas();
                while (!jugador.getMano().isVacia() || !crupier.getMano().isVacia()) {
                    if (!jugador.getMano().isVacia())
                        pilaDescartes.apilar(jugador.getMano().desapilar());
                    if (!crupier.getMano().isVacia())
                        pilaDescartes.apilar(crupier.getMano().desapilar());
                }

                UI.textoComprobarCartasEnMazo();
                System.out.println("    Quedan " + mazo.getLength() + " cartas en el mazo.");

                if (mazo.getLength() < 10) {
                    UI.textoReconstruirMazo();
                    while (!pilaDescartes.isVacia()) {
                        mazo.meterCarta(pilaDescartes.desapilar());
                    }
                    mazo.mezclar();
                }
            }
        }
    }
}
