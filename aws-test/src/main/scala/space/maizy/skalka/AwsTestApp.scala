package space.maizy.skalka

/**
 * Copyright (c) Nikita Kovaliov, maizy.space, 2018
 * See LICENSE.txt for details.
 */

import scala.collection.JavaConverters._
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.typesafe.scalalogging.StrictLogging
import space.maizy.skalka.core.CliApplication

object AwsTestApp extends CliApplication with StrictLogging {

  val name = "aws-test"

  def main(args: Array[String]): Unit = {
    logger.info("init")
    if (args.length == 1) {
      testS3Listing(args(0))
    } else {
      println("Usage: aws-test s3://bucket/path/")
    }
  }

  /**
   * currenty fails in runtime because of missing support for SSL/TLS in native-image
   * • graalVM issues - https://github.com/oracle/graal/issues/390, https://github.com/oracle/graal/issues/392
   * • exeption throws here -
   *    https://github.com/aws/aws-sdk-java/blob/4734de6fb0f80fe5768a6587aad3b9d0eaec388f/
   *      aws-java-sdk-core/src/main/java/com/amazonaws/internal/SdkSSLContext.java#L32
   */
  def testS3Listing(path: String): Unit = {
    val client = AmazonS3ClientBuilder.defaultClient()
    require(path.startsWith("s3://"))
    val subpath = path.substring("s3://".length)
    val parts = subpath.split("/")
    require(parts.length >= 2)
    val bucket = parts.head
    val prefix = parts.tail.mkString("/")
    val result = client.listObjectsV2(bucket, prefix)
    println(s"objects:\n * ${result.getObjectSummaries.asScala.map(_.getKey).mkString("\n * ")}")
  }
}
