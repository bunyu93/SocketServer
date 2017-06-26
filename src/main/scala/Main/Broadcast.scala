package Main

import java.io.{DataOutputStream, IOException}

import scala.collection.mutable.ListBuffer

class Broadcast(ListAllDevices:ListBuffer[DeviceInfo]) extends Thread{
  override def run(): Unit =
  {
    var outPut:DataOutputStream = null

    while(true){
      Thread.sleep(3000)
      for (x <- ListAllDevices){
        outPut = new DataOutputStream(x.GetSocket.getOutputStream)
        for (xx <- ListAllDevices){
          try
          {
            outPut.writeBytes("IP: '"+ xx.GetSocket.getInetAddress + "' \n\r")
            outPut.writeBytes("PORT: '"+ xx.GetSocket.getPort + "' \n\r")
            outPut.writeBytes("Latitude: '"+ xx.Latitude + "' \n\r")
            outPut.writeBytes("Longitude: '"+ xx.Longitude + "' \n\r")
            outPut.writeBytes("Score: '"+ xx.Score + "' \n\r")
            outPut.flush()
          } catch {
            case e: IOException =>
              return
          }
        }
      }
      ListAllDevices.foreach{println}
      println("Bcasting")
    }
  }
}
