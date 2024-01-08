package org.finos.waltz.jobs.tools.taxonomy.parsers;

import com.microsoft.playwright.Page;
import org.apache.poi.ss.usermodel.Workbook;
import org.finos.waltz.common.MapUtilities;
import org.finos.waltz.common.StringUtilities;
import org.finos.waltz.jobs.Columns;
import org.finos.waltz.jobs.SheetNumProvider;
import org.finos.waltz.jobs.XlsUtilities;
import org.finos.waltz.jobs.tools.taxonomy.TaxonomyItem;
import org.finos.waltz.jobs.tools.taxonomy.TaxonomyParser;
import org.immutables.value.Value;
import org.jooq.lambda.tuple.Tuple2;
import org.jooq.lambda.tuple.Tuple4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;
import static org.finos.waltz.common.StringUtilities.firstNonNull;
import static org.finos.waltz.common.StringUtilities.isDefined;
import static org.finos.waltz.jobs.XlsUtilities.strVal;
import static org.jooq.lambda.tuple.Tuple.tuple;

public class SparseTabularTreeParser implements TaxonomyParser {

    @Value.Immutable
    public interface Options extends SheetNumProvider {

        int levels();

        int descriptionColumnIndex();

        @Value.Default
        default int skipRows() {
            return 1;
        }
    }


    private final Options options;


    public SparseTabularTreeParser(Options options) {
        this.options = options;
    }


    public Set<TaxonomyItem> parse(Workbook workbook) {
        String[] lastRow = new String[3];
        List<Tuple2<String[], Optional<String>>> rows = XlsUtilities
                .streamRows(workbook, options)
                .skip(options.skipRows())
                .map(r -> {
                    String a = strVal(r, Columns.A);
                    String b = strVal(r, Columns.B);
                    String c = strVal(r, Columns.C);
                    String desc = strVal(r, options.descriptionColumnIndex());

                    String[] row = new String[3];
                    if (isDefined(a)) {
                        row[0] = a;
                        row[1] = null;
                        row[2] = null;
                    }
                    if (isDefined(b)) {
                        row[0] = lastRow[0];
                        row[1] = b;
                        row[2] = null;
                    }
                    if (isDefined(c)) {
                        row[0] = lastRow[0];
                        row[1] = lastRow[1];
                        row[2] = c;
                    }

                    replaceRowWith(lastRow, row);

                    return tuple(row, ofNullable(desc));
                })
                .filter(t -> isDefined(t.v1[0])
                        || isDefined(t.v1[1])
                        || isDefined(t.v1[2]))
                .collect(Collectors.toList());

        rows.forEach(t -> System.out.printf("%s : %s\n", Arrays.toString(t.v1), t.v2));

        AtomicLong ctr = new AtomicLong();

        Map<String, Long> idsByName = MapUtilities.indexBy(
                rows,
                t -> firstNonNull(t.v1[2], t.v1[1], t.v1[0]).get(),
                t -> ctr.incrementAndGet());

        System.out.println(idsByName);

        Set<Tuple4<String, Optional<String>, Long, ?>> itemsWithIds = rows.stream()
                .map(t -> {
                    String l1 = t.v1[0];
                    String l2 = t.v1[1];
                    String l3 = t.v1[2];
                    if (l1 == null) {
                        return null;
                    } else if (l2 == null) {
                        return tuple(l1, t.v2, idsByName.get(l1), null);
                    } else if (l3 == null) {
                        return tuple(l2, t.v2, idsByName.get(l2), idsByName.get(l1));
                    } else {
                        return tuple(l3, t.v2, idsByName.get(l3), idsByName.get(l2));
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        System.out.println(itemsWithIds);
        return null;
    }


    private static void replaceRowWith(String[] target, String[] row) {
        target[0] = row[0];
        target[1] = row[1];
        target[2] = row[2];
    }
}
