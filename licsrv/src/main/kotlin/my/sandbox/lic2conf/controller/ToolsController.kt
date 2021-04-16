package my.sandbox.lic2conf.controller

import my.sandbox.lic2conf.service.DiscoveryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(value = ["v1/tools"])
class ToolsController @Autowired constructor(
    private val discoveryService: DiscoveryService
){
    @RequestMapping(value = ["/eureka/services"], method = [RequestMethod.GET])
    fun getEurekaServices(): List<String?> = discoveryService.getEurekaServices()
}