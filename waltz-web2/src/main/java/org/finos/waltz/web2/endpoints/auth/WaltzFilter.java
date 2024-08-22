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

package org.finos.waltz.web2.endpoints.auth;

import io.javalin.http.Handler;
import org.finos.waltz.service.settings.SettingsService;

import java.util.Optional;

import static org.finos.waltz.common.Checks.checkNotNull;


public abstract class WaltzFilter implements Handler {

    private final SettingsService settingsService;


    public WaltzFilter(SettingsService settingsService) {
        checkNotNull(settingsService, "Settings Service cannot be null");
        this.settingsService = settingsService;
    }


    public Optional<String> getSettingValue(String name) {
        return settingsService.getValue(name);
    }


}
