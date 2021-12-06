package dev.chadxz.adventofcode.sonarsweep

import scala.io.Source

object SonarSweep {
  def main(args: Array[String]): Unit = {
    val part1Result = part1()

    println(s"Part 1 Answer: ${part1Result}")
  }

  def part1(): Int = {
    Source
      .fromInputStream(getClass.getResourceAsStream("input.txt"))
      .getLines()
      .map(_.toInt)
      .sliding(2)
      .count {
        case Seq(a, b) => b > a
      }
  }

  def part2(): Int = {
    1
  }
}
