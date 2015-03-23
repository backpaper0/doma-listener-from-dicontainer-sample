package sample;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.EntityListenerProvider;
import org.seasar.doma.jdbc.dialect.Dialect;

public class SampleConfig implements Config {

    @Inject
    private EntityListenerProvider entityListenerProvider;

    @Inject
    private DataSource dataSource;

    @Inject
    private Dialect dialect;

    @Override
    public EntityListenerProvider getEntityListenerProvider() {
        return entityListenerProvider;
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }
}
