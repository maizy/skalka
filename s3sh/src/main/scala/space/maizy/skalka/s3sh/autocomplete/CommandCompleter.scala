package space.maizy.skalka.s3sh.autocomplete

/**
 * Copyright (c) Nikita Kovaliov, maizy.ru, 2018
 * See LICENSE.txt for details.
 */

import java.util
import scala.collection.JavaConverters._
import org.jline.builtins.Completers
import org.jline.reader.impl.completer.ArgumentCompleter
import org.jline.reader.{ Completer, LineReader, ParsedLine }
import space.maizy.skalka.s3sh.command.{ Command, Commands }


object CommandCompleter {
  def apply(): CommandCompleter = new CommandCompleter(Commands.ALL)

  private def buildCompleter(commands: List[Command]): Completer = {
//    val nodes = commands.map{ command =>
//      TreeCompleter.node(command.name, TreeCompleter.node("TODO"))
//    }

//    new TreeCompleter(nodes: _*)

//    val comp = immutable.Map[String, Completer](
//      "C1" -> new StringsCompleter("ls"),
//      "C11" -> new StringsCompleter("--type", "--profile"),
//      "C12" -> new StringsCompleter("s3://path/to", "s3://path/to/other", "s3://path/to/some"),
//    )
//    def func(s: String): Completer = {
//      println(s)
//      comp.getOrElse(s, new NullCompleter())
//    }
////    comp.put("C2", new StringsCompleter("cmd2"))
////    comp.put("C21", new StringsCompleter("--opt21", "--opt22"))
////    comp.put("C22", new StringsCompleter("arg21", "arg22", "arg23"))
//    new RegexCompleter("C1 C11* C12+", func)

    val env = new Completers.CompletionEnvironment {
      override def getCompletions: util.Map[String, util.List[Completers.CompletionData]] =
        Map(
          "cmd" -> List(
            new Completers.CompletionData(List("a", "b").asJava, "test", "argX", "cond"),
            new Completers.CompletionData(List("e", "f").asJava, "test3", "argXX", "cond123")
          ).asJava,
          "cmd2" -> List(
            new Completers.CompletionData(List("c", "d").asJava, "test2", "argY", "cond2")
          ).asJava
        ).asJava

      override def getCommands: util.Set[String] = Set("cmd", "cmd2").asJava

      override def resolveCommand(command: String): String = command

      override def commandName(command: String): String = s"name:[$command]"

      override def evaluate(reader: LineReader, line: ParsedLine, func: String): AnyRef = {
        s"test - $reader, $line, $func"
      }
    }

    new Completers.Completer(env)
  }
}

class CommandCompleter(commands: List[Command]) extends ArgumentCompleter(CommandCompleter.buildCompleter(commands))

