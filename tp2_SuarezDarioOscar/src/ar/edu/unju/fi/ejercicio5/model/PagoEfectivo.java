package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {

	private double montoPagado;
	private LocalDate fechaPago;
	
	
	@Override
	public void realizarPago(double monto) {
		this.fechaPago = LocalDate.now();
		this.montoPagado = monto*0.90;

	}

	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		System.out.println(
				"Fecha de pago: "+fechaPago +"\n"
				+ "Monto pagado: "+montoPagado);
	}

	
	
	//Métodos accesores
	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	

}
