package hijos;

import padre.Círculo;

public class Cono extends Círculo{
	private double altura;
	private double generatriz;
	public Cono(double radio, double altura, double generatriz) {
		super(radio);
		this.altura = altura;
		this.generatriz = generatriz;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double getGeneratriz() {
		return generatriz;
	}
	public void setGeneratriz(double generatriz) {
		this.generatriz = generatriz;
	}
	public String Mensaje() {
		return "Soy un cono";
	}
	public double Área() {
		return (3.1416*radio*radio)+(3.1416*radio*generatriz);
	}
	public double Volumen() {
		return (3.1416*radio*radio*altura)/3;
	}
	
	
}
