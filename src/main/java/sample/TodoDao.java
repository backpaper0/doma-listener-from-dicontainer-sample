package sample;

import java.util.List;

import javax.inject.Inject;

import org.seasar.doma.AnnotateWith;
import org.seasar.doma.Annotation;
import org.seasar.doma.AnnotationTarget;
import org.seasar.doma.Dao;
import org.seasar.doma.Insert;
import org.seasar.doma.Script;
import org.seasar.doma.Select;

@Dao
@AnnotateWith(annotations = { @Annotation(
        target = AnnotationTarget.CONSTRUCTOR, type = Inject.class) })
public interface TodoDao {

    @Select
    List<Todo> select();

    @Insert
    int insert(Todo entity);

    @Script
    void createTable();
}
