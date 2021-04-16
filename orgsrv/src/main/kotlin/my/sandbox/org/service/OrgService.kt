package my.sandbox.org.service

import my.sandbox.org.model.Organization
import my.sandbox.org.repository.OrganizationRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*


@Service
class OrganizationService @Autowired constructor(
    private val orgRepository: OrganizationRepository
) {
    fun getOrgs(): List<Organization?> = orgRepository.findAll().toList()

    fun getOrg(organizationId: String?): Organization? = orgRepository.findById(organizationId)

    fun saveOrg(org: Organization) {
        org.id = UUID.randomUUID().toString()
        orgRepository.save(org)
    }

    fun updateOrg(org: Organization) = orgRepository.save(org)
    fun deleteOrg(org: Organization) = orgRepository.delete(org)
}