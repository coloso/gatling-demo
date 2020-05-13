import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder

class MyFirstSimulation extends Simulation {


    val theHttpProtocolBuilder: HttpProtocolBuilder = http
        .baseUrl("172.28.1.1")


    val theScenarioBuilder: ScenarioBuilder = scenario("Scenario1")
        .exec(
            http("myRequest1")
                .get("/")
        )

    setUp(
        theScenarioBuilder.inject(atOnceUsers(1))
    ).protocols(theHttpProtocolBuilder)
}
