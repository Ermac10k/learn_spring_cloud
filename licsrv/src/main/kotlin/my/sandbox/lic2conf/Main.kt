package my.sandbox.lic2conf

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
//import org.springframework.security.config.annotation.web.builders.HttpSecurity
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
//import org.springframework.security.core.userdetails.User
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.core.userdetails.UserDetailsService
//import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.web.client.RestTemplate


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
class HelloApplication() {
//	@Throws(Exception::class)
//	override fun configure(http: HttpSecurity) {
//		http
//			.authorizeRequests()
//			.antMatchers("/", "/home").permitAll()
//			.anyRequest().authenticated()
//			.and()
//			.httpBasic()
//			.realmName("lic")
//			.and()
//			.csrf().disable()
//	}
//
//	@Bean
//	override fun userDetailsService(): UserDetailsService? {
//		val user: UserDetails = User.withDefaultPasswordEncoder()
//			.username("user")
//			.password("password")
//			.roles("USER")
//			.build()
//		return InMemoryUserDetailsManager(user)
//	}

	@LoadBalanced
	@Bean
	fun getRestTemplate(): RestTemplate {
		return RestTemplate()
	}
}

fun main(args: Array<String>) {
	runApplication<HelloApplication>(*args)
}
