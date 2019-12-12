package catalogservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import java.lang.Integer;
import java.lang.String;

@CdsName("CatalogService.Books_texts")
public interface BooksTexts_ extends StructuredType<BooksTexts_> {
  String CDS_NAME = "CatalogService.Books_texts";

  ElementRef<Integer> ID();

  ElementRef<String> locale();

  ElementRef<String> title();
}
