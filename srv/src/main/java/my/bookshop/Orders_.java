package my.bookshop;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.Predicate;
import com.sap.cds.ql.StructuredType;
import java.lang.Integer;
import java.lang.String;
import java.time.Instant;
import java.util.function.Function;
import sap.common.Countries_;

@CdsName("my.bookshop.Orders")
public interface Orders_ extends StructuredType<Orders_> {
  String CDS_NAME = "my.bookshop.Orders";

  ElementRef<Instant> createdAt();

  ElementRef<String> country_code();

  Countries_ country();

  Countries_ country(Function<Countries_, Predicate> filter);

  ElementRef<Integer> amount();

  ElementRef<String> createdBy();

  ElementRef<Instant> modifiedAt();

  Books_ book();

  Books_ book(Function<Books_, Predicate> filter);

  ElementRef<String> modifiedBy();

  ElementRef<String> ID();

  ElementRef<Integer> book_ID();
}
