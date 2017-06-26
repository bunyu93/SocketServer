package Main

import java.net.Socket

/**
  * Created by B-40 on 26-6-2017.
  */
class DeviceInfo(socket: Socket, RefIncome:Int) {
  //attr
  private val _ID : Int = RefIncome
  private var _Longitude : String = ""
  private var _Latitude : String = ""
  private var _Score : String = ""
  private var _Socket : Socket = socket

  //Getter
  def ID : Int = _ID
  def Longitude : String = _Longitude
  def Latitude : String = _Latitude
  def Score : String = _Score
  def GetSocket : Socket = _Socket

  // Setter
  def Longitude_= (value:String):Unit = _Longitude = value
  def Latitude_= (value:String):Unit = _Latitude = value
  def Score_= (value:String):Unit = _Score = value
}
