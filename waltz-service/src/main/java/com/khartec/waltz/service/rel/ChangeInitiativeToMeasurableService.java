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

package com.khartec.waltz.service.rel;

import com.khartec.waltz.data.change_initiative.ChangeInitiativeIdSelectorFactory;
import com.khartec.waltz.data.measurable.MeasurableIdSelectorFactory;
import com.khartec.waltz.data.rel.ChangeInitiativeToMeasurableRelDao;
import com.khartec.waltz.model.IdSelectionOptions;
import com.khartec.waltz.model.rel.ChangeInitiativeToMeasurableRel;
import com.khartec.waltz.model.rel.CreateRelationshipCommand;
import org.jooq.Record1;
import org.jooq.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.khartec.waltz.common.Checks.checkNotNull;

@Service
public class ChangeInitiativeToMeasurableService {

    private final ChangeInitiativeToMeasurableRelDao changeInitiativeToMeasurableDao;


    @Autowired
    public ChangeInitiativeToMeasurableService(ChangeInitiativeToMeasurableRelDao changeInitiativeToMeasurableDao) {
        checkNotNull(changeInitiativeToMeasurableDao, "changeInitiativeToMeasurableDao cannot be null");
        this.changeInitiativeToMeasurableDao = changeInitiativeToMeasurableDao;
    }


    public Set<ChangeInitiativeToMeasurableRel> findForChangeInitiativeSelector(IdSelectionOptions selectionOptions) {
        Select<Record1<Long>> selector = new ChangeInitiativeIdSelectorFactory().apply(selectionOptions);
        return changeInitiativeToMeasurableDao.findForChangeInitiativeSelector(selector);
    }


    public Set<ChangeInitiativeToMeasurableRel> findForMeasurableSelector(IdSelectionOptions selectionOptions) {
        Select<Record1<Long>> selector = new MeasurableIdSelectorFactory().apply(selectionOptions);
        return changeInitiativeToMeasurableDao.findForMeasurableSelector(selector);
    }


    public Long createRelationship(CreateRelationshipCommand cmd,
                                   String userId) {
        return changeInitiativeToMeasurableDao.createRelationship(cmd, userId);
    }


    public int removeRelationship(Long relId,
                                  String user) {
        return changeInitiativeToMeasurableDao.removeRelationship(relId, user);
    }


    public int updateDescription(Long relId,
                                 String newDesc,
                                 String userId) {
        return changeInitiativeToMeasurableDao.updateDescription(relId, newDesc, userId);
    }
}
