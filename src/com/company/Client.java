package com.company;

// Java implementation for a client
// Save file as Client.java

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.Naming;
import java.util.Scanner;

// Client class
public class Client
{
  public static void main(String[] args) throws IOException
  {
    try {
      Scanner scn = new Scanner(System.in);
      String tosend = "";
      // getting localhost ip
      InetAddress ip = InetAddress.getByName("localhost");
      Socket s1 = new Socket(ip, 5056);
      Socket s2 = new Socket(ip, 8080);

      do{
        System.out.println("-----------------------------");
        System.out.println("Escolha uma operação:");
        System.out.println("Soma (1):");
        System.out.println("Subtração (2):");
        System.out.println("Multiplicação (3):");
        System.out.println("Divisão (4):");
        System.out.println("Raiz quadrada (5):");
        System.out.println("Porcentagem (6):");
        System.out.println("Potenciação (7):");
        System.out.println("Digite 'Exit' para sair");
        System.out.println("Opção: ");
        tosend = scn.nextLine();
        switch(tosend){
          case "1":{
            System.out.println("Primeiro numero da soma:");
            int num1 = Integer.parseInt(scn.nextLine());
            System.out.println("Segundo numero da soma:");
            int num2 = Integer.parseInt(scn.nextLine());
            DataInputStream dis1 = new DataInputStream(s1.getInputStream());
            DataOutputStream dos1 = new DataOutputStream(s1.getOutputStream());
            dos1.writeUTF("Soma" + " " + num1 + " " + num2);
            System.out.println("Response: " + dis1.readUTF());
            break;
          }
          case "2":{
            System.out.println("Primeiro numero da Subtração:");
            int num1 = Integer.parseInt(scn.nextLine());
            System.out.println("Segundo numero da Subtração:");
            int num2 = Integer.parseInt(scn.nextLine());
            DataInputStream dis1 = new DataInputStream(s1.getInputStream());
            DataOutputStream dos1 = new DataOutputStream(s1.getOutputStream());
            dos1.writeUTF("sub" + " " + num1 + " " + num2);
            System.out.println("Response: " + dis1.readUTF());
            break;
          }
          case "3":{
            System.out.println("Primeiro numero da Multiplicação:");
            int num1 = Integer.parseInt(scn.nextLine());
            System.out.println("Segundo numero da Multiplicação:");
            int num2 = Integer.parseInt(scn.nextLine());
            DataInputStream dis1 = new DataInputStream(s1.getInputStream());
            DataOutputStream dos1 = new DataOutputStream(s1.getOutputStream());
            dos1.writeUTF("multip" + " " + num1 + " " + num2);
            System.out.println("Response: " + dis1.readUTF());
            break;
          }
          case "4":{
            System.out.println("Primeiro numero da Divisão:");
            int num1 = Integer.parseInt(scn.nextLine());
            System.out.println("Segundo numero da Divisão:");
            int num2 = Integer.parseInt(scn.nextLine());
            DataInputStream dis1 = new DataInputStream(s1.getInputStream());
            DataOutputStream dos1 = new DataOutputStream(s1.getOutputStream());
            dos1.writeUTF("div" + " " + num1 + " " + num2);
            System.out.println("Response: " + dis1.readUTF());
            break;
          }
          case "5":{
            System.out.println("Digite um número para calcular a raíz quadrada:");
            int num1 = Integer.parseInt(scn.nextLine());
            DataInputStream dis1 = new DataInputStream(s2.getInputStream());
            DataOutputStream dos1 = new DataOutputStream(s2.getOutputStream());
            dos1.writeUTF("raiz" + " " + num1);
            System.out.println("Response: " + dis1.readUTF());
            break;
          }
          case "6":{
            System.out.println("Digite um número para ser calcular porcentagem:");
            int num1 = Integer.parseInt(scn.nextLine());
            System.out.println("Digite a porcentagem a ser calcular porcentagem:");
            int num2 = Integer.parseInt(scn.nextLine());
            DataInputStream dis1 = new DataInputStream(s2.getInputStream());
            DataOutputStream dos1 = new DataOutputStream(s2.getOutputStream());
            dos1.writeUTF("porcent" + " " + num1 + " "+ num2);
            System.out.println("Response: " + dis1.readUTF());
            break;
          }
          case "7":{
            System.out.println("Digite um número para ser calcular a  potenciação:");
            int num1 = Integer.parseInt(scn.nextLine());
            System.out.println("Digite o segundo numero para ser calcular a potenciação:");
            int num2 = Integer.parseInt(scn.nextLine());
            DataInputStream dis1 = new DataInputStream(s2.getInputStream());
            DataOutputStream dos1 = new DataOutputStream(s2.getOutputStream());
            dos1.writeUTF("potencia" + " " + num1 + " "+ num2);
            System.out.println("Response: " + dis1.readUTF());
            break;
          }
        }
      }while(!tosend.equals("Exit"));
      // establish the connection with server port 5056
      //Socket s1 = new Socket(ip, 5056);
      //Socket s2 = new Socket(ip, 8080);
      //String tosend = scn.nextLine();
      //System.out.println("Closing this connection : " + tosend);

      // obtaining input and out streams
      //DataInputStream dis1 = new DataInputStream(s1.getInputStream());
     // DataOutputStream dos1 = new DataOutputStream(s1.getOutputStream());
      //DataInputStream dis2 = new DataInputStream(s1.getInputStream());
      //DataOutputStream dos2 = new DataOutputStream(s1.getOutputStream());

      // the following loop performs the exchange of
      // information between client and client handler
      //while (true)
      //{
        //System.out.println(dis1.readUTF());
        //System.out.println(dis2.readUTF());
        //String tosend = scn.nextLine();
        //dos1.writeUTF(tosend);
        //dos2.writeUTF(tosend);

        // If client sends exit,close this connection
        // and then break from the while loop
        //if(tosend.equals("Exit"))
        //{
         // System.out.println("Closing this connection : " + s1);
          //System.out.println("Closing this connection : " + s2);
          //s1.close();
          //s2.close();
          //System.out.println("Connection closed");
         //break;
        //}

        // printing date or time as requested by client
        //String received1 = dis1.readUTF();
        //String received2 = dis2.readUTF();
        //System.out.println(received1);
       //System.out.println(received2);
      //}

      // closing resources
      //scn.close();
      //dis1.close();
      //dos1.close();
    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
