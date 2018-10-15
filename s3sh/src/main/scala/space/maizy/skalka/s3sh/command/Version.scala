package space.maizy.skalka.s3sh.command

/**
 * Copyright (c) Nikita Kovaliov, maizy.ru, 2018
 * See LICENSE.txt for details.
 */

import space.maizy.skalka.s3sh.{ Version => AppVersion }

object Version extends Command {
  override def name: String = "version"
  override def exec(args: List[String]): Unit = println(s"s3sh $AppVersion")
}
