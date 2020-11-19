package lista;

import caso_practico.util.io;

public class TestLista {
    public static void main(String[] args) throws Exception {
        
        testNodoVacio();
        testAniadirDato();
        testImprimirPosicion();
        testBorrarNodo();
        testComprobarDato();
        testObtenerPosicion();

    }

    private static void testNodoVacio() {// TODO POR AHORA se permiten nodos vacios
        System.out.println("*****************************************");
        System.out.println("*** Test intentar iniciar nodo a null ***");
        System.out.println("*****************************************\n");

        System.out.println("Crear Lista");
        Lista<String> miLista = new Lista<>();
        miLista.printLista();

        System.out.println("Aniadir un elemento \"null\"");
        miLista.addDato(null);
        miLista.printLista();

        System.out.println("Aniadir un elemento \"null\"");
        miLista.addDato(null);
        miLista.printLista();

        io.esperarUsuario();
    }

    private static void testObtenerPosicion() {
        System.out.println("*****************************");
        System.out.println("*** Test Obtener posicion ***");
        System.out.println("*****************************\n");

        System.out.println("Crear Lista");
        Lista<String> miLista = new Lista<>();
        miLista.printLista();

        System.out.println("Obtener posicion que contiene \"dos\"");
        System.out.println(miLista.getPosicion("dos"));

        System.out.println("Aniadir elemento \"cero\"");
        miLista.addDato("cero");

        System.out.println("Obtener posicion que contiene \"dos\"");
        System.out.println(miLista.getPosicion("dos"));

        System.out.println("Aniadir elemento \"uno\"");
        miLista.addDato("uno");

        System.out.println("Obtener posicion que contiene \"dos\"");
        System.out.println(miLista.getPosicion("dos"));

        System.out.println("Aniadir elemento \"dos\"");
        miLista.addDato("dos");

        System.out.println("Obtener posicion que contiene \"dos\"");
        System.out.println(miLista.getPosicion("dos"));

        System.out.println("Aniadir elemento \"uno\"");
        miLista.addDato("uno");
        miLista.printLista();

        System.out.println("Obtener posicion que contiene \"dato\"");
        System.out.println(miLista.getPosicion("dato"));
        System.out.println("Obtener posicion que contiene \"dos\"");
        System.out.println(miLista.getPosicion("dos"));

        io.esperarUsuario();
    }

    private static void testBorrarNodo() {
        System.out.println("*****************************");
        System.out.println("*** Test Borrado por dato ***");
        System.out.println("*****************************\n");

        System.out.println("Crear Lista");
        Lista<String> miLista = new Lista<>();
        miLista.printLista();

        System.out.println("Sacara e imprimir \"uno\"");
        System.out.println(miLista.sacarDato("uno"));

        System.out.println("Aniadir 4 elementos");
        miLista.addDato("cero");
        miLista.addDato("uno");
        miLista.addDato("dos");
        miLista.addDato("uno");
        miLista.printLista();

        System.out.println("Sacara e imprimir \"uno\"");
        System.out.println(miLista.sacarDato("uno"));
        miLista.printLista();

        System.out.println("Sacara e imprimir \"cero\"");
        System.out.println(miLista.sacarDato("cero"));
        miLista.printLista();

        System.out.println("Sacara e imprimir \"uno\"");
        System.out.println(miLista.sacarDato("uno"));
        miLista.printLista();

        System.out.println("Sacara e imprimir \"dos\"");
        System.out.println(miLista.sacarDato("dos"));
        miLista.printLista();

        System.out.println("*********************************");
        System.out.println("*** Test Borrado por posicion ***");
        System.out.println("*********************************\n");

        System.out.println("Sacara e imprimir posicion 1");
        System.out.println(miLista.sacarDato(1));

        System.out.println("Aniadir 4 elementos");
        miLista.addDato("cero");
        miLista.addDato("uno");
        miLista.addDato("dos");
        miLista.addDato("tres");
        miLista.printLista();

        System.out.println("Sacara e imprimir posicion 3");
        System.out.println(miLista.sacarDato(3));
        miLista.printLista();

        System.out.println("Sacara e imprimir posicion 0");
        System.out.println(miLista.sacarDato(0));
        miLista.printLista();

        System.out.println("Sacara e imprimir posicion 1");
        System.out.println(miLista.sacarDato(1));
        miLista.printLista();

        System.out.println("Sacara e imprimir posicion 0");
        System.out.println(miLista.sacarDato(0));
        miLista.printLista();
        
        io.esperarUsuario();
    }

