package io.camunda.connector;

import io.camunda.connector.api.annotation.OutboundConnector;
import io.camunda.connector.api.outbound.OutboundConnectorContext;
import io.camunda.connector.api.outbound.OutboundConnectorFunction;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Base64;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@OutboundConnector(
        name = "CATCONNECTOR",
        inputVariables = {"tag", "message"},
        type = "io.camunda:cat-connector:1")

public class CatConnectorFunction implements OutboundConnectorFunction {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatConnectorFunction.class);

    @Override
    public Object execute(OutboundConnectorContext context) throws Exception {
        var connectorRequest = context.getVariablesAsType(MyConnectorRequest.class);

        return executeConnector(connectorRequest);
    }

    private MyConnectorResult executeConnector(final MyConnectorRequest connectorRequest) {
        // TODO: implement connector logic
        LOGGER.info("Executing my connector with request {}", connectorRequest);
        var result = new MyConnectorResult();
        result.setUrl(getCatUrl(connectorRequest.getMessage(), connectorRequest.getTag()));
        return result;
    }

    private static String getCatUrl(String tag, String message) {
        return "https://cataas.com/cat/" + tag + "/says/" + message;
    }

}
