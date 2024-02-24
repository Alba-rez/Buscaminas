package interfacebuscaminas;

import buscaminas.Buscaminas;

import java.util.Scanner;

public class Interface {
    Scanner sc = new Scanner(System.in);

    Buscaminas busca;

    public static void main(String[] args) {
    Interface inter=new Interface();
    inter.jugar();

    }
    public void jugar(){
        System.out.println("Indique número de filas del tablero");
        int filas=sc.nextInt();
        System.out.println("Indique número de columnas del tablero");
        int columnas=sc.nextInt();
        System.out.println("Indique número de minas que tendrá el tablero");
        int numMinas=sc.nextInt();
        busca=new Buscaminas(filas, columnas, numMinas);
        dibujarTablero();
        while(!busca.isHayMina()){
            System.out.println("Indique posición en el tablero a destapar");
            busca.destaparCasilla(sc.nextInt(),sc.nextInt());
            dibujarTablero();
            ganador();
        }
        if(busca.isHayMina()){
            System.out.println("Has perdido!");
        }
        mostrarTableroCompleto();
    }

    private void dibujarTablero(){
        char [][] tablero=busca.verTableroVista();
        for(int i=0; i<busca.getFilas(); i++){

            for(int j=0; j<busca.getColumnas(); j++){
                System.out.print("----");
            }
            System.out.println("-");

            for(int j=0; j<busca.getColumnas(); j++){
                System.out.print("| "+tablero[i][j]+" ");
            }
            System.out.println("|");
        }

        for(int j=0; j<busca.getColumnas(); j++){
            System.out.print("----");
        }
        System.out.println("-");
    }
    private void mostrarTableroCompleto () {
        for (int i = 0; i < busca.verFilas(); i++) {
            for (int j = 0; j < busca.verColumnas(); j++) {
                System.out.print(busca.verTablero()[i][j] + " ");
            }
            System.out.println();
        }
    }
 private void ganador(){

     if(busca.getComprobarCasillas()){
         System.out.println("Has ganado!!") ;
         mostrarTableroCompleto();
         System.exit(0);
     }

 }

}
