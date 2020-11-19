package caso_practico;

import caso_practico.Jugador.Estados;
import pila.Pila;

public class Partida {
    private Jugador[] jugadores;
    // private Marcador marcador;
    private Pila<Carta> pilaBote;
    private Pila<Carta> pilaDescartes;
    private int numeroJugadores;
    // private int turno;
    private boolean finPartida;

    private static Partida p;

    private Partida(int nJugadores) {
        numeroJugadores = nJugadores;
        jugadores = new Jugador[numeroJugadores];
        pilaBote = new Pila<>();
        pilaDescartes = new Pila<>();
        finPartida=false;
        // this.marcador = new Marcador(numeroJugadores);
    }

    public void comprobarGanador() {
        int jugadorFin = 0;
        for (int i = 1; i < jugadores.length; i++) {
            Jugador jugador = jugadores[i];
            if (jugador.getEstado() == Estados.FIN_PARIDA)
                jugadorFin++;
            if (jugadorFin == jugadores.length)
                finPartida = true;

            // int p1 = p.jugadores[i-1].;
        }
    }

    public int contabilizarPuntuacion() {
        pasarABote();
        imprimirBote();
        int puntos = contabilizarBote();
        System.out.println("Puntos bote total: " + puntos);
        return puntos;
    }

    private void imprimirBote() {
        System.out.println("Bote total:");
        pilaBote.imprimir();
    }

    private int contabilizarBote() {
        int puntos = 0;
        while (!pilaBote.isVacia()) {
            puntos += pilaBote.getCima().getValor();
            Carta c = pilaBote.desapilar();
            pilaDescartes.apilar(c);
        }
        return puntos;
    }

    private void pasarABote() {
        for (Jugador jugador : p.jugadores) {
            Pila<Carta> pilaJugador = jugador.getPilaJuego();
            while (!pilaJugador.isVacia()) {
                p.pilaBote.apilar(pilaJugador.desapilar());
            }
        }
    }

    private boolean comprobarEmpates() {
        boolean empate = false;
        for (Jugador jugador : p.jugadores) {
            if (jugador.getEstado() == Estados.EMPATADO) {
                empate = true;
                jugador.setEstado(Estados.JUGANDO);
            }
        }
        return empate;
    }

    public static Partida iniciarPartida(Jugador[] jugadores) {
        if (Partida.p == null) {
            p = new Partida(jugadores.length);
            p.jugadores = jugadores;
        }
        // return Partida.jugadores;
        return p;
    }

    // public static void iniciarPartida() {
    // if (Partida.p == null)
    // p = new Partida();
    // }

    public Jugador[] getJugadores() {
        return p.jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        p.jugadores = jugadores;
    }

    public int getNumeroJugadores() {
        return numeroJugadores;
    }

    public static Partida getPartida() {
        return p;
    }

    public boolean isFinPartida() {
        return finPartida;
    }

    // public Marcador getMarcador() {
    // return marcador;
    // }

    // public void setMarcador(Marcador marcador) {
    // this.marcador = marcador;
    // }

    // public void setNumeroJugadores(int n) {
    // this.marcador = new Marcador(numeroJugadores);
    // numeroJugadores = n;
    // }

}
