package org.finos.waltz.web2;

import io.javalin.Javalin;
import org.finos.waltz.common.LoggingUtilities;
import org.finos.waltz.service.DIConfiguration;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.web2.endpoints.api.ChangeLogEndpoint;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainV2 {
    public static void main(String[] args) {

        LoggingUtilities.configureLogging();

        AnnotationConfigApplicationContext spring = new AnnotationConfigApplicationContext(DIConfiguration.class);

        Javalin app = Javalin
                .create()
                .get("/", ctx -> ctx.result("Hello World"))
                .start(7070);

        new ChangeLogEndpoint(spring.getBean(ChangeLogService.class)).register(app);
        System.out.println("Done");


    }
}