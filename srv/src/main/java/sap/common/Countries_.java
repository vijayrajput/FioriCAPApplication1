package sap.common;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.Predicate;
import com.sap.cds.ql.StructuredType;
import java.lang.String;
import java.util.function.Function;

@CdsName("sap.common.Countries")
public interface Countries_ extends StructuredType<Countries_> {
  String CDS_NAME = "sap.common.Countries";

  ElementRef<String> descr();

  ElementRef<String> code();

  CountriesTexts_ texts();

  CountriesTexts_ texts(Function<CountriesTexts_, Predicate> filter);

  ElementRef<String> name();

  CountriesTexts_ localized();

  CountriesTexts_ localized(Function<CountriesTexts_, Predicate> filter);
}
