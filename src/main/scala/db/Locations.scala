package db

import model.Location
import slick.lifted.Tag
import slick.driver.PostgresDriver.api._

/**
 * Author: @aguestuser
 * License: GPLv3 (https://www.gnu.org/licenses/gpl-3.0.html)
 */

class Locations(tag: Tag) extends Table[Location](tag, "LOCATIONS") {

  def id = column[String]("ID", O.PrimaryKey)
  def lat = column[Double]("LAT")
  def lon = column[Double]("LON")
  def time = column[Long]("TIME")

  def *  = (id, lat, lon, time) <> ((Location.apply _).tupled, Location.unapply)
  def idx = index("idx_time", time, unique = false)
}





