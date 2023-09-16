package org.example.grpc.server.service

import io.grpc.stub.StreamObserver
import net.devh.boot.grpc.server.service.GrpcService
import org.example.grpc.HelloReply
import org.example.grpc.HelloRequest
import org.example.grpc.SimpleGrpc

@GrpcService
class GrpcServerService : SimpleGrpc.SimpleImplBase() {
    override fun sayHello(request: HelloRequest?, responseObserver: StreamObserver<HelloReply>?) {
        val reply = HelloReply.newBuilder()
            .setMessage("Hello, ${request?.name}!")
            .build()
        responseObserver?.onNext(reply)
        responseObserver?.onCompleted()
    }
}
