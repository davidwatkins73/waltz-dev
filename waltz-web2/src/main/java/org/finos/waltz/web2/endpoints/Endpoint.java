package org.finos.waltz.web2.endpoints;

import io.javalin.Javalin;

public interface Endpoint {
    void register(Javalin javalin);
}
