package sample;

import java.time.LocalDateTime;

import javax.inject.Provider;
import javax.inject.Singleton;
import javax.sql.DataSource;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.EntityListenerProvider;
import org.seasar.doma.jdbc.SimpleDataSource;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.H2Dialect;

import com.google.inject.AbstractModule;

public class SampleModule extends AbstractModule {

    private final String url, user, password;

    public SampleModule(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    protected void configure() {
        binder().requireExplicitBindings();

        SimpleDataSource dataSource = new SimpleDataSource();
        dataSource.setUrl(url);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        bind(Config.class).to(SampleConfig.class).in(Singleton.class);
        bind(EntityListenerProvider.class).to(
                SampleEntityListenerProvider.class).in(Singleton.class);
        bind(DataSource.class).toInstance(dataSource);
        bind(Dialect.class).to(H2Dialect.class).in(Singleton.class);

        bind(TodoDao.class).to(TodoDaoImpl.class);
        bind(TodoListener.class);

        Provider<? extends LocalDateTime> createdAtProvider = LocalDateTime::now;
        bind(LocalDateTime.class).toProvider(createdAtProvider);
    }
}
