package cola;

import lista.Lista;

public class Cola<Tipo> {
    private Lista<Tipo> lista;
    private Tipo primero;
    private Tipo ultimo;
    private int length;

    public Cola() {
        lista = new Lista<Tipo>();
        this.inicializar();
    }

    public boolean encolar(Tipo dato) {
        ultimo = dato;
        length = lista.getLenght() + 1;
        return lista.addDato(dato);
    }

    public Tipo desencolar() {
        Tipo dato = lista.sacarDato(0);
        primero = lista.getDato(0);
        length = lista.getLenght();
        return dato;
    }

    public Tipo getSiguiente() {
        return lista.getDato(0);
    }

    public boolean isVacia() {
        return lista.getLenght() == 0 ? true : false;
    }

    public void limpiar() { //TODO inicializar y limpiar redundante
        lista.clear();
    }

    public void inicializar() {
        length = 0;
        primero = null;
        ultimo = null;
        lista.clear();
    }

    public int getLength() {
        return length;
    }

    public void print() {
        String str = "";
        str += " n:" + length + "\n";
        str += " ultimo:" + ultimo + "\n";
        str += " primero:" + primero + "\n";
        str += " lista:\n" + lista;
        System.out.println(str);
    }

    @Override
    public String toString() {
        return lista.toString();
    }

}
