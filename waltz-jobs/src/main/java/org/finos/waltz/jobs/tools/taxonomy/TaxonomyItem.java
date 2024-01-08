package org.finos.waltz.jobs.tools.taxonomy;

import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
public interface TaxonomyItem {

    String externalId();
    Optional<String> parentExternalId();

    String name();
    Optional<String> description();
    boolean concrete();


}
