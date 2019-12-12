package sap.common;

import com.sap.cds.ql.CdsName;
import java.lang.Class;
import java.lang.String;

@CdsName("sap.common")
public interface Common_ {
  String CDS_NAME = "sap.common";

  Class<CurrenciesTexts_> CURRENCIES_TEXTS = CurrenciesTexts_.class;

  Class<Languages_> LANGUAGES = Languages_.class;

  Class<LanguagesTexts_> LANGUAGES_TEXTS = LanguagesTexts_.class;

  Class<Currencies_> CURRENCIES = Currencies_.class;

  Class<CountriesTexts_> COUNTRIES_TEXTS = CountriesTexts_.class;

  Class<Countries_> COUNTRIES = Countries_.class;
}
