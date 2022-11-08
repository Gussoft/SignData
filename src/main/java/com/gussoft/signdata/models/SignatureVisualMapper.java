package com.gussoft.signdata.models;

public class SignatureVisualMapper {

    private String x;
    private String y;
    private String alto;
    private String ancho;
    private String page;
    private Integer sizeText;

    public SignatureVisualMapper() {
    }

    public SignatureVisualMapper(String x, String y, String alto, String ancho, String page) {
        this.x = x;
        this.y = y;
        this.alto = alto;
        this.ancho = ancho;
        this.page = page;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getAlto() {
        return alto;
    }

    public void setAlto(String alto) {
        this.alto = alto;
    }

    public String getAncho() {
        return ancho;
    }

    public void setAncho(String ancho) {
        this.ancho = ancho;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Integer getSizeText() {
        return sizeText;
    }

    public void setSizeText(Integer sizeText) {
        this.sizeText = sizeText;
    }
}
