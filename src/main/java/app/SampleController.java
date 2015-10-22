package app;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.seasar.doma.jdbc.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Autowired
    FooDao fooDao;
    @Autowired
    BarDao barDao;

    @RequestMapping(value = "/", produces = "text/plain")
    String index() {
        StringWriter s = new StringWriter();
        try (PrintWriter out = new PrintWriter(s)) {
            out.println(Config.get(fooDao).getDataSourceName());
            out.println(Config.get(barDao).getDataSourceName());
        }
        return s.toString();
    }
}
