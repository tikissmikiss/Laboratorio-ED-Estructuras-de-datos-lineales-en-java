package caso_practico.blackjack;

import caso_practico.DemoEstructuras;

public class UI {

	public static void textoReconstruirMazo() {
	    System.out.println("");
	    System.out.println("- Reincorporar la pila de descartes en el mazo y volver ");
	    System.out.println("  a mezclar. Para hacer esto se desopilan las cartas de ");
	    System.out.println("  la pila de descartes una por una, y se meten en el mazo, ");
	    System.out.println("  en el que internamente usa una cola de cartas. El proceso ");
	    System.out.println("  de mezclar ya se ha explicado. ");
	}

	public static void textoComprobarCartasEnMazo() {
	    System.out.println("");
	    System.out.println("- Comprobar si quedan cartas suficientes en el mazo. ");
	    System.out.println("  Para ello se mira el tamaño de la pila.");
	}

	public static void textoDescartarCartas() {
	    System.out.println();
	    System.out.println("- Retirar cartas de la mesa. Para ello se sacan las cartas ");
	    System.out.println("  de las pilas del crupier y del jugador y se apilan en la ");
	    System.out.println("  pila de descarte");
	}

	public static void textoImpresionMarcador() {
	    System.out.println();
	    System.out.println("Para imprimir el marcador se imprime la cola de jugadores");
	    System.out.println("Cola de jugadores:");
	}

	public static void textoReencolarJugador(Jugador jugador) {
	    System.out.println("\n- " + jugador.getNombre() + " vuelve a la cola de jugadores");
	    System.out.println("  El jugador de este turno se vuelve a meter ");
	    System.out.println("  en la cola de jugadores, por lo que quedara ");
	    System.out.println("  el ultimo y tendrá que esperar los turnos del ");
	    System.out.println("  resto hasta volver a jugar.");
	}

	public static void mostrarGanador(Jugador jugador) {
	    System.out.println();
	    System.out.println(UI.comprobarGanador(jugador));
	}

	public static void turnoCrupier(int ronda, Jugador jugador) {
	    System.out.println();
	    System.out.println("- El crupier descubre su carta");
	    DemoEstructuras.crupier.getCima().setVisibilidad(Carta.VISIBLE);
	
	    // El crupier no arriesga. Pide si va perdiendo
	    boolean plantado = false;
	    while (!plantado) {
	        UI.printMesa(ronda, jugador);
	
	        System.out.println();
	        System.out.println("- Juega " + DemoEstructuras.crupier);
	        if (jugador.getPuntuacion() <= 21 && jugador.getPuntuacion() > DemoEstructuras.crupier.getPuntuacion()
	                && DemoEstructuras.crupier.getPuntMin() < 21) {
	            DemoEstructuras.crupier.recibirCarta(DemoEstructuras.mazo.darCarta(Carta.VISIBLE));
	        } else {
	            plantado = true;
	            System.out.println(" Se planta con " + DemoEstructuras.crupier.getPuntuacion() + " puntos");
	        }
	    }
	}

	public static void trunoJugador(int maxToPlay, int ronda, Jugador jugador) {
	    boolean plantado = false;
	    while (!plantado) {
	        UI.printMesa(ronda, jugador);
	
	        System.out.println();
	        System.out.println("- Juega " + jugador);
	        if (jugador.getPuntMin() <= maxToPlay) {
	            jugador.recibirCarta(DemoEstructuras.mazo.darCarta(Carta.VISIBLE));
	        } else {
	            plantado = true;
	            System.out.println(" Se planta con " + jugador.getPuntuacion() + " puntos");
	        }
	    }
	}

	public static void comprobarBJCrupier(int ronda, Jugador jugador) {
	    System.out.println();
	    System.out.println("- El crupier descubre su carta");
	    DemoEstructuras.crupier.getCima().setVisibilidad(Carta.VISIBLE);
	
	    UI.printMesa(ronda, jugador);
	    jugador.resetPuntuacion();
	}

	public static void textoComprobarBlackjackCrupier() {
	    // si crupier tiene blackjack gana
	    System.out.println("- Comprobar si Crupier tiene blackjack: ");
	    System.out.println("  Si tiene 21 de dadas gana. ");
	}

	public static void textoRepartirCartas() {
	    System.out.println();
	    System.out.println("- Repartir cartas: Se sacan 2 cartas del mazo descubiertas ");
	    System.out.println("  para el jugador y 2 para el Crupier, una cubierta y otra ");
	    System.out.println("  descubierta. Las cartas sacadas del mazo se apilan en una ");
	    System.out.println("  pila interna de cada jugador.");
	    System.out.println();
	}

	public static void textoCrearPilaDescartes() {
	    System.out.println("");
	    System.out.println("Crear pila de descartes: Al terminar la mano, las cartas jugadas");
	    System.out.println("se apilarán aquí, hasta que en el mazo queden menos de 10 cartas, ");
	    System.out.println("en cuyo caso se reintroducirán en el mazo y se volverá a mezclar.");
	}

	public static void textoMezclarMazo() {
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
	}

	public static void textoCrearMazo() {
	    System.out.println("");
	    System.out.println("Crear mazo: La baraja está construida internamente por una ");
	    System.out.println("cola de cartas, de modo que solo se puede sacar cartas por un ");
	    System.out.println("lado.");
	    System.out.println("");
	}

	public static void textoCabecera() {
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
	}

	public static String comprobarGanador(Jugador jugador) {
	    int pntJug = jugador.getPuntuacion();
	    int pntCru = DemoEstructuras.crupier.getPuntuacion();
	    if (pntJug == pntCru) {
	        return " >>> Empate <<<";
	    }
	    if (pntCru > 21 || (pntCru < 21 && pntJug > pntCru && pntJug < 21)) {
	        jugador.addWin();
	        return " >>> Gana " + jugador + " <<<";
	    }
	    DemoEstructuras.crupier.addWin();
	    return " >>> Gana " + DemoEstructuras.crupier + " <<<";
	}

	public static void printMesa(int ronda, Jugador jugador) {
	    System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
	    System.out.println("┃ Ronda " + ronda + "  ┃  " + jugador.getNombre());
	    System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
	    System.out.println("┃ Cartas mazo: " + DemoEstructuras.mazo.getLength());
	    System.out.println("┠───────────────────────────────────────────────────────┨");
	    System.out.println("┃ Mano " + DemoEstructuras.crupier.getNombre() + "     >>> " + UI.stringPuntuacion(DemoEstructuras.crupier) + " <<<");
	    System.out.println(DemoEstructuras.crupier.toStringMano());
	    System.out.println("┠───────────────────────────────────────────────────────┨");
	    System.out.println("┃ Mano " + jugador.getNombre() + "   >>> " + UI.stringPuntuacion(jugador) + " <<<");
	    System.out.println(jugador.toStringMano());
	    System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
	}

	public static String stringPuntuacion(Jugador jugador) {
	    int p = jugador.getPuntuacion();
	    return p == 21 ? p + " Blackjack" : p + "";
	}
    
}
