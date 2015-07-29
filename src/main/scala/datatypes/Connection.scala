package datatypes

import java.net.InetAddress
import org.joda.time.DateTime

object ConnectionState extends Enumeration {
  val Connecting, Connected, Disconnected = Value
}

trait ConnectionInfo {
  val state:            ConnectionState.Value
  val server:           InetAddress
  val lastPingTime:     Option[DateTime]
  val lastPingId:       Option[Int]
  val sessionId:        Option[String]
  val whenInitiated:    Option[DateTime]
  val whenDisconnected: Option[DateTime]
}

