package padre;

public class Círculo {
	protected double radio;
	public Círculo(double radio) {
		this.radio = radio;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
	}
	public double Área() {
		return 3.1416*radio*radio;
	}
	public double Longitud() {
		return 2*3.1416*radio;
	}
	public String Mensaje() {
		return "Soy círculo";
	}
	
	
}
