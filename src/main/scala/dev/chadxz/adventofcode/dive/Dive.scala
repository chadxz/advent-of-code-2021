package dev.chadxz.adventofcode.dive

import scala.io.Source

object Dive {
  def main(args: Array[String]): Unit = {
    val Up = raw"up (\d+)".r
    val Down = raw"down (\d+)".r
    val Forward = raw"forward (\d+)".r

    var horizontal = 0;
    var depth = 0;

    Source
      .fromInputStream(getClass.getResourceAsStream("input.txt"))
      .getLines()
      .foreach{
        case Forward(value) => horizontal += value.toInt
        case Up(value) => depth -= value.toInt
        case Down(value) => depth += value.toInt
      }

    println(s"Horizontal is ${horizontal} and Depth is ${depth}")
    println(s"Multiplication is ${horizontal * depth}")
  }

}
