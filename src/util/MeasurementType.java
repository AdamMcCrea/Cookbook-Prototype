package util;

public class MeasurementType {
    enum Type{
        GRAMS,
        TSP,
        TBSP,
        ML,
        COUNT,
        CLOVE
    }
    private Type type;

    public Type getType() {
        return type;
    }

    public String toString() {
        if(this.type == Type.GRAMS){
            return "g";
        } else if (this.type == Type.TSP) {
            return "tsp";
        } else if (this.type == Type.TBSP) {
            return "tbsp";
        } else if (this.type == Type.ML) {
            return "mls";
        } else if (this.type == Type.CLOVE) {
            return "clove(s)";
        } else if (this.type == Type.COUNT) {
            return "";
        }
        return null;
    }
}
