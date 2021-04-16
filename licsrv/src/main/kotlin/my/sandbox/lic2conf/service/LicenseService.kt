package my.sandbox.lic2conf.service

import my.sandbox.lic2conf.cfg.ServiceCfg
import my.sandbox.lic2conf.client.OrganizationDiscoveryClient
import my.sandbox.lic2conf.client.OrganizationFeignClient
import my.sandbox.lic2conf.client.OrganizationRestTemplateClient
import my.sandbox.lic2conf.model.License
import my.sandbox.lic2conf.model.Organization
import my.sandbox.lic2conf.repository.LicRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class LicenseService @Autowired constructor(
    private val licenseRepository: LicRepository,
    val config: ServiceCfg,
    val organizationFeignClient: OrganizationFeignClient,
    val organizationRestClient: OrganizationRestTemplateClient,
    val organizationDiscoveryClient: OrganizationDiscoveryClient
){
    private fun retrieveOrgInfo(organizationId: String, clientType: String): Organization? = when (clientType) {
        "feign" -> {
            println("I am using the feign client")
            organizationFeignClient.getOrganization(organizationId)
        }
        "rest" -> {
            println("I am using the rest client")
            organizationRestClient.getOrganization(organizationId)
        }
        "discovery" -> {
            println("I am using the discovery client")
            organizationDiscoveryClient.getOrganization(organizationId)
        }
        else -> organizationRestClient.getOrganization(organizationId)
    }

    fun getLicense(organizationId: String, licenseId: String?, clientType: String): License? {
        val license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId)
        val org = retrieveOrgInfo(organizationId, clientType)
        return license
            ?.withOrganizationName(org?.name.orEmpty())
            ?.withContactName(org?.contactName.orEmpty())
            ?.withContactEmail(org?.contactEmail.orEmpty())
            ?.withContactPhone(org?.contactPhone.orEmpty())
            ?.withComment(config.exampleProperty)
    }

    fun getLicensesByOrg(organizationId: String?): List<License?> = licenseRepository.findByOrganizationId(organizationId)

    fun saveLicense(license: License) {
        license.withId(UUID.randomUUID().toString())
        licenseRepository.save(license)
    }

    fun updateLicense(license: License?) = license?.let {licenseRepository.save(it)}
    fun deleteLicense(license: License) = licenseRepository.delete(license)
}