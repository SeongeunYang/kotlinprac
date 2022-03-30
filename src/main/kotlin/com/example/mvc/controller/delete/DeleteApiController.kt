package com.example.mvc.controller.delete

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class DeleteApiController {

    // 1. path variable
    // 2. request param

    @DeleteMapping("/delete-mapping")
    fun deleteMapping(@RequestParam name: String, @RequestParam age: Int): String {
        println(name)
        println(age)
        return "delete-mapping"
    }

    @DeleteMapping("/delete-mapping/path/{name}/{age}")
    fun deleteMappingPath(@PathVariable name: String, @PathVariable age: Int): String {
        println(name)
        println(age)
        return "delete-mapping-path"
    }

    @RequestMapping(method = [RequestMethod.DELETE], path = ["/request-mapping"])
    fun requestMapping(@RequestParam name: String, @RequestParam age: Int): String {
        return "request-mapping - delete method"
    }
}