/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rmi;

import java.lang.reflect.Array;
import java.rmi.*;
import java.rmi.server.ServerNotActiveException;
import java.util.Vector;

/**
 *
 * @author PC
 */

public interface servinterface extends Remote {
public char inter (char a) throws RemoteException,ServerNotActiveException;
public char checkRound () throws RemoteException,ServerNotActiveException;
public boolean setFinished(boolean finished) throws RemoteException,ServerNotActiveException;

}
