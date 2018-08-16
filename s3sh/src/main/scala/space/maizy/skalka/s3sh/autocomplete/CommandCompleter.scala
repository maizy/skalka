package space.maizy.skalka.s3sh.autocomplete

/**
 * Copyright (c) Nikita Kovaliov, maizy.ru, 2018
 * See LICENSE.txt for details.
 */

import java.util
import scala.collection.JavaConverters._
import org.jline.reader.{ Candidate, Completer, LineReader, ParsedLine }
import space.maizy.skalka.s3sh.command.{ Command, Commands }


object CommandCompleter {
  def apply(): CommandCompleter = new CommandCompleter(Commands.ALL)
}

class CommandCompleter(commands: List[Command]) extends Completer {
  override def complete(reader: LineReader, line: ParsedLine, candidates: util.List[Candidate]): Unit = {
    candidates.addAll(commands.map(c => new Candidate(c.prefix)).asJava)
  }
}
