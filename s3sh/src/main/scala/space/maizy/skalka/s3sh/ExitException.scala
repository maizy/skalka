package space.maizy.skalka.s3sh

/**
 * Copyright (c) Nikita Kovaliov, maizy.ru, 2018
 * See LICENSE.txt for details.
 */

object ExitStatus extends Enumeration {
  protected case class ExitStatus(returnCode: Int) extends super.Val
  type Status = Value
  val SUCCESS = ExitStatus(0)
  val UNKNOWN_ERROR = ExitStatus(1)
}

case class ExitException(status: ExitStatus.Status, message: Option[String] = None)
  extends RuntimeException(message.orNull)
