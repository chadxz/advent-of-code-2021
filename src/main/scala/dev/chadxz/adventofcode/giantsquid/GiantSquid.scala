package dev.chadxz.adventofcode.giantsquid

import scala.annotation.tailrec
import scala.io.Source

object GiantSquid {
  case class Square(value: Int, marked: Boolean)
  type Row = Seq[Square]
  type Board = Seq[Row]

  def main(args: Array[String]): Unit =
    winningBoard(
      selections(rawInput.head),
      startingBoards(rawInput.tail).toList
    ) match {
      case Some((lastCalled, board)) =>
        println(s"Winning board on ${lastCalled}!")
        println(s"Score is ${score(lastCalled, board)}")
      case None => println(s"No winning board found")
    }

  @tailrec
  def winningBoard(
      selections: Seq[Int],
      boards: Seq[Board]
  ): Option[(Int, Board)] = {
    selections.headOption match {
      case None => None
      case Some(selection) =>
        val newBoards = boards
          .map(
            _.map(
              _.map(square =>
                Square(
                  square.value,
                  square.marked || (square.value == selection)
                )
              )
            )
          )

        newBoards.find(isWinningBoard) match {
          case Some(board) => Some((selection, board))
          case None        => winningBoard(selections.tail, newBoards)
        }
    }
  }

  def isWinningBoard(board: Board): Boolean =
    /* rows */ board.exists(r => r.forall(s => s.marked)) ||
      /* columns */ board.transpose.exists(r => r.forall(s => s.marked))

  def rawInput: Seq[String] =
    Source
      .fromInputStream(getClass.getResourceAsStream("input.txt"))
      .getLines()
      .toSeq

  def selections(input: String): Seq[Int] =
    input.split(',').map(_.toInt)

  def startingBoards(input: Seq[String]): Iterator[Board] =
    input
      .filter(_.nonEmpty)
      .grouped(5)
      .map(
        _.map(
          _.split(' ')
            .filter(_.nonEmpty)
            .map(value => Square(value = value.toInt, marked = false))
        )
      )

  def score(lastCalled: Int, board: Board): Int =
    board.flatMap(_.filter(!_.marked)).map(_.value).sum * lastCalled
}
