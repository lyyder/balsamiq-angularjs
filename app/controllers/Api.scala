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


  var beerStorage = Map("red_neck" -> new Beer("red_neck", "Red Neck", "100", "Very Good"))


  def beers = Action {
    Ok(toJson(beerStorage values))
  }

  def save = Action { request =>
    val body = request.body
    println("body: " + body)

    Ok()
  }


//  def beer(id: String) = Action {
//    Ok()
//  }


  case class Beer (id: String, name: String, hops: String, comments: String);

    implicit val beerJsonWrite = new Writes[Beer] {
      def reads(json: JsValue): Beer = Beer(
        (json \ "id").as[String],
        (json \ "name").as[String],
        (json \ "hops").as[String],
        (json \ "comments").as[String]

      )


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
