package Enum;

public enum Figures {
    AS, DEUX, TROIS, QUATRE, CINQ, SIX, SEPT, HUIT, NEUF, DIX, VALET, DAME, ROI;

    public static Figures getFigure(int index) {
        return Figures.values()[index];
    }
}