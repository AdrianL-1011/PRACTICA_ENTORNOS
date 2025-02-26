
/**
 * 
 */

import java.time.LocalDate;
import java.util.Scanner;

/**
 * 
 */
public class ETAPA1 {
	/**
	 * 
	 * @param usuarios   matriz donde se almacenan los datos de los usuarios
	 * @param numusuario en que posicion se guardara el nuevo usuario
	 * @param eventos  para ver los eventos en el que se puede inscribir el usuario
	 * @param numeventos para ver cuantos eventos se han creado
	 * @return actualiza los datos del usuario
	 */
	public static int usuario(String[][] usuarios, int numusuario, String[][] eventos, int numeventos) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("¿Quieres cancelar el registro? (S/N)");
		String cancelar = teclado.nextLine();
		if (cancelar.equalsIgnoreCase("S")) {
			System.out.println("Registro cancelado.");
			return numusuario;
		}
		for (int i = 0; i < usuarios.length; i++) {
			if (i == 0) {
				while (true) {
					System.out.println("DNI DEL USUARIO (sin la letra)");
					int dni = teclado.nextInt();
					String dnifinal = String.valueOf(dni);
					if (!dnifinal.isEmpty()) {
						if (dnifinal.length() == 8) {
							System.out.println("LETRA DEL DNI");
							teclado.nextLine();
							char letra = teclado.nextLine().charAt(0);
							String letrafinal = String.valueOf(letra);
							if (letrafinal == letrafinal.toUpperCase()) {
								String resul = dnifinal.concat(letrafinal);
								usuarios[numusuario][0] = "DNI:" + resul.trim();
								break;
							} else {
								System.out.println("La letra tiene que estar en mayuscula");
							}
						} else {
							System.out.println("Tiene que tener 8 digitos");

						}
					} else if (dnifinal.isEmpty()) {
						System.out.println("DNI no puede estar vacío");
					}
				}

			}

			if (i == 1) {
				while (true) {
					System.out.println("NOMBRE DEL USUARIO");
					String nombre = teclado.nextLine();
					if (!nombre.isEmpty()) {
						String nombrefinal = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
						usuarios[numusuario][1] = "NOMBRE:" + nombrefinal.trim();
						break;
					} else if (nombre.isEmpty()) {
						System.out.println("Nombre no puede estar vacío");
					}
				}
			}
			if (i == 2) {
				while (true) {
					System.out.println("CORREO ELECTRONICO (no se te olvide poner @)");
					String correo = teclado.nextLine();
					int pos = correo.indexOf("@");
					if (!correo.isEmpty()) {
						if (pos != -1) {
							usuarios[numusuario][2] = "CORREO ELECTRONICO:" + correo.trim();
							break;
						} else {
							System.out.println("No tiene el @");
						}
					} else if (correo.isEmpty()) {
						System.out.println("Correo no puede estar vacío");
					}
				}
			}
			if (i == 3) {
				while (true) {
					System.out.println("CONTRASEÑA (Menos de 6 digitos)");
					int contraseña = teclado.nextInt();
					String finalcontraseña = String.valueOf(contraseña);
					if (!finalcontraseña.isEmpty()) {
						if (finalcontraseña.length() <= 6) {
							usuarios[numusuario][3] = "CONTRASEÑA:" + finalcontraseña.trim();
							break;
						} else {
							System.out.println("La contraseña tiene  menos de 6 digitos");
						}
					} else if (finalcontraseña.isEmpty()) {
						System.out.println("Contraseña no puede estar vacío");
					}
				}
			}
			if (i == 4) {
				System.out.println("EVENTOS QUE SE PUEDE INCRIBIR:");
				for (int j = 0; j < numeventos; j++) {
					System.out.println(eventos[j][1]);
					teclado.nextLine();
				}
				while (true) {
					if (numeventos == 1) {
						System.out.println("Escriba el nombre del evento");
						String eventoElegido = teclado.nextLine().trim();
						boolean encontrado = false;
						for (int j = 0; j < numeventos; j++) {
							if (eventos[j][1].equalsIgnoreCase("NOMBRE DEL EVENTO:" + eventoElegido)) {
								usuarios[numusuario][2] = "ESTA INSCRITO AL EVENTO:"
										+ eventoElegido.replace("NOMBRE DEL EVENTO:", "");
								encontrado = true;
								break;
							}
						}

						if (encontrado) {
							break;
						} else {
							System.out.println("Evento no encontrado, intente de nuevo.");
						}

					} else {
						System.out.println("No hay eventos");
						break;
					}
				}
			}
		}
		return numusuario + 1;

	}
}
