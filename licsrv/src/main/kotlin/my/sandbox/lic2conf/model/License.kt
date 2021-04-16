package my.sandbox.lic2conf.model

import javax.persistence.*


@Entity
@Table(name = "licenses")
data class License (
    @Id
    @Column(name = "license_id", nullable = false)
    var licenseId: String,

    @Column(name = "organization_id", nullable = false)
    var organizationId: String,

    @Transient
    var organizationName: String = "",

    @Transient
    var contactName: String = "",

    @Transient
    var contactPhone: String = "",

    @Transient
    var contactEmail: String = "",

    @Column(name = "product_name", nullable = false)
    var productName: String,

    @Column(name = "license_type", nullable = false)
    var licenseType: String,

    @Column(name = "license_max", nullable = false)
    var licenseMax: Int,

    @Column(name = "license_allocated", nullable = false)
    var licenseAllocated: Int,

    @Column(name = "comment")
    var comment: String?
) {
    fun withId(id: String?): License {
        licenseId = id.orEmpty()
        return this
    }

    fun withOrganizationId(organizationId: String?): License {
        this.organizationId = organizationId.orEmpty()
        return this
    }

    fun withProductName(productName: String?): License {
        this.productName = productName.orEmpty()
        return this
    }

    fun withLicenseType(licenseType: String?): License {
        this.licenseType = licenseType.orEmpty()
        return this
    }

    fun withLicenseMax(licenseMax: Int?): License {
        this.licenseMax = licenseMax ?: 0
        return this
    }

    fun withLicenseAllocated(licenseAllocated: Int?): License {
        this.licenseAllocated = licenseAllocated ?: 0
        return this
    }

    fun withComment(comment: String?): License {
        this.comment = comment
        return this
    }

    fun withOrganizationName(organizationName: String): License {
        this.organizationName = organizationName
        return this
    }

    fun withContactName(contactName: String): License {
        this.contactName = contactName
        return this
    }

    fun withContactPhone(contactPhone: String): License {
        this.contactPhone = contactPhone
        return this
    }

    fun withContactEmail(contactEmail: String): License {
        this.contactEmail = contactEmail
        return this
    }
}