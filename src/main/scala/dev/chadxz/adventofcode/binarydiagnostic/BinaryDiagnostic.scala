package dev.chadxz.adventofcode.binarydiagnostic

import scala.io.Source

object BinaryDiagnostic {
  def main(args: Array[String]): Unit = {
    val binaryLines =
      Source
        .fromInputStream(getClass.getResourceAsStream("input.txt"))
        .getLines()
        .toSeq

    val (_, gammaRate, epsilonRate) = binaryLines
      .transpose
      .map(seq => seq.count(_ == '1') > seq.length / 2)
      .foldRight((1, 0, 0)) {
        case (isGamma, (power, gamma, epsilon)) =>
          if (isGamma) {
            (power * 2, gamma + power, epsilon)
          } else {
            (power * 2, gamma, epsilon + power)
          }
      }

    println(gammaRate * epsilonRate)
  }
}
