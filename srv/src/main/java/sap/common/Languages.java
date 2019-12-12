package sap.common;

import com.sap.cds.CdsData;
import com.sap.cds.ql.CdsName;
import java.lang.String;
import java.util.List;
import java.util.Map;

@CdsName("sap.common.Languages")
public interface Languages extends CdsData {
  String DESCR = "descr";

  String CODE = "code";

  String TEXTS = "texts";

  String NAME = "name";

  String LOCALIZED = "localized";

  String getDescr();

  void setDescr(String descr);

  String getCode();

  void setCode(String code);

  List<LanguagesTexts> getTexts();

  String getName();

  void setName(String name);

  LanguagesTexts getLocalized();

  void setLocalized(Map<String, ?> localized);
}
