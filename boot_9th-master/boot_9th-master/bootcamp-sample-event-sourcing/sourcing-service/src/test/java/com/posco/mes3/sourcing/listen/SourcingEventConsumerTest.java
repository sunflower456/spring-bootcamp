package com.posco.mes3.sourcing.listen;

import com.posco.mes3.share.domain.NameValueList;
import com.posco.mes3.shared.event.SourcingEvent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class SourcingEventConsumerTest {

    @MockBean
    private SourcingEventConsumer sourcingEventConsumer;

    private SourcingEvent sourcingEvent;

    @Before
    public void before() {
        //
        sourcingEvent = SourcingEvent.buildCreateEvent("Test", "Test", NameValueList.sample());
    }

    @Test
    public void testConsume() {
        //
        sourcingEventConsumer.listenSourcingEvent(sourcingEvent);
    }
}
