package app;

import org.seasar.doma.AnnotateWith;
import org.seasar.doma.Annotation;
import org.seasar.doma.AnnotationTarget;
import org.seasar.doma.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.Application.Bar;

@Dao
@AnnotateWith(annotations = {
        @Annotation(type = Component.class, target = AnnotationTarget.CLASS),
        @Annotation(type = Autowired.class, target = AnnotationTarget.CONSTRUCTOR),
        @Annotation(type = Bar.class, target = AnnotationTarget.CONSTRUCTOR_PARAMETER) })
public interface BarDao {
}
