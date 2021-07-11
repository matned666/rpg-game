package eu.mrndesign.matned.rpggame.core.data.map;

public abstract class MapFragment implements IMapFragment{

    protected String name;

    protected Integer x;
    protected Integer y;

    protected IMapFragment eastNode;
    protected IMapFragment westNode;
    protected IMapFragment northNode;
    protected IMapFragment southNode;

    protected String imageName;
    private NodeType nodeType;

    public MapFragment(IMapFragment eastNode,
                       IMapFragment westNode, 
                       IMapFragment northNode, 
                       IMapFragment southNode, 
                       Integer x, Integer y) {
        this.eastNode = eastNode;
        this.westNode = westNode;
        this.northNode = northNode;
        this.southNode = southNode;
        this.x = x;
        this.y = y;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getX() {
        return x;
    }

    @Override
    public Integer getY() {
        return y;
    }

    @Override
    public void setX(Integer x) {
        this.x = x;
    }

    @Override
    public void setY(Integer y) {
        this.y = y;
    }

    public String getImage() {
        checkNodes();
        imageName += nodeType.name();
        return imageName;
    }

    private void checkNodes(){
        String map = "";
        map += checkInstance(eastNode, "E");
        map += checkInstance(westNode, "W");
        map += checkInstance(northNode, "N");
        map += checkInstance(southNode, "S");
        nodeType = NodeType.valueOf(map);
    }

    private String checkInstance(IMapFragment map, String sign){
        if (eastNode.isInstanceOf(this)){
            return  sign;
        }else return "";
    }

    private enum NodeType{
        E,
        W,
        N,
        S,
        EW,
        EN,
        ES,
        ENS,
        EWS,
        EWN,
        EWNS,
        WN,
        WS,
        WNS,
        NS,
        SINGLE
    }
}
