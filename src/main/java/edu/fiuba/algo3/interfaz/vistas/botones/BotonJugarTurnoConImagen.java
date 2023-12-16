package edu.fiuba.algo3.interfaz.vistas.botones;

import edu.fiuba.algo3.interfaz.controladores.ControladorJugarTurnoConImagen;
import edu.fiuba.algo3.modelo.Juego;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BotonJugarTurnoConImagen extends ImageView {

    public BotonJugarTurnoConImagen(Juego juego){
        Image imagen = new Image("file:" + System.getProperty("user.dir") + "/imagenes/dadoRojito.gif");
        this.setImage(imagen);
        this.setPreserveRatio(true);
        this.setFitWidth(50);
        this.setFitHeight(50);

        this.setOnMouseClicked(new ControladorJugarTurnoConImagen(juego));
    }
}
