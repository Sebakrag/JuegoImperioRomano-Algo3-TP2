package edu.fiuba.algo3.interfaz.vistas.escenas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class VistaTablero extends GridPane {

    private static final int TAMANO_CELDA = 50;

    //  public VistaTablero(Tablero tablero)? TODO: Pasarle tablero?
    public VistaTablero() {
        for (int fila = 0; fila < 4; fila++) {
            for (int col = 0; col < 7; col++) {

                StackPane panelCelda = this.crearPanelCelda("/imagenes/imagenCamino.png");

                setConstraints(panelCelda, fila, col);

                super.getChildren().add(panelCelda);
            }
        }
    }

    public StackPane crearPanelCelda(String rutaImagen) {
        // "file:" + System.getProperty("user.dir") + "/imagenes/pasto.jpg"  --> Ruta para imagen de pasto
        // "file:" + System.getProperty("user.dir") + "/imagenes/imagenCamino.png" --> Ruta para imagen de camino
        StackPane panelCelda = new StackPane();
        Image imagenCamino = new Image("file:" + System.getProperty("user.dir") + rutaImagen);

        ImageView viewImagenCamino = new ImageView(imagenCamino);
        viewImagenCamino.setFitHeight(TAMANO_CELDA);
        viewImagenCamino.setFitWidth(TAMANO_CELDA);

        panelCelda.getChildren().add(viewImagenCamino);
        
        return panelCelda;
    }

}
