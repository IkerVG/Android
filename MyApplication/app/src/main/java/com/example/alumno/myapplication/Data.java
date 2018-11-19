package com.example.alumno.myapplication;

public class Data {
    // Cada opcion tiene un titulo y un subtitulo
    private int img;
    private String texto,txt2,txt3,txt4;

    public Data(int img, String texto, String txt2, String txt3, String txt4){
        this.img = img;
        this.texto = texto;
        this.txt2 = txt2;
        this.txt3 = txt3;
        this.txt4 = txt4;
    }

    public int getTitulo(){
        return img;
    }

    public String getSubtitulo(){
        return texto;
    }
    public String getSubtitulo2(){
        return txt2;
    }
    public String getSubtitulo3(){
        return txt3;
    }
    public String getSubtitulo4(){
        return txt4;
    }
}
