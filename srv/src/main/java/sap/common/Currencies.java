package sap.common;

import com.sap.cds.CdsData;
import com.sap.cds.ql.CdsName;
import java.lang.String;
import java.util.List;
import java.util.Map;

@CdsName("sap.common.Currencies")
public interface Currencies extends CdsData {
  String DESCR = "descr";

  String SYMBOL = "symbol";

  String CODE = "code";

  String TEXTS = "texts";

  String NAME = "name";

  String LOCALIZED = "localized";

  String getDescr();

  void setDescr(String descr);

  String getSymbol();

  void setSymbol(String symbol);

  String getCode();

  void setCode(String code);

  List<CurrenciesTexts> getTexts();

  String getName();

  void setName(String name);

  CurrenciesTexts getLocalized();

  void setLocalized(Map<String, ?> localized);
}
