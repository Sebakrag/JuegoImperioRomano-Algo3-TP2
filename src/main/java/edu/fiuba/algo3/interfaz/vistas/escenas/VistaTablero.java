package edu.fiuba.algo3.interfaz.vistas.escenas;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.celdas.Celda;
import javafx.scene.Node;

public class VistaTablero extends GridPane {

    private static final int TAMANO_CELDA = 50;

    public VistaTablero(Tablero tablero) {
        this.crearCamino(tablero);
        this.rellenarConCeldasPasto();
    }

    private void crearCamino(Tablero tablero) {
        Celda celdaActual = tablero.getCeldaInicial();
        while (!(celdaActual == tablero.getCeldaFinal())) {
            StackPane panelCeldaActual = this.crearPanelCamino(celdaActual);

            //celdaActual.ubicarEnGrillaInterfaz(this, panelCeldaActual);
            setConstraints(panelCeldaActual, celdaActual.getX(), celdaActual.getY());

            super.getChildren().add(panelCeldaActual);

            celdaActual = celdaActual.celdaSiguiente();
        }
        // Llegado este punto se crea el panel de la celda final y se lo ubica en la grilla del tablero.
        StackPane panelCeldaActual = this.crearPanelCamino(celdaActual);
        //celdaActual.ubicarEnGrillaInterfaz(this, panelCeldaActual);
        setConstraints(panelCeldaActual, celdaActual.getX(), celdaActual.getY());
        super.getChildren().add(panelCeldaActual);
    }

    private StackPane crearPanelCamino(Celda celdaActual) {
        return crearPanelCelda(celdaActual.nombreImagenFondo());
        // Si optamos por no agregar una imagen del premio y del obstaculo en cada celda, el metodo crearPanelCamino
        // pasa a ser innecesario y usariamos "crearPanelCelda" como su reemplazante.

        /*   Este codigo comentado sirve si queremos poner una imagen del premio y del obstaculo en cada celda que tenga el respectivo premio u obstaculo
        StackPane panelCelda = crearPanelCelda(celdaActual.nombreImagenFondo());
        Image imagenPremio = new Image("file:" + System.getProperty("user.dir") + "/imagenes/" + celdaActual.nombreImagenPremio());
        Image imagenObstaculo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/" + celdaActual.nombreImagenObstaculo());

        ImageView viewImagenPremio = new ImageView(imagenPremio);
        viewImagenPremio.setFitHeight(20);
        viewImagenPremio.setFitWidth(20);

        ImageView viewImagenObstaculo = new ImageView(imagenObstaculo);
        viewImagenObstaculo.setFitHeight(20);
        viewImagenObstaculo.setFitWidth(20);

        panelCelda.getChildren().add(viewImagenPremio);
        panelCelda.getChildren().add(viewImagenObstaculo);

        return panelCelda;
        */
    }

    private void rellenarConCeldasPasto() {
        // Pensar si para crear todas las celdas que contienen pasto nos conviene tener el ancho y el alto
        // del tablero para recorrer cada celda de la GridPane e ir verificando si ya hay un camino ahi o esta vacio.
        // Si se da el caso de que este vacio, habria que poner una imagen de pasto. En caso contrario se avanza a la
        // siguiente celda para verificar lo mismo.
        // (La pregunta es: GridPane tendra algun metodo para que podamos verificar si el casillero en el que estamos
        // tiene una imagen o no?)
        for (int fila = 0; fila < 11; fila++) {
            for (int col = 0; col < 19; col++) {
                if (!hayCeldaCaminoEn(fila, col)) {
                    StackPane panelPasto = crearPanelCelda("imagenPasto.png");

                    setConstraints(panelPasto, col, fila);

                    super.getChildren().add(panelPasto);
                }
            }
        }
    }

    private StackPane crearPanelCelda(String nombreImagen) {
        // "file:" + System.getProperty("user.dir") + "/imagenes/pasto.jpg"  --> Ruta para imagen de pasto
        // "file:" + System.getProperty("user.dir") + "/imagenes/imagenCamino.png" --> Ruta para imagen de camino
        StackPane panelCelda = new StackPane();
        Image imagenFondo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/" + nombreImagen);

        ImageView viewImagenFondo = new ImageView(imagenFondo);
        viewImagenFondo.setFitHeight(TAMANO_CELDA);
        viewImagenFondo.setFitWidth(TAMANO_CELDA);

        panelCelda.getChildren().add(viewImagenFondo);

        return panelCelda;
    }

    private boolean hayCeldaCaminoEn(int fila, int columna) {
        for (Node node : this.getChildren()) {
            if ((GridPane.getColumnIndex(node) == columna) && (GridPane.getRowIndex(node) == fila)) {
                // Verifica si el nodo en la celda de la gridpane (vistaTablero) es un StackPane.
                return node instanceof StackPane;
            }
        }
        return false;
    }

}
