package dev.chadxz.adventofcode.dive

import scala.io.Source
import scala.util.matching.Regex

object Dive {
  private val Up: Regex = raw"up (\d+)".r
  private val Down: Regex = raw"down (\d+)".r
  private val Forward: Regex = raw"forward (\d+)".r

  def main(args: Array[String]): Unit = {
    val movements =
      Source
        .fromInputStream(getClass.getResourceAsStream("input.txt"))
        .getLines()
        .toSeq

    println(s"Part 1 result: ${part1(movements)}")
    println(s"Part 2 result: ${part2(movements)}")
  }

  def part1(movements: Seq[String]): Int = {
    var horizontal = 0;
    var depth = 0;

    movements
      .foreach{
        case Forward(value) => horizontal += value.toInt
        case Up(value) => depth -= value.toInt
        case Down(value) => depth += value.toInt
      }

    horizontal * depth
  }

  def part2(movements: Seq[String]): Int = {
    var horizontal = 0
    var depth = 0
    var aim = 0

    movements
      .foreach{
        case Forward(value) =>
          horizontal += value.toInt
          depth = depth + (aim * value.toInt)
        case Up(value) => aim -= value.toInt
        case Down(value) => aim += value.toInt
      }

    horizontal * depth
  }
}
