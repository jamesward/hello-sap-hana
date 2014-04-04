package models

import java.util.Date
import java.math.BigDecimal

import anorm._
import anorm.SqlParser._
import play.api.libs.json.Json


case class Transaction(id: Int, amount: Double, tranDate: Date, postDate: Date, description: String, category: String)

object Transaction {

  val rowParser = {
    get[Int]("ID") ~
    get[BigDecimal]("AMOUNT") ~
    get[Date]("TRAN_DATE") ~
    get[Date]("POST_DATE") ~
    get[String]("DESCRIPTION") ~
    get[String]("CATEGORY_TEXT") map { case id~amount~tranDate~postDate~description~category => 
      Transaction(id, amount.doubleValue(), tranDate, postDate, description, category)
    }
  }
  
  implicit val jsonWrites = Json.writes[Transaction]
  
}