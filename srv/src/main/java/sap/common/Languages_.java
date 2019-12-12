package sap.common;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.Predicate;
import com.sap.cds.ql.StructuredType;
import java.lang.String;
import java.util.function.Function;

@CdsName("sap.common.Languages")
public interface Languages_ extends StructuredType<Languages_> {
  String CDS_NAME = "sap.common.Languages";

  ElementRef<String> descr();

  ElementRef<String> code();

  LanguagesTexts_ texts();

  LanguagesTexts_ texts(Function<LanguagesTexts_, Predicate> filter);

  ElementRef<String> name();

  LanguagesTexts_ localized();

  LanguagesTexts_ localized(Function<LanguagesTexts_, Predicate> filter);
}
