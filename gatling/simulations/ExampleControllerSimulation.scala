import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class ExampleControllerSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://nginx") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Scenario Name") // A scenario is a chain of requests and pauses
    .exec(
      http("request_1")
        .get("/example")
    )

  setUp(scn.inject(atOnceUsers(10)).protocols(httpProtocol))
}
