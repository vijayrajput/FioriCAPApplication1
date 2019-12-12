package catalogservice;

import com.sap.cds.CdsData;
import com.sap.cds.ql.CdsName;
import java.lang.Integer;
import java.lang.String;

@CdsName("CatalogService.Books_texts")
public interface BooksTexts extends CdsData {
  String ID = "ID";

  String LOCALE = "locale";

  String TITLE = "title";

  @CdsName(ID)
  Integer getId();

  @CdsName(ID)
  void setId(Integer id);

  String getLocale();

  void setLocale(String locale);

  String getTitle();

  void setTitle(String title);
}
