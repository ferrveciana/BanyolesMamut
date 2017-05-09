package prova;
import java.awt.Desktop;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 
public final class Prova extends Application {
    
    Stage window;
    Scene scene2;
    
    private final Desktop desktop = Desktop.getDesktop();
 
    @Override
    public void start(final Stage primaryStage) {
        window = primaryStage;
        primaryStage.setTitle("ProActive Travel");
 
        FileChooser fileChooser = new FileChooser();
        Button button1 = new Button("Selecciona un fitxer");   
      
        button1.setOnAction((final ActionEvent e) -> {
            configureFileChooser(fileChooser);
            File file = fileChooser.showOpenDialog(primaryStage);
            window.setScene(scene2);
            if (file != null) {
                openFile(file);
            }
            
        });
        StackPane layout = new StackPane();
        layout.getChildren().add(button1);
        Scene scene1 = new Scene(layout,250,100);

        BorderPane border = new BorderPane();
        HBox hbox = addHBox();
        border.setTop(hbox);
        border.setLeft(addVBox());
        scene2 = new Scene(border,300,300);
        
        
        
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    
    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #52afaf;");
        
        Text title = new Text("SELECCIONA EL RECORREGUT");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        hbox.getChildren().add(title);

    return hbox;
}
    
    public VBox addVBox() {
    VBox vbox = new VBox();
    vbox.setPadding(new Insets(10));
    vbox.setSpacing(8);
   
    
    Button buttonBk1 = new Button("Backtraking 1");
    Button buttonBk2 = new Button("Backtraking 2");
    Button buttonGrdy = new Button("Greedy");
    
    Label bk1 = new Label("Narrada");
    Label bk2 = new Label("Narrada");
    Label gr = new Label("Narrada");
    
    VBox.setMargin(buttonBk1, new Insets(0, 0, 15, 20)); // -,-,altura,marge
    VBox.setMargin(buttonBk2, new Insets(0, 0, 15, 20));
    VBox.setMargin(buttonGrdy, new Insets(0, 0, 15, 20));
    vbox.getChildren().addAll(bk1,buttonBk1,bk2,buttonBk2,gr,buttonGrdy);

    return vbox;
}
    
 
    public static void main(String[] args) {
        Application.launch(args);
    }
 
    private static void configureFileChooser(
        final FileChooser fileChooser) {      
            fileChooser.setTitle("Selecciona el fitxer de dades");
            fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
            );                 
            fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT", "*.txt")
            );
    }
 
    private void openFile(File file) {
        System.out.println(file);
    }
}