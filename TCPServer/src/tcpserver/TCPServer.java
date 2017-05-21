/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ferreira
 */

public class TCPServer implements Runnable {
  public static int value;
  ServerSocket servidor;
  
  //public void main(String[] args) {
    //public void InitSis() {
    public void startServer() throws IOException{
    try {
      // Instancia o ServerSocket ouvindo a porta 12345
      String clientSentence;
      servidor = new ServerSocket(9000);
      System.out.println("Servidor ouvindo a porta 9000");
      Socket cliente = servidor.accept();
      System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
      while(true){
        // o método accept() bloqueia a execução até que
        // o servidor receba um pedido de conexão
        BufferedReader inFromClient = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        clientSentence = inFromClient.readLine();
        TCPServer.value = Integer.valueOf(clientSentence);
        //System.out.println(clientSentence);
     //   setClientSentence(inFromClient.readLine());
        //inFromClient.close();
      }  
    }   
    catch(Exception e) {
       System.out.println("Erro: " + e.getMessage());
       TCPServer.value=0;
       servidor.close();
       
       
    }
  }     

    @Override
    public void run() {
 
    while(true){
        try {
            startServer();
        } catch (IOException ex) {
            Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    }
}

