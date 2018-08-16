package space.maizy.skalka.s3sh.command

/**
 * Copyright (c) Nikita Kovaliov, maizy.ru, 2018
 * See LICENSE.txt for details.
 */

trait Command {
  def prefix: String
  def exec(args: List[String]): Unit
}

object Commands {
  final val ALL: List[Command] = List(Ls, Version)
  def prefixes: List[String] = ALL.map(_.prefix)
  def findByPrefix(prefix: String): Option[Command] = ALL.find(_.prefix == prefix)
}
