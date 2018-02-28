/*
 * Waltz - Enterprise Architecture
 * Copyright (C) 2016, 2017 Waltz open source project
 * See README.md for more information
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.khartec.waltz.service.constraints;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.khartec.waltz.model.ImmutableStringConstraintDefinition;
import com.khartec.waltz.model.StringConstraintDefinition;
import com.khartec.waltz.schema.DefaultSchema;
import org.jooq.Table;
import org.jooq.lambda.tuple.Tuple;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StringConstraintsService {

    /**
     * Takes the default jooq schema and returns a list of {@link StringConstraintDefinition} objects.
     */
    public List<StringConstraintDefinition> getFieldDefinitions() {
        List<Table<?>> tables = DefaultSchema.DEFAULT_SCHEMA.getTables();

        return tables
                .stream()
                .flatMap(table -> table
                            .fieldStream()
                            .map(field -> Tuple.tuple(table.getName(), field)))
                .filter(tf -> tf.v2.getType().isAssignableFrom(String.class))
                .map(tf -> {
                    int length = tf.v2.getDataType().length();
                    return ImmutableStringConstraintDefinition.builder()
                            .objectName(tf.v1)
                            .fieldName(tf.v2.getName())
                            .length(length == 0
                                    ? Integer.MAX_VALUE
                                    : length)
                            .build();
                })
                .collect(toList());
    }


    public static void main(String[] args) throws IOException {
        StringConstraintsService schemaToJson = new StringConstraintsService();
        List<StringConstraintDefinition> fieldDefinitions = schemaToJson.getFieldDefinitions();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(fieldDefinitions);
        System.out.println(json);
    }
}
