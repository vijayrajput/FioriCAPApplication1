package sap.common;

import com.sap.cds.CdsData;
import com.sap.cds.ql.CdsName;
import java.lang.String;

@CdsName("sap.common.Languages_texts")
public interface LanguagesTexts extends CdsData {
  String DESCR = "descr";

  String CODE = "code";

  String NAME = "name";

  String LOCALE = "locale";

  String getDescr();

  void setDescr(String descr);

  String getCode();

  void setCode(String code);

  String getName();

  void setName(String name);

  String getLocale();

  void setLocale(String locale);
}
