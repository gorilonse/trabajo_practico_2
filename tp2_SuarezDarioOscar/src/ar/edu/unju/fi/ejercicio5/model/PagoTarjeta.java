package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {

	private String numeroTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;
	
	@Override
	public void realizarPago(double monto) {
		// TODO Auto-generated method stub
		this.fechaPago = LocalDate.now();
		this.montoPagado = monto * 1.15;
	}

	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		System.out.println( 
				"Número de tarjeta: "+numeroTarjeta + "\n"
				+ "Fecha de pago: "+ fechaPago + "\n"
				+ "Monto pagado: "+montoPagado);
	}
	
	
	
	//Metodos accesores

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}
	

}
