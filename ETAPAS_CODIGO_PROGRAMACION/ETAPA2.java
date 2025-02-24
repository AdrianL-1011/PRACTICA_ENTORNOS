import java.time.LocalDate;
import java.util.Scanner;

public class ETAPA2 {
	/**
	 * 
	 * @param eventos matriz donde se almacenan los datos del evento
	 * @param numeventos en que posicion se guardara el nuevo evento
	 * @return actualiza los datos del evento
	 */
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

}
