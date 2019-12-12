package catalogservice;

import com.sap.cds.ql.CdsName;
import java.lang.Class;
import java.lang.String;

@CdsName("CatalogService")
public interface CatalogService_ {
  String CDS_NAME = "CatalogService";

  Class<Orders_> ORDERS = Orders_.class;

  Class<Authors_> AUTHORS = Authors_.class;

  Class<Books_> BOOKS = Books_.class;

  Class<CountriesTexts_> COUNTRIES_TEXTS = CountriesTexts_.class;

  Class<BooksTexts_> BOOKS_TEXTS = BooksTexts_.class;

  Class<Countries_> COUNTRIES = Countries_.class;
}
