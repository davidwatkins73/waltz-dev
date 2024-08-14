package org.finos.waltz.web2;

import io.javalin.Javalin;

public class MainV2 {
    public static void main(String[] args) {
        Javalin app = Javalin
                .create()
                .get("/", ctx -> ctx.result("Hello World"))
                .start(7070);
    }
}