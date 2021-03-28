package com.vigneshsn.hazelcastexample;


import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public HazelcastInstance hazelcastClientInstance() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setClusterName("dev");
        clientConfig.getNetworkConfig().addAddress("192.168.99.100:5701", "192.168.99.100:5702");
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        return client;
    }
}
