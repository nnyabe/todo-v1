package dynamo.to_do.todo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class Todo {
    public Todo() {
    }

    public Todo(String id, String heading, String description, String date, String time, boolean completed) {
        this.id = id;
        this.heading = heading;
        this.description = description;
        this.date = date;
        this.time = time;
        this.completed = completed;
    }

    private String id;
    private String heading;
    private String description;
    private String date;
    private String time;
    private boolean completed;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setId(String id) {
        this.id = id;
    }
}