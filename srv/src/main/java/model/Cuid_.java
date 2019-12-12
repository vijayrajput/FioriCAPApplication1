package model;

import com.sap.cds.ql.CdsName;
import com.sap.cds.ql.ElementRef;
import com.sap.cds.ql.StructuredType;
import java.lang.String;

@CdsName("cuid")
public interface Cuid_ extends StructuredType<Cuid_> {
  String CDS_NAME = "cuid";

  ElementRef<String> ID();
}
