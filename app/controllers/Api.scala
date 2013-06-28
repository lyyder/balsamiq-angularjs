package controllers

import play.api.mvc.{Action, Controller}
import play.api.libs.json.{JsResult, JsValue, Writes}
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

  def save(id: String) = Action (parse.json) { request =>
    val beer = request.body

    val b = new Beer(id,
      (beer \ "name").toString(), (beer \ "hops").toString(), (beer \ "review").toString())

    beerStorage = beerStorage + (id -> b)

    println(beerStorage values)
    println("beer: " + b)
    Ok("")
  }

  case class Beer (id: String, name: String, hops: String, comments: String);

    implicit val beerJsonWrite = new Writes[Beer] {
      def reads(json: JsValue): Beer = Beer(
        (json \ "id").as[String],
        (json \ "name").as[String],
        (json \ "hops").as[String],
        (json \ "review").as[String]
      )


      def writes(b: Beer): JsValue = {
        obj(
          "id" -> b.id,
          "name" -> b.name,
          "hops" -> b.hops,
          "review" -> b.comments
        )
      }
    }

}
