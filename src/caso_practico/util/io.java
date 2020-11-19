package caso_practico.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class io {

    public static int leerInt(String msg) {
        System.out.println(msg);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String resp;
        try {
            resp = in.readLine();
            return Integer.parseInt(resp);
        } catch (NumberFormatException | IOException e) {
            System.out.println("Entrada no permitida");
            return leerInt(msg);
        }
    }

    public static int leerInt(String msg, int defecto) {
        System.out.println(msg);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String resp;
        try {
            resp = in.readLine();
            if (resp.equals(""))
                return defecto;
            return Integer.parseInt(resp);
        } catch (NumberFormatException | IOException e) {
            System.out.println("Entrada no permitida");
            return leerInt(msg, defecto);
        }
    }

    public static String leerString(String msg) {
        System.out.println(msg);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            return in.readLine();
        } catch (NumberFormatException | IOException e) {
            System.out.println("Entrada no permitida");
            return leerString(msg);
        }
    }

    public static String leerString(String msg, String defecto) {
        System.out.println(msg);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String resp;
        try {
            resp = in.readLine();
            if (resp.equals(""))
                return defecto;
            return resp;
        } catch (NumberFormatException | IOException e) {
            System.out.println("Entrada no permitida");
            return leerString(msg);
        }
    }
    
	public static void esperarUsuario() {
		io.leerString("- pulse ENTER para continuar -");
		System.out.println();
	}

}
