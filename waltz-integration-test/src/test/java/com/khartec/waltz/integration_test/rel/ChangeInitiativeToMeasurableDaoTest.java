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

package com.khartec.waltz.integration_test.rel;

import com.khartec.waltz.common.SetUtilities;
import com.khartec.waltz.data.change_initiative.ChangeInitiativeIdSelectorFactory;
import com.khartec.waltz.data.measurable.MeasurableIdSelectorFactory;
import com.khartec.waltz.data.rel.ChangeInitiativeToMeasurableRelDao;
import com.khartec.waltz.integration_test.BaseIntegrationTest;
import com.khartec.waltz.model.EntityKind;
import com.khartec.waltz.model.HierarchyQueryScope;
import com.khartec.waltz.model.IdSelectionOptions;
import com.khartec.waltz.model.UserTimestamp;
import com.khartec.waltz.model.rel.BaseRelationship;
import com.khartec.waltz.model.rel.ChangeInitiativeToMeasurableRel;
import org.jooq.Record1;
import org.jooq.Select;
import org.jooq.exception.DataAccessException;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static com.khartec.waltz.common.CollectionUtilities.first;
import static com.khartec.waltz.model.EntityReference.mkRef;
import static com.khartec.waltz.model.IdSelectionOptions.mkOpts;
import static com.khartec.waltz.schema.Tables.CHANGE_INITIATIVE_TO_MEASURABLE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ChangeInitiativeToMeasurableDaoTest extends BaseIntegrationTest {

    private long measurableId;
    private long ciId;
    private long rk1Id;
    private long rk2Id;
    private long roRkId;


    @Before
    public void setup() {
        getDsl().deleteFrom(CHANGE_INITIATIVE_TO_MEASURABLE).execute();
        measurableId = createMeasurable("testMeasurable", createMeasurableCategory("testCategory"));
        ciId = createChangeInitiative("testCI");
        rk1Id = createRelationshipKind("ci2mRelKind1", EntityKind.CHANGE_INITIATIVE, EntityKind.MEASURABLE);
        rk2Id = createRelationshipKind("ci2mRelKind2", EntityKind.CHANGE_INITIATIVE, EntityKind.MEASURABLE);
        roRkId = createRelationshipKind("readOnlyCi2mRelKind", EntityKind.CHANGE_INITIATIVE, EntityKind.MEASURABLE, true);
    }


    @Test
    public void testCreationOfRelationship() {
        ChangeInitiativeToMeasurableRelDao dao = ctx.getBean(ChangeInitiativeToMeasurableRelDao.class);

        Long relId = dao.createRelationship(
                mkRel(ciId, measurableId, rk1Id),
                "testUser");

        assertTrue("Newly created relationship should have a positive id", relId > 0);

        Set<ChangeInitiativeToMeasurableRel> relsByCi = findByChangeInitiativeId(dao, ciId);
        assertEquals("can retrieve by change initiative selector", 1, relsByCi.size());

        Set<ChangeInitiativeToMeasurableRel> relsByMeasurable = findByMeasurableId(dao, measurableId);
        assertEquals("can retrieve by measurable selector", 1, relsByMeasurable.size());
    }


    @Test(expected = DataAccessException.class)
    public void duplicateRelationshipsAreNotAllowed() {
        ChangeInitiativeToMeasurableRelDao dao = ctx.getBean(ChangeInitiativeToMeasurableRelDao.class);

        dao.createRelationship(
                mkRel(ciId, measurableId, rk1Id),
                "testUser");

        dao.createRelationship(
                mkRel(ciId, measurableId, rk1Id),
                "testUser");
    }


    @Test
    public void multipleRelationshipsBetweenTwoEntitiesAreAllowedIfTheKindDiffers() {
        ChangeInitiativeToMeasurableRelDao dao = ctx.getBean(ChangeInitiativeToMeasurableRelDao.class);

        dao.createRelationship(
                mkRel(ciId, measurableId, rk1Id),
                "testUser");

        dao.createRelationship(
                mkRel(ciId, measurableId, rk2Id),
                "testUser");

        Set<ChangeInitiativeToMeasurableRel> rels = findByChangeInitiativeId(dao, ciId);

        assertEquals(2, rels.size());
        assertEquals(
                SetUtilities.asSet(rk1Id, rk2Id),
                SetUtilities.map(rels, BaseRelationship::relationshipId));
    }


    @Test
    public void commentsCanBeUpdated() {
        ChangeInitiativeToMeasurableRelDao dao = ctx.getBean(ChangeInitiativeToMeasurableRelDao.class);

        Long relId = dao.createRelationship(
                mkRel(ciId, measurableId, rk1Id),
                "testUser");

        ChangeInitiativeToMeasurableRel rel = first(findByChangeInitiativeId(dao, ciId));

        dao.updateDescription(relId, "new comment", "newTestUser");

        ChangeInitiativeToMeasurableRel updatedRel = first(findByChangeInitiativeId(dao, ciId));

        assertEquals(rel.id(), updatedRel.id());
        assertEquals(rel.changeInitiativeId(), updatedRel.changeInitiativeId());
        assertEquals(rel.measurableId(), updatedRel.measurableId());
        assertEquals("new comment", updatedRel.description());
        assertEquals("newTestUser", updatedRel.lastUpdated().map(UserTimestamp::by).orElse(null));

    }


    @Test
    public void relationshipsCanBeRemovedById() {
        ChangeInitiativeToMeasurableRelDao dao = ctx.getBean(ChangeInitiativeToMeasurableRelDao.class);

        Long relId = dao.createRelationship(
                mkRel(ciId, measurableId, rk1Id),
                "testUser");

        assertEquals(1, findByChangeInitiativeId(dao, ciId).size());

        dao.removeRelationship(relId, "admin");

        assertTrue(findByChangeInitiativeId(dao, ciId).isEmpty());

    }


    @Test
    public void cannotRemoveReadOnlyRelationship() {
        ChangeInitiativeToMeasurableRelDao dao = ctx.getBean(ChangeInitiativeToMeasurableRelDao.class);

        Long relId = dao.createRelationship(
                mkRel(ciId, measurableId, roRkId),
                "testUser");

        assertEquals(1, findByChangeInitiativeId(dao, ciId).size());

        int rc = dao.removeRelationship(relId, "admin");

        assertEquals("expected return code to be zero when attempting to remove a read-only relationship", 0, rc);
        assertEquals(1, findByChangeInitiativeId(dao, ciId).size());

    }


    // -- HELPERS ---

    private Set<ChangeInitiativeToMeasurableRel> findByChangeInitiativeId(ChangeInitiativeToMeasurableRelDao dao,
                                                                          long id) {
        IdSelectionOptions selectionOptions = mkOpts(
                mkRef(EntityKind.CHANGE_INITIATIVE, id),
                HierarchyQueryScope.EXACT);

        ChangeInitiativeIdSelectorFactory selectorFactory = new ChangeInitiativeIdSelectorFactory();
        Select<Record1<Long>> ciSelector = selectorFactory.apply(selectionOptions);

        return dao.findForChangeInitiativeSelector(ciSelector);
    }


    private Set<ChangeInitiativeToMeasurableRel> findByMeasurableId(ChangeInitiativeToMeasurableRelDao dao,
                                                                    long id) {
        IdSelectionOptions selectionOptions = mkOpts(
                mkRef(EntityKind.MEASURABLE, id),
                HierarchyQueryScope.EXACT);

        MeasurableIdSelectorFactory selectorFactory = new MeasurableIdSelectorFactory();
        Select<Record1<Long>> mSelector = selectorFactory.apply(selectionOptions);

        return dao.findForMeasurableSelector(mSelector);
    }

}
