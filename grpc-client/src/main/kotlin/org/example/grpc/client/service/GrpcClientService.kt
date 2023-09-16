package org.example.grpc.client.service

import net.devh.boot.grpc.client.inject.GrpcClient
import org.example.grpc.HelloRequest
import org.example.grpc.SimpleGrpc.SimpleBlockingStub
import org.springframework.stereotype.Service

@Service
class GrpcClientService(
    @GrpcClient("test") private val simpleStub: SimpleBlockingStub
) {
    fun receiveGreeting(name: String): String {
        val request = HelloRequest.newBuilder()
            .setName(name)
            .build()
        val response = simpleStub.sayHello(request)
        return response.message
    }
}
