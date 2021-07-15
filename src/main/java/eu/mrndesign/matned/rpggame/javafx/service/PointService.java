package eu.mrndesign.matned.rpggame.javafx.service;

import eu.mrndesign.matned.rpggame.core.IObserver;
import eu.mrndesign.matned.rpggame.core.data.map.IMapFragment;
import eu.mrndesign.matned.rpggame.core.game.Game;
import eu.mrndesign.matned.rpggame.core.game.Hero;
import eu.mrndesign.matned.rpggame.core.game.IHero;
import eu.mrndesign.matned.rpggame.core.game.Map;
import eu.mrndesign.matned.rpggame.javafx.utils.Variables;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * Service singleton class
 * created to have the same instance for all classes
 */

public class PointService implements IPointService, IObserver {

    public static final int MAP_WIDTH = 35;
    public static final int MAP_HEIGHT = 20;
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
    private VBox messagesList;
    private Game game;
    private IHero hero;
    private Canvas[][] backgrounds;
    private Canvas[][] canvases;
    private Image heroImage;

    private PointService() {
        if (instance != null) {
            throw new IllegalStateException("Cannot create new instance, please use getInstance method instead.");
        } else {
            instance = this;
        }
    }

    @Override
    public void initiate(Node... nodes) {
        heroImage = new Image("/hero.png");
        backgrounds = new Canvas[MAP_WIDTH][MAP_HEIGHT];
        canvases = new Canvas[MAP_WIDTH][MAP_HEIGHT];
        game = new Game();
        map = game.getMap();
        initiateMap(nodes);
        initiateHero();
        removeFog();

    }

    @Override
    public void addNewLog(String text) {
        messagesList.getChildren().add(new Label("> " + text));
    }

    @Override
    public void moveWest() {
        hero.moveWest();
    }

    @Override
    public void moveNorth() {
        hero.moveNorth();
    }

    @Override
    public void moveSouth() {
        hero.moveSouth();
    }

    @Override
    public void moveEast() {
        hero.moveEast();
    }

    @Override
    public IHero getHero() {
        return hero;
    }

    @Override
    public void update(String action) {
        switch (action) {
            case "MOVE_WEST": {
                switchWest();
                break;
            }
            case "MOVE_EAST": {
                switchEast();
                break;
            }
            case "MOVE_NORTH": {
                switchNorth();
                break;
            }
            case "MOVE_SOUTH": {
                switchSouth();
                break;
            }
            case Hero.CANNOT_PUT_ITEM_ON:{
                addNewLog("This item cannot be worn.");
                break;
            }
        }
    }

    private void roulette() {
//        int max = 10;
//        int min = 1;
//        int range = max - min + 1;
//        int rand = (int) (Math.random() * range) + min;
//
//        if (rand > 4) {
//            drawHappening(new Happening("Simple test happening",
//                    "Something has happened\nThis is a simple happening \nIt has happened suddenly\nWhat shall I do?",
//                    "",
//                    Happening.HappeningType.ACCIDENT,
//                    Arrays.asList(
//                            new Action("Move back"),
//                            new Action("Run away"),
//                            new Action("Run away ASAP")
//                    )));
//        }

    }

    private void initiateMap(Node[] nodes) {
        map = game.getMap();
        this.messagesList = (VBox) nodes[0];
        GridPane mapGrid = (GridPane) nodes[1];
        for (int y = 0; y < mapGrid.getRowCount(); y++) {
            for (int x = 0; x < mapGrid.getColumnCount(); x++) {
                Canvas background = new Canvas();
                background.setHeight(34);
                background.setWidth(36);
                background.getGraphicsContext2D().drawImage(new Image("/maps/fog.jpg"), 0, 0);
                backgrounds[x][y] = background;
                Canvas canvas = new Canvas();
                canvas.setHeight(34);
                canvas.setWidth(36);
                mapGrid.add(background, x, y);
                canvases[x][y] = canvas;
                mapGrid.add(canvas, x, y);
            }
        }

    }

