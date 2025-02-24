import java.util.Scanner;

public class ETAPA1 {
	/**
	 * 
	 * @param usuarios matriz donde se almacenan los datos de los usuarios
	 * @param numusuario en que posicion se guardara el nuevo usuario
	 * @return actualiza los datos del usuario
	 */
	public static int usuario(String[][] usuarios, int numusuario) {
		Scanner teclado = new Scanner(System.in);
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
					} else if (finalcontraseña == null || finalcontraseña.isEmpty()) {
						System.out.println("Contraseña no puede estar vacío");
					}
				}
			}
		}
		return numusuario + 1;
	}
}

