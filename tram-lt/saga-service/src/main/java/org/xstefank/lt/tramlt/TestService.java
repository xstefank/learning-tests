package org.xstefank.lt.tramlt;

import io.eventuate.tram.sagas.orchestration.SagaManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xstefank.lt.tramlt.saga.TestSagaData;

@Component
public class TestService {

    @Autowired
    private SagaManager<TestSagaData> testSagaManager;

    public String testExecution() {
        System.out.println("testExecution()");

        TestSagaData data = new TestSagaData("test string");
        testSagaManager.create(data);

        return "processing saga";
    }
}
