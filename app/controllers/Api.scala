package controllers

import play.api.mvc.{Action, Controller}

/**
 *
 *
 * @author Hannu Lyytikainen
 */
object Api extends Controller {


  var beerStorage = Map("red_neck" -> "{\"id\" : \"red_neck\", \"name\" : \"Red Neck\", \"hops\": \"1000\", , \"comments\": \"aaawyeah\"}")


  def beers = Action {
    Ok(beerStorage("red_neck"))
  }

//  def beer(id: String) = Action {
//    Ok()
//  }
}
