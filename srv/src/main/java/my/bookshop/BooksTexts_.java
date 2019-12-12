package my.bookshop;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import java.lang.Integer;
import java.lang.String;

@CdsName("my.bookshop.Books_texts")
public interface BooksTexts_ extends StructuredType<BooksTexts_> {
  String CDS_NAME = "my.bookshop.Books_texts";

  ElementRef<Integer> ID();

  ElementRef<String> locale();

  ElementRef<String> title();
}
