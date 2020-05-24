package cuentabancaria;
/**Interfaz TarjetaCredito donde creamos los metodos usados en el constructor (CuentaBancaria)
 *  para pasar filtros a la hora de sacar dinero de la cuenta del sistema

@author Roberto Tajuelo y David Gomez.

@version 1.0.0
*/
public interface TarjetaCredito {
	public boolean SacarDineroTarjeta(int retirar);
	public boolean PagosInternet(int retirar);
}


