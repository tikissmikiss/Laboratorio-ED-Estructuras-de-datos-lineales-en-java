package caso_practico;

public class App {
    public static void main(String[] args) throws Exception {
        UI ui = UI.iniciarUI();
        ui.iniciarPartida();

        Partida p = Partida.getPartida();

        ui.setJugadores();
        Baraja baraja = ui.setBaraja();
        ui.esperarUsuario();
        baraja.mezclar();

        ui.esperarUsuario();

        baraja.repartir(p.getJugadores());

        Turno t;
        while (!p.isFinPartida()) {
            t = new Turno(p.getJugadores());

            while (!t.isFinTurno()) {
                t.jugarRonda();
                ui.esperarUsuario();
            }

            t.imprimirTurno();
            t.sumarPuntosGanador(p.contabilizarPuntuacion());
            t.imprimirGanador();
            t.imprimirMarcador();

            ui.esperarUsuario();
            p.comprobarGanador();

        }
        if (!p.isFinPartida()) {
            System.out.println("\n````` FIN DE LA PARTIDA ´´´´´");
            // t.imprimirGanador();
        }
        // UI.setJugadores();

        // testCola();
        // testPila();

    }

//     private static void testCola() {
//         System.out.println("***********************************");
//         System.out.println("*** Test aniadir Cola           ***");
//         System.out.println("***********************************\n");

//         System.out.println("Crear Pila");
//         Cola<Object> miCola = new Cola<Object>();
//         miCola.imprimir();

//         ArrayList<String> lista0 = new ArrayList<String>();
//         // Lista lista0 = new Lista();
//         lista0.add("lista 0 cero");
//         lista0.add("lista 0 uno");
//         lista0.add("lista 0 dos");

//         ArrayList<String> lista1 = new ArrayList<String>();
//         lista1.add("lista 1 cero");
//         lista1.add("lista 1 uno");
//         lista1.add("lista 1 dos");

//         ArrayList<String> lista2 = new ArrayList<String>();
//         lista2.add("lista 2 cero");
//         lista2.add("lista 2 uno");
//         lista2.add("lista 2 dos");

//         ArrayList<String> lista3 = new ArrayList<String>();
//         lista3.add("lista 3 cero");
//         lista3.add("lista 3 uno");
//         lista3.add("lista 3 dos");

//         ArrayList<String> lista4 = new ArrayList<String>();
//         lista4.add("lista 4 cero");
//         lista4.add("lista 4 uno");
//         lista4.add("lista 4 dos");

//         System.out.println("Aniadir un elemento \"lista0\"");
//         miCola.encolar(lista0);
//         miCola.imprimir();

//         System.out.println("Aniadir un elemento \"lista1\"");
//         miCola.encolar(lista1);
//         miCola.imprimir();

//         System.out.println("Aniadir un elemento \"lista2\"");
//         miCola.encolar(lista2);
//         miCola.imprimir();

//         System.out.println("Aniadir un elemento \"lista3\"");
//         miCola.encolar(lista3);
//         miCola.imprimir();

//         System.out.println("Aniadir un elemento \"lista4\"");
//         miCola.encolar(lista4);
//         miCola.imprimir();

//         System.out.println("Aniadir un elemento \"cero\"");
//         miCola.encolar("cero");
//         miCola.imprimir();

//         System.out.println("Aniadir un elemento \"uno\"");
//         miCola.encolar("uno");
//         miCola.imprimir();

//         System.out.println("Aniadir un elemento \"dos\"");
//         miCola.encolar("dos");
//         miCola.imprimir();

//         System.out.println("Aniadir un elemento \"tres\"");
//         miCola.encolar("tres");
//         miCola.imprimir();

//         System.out.println("Aniadir un elemento \"Integer\"");
//         miCola.encolar((Integer) 25);
//         miCola.imprimir();

//         System.out.println("Aniadir un elemento \"Long\"");
//         miCola.encolar(new Long(68465465));
//         miCola.imprimir();

//         System.out.println("Aniadir un elemento \"Double\"");
//         miCola.encolar((Double) 25.125);
//         miCola.imprimir();

//         System.out.println("Aniadir un elemento \"Boolean\"");
//         miCola.encolar((Boolean) true);
//         miCola.imprimir();

//         System.out.println("Aniadir un elemento \"String\"");
//         miCola.encolar("Esto es una cadena");
//         miCola.imprimir();

//         System.out.println("**************************************");
//         System.out.println("*** Test aniadir datos en posicion ***");
//         System.out.println("**************************************\n");

//         System.out.println("Insertar elemento en posicion 2");
//         if (miCola.encolar("insert 2"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miCola.imprimir();

//         System.out.println("Insertar elemento en posicion 1");
//         if (miCola.encolar("insert 1"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miCola.imprimir();

//         System.out.println("Insertar elemento en posicion 0");
//         if (miCola.encolar("insert 0"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miCola.imprimir();

//         System.out.println("Reset Cola");
//         miCola.inicializar();
//         miCola.imprimir();

//         System.out.println("Insertar elemento en posicion -1");
//         if (miCola.encolar("insert -1"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miCola.imprimir();

//         System.out.println("Insertar elemento en posicion 10");
//         if (miCola.encolar("insert 10"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miCola.imprimir();

//         System.out.println("Insertar elemento 'uno' en posicion 0");
//         if (miCola.encolar("uno"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miCola.imprimir();

//         System.out.println("Insertar elemento 'dos' en posicion 0");
//         if (miCola.encolar("dos"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miCola.imprimir();

//         System.out.println("Insertar elemento 'tres' en posicion 0");
//         if (miCola.encolar("tres"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miCola.imprimir();

//         System.out.println("Insertar elemento en posicion 1");
//         if (miCola.encolar("insert 1"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miCola.imprimir();

//         System.out.println("Insertar elemento en posicion 4");
//         if (miCola.encolar("insert 4"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miCola.imprimir();
//     }

//     private static void testPila() {
//         System.out.println("***********************************");
//         System.out.println("*** Test aniadir Pila           ***");
//         System.out.println("***********************************\n");

//         System.out.println("Crear Pila");
//         Pila<Object> miPila = new Pila<Object>();
//         miPila.imprimir();

//         ArrayList<String> lista0 = new ArrayList<String>();
//         // Lista lista0 = new Lista();
//         lista0.add("lista 0 cero");
//         lista0.add("lista 0 uno");
//         lista0.add("lista 0 dos");

//         ArrayList<String> lista1 = new ArrayList<String>();
//         lista1.add("lista 1 cero");
//         lista1.add("lista 1 uno");
//         lista1.add("lista 1 dos");

//         ArrayList<String> lista2 = new ArrayList<String>();
//         lista2.add("lista 2 cero");
//         lista2.add("lista 2 uno");
//         lista2.add("lista 2 dos");

//         ArrayList<String> lista3 = new ArrayList<String>();
//         lista3.add("lista 3 cero");
//         lista3.add("lista 3 uno");
//         lista3.add("lista 3 dos");

//         ArrayList<String> lista4 = new ArrayList<String>();
//         lista4.add("lista 4 cero");
//         lista4.add("lista 4 uno");
//         lista4.add("lista 4 dos");

//         System.out.println("Aniadir un elemento \"lista0\"");
//         miPila.apilar(lista0);
//         miPila.imprimir();

//         System.out.println("Aniadir un elemento \"lista1\"");
//         miPila.apilar(lista1);
//         miPila.imprimir();

//         System.out.println("Aniadir un elemento \"lista2\"");
//         miPila.apilar(lista2);
//         miPila.imprimir();

//         System.out.println("Aniadir un elemento \"lista3\"");
//         miPila.apilar(lista3);
//         miPila.imprimir();

//         System.out.println("Aniadir un elemento \"lista4\"");
//         miPila.apilar(lista4);
//         miPila.imprimir();

//         System.out.println("Aniadir un elemento \"cero\"");
//         miPila.apilar("cero");
//         miPila.imprimir();

//         System.out.println("Aniadir un elemento \"uno\"");
//         miPila.apilar("uno");
//         miPila.imprimir();

//         System.out.println("Aniadir un elemento \"dos\"");
//         miPila.apilar("dos");
//         miPila.imprimir();

//         System.out.println("Aniadir un elemento \"tres\"");
//         miPila.apilar("tres");
//         miPila.imprimir();

//         System.out.println("Aniadir un elemento \"Integer\"");
//         miPila.apilar((Integer) 25);
//         miPila.imprimir();

//         System.out.println("Aniadir un elemento \"Long\"");
//         miPila.apilar(new Long(68465465));
//         miPila.imprimir();

//         System.out.println("Aniadir un elemento \"Double\"");
//         miPila.apilar((Double) 25.125);
//         miPila.imprimir();

//         System.out.println("Aniadir un elemento \"Boolean\"");
//         miPila.apilar((Boolean) true);
//         miPila.imprimir();

//         System.out.println("Aniadir un elemento \"String\"");
//         miPila.apilar("Esto es una cadena");
//         miPila.imprimir();

//         System.out.println("**************************************");
//         System.out.println("*** Test aniadir datos en posicion ***");
//         System.out.println("**************************************\n");

//         System.out.println("Insertar elemento en posicion 2");
//         if (miPila.apilar("insert 2"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miPila.imprimir();

//         System.out.println("Insertar elemento en posicion 1");
//         if (miPila.apilar("insert 1"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miPila.imprimir();

//         System.out.println("Insertar elemento en posicion 0");
//         if (miPila.apilar("insert 0"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miPila.imprimir();

//         System.out.println("Reset Pila");
//         miPila.inicializar();
//         miPila.imprimir();

//         System.out.println("Insertar elemento en posicion -1");
//         if (miPila.apilar("insert -1"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miPila.imprimir();

//         System.out.println("Insertar elemento en posicion 10");
//         if (miPila.apilar("insert 10"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miPila.imprimir();

//         System.out.println("Insertar elemento 'uno' en posicion 0");
//         if (miPila.apilar("uno"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miPila.imprimir();

//         System.out.println("Insertar elemento 'dos' en posicion 0");
//         if (miPila.apilar("dos"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miPila.imprimir();

//         System.out.println("Insertar elemento 'tres' en posicion 0");
//         if (miPila.apilar("tres"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miPila.imprimir();

//         System.out.println("Insertar elemento en posicion 1");
//         if (miPila.apilar("insert 1"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miPila.imprimir();

//         System.out.println("Insertar elemento en posicion 4");
//         if (miPila.apilar("insert 4"))
//             System.out.println("Se ha conseguido insertar");
//         else
//             System.out.println("No se ha conseguido insertar");
//         miPila.imprimir();
//     }
}
