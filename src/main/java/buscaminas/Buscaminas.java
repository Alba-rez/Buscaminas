package buscaminas;

public class Buscaminas {
    private int filas;
    private int columnas;
    private int numMinas;
    private char [][] tablero;
    private char [][] tableroVista;
    private char caracter='#';
    private boolean hayMina=false;

    /**
     * Constructor de la clase Buscaminas
     * @param filas numero de filas del tablero
     * @param columnas numero de columnas del tablero
     * @param numMinas numero de minas en el tablero
     */


    public Buscaminas(int filas, int columnas, int numMinas){
        this.filas=filas;
        this.columnas=columnas;
        this.numMinas=numMinas;
        this.tablero=new char[filas][columnas];
        this.tableroVista=new char[filas][columnas];


        for(int i=0;i< tablero.length;i++){
            for(int j=0;j<tablero[i].length;j++){

                tableroVista[i][j]=caracter;
                tablero[i][j]='-';
            }
        }
        colocarMinas();
    }

    private void colocarMinas(){
        int minas=0;
        while(minas<numMinas){
            int fila=(int)(Math.random()*filas);
            int columna=(int)(Math.random()*columnas);
            if(tablero[fila][columna]!='*'){
                tablero[fila][columna]='*';
                minas++;
            }
        }
    }


    /**
     * Destapa una casilla del tablero
     * @param fila fila de la casilla a destapar
     * @param columna columna de la casilla a destapar
     */

    public void destaparCasilla(int fila,int columna){
        if(tablero[fila][columna] != '*'){
            tableroVista[fila][columna] = contarMinas(fila,columna);
            if (tableroVista[fila][columna] == '0') {
                casillasVacias(fila, columna,true);
            }
        }else{
            tableroVista[fila][columna] = '*';
            hayMina = true;
        }
    }
    private char contarMinas(int fila, int columna) {
        int minas = 0;
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i >= 0 && i < filas && j >= 0 && j < columnas && tablero[i][j] == '*') {
                    minas++;
                }
            }
        }
        return (char) (minas + '0');
    }


    private void casillasVacias(int fila, int columna,boolean esCasillaOriginal) {
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i >= 0 && i < filas && j >= 0 && j < columnas && tableroVista[i][j] == caracter) {
                    tableroVista[i][j] = contarMinas(i, j);
                    if (tableroVista[i][j] == '0' && esCasillaOriginal) {
                        casillasVacias(i, j,false);
                    }
                }
            }
        }
    }

    /**
     * Comprueba si todas las casillas sin minas estan destapadas
     * @return true si todas las casillas sin minas están destapadas, false en caso contrario
     */

    private boolean comprobarCasillas(){
        int casillasTapadas=0;
        for(int i=0;i<filas;i++){
             for(int j=0;j<columnas;j++){
                if(tableroVista[i][j]==caracter){
                casillasTapadas++;
                }
             }
        }
        return casillasTapadas==numMinas;
    }

    public boolean getComprobarCasillas(){
        return comprobarCasillas();
    }

    /**
     * Obtiene el numero de minas del tablero
     * @return numero de minas
     */

    public int getNumMinas() {

        return numMinas;
    }

    public void setNumMinas(int numMinas) {

        this.numMinas = numMinas;
    }

    /**
     * Obtiene el tablero de minas
     * @return tablero de minas
     */

    public char[][] getTablero() {

        return tablero;
    }

    public char [][]verTablero(){
        return getTablero();
    }

    public void setTablero(char[][] tablero) {

        this.tablero = tablero;
    }
    /**
     * Obtiene el tablero a la vista del jugador
     * @return tablero a la vista del jugador
     */

    public char[][] getTableroVista() {

        return tableroVista;
    }

    /**
     * Obtiene el tablero a la vista del jugador
     * @return metodo que devuelve tablero a la vista del jugador
     */
    public char[][] verTableroVista(){
        return getTableroVista();
    }

    public void setTableroVista(char[][] tableroVista) {

        this.tableroVista = tableroVista;
    }

    /**
     * Obtiene el caracter que representa una casilla tapada
     * @return caracter que representa una casilla tapada
     */

    public char getCaracter() {

        return caracter;
    }

    /**
     * Obtiene el caracter que representa una casilla tapada
     * @return metodo que devuelve el caracter que representa una casilla tapada
     */
    private char caracter(){

        return getCaracter();
    }

    public void setCaracter(char caracter) {

        this.caracter = caracter;
    }

    public boolean isHayMina() {

        return hayMina;
    }
    /**
     * Comprueba si hay una mina en la casilla destapada
     * Devuelve true si hay una mina, false en caso contrario
     */

    public void setHayMina(boolean hayMina) {

        this.hayMina = hayMina;
    }
    /**
     * Obtiene el numero de filas del tablero
     * @return numero de filas
     */

    public int getFilas() {

        return filas;
    }
    /**
     * Obtiene el numero de filas del tablero
     * @return un metodo que devuelve el numero de filas
     */
    public int verFilas(){
        return getFilas();
    }

    public void setFilas(int filas) {

        this.filas = filas;
    }
    /**
     * Obtiene el numero de columnas del tablero
     * @return numero de columnas
     */

    public int getColumnas() {

        return columnas;
    }
    /**
     * Obtiene el numero de columnas del tablero
     * @return un metodo que devuleve el numero de columnas
     */
    public int verColumnas(){
        return getColumnas();
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
}
