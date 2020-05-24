package cuentabancaria;

/**Clase CuentaBancaria donde creamos las cuentas de la sesion en el sistema y introducimos los datos personales de cada cuenta

@author Roberto Tajuelo y David Gomez

@version 1.0.0
*/

public class CuentaBancaria implements TarjetaCredito {
	String pNombre;
	String pApellido;
	String pDireccion;
	String pDNI;
	int pTelefono;
	int pEdad;
	double pSaldo;
	String pFechaCreacion;
	
	/**Esta clase cuenta con un constructor, con las propiedades de pNombre, pApellido, pDireccion, pDNI, pTelefono, pEdad, pSaldo y pFechaCreacion,
	 * para permitir la modificacion de cada dato personal de cada titular de cuenta en casos de prueba aislados.
	 * @param iNombre Parametro que pasamos por el main refiriendonos con una string al nombre del dueño de la cuenta.
	 * @param iApellido Parametro que pasamos por el main refiriendonos con una string al apellido del dueño de la cuenta.
	 * @param iDireccion Parametro que pasamos por el main refiriendonos con una string a la direccion fisica del dueño de la cuenta.
	 * @param iDNI Parametro que pasamos por el main refiriendonos con una string al numero de identificacion del dueño de la cuenta.
	 * @param iTelefono Parametro que pasamos por el main refiriendonos con un int al numero telefonico del dueño de la cuenta.
	 * @param iEdad Parametro que pasamos por el main refiriendonos con un int a la Edad del dueño de la cuenta.
	 * @param iSaldo Parametro de numero doble que muestra la cantidad de saldo que posee la cuenta 
	 * sera modficiado conforme se añada o se retire salario o se solicite la modificacion de alguno de los datos.*/

	public CuentaBancaria(String iNombre, String iApellido, String iDireccion, String iDNI, int iTelefono, int iEdad, double iSaldo){
		pNombre = iNombre;
		pApellido = iApellido;
		pDireccion = iDireccion;
		pDNI = iDNI;
		pTelefono = iTelefono;
		pEdad = iEdad;
		pSaldo = iSaldo;
	}

	//Getters y Setters 
	
	public String getpNombre() {
		return pNombre;
	}

	public void setpNombre(String pNombre) {
		this.pNombre = pNombre;
	}

	public String getpApellido() {
		return pApellido;
	}

	public void setpApellido(String pApellido) {
		this.pApellido = pApellido;
	}

	public String getpDireccion() {
		return pDireccion;
	}

	public void setpDireccion(String pDireccion) {
		this.pDireccion = pDireccion;
	}

	public String getpDNI() {
		return pDNI;
	}

	public void setpDNI(String pDNI) {
		this.pDNI = pDNI;
	}

	public int getpTelefono() {
		return pTelefono;
	}

	public void setpTelefono(int pTelefono) {
		this.pTelefono = pTelefono;
	}

	public int getpEdad() {
		return pEdad;
	}

	public void setpEdad(int pEdad) {
		this.pEdad = pEdad;
	}

	public double getpSaldo() {
		return pSaldo;
	}

	public void setpSaldo(double pSaldo) {
		this.pSaldo = pSaldo;
	}
	
	
	public String getpFechaCreacion() {
		return pFechaCreacion;
	}

	public void setpFechaCreacion(String pFechaCreacion) {
		this.pFechaCreacion = pFechaCreacion;
	}

	//Metodos Interfaz
	
	/**Metodo SacarDineroTarjeta, en este metodo lo que estamos haciendo es pasar dos comprobantes, en el primero nos aseguramos de que el
	 * saldo de la cuenta es siempre superior a 0 y que la cantidad que queremos retirar es menor que la cantidad maxima de dinero que tenemos en cuenta
	 * (ambos antes de realizar la transaccion), y el segundo comprobante seria un limitador a 500 euros de la cuenta por transaccion. Una vez realizado, se resta 
	 * la cifra solicitada de la cuenta y se escribe por la pantalla el dinero retirado y el dinero total que queda en cuenta. En caso de que no se pueda realizar 
	 * se escribe un mensaje por pantalla dando aviso de falta de dinero.
	 *  @param retirar Sera el parametro usado para retirar el valor de saldo (que en el Main sera modificado por simplemente "Saldo".
	 *  @return sacar Recoge el valor booleano que permite pasar los test. */
	@Override
	public boolean SacarDineroTarjeta(int retirar) {
		boolean sacar = false;
		if (pSaldo > 0 && retirar <= pSaldo) {
			if (retirar <= 500) {
				sacar = true;
				pSaldo = pSaldo - retirar;
				System.out.println("Sacas de la cuenta el siguiente dinero : "+retirar+
									" Lo cual te deja con un total de "+ pSaldo);
			}
			else {
				System.out.println("No puedes retirar tanto dinero con la tarjeta");
			}	
		}
		else {
			System.out.println("No queda dinero en la cuenta");
		}
		return sacar;
	}

	/**Metodo PagosInternet, como en el anterior metodo, pasamos dos comprobantes, en el primero nos aseguramos de que el
	 * saldo de la cuenta es siempre superior a 0 y que la cantidad que queremos retirar es menor que la cantidad maxima de dinero que tenemos en cuenta
	 * (ambos antes de realizar la transaccion), y el segundo comprobante seria un limitador a 300 euros de la cuenta por transaccion. Una vez realizado, se resta 
	 * la cifra solicitada de la cuenta y se escribe por la pantalla el dinero retirado y el dinero total que queda en cuenta. En caso de que no se pueda realizar 
	 * se escribe un mensaje por pantalla dando aviso de falta de dinero para la transaccion online.
	 *  @param retirar Sera el parametro usado para retirar el valor de saldo (que en el Main sera modificado por simplemente "Saldo".
	 *  @return sacar Recoge el valor booleano que permite pasar los test. */
	@Override
	public boolean PagosInternet(int retirar) {
		boolean sacar = false;
		if (pSaldo > 0 && retirar <= pSaldo) {
			if (retirar <= 300) {
				 sacar = true;
				pSaldo = pSaldo - retirar;
				System.out.println("Pagas online de la cuenta el siguiente dinero : "+retirar+
									" Lo cual te deja con un total de "+ pSaldo);
				
			}
			else {
				System.out.println("No puedes pagar tanto dinero online");
			}
		}
		else {
			System.out.println("No queda dinero en la cuenta");
		}
		return sacar;
	}
	
}
