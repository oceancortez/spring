package org.oxi.service.store.test.service;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/ctx-oxi-service-test.xml" })
//@PropertySource(value = {})
public abstract class AbstractDatabaseTest {

}
