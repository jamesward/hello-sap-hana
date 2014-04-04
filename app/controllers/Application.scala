package controllers

import play.api.mvc.{Action, Controller}

object Application extends Controller {
  
  def index = Action {
    Ok(views.html.index("Hello Play Framework"))
  }
  
  def psaTransactions = Action {
    import anorm._
    import play.api.db.DB
    import play.api.Play.current
    import play.api.libs.json.Json
    import models.Transaction

    DB.withConnection { implicit c =>
      val result = SQL("""SELECT * FROM "PSA"."psa.data::psa_transaction.Details"""").as(Transaction.rowParser.*)
      Ok(Json.toJson(result))
    }
  }
  
}