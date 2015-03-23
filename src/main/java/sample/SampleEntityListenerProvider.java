package sample;

import java.util.function.Supplier;

import javax.inject.Inject;

import org.seasar.doma.jdbc.EntityListenerProvider;
import org.seasar.doma.jdbc.entity.EntityListener;

import com.google.inject.Injector;

public class SampleEntityListenerProvider implements EntityListenerProvider {

    @Inject
    private Injector injector;

    @Override
    public <ENTITY, LISTENER extends EntityListener<ENTITY>> LISTENER get(
            Class<LISTENER> listenerClass, Supplier<LISTENER> listenerSupplier) {
        return injector.getInstance(listenerClass);
    }
}
