package Main

import java.io._
import java.net.Socket

class Clients(socket: Socket) extends Thread{
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
      try {
        line = bufferRead.readLine()
        if ((line == null) || line.equalsIgnoreCase("QUIT")) {
          println("Client has left")
          socket.close()
          return
        }
        else {
          println("input van client : "+line)
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

