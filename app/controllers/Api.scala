package controllers

import play.api.mvc.{Action, Controller}

/**
 *
 *
 * @author Hannu Lyytikainen
 */
object Api extends Controller {

  var postStorage = Map("first" -> "{\"author\" : \"bob\", \"msg\": \"Hello World\"}")

  def posts = Action {
    Ok(postStorage("first"))
  }

}
