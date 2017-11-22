package casinoperformance

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

import java.io.File
import com.typesafe.config.{ Config, ConfigFactory }

class API_test extends Simulation {

  //set test config from config file
  var conf = ConfigFactory.load
  lazy val numberOfUsers = conf.getString("users")
  lazy val duration = conf.getString("duration")
  lazy val baseApiUrl = conf.getString("baseLocalApiUrl")
  lazy val SOME_VAL = conf.getString("SOME_PARAM")
  lazy val SOME_VAL_2 = conf.getString("SOME_PARAM_2")

  val commandLineParamUsers = Integer.getInteger("users", 1)
  val commandLineParamDuration = Integer.getInteger("duration", 1)

  System.out.println("Test will run with: " + commandLineParamUsers + " users per second rate")
  System.out.println("Duration for test execution: " + commandLineParamDuration + " minutes")

  //set base API url
  val httpConf = http
    .baseURL(baseApiUrl)
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val headers_10 = Map("Content-Type" -> """application/x-www-form-urlencoded""")
  val GetBalanceScenario = BonusTriggerRequestController;

  //set POST params
  val scn = scenario("Check bonus trigger request API performance")
    .forever{
    exec(http(SOME_VAL)
      .post(SOME_VAL)
      .formParam("""p""", SOME_PARAM)
      .check(regex("\"errorCode\":\"0\"")))
  }
  //setUp(scn.inject(rampUsers(numberOfUsers.toInt) over (duration.toInt seconds)).protocols(httpConf))
  //setUp(scn.inject(constantUsersPerSec(numberOfUsers.toInt).during(duration.toInt minutes).randomized)).maxDuration(duration.toInt minutes).protocols(httpConf)
  //setUp(scn.inject(constantUsersPerSec(commandLineParamUsers.toInt).during(commandLineParamDuration.toInt minutes).randomized)).maxDuration(commandLineParamDuration.toInt minutes).protocols(httpConf)
  setUp(scn.inject(rampUsersPerSec(1) to((3)) during (1 minutes))).maxDuration(1 minutes).protocols(httpConf)
}
