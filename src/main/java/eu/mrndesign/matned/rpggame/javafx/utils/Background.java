package eu.mrndesign.matned.rpggame.javafx.utils;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.File;

public class Background {


    public static javafx.scene.layout.Background BACKGROUND_COLOR(Color color){
        return new javafx.scene.layout.Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY));
    }


    public static javafx.scene.layout.Background BACKGROUND_IMAGE(String pathToImage){
        File file = new File(pathToImage);
        Image image = new Image(file.toURI().toString());
        return new javafx.scene.layout.Background(new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(image.getWidth() >= image.getHeight()? 1 : getHeight(image), image.getWidth() <= image.getHeight()? 1: getWidth(image), true, true, false, false)));

    }

    private static double getWidth(Image image) {
        return image.getHeight()/image.getWidth();
    }

    private static double getHeight(Image image) {
        return image.getWidth()/image.getHeight();
    }


}
