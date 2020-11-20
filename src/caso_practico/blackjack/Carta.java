package caso_practico.blackjack;

import caso_practico.util.Figura;
import caso_practico.util.Palo;

public class Carta {
    private Palo palo;
    private Figura figura;
    private VisibilidadCarta visibilidad;

    // private enum VisibilidadCarta {
    // DESCUBIERTA, CUBIERTA;
    // }

    public static VisibilidadCarta VISIBLE = VisibilidadCarta.DESCUBIERTA;
    public static VisibilidadCarta CUBIERTA = VisibilidadCarta.CUBIERTA;

    public Carta(Palo palo, Figura figura) {
        this.palo = palo;
        this.figura = figura;
        this.visibilidad = VISIBLE;
    }

    /**
     * devuelve el valor aunque este cubierta
     * @param all
     * @return
     */
    public int getValor() {
        return getValor(false);
    }

    public int getValor(boolean incluirCubiertas) {
        if (visibilidad == VISIBLE || incluirCubiertas)
            return figura.getValor();
        else
            return 0;
    }
    // public void setValor(Figura figura) {
    // this.figura = figura;
    // }

    public Palo getPalo() {
        return palo;
    }
    // public void setPalo(Palo palo) {
    // this.palo = palo;
    // }

    public void setVisibilidad(VisibilidadCarta visibilidad) {
        this.visibilidad = visibilidad;
    }

    public String stringVisible() {
        return "[" + figura + " - " + palo + "]";
    }

    @Override
    public String toString() {
        if (visibilidad == VISIBLE)
            return "[" + figura + " - " + palo + "]";
        else
            return "[  ♠  ♣  ♥  ♦  ]";
        // return "[ ]";
    }
}
