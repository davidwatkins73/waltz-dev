package org.finos.waltz.jobs.tools.taxonomy;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.finos.waltz.jobs.Columns;
import org.finos.waltz.jobs.tools.taxonomy.parsers.ImmutableOptions;
import org.finos.waltz.jobs.tools.taxonomy.parsers.SparseTabularTreeParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import static org.finos.waltz.common.Checks.checkNotNull;

public class TaxonomyLoader {

    private final String filename = "taxonomies/sparse-tree-taxonomy-demo.xlsx";

    public static void main(String[] args) throws IOException {
        new TaxonomyLoader().go();
    }

    private void go() throws IOException {
        InputStream inputStream = checkNotNull(
                this.getClass().getClassLoader().getResourceAsStream(filename),
                "Cannot find file [%s] on classpath",
                filename);

        Workbook workbook = new XSSFWorkbook(inputStream);

        SparseTabularTreeParser.Options opts = ImmutableOptions
                .builder()
                .sheetNum(0)
                .skipRows(1)
                .levels(3)
                .descriptionColumnIndex(Columns.D)
                .build();

        Set<TaxonomyItem> items = new SparseTabularTreeParser(opts)
                .parse(workbook);

    }
}
