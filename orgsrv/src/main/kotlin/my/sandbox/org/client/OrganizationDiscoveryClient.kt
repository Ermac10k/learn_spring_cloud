package my.sandbox.org.client

import my.sandbox.org.model.Organization
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
class OrganizationDiscoveryClient @Autowired constructor(
    private val discoveryClient: DiscoveryClient
) {
    fun getOrganization(organizationId: String?): Organization? {
        val restTemplate = RestTemplate()
        val instances: List<ServiceInstance> = discoveryClient.getInstances("orgsrv")
        if (instances.isEmpty()) return null
        val serviceUri = String.format("%s/v1/organizations/%s", instances[0].uri.toString(), organizationId)
        val restExchange = restTemplate.exchange(
            serviceUri,
            HttpMethod.GET,
            null, Organization::class.java, organizationId
        )
        return restExchange.body
    }
}