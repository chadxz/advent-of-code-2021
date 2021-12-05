package dev.chadxz.adventofcode.sonarsweep

import scala.io.Source

object SonarSweep extends App {
  var lastLine = ""
  var increases = 0

  Source
    .fromInputStream(getClass.getResourceAsStream("/sonarsweep/input.txt"))
    .getLines()
    .foreach(line => {
      if (lastLine.nonEmpty && lastLine.toInt < line.toInt) {
        increases += 1
      }

      lastLine = line
    })

  println(s"Part 1 Answer: ${increases} in depth")
}
