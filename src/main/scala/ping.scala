import scala.io.Source
import scala.concurrent.duration._
import java.io._
import java.util.Calendar
/**
  * Created by Scott on 2/8/16.
  */
object ping extends App {
  val ips = Source.fromFile("ip.txt").getLines().toList
  val writer = new PrintWriter(new File("result.txt"))
  while(true){
    Thread.sleep(1000L)
    ips.foreach(ip => {
      val time = Calendar.getInstance.getTime.toString
      if(pingService.isReachableByPing(ip)){
        writer.write(time + "," + ip + "," + "1" + "\n")
      }
      else{
        writer.write(time + "," + ip + "," + "0")
      }
    }
    )
    writer.flush()
  }
  writer.close()
}
