package controllers

import play.api._
import play.api.mvc._

class Application extends Controller {

  def index = Action {
    Ok("Hat xi hoi")
  }

  def hello(name: String) = Action {
    Redirect(routes.Products.list())
  }

}
