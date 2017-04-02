package org.oxi.resteasy.persistences.database;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/ctx-oxi-spring-resteasy-consumes-service.test.xml"})
@ComponentScan("org.oxi")
//@PropertySource(value = {"classpath:consumes.properties"})
public abstract class AbstractDatabaseTest {

}
