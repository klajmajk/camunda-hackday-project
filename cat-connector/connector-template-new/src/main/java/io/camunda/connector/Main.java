/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.camunda.connector;

import io.camunda.connector.runtime.jobworker.api.outbound.ConnectorJobHandler;
import io.camunda.zeebe.client.ZeebeClient;

/**
 *
 * @author adakl
 */
public class Main {

    public static void main(String[] args) {

        var zeebeClient = ZeebeClient.newCloudClientBuilder().
                withClusterId("266a0819-2a9e-44ac-9785-7077edd7c857").
                withClientId("nNl3EDBHtwyOJvaMYiYNtG7Kl5E4qiLc").
                withClientSecret("FW0ingxHHd~C1o6ObKPjpgIv35jYA-cylhhsuBr4q6FYBpgTlFm3Y.qTWow2cHEx")
                .withRegion("dsm-1")
                .build();

        zeebeClient.newWorker()
                .jobType("io.camunda:cat-connector:1")
                .handler(new ConnectorJobHandler(new CatConnectorFunction()))
                .name("CATCONNECTOR")
                .fetchVariables("tag", "message")
                .open();
    }
}
