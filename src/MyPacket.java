import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.InetAddress;

/* 
* This is a class created to provide a basic strcuture for 
* a packet in which data is encapsulated 
*/

public class MyPacket{

  byte[] data; //data to be sent
  int seqnum; // Sequence number of the packet
  int acknum; // Acknowledgment number 
  int recvWindow; //receiving window available
	boolean ack=false; 
	boolean fin=false; 
	boolean syn=false;
	int checkSum;
}

	//empty constructor
	MyPacket(){
		
	}

	//constructor to initialize with sequence number
	MyPacket(int seqnum){
		this.seqnum = seqnum;
	}

//Constructor for intializing with seq number and syn bit
	MyPacket(int seqnum, boolean syn){
		this.seqnum = seqnum;
		this.syn = syn;
	}
	
	//Constructor
	MyPacket(int seqnum, boolean syn, boolean ack, int acknum){
		this.seqnum = seqnum;
		this.syn = syn;
		this.ack = ack;
		this.acknum = acknum;
	}

	//Constructor
	MyPacket(int seqnum, boolean ack, int acknum){
		this.seqnum = seqnum;
		this.ack = ack;
		this.acknum = acknum;
	}

	//constructor
	MyPacket(byte[] data){
		
		this.data = data;
	}
	
	//Method to set syn bit
	public void setSyn(){
		syn = true;
	}
	
	//Method to get sequence number
	public int getSeqnum(){
		return seqnum;
	}
	
	//Method to set sequence number
	public void setSeqnum(int seqnum){
		this.seqNum = seqNum;
	}
	
	//Method to set acknowledgement number
	public void setAcknum(int acknum){
		this.acknum = acknum;
	}
	
	//Method to set finish bit
	public void setFin(){
		fin = true;
	}
	
	//Method to get acknowledgement number
	public int getAcknum(){
		return acknum;
	}
