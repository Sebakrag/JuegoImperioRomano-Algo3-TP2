package edu.fiuba.algo3.interfaz.vistas.escenas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.celdas.Celda;

public class VistaTablero extends GridPane {

    private static final int TAMANO_CELDA = 50;

    public VistaTablero(Tablero tablero) {
        Celda celdaActual = tablero.getCeldaInicial();
        while (!(celdaActual == tablero.getCeldaFinal())) {
            StackPane panelCeldaActual = this.crearPanelCelda(celdaActual);

            celdaActual.ubicarEnGrillaInterfaz(this, panelCeldaActual);
            //setConstraints(panelCeldaActual, fila, col);

            super.getChildren().add(panelCeldaActual);

            celdaActual = celdaActual.celdaSiguiente();
        }
        // Llegado este punto se crea el panel de la celda final y se lo ubica en la grilla del tablero.
        StackPane panelCeldaActual = this.crearPanelCelda(celdaActual);
        celdaActual.ubicarEnGrillaInterfaz(this, panelCeldaActual);
        super.getChildren().add(panelCeldaActual);
    }

    public StackPane crearPanelCelda(Celda celdaActual) {
        // "file:" + System.getProperty("user.dir") + "/imagenes/pasto.jpg"  --> Ruta para imagen de pasto
        // "file:" + System.getProperty("user.dir") + "/imagenes/imagenCamino.png" --> Ruta para imagen de camino
        StackPane panelCelda = new StackPane();
        Image imagenFondo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/" + celdaActual.nombreImagenFondo());

        ImageView viewImagenFondo = new ImageView(imagenFondo);
        viewImagenFondo.setFitHeight(TAMANO_CELDA);
        viewImagenFondo.setFitWidth(TAMANO_CELDA);

        /*
        Image imagenPremio = new Image("file:" + System.getProperty("user.dir") + "/imagenes/" + celdaActual.nombreImagenPremio());
        Image imagenObstaculo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/" + celdaActual.nombreImagenObstaculo());

        ImageView viewImagenPremio = new ImageView(imagenPremio);
        viewImagenPremio.setFitHeight(20);
        viewImagenPremio.setFitWidth(20);

        ImageView viewImagenObstaculo = new ImageView(imagenObstaculo);
        viewImagenObstaculo.setFitHeight(20);
        viewImagenObstaculo.setFitWidth(20);
         */

        panelCelda.getChildren().add(viewImagenFondo);
        //panelCelda.getChildren().add(viewImagenPremio);
        //panelCelda.getChildren().add(viewImagenObstaculo);

        return panelCelda;
    }


    /*
    public VistaTablero(Tablero tablero) {
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
*/
}
