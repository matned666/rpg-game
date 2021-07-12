package eu.mrndesign.matned.rpggame.javafx.service;

import eu.mrndesign.matned.rpggame.core.data.happening.Action;
import eu.mrndesign.matned.rpggame.core.data.happening.Happening;
import eu.mrndesign.matned.rpggame.core.data.items.ICreature;
import eu.mrndesign.matned.rpggame.core.data.items.utils.Direction;
import eu.mrndesign.matned.rpggame.core.data.map.City;
import eu.mrndesign.matned.rpggame.core.data.map.IMapFragment;
import eu.mrndesign.matned.rpggame.core.game.Game;
import eu.mrndesign.matned.rpggame.core.game.Map;
import eu.mrndesign.matned.rpggame.javafx.ActionController;
import eu.mrndesign.matned.rpggame.javafx.HappeningController;
import eu.mrndesign.matned.rpggame.javafx.utils.Background;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

/**
 * Service singleton class
 * created to have the same instance for all classes
 */

public class PointService implements IPointService {

    private static IPointService instance;
    private double actualHeroY;
    private double actualHeroX;

    public static IPointService getInstance() {
        if (instance == null) {
            synchronized (PointService.class) {
                if (instance == null)
                    instance = new PointService();
            }
        }
        return instance;
    }

    private Map map;
    private GridPane mapGrid;
    private VBox messagesList;
    private Canvas canvas;
    private final List<Node> buttons;
    private Game game;
    private ICreature hero;
    private Canvas[][] canvases;
    private Image heroImage;
    private double currentX;
    private double currentY;

    private PointService() {
        if (instance != null) {
            throw new IllegalStateException("Cannot create new instance, please use getInstance method instead.");
        }else {
            instance = this;
            buttons = new ArrayList<>();
        }
    }

    @Override
    public void initiate (Node... nodes){
        heroImage = new Image("/hero.png");
        actualHeroY = 15;
        actualHeroX = 15;
        canvases = new Canvas[35][20];
        game = Game.getInstance();
        initiateMap(nodes);
        initiateHero();
    }

    @Override
    public void addNewLog(String text) {
        messagesList.getChildren().add(new Label("> " + text));
    }

    @Override
    public void moveWest(){
        if (actualHeroX > 0) {
            Canvas canvas = canvases[(int) actualHeroX][(int) actualHeroY];
            actualHeroX -= 1;
            canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            canvas = canvases[(int) actualHeroX][(int) actualHeroY];
            hero.move(Direction.WEST, 1D);
            draw(canvas.getGraphicsContext2D(), canvas.getWidth()/2, canvas.getHeight()/2);
            getLogWhenMoved("West");
            roulette();
        }
    }

    @Override
    public void moveNorth(){
        if (actualHeroY > 0) {
            Canvas canvas = canvases[(int) actualHeroX][(int) actualHeroY];
            actualHeroY -= 1;
            canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            canvas = canvases[(int) actualHeroX][(int) actualHeroY];
            hero.move(Direction.NORTH, 1D);
            draw(canvas.getGraphicsContext2D(), canvas.getWidth()/2, canvas.getHeight()/2);
            getLogWhenMoved("North");
            roulette();
        }    }

    @Override
    public void moveSouth(){
        if (actualHeroY < mapGrid.getRowCount()-1) {
            Canvas canvas = canvases[(int) actualHeroX][(int) actualHeroY];
            actualHeroY += 1;
            canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            canvas = canvases[(int) actualHeroX][(int) actualHeroY];
            hero.move(Direction.SOUTH, 1D);
            draw(canvas.getGraphicsContext2D(), canvas.getWidth()/2, canvas.getHeight()/2);
            getLogWhenMoved("South");
            roulette();
        }
    }

    @Override
    public void moveEast(){
        if (actualHeroX < mapGrid.getColumnCount()-1) {
            Canvas canvas = canvases[(int) actualHeroX][(int) actualHeroY];
            actualHeroX += 1;
            canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            canvas = canvases[(int) actualHeroX][(int) actualHeroY];
            hero.move(Direction.EAST, 1D);
            draw(canvas.getGraphicsContext2D(), canvas.getWidth()/2, canvas.getHeight()/2);
            getLogWhenMoved("East");
            roulette();
        }
    }

    private void getLogWhenMoved(String direction) {
        IMapFragment frag = map.getFrags()[(int) actualHeroX][(int) actualHeroY];
        addNewLog("You move to the "+direction+"." + "You are passing a "+map.getFrags()[(int) actualHeroX][(int) actualHeroY].getImage());
        if (frag.getImage().equals("city")) addNewLog("The city is called "+frag.getName());
    }

    @Override
    public ICreature getHero() {
        return hero;
    }

    private void roulette() {
        int max = 10;
        int min = 1;
        int range = max - min + 1;
        int rand = (int)(Math.random() * range) + min;

        if (rand > 4) {
            drawHappening(new Happening("Simple test happening",
                    "Something has happened\nThis is a simple happening \nIt has happened suddenly\nWhat shall I do?",
                    "",
                    Happening.HappeningType.ACCIDENT,
                    Arrays.asList(
                            new Action("Move back"),
                            new Action("Run away"),
                            new Action("Run away ASAP")
                    )));
        }

    }

    private void initiateMap(Node[] nodes) {
        map = game.getMap();
        this.messagesList = (VBox) nodes[0];
        this.mapGrid = (GridPane) nodes[1];
        for (int y = 0; y < mapGrid.getRowCount(); y++) {
            for (int x = 0; x < mapGrid.getColumnCount(); x++) {
                Canvas background = new Canvas();
                background.setHeight(34);
                background.setWidth(36);
                background.getGraphicsContext2D().drawImage(new Image("/maps/"+map.getFrags()[x][y].getImage()+".jpg"), 0, 0);
                Canvas canvas = new Canvas();
                canvas.setHeight(34);
                canvas.setWidth(36);
//                canvas.setOnMouseClicked(event-> draw(canvas.getGraphicsContext2D(), canvas.getWidth()/2, canvas.getHeight()/2));
                mapGrid.add(background, x,y);
                canvases[x][y] = canvas;
                mapGrid.add(canvas, x, y);
            }
        }
    }

    private void initiateHero() {
        hero = game.getHero();

        hero.setX(actualHeroX);
        hero.setY(actualHeroY);

        draw(canvases[(int) actualHeroX][(int) actualHeroY].getGraphicsContext2D(), actualHeroX, actualHeroY);

    }

    private void draw(GraphicsContext context, double x, double y) {
//        context.setFill(Color.RED);
//        context.setStroke(Color.DARKGRAY);
//        context.fillOval(x-5,y-5,5*2,5*2);
//        context.strokeOval(x-5,y-5,5*2,5*2);
        context.drawImage(heroImage,0,0);
    }



    private void drawHappening(Happening happening) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                .getResource("/happeningDialog.fxml"));
        AnchorPane parent = null;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            addNewLog("Exception happened:");
            addNewLog(e.getMessage());
        }
        HappeningController controller = fxmlLoader.getController();
        controller.applyHappening(happening);
        if (parent != null) {
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setTitle("Happening");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            addNewLog("Stage >" + "Happening" + "< has been set");
        }
    }



}
