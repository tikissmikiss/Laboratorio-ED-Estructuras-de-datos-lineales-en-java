package caso_practico;

import caso_practico.util.io;

public class UI {
	private Jugador[] jugadores;
	private Partida p;

	private static UI ui;

	private UI() {
	}

	public static UI iniciarUI() {
		if (ui == null)
			ui = new UI();
		return ui;
	}

	public void setJugadores() {
		// Jugador[] jugadores = new Jugador[setNumeroJugadores()];
		// Jugador[] jugadores = partida.getJugadores();
		for (int i = 0; i < ui.jugadores.length; i++) {
			ui.jugadores[i] = new Jugador(io.leerString("[Jugador " + (i + 1) + "]: ¿Cual es tu nombre?",
					"Juagador " + (i + 1)));
			System.out.println("Buena suerte " + ui.jugadores[i].getNombre() + " !!!\n");
		}
		p.setJugadores(ui.jugadores);
	}

	public void iniciarPartida() {
		if (ui == null)
			ui = new UI();
		int n = setNumeroJugadores();
		// partida = Partida.;
		// ui.marcador = new Marcador(n);
		ui.jugadores = new Jugador[n];
		p = Partida.iniciarPartida(ui.jugadores);
	}

	public Baraja setBaraja() {
		return Baraja.setBaraja(setPalos(), setFiguras());
	}

	private static int setNumeroJugadores() {
		int fig = io.leerInt("¿Cuantos jugadores jugaran la partida? [2-6] (por defecto 6)", 6);
		if (fig < 2 || fig > 6) {
			System.out.println("Valor no permitido !!!");
			fig = setFiguras();
		}
		return fig;
	}

	private static int setFiguras() {
		int fig = io.leerInt("¿Cuantas figuras tendra la baraja? [4-13] (por defecto 13)", 13);
		if (fig < 4 || fig > 13) {
			System.out.println("Valor no permitido !!!");
			fig = setFiguras();
		}
		return fig;
	}

	private static int setPalos() {
		int palos = io.leerInt("¿Cuantos palos tendra la baraja? [2-8] (por defecto 8)", 8);
		if (palos < 2 || palos > 8) {
			System.out.println("Valor no permitido !!!");
			palos = setPalos();
		}
		return palos;
	}

	public void esperarUsuario() {
		io.leerString("- pulse ENTER para continuar -");
		System.out.println();
	}

	// public UI(Marcador marcador, Partida partida) {
	// this.marcador = marcador;
	// this.partida = partida;
	// }

}
