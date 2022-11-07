package com.antoniaggo.mismascotas.pojo;

public class Mascota {
    private int foto;
    private String nombre;
    private int likes;
    private boolean isButtonClicked;

    public Mascota(int foto, String nombre, int likes) {
        this.foto = foto;
        this.nombre = nombre;
        this.likes = likes;
        this.isButtonClicked = false;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isButtonClicked() {
        return isButtonClicked;
    }

    public void setButtonClicked(boolean buttonClicked) {
        isButtonClicked = buttonClicked;
    }


}
