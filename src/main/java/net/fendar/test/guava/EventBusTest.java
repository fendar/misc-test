package net.fendar.test.guava;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.junit.Test;

/**
 * Created by zhongchao on 16/8/18.
 */
public class EventBusTest {
    @Test
    public void test1() {
        EventBus eventBus = new EventBus("test");


        eventBus.register(new EventTestListener());

        eventBus.post(new EventTest("18510085170", "123fsdsfdsf"));
    }


    class EventTest {
        private final String phone;
        private final String uuid;

        public EventTest(String phone, String uuid) {
            this.phone = phone;
            this.uuid = uuid;
        }

        public String getPhone() {
            return phone;
        }

        public String getUuid() {
            return uuid;
        }
    }

    class EventTestListener {
        @Subscribe
        public void handleEventTest(EventTest eventTest) {
            System.out.println(eventTest.getPhone());
            System.out.println(eventTest.getUuid());
        }
    }
}