    private void removeFog() {
        backgrounds[(int) actualHeroX][(int) actualHeroY].getGraphicsContext2D().drawImage(new Image("/maps/" + map.getFrags()[(int) actualHeroX][(int) actualHeroY].getImage() + ".jpg"), 0, 0);
        if (actualHeroY < MAP_HEIGHT-1) {
            backgrounds[(int) actualHeroX][(int) actualHeroY + 1].getGraphicsContext2D().drawImage(new Image("/maps/" + map.getFrags()[(int) actualHeroX][(int) actualHeroY + 1].getImage() + ".jpg"), 0, 0);
        }
        if (actualHeroY > 0) {
            backgrounds[(int) actualHeroX][(int) actualHeroY - 1].getGraphicsContext2D().drawImage(new Image("/maps/" + map.getFrags()[(int) actualHeroX][(int) actualHeroY - 1].getImage() + ".jpg"), 0, 0);
        }
        if (actualHeroX < MAP_WIDTH-1) {
            backgrounds[(int) actualHeroX + 1][(int) actualHeroY].getGraphicsContext2D().drawImage(new Image("/maps/" + map.getFrags()[(int) actualHeroX + 1][(int) actualHeroY].getImage() + ".jpg"), 0, 0);
        }
        if (actualHeroX > 0) {
            backgrounds[(int) actualHeroX - 1][(int) actualHeroY].getGraphicsContext2D().drawImage(new Image("/maps/" + map.getFrags()[(int) actualHeroX - 1][(int) actualHeroY].getImage() + ".jpg"), 0, 0);
        }
    }


    private void initiateHero() {
        game.initiate(this);
        map = game.getMap();
        hero = game.getHero();
        actualHeroY = hero.getY();
        actualHeroX = hero.getX();
        draw(canvases[(int) actualHeroX][(int) actualHeroY].getGraphicsContext2D());

    }

    private void draw(GraphicsContext context) {
        context.drawImage(heroImage, 0, 0);
    }


//    private void drawHappening(Happening happening) {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass()
//                .getResource("/happeningDialog.fxml"));
//        AnchorPane parent = null;
//        try {
//            parent = fxmlLoader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//            addNewLog("Exception happened:");
//            addNewLog(e.getMessage());
//        }
//        HappeningController controller = fxmlLoader.getController();
//        controller.applyHappening(happening);
//        if (parent != null) {
//            Scene scene = new Scene(parent);
//            Stage stage = new Stage();
//            stage.setTitle("Happening");
//            stage.initModality(Modality.APPLICATION_MODAL);
//            stage.setScene(scene);
//            stage.setResizable(false);
//            stage.show();
//            addNewLog("Stage >" + "Happening" + "< has been set");
//        }
//    }


    private void switchSouth() {
        switchDirection("South");
    }

    private void switchNorth() {
        switchDirection("North");
    }

    private void switchEast() {
        switchDirection("East");
    }

    private void switchWest() {
        switchDirection("West");
    }

    private void switchDirection(String subtitle){
        updateXY();
        canvases[hero.getPrevX()][hero.getPrevY()].getGraphicsContext2D().clearRect(0, 0, Variables.MAP_FRAGMENT_X, Variables.MAP_FRAGMENT_Y);
        draw(canvases[(int) actualHeroX][(int) actualHeroY].getGraphicsContext2D());
        getLogWhenMoved(subtitle);
        removeFog();
        roulette();
    }

    private void updateXY() {
        actualHeroX = hero.getX();
        actualHeroY = hero.getY();
    }

    private void getLogWhenMoved(String direction) {
        IMapFragment frag = map.getFrags()[(int) actualHeroX][(int) actualHeroY];
        addNewLog("You move to the " + direction + "." + "You are passing a " + map.getFrags()[(int) actualHeroX][(int) actualHeroY].getImage());
        if (frag.getImage().equals("city")) addNewLog("The city is called " + frag.getName());
    }
}
