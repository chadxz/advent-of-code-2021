package dev.chadxz.adventofcode.sonarsweep

import scala.io.Source

object SonarSweep {
  def main(args: Array[String]): Unit = {
    val readings =
      Source
        .fromInputStream(getClass.getResourceAsStream("input.txt"))
        .getLines()
        .map(_.toInt)
        .toSeq

    println(s"Part 1 Answer: ${part1(readings)}")
    println(s"Part 2 Answer: ${part1(part2(readings))}")
  }

  def part1(readings: Seq[Int]): Int =
    readings
      .sliding(2)
      .count {
        case Seq(a, b) => b > a
      }

  def part2(readings: Seq[Int]): Seq[Int] =
    readings
      .sliding(3)
      .map(_.sum)
      .toSeq

}
