package caso_practico;

import java.util.Random;

import caso_practico.util.Figura;
import caso_practico.util.Palo;
import cola.Cola;
import lista.Lista;

public class Baraja {
    private static final int NUMERO_MEZCLAS = 4;
    private int numeroPalos;
    private int numeroFiguras;
    private Cola<Carta> mazo;

    private static Baraja b;

    private Baraja(int numeroPalos, int numeroFiguras) {
        this.numeroPalos = numeroPalos;
        this.numeroFiguras = numeroFiguras;
        mazo = new Cola<>();

        buildBaraja();
    }

    public static Baraja setBaraja(int numeroPalos, int numeroFiguras) {
        assert numeroFiguras > 0 && numeroFiguras <= 13;
        assert numeroPalos > 0 && numeroPalos <= 4;
        if (b == null)
            b = new Baraja(numeroPalos, numeroFiguras);
        return b;
    }

    private void buildBaraja() {
        Palo[] palos = Palo.values();
        Figura[] figuras = Figura.values();
        for (int i = 0; i < numeroPalos; i++) {
            for (int j = 0; j < numeroFiguras; j++) {
                mazo.encolar(new Carta(palos[i], figuras[j]));
            }
        }
        mazo.print();
    }

    public boolean mezclar() {
        Lista<Carta> aux1 = new Lista<>();
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < NUMERO_MEZCLAS; i++) {
            while (!b.mazo.isVacia()) {
                int insertPos = random.nextInt(aux1.getLenght() + 1);
                aux1.addDato(b.mazo.desencolar(), insertPos);
                // aux1.imprimirLista();
            }

            while (aux1.getLenght() > 0) {
                int extracPos = random.nextInt(aux1.getLenght());
                b.mazo.encolar(aux1.sacarDato(extracPos));
            }
        }
        b.mazo.print();
        return true;
    }

    public void setNumeroFiguras(int numeroFiguras) {
        if (numeroFiguras < 1)
            this.numeroFiguras = 1;
        if (numeroFiguras > 15)
            this.numeroFiguras = 15;
        this.numeroFiguras = numeroFiguras;
    }

    public int getNumeroPalos() {
        return numeroPalos;
    }

    public void setNumeroPalos(int numeroPalos) {
        if (numeroFiguras < 1)
            this.numeroPalos = 1;
        if (numeroFiguras > 5)
            this.numeroPalos = 5;
        this.numeroPalos = numeroPalos;
    }

    public Carta darCarta() {
        if (!b.mazo.isVacia())
            return b.mazo.desencolar();
        return null;
    }

    public void repartir(Jugador[] jugadores) {
        int i = 0;
        while (!b.mazo.isVacia()) {
            jugadores[i++ % jugadores.length].recibirCarta(b.mazo.desencolar());
        }
    }

}
