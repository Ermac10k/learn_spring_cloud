package my.sandbox.lic2conf.client

import my.sandbox.lic2conf.model.Organization
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod


@FeignClient("orgsrv")
interface OrganizationFeignClient {
    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/v1/organizations/{organizationId}"],
        consumes = ["application/json"]
    )
    fun getOrganization(@PathVariable("organizationId") organizationId: String?): Organization?
}