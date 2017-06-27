package io.dabrowski.grpc.client;

import io.dabrowski.grpc.api.EchoOuterClass;
import io.dabrowski.grpc.api.EchoServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

@GRpcService
public class EchoServiceImpl extends EchoServiceGrpc.EchoServiceImplBase {
    @Override
    public void echo(EchoOuterClass.Echo request, StreamObserver<EchoOuterClass.Echo> responseObserver) {
        System.out.println(request);
        responseObserver.onNext(request);
        responseObserver.onCompleted();
    }
}
