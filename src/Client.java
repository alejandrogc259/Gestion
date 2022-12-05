import javax.persistence.Entity;

@Entity
public class Client {
	String NIF;
	String Nombre;
	String Apellidos;
	int Edad;
	public Client(String NIF, String Nombre, String Apellidos, int Edad){
		this.NIF=NIF;
		this.Nombre=Nombre;
		this.Apellidos=Apellidos;
		this.Edad=Edad;
	}
	public String toString(){
		return NIF+","+Nombre+","+Apellidos+","+Edad+".";
	}
}
