package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// ClientHandler class
class ClientHandler extends Thread
{
  DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
  DateFormat fortime = new SimpleDateFormat("hh:mm:ss");
  final DataInputStream dis;
  final DataOutputStream dos;
  final Socket s;


  // Constructor
  public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)
  {
    this.s = s;
    this.dis = dis;
    this.dos = dos;
  }

  @Override
  public void run()
  {
    String received;
    String toreturn;
    while (true)
    {
      try {

        // Ask user what he wants
        //dos.writeUTF("What do you want?[Date | Time]..\n"+
            //"Type Exit to terminate connection.");

        // receive the answer from client
        received = dis.readUTF();
        String[] options = received.split(" ");
        System.out.println(received);
        if(received.equals("Exit"))
        {
          System.out.println("Client " + this.s + " sends exit...");
          System.out.println("Closing this connection.");
          this.s.close();
          System.out.println("Connection closed");
          break;
        }

        // creating Date object
        Date date = new Date();

        // write on output stream based on the
        // answer from the client
        switch (options[0].trim().toLowerCase()) {
          case "soma":
            int result = Integer.parseInt(options[1]) + Integer.parseInt(options[2]);
            dos.writeUTF(Integer.toString(result));
            break;

          case "sub":
            int subresult = Integer.parseInt(options[1]) - Integer.parseInt(options[2]);
            dos.writeUTF(Integer.toString(subresult));
            break;
          case "multip":
            int multipresult = Integer.parseInt(options[1]) * Integer.parseInt(options[2]);
            dos.writeUTF(Integer.toString(multipresult));
            break;
          case "div":
            float divresult = Float.parseFloat(options[1]) / Float.parseFloat(options[2]);
            dos.writeUTF(Float.toString(divresult));
            break;

          default:
            dos.writeUTF("Invalid input");
            break;
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    try
    {
      // closing resources
      this.dis.close();
      this.dos.close();

    }catch(IOException e){
      e.printStackTrace();
    }
  }
}
