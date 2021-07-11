package eu.mrndesign.matned.rpggame.core.data.happening;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Happening {

    private String title;
    private String description;
    private String image;
    private HappeningType happeningType;
    private final List<Action> actions;

    public Happening() {
        this.actions = new LinkedList<>();
    }

    public Happening(String title, String description, String image, HappeningType happeningType, List<Action> actions) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.happeningType = happeningType;
        this.actions = new LinkedList<>();
        this.actions.addAll(actions);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public HappeningType getHappeningType() {
        return happeningType;
    }

    public void setHappeningType(HappeningType happeningType) {
        this.happeningType = happeningType;
    }

    public List<Action> getActions() {
        return actions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Happening happening = (Happening) o;
        return Objects.equals(title, happening.title) && Objects.equals(description, happening.description) && Objects.equals(image, happening.image) && happeningType == happening.happeningType && Objects.equals(actions, happening.actions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, image, happeningType, actions);
    }

    public enum HappeningType{
        FIGHT,
        SHOP,
        PERSON,
        ACCIDENT;
    }
}
