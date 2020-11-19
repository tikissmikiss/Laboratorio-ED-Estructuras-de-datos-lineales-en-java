package caso_practico.util;

public enum Figura {
    AS(" A", 20), II(" 2", 2), III(" 3", 3), IV(" 4", 4), V(" 5", 5), VI(" 6", 6), VII(" 7", 7), VIII(" 8", 8),
    IX(" 9", 9), X("10", 10), J(" J", 11), Q(" Q", 12), K(" K", 13);

    private String nombre;
    private int valor;

    private Figura(String nombre, int valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public int getValor() {
        return valor;
    }

}
