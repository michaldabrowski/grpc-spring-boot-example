package io.dabrowski.grpc.client;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import io.dabrowski.grpc.api.EchoOuterClass;
import io.dabrowski.grpc.api.EchoServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Component;

import static java.lang.Thread.sleep;

@Component
@EnableDiscoveryClient
public class SimpleClient {
    @Autowired
    public SimpleClient(EurekaClient client) throws InterruptedException {
        int i = 0;
        while (true) {
            InstanceInfo instanceInfo = client.getNextServerFromEureka("echo-service", false);
            ManagedChannel channel = ManagedChannelBuilder.forAddress(instanceInfo.getIPAddr(), instanceInfo.getPort())
                .usePlaintext(true)
                .build();
            EchoServiceGrpc.EchoServiceBlockingStub stub = EchoServiceGrpc.newBlockingStub(channel);
            stub.echo(EchoOuterClass.Echo.newBuilder().setMessage("Hello " + i).build());
            System.out.println("Sent " + i);
            i++;
            sleep(1000);
        }
    }
}
