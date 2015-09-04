package sample;

import java.time.Clock;
import java.time.LocalDateTime;

import javax.inject.Inject;

import org.seasar.doma.jdbc.entity.EntityListener;
import org.seasar.doma.jdbc.entity.PreInsertContext;

public class TodoListener implements EntityListener<Todo> {

    @Inject
    private Clock clock;

    @Override
    public void preInsert(Todo entity, PreInsertContext<Todo> context) {
        entity.done = false;
        entity.createdAt = LocalDateTime.now(clock);
    }
}