    private static void testComprobarDato() {
        System.out.println("****************************");
        System.out.println("*** Test Comprobar datos ***");
        System.out.println("****************************\n");

        System.out.println("Crear Lista");
        Lista<String> miLista = new Lista<>();
        miLista.printLista();

        System.out.println("Comprobar si esta \"uno\"");
        System.out.println(miLista.comprobarDato("uno") ? "\"uno\" si esta" : "\"uno\" no esta");
        miLista.printLista();

        System.out.println("Aniadir 3 elementos");
        miLista.addDato("cero");
        miLista.addDato("uno");
        miLista.addDato("dos");
        miLista.printLista();

        System.out.println("Comprobar si esta \"uno\"");
        System.out.println(miLista.comprobarDato("uno") ? "\"uno\" si esta" : "\"uno\" no esta");
        miLista.printLista();

        System.out.println("Comprobar si esta \"tres\"");
        System.out.println(miLista.comprobarDato("tres") ? "\"tres\" si esta" : "\"tres\" no esta");
        miLista.printLista();
        
        io.esperarUsuario();
    }

    private static void testImprimirPosicion() {
        System.out.println("***************************");
        System.out.println("*** Test Imprimir datos ***");
        System.out.println("***************************\n");

        System.out.println("Crear Lista");
        Lista<String> miLista = new Lista<>();
        miLista.printLista();

        System.out.println("Imprimir posicion 2");
        if (miLista.printPosicion(2) == null) {
            System.out.println("Dato no encontrado");
        } else {
            System.out.println("Dato encontrado");
        }

        System.out.println("Aniadir 3 elementos");
        miLista.addDato("cero");
        miLista.addDato("uno");
        miLista.addDato("dos");
        miLista.printLista();

        System.out.println("Imprimir y recuperar dato posicion 2");
        String dato = miLista.printPosicion(2);
        if (dato == null) {
            System.out.println("Dato no encontrado");
        } else {
            System.out.println("Dato recuperado");
        }
        System.out.println("Imprimir dato recuperado");
        System.out.println(dato);
        
        io.esperarUsuario();
    }

    private static void testAniadirDato() {
        System.out.println("***********************************");
        System.out.println("*** Test aniadir datos al final ***");
        System.out.println("***********************************\n");

        System.out.println("Crear Lista");
        Lista<String> miLista = new Lista<>();
        miLista.printLista();

        System.out.println("Aniadir un elemento \"cero\"");
        miLista.addDato("cero");
        miLista.printLista();

        System.out.println("Aniadir un elemento \"uno\"");
        miLista.addDato("uno");
        miLista.printLista();

        System.out.println("Aniadir un elemento \"dos\"");
        miLista.addDato("dos");
        miLista.printLista();

        System.out.println("Aniadir un elemento \"tres\"");
        miLista.addDato("tres");
        miLista.printLista();

        System.out.println("**************************************");
        System.out.println("*** Test aniadir datos en posicion ***");
        System.out.println("**************************************\n");

        System.out.println("Insertar elemento en posicion 2");
        if (miLista.addDato("insert 2", 2))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.printLista();

        System.out.println("Insertar elemento en posicion 1");
        if (miLista.addDato("insert 1", 1))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.printLista();

        System.out.println("Insertar elemento en posicion 0");
        if (miLista.addDato("insert 0", 0))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.printLista();

        System.out.println("Reset Lista");
        miLista.clear();
        miLista.printLista();

        System.out.println("Insertar elemento en posicion -1");
        if (miLista.addDato("insert -1", -1))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.printLista();

        System.out.println("Insertar elemento en posicion 10");
        if (miLista.addDato("insert 10", 10))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.printLista();

        System.out.println("Insertar elemento 'uno' en posicion 0");
        if (miLista.addDato("uno", 0))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.printLista();

        System.out.println("Insertar elemento 'dos' en posicion 0");
        if (miLista.addDato("dos", 0))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.printLista();

        System.out.println("Insertar elemento 'tres' en posicion 0");
        if (miLista.addDato("tres", 0))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.printLista();

        System.out.println("Insertar elemento en posicion 1");
        if (miLista.addDato("insert 1", 1))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.printLista();

        System.out.println("Insertar elemento en posicion 4");
        if (miLista.addDato("insert 4", 4))
            System.out.println("Se ha conseguido insertar");
        else
            System.out.println("No se ha conseguido insertar");
        miLista.printLista();
        
        io.esperarUsuario();
    }
}
