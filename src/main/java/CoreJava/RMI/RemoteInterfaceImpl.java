package CoreJava.RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteInterfaceImpl extends UnicastRemoteObject implements RemoteInterface {
    RemoteInterfaceImpl() throws RemoteException {
        super();
    }

    public int add(int x, int y) throws RemoteException
    {
        return x+y;
    }

}
