/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prog02_ejerc1;

/**
 * Operaciones con diferentes tipos de variables.
 * @author Raúl Vañes
 */
public class PROG02_Ejerc10 {
    public static void main(String[] args){
        //Conversiones entre enteros y coma flotante
        System.out.println("------- Conversiones entre enteros y coma flotante -------");
        float x=4.5f, y=3.0f; 
        int i=2,j;
        /*
        * Necesitamos hacer conversión explícita (casting de tipos). Puesto que el producto nos devuelve un float.
        */
        j=(int)(i*x); 

        System.out.printf("Producto de int por float: j = i * x = %d%n",j);
        
        double dx=2.0d, dz=dx*y; //No necesitamos hacer ninguna conversión explícita.
        
        System.out.printf("Producto de float por double: dz = dx * y = %.1f%n%n",dz); 
        
        //Operaciones con byte
        System.out.println("------- Operaciones con byte -------"); 
        byte bx=5,by=2;
        byte bz=(byte)(bx-by); //Debemos hacer conversión puesto que al realizar la resta nos devuelve un tipo entero (int).

        System.out.printf("byte: %d - %d = %d%n",bx,by,bz);
        
        bx=-128;
        by=1;
        bz=(byte)(bx-by); //Byte sólo alcanza hasta -128, si le restamos 1 nos da el máximo positivo que es 127.
        System.out.printf("byte: %d - %d = %d%n",bx,by,bz);
        System.out.printf("(int)(%d - %d) = %d%n%n",bx,by,(int)(bx-by));
        
        //Operaciones con short
        System.out.println("------- Operaciones con short -------");
        short sx=5,sy=2,sz;
        sz=(short)(sx-sy); //Al igual que byte debemos convertir el resultado de la resta porque nos devuelve un tipo entero.
        System.out.printf("short: %d - %d = %d%n",sx,sy,sz);
        sx=32767;
        sy=1;
        sz=(short)(sx+sy);
        System.out.printf("short: %d + %d = %d%n%n",sx,sy,sz);
        
        //Operaciones con char
        System.out.println("------- Operaciones con char -------");
        char cx='\u000F', cy='\u0001';
        int z=cx-cy; //No necesita casting

        System.out.printf("char: %c - %c = %d%n",cx,cy,z);
        z=cx-1; //No necesita casting
        
        //Para mostrar el valor en hexadecimal he utilizado el método String.format y he convertido de char a int.
        System.out.printf("char: (%s) - 1 = %d%n",String.format("0x%04X",(int)cx),z);
        
        cx='\uFFFF';
        z=cx;
        System.out.printf("(int) (%c) = %d%n",cx,z);
        
        sx=(short)cx;
        System.out.printf("(short) (%c) = %d%n",cx,sx);
        
        sx=-32768;
        cx=(char)sx;
        z=cx;
        System.out.printf("%d short-char-int = %d%n",sx,z);
        
        sx=-1;
        cx=(char)sx;
        z=cx;
        System.out.printf("%d short-char-int = %d%n",sx,z);
    }
}
