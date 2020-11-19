package caso_practico.util;

public enum Palo {
    ROMBOS("Rombos   "), PIKAS("Pikas    "), CORAZONES("Corazones"), TREBOLES("Treboles "),
    ORO   ("Oro      "), COPAS("Copas    "), BASTOS   ("Bastos   "), ESPADAS ("Espadas  ");

    private String nombre;

    private Palo(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    
}
