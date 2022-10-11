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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
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
    private FlowPane checkBoxPanel;
    private VBox botonesPanel;
    private GridPane principalPanel;
    private BorderPane root;


    @Override
    public void start(Stage primaryStage) throws Exception {

        // Creamos las labels que indican los cuadros de texto
        buscarLabel = new Label("Buscar: ");
        reemplazarConLabel = new Label("Reemplazar con: ");

        // Instanciamos los botones para añadirlos al VBox
        buscarButton = new Button("Buscar");
        reemplazarButton = new Button("Reemplazar");
        reemplazarTodoButton = new Button("Reemplazar todo");
        cerrarButton = new Button("Cerrar");
        ayudaButton = new Button("Ayuda");

        botonesPanel = new VBox(5, buscarButton, reemplazarButton, reemplazarTodoButton, cerrarButton, ayudaButton);
        botonesPanel.setAlignment(Pos.TOP_CENTER);

        // Creamos el panel de Checkboxes
        mayusculasCheckBox = new CheckBox("Mayúsculas y minúsculas");
        expresionCheckBox = new CheckBox("Expresión regular");
        buscarCheckBox = new CheckBox("Buscar hacia atrás");
        resaltarCheckBox = new CheckBox("Resaltar resultados");

        // TODO CAMBIAR EL FLOWPANE POR UN GRIDPANE
        checkBoxPanel = new FlowPane();
        checkBoxPanel.getChildren().addAll(mayusculasCheckBox, expresionCheckBox, buscarCheckBox, resaltarCheckBox);

        // Creamos el panel principal, donde se realizarán las busquedas
        principalPanel = new GridPane();
        principalPanel.setPadding(new Insets(5));
        principalPanel.setHgap(5);        
        principalPanel.setVgap(5);
        principalPanel.setGridLinesVisible(true);
        principalPanel.addRow(0, buscarLabel, new TextField());
        principalPanel.addRow(1, reemplazarConLabel, new TextField());
        principalPanel.addRow(2, new Label(""), checkBoxPanel);

        ColumnConstraints [] cols = {
            new ColumnConstraints(),
            new ColumnConstraints()
        };

        cols[0].setMinWidth(Control.USE_PREF_SIZE);

        // Creamos la escena, la venta principal y hacemos que se muestren
        root = new BorderPane();
        root.setRight(botonesPanel);
        root.setCenter(principalPanel);
        
        primaryStage.setTitle("Buscar y Reemplazar");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
