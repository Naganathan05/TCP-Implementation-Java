import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
* This Class acts as a client for receiving a file that is sent
* by the server 
*/

public class Client{
  
  // creating a object of class MySocket for initiating the communication
  MySocket clientsocket;

  public static void main(String[] args){
    
    // Creating Object of client class to access its non static data members and methods
    Client clt = new Client();
    try{

      // Initialising the socket using constructors of MySocket class
      clt.clientsocket = new MySocket(5656,InetAddress.getByName(args[0]), Integer.parseInt(args[1]));
      System.out.println("Succesfully Handshake Done !!!");
    }
    catch(NumberFormatException e1){
      e1.printStackTrace();
    }

    // Requesting name of the file from the server
    clt.requestfile("sendfileName");
    MyPacket filepacket = clt.clientsocket.listen();

    // Requesting file data from the server
    String filename = new String(filepacket.data);
    clt.requestfile("sendFile");

    // Receiving File data sent by the server
    byte[] filedata = (clt.clientsocket.listen()).data;

    // Creating a new file and writing the data of received file int it.
    try{
      file = new FileOutputStream("x" + filename);
      file.write(filedata);
      file.close();
    }
    catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
    catch (IOException e) {
			e.printStackTrace();
		} 
    
  }

  //method to send request msg to server
	void requestFile(String rqstMsg){
		byte[] rqstBytes = rqstMsg.getBytes();
		MyPacket rqstPacket = new MyPacket(rqstBytes);
		clientsocket.send(rqstPacket);
	}
  
}
