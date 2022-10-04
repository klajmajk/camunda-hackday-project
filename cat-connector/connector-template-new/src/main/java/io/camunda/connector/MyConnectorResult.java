package io.camunda.connector;

import java.util.Objects;

public class MyConnectorResult {

    // TODO: define connector result properties, which are returned to the process engine
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final MyConnectorResult that = (MyConnectorResult) o;
        return Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }

    @Override
    public String toString() {
        return "MyConnectorResult [myProperty=" + url + "]";
    }

}
