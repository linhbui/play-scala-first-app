package controllers

import play.api.mvc.{Action, Controller}
import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText}
import models.Product

class Products extends Controller {
  def list = Action { implicit request =>
    val products = Product.findAll

    Ok(views.html.products.list(products))
  }

  def show(ean: String) = Action { implicit request =>
    Product.findByEan(ean).map { product =>
      Ok(views.html.products.details(product))
    }.getOrElse(NotFound)
  }

  private val productForm: Form[Product] = Form(
    mapping(
      "ean" -> nonEmptyText.verifying(
        "validation.ean.duplicate", Product.findByEan(_).isEmpty),
      "name" -> nonEmptyText,
      "description" -> nonEmptyText
    )(Product.apply)(Product.unapply)
  )
}