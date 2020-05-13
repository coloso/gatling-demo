import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class MyFirstLoadtest extends Simulation {
	
	val httpProtocol = http.baseUrl("nginx")
	val scn = scenario("MyFirstTest").exec(http("Hello World").get("/"))

	setUp(scn.inject(atOnceUsers(20)).protocols(httpProtocol))	

}
