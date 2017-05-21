/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ferreira
 */
class Plotadora implements Runnable{
    int time,prevValue;
    Graphics2D g;

    public Plotadora(Graphics2D g) {
        this.g = g;
        time=0;
        prevValue=0;
    }
    
    @Override
    public void run() {
        g.setStroke(new BasicStroke(1));
        g.setColor(Color.gray);
        for(int i = 0; i < 60; i++){
            g.drawLine(0, i*10, 600, i*10);
        }
        for(int i = 0; i < 60; i++){
            g.drawLine(i*10, 0, i*10, 600);
        }
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.red);
        while(true){
           // g.drawLine(0, 400, 100, 100); 
           g.drawLine(time, 300-prevValue, time+1, 300-TCPServer.value); 
           prevValue = TCPServer.value;
           time=time+1;            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Plotadora.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
    
}
}
