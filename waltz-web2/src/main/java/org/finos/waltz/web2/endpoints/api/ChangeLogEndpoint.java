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

package org.finos.waltz.web2.endpoints.api;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.changelog.ChangeLog;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.web2.endpoints.Endpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static org.finos.waltz.common.Checks.checkNotNull;
import static org.finos.waltz.common.DateTimeUtilities.toSqlDate;
import static org.finos.waltz.common.StringUtilities.mkPath;
import static org.finos.waltz.web2.WebUtilities.getDateParam;
import static org.finos.waltz.web2.WebUtilities.getEntityReference;
import static org.finos.waltz.web2.endpoints.EndpointUtilities.getForList;


@Service
public class ChangeLogEndpoint implements Endpoint {


    private static final String BASE_URL = mkPath("api", "change-log");

    private final ChangeLogService service;


    @Autowired
    public ChangeLogEndpoint(ChangeLogService changeLogService) {
        checkNotNull(changeLogService, "changeLogService must not be null");
        this.service = changeLogService;
    }

    @Override
    public void register(Javalin javalin) {

        getForList(
                javalin,
                mkPath(BASE_URL, "user", "{userId}"),
                ctx -> service.findByUser(
                                ctx.pathParam("userId"),
                                getLimit(ctx)));
//
//        postForList(
//                mkPath(BASE_URL, "summaries", ":kind"),
//                (request, response) -> service.findCountByDateForParentKindBySelector(
//                        getKind(request),
//                        readIdSelectionOptionsFromBody(request),
//                        getLimit(request)));
//
        getForList(
                javalin,
                mkPath(BASE_URL, "{kind}", "{id}"),
                (ctx) -> {
                    EntityReference ref = getEntityReference(ctx);
                    Optional<java.util.Date> dateParam = getDateParam(ctx);
                    Optional<Integer> limitParam = getLimit(ctx);

                    if (ref.kind() == EntityKind.PERSON) {
                        return service.findByPersonReference(ref, dateParam, limitParam);
                    } else {
                        return service.findByParentReference(ref, dateParam, limitParam);
                    }
                });
//
//        getForList(
//                mkPath(BASE_URL, ":kind", ":id", "date-range"),
//                (request, response) -> {
//                    EntityReference ref = getEntityReference(request);
//                    Date startDate = getStartDate(request);
//                    Date endDate = getEndDate(request);
//                    Optional<Integer> limitParam = getLimit(request);
//
//                    if (ref.kind() == EntityKind.PERSON) {
//                        return service.findByPersonReferenceForDateRange(ref, startDate, endDate, limitParam);
//                    } else {
//                        return service.findByParentReferenceForDateRange(ref, startDate, endDate, limitParam);
//                    }
//                });
//
//        getForList(
//                mkPath(BASE_URL, ":kind", ":id", "unattested"),
//                (request, response) -> {
//                    EntityReference ref = getEntityReference(request);
//                    return service.findUnattestedChanges(ref);
//                });


    }




    public static Optional<Integer> getLimit(Context ctx) {
        String limitVal = ctx.queryParam("limit");
        return Optional
                .ofNullable(limitVal)
                .map(Integer::valueOf);
    }


    private Date getStartDate(Context ctx) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return toSqlDate(formatter.parse(ctx.queryParam("startDate")));
    }


    private Date getEndDate(Context ctx) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return toSqlDate(formatter.parse(ctx.queryParam("endDate")));
    }
}
