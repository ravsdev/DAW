/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteFecha;

/**
 *
 * @author Raúl Vañes
 */
public class Fecha {
    //Atributos de la clase Fecha
    public enum enumMes{ENERO,FEBRERO,MARZO,ABRIL,MAYO,JUNIO,JULIO,AGOSTO,SEPTIEMBRE,OCTUBRE,NOVIEMBRE,DICIEMBRE};
    private int dia,anio;
    private enumMes mes;
    
    //Constructor sólo con el parámetro mes
    public Fecha(enumMes mes){
        this.mes=mes;
        this.dia=0;
        this.anio=0;
    }
    
    //Constructor con todos los parámetros
    public Fecha(int dia,enumMes mes, int anio){
        this.mes=mes;
        this.dia=dia;
        this.anio=anio;
    }
    
    //Métodos GET
    public int getDia(){
        return dia;
    }
    
    public enumMes getMes(){
        return mes;
    }
    
    public int getAnio(){
        return anio;
    }
    
    //Métodos SET
    public void setDia(int dia){
        this.dia=dia;
    }
    
    public void setMes(enumMes mes){
        this.mes=mes;
    }
    
    public void setAnio(int anio){
        this.anio=anio;
    }
    
    //Comprobamos si la fecha es verano
    public boolean isSummer(){
        boolean verano;
        verano=false;
        //He utilizado un SWITCH para comprobar si la fecha actual es verano
        switch(mes){
            case JUNIO:
                if(this.dia>=21) verano=true;
                break;
            case JULIO:
            case AGOSTO:
                verano=true;
                break;
            case SEPTIEMBRE:
                if(this.dia<=22) verano=true;
                break;
            default:
                verano=false;
        }
        return verano;
    }
    
    @Override
    public String toString(){
        return dia+" de "+mes.name().toLowerCase()+" de "+anio;
    }
}
