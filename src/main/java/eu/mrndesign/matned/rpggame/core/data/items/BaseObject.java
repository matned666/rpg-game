package eu.mrndesign.matned.rpggame.core.data.items;


import eu.mrndesign.matned.rpggame.core.data.items.utils.Direction;

public abstract class BaseObject implements IGameObject {

    protected Long id;
    protected Integer pV;
    protected Integer dV;
    protected Symbol symbol;
    protected Double x;
    protected Double y;
    protected Double weight;
    protected String name;
    protected String image;
    protected Integer hP;
    protected boolean isVisible;
    protected boolean isFireproof;
    protected boolean isWaterproof;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public void hit(int hP) {
        this.hP -= hP;
    }

    @Override
    public int getHP() {
        return hP;
    }

    @Override
    public void setX(double x) {
        this.x = x;
    }

    @Override
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public Double getX() {
        return x;
    }

    @Override
    public Double getY() {
        return y;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public void setName(String newName) {
        this.name = newName;
    }

    @Override
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public void setVisibility() {
        this.isVisible = !isVisible;
    }


    @Override
    public boolean collide(Direction direction, IGameObject collider) {
        return (Direction.changeX(direction) + collider.getX() == this.x) &&
                (Direction.changeY(direction) + collider.getY() == this.y);
    }
    @Override
    public boolean isWaterproof() {
        return isWaterproof;
    }

    @Override
    public void setWaterproof() {
        this.isWaterproof = !isWaterproof;
    }

    @Override
    public boolean isFireproof() {
        return isFireproof;
    }

    @Override
    public void setFireproof() {
        isFireproof = !isFireproof;
    }

    @Override
    public Integer getDV() {
        return dV;
    }

    @Override
    public Integer getPV() {
        return pV;
    }
}
