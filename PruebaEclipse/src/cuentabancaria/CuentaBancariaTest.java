package cuentabancaria;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.Test;


public class CuentaBancariaTest {
	@Test
	public void RetirarTarjetaMayorLimite(){
		CuentaBancaria objetocuenta = new CuentaBancaria("David","Gomez","calle falsa","12345678A",722239708,18,1500);
		assertFalse(objetocuenta.SacarDineroTarjeta(501));
	}
	
	@Test
	public void RetirarTarjetaMenorLimite(){
		CuentaBancaria objetocuenta = new CuentaBancaria("David","Gomez","calle falsa","12345678A",722239708,18,1500);
		assertTrue(objetocuenta.SacarDineroTarjeta(500));
	}
	@Test
	public void RetirarTarjetaSinSaldo(){
		CuentaBancaria objetocuenta = new CuentaBancaria("David","Gomez","calle falsa","12345678A",722239708,18,300);
		assertFalse(objetocuenta.SacarDineroTarjeta(400));
	}
	@Test
	public void RetirarTarjetaConSaldo(){
		CuentaBancaria objetocuenta = new CuentaBancaria("David","Gomez","calle falsa","12345678A",722239708,18,500);
		assertTrue(objetocuenta.SacarDineroTarjeta(400));
	}
	@Test
	public void RetirarTarjetaCuentaVacia(){
		CuentaBancaria objetocuenta = new CuentaBancaria("David","Gomez","calle falsa","12345678A",722239708,18,0);
		assertFalse(objetocuenta.SacarDineroTarjeta(1));
	}
	
	

	@Test
	public void RetirarInternetMayorLimite(){
		CuentaBancaria objetocuenta = new CuentaBancaria("David","Gomez","calle falsa","12345678A",722239708,18,1500);
		assertFalse(objetocuenta.PagosInternet(301));
	}
	
	@Test
	public void RetirarInternetMenorLimite(){
		CuentaBancaria objetocuenta = new CuentaBancaria("David","Gomez","calle falsa","12345678A",722239708,18,1500);
		assertTrue(objetocuenta.PagosInternet(300));
	}
	
	@Test
	public void RetirarInternetSinSaldo(){
		CuentaBancaria objetocuenta = new CuentaBancaria("David","Gomez","calle falsa","12345678A",722239708,18,100);
		assertFalse(objetocuenta.PagosInternet(200));
	}
	@Test
	public void RetirarInternetConSaldo(){
		CuentaBancaria objetocuenta = new CuentaBancaria("David","Gomez","calle falsa","12345678A",722239708,18,500);
		assertTrue(objetocuenta.PagosInternet(100));
	}
	@Test
	public void RetirarInternetCuentaVacia(){
		CuentaBancaria objetocuenta = new CuentaBancaria("David","Gomez","calle falsa","12345678A",722239708,18,0);
		assertFalse(objetocuenta.PagosInternet(1));
	}
}