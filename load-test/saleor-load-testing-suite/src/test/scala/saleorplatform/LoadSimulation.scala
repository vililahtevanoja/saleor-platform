package saleorplatforms

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class LoadSimulation extends Simulation {
  val httpProtocol = http
    .baseUrl("http://localhost:3000") // Here is the root for all relative URLs
    .acceptHeader(
      "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"
    )
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader(
      "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0"
    )

  val feeder = Array(
    Map("category" -> "/category/juices/14/"),
    Map("category" -> "/category/alcohol/15/"),
    Map("category" -> "/category/polo-shirts/11/"),
    Map("category" -> "/category/t-shirts/10/"),
    Map("category" -> "/category/footwear/13/"),
    Map("category" -> "/category/hoodies/12/"),
    Map("category" -> "/category/paints/20/"),
    Map("category" -> "/category/homewares/22/"),
    Map("category" -> "/category/audiobooks/23/")
  ).random

  val scn =
    scenario("Browsing scenario")
      .exec(
        http("request_1")
          .get("/")
      )
      .pause(2 seconds)
      .feed(feeder)
      .exec(
        http("request_2")
          .get("${category}")
      )
      .pause(2 seconds)
      .feed(feeder)
      .exec(
        http("request_3")
          .get("${category}")
      )
      .pause(2 seconds)
      .feed(feeder)
      .exec(
        http("request_4")
          .get("${category}")
      )
      .pause(2 seconds)
      .feed(feeder)
      .exec(
        http("request_5")
          .get("${category}")
      )
      .pause(2 seconds)
      .feed(feeder)
      .exec(
        http("request_6")
          .get("${category}")
      )
      .pause(2 seconds)
      .feed(feeder)
      .exec(
        http("request_7")
          .get("${category}")
      )
      .pause(2 seconds)
      .feed(feeder)
      .exec(
        http("request_8")
          .get("${category}")
      )
      .pause(2 seconds)
      .feed(feeder)
      .exec(
        http("request_9")
          .get("${category}")
      )

  setUp(
    scn
      .inject(rampUsers(1000).during(5 seconds))
      .protocols(httpProtocol)
  )
}
