package org.oxi.stok.config.test;

import org.junit.runner.RunWith;
import org.oxi.stok.config.PersistenceJPAConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
@ComponentScan("org.oxi")
@Import(PersistenceJPAConfig.class)
public abstract class AbstractDatabaseTest {

}
