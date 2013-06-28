package controllers

import play.api.mvc.{Action, Controller}
import play.api.libs.json.{JsValue, Writes}
import play.api.libs.json.Json._

/**
 *
 *
 * @author Hannu Lyytikainen
 */
object Api extends Controller {


  var beerStorage = Map("red_neck" -> new Beer("red neck", "Red Neck", "100", "Very Good"))


  def beers = Action {
    Ok(toJson(beerStorage("red_neck")))
  }

//  def beer(id: String) = Action {
//    Ok()
//  }



  case class Beer (id: String, name: String, hops: String, comments: String);

    implicit val beerJsonWrite = new Writes[Beer] {
      def writes(b: Beer): JsValue = {
        obj(
          "id" -> b.id,
          "name" -> b.name,
          "hops" -> b.hops,
          "comments" -> b.comments
        )
      }
    }

}
