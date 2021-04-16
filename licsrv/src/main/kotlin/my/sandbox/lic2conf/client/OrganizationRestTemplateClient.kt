package my.sandbox.lic2conf.client

import my.sandbox.lic2conf.model.Organization
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
            "http://orgsrv/v1/organizations/{organizationId}",
            HttpMethod.GET,
            null, Organization::class.java, organizationId
        )
        return restExchange.body
    }
}