package com.example.freteCheck.Repository.nosql;

import com.example.freteCheck.model.Frete;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;
import java.util.*;

@Repository
@RequiredArgsConstructor
public class FreteRepository {

    private final DynamoDbClient dynamoDbClient;
    private final String tableName = "Frete";

    public Frete save(Frete frete) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("id", AttributeValue.builder().s(frete.getId()).build());
        item.put("origem", AttributeValue.builder().s(frete.getOrigem()).build());
        item.put("destino", AttributeValue.builder().s(frete.getDestino()).build());
        item.put("descricao", AttributeValue.builder().s(frete.getDescricao()).build());
        item.put("valor", AttributeValue.builder().n(String.valueOf(frete.getValor())).build());
        item.put("status", AttributeValue.builder().s(frete.getStatus()).build());
        item.put("motorista", AttributeValue.builder().s(frete.getMotorista()).build());
        item.put("telefone", AttributeValue.builder().s(frete.getTelefone()).build());
        item.put("rating", AttributeValue.builder().n(String.valueOf(frete.getRating())).build());

        dynamoDbClient.putItem(PutItemRequest.builder()
                .tableName(tableName)
                .item(item)
                .build());
        return frete;
    }

    public Optional<Frete> findById(String id) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("id", AttributeValue.builder().s(id).build());

        GetItemResponse response = dynamoDbClient.getItem(GetItemRequest.builder()
                .tableName(tableName)
                .key(key)
                .build());

        if (!response.hasItem()) {
            return Optional.empty();
        }

        return Optional.of(mapToFrete(response.item()));
    }

    public List<Frete> findAll() {
        ScanResponse response = dynamoDbClient.scan(ScanRequest.builder()
                .tableName(tableName)
                .build());

        List<Frete> fretes = new ArrayList<>();
        for (Map<String, AttributeValue> item : response.items()) {
            fretes.add(mapToFrete(item));
        }
        return fretes;
    }

    public void deleteById(String id) {
        Map<String, AttributeValue> key = new HashMap<>();
        key.put("id", AttributeValue.builder().s(id).build());

        dynamoDbClient.deleteItem(DeleteItemRequest.builder()
                .tableName(tableName)
                .key(key)
                .build());
    }

    private Frete mapToFrete(Map<String, AttributeValue> item) {
        Frete frete = new Frete();
        frete.setId(item.get("id").s());
        frete.setOrigem(item.get("origem").s());
        frete.setDestino(item.get("destino").s());
        frete.setDescricao(item.get("descricao").s());
        frete.setValor(Double.parseDouble(item.get("valor").n()));
        frete.setStatus(item.get("status").s());
        frete.setMotorista(item.get("motorista").s());
        frete.setTelefone(item.get("telefone").s());
        frete.setRating(Double.parseDouble(item.get("rating").n()));
        return frete;
    }
}
