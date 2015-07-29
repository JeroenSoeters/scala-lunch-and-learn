//package datatypes
//
//import java.net.InetAddress
//
//import org.joda.time.DateTime
//
//sealed trait ConnectionState
//case class Connecting(whenInitiated: DateTime)
//case class Connected(lastPing: (DateTime, Int),
//                     sessionId: String)
//case class Disconnected(whenDisconnected: DateTime)
//
//
//trait ConnectionInfo {
//  val state:            ConnectionState
//  val server:           InetAddress
//}
