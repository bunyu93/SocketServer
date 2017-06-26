package Main

import java.io._
import java.net.Socket

class Clients(socket: Socket, BCT:Broadcast,RefIncome:Int) extends Thread{

  //attr
  private var _Ref : Int = 0
  private var _Longitude : String = ""
  private var _Latitude : String = ""
  private var _Score : String = ""
  private var _Socket : Socket = socket

  //Getter
  def Ref : Int = _Ref
  def Longitude : String = _Longitude
  def Latitude : String = _Latitude
  def Score : String = _Score
  def GetSocket : Socket = _Socket

  // Setter
  def Longitude_= (value:Int):Unit = _Ref = value
  def Longitude_= (value:String):Unit = _Longitude = value
  def Latitude_= (value:String):Unit = _Latitude = value
  def Score_= (value:String):Unit = _Score = value

  override def run() : Unit={
    //Thread.currentThread.setName("Thread"+RefIncome)

    _Ref = RefIncome
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
        else if("LATITUDE".r.findAllIn(line).length == 1){
          _Latitude = line
        }
        else if("LONGITUDE".r.findAllIn(line).length == 1){
          _Longitude = line
        }
        else if("SCORE".r.findAllIn(line).length == 1){
          _Longitude = line
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

