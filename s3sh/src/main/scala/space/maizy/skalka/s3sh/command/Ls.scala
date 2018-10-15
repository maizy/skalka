package space.maizy.skalka.s3sh.command

/**
 * Copyright (c) Nikita Kovaliov, maizy.ru, 2018
 * See LICENSE.txt for details.
 */

object Ls extends Command {
  override val name = "ls"

  override def exec(args: List[String]): Unit = {
    println(s"ls $args")
  }
}
