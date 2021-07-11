package eu.mrndesign.matned.rpggame.core.data.items;

import javafx.scene.paint.Color;

import java.util.Objects;

public class Symbol implements ISymbol {

    private final Character symbol;
    private final Color color;

    public Symbol(Character symbol, Color color) {
        this.symbol = symbol;
        this.color = color;
    }

    @Override
    public Character getSymbol() {
        return symbol;
    }

    @Override
    public Color getColor() {
        return color;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol1 = (Symbol) o;
        return symbol == symbol1.symbol && color.equals(symbol1.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, color);
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "symbol=" + symbol +
                ", color=" + color.toString() +
                '}';
    }


}
