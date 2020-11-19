package caso_practico;

import caso_practico.Jugador.Estados;
import lista.Lista;

public class Turno {

    private Lista<Jugador> jugadores;
    private boolean finTurno;
    private Jugador[] jugadoresPartida;
    private int ronda;
    private static int turno;

    public Turno(Jugador[] jugadoresTurno) {
        iniciarTurno(jugadoresTurno);
    }

    private void iniciarTurno(Jugador[] jugadoresTurno) {
        // poner en cola los jugadores
        jugadoresPartida = jugadoresTurno;
        jugadores = new Lista<>();
        for (Jugador jugador : jugadoresTurno) {
            jugador.setEstado(Estados.JUGANDO);
            jugadores.addDato(jugador);
        }
        turno++;
        ronda = 0;
        finTurno = false;
    }

    public void valorarRonda() {
        Jugador jugadorGanando = jugadores.getDato(0);
        int loops = jugadores.getLenght();
        for (int i = 1, pos = 1; i < loops; i++, pos++) {
            Jugador jugadorComparando = jugadores.getDato(pos);
            if (jugadorComparando.getEstado() == Estados.JUGANDO) {
                // comparar
                // int puntGanando = jugadorGanando.getEstado()!=Estados.FIN_PARIDA ?
                // jugadorGanando.getPilaJuego().getCima().getValor() : 0;
                int puntGanando;// = jugadorGanando.getEstado()!=Estados.FIN_PARIDA ?
                                // jugadorGanando.getPilaJuego().getCima().getValor() : 0;
                int puntComparando;// = jugadorComparando.getEstado()!=Estados.FIN_PARIDA ?
                                   // jugadorComparando.getPilaJuego().getCima().getValor() : 0;

                if (jugadorGanando.getPilaJuego().getCima() != null)
                    puntGanando = jugadorGanando.getPilaJuego().getCima().getValor();
                else
                    puntGanando = 0;

                if (jugadorComparando.getPilaJuego().getCima() != null)
                    puntComparando = jugadorComparando.getPilaJuego().getCima().getValor();
                else
                    puntComparando = 0;

                if (puntComparando > puntGanando) {
                    // descalificar jugadorGanando y empatados
                    jugadorGanando.setEstado(Estados.DESCALIFICADO);
                    jugadores.sacarDato(jugadorGanando);
                    pos--;
                    for (int j = 0; j < jugadores.getLenght(); j++) {
                        Jugador jugador = jugadores.getDato(j);
                        if (jugador.getEstado() == Estados.EMPATADO) {
                            jugador.setEstado(Estados.DESCALIFICADO);
                            jugadores.sacarDato(jugador);
                            pos--;
                        }
                    }
                    jugadorGanando = jugadorComparando;
                } else if (puntComparando == puntGanando) {
                    // marcar empate
                    jugadorGanando.setEstado(Estados.EMPATADO);
                    jugadorComparando.setEstado(Estados.EMPATADO);
                } else {
                    // descalificar jugadorComparando
                    jugadorComparando.setEstado(Estados.DESCALIFICADO);
                    jugadores.sacarDato(jugadorComparando);
                    pos--;
                }
            }
        }
        if (jugadores.getLenght() == 1) {
            finTurno = true;
            jugadorGanando.setEstado(Estados.GANADOR);
        }
    }

    /**
     * Los juagadores en juego sacan carta
     */
    public void jugarRonda() {
        ronda++;
        for (int i = 0; i < jugadores.getLenght(); i++) {
            Jugador jugador = jugadores.getDato(i);
            jugador.setEstado(Estados.JUGANDO);
            if (jugador.isConCartas()) {
                jugador.jugarCarta();
            } else {
                jugador.setEstado(Estados.FIN_PARIDA);
                jugadores.sacarDato(jugador);
            }
        }
        imprimirRonda();
        valorarRonda();
    }

    public void imprimirGanador() {
        for (int i = 0; i < jugadores.getLenght(); i++) {
            Jugador jugador = jugadores.getDato(i);
            if (jugador.getEstado() == Estados.GANADOR) {
                System.out.println("GANADOR: <<< " + jugador.getNombre() + " >>>  ( Total Puntos: "
                        + jugador.getPuntuacion() + " )");
            }
        }
    }

    public void imprimirMarcador() {
        System.out.println("\n   --- MARCADOR ---");
        for (int i = 0; i < jugadoresPartida.length; i++) {
            Jugador jugador = jugadoresPartida[i];
            System.out.println(
                    "  <<< " + jugador.getNombre() + " >>>  ( Total Puntos: " + jugador.getPuntuacion() + " )");
        }
    }

    public void imprimirTurno() {
        System.out.println("*******************************************");
        System.out.println("          FIN TURNO: [" + turno + "]");
        System.out.println("*******************************************");
        for (Jugador jugador : jugadoresPartida) {
            System.out.println(jugador.getNombre() + ": (Puntos: " + jugador.getPuntuacion() + ") - "
                    + jugador.getEstado() + "\n" + jugador.getPilaJuego());
            // System.out.println();
        }
    }

    public void imprimirRonda() {
        System.out.println("*******************************************");
        System.out.println("         TURNO: " + turno + "     Ronda: " + ronda);
        System.out.println("*******************************************");
        for (int i = 0; i < jugadores.getLenght(); i++) {
            Jugador jugador = jugadores.getDato(i);
            System.out.println(jugador.getNombre() + ": (Puntos: " + jugador.getPuntuacion() + ") - "
                    + jugador.getEstado() + "\n\t" + jugador.getPilaJuego().getCima());
            System.out.println();
        }
    }

    public void sumarPuntosGanador(int puntos) {
        for (int i = 0; i < jugadores.getLenght(); i++) {
            Jugador jugador = jugadores.getDato(i);
            if (jugador.getEstado() == Estados.GANADOR)
                jugador.sumarPuntuacion(puntos);
            // puntos = 0;
        }
    }

    public boolean isFinTurno() {
        return finTurno;
    }

}
