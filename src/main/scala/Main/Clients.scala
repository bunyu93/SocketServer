package Main

import java.io._
import java.net.Socket

import scala.collection.mutable.ListBuffer

class Clients(socket: Socket,RefIncome:Int,ListAllDevices:ListBuffer[DeviceInfo]) extends Thread{
  override def run() : Unit={
    var inPut:InputStream = null
    var bufferRead:BufferedReader = null
    var outPut:DataOutputStream = null

    try {
      inPut = socket.getInputStream
      bufferRead = new BufferedReader(new InputStreamReader(inPut))
      outPut = new DataOutputStream(socket.getOutputStream)
    } catch {
      case e: IOException =>
        return
    }

    var line:String = null

    while (true) {
      for(x <- ListAllDevices)
      {
        if (x.ID == RefIncome)
        {
          try
          {
            line = bufferRead.readLine()
            if ((line == null) || line.equalsIgnoreCase("QUIT")) {
              println("Client has left")
              socket.close()
              return
            }
            else if ("LATITUDE".r.findAllIn(line).length == 1) {
              x.Latitude = line
            }
            else if ("LONGITUDE".r.findAllIn(line).length == 1) {
              x.Longitude = line
            }
            else if ("SCORE".r.findAllIn(line).length == 1) {
              x.Score = line
            }
            else {
              println("input van client : " + line)
              outPut.writeBytes(line + "\n\r")
              outPut.flush()
            }
          } catch {
            case e: IOException =>
              return
          }
        }
      }
    }
  }
}

