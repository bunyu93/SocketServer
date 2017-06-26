package Logic

class Devices {
  //attr
  private var _ID : Int = 0
  private var _IP : Int = 0
  private var _Longitude : String = ""
  private var _Latitude : String = ""
  private var _Score : Long = 0

  //Getter
  def ID:Int = _ID
  def IP:Int = _IP
  def Longitude : String = _Longitude
  def Latitude : String = _Latitude
  def Score : Long = _Score

  // Setter
  def ID_= (value:Int):Unit = _ID = value
  def IP_= (value:Int):Unit = _IP = value
  def Longitude_= (value:String):Unit = _Longitude = value
  def Latitude_= (value:String):Unit = _Latitude = value
  def Score_= (value:Long):Unit = _Score = value

}
