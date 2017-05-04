package Scala

import java.net._
import java.io._

import scala.util.control.Breaks


object SocketLogic{
  var allDevices: List[String] = List()
  var status: Boolean = false
  val port: Int = 21

  val s1 = new server(port)
  val t1 = new Thread(s1)
  def StartServer():String = {
    t1.start()
    "Server is listing op port : " + port
  }

  def StopServer():String = {
    s1.StopServer()
    "Server is down"
  }
}

class server(port:Int) extends Runnable{
  var status:Boolean = false

  override def run(): Unit = {
    status = true
    var serverSocket: ServerSocket = null

    try
      serverSocket = new ServerSocket(port)
    catch
      {
      case e: IOException =>
        println("Could not listen on port: "+port+".")
        System.exit(1)
      }
    var clientSocket: Socket = null
    println("Waiting for connection.....")

    try
      clientSocket = serverSocket.accept
    catch {
      case e: IOException =>
        println("Accept failed.")
        System.exit(1)
    }
    println("Connection successful")
    println("Waiting for input.....")

    var out: PrintWriter = new PrintWriter(clientSocket.getOutputStream, true)
    var in: BufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream))

    var inputLine:String = "null"
    val loop = new Breaks

    while (status) {
      println("Server: " + inputLine)
      out.println(inputLine)
      if (inputLine == "exit")
      {
        loop.break()
      }
    }

    out.close()
    in.close()
    clientSocket.close()
    serverSocket.close()
  }
  def StopServer():Unit= {
    status=false
  }
}


