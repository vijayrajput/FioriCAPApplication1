package catalogservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.Predicate;
import com.sap.cds.ql.StructuredType;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Function;

@CdsName("CatalogService.Authors")
public interface Authors_ extends StructuredType<Authors_> {
  String CDS_NAME = "CatalogService.Authors";

  Books_ books();

  Books_ books(Function<Books_, Predicate> filter);

  ElementRef<String> name();

  ElementRef<Integer> ID();
}
