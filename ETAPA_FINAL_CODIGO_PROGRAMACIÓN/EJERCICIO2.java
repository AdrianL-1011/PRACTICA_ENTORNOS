
/**
 * 
 */

import java.time.LocalDate;
import java.util.Scanner;

/**
 * 
 */
public class EJERCICIO2 {

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

	public static int evento(String[][] eventos, int numeventos) {
		Scanner teclado = new Scanner(System.in);
		for (int i = 0; i < eventos.length; i++) {
			if (i == 0) {
				while (true) {
					String cod = "COD-";
					System.out.println("CODIGO DEL EVENTO");
					int codigoEvento = teclado.nextInt();
					String finalcodigo = String.valueOf(codigoEvento);
					if (!finalcodigo.isEmpty()) {
						eventos[numeventos][0] = "CODIGO EVENTO:" + cod.concat(finalcodigo);
						break;
					} else if (finalcodigo.isEmpty()) {
						System.out.println("Codigo del evento no puede estar vacío");
					}
				}
			}
			if (i == 1) {
				while (true) {
					System.out.println("NOMBRE DEL EVENTO");
					teclado.nextLine();
					String nombre = teclado.nextLine();
					if (!nombre.isEmpty()) {
						String nueva = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
						eventos[numeventos][1] = "NOMBRE:" + nueva.trim();
						break;
					} else if (nombre == null || nombre.isEmpty()) {
						System.out.println("Nombre no puede estar vacío");
					}
				}
			}
			if (i == 2) {
				while (true) {
					System.out.println("LUGAR DEL EVENTO");
					String lugar = teclado.nextLine();
					String calle = "Cl.";
					if (!lugar.isEmpty()) {
						String lugarfinal = lugar.substring(0, 1).toUpperCase() + lugar.substring(1);
						eventos[numeventos][2] = "LUGAR:" + calle.concat(lugarfinal);
						break;
					} else if (lugar.isEmpty()) {
						System.out.println("Lugar del evento no puede estar vacío");
					}
				}
			}
			if (i == 3) {
				while (true) {
					System.out.println("FECHA:");
					System.out.println("DIA:");
					int dia = teclado.nextInt();
					if (dia <= 31) {
						System.out.println("MES:");
						int mes = teclado.nextInt();
						if (mes <= 12) {
							System.out.println("AÑO:");
							int año = teclado.nextInt();
							if (año <= 2026) {
								System.out.println(año + "/" + mes + "/" + dia);
								LocalDate fecha = LocalDate.of(año, mes, dia);
								String fechafinal = String.valueOf(fecha);
								if (!fechafinal.isEmpty()) {
									if (LocalDate.now().isBefore(fecha)) {
										eventos[numeventos][3] = "FECHA:" + fechafinal;
										break;
									} else {
										System.out.println("La fecha es menor a la fecha actual");
									}
								} else {
									System.out.println("Esta vacio la fecha");
								}
							} else {
								System.out.println("El año no puede ser mayor a 2026");
							}

						} else {
							System.out.println("El mes no puede ser mayor que 12");
						}
					} else {
						System.out.println("El dia no puede ser mayor que 31");
					}
				}
			}
			if (i == 4) {
				System.out.println("DURACION DEL EVENTO");
				int duracion = teclado.nextInt();
				teclado.nextLine();
				System.out.println("MINUTOS O HORAS");
				String tiempo = teclado.nextLine();
				tiempo = tiempo.toUpperCase();
				if (tiempo.equals("MINUTOS")) {
					int horas = duracion / 60;
					int minutosRestantes = duracion % 60;
					eventos[numeventos][4] = "DURACION:" + horas + ":" + minutosRestantes;
				}
				if (tiempo.equals("HORAS")) {
					eventos[numeventos][4] = "DURACION:" + duracion + "horas";

				}
			}

			if (i == 5) {
				while (true) {
					System.out.println("El evento va a ser un Taller o Conferencia");
					String tipo = teclado.nextLine();
					String tipofinal = tipo.substring(0, 1).toUpperCase() + tipo.substring(1);
					if (!tipo.isEmpty()) {
						if (tipofinal.equals("Taller") || tipofinal.equals("Conferencia")) {
							eventos[numeventos][5] = "TIPO DE EVENTO:" + tipofinal;
							break;
						} else {
							System.out.println("Tienes que escribir taller o conferencia");
						}
					} else if (tipo.isEmpty()) {
						System.out.println("El tipo de evento está vacío");
					}
				}
			}
		}
		return numeventos + 1;
	}

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
				usuario(usuarios, contadorUsuarios);
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
				organizador(organizadores, contadorOrganizadores);
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
				evento(eventos, contadorEventos);
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




