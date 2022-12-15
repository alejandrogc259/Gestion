
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ClientController implements Initializable {

    @FXML
    public TableView<Client> tablaClient;
    @FXML
    public TableColumn<Client, String> columnaNif;
    @FXML
    public TableColumn<Client, String> columnaNombre;
    @FXML
    public TableColumn<Client, String> columnaApellidos;
    @FXML
    public TableColumn<Client, Integer> columnaEdad;
    @FXML
    public TextField NIF;
    @FXML
    public TextField Apellidos;
    @FXML
    public TextField Nombre;
    @FXML
    public ListView<Integer> Edad;
    private ObservableList<Client> clientes;
    public static Client seleccionado;
    public static Client obtenerCliente() {
    	if(seleccionado!=null)return seleccionado;
    	else return null;
    }

    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        leerClient();
    }
    
    public void leerClient() {
    	List<Client> clients=Prueba.obtenerClients();
    	clientes = FXCollections.observableArrayList(clients);
    	columnaNif.setCellValueFactory(s -> new ReadOnlyObjectWrapper<>(s.getValue().getNIF()));
    	columnaNombre.setCellValueFactory(s -> new ReadOnlyObjectWrapper<>(s.getValue().getNombre()));
    	columnaApellidos.setCellValueFactory(s -> new ReadOnlyObjectWrapper<>(s.getValue().getApellidos()));
    	columnaEdad.setCellValueFactory(s -> new ReadOnlyObjectWrapper<>(s.getValue().getEdad()));
    	tablaClient.setItems(clientes);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        leerClient();
        List<Integer> edades=new ArrayList<Integer>();
        for(int i=0;i<150;i++) {
        	edades.add(i);
        }
        ObservableList<Integer> edades2= FXCollections.observableArrayList(edades);
        Edad.setItems(edades2);
		
	}
	public void MostrarSeleccion() {
		if(tablaClient.getSelectionModel().getSelectedItem()!=null) {
			NIF.setText(tablaClient.getSelectionModel().getSelectedItem().getNIF());
			Nombre.setText(tablaClient.getSelectionModel().getSelectedItem().getNombre());
			Apellidos.setText(tablaClient.getSelectionModel().getSelectedItem().getApellidos());
			Edad.getSelectionModel().select(tablaClient.getSelectionModel().getSelectedItem().getEdad());
			Edad.scrollTo(tablaClient.getSelectionModel().getSelectedItem().getEdad());
		}
		
	}
	public void Limpiar() {
		tablaClient.getSelectionModel().clearSelection();
		NIF.clear();
		Nombre.clear();
		Apellidos.clear();
		Edad.getSelectionModel().clearSelection();
		Edad.scrollTo(0);
		leerClient();
	}
	public void Cerrar() {
		System.exit(0);
	}
	public void Anadir() {
		if(!NIF.getText().isBlank() && !Nombre.getText().isBlank() && !Apellidos.getText().isBlank() && Edad.getSelectionModel().getSelectedItem()!=null) {
			boolean anadido=Prueba.anadirClient(new Client(NIF.getText(), Nombre.getText(), Apellidos.getText(), Edad.getSelectionModel().getSelectedItem()));
			if(!anadido) {
				Alert alert = new Alert(AlertType.WARNING,"Ya hay un cliente con ese NIF");
				alert.showAndWait();
			}
			Limpiar();
		}
		else {
			Alert alert = new Alert(AlertType.WARNING,"Faltan campos por rellenar");
			alert.showAndWait();
		}
		
	}
	public void Borrar() {
		if(tablaClient.getSelectionModel().getSelectedItem()!=null) {
			Prueba.BorrarClient(tablaClient.getSelectionModel().getSelectedItem().getNIF());
			Limpiar();
		}
		else {
			Alert alert = new Alert(AlertType.WARNING,"No ha seleccionado ningún cliente");
			alert.showAndWait();
		}
		
	}
	public void Actualizar() {
		if(tablaClient.getSelectionModel().getSelectedItem()!=null) {
			Prueba.ActualizarClient(tablaClient.getSelectionModel().getSelectedItem().getNIF(),new Client(NIF.getText(), Nombre.getText(), Apellidos.getText(), Edad.getSelectionModel().getSelectedItem()));
			Limpiar();
		}
		else {
			Alert alert = new Alert(AlertType.WARNING,"No ha seleccionado ningún cliente");
			alert.showAndWait();
		}
		
	}
	public void Revisiones() throws Exception {
		if(tablaClient.getSelectionModel().getSelectedItem()!=null) {
			Stage secondaryStage=new Stage();
			FXMLLoader loader= new FXMLLoader(getClass().getResource("VistaRevision.fxml"));
	        secondaryStage.setTitle("Revisiones");
	        seleccionado=tablaClient.getSelectionModel().getSelectedItem();
	        secondaryStage.setScene(new Scene(loader.load(), 1200, 600));
	        secondaryStage.show();
		}
		else {
			Alert alert = new Alert(AlertType.WARNING,"No ha seleccionado ningún cliente");
			alert.showAndWait();
		}
		
	}
}