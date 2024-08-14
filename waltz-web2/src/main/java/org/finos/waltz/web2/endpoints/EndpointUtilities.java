/*
 * Waltz - Enterprise Architecture
 * Copyright (C) 2016, 2017, 2018, 2019 Waltz open source project
 * See README.md for more information
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific
 *
 */

package org.finos.waltz.web2.endpoints;


import io.javalin.Javalin;
import org.finos.waltz.web2.DatumRoute;
import org.finos.waltz.web2.ListRoute;

public class EndpointUtilities {

//    private static final ResponseTransformer transformer = WebUtilities.transformer;


    /**
     * Helper method to register a route which provides a list of items.
     * This helps comprehension as the return types of routes becomes explicit.
     * @param path
     * @param handler
     * @param <T>
     */
    public static <T> void getForList(Javalin javalin,
                                      String path,
                                      ListRoute<T> handler) {
        javalin.get(
                path,
                ctx -> ctx.json(handler.apply(ctx)));
    }

//
//    /**
//     * Helper method to register a route which provides a single item (not
//     * a list).  This helps comprehension as the return types of routes
//     * becomes explicit.
//     * @param path
//     * @param handler
//     * @param <T>
//     */
//    public static <T> void getForDatum(String path, DatumRoute<T> handler) {
//        Spark.get(path, wrapDatumHandler(handler), transformer);
//    }
//
//    public static <T> void postForDatum(String path, DatumRoute<T> handler) {
//        Spark.post(path, wrapDatumHandler(handler), transformer);
//    }
//
//    public static <T> void postForList(String path, ListRoute<T> handler) {
//        Spark.post(path, wrapListHandler(handler), transformer);
//    }
//
//    public static <T> void deleteForList(String path, ListRoute<T> handler) {
//        Spark.delete(path, wrapListHandler(handler), transformer);
//    }
//
//    public static <T> void deleteForDatum(String path, DatumRoute<T> handler) {
//        Spark.delete(path, wrapDatumHandler(handler), transformer);
//    }
//
//    public static <T> void putForDatum(String path, DatumRoute<T> handler) {
//        Spark.put(path, wrapDatumHandler(handler), transformer);
//    }
//
//    public static <T> void putForList(String path, ListRoute<T> handler) {
//        Spark.put(path, wrapListHandler(handler), transformer);
//    }
//
//    public static <T extends Exception> void addExceptionHandler(Class<T> exceptionClass, ExceptionHandler<T> handler) {
//        Spark.exception(exceptionClass, handler);
//
//        ExceptionHandlerImpl<T> servletExceptionHandler = new ExceptionHandlerImpl<T>(exceptionClass) {
//            @Override
//            public void handle(T exception, Request request, Response response) {
//                handler.handle(exception, request, response);
//            }
//        };
//
//        ExceptionMapper.getInstance().map(exceptionClass, servletExceptionHandler);
//    }
//
//    // -- helpers ---
//
//    private static <T> Route wrapListHandler(ListRoute<T> handler) {
//        return (request, response) -> {
//            response.type(TYPE_JSON);
//            return handler.apply(request, response);
//        };
//    }
//
//    private static <T> Route wrapDatumHandler(DatumRoute<T> handler) {
//        return (request, response) -> {
//            response.type(TYPE_JSON);
//            return handler.apply(request, response);
//        };
//    }

}
