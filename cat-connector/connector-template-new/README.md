> A template for new C8 connectors.
>
> To use this template update the following resources to match the name of your connector:
>
> * [README](./README.md) (title, description)
> * [Element Template](./element-templates/template-connector.json)
> * [POM](./pom.xml) (artifact name, id, description)
> * [Connector Function](./src/main/java/io/camunda/connector/MyConnectorFunction.java) (rename, implement, update `OutboundConnector` annotation)
> * [Service Provider Interface (SPI)](./src/main/resources/META-INF/services/io.camunda.connector.api.ConnectorFunction#L1) (rename)
>
> ...and delete this hint.


# Connector Template

Camunda Connector Template

## Build

```bash
mvn clean package
```

## API

### Input

```json
{
  "token": ".....",
  "message": "....."
}
```

### Output

```json
{
  "result": {
    "myProperty": "....."
  }
}
```

## Test locally

Run unit tests

```bash
mvn clean verify
```

Use the [Camunda Job Worker Connector Run-Time](https://github.com/camunda/connector-framework/tree/main/runtime-job-worker) to run your function as a local Job Worker.

## Element Template

The element templates can be found in the [element-templates/template-connector.json](element-templates/template-connector.json) file.


RUNNING
export ZEEBE_ADDRESS='266a0819-2a9e-44ac-9785-7077edd7c857.dsm-1.zeebe.camunda.io:443'
export ZEEBE_CLIENT_ID='nNl3EDBHtwyOJvaMYiYNtG7Kl5E4qiLc'
export ZEEBE_CLIENT_SECRET='FW0ingxHHd~C1o6ObKPjpgIv35jYA-cylhhsuBr4q6FYBpgTlFm3Y.qTWow2cHEx'
# export ZEEBE_AUTHORIZATION_SERVER_URL='[OAuth API]'

CONNECTOR_CATCONNECTOR_FUNCTION=io.camunda.connector
#CONNECTOR_SLACK_TYPE=non-default-slack-task-type
