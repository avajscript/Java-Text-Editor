package org.example.javafxfirst.constants.ui.themes;

public class ColorTheme {
    protected String themeName;
    protected int[] fontColor;
    protected int[] mainBackgroundColor;
    protected int[] secondaryBackgroundColor;

    public ColorTheme() {

    }

    public ColorTheme(String themeName, int[] fontColor, int[] mainBackgroundColor, int[] secondaryBackgroundColor) {
        this.themeName = themeName;
        this.fontColor = fontColor;
        this.mainBackgroundColor = mainBackgroundColor;
        this.secondaryBackgroundColor = secondaryBackgroundColor;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public int[] getFontColor() {
        return fontColor;
    }

    public void setFontColor(int[] fontColor) {
        this.fontColor = fontColor;
    }

    public int[] getMainBackgroundColor() {
        return mainBackgroundColor;
    }

    public void setMainBackgroundColor(int[] mainBackgroundColor) {
        this.mainBackgroundColor = mainBackgroundColor;
    }

    public int[] getSecondaryBackgroundColor() {
        return secondaryBackgroundColor;
    }

    public void setSecondaryBackgroundColor(int[] secondaryBackgroundColor) {
        this.secondaryBackgroundColor = secondaryBackgroundColor;
    }


}
