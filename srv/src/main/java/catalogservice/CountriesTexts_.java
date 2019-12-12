package catalogservice;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import java.lang.String;

@CdsName("CatalogService.Countries_texts")
public interface CountriesTexts_ extends StructuredType<CountriesTexts_> {
  String CDS_NAME = "CatalogService.Countries_texts";

  ElementRef<String> descr();

  ElementRef<String> code();

  ElementRef<String> name();

  ElementRef<String> locale();
}
