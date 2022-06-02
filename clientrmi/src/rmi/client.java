package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class client {

    public char exe_client(char action, String ipaddrs, String port) throws NotBoundException, MalformedURLException, RemoteException, ServerNotActiveException {
        
        char v = ' ';

        System.out.println("ip addr:" + ipaddrs + "  port:" + port);
        servinterface lp = (servinterface) Naming.lookup("rmi://" + ipaddrs + ":" + port + "/servinterface");
        System.out.println("ddddddddddddd ");

        v = lp.inter(action);

        return v;
    }

    public char exe_cli_somme(char c, String u, String ee) throws NotBoundException, MalformedURLException, RemoteException, ServerNotActiveException {
        System.out.println("exec_cli_client excuted");
        //char v = 0;
    
        System.out.println("ip Address: " + u + " / port: " + ee);
        servinterface lp = (servinterface) Naming.lookup("rmi://" + u + ":" + ee + "/servinterface");
        System.out.println("client has connceted to server");
    
        //v = lp.checkRound();
        
        return lp.checkRound();
        
    }
    
    
    
    public void clearGame(String u, String ee)throws NotBoundException, MalformedURLException, RemoteException, ServerNotActiveException{
        /*servinterface lp = (servinterface) Naming.lookup("rmi://" + u + ":" + ee + "/servinterface");
        lp.setFinished();*/
        System.out.println("***** ** **  ** ROUND ENDED ** ** ** ****");
    }
    
    public static void main(String[] argv) {

    }

}
