package tp.Enum;
public enum Types {
    pique, coeur, carreau, trefle;

    public static Types getType(int index) {
        return Types.values()[index];
    }
}