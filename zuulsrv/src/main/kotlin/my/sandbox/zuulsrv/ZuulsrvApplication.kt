package my.sandbox.zuulsrv

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@SpringBootApplication
@EnableZuulProxy
class ZuulsrvApplication

fun main(args: Array<String>) {
	runApplication<ZuulsrvApplication>(*args)
}
