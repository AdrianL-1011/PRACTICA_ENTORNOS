import java.util.Scanner;

public class ETAPA4 {

	/**
	 * 
	 * @param Permite elegir entrar como usuario o organizador para registrar los datos
	 * @param Permite elegir si quieres  añadir solo un usuario o organizador, o quieres añadir más más
	 * @param args Argumento de línea de comandos.
	 */
	public static void main(String[] args) {
		int maxUsuarios = 10;
		int maxEventos = 5;
		int maxOrganizadores = 5;
		String[][] usuarios = new String[maxUsuarios][4];
		String[][] eventos = new String[maxEventos][6];
		String[][] organizadores = new String[maxOrganizadores][5];
		int contadorUsuarios = 0;
		int contadorEventos = 0;
		int contadorOrganizadores = 0;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Con que usuario quieres entrar:");
		System.out.println("USUARIO O ORGANIZADOR");
		String tipousuario = teclado.nextLine();
		tipousuario = tipousuario.toUpperCase();
		if (tipousuario.equals("USUARIO")) {
			while (contadorUsuarios <= maxUsuarios) {
				ETAPA1.usuario(usuarios, contadorUsuarios);
				contadorUsuarios++;
				System.out.println("¿Deseas agregar otro usuario? (S/N)");
				String respuesta = teclado.nextLine();
				if (respuesta.equalsIgnoreCase("N")) {
					break;
				}
			}
			System.out.println("Datos del Usuario:");
			for (int i = 0; i < contadorUsuarios; i++) {
				for (String u : usuarios[i]) {
					if (u != null) {
						System.out.println(u);
					}

				}
			}
		}

		if (tipousuario.equals("ORGANIZADOR")) {
			while (contadorOrganizadores < maxOrganizadores) {
				ETAPA3.organizador(organizadores, contadorOrganizadores);
				contadorOrganizadores++;
				System.out.println("¿Deseas agregar otro usuario? (S/N)");
				String respuesta = teclado.nextLine();
				if (respuesta.equalsIgnoreCase("N")) {
					break;
				}
			}
			System.out.println("Datos del Organizador:");
			for (int i = 0; i < contadorOrganizadores; i++) {
				for (String o : organizadores[i]) {
					if (o != null) {
						System.out.println(o);
					}
				}
			}
			while (contadorEventos < maxEventos) {
				ETAPA2.evento(eventos, contadorEventos);
				contadorEventos++;
				System.out.println("¿Deseas agregar otro usuario? (S/N)");
				String respuesta = teclado.nextLine();
				if (respuesta.equalsIgnoreCase("N")) {
					break;
				}
			}
			System.out.println("Datos del Evento:");
			for (int i = 0; i < contadorEventos; i++)
				for (String e : eventos[i]) {
					if (e != null) {
						System.out.println(e);
					}
					teclado.close();
				}
		}
	}
}




