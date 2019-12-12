package sap.common;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import java.lang.String;

@CdsName("sap.common.Currencies_texts")
public interface CurrenciesTexts_ extends StructuredType<CurrenciesTexts_> {
  String CDS_NAME = "sap.common.Currencies_texts";

  ElementRef<String> descr();

  ElementRef<String> code();

  ElementRef<String> name();

  ElementRef<String> locale();
}
