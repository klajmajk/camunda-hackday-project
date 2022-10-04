package io.camunda.connector;

import io.camunda.connector.api.annotation.Secret;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class MyConnectorRequest {

    @NotEmpty
    private String message;

    @NotEmpty
    private String tag;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag, message);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        MyConnectorRequest other = (MyConnectorRequest) obj;
        return Objects.equals(tag, other.tag)
                && Objects.equals(message, other.message);
    }

    @Override
    public String toString() {
        return "MyConnectorRequest [message=" + message + ", authentication=" + tag + "]";
    }
}
