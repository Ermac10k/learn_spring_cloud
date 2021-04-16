package my.sandbox.lic2conf.cfg

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component


@Component
data class ServiceCfg(
    @Value("\${example.property}")
    val exampleProperty: String?
)