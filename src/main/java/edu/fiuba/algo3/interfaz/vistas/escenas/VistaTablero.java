package edu.fiuba.algo3.interfaz.vistas.escenas;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import edu.fiuba.algo3.modelo.Tablero;
import edu.fiuba.algo3.modelo.celdas.Celda;
import javafx.scene.Node;
import javafx.scene.paint.ImagePattern;

public class VistaTablero extends GridPane {

    private static final int TAMANIO_CELDA = 50;

    public VistaTablero(Tablero tablero) {

        //System.out.println("Ancho : " + tablero.getAncho());
        //System.out.println("Largo : " + tablero.getLargo());
        int columnas = tablero.getLargo();
        int filas = tablero.getAncho();

        super.setAlignment(Pos.CENTER);

        // Configurar restricciones de columna
        for (int i = 0; i < columnas; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(100.0 / columnas);
            this.getColumnConstraints().add(columnConstraints);
        }

        // Configurar restricciones de fila
        for (int i = 0; i < filas; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(100.0 / filas);
            this.getRowConstraints().add(rowConstraints);
        }

        //this.crearCamino(tablero);
        //this.rellenarConCeldasPasto(tablero);
        this.crearMapa(tablero);
    }

    private void crearCamino(Tablero tablero) {
        Celda celdaActual = tablero.getCeldaInicial();

        while (!(celdaActual == tablero.getCeldaFinal())) {
            StackPane panelCeldaActual = this.crearPanelCamino(celdaActual);

            super.getChildren().add(panelCeldaActual);

            setConstraints(panelCeldaActual, celdaActual.getX(), celdaActual.getY());

            celdaActual = celdaActual.celdaSiguiente();
        }

        // Llegado este punto se crea el panel de la celda final y se lo ubica en la grilla del tablero.
        StackPane panelCeldaActual = this.crearPanelCamino(celdaActual);
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

    private void rellenarConCeldasPasto(Tablero tablero) {
        // Pensar si para crear todas las celdas que contienen pasto nos conviene tener el ancho y el alto
        // del tablero para recorrer cada celda de la GridPane e ir verificando si ya hay un camino ahi o esta vacio.
        // Si se da el caso de que este vacio, habria que poner una imagen de pasto. En caso contrario se avanza a la
        // siguiente celda para verificar lo mismo.
        // (La pregunta es: GridPane tendra algun metodo para que podamos verificar si el casillero en el que estamos
        // tiene una imagen o no?)
        for (int fila = 0; fila < tablero.getLargo(); fila++) {
            for (int col = 0; col < tablero.getAncho(); col++) {
                if (!hayCeldaCaminoEn(fila, col)) {
                    StackPane panelPasto = crearPanelCelda("imagenPasto.png");

                    super.getChildren().add(panelPasto);

                    setConstraints(panelPasto, col, fila);
                }
            }
        }
    }

    private StackPane crearPanelCelda(String nombreImagen) {
        StackPane panelCelda = new StackPane();
        Image imagenFondo = new Image("file:" + System.getProperty("user.dir") + "/imagenes/" + nombreImagen);

        ImagePattern imagePattern = new ImagePattern(imagenFondo, 0, 0, 1, 1, true);
        BackgroundFill backgroundFill = new BackgroundFill(imagePattern, null, null);
        Background background = new Background(backgroundFill);

        panelCelda.setBackground(background);

        panelCelda.prefWidthProperty().bind(super.widthProperty());
        panelCelda.prefHeightProperty().bind(super.heightProperty());

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

    private void crearMapa(Tablero tablero){
        Celda celda = tablero.getCeldaInicial();
        int x = celda.getX();
        int y = celda.getY();
        StackPane panelCelda;

        for (int i = 0; i < tablero.getAncho(); i++) {
            for (int j = 0; j < tablero.getLargo(); j++) {
                panelCelda = crearPanelCelda("imagenPasto.png");
                super.getChildren().add(panelCelda);
                setConstraints(panelCelda, j, i);
            }
        }

        int i = 0;

        while(i < tablero.getcantidadTotalDeCeldas()){
            panelCelda = crearPanelCelda(celda.nombreImagenFondo());
            super.getChildren().add(panelCelda);
            setConstraints(panelCelda, x, y);
            celda = celda.celdaSiguiente();
            x = celda.getX();
            y = celda.getY();
            i++;
        }
    }
}
