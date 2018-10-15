package space.maizy.skalka.s3sh.command

/**
 * Copyright (c) Nikita Kovaliov, maizy.ru, 2018
 * See LICENSE.txt for details.
 */

import space.maizy.skalka.s3sh.{ ExitException, ExitStatus }

object Exit extends Command {
  override def name: String = "exit"
  override def exec(args: List[String]): Unit = throw ExitException(ExitStatus.SUCCESS)
}
