package my.sandbox.lic2conf.repository

import my.sandbox.lic2conf.model.License
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface LicRepository : CrudRepository<License?, String?> {
    fun findByOrganizationId(organizationId: String?): List<License?>
    fun findByOrganizationIdAndLicenseId(organizationId: String?, licenseId: String?): License?
}