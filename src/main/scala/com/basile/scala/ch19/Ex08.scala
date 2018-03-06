package com.basile.scala.ch19

import scala.util.parsing.combinator.RegexParsers

/**
 * Add variables and assignment to the calculator program.
 * Variables are created when they are first used.
 * Uninitialized variables are zero.
 *
 * To print a value, assign it to the special variable out .
 */
object Ex08 extends App {

  class ExprParser extends RegexParsers {

    //A Map to store variables values
    val ValueMap = scala.collection.mutable.Map[String, Int]()

    val number = "[0-9]+".r

    //match variable name
    val name = "[a-z]+".r

    def expr: Parser[Int] = term ~ rep( ("+" | "-") ~ term ) ^^ {
      case t ~ l => l.foldLeft(t)(
        (res, e) => e match {
          case "-" ~ n => res - n
          case "+" ~ n => res + n
        }
      )
    }

    def term: Parser[Int] = factor ~ opt(("/" | "*" | "%") ~ term) ^^ {
      case f ~ None => f
      case f ~ Some("/" ~ e) => f / e
      case f ~ Some("*" ~ e) => f * e
      case f ~ Some("%" ~ e) => f % e
    }

    //a factor must be a number, variable or expression between ()
    def factor: Parser[Int] =
      number ^^ { _.toInt } | name ^^ { ValueMap.getOrElse(_, 0) } | "(" ~> expr <~ ")"

    //assign an expression to a variable
    def assign = (name <~ "=") ~ expr ^^ {
      case "out" ~ e => println(e)
      case n ~ e => ValueMap.update(n, e)
    }

    //parse semicolon separated language
    def language = rep(assign <~ ';')

  }

  val parser = new ExprParser

  //should print 20 then 5
  val result = parser.parseAll(parser.language, "a=3; b=(a+2)*4; out=b; b=b/4; out=b")


}
