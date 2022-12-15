
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RevisionController implements Initializable {

    @FXML
    public TableView<Revision> tablaRevision;
    @FXML
    public TableColumn<Revision, Integer> columnaID;
    @FXML
    public TableColumn<Revision, String> columnaNIF;
    @FXML
    public TableColumn<Revision, LocalDate> columnaConsulta;
    @FXML
    public TableColumn<Revision, Double> columnaOD_Esfera;
    @FXML
    public TableColumn<Revision, Double> columnaOD_Cilindro;
    @FXML
    public TableColumn<Revision, Double> columnaOD_Adicion;
    @FXML
    public TableColumn<Revision, Double> columnaOD_Agudeza;
    @FXML
    public TableColumn<Revision, Double> columnaOI_Esfera;
    @FXML
    public TableColumn<Revision, Double> columnaOI_Cilindro;
    @FXML
    public TableColumn<Revision, Double> columnaOI_Adicion;
    @FXML
    public TableColumn<Revision, Double> columnaOI_Agudeza;
    @FXML
    public TextField OD_Esfera;
    @FXML
    public TextField OD_Cilindro;
    @FXML
    public TextField OD_Adicion;
    @FXML
    public TextField OD_Agudeza;
    @FXML
    public TextField OI_Esfera;
    @FXML
    public TextField OI_Cilindro;
    @FXML
    public TextField OI_Adicion;
    @FXML
    public TextField OI_Agudeza;
    @FXML
    public DatePicker fechaConsulta;
    @FXML
    public Label cliente;
    private Client clienteActual;
    private ObservableList<Revision> revisiones;

    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        //leerRevision();
    }
    
    public void leerRevision() {
    	List<Revision> revisiones2=Prueba.obtenerRevisiones();
    	revisiones = FXCollections.observableArrayList(revisiones2);
    	columnaID.setCellValueFactory(s -> new ReadOnlyObjectWrapper<>(s.getValue().getID()));
    	columnaNIF.setCellValueFactory(s -> new ReadOnlyObjectWrapper<>(s.getValue().getNIF()));
    	columnaConsulta.setCellValueFactory(s -> new ReadOnlyObjectWrapper<>(s.getValue().getConsulta()));
    	columnaOD_Esfera.setCellValueFactory(s -> new ReadOnlyObjectWrapper<>(s.getValue().getOD_Esfera()));
    	columnaOD_Cilindro.setCellValueFactory(s -> new ReadOnlyObjectWrapper<>(s.getValue().getOD_Cilindro()));
    	columnaOD_Adicion.setCellValueFactory(s -> new ReadOnlyObjectWrapper<>(s.getValue().getOD_Adicion()));
    	columnaOD_Agudeza.setCellValueFactory(s -> new ReadOnlyObjectWrapper<>(s.getValue().getOD_Agudeza()));
    	columnaOI_Esfera.setCellValueFactory(s -> new ReadOnlyObjectWrapper<>(s.getValue().getOI_Esfera()));
    	columnaOI_Cilindro.setCellValueFactory(s -> new ReadOnlyObjectWrapper<>(s.getValue().getOI_Cilindro()));
    	columnaOI_Adicion.setCellValueFactory(s -> new ReadOnlyObjectWrapper<>(s.getValue().getOI_Adicion()));
    	columnaOI_Agudeza.setCellValueFactory(s -> new ReadOnlyObjectWrapper<>(s.getValue().getOI_Agudeza()));
    	tablaRevision.setItems(revisiones);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        clienteActual = ClientController.obtenerCliente();
        cliente.setText(clienteActual.toString());
        leerRevision();
		
	}
	public void MostrarSeleccion() {
		if(tablaRevision.getSelectionModel().getSelectedItem()!=null) {
			OD_Esfera.setText(String.valueOf(tablaRevision.getSelectionModel().getSelectedItem().getOD_Esfera()));
			OD_Cilindro.setText(String.valueOf(tablaRevision.getSelectionModel().getSelectedItem().getOD_Cilindro()));
			OD_Adicion.setText(String.valueOf(tablaRevision.getSelectionModel().getSelectedItem().getOD_Adicion()));
			OD_Agudeza.setText(String.valueOf(tablaRevision.getSelectionModel().getSelectedItem().getOD_Agudeza()));
			OI_Esfera.setText(String.valueOf(tablaRevision.getSelectionModel().getSelectedItem().getOI_Esfera()));
			OI_Cilindro.setText(String.valueOf(tablaRevision.getSelectionModel().getSelectedItem().getOI_Cilindro()));
			OI_Adicion.setText(String.valueOf(tablaRevision.getSelectionModel().getSelectedItem().getOI_Adicion()));
			OI_Agudeza.setText(String.valueOf(tablaRevision.getSelectionModel().getSelectedItem().getOI_Agudeza()));
		}
		
	}
	public void Limpiar() {
		tablaRevision.getSelectionModel().clearSelection();
		OD_Esfera.clear();
		OD_Cilindro.clear();
		OD_Adicion.clear();
		OD_Agudeza.clear();
		OI_Esfera.clear();
		OI_Cilindro.clear();
		OI_Adicion.clear();
		OI_Agudeza.clear();
		leerRevision();
	}
	public void Cerrar() {
		Stage stage = (Stage) OD_Esfera.getScene().getWindow();
	    stage.close();
	}
	
	  public void Anadir() { 
		  if(!OD_Esfera.getText().isBlank() && !OD_Cilindro.getText().isBlank() && !OD_Adicion.getText().isBlank() && !OD_Agudeza.getText().isBlank() && !OI_Esfera.getText().isBlank() && !OI_Cilindro.getText().isBlank() && !OI_Adicion.getText().isBlank() && !OI_Agudeza.getText().isBlank()) {
			  int id=Prueba.obtenerID();
			  Prueba.anadirRevision(new Revision(id,clienteActual.getNIF(),LocalDate.now(),Double.parseDouble(OD_Esfera.getText()),Double.parseDouble(OD_Cilindro.getText()),Double.parseDouble(OD_Adicion.getText()),Double.parseDouble(OD_Agudeza.getText()),Double.parseDouble(OI_Esfera.getText()),Double.parseDouble(OI_Cilindro.getText()),Double.parseDouble(OI_Adicion.getText()),Double.parseDouble(OI_Agudeza.getText()))); 
			  Limpiar(); 
		  } 
		  else { 
			Alert alert = new
			Alert(AlertType.WARNING,"Faltan campos por rellenar"); alert.showAndWait(); 
		  }
	  }
	  
	  public void Borrar() {
			if(tablaRevision.getSelectionModel().getSelectedItem()!=null) {
				Prueba.BorrarRevision(tablaRevision.getSelectionModel().getSelectedItem().getID());
				Limpiar();
			}
			else {
				Alert alert = new Alert(AlertType.WARNING,"No ha seleccionado ningún cliente");
				alert.showAndWait();
			}
			
		} 
	  
	 public void Actualizar() {
			if(tablaRevision.getSelectionModel().getSelectedItem()!=null) {
				int id=Prueba.obtenerID();
				Prueba.ActualizarRevision(tablaRevision.getSelectionModel().getSelectedItem().getID(),new Revision(id,clienteActual.getNIF(),LocalDate.now(),Double.parseDouble(OD_Esfera.getText()),Double.parseDouble(OD_Cilindro.getText()),Double.parseDouble(OD_Adicion.getText()),Double.parseDouble(OD_Agudeza.getText()),Double.parseDouble(OI_Esfera.getText()),Double.parseDouble(OI_Cilindro.getText()),Double.parseDouble(OI_Adicion.getText()),Double.parseDouble(OI_Agudeza.getText())));
				Limpiar();
			}
			else {
				Alert alert = new Alert(AlertType.WARNING,"No ha seleccionado ninguna revisión");
				alert.showAndWait();
			}
			
		}
	 
}