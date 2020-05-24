package cuentabancaria;

import java.util.ArrayList;
import java.util.Scanner;

/**Clase Main del ejercicio, en la cual simulamos  una terminal de un sistema bancario para
 *  ingresar cuentas y acceder, modificar, ingresar dinero o sacar dinero de dichas cuentas
 *  dentro de un bucle permanente hasta que pase una simulacion de 12 meses, mostremos la información de la cuenta o
 *  salgamos forzadamente de dicho sistema

@author Roberto Tajuelo y David Gomez

@version 1.1.0
*/
public class CMain {
	
	public static void main(String[] args) {
		System.out.println("Bancos David-Roberto & company le agradece la depositacion de confianza sobre sus sistemas");
		Scanner teclado = new Scanner(System.in);
		String nombre = "";
		String apellido = "";
		String direccion = "";
		String DNI = "";
		
		int telefono = 0;
		int edad = 0;
		
		double saldo = 2000.50;
		
		int mes = 12;
		
		//Codigo debug (por el error de scanner entre int y String
		String debug = "";
		
		
		//Opcion de eleccion
		int eleccion = 0; //Eleccion del menu principal
		int eleccion1 = 0; //Eleccion de creacion de cuenta
		int eleccion2 = 0; //Eleccion de saldo
		int eleccion3 = 0; //Eleccion de metodo de pago
		int eleccion4 = 0; //Eleccion de modificaciones de cuenta
		
		//contraseña de gestion
		String ingresoContraseña = "";
		int fallos = 0;
		boolean contraseñaAcertada = false;
		
		// variables de cambio de valores en la gestion de cuentas
		String cambio1;
		int cambio2;
		double cambio3;
		
		//Contador de cuentas
		int maximo = 0;
		int ContadorCuenta = 0;
		
		//variables de pago
		int numTransacciones = 1; //numero de acciones realizadas en pago o ingreso
		double SaldoMaximo = 0; // Variable en la cual guardamos todo el saldo que queda en la cuenta a lo largo de los 12 meses
		
		//ArrayList cuentas
		System.out.println("¿Cuantas cuentas desea añadir o modificar COMO MAXIMO al sistema?");
		maximo = teclado.nextInt();
		CuentaBancaria [] cuentas = new CuentaBancaria [maximo];
		
		//Comienzo del codigo
		for(int i = 0; i < mes;) {
			//variable de bucle
			boolean salir = false;
			boolean añoCompleto = false;
			if (añoCompleto == true) { /*Tras ingresar una cuenta en el sistema,
										se guardan aqui todo el saldo de una cuenta durante los ultimos 12 meses, sacando la media por mes*/
				double saldoMedio = SaldoMaximo / 12;
				System.out.println("El saldo medio de todo el año ha sido " + saldoMedio);
				salir = true;
			}
			while (salir == false) {/*While que recorre todo el sistema para hacer las gestiones sobre terminal,
			 						  se cerrara el while en el caso de cambio de mes o forzosamente con "Salir del sistema"*/
				
				
				System.out.println("Por favor, introduzca en la terminal la opcion que mas le interese por medio del numero.");
				System.out.println("======================================================================================");
				System.out.println("1. Crear cuenta\n");
				System.out.println("2. Sacar / Ingresar dinero\n");
				System.out.println("En caso de querer gestionar una cuenta:\n");
				System.out.println("3. Modificar datos (requiere contraseña de administrador)\n");
				System.out.println("4. Cambiar de mes\n");
				System.out.println("5. Salir del sistema\n");
				
				eleccion = teclado.nextInt();
				
				if (eleccion == 1) {
					System.out.println("===================================================================");
					System.out.println("Aqui puede crear una cuenta nueva, o bien volver al menu anterior");
					System.out.println("1.Crear cuentas");
					System.out.println("2. Volver al menu anterior");
					  
					eleccion1 = teclado.nextInt();
					
					if(eleccion1 == 1) {
						
						if (ContadorCuenta > maximo) { //Comprobante de que la cantidad de cuentas actuales en el sistema no es mayor al maximo de cuentas establecido
							System.out.println("No se pueden añadir mas cuentas al banco");
							continue;
						}
						System.out.println("Introduzca los datos de la nueva cuenta");
						debug = teclado.nextLine(); //Codigo debug para saltar en ejecucion el error del cambio del Scanner entre nextInt y nextLine
						System.out.println("Nombre: "); nombre = teclado.nextLine();
						System.out.println("Apellido: "); apellido = teclado.nextLine();
						System.out.println("Direccion: "); direccion = teclado.nextLine();
						System.out.println("DNI: "); DNI = teclado.nextLine();
						if(DNI.length() > 9 || DNI.length() < 9 ) {
							System.out.println("Numero de caracteres erroneo");
							continue;
						}
						System.out.println("Telefono: "); telefono = teclado.nextInt();
						System.out.println("Edad: "); edad = teclado.nextInt();
						double ingresosaldo = saldo;
						cuentas[ContadorCuenta] = new CuentaBancaria(nombre,apellido,direccion,DNI,telefono,edad,ingresosaldo);
					}
					
					if(eleccion1 == 2) {
						continue;
					}
					ContadorCuenta++;
					
				}//eleccion 1 (introduccion de cuenta)
				
				if (eleccion == 2) {
					System.out.println("===================================================================");
					System.out.println("Aqui puede sacar o ingresar dinero, con sus distintas opciones, o bien volver al menu anterior");
					System.out.println("Dime el numero de la cuenta (Hueco de Array que ocupa)");
					int numeroCuenta = teclado.nextInt();
					System.out.println("1.Sacar dinero");
					System.out.println("2.Introducir dinero");
					System.out.println("3. Volver al menu anterior");
					eleccion2 = teclado.nextInt();
					
						if (eleccion2 == 1) {
							System.out.println("¿Hara el pago online o con tarjeta?");
							System.out.println("1. Online");
							System.out.println("2. Tarjeta");
							eleccion3 = teclado.nextInt();
							if (eleccion3 == 1) {
								System.out.println("¿Cuanto dinero quiere sacar?");
								numTransacciones++;
								int dinero = teclado.nextInt();
								cuentas[numeroCuenta].PagosInternet(dinero);
								SaldoMaximo = SaldoMaximo + cuentas[numeroCuenta].getpSaldo(); //Para poder ver el saldo medio de la cuenta tras pasar los 12 meses
								
							}
							
							if (eleccion3 == 2) {
								System.out.println("¿Cuanto dinero quiere sacar?");
								numTransacciones++;
								int dinero = teclado.nextInt();
								cuentas[numeroCuenta].SacarDineroTarjeta(dinero);
								SaldoMaximo = SaldoMaximo + cuentas[numeroCuenta].getpSaldo(); //Para poder ver el saldo medio de la cuenta tras pasar los 12 meses
							}	
						}
						
						if (eleccion2 == 2) {
							System.out.println("¿Cuanto quiere introducir?");
							int dinero = teclado.nextInt();
							cuentas[numeroCuenta].setpSaldo(cuentas[numeroCuenta].pSaldo + dinero);
							System.out.println("Introduces en la cuenta el siguiente dinero : "+dinero+
									" Lo cual te deja con un total de "+ cuentas[numeroCuenta].getpSaldo());
							SaldoMaximo = SaldoMaximo + cuentas[numeroCuenta].getpSaldo(); //Para poder ver el saldo medio de la cuenta tras pasar los 12 meses
						}
						if (eleccion2 == 3) {
							continue;
						}
						
					
				}//eleccion 2 (sacar / ingresar)
				if (eleccion == 3) { 
					while (contraseñaAcertada == false && fallos <= 3) {
						System.out.println("Por favor, ingrese la contraseña del sistema");
						if (fallos == 0) {
							debug = teclado.nextLine(); //Se encierra dentro de un if para que se ejecute solo en la primera vuelta
						}
						ingresoContraseña = teclado.nextLine();
						
						if (ingresoContraseña.equals("admin")) { //La contraseña de ingreso sera admin
							contraseñaAcertada = true;
							System.out.println("===================================================================");
							System.out.println("Bienvenido a la consola de operador\n");
							System.out.println("Dime el numero de la cuenta");
							int numeroCuenta = teclado.nextInt();
							
							System.out.println("1.Cambiar nombre");
							System.out.println("2.Cambiar apellido");
							System.out.println("3.Cambiar direccion");
							System.out.println("4.Cambiar DNI");
							System.out.println("5.Cambiar Telefono");
							System.out.println("6.Cambiar Edad");
							System.out.println("7.Cambiar Saldo");
							System.out.println("8. Ver el perfil del usuario");
							
							eleccion4 = teclado.nextInt();
							if (eleccion4 == 1) {
								System.out.println("Introduce el nombre nuevo");
								cambio1 = teclado.nextLine();
								cuentas[numeroCuenta].setpNombre(cambio1);
							}
						    if (eleccion4 == 2) {
								System.out.println("Introduce el apellido nuevo");
								cambio1 = teclado.nextLine();
								cuentas[numeroCuenta].setpApellido(cambio1);
							}
							if (eleccion4 == 3) {
								System.out.println("Introduce la dirección nueva");
								cambio1 = teclado.nextLine();
								cuentas[numeroCuenta].setpDireccion(cambio1);
							}
							if (eleccion4 == 4) {
								System.out.println("Introduce el DNI nuevo");
								cambio1 = teclado.nextLine();
								if(cambio1.length() > 8 || cambio1.length() < 8 ) {
									System.out.println("Numero de caracteres erroneo");
									continue;
								}
								cuentas[numeroCuenta].setpDNI(cambio1);
							}
							if (eleccion4 == 5) {
								System.out.println("Introduce el telefono nuevo");
								cambio2 = teclado.nextInt();
								cuentas[numeroCuenta].setpTelefono(cambio2);
							}
							if (eleccion4 == 6) {
								System.out.println("6.Introduce la nueva Edad");
								cambio2 = teclado.nextInt();
								cuentas[numeroCuenta].setpEdad(cambio2);
							}
							if (eleccion4 == 7) {
								System.out.println("7.Introduce el nuevo saldo");
								cambio3 = teclado.nextDouble();
								cuentas[numeroCuenta].setpSaldo(cambio3);
								
							}
							
							if(eleccion4 == 8) {
								System.out.println("Nombre: "+cuentas[numeroCuenta].getpNombre());
								System.out.println("Apellido: "+cuentas[numeroCuenta].getpApellido());
								System.out.println("Direccion: "+cuentas[numeroCuenta].getpDireccion());
								System.out.println("DNI: "+cuentas[numeroCuenta].getpDNI());
								System.out.println("Telefono: "+cuentas[numeroCuenta].getpTelefono());
								System.out.println("Edad: "+cuentas[numeroCuenta].getpEdad());
								System.out.println("Saldo: "+cuentas[numeroCuenta].getpSaldo());
								System.out.println("====================================================");
							}
							
						}
						else {
							System.out.println("===================================================================");
							System.out.println("Contraseña fallida");
							fallos++;
						}
						
						if (fallos == 3) {
							System.out.println("Se ha dado un aviso a seguridad, esta terminal se cerrara");
							System.exit(0);
							
						}
					}//while logeo fallido
						
				}//eleccion 3 (acceder a la modificacion de cuenta)
				
				if (eleccion == 4) {
					System.out.println("Termina el mes " + i +".");
					if (i == 12) { //Al llegar a los 12 meses, la variable se vuelve true, finalizando el programa y sacando por pantalla (si hubiera cuentas activas) los sueldos medios.
						añoCompleto = true;
					}
					i++;
					salir = true; //activando esta boolean, salimos del While
					
				}
				
				if (eleccion == 5) {
					System.out.println("===================================================================");
					System.out.println("Gracias por usar nuestro sistema. Pase un buen dia.");
					System.exit(0); //Cierre del sistema
				}
				
			}//While
			System.out.println("El numero de acciones durante este mes, ha sido de "+numTransacciones+".");
			
		}//for
	}
}
