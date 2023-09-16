package org.example.grpc.client.controller

import org.example.grpc.client.service.GrpcClientService
import org.example.grpc.client.support.ApiResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GrpcClientController(
    private val grpcClientService: GrpcClientService
) {
    @GetMapping("/v1/greeting")
    fun greeting(
        @RequestParam name: String
    ): ApiResponse<String> {
        return ApiResponse.success(grpcClientService.receiveGreeting(name))
    }
}
