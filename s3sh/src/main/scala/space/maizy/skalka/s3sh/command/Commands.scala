package space.maizy.skalka.s3sh.command

/**
 * Copyright (c) Nikita Kovaliov, maizy.ru, 2018
 * See LICENSE.txt for details.
 */

object Commands {
  final val ALL: List[Command] = List(Ls, Version, Exit).sortBy(_.name)
  def names: List[String] = ALL.map(_.name)
  def findByName(name: String): Option[Command] = ALL.find(_.name == name)
}
