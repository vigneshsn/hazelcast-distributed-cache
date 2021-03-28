package com.vigneshsn.hazelcastexample;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class HazelcastExampleApplication implements CommandLineRunner {

	private final HazelcastInstance hazelcastInstance;

	public static void main(String[] args) {
		SpringApplication.run(HazelcastExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Long writeStart = System.currentTimeMillis();
		IMap<String, Customer> mapCustomers = hazelcastInstance.getMap("customers");
		int i=1;
		while(i <= 100) {
			String id = String.valueOf(i);
			mapCustomers.put(id, new Customer(id, "foo "+ 1));
			i++;
		}

		log.info("total time taken for write {}", System.currentTimeMillis() - writeStart);
		log.info("loaded customers into hazelcast");

		Long readStart = System.currentTimeMillis();
		int j = 0;
		while(j <= 100) {
			mapCustomers.get(j);
			j++;
		}
		log.info("total time taken for read {}", System.currentTimeMillis() - readStart);
	}
}
