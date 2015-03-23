package sample;

import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Sample {

    public static void main(String[] args) {
        String url = "jdbc:h2:mem:sample;DB_CLOSE_DELAY=-1";
        String user = "sa";
        String password = "secret";
        Module module = new SampleModule(url, user, password);
        Injector injector = Guice.createInjector(module);
        TodoDao dao = injector.getInstance(TodoDao.class);
        dao.createTable();

        Todo todo1 = new Todo();
        todo1.content = "あれやる";
        dao.insert(todo1);

        Todo todo2 = new Todo();
        todo2.content = "これやる";
        dao.insert(todo2);

        List<Todo> entities = dao.select();
        entities.forEach(e -> System.out.printf("%1$s (%2$s)%n", e.content,
                e.createdAt));
    }
}
