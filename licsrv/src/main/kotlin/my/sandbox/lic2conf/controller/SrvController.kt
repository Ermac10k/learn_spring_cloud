package my.sandbox.lic2conf.controller

import my.sandbox.lic2conf.cfg.ServiceCfg
import my.sandbox.lic2conf.model.License
import my.sandbox.lic2conf.service.LicenseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = ["v1/organizations/{organizationId}/licenses"])
class LicenseServiceController @Autowired constructor(
    private val licenseService: LicenseService,
    private val serviceConfig: ServiceCfg
) {

    @RequestMapping(value = ["/"], method = [RequestMethod.GET])
    fun getLicenses(@PathVariable("organizationId") organizationId: String?): List<License?> =
        licenseService.getLicensesByOrg(organizationId)

    @RequestMapping(value = ["/{licenseId}"], method = [RequestMethod.GET])
    fun getLicenses(
        @PathVariable("organizationId") organizationId: String?,
        @PathVariable("licenseId") licenseId: String?
    ): License? = organizationId?.let{ licenseService.getLicense(it, licenseId, "") }

    @RequestMapping(value = ["/{licenseId}/{clientType}"], method = [RequestMethod.GET])
    fun getLicensesWithClient(
        @PathVariable("organizationId") organizationId: String?,
        @PathVariable("licenseId") licenseId: String?,
        @PathVariable("clientType") clientType: String?
    ): License? = licenseService.getLicense(organizationId.orEmpty(), licenseId, clientType.orEmpty())

    @RequestMapping(value = ["{licenseId}"], method = [RequestMethod.PUT])
    fun updateLicenses(@PathVariable("licenseId") licenseId: String?, @RequestBody license: License?) =
        licenseService.updateLicense(license)

    @RequestMapping(value = ["/"], method = [RequestMethod.POST])
    fun saveLicenses(@RequestBody license: License?) = license?.let { licenseService.saveLicense(it) }

    @RequestMapping(value = ["{licenseId}"], method = [RequestMethod.DELETE])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteLicenses(@PathVariable("licenseId") licenseId: String?, @RequestBody license: License?) =
        license?.let{ licenseService.deleteLicense(license) }
}