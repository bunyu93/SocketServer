package Main

import java.io.DataOutputStream
import java.net.{ServerSocket, Socket}
import java.util

import scala.collection.JavaConversions._
import scala.collection.mutable.ListBuffer

class Broadcast() extends Thread{

  //attr
  private var _listClients : ListBuffer[Socket] = ListBuffer()
  private var _listClientsV2 : util.Set[Thread] = Thread.getAllStackTraces().keySet()

  //Getter
  def listClients : ListBuffer[Socket] = _listClients
  def listClientsV2 : util.Set[Thread] = _listClientsV2

  //Setter
  def listClients_= (value:ListBuffer[Socket]):Unit = _listClients = value
  def listClientsV2_= (value:util.Set[Thread]):Unit = _listClientsV2 = value

  override def run(): Unit =
  {
//    while(true)
//    {
//      Thread.sleep(1500)
//      val threadArray = _listClientsV2.toArray(new Array[Thread](_listClientsV2.size))
//      for (x <- _listClientsV2)
//      {
//        println(x)
//      }
//    }

    var outPut:DataOutputStream = null
    while(true){
      Thread.sleep(3000)

      for(i <- _listClientsV2)
      {
        var temp = i.getClass.getMethods
        var temp1 = i.getClass.getMethods

      }

      for (x <- listClients){
        outPut = new DataOutputStream(x.getOutputStream)

        for (xx <- listClients){
        outPut.writeBytes("IP: '"+ xx.getInetAddress + "' \n\r")
        outPut.writeBytes("PORT: '"+ xx.getPort + "' \n\r")

        outPut.flush()
        }
      }

      listClients.foreach{println}
      println("Bcasting")
    }

  }
}
