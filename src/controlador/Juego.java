package controlador;


import java.util.logging.Level;
import java.util.logging.Logger;
import vista.Ventana;


public class Juego {
    
    
    int tiempoSegundos = 0;
    int tiempoCiclos = 0;
    boolean abierto = true;
    Ventana ventana;
    int fps = 60;
    
    
    
    public static void main(String[] args) {
        Juego juego = new Juego();
    }
   
    
    public Juego() {    //empieza
        
        ventana = new Ventana();
        ventana.setVisible(true);
        ventana.muestraFps.setText(Integer.toString(fps));
        ventana.tiempoCiclos.setText("tiempoCiclos"+Integer.toString(fps)+"Fps");
        actualiza();
    }
    
    void muestraSegundos() {
        tiempoSegundos=tiempoCiclos/fps;
        ventana.muestraTiempoSegundos.setText(Integer.toString(tiempoSegundos));
        
    }

    

        
    
    void esperaFrame() {
        try {
                Thread.sleep(1000/fps);
            } 
        catch (InterruptedException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    
    private void actualiza() {
        while (abierto) {
        
            tiempoCiclos++;
            ventana.muestraTiempoCiclos.setText(Integer.toString(tiempoCiclos));
            muestraSegundos();
            esperaFrame();
        }
    }
}
