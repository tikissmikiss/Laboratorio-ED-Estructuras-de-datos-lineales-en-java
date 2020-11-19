package caso_practico;

import caso_practico.util.Figura;
import caso_practico.util.Palo;

public class Carta {
    private Palo palo;
    private Figura figura;

    public Carta(Palo palo, Figura figura) {
        this.palo = palo;
        this.figura = figura;
    }
    
    public int getValor() {
        return figura.getValor();
    }
    // public void setValor(Figura figura) {
    //     this.figura = figura;
    // }
    
    public Palo getPalo() {
        return palo;
    }
    // public void setPalo(Palo palo) {
    //     this.palo = palo;
    // }

    @Override
    public String toString() {
        return "[" + figura + " - " + palo + "]";
    }
}
