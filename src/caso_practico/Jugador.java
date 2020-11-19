package caso_practico;

import pila.Pila;

public class Jugador {
    private String nombre;
    private Pila<Carta> mano;
    private Pila<Carta> pilaJuego;
    private int puntuacion;
    private Estados estado;
    private boolean conCartas;

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

}
