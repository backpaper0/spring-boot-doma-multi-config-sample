package app;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.sql.DataSource;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.SimpleDataSource;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.StandardDialect;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    @Foo
    Config config1() {
        return new Config() {

            @Override
            public String getDataSourceName() {
                return "foo";
            }

            @Override
            public Dialect getDialect() {
                return new StandardDialect();
            }

            @Override
            public DataSource getDataSource() {
                return new SimpleDataSource();
            }
        };
    }

    @Bean
    @Bar
    Config config2() {
        return new Config() {

            @Override
            public String getDataSourceName() {
                return "bar";
            }

            @Override
            public Dialect getDialect() {
                return new StandardDialect();
            }

            @Override
            public DataSource getDataSource() {
                return new SimpleDataSource();
            }
        };
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Foo {
    }

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Bar {
    }
}
