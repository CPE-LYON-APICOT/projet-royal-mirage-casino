package Enum;
public enum Types {
    PIQUE, COEUR, CARREAU, TREFLE;

    public static Types getType(int index) {
        return Types.values()[index];
    }
}