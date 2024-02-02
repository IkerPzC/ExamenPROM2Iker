package com.example.examen2ev;

public class ElementoQuimico {
    private int id;
    private String nombre;
    private String simbolo;
    private int numAtomico;
    private String estado;

    public ElementoQuimico(int id, String nombre, String simbolo, int numAtomico, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.numAtomico = numAtomico;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public int getNumAtomico() {
        return numAtomico;
    }

    public void setNumAtomico(int numAtomico) {
        this.numAtomico = numAtomico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
