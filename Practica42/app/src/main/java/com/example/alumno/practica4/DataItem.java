package com.example.alumno.practica4;

public class DataItem {
    // Cada opcion tiene un titulo y un subtitulo
    private int img;
    private String texto;

    public DataItem(int img, String texto){
        this.img = img;
        this.texto = texto;
    }

    public int getTitulo(){
        return img;
    }

    public String getSubtitulo(){
        return texto;
    }

}
