/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e09.sockets;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author riversong
 */
public class Cliente {
        
    public static void main (String args[]) throws UnknownHostException, IOException {    
 
        try (Socket cliente = new Socket ("127.0.0.1", 3000)) {
            System.out.println ("O cliente se conectou ao servidor" );
            
            Scanner teclado = new Scanner (System.in) ;
            PrintStream saida = new PrintStream ( cliente.getOutputStream () );
            
            while (teclado.hasNextLine()) {
                saida.println (teclado.nextLine());
            }
            
            saida.close();
            teclado.close();
        } catch(Exception err){
            System.out.println(err);                    
        }
        
        
    }
}
