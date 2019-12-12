package sap.common;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import java.lang.String;

@CdsName("sap.common.Languages_texts")
public interface LanguagesTexts_ extends StructuredType<LanguagesTexts_> {
  String CDS_NAME = "sap.common.Languages_texts";

  ElementRef<String> descr();

  ElementRef<String> code();

  ElementRef<String> name();

  ElementRef<String> locale();
}
