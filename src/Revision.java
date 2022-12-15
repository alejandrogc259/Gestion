import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Revision {
	int ID;
	String NIF;
	LocalDate Consulta;
	double OD_Esfera;
	double OD_Cilindro;
	double OD_Adicion;
	double OD_Agudeza;
	double OI_Esfera;
	double OI_Cilindro;
	double OI_Adicion;
	double OI_Agudeza;
	public Revision(int iD, String nIF, LocalDate consulta, double oD_Esfera, double oD_Cilindro, double oD_Adicion,
			double oD_Agudeza, double oI_Esfera, double oI_Cilindro, double oI_Adicion, double oI_Agudeza) {
		ID = iD;
		NIF = nIF;
		Consulta = consulta;
		OD_Esfera = oD_Esfera;
		OD_Cilindro = oD_Cilindro;
		OD_Adicion = oD_Adicion;
		OD_Agudeza = oD_Agudeza;
		OI_Esfera = oI_Esfera;
		OI_Cilindro = oI_Cilindro;
		OI_Adicion = oI_Adicion;
		OI_Agudeza = oI_Agudeza;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNIF() {
		return NIF;
	}
	public void setNIF(String nIF) {
		NIF = nIF;
	}
	public LocalDate getConsulta() {
		return Consulta;
	}
	public void setConsulta(LocalDate consulta) {
		Consulta = consulta;
	}
	public double getOD_Esfera() {
		return OD_Esfera;
	}
	public void setOD_Esfera(double oD_Esfera) {
		OD_Esfera = oD_Esfera;
	}
	public double getOD_Cilindro() {
		return OD_Cilindro;
	}
	public void setOD_Cilindro(double oD_Cilindro) {
		OD_Cilindro = oD_Cilindro;
	}
	public double getOD_Adicion() {
		return OD_Adicion;
	}
	public void setOD_Adicion(double oD_Adicion) {
		OD_Adicion = oD_Adicion;
	}
	public double getOD_Agudeza() {
		return OD_Agudeza;
	}
	public void setOD_Agudeza(double oD_Agudeza) {
		OD_Agudeza = oD_Agudeza;
	}
	public double getOI_Esfera() {
		return OI_Esfera;
	}
	public void setOI_Esfera(double oI_Esfera) {
		OI_Esfera = oI_Esfera;
	}
	public double getOI_Cilindro() {
		return OI_Cilindro;
	}
	public void setOI_Cilindro(double oI_Cilindro) {
		OI_Cilindro = oI_Cilindro;
	}
	public double getOI_Adicion() {
		return OI_Adicion;
	}
	public void setOI_Adicion(double oI_Adicion) {
		OI_Adicion = oI_Adicion;
	}
	public double getOI_Agudeza() {
		return OI_Agudeza;
	}
	public void setOI_Agudeza(double oI_Agudeza) {
		OI_Agudeza = oI_Agudeza;
	}
}
