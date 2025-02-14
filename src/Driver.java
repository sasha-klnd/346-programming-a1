
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kerly Titus
 */
public class Driver {

    /** 
     * main class
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	 /*******************************************************************************************************************************************
    	  * TODO : implement all the operations of main class   																					*
    	  ******************************************************************************************************************************************/
        
    	Network objNetwork = new Network("network");            /* Activate the network */
        Server objServer = new Server();        
        Client receiveClient = new Client("receiving");
        Client sendClient = new Client("sending");
        
        Thread networkThread = new Thread(objNetwork);
        Thread serverThread = new Thread(objServer);
        Thread receiveThread = new Thread(receiveClient);
        Thread sendThread = new Thread(sendClient);

        networkThread.start();
        serverThread.start();
        receiveThread.start();
        sendThread.start();

        try {
            receiveThread.join();
            sendThread.join();
            networkThread.join();
            serverThread.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        
        /* Complete here the code for the main method ...*/
    }
}
