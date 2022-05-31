/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

//import com.sun.org.apache.xml.internal.utils.StopParseException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JFrame;

import javax.swing.JOptionPane;

//import sun.java2d.Disposer;
/**
 *
 * @author PC
 */
public class aserveur extends UnicastRemoteObject implements servinterface {

    public aserveur() throws RemoteException {
    }

    public void exe(String port) {
        try {

            servinterface service = new aserveur();
            LocateRegistry.createRegistry(Integer.parseInt(port));
            Naming.rebind("rmi://127.0.0.1:" + port + "/servinterface", service);
            System.out.println("server is ready .");
        } catch (Exception e) {
            System.out.println(" server failed:" + e);
            JOptionPane.showMessageDialog(new JFrame(), "LE SERVEUR N'EST PAS CONNECTER");
        }
    }

    @Override
    public char inter(char action) throws RemoteException, ServerNotActiveException {
        char result = ' ';

        System.out.println("a user has played: " + action);

        try {
            result = action;
            System.out.println(" has played" + action);

            Serv.traffic.add(result);
            int last = Serv.traffic.size();
            System.out.println("players number :" + Serv.traffic.get(last - 1));

        } catch (Exception e) {
            System.out.println("Error:" + e);
        }
        return result;
    }

    @Override
    public char checkRound() throws RemoteException, ServerNotActiveException {

        System.out.println("checkRound excuted");
        char roundAction = ' ';
        char won;
        won = ' ';
        try {

            int last = Serv.traffic.size();
            
            if (last == 2) {
                
                char lastAction = (char) Serv.traffic.get(last - 1);
                char beforelastAction = (char) Serv.traffic.get(last - 2);

                roundAction = (char) Serv.traffic.get(last - 1);

                if (lastAction == 'r' && beforelastAction == 's'
                        || lastAction == 'p' && beforelastAction == 'r'
                        || lastAction == 's' && beforelastAction == 'p') {
                    won = lastAction;
                    
                    
                }else if (lastAction == beforelastAction){
                    won = '1';
                    
                }
                else {
                    won = beforelastAction;
                    
                }

                System.out.println("last is :" + lastAction + " and before last is:" + beforelastAction);
                System.out.println("winner action is :" + won);
                
            }else{
                won ='0';
            }

        } catch (Exception e) {
            System.out.println("An error has occured:" + e);
        }
        
        //Serv.traffic.clear();
        return won;

    }
    
    public boolean setFinished(boolean finished){
        finished = false;
        if(finished){
            Serv.traffic.clear();
        }
        return finished;
    }

}
