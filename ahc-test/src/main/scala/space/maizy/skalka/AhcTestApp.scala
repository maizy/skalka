package space.maizy.skalka

/**
 * Copyright (c) Nikita Kovaliov, maizy.ru, 2018
 * See LICENSE.txt for details.
 */

import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import space.maizy.skalka.core.CliApplication

object AhcTestApp extends CliApplication {

  val name = "ahc-test"

  def main(args: Array[String]): Unit = {
    val url = if (args.length > 0) args(0) else "https://example.com/"
    val httpClient = HttpClients.createDefault()
    val httpGet = new HttpGet(url)
    val response = httpClient.execute(httpGet)
    try {
      println(s"Status: ${response.getStatusLine}")
      val headers = response.getAllHeaders.toList.map { h => s"${h.getName} = ${h.getValue}" }
      println(s"Headers:\n${headers.mkString("\n")}")
      val body = response.getEntity
      println(s"Body:\n${EntityUtils.toString(body)}")
      EntityUtils.consume(body)
    } finally {
      response.close()
    }
  }
}
