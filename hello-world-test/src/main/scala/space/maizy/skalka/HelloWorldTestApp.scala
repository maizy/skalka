package space.maizy.skalka

/**
 * Copyright (c) Nikita Kovaliov, maizy.space, 2018
 * See LICENSE.txt for details.
 */

import com.typesafe.scalalogging.LazyLogging
import space.maizy.skalka.core.CliApplication

object HelloWorldTestApp extends CliApplication with LazyLogging {

  val name = "hello-world-test"

  def main(args: Array[String]): Unit = {
    println(s"Hello world\n${args.mkString("\n")}")
    logger.info("test")
  }
}
