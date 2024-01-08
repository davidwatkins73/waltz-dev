package org.finos.waltz.jobs.tools.taxonomy;


import org.apache.poi.ss.usermodel.Workbook;

import java.util.Set;

public interface TaxonomyParser {


    Set<TaxonomyItem> parse(Workbook workbook);

}
