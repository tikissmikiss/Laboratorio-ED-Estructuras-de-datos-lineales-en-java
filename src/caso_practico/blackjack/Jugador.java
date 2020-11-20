package caso_practico.blackjack;

import pila.Pila;

public class Jugador {
    private String nombre;
    private Pila<Carta> mano;
    private Pila<Carta> pilaJuego;
    private int puntuacion;
    private int cntGanadas;
    private Estados estado;
    private boolean conCartas;
    private int puntMin;

    public enum Estados {
        JUGANDO, PLANTADO, EMPATADO, DESCALIFICADO, FIN_PARIDA, GANADOR;
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
        mano = new Pila<Carta>();
        pilaJuego = new Pila<Carta>();
        puntuacion = 0;
        estado = Estados.JUGANDO;
        conCartas = false;
    }

    public void recibirCarta(Carta carta) {
        mano.apilar(carta);
        conCartas = true;
    }

    public Carta sacarCarta() {
        if (mano.getLength() == 1)
            conCartas = false;
        return mano.desapilar();
    }

    public Carta jugarCarta() {
        pilaJuego.apilar(sacarCarta());
        return pilaJuego.getCima();
    }

    public Carta sacarPilaJuego() {
        return pilaJuego.desapilar();
    }

    public void sumarPuntuacion(int puntos) {
        puntuacion += puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return getPuntuacion(false); 
    }

    public int getPuntuacion(boolean incluirCubiertas) {
        if (mano.isVacia())
            return 0;

        puntuacion = 0;
        Pila<Carta> auxPila = new Pila<>();

        int cntAs = 0;
        while (!mano.isVacia()) {
            auxPila.apilar(mano.desapilar());
            int val = auxPila.getCima().getValor(incluirCubiertas);
            puntuacion += val;
            if (val == 11) { // Si es un AS se contabiliza el AS
                cntAs++;
                // puntuacion += 10;
            }
        }
        // Si hay Ases, si se supera 21 se resta 10 para que el valor del As sea 1
        puntMin = puntuacion;
        for (; cntAs > 0; cntAs--) {
            puntMin -= 10; // puntuacion minima para toma de decisiones de mas cartas
            if (puntuacion > 21)
                puntuacion -= 10;
        }

        // for (auxPila.apilar(mano.desapilar()); !mano.isVacia();)
        // puntuacion += auxPila.getCima().getValor();

        while (!auxPila.isVacia())
            mano.apilar(auxPila.desapilar());

        return puntuacion;
    }

    // public void setPuntuacion(int puntuacion) {
    // this.puntuacion = puntuacion;
    // }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public Pila<Carta> getPilaJuego() {
        return pilaJuego;
    }

    public boolean isConCartas() {
        return conCartas;
    }

    public int getCntGanadas() {
        return cntGanadas;
    }

    public void addWin() {
        cntGanadas++;
    }

    public String toStringMano() {
        return mano.toString();
    }

    @Override
    public String toString() {
        return nombre + " " + "   |   Victorias: " + cntGanadas;
        // return nombre + " " + " Ptos " + puntuacion + " | Victorias: " + cntGanadas;
    }

    public int getPuntMin() {
        return puntMin;
    }

	public Carta getCima() {
        return mano.getCima();
	}

    public Pila<Carta> getMano() {
        return mano;
    }

	public void resetPuntuacion() {
        puntuacion = 0;
	}


}
