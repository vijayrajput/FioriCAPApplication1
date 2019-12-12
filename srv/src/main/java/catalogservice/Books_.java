package catalogservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.Predicate;
import com.sap.cds.ql.StructuredType;
import java.lang.Integer;
import java.lang.String;
import java.time.Instant;
import java.util.function.Function;

@CdsName("CatalogService.Books")
public interface Books_ extends StructuredType<Books_> {
  String CDS_NAME = "CatalogService.Books";

  ElementRef<Instant> createdAt();

  BooksTexts_ texts();

  BooksTexts_ texts(Function<BooksTexts_, Predicate> filter);

  ElementRef<String> createdBy();

  ElementRef<Instant> modifiedAt();

  Authors_ author();

  Authors_ author(Function<Authors_, Predicate> filter);

  BooksTexts_ localized();

  BooksTexts_ localized(Function<BooksTexts_, Predicate> filter);

  ElementRef<String> modifiedBy();

  ElementRef<Integer> ID();

  ElementRef<String> title();

  ElementRef<Integer> stock();

  ElementRef<Integer> author_ID();
}
