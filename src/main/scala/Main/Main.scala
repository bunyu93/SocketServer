package Main

import java.io._
import java.net.Socket
import java.net.ServerSocket

import com.sun.xml.internal.ws.client.ClientSchemaValidationTube

//java -jar app.jar {Locatie jar file}

object Main{
  val portServer : Int = 4040
  var clientNumber : Int = 0

  def main(args: Array[String]): Unit = {

    var SS:ServerSocket = null
    var socket:Socket = null

    val BCT:Broadcast = new Broadcast()

    try{SS = new ServerSocket(portServer)}
    catch {
      case e: IOException =>
        e.printStackTrace()
    }

    BCT.start()
    while (true) {
      try{
        socket = SS.accept()
        clientNumber += 1
        println("new client total " + clientNumber.toString())
      }
      catch {
        case e: IOException =>
          System.out.println("I/O error: " + e)
      }

      // new thread for a client
      BCT.listClients += socket
      new Clients(socket,BCT,clientNumber).start()

    }
  }
}