package hijos;

import padre.Círculo;

public class Cilindro extends Círculo{
	private double altura;

	public Cilindro(double radio, double altura) {
		super(radio);
		this.altura = altura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	public String Mensaje() {
		return "Soy cilindro";
	}
	public double Área() {
		return 2*3.1416*radio*(radio+altura);
	}
	public double Volumen() {
		return 3.1416*radio*radio*altura;
	} 
}
