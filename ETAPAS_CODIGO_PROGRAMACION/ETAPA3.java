import java.util.Scanner;

public class ETAPA3 {

	/**
	 * 
	 * @param organizadoresmatriz donde se almacenan los datos de los organizadores
	 * @param numorganizadores en que posicion se guardara el nuevo organizador
	 * @return actualiza los datos del organizador
	 */
	public static int organizador(String[][] organizadores, int numorganizadores) {
		Scanner teclado = new Scanner(System.in);
		for (int i = 0; i < organizadores.length; i++) {
			if (i == 0) {
				while (true) {
					String cod = "COD-";
					System.out.println("CODIGO DEL ORGANIZADOR");
					String codigoOrganizador = teclado.nextLine();
					if (!codigoOrganizador.isEmpty()) {
						organizadores[numorganizadores][0] = "CODIGO DEL ORGANIZADOR:" + cod.concat(codigoOrganizador);
						break;
					} else if (codigoOrganizador.isEmpty()) {
						System.out.println("El codigo del organizador esta vacío");
					}
				}
			}
			if (i == 1) {
				while (true) {
					System.out.println("NOMBRE DEL ORGANIZADOR");
					String nombre = teclado.nextLine();
					if (!nombre.isEmpty()) {
						String nombrefinal = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
						organizadores[numorganizadores][1] = "NOMBRE:" + nombrefinal.trim();
						break;
					} else if (nombre.isEmpty()) {
						System.out.println("El nombre esta vacío");
					}
				}
			}
			if (i == 2) {
				while (true) {
					String num = "(+34)";
					System.out.println("TELEFONO DEL ORGANIZADOR");
					int telefono = teclado.nextInt();
					String telefonofinal = String.valueOf(telefono);
					telefonofinal = telefonofinal.trim();
					if (!telefonofinal.isEmpty()) {
						if (telefonofinal.length() == 9) {
							organizadores[numorganizadores][2] = "TELEFONO:" + num.concat(telefonofinal);
							break;
						} else {
							System.out.println("El numero de telefono tiene que tener 9 digitos");
						}
					} else if (telefonofinal.isEmpty()) {
						System.out.println("El número de telefono esta vacío");
					}
				}
			}
			if (i == 3) {
				while (true) {
					System.out.println("CORREO DEL ORGANIZADOR (no se te olvide poner @)");
					teclado.nextLine();
					String correo = teclado.nextLine();
					if (!correo.isEmpty()) {
						int pos = correo.indexOf("@");
						if (pos != -1) {
							organizadores[numorganizadores][3] = "CORREO ELECTRONICO:" + correo.trim();
							break;
						} else {
							System.out.println("No tiene el @");
						}
					} else if (correo.isEmpty()) {
						System.out.println(" El correo electronico no puede estar vacío");
					}
				}
			}
			if (i == 4) {
				while (true) {
					System.out.println("Los organizadores son una Empresa o Institución");
					String tipo = teclado.nextLine();
					String tipofinal = tipo.substring(0, 1).toUpperCase() + tipo.substring(1);
					if (!tipo.isEmpty()) {
						if (tipofinal.equals("Empresa") || tipofinal.equals("Institución")) {
							organizadores[numorganizadores][4] = tipofinal;
							break;
						} else {
							System.out.println("Tiene que poner que sea Empresa o Institución");
						}
					} else if (tipo.isEmpty()) {
						System.out.println("El tipo de organizador esta vacío");
					}
				}
			}
		}
		return numorganizadores + 1;
	}
}