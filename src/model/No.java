/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Leo
 */
public class No {

    private No esquerda;
    private No direita;
    private No pai;
    private int id;
    private int equilibrar;

    public No(int value) {
        setEsquerda(null);
        setDireita(null);
        setPai(null);
        setEquilibrar(0);
        setId(value);
    }

    public String toString() {
        return Integer.toString(getId());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEquilibrar() {
        return equilibrar;
    }

    public void setEquilibrar(int equilibrar) {
        this.equilibrar = equilibrar;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }
}
