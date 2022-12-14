package dad.buscaryreemplazar;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BuscarYReemplazar extends Application {

    // VIEW

    // Botones de la derecha de la interfaz
    private Button buscarButton;
    private Button reemplazarButton;
    private Button reemplazarTodoButton;
    private Button cerrarButton;
    private Button ayudaButton;

    // Labels de  los cuadros de texto
    private Label buscarLabel;
    private Label reemplazarConLabel;

    // TextFields de busqueda y reemplazo
    private TextField buscarText;
    private TextField reemplazarConText;

    // Checkboxes debajo de los TextFields
    private CheckBox mayusculasCheckBox;
    private CheckBox expresionCheckBox;
    private CheckBox buscarCheckBox;
    private CheckBox resaltarCheckBox;

    // Paneles necesarios para la interfaz
    private GridPane checkBoxPanel;
    private VBox botonesPanel;
    private GridPane principalPanel;
    private BorderPane root;


    @Override
    public void start(Stage primaryStage) throws Exception {

        // Creamos las labels que indican los cuadros de texto
        buscarLabel = new Label("Buscar: ");
        reemplazarConLabel = new Label("Reemplazar con: ");

        // Insatanciamos los cuadros de texto de la busqueda y el reemplazo
        buscarText = new TextField();
        reemplazarConText = new TextField();

        // Instanciamos los botones para añadirlos al VBox
        buscarButton = new Button("Buscar");
        reemplazarButton = new Button("Reemplazar");
        reemplazarTodoButton = new Button("Reemplazar todo");
        cerrarButton = new Button("Cerrar");
        ayudaButton = new Button("Ayuda");

        // Añadimos los botones al VBox
        botonesPanel = new VBox(5, buscarButton, reemplazarButton, reemplazarTodoButton, cerrarButton, ayudaButton);
        botonesPanel.setAlignment(Pos.TOP_CENTER);
        VBox.setMargin(botonesPanel, new Insets(10, 10, 0, 0));

        // Ajustamos el tamaño de los botones para que sean del mismo ancho que el más grande
        buscarButton.setMaxWidth(Double.MAX_VALUE);
        reemplazarButton.setMaxWidth(Double.MAX_VALUE);
        reemplazarTodoButton.setMaxWidth(Double.MAX_VALUE);
        cerrarButton.setMaxWidth(Double.MAX_VALUE);
        ayudaButton.setMaxWidth(Double.MAX_VALUE);

        // Creamos el panel de Checkboxes
        mayusculasCheckBox = new CheckBox("Mayúsculas y minúsculas");
        expresionCheckBox = new CheckBox("Expresión regular");
        buscarCheckBox = new CheckBox("Buscar hacia atrás");
        resaltarCheckBox = new CheckBox("Resaltar resultados");

        checkBoxPanel = new GridPane();
        checkBoxPanel.setHgap(5);
        checkBoxPanel.setVgap(5);
        checkBoxPanel.addRow(0, mayusculasCheckBox, buscarCheckBox);
        checkBoxPanel.addRow(1, expresionCheckBox, resaltarCheckBox);

        // Creamos el panel principal, donde se realizarán las busquedas
        principalPanel = new GridPane();
        principalPanel.setVgap(5);
        principalPanel.addRow(0, buscarLabel, buscarText);
        principalPanel.addRow(1, reemplazarConLabel, reemplazarConText);
        principalPanel.addRow(2, new Label(""),checkBoxPanel);

        // Ajustamos el tamaño minimo del panel principal
        principalPanel.setMinWidth(Control.USE_PREF_SIZE);

        // Creamos la escena, la venta principal y hacemos que se muestren
        root = new BorderPane();
        root.setRight(botonesPanel);
        root.setCenter(principalPanel);
        root.setPadding(new Insets(5));
        
        primaryStage.setTitle("Buscar y Reemplazar");
        primaryStage.setScene(new Scene(root, 500, 200));
        primaryStage.show();

    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
