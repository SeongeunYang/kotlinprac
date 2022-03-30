package com.example.mvc.controller.response

import com.example.mvc.modelhttp.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/response")
class ResponseApiController {

    @GetMapping("")
    fun getMapping(@RequestParam age: Int?): ResponseEntity<String> {

        age?.let {
            if (it < 20) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("age는 20보다 작아야 합니다.")
            }

            return ResponseEntity.status(HttpStatus.OK).body("sucess")
        } ?: kotlin.run {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("age는 20보다 커야 합니다.")
        }

//        // 0. age == null -> 400 error
//        if (age == null){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("age는 20보다 작아야 합니다.")
//        }
//        // 1. age < 20 -> 400 error
//        if (age < 20) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("age는 20보다 커야 합니다.")
//        }

        return ResponseEntity.status(HttpStatus.OK).body("sucess")
    }

    @PostMapping("")
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<Any> {
        return ResponseEntity.status(200).body(userRequest)
    }

    @PutMapping("")
    fun putMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }

    @DeleteMapping("")
    fun deleteMapping(@PathVariable id:Int): ResponseEntity<Any> {
        return ResponseEntity.status(500).body(null)
    }
}