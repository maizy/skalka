package space.maizy.skalka.s3sh.command

/**
 * Copyright (c) Nikita Kovaliov, maizy.ru, 2018
 * See LICENSE.txt for details.
 */

trait Command {
  def name: String
  def exec(args: List[String]): Unit
}
