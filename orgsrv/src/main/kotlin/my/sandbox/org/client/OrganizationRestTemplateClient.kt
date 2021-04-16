package my.sandbox.org.client

import my.sandbox.org.model.Organization
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate


@Component
class OrganizationRestTemplateClient @Autowired constructor(
    val restTemplate: RestTemplate
){
    fun getOrganization(organizationId: String?): Organization? {
        val restExchange = restTemplate.exchange(
            "http://organizationservice/v1/organizations/{organizationId}",
            HttpMethod.GET,
            null, Organization::class.java, organizationId
        )
        return restExchange.body
    }
}