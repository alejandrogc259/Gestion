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
	public String getNIF() {
		return NIF;
	}
	public void setNIF(String nIF) {
		NIF = nIF;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public int getEdad() {
		return Edad;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
}
