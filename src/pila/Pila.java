package pila;

import lista.Lista;

public class Pila<Tipo> {
    private Lista<Tipo> lista;
    private Tipo cima;
    private int length;

    public Pila() {
        lista = new Lista<Tipo>();
        this.inicializar();
    }

    public boolean apilar(Tipo dato) {
        lista.addDato(dato);
        cima = dato;
        length = lista.getLenght(); //TODO para mantener la longitud bien sincronizada
        return false;
    }

    public Tipo desapilar() {
        length = lista.getLenght() - 1; //TODO actualizar con -1 porque lista lo decrementa al retornar
        if (length > 0)
            cima = lista.getDato(length - 1);
        else
            cima = null;
        return lista.sacarDato(length);
    }

    public Tipo getCima() {
        return lista.getDato(lista.getLenght() - 1);
    }

    public int getLength() {
        return length;
    }

    public boolean isVacia() {
        return lista.getLenght() == 0 ? true : false;
    }

    public void limpiar() { // TODO es redundante
        lista.clear();
    }

    public void inicializar() {
        lista.clear();
    }

    public void imprimir() {
        String str = "";
        str += " n:" + length + "\n";
        str += " cima:" + cima + "\n";
        str += " lista:\n" + lista;
        System.out.println(str);
    }

    @Override
    public String toString() {
        // String str = "";
        // str += " n:" + n + "\n";
        // str += " cima:" + cima + "\n";
        // str += " lista:\n" + lista;
        // return str;
        return lista.toString();
    }

}
