package app;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.seasar.doma.AnnotateWith;
import org.seasar.doma.Annotation;
import org.seasar.doma.AnnotationTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.Application.Foo;

@Retention(RetentionPolicy.RUNTIME)
@AnnotateWith(annotations = {
        @Annotation(type = Component.class, target = AnnotationTarget.CLASS),
        @Annotation(type = Autowired.class, target = AnnotationTarget.CONSTRUCTOR),
        @Annotation(type = Foo.class, target = AnnotationTarget.CONSTRUCTOR_PARAMETER) })
public @interface FooConfigured {
}
