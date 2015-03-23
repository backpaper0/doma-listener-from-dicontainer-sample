package sample;

import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.inject.Provider;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PreInsertContext;

public class TodoListener implements EntityListener<Todo> {

    @Inject
    private Provider<LocalDateTime> createdAtProvider;

    @Override
    public void preInsert(Todo entity, PreInsertContext<Todo> context) {
        entity.done = false;
        entity.createdAt = createdAtProvider.get();
    }
}
