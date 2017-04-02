package br.com.oxi.laicnanifnalpym.repository.test.config;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import br.com.oxi.laicnanifnalpym.repository.config.PersistenceJPAConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration()
@ComponentScan("br.com.oxi")
@Import(PersistenceJPAConfig.class)
public abstract class AbstractDatabaseTest {

}
