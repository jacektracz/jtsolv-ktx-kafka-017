package com.jtsolv.jtsolvcurr.kafkaoperations;

import io.confluent.kafka.schemaregistry.avro.AvroSchema;
import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.rest.RestService;
import org.apache.avro.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AvroSchemaRegister {

    private static Logger logger = LoggerFactory.getLogger(AvroSchemaRegister.class.getName());

    public static void main(String[] args) {
        String schemaRegistryUrl = "http://localhost:8081"; // URL of your schema registry
        String subject = "jtsolv-avro-schema-3"; // The subject under which the schema is registered
        String schemaString = "{\n" +
                "  \"type\": \"record\",\n" +
                "  \"name\": \"User\",\n" +
                "  \"fields\": [\n" +
                "    { \"name\": \"name\", \"type\": \"string\" },\n" +
                "    { \"name\": \"age\", \"type\": \"int\" }\n" +
                "  ]\n" +
                "}"; // Avro schema definition as a string

        // Create Schema Registry Client
        RestService restService = new RestService(schemaRegistryUrl);
        SchemaRegistryClient schemaRegistryClient = new CachedSchemaRegistryClient(restService, 100);

        // Parse Avro schema from schema string
        Schema.Parser parser = new Schema.Parser();
        Schema avroSchema = parser.parse(schemaString);

        try {
            dbg("Schema register start ... ");
            // Register schema with the schema registry
            int schemaId = schemaRegistryClient.register(subject, new AvroSchema(avroSchema));
            dbg("Schema registered successfully with ID: " + schemaId);
        } catch (Exception e) {
            dbg("Error while registering schema: " + e.getMessage());
            err("Error while registering schema: " + e.getMessage());
        }
    }

    private static void dbg(String txt){
        logger.trace(txt);
    }

    private static String err (String txt){
        logger.trace(txt);
        logger.error(txt);
        return txt;
    }

}
