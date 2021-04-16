package my.sandbox.eur

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class EurApplication

fun main(args: Array<String>) {
	runApplication<EurApplication>(*args)
}
