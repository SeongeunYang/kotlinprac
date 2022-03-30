package com.example.mvc.controller.put

import com.example.mvc.modelhttp.Result
import com.example.mvc.modelhttp.UserRequest
import com.example.mvc.modelhttp.UserResponse
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api")
class PutApiController {

    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }

    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping - put method"
    }

    @PutMapping("/put-mapping/object")
    fun putMappingObject(@RequestBody userRequest: UserRequest): UserResponse {

        return UserResponse().apply {
            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "sucess"
            }
        }.apply {
            this.description = "!!!!"
        }.apply {
            val userList = mutableListOf<UserRequest>()

            userList.add(userRequest)
            userList.add(UserRequest().apply {
                this.name = "Ella"
                this.age = 24
                this.email = "aaa"
                this.address = "adsfa"
                this.phoneNumber = "01011111111"
            })
            userList.add(UserRequest().apply {
                this.name = "lala"
                this.age = 20
                this.email = "aaa113r"
                this.address = "adsfa33r"
                this.phoneNumber = "01022221111"
            })
        }
    }

}