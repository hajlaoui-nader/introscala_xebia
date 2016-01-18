package fr.xebia.scala.control

import fr.xebia.scala.model.Film

object PriceCalculations {

  /*
   * TODO PriceCalculations_1: use CollectionTools#zip[A,B](List[A], List[B]):(A,B)
   * Calculate the totalPrice of the list specified only if the film list size is equal to the prices list
   */
  def calculateTotalPrice(films: List[Film], qty: List[Int]): Option[Double] =
    if (films.size == qty.size) {
      Some {
        CollectionTools.zip(films, qty)
          .map { case (film, amt) => film.price * amt }
          .sum
      }
    } else {
      None
    }

  /*
   * TODO PriceCalculations_2 : use CollectionTools#zipWithIndex[A](List[A]):(A, Int)
   * Return the total price and the index on the ranking only if the film list size is equal to the prices list
   */
  def calculateTotalPriceWithIndex(films: List[Film], qty: List[Int]): Option[List[(Int, Double)]] =
    if (films.size == qty.size) {
      Some {
        CollectionTools.zipWithIndex(CollectionTools.zip(films, qty))
          .map { case ((f: Film, qty: Int), index) => (index, f.price * qty) }
      }
    } else {
      None
    }
}
