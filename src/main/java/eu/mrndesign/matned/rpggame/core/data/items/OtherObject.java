package eu.mrndesign.matned.rpggame.core.data.items;

public class OtherObject extends BaseObject implements IGameObject {


    public OtherObject(OtherObjectDTOBuilder builder) {
        this.id = builder.id;
        this.symbol = builder.symbol;
        this.image = builder.image;
        this.x = builder.x;
        this.y = builder.y;
        this.pV = builder.pV;
        this.dV = builder.dV;
        this.weight = builder.weight;
        this.name = builder.name;
        this.hP = builder.HP;
        this.isVisible = builder.isVisible;
        this.isFireproof = builder.isFireproof;
        this.isWaterproof = builder.isWaterproof;
    }

    public static class OtherObjectDTOBuilder {

        private Long id;
        private final Symbol symbol;
        private String name;
        private String image;
        private int HP;
        private Integer pV;
        private Integer dV;
        private Double x;
        private Double y;
        private Double weight;
        private boolean isVisible;
        private boolean isFireproof;
        private boolean isWaterproof;

        public OtherObjectDTOBuilder(Symbol symbol) {
            this.symbol = symbol;
        }

        public OtherObjectDTOBuilder HP(int HP) {
            this.HP = HP;
            return this;
        }

        public OtherObjectDTOBuilder image(String image) {
            this.image = image;
            return this;
        }

        public OtherObjectDTOBuilder x(Double x) {
            this.x = x;
            return this;
        }

        public OtherObjectDTOBuilder y(Double y) {
            this.y = y;
            return this;
        }

        public OtherObjectDTOBuilder pV(Integer pV) {
            this.pV = pV;
            return this;
        }

        public OtherObjectDTOBuilder dV(Integer dV) {
            this.dV = dV;
            return this;
        }

        public OtherObjectDTOBuilder weight(Double weight) {
            this.weight = weight;
            return this;
        }

        public OtherObjectDTOBuilder isVisible(boolean isVisible) {
            this.isVisible = isVisible;
            return this;
        }

        public OtherObjectDTOBuilder isFireproof(boolean isFireproof) {
            this.isFireproof = isFireproof;
            return this;
        }

        public OtherObjectDTOBuilder isWaterproof(boolean isWaterproof) {
            this.isWaterproof = isWaterproof;
            return this;
        }


        public OtherObjectDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public OtherObjectDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public OtherObject build() {
            return new OtherObject(this);
        }
    }
}
