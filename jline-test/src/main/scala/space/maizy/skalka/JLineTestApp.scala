package space.maizy.skalka

/**
 * Copyright (c) Nikita Kovaliov, maizy.space, 2018
 * See LICENSE.txt for details.
 */

import org.jline.reader.{ EndOfFileException, LineReaderBuilder, UserInterruptException }
import org.jline.reader.impl.DefaultParser
import org.jline.reader.impl.completer.{ ArgumentCompleter, StringsCompleter }
import org.jline.terminal.TerminalBuilder
import space.maizy.skalka.core.CliApplication

import scala.util.{ Failure, Success, Try }

object JLineTestApp extends CliApplication {

  val name = "jline-test"

  def main(args: Array[String]): Unit = {
    val terminal = TerminalBuilder
      .builder()
      .system(true)
      .build()

    val completer = new ArgumentCompleter(
      new StringsCompleter("bar", "baz"),
      new StringsCompleter("foo"),
      new StringsCompleter("ree")
    )

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
