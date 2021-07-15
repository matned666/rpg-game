package eu.mrndesign.matned.rpggame.javafx;

import eu.mrndesign.matned.rpggame.core.data.items.IInventory;
import eu.mrndesign.matned.rpggame.core.game.IHero;
import eu.mrndesign.matned.rpggame.javafx.service.IPointService;
import eu.mrndesign.matned.rpggame.javafx.service.PointService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class BackpackElementController implements Initializable {

    @FXML
    private VBox backpackItemVBox;

    @FXML
    private ImageView backPackItemImage;

    private IPointService service;
    private IHero hero;
    private IInventory item;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.service = PointService.getInstance();
        hero = service.getHero();
    }

    public void setItem(IInventory item){
        this.item = item;
        IInventory.addLabel(backpackItemVBox, item);
        backPackItemImage.setImage(new Image("/slots/"+item.getInventoryType().getImage()+".jpg"));
    }


    @FXML
    public void onBackPackItemPutOnSlot1(){
        hero.putItemOnSlot1(item);
    }

    @FXML
    public void onBackPackItemPutOnSlot2(){
        hero.putItemOnSlot2(item);
    }

    @FXML
    public void onBackPackItemUse(){
        hero.useItem(item);
    }

    @FXML
    public void onBackPackItemDrop(){
        hero.dropItem(item);
    }

}
