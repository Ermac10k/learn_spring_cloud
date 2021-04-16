package my.sandbox.org.controller

import my.sandbox.org.model.Organization
import my.sandbox.org.service.OrganizationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = ["v1/organizations"])
class OrganizationServiceController @Autowired constructor(
    private val orgService: OrganizationService
) {
    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun getOrganizations(): List<Organization?> {
        return orgService.getOrgs()
    }

    @RequestMapping(value = ["/{organizationId}"], method = [RequestMethod.GET])
    fun getOrganization(@PathVariable("organizationId") organizationId: String?): Organization? {
        return orgService.getOrg(organizationId)
    }

    @RequestMapping(value = ["/{organizationId}"], method = [RequestMethod.PUT])
    fun updateOrganization(@PathVariable("organizationId") orgId: String?, @RequestBody org: Organization?) =
        org?.let{ orgService.updateOrg(it) }

    @RequestMapping(value = ["/{organizationId}"], method = [RequestMethod.POST])
    @ResponseBody
    fun saveOrganization(@RequestBody org: Organization?): String {
        org?.let {
            orgService.saveOrg(it)
        }
        return "saved?"
    }

    @RequestMapping(value = ["/{organizationId}"], method = [RequestMethod.DELETE])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteOrganization(@PathVariable("orgId") orgId: String?, @RequestBody org: Organization?) = org?.let{
        orgService.deleteOrg(it)
    }
}