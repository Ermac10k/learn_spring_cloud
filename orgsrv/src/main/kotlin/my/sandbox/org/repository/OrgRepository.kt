package my.sandbox.org.repository

import my.sandbox.org.model.Organization
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface OrganizationRepository : CrudRepository<Organization?, String?> {
    fun findById(organizationId: String?): Organization?
}