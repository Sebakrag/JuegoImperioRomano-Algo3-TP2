package edu.fiuba.algo3.interfaz.vistas.escenas;

import edu.fiuba.algo3.interfaz.vistas.contenedores.ContenedorPrincipal;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class VistaInicial extends StackPane {

    public VistaInicial(Stage stage) {
        /*    // TODO: Que onda esto? Arranca o no arranca?
        DoubleProperty fontSize = new SimpleDoubleProperty(12);
        imperioRomanoEtiqueta.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize.asString()));
        fontSize.bind(Bindings.createDoubleBinding(
                () -> contenedorPrincipal.getWidth() / imperioRomanoEtiqueta.getText().length() * 1.5, // Puedes ajustar este factor según tus necesidades
                contenedorPrincipal.widthProperty(), imperioRomanoEtiqueta.textProperty()));
        */

        //Imagen de Fondo
        Image imagenDeFondo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/fondoMenuInicial.jpg");
        ImageView viewImagenFondo = new ImageView(imagenDeFondo);
        viewImagenFondo.setPreserveRatio(false);
        viewImagenFondo.fitWidthProperty().bind(stage.widthProperty());
        viewImagenFondo.fitHeightProperty().bind(stage.heightProperty());

        this.getChildren().add(viewImagenFondo);
        this.getChildren().add(new ContenedorPrincipal(stage));
    }
}
