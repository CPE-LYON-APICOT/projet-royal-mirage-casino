package tp.Enum;

public enum Figures {
    as, deux, trois, quatre, cinq, six, sept, huit, neuf, dix, valet, dame, roi;

    public static Figures getFigure(int index) {
        return Figures.values()[index];
    }
}