package my.sandbox.lic2conf.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.client.ServiceInstance
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.function.Consumer


@Service
class DiscoveryService @Autowired constructor(
    val restTemplate: RestTemplate,
    private val discoveryClient: DiscoveryClient
) {
    fun getEurekaServices(): List<String> {
        val services: MutableList<String> = ArrayList()
        discoveryClient.services.forEach(Consumer { serviceName: String? ->
            discoveryClient.getInstances(serviceName).forEach(
                Consumer { instance: ServiceInstance ->
                    services.add(
                        String.format(
                            "%s:%s",
                            serviceName,
                            instance.uri
                        )
                    )
                })
        })
        return services
    }
}