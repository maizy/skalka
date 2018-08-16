package space.maizy.skalka.s3sh

/**
 * Copyright (c) Nikita Kovaliov, maizy.space, 2018
 * See LICENSE.txt for details.
 */

import org.jline.reader.{ EndOfFileException, LineReaderBuilder, UserInterruptException }
import org.jline.reader.impl.DefaultParser
import org.jline.terminal.TerminalBuilder
import space.maizy.skalka.core.CliApplication
import scala.util.{ Failure, Success, Try }
import space.maizy.skalka.s3sh.autocomplete.CommandCompleter

object S3ShApp extends CliApplication {

  val name = "s3sh"

  def main(args: Array[String]): Unit = {
    val terminal = TerminalBuilder
      .builder()
      .system(true)
      .build()

    val completer = CommandCompleter()

    val reader = LineReaderBuilder.builder()
      .terminal(terminal)
      .completer(completer)
      .parser(new DefaultParser)
      .build()

    terminal.writer().println("Press tab to autocomplete. Enter 'exit' or press ctrl+c to exit.")
    terminal.flush()

    while (true) {
      Try(reader.readLine("$> ")) match {
        case Success(line) =>
          if (line == "exit") {
            System.exit(0)
          } else if (line != null) {
            terminal.writer().println("You: " + line.trim())
            terminal.flush()
          }
        case Failure(ignore @(_: UserInterruptException | _: EndOfFileException)) =>
          println("Buy!")
          System.exit(0)
        case Failure(_) =>
      }
    }
  }
}
