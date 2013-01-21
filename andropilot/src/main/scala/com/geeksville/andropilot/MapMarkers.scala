package com.geeksville.andropilot

import com.geeksville.gmaps._
import org.mavlink.messages.ardupilotmega.msg_mission_item
import com.ridemission.scandroid.AndroidLogger

class WaypointMarker(val msg: msg_mission_item) extends SmartMarker with AndroidLogger {
  def lat = msg.x
  def lon = msg.y
  override def lat_=(n: Double) { msg.x = n.toFloat }
  override def lon_=(n: Double) { msg.y = n.toFloat }
  override def title = Some("Waypoint #" + msg.seq)
  override def snippet = Some(msg.toString)
  override def draggable = false // Disable dragging until we have waypoint upload

  override def toString = title.get

  override def onDragEnd() {
    super.onDragEnd()
    debug("Drag ended on " + this)
  }
}