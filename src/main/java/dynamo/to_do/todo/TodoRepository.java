package dynamo.to_do.todo;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;


import java.util.List;
import java.util.UUID;

@Repository
public class TodoRepository {

    private final DynamoDbClient dynamoDbClient;
    private DynamoDbTable<Todo> todoTable;

    public TodoRepository(DynamoDbClient dynamoDbClient) {
        this.dynamoDbClient = dynamoDbClient;
    }

//    @PostConstruct
//    public void init() {
//        DynamoDbEnhancedClient enhancedClient = DynamoDbEnhancedClient.builder()
//                .dynamoDbClient(dynamoDbClient)
//                .build();
//        todoTable = enhancedClient.table("Todos", TableSchema.fromBean(Todo.class));
//    }

    public Todo save(Todo todo) {
        if (todo.getId() == null) {
            todo.setId(UUID.randomUUID().toString());
        }
        todoTable.putItem(todo);
        return todo;
    }

    public List<Todo> findAll() {
        return todoTable.scan().items().stream().toList();
    }

    public Todo findById(String id) {
        return todoTable.getItem(r -> r.key(k -> k.partitionValue(id)));
    }

    public void delete(String id) {
        todoTable.deleteItem(r -> r.key(k -> k.partitionValue(id)));
    }
}