package com.searchservice.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.elasticsearch.tasks.Task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.searchservice.model.IndexedProject;
import com.searchservice.model.IndexedTask;
import com.searchservice.model.IndexedUser;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "elasticsearch-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*"); // Adjust trusted packages if needed
        return props;
    }

    @Bean
    public ConsumerFactory<String, IndexedTask> taskConsumerFactory() {
        JsonDeserializer<IndexedTask> jsonDeserializer = new JsonDeserializer<>(IndexedTask.class);
        jsonDeserializer.addTrustedPackages("*");
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(), jsonDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, IndexedTask> taskKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, IndexedTask> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(taskConsumerFactory());
        return factory;
    }
    
    @Bean
    public ConsumerFactory<String, IndexedProject> projectConsumerFactory() {
        JsonDeserializer<IndexedProject> jsonDeserializer = new JsonDeserializer<>(IndexedProject.class);
        jsonDeserializer.addTrustedPackages("*");
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(), jsonDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, IndexedProject> projectKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, IndexedProject> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(projectConsumerFactory());
        return factory;
    }
    
    @Bean
    public ConsumerFactory<String, IndexedUser> userConsumerFactory() {
        JsonDeserializer<IndexedUser> jsonDeserializer = new JsonDeserializer<>(IndexedUser.class);
        jsonDeserializer.addTrustedPackages("*");
        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(), jsonDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, IndexedUser> userKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, IndexedUser> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(userConsumerFactory());
        return factory;
    }
}


//package com.searchservice.config;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.apache.kafka.common.serialization.StringDeserializer;
//import org.elasticsearch.tasks.Task;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//
//import com.searchservice.model.IndexedTask;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@EnableKafka
//public class KafkaConsumerConfig {
//
//    @Bean
//    public Map<String, Object> consumerConfigs() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "elasticsearch-group");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());
//        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*"); // Adjust trusted packages if needed
//        return props;
//    }
//
//    @Bean
//    public ConsumerFactory<String, Task> taskConsumerFactory() {
//        JsonDeserializer<Task> jsonDeserializer = new JsonDeserializer<>(Task.class);
//        return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new StringDeserializer(), jsonDeserializer);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, Task> taskKafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, Task> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(taskConsumerFactory());
//        return factory;
//    }
//}
