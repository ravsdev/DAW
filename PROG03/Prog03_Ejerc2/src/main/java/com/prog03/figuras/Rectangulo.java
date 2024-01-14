/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prog03.figuras;

/**
 *
 * @author Raúl Vañes
 */
public class Rectangulo {
    //Atributos de la clase Rectangulo
    private float base;
    private float altura;
    
    //Constructores
    public Rectangulo(){
        base=0F;
        altura=0F;
    }
    
    public Rectangulo(float base, float altura){
        this.base=base;
        this.altura=altura;
    }
    
    //Métodos GET
    public float getBase(){
        return base;
    }
    
    public float getAltura(){
        return altura;
    }
    
    //Métodos SET
    public void setBase(float base){
        this.base=base;
    }
        
    public void setAltura(float altura){
        this.altura=altura;
    }
    
    //Método para obtener el área del rectángulo
    public float getArea(){
        return base*altura;
    }
    
    //Método para obtener una cadena con el área y la altura del rectángulo
    @Override
    public String toString(){
        return "El área del rectángulo es "+getArea()+" y su altura es "+altura;
    }
    
    //Método que devuelve si el rectángulo es cuadrado
    public boolean isCuadrado(){
        return base==altura;
    }
}
