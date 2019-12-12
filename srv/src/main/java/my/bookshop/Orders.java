package my.bookshop;

import com.sap.cds.CdsData;
import com.sap.cds.ql.CdsName;
import java.lang.Integer;
import java.lang.String;
import java.time.Instant;
import java.util.Map;
import sap.common.Countries;

@CdsName("my.bookshop.Orders")
public interface Orders extends CdsData {
  String CREATED_AT = "createdAt";

  String COUNTRY_CODE = "country_code";

  String COUNTRY = "country";

  String AMOUNT = "amount";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String BOOK = "book";

  String MODIFIED_BY = "modifiedBy";

  String ID = "ID";

  String BOOK_ID = "book_ID";

  Instant getCreatedAt();

  void setCreatedAt(Instant createdAt);

  @CdsName(COUNTRY_CODE)
  String getCountryCode();

  @CdsName(COUNTRY_CODE)
  void setCountryCode(String countryCode);

  Countries getCountry();

  void setCountry(Map<String, ?> country);

  Integer getAmount();

  void setAmount(Integer amount);

  String getCreatedBy();

  void setCreatedBy(String createdBy);

  Instant getModifiedAt();

  void setModifiedAt(Instant modifiedAt);

  Books getBook();

  void setBook(Map<String, ?> book);

  String getModifiedBy();

  void setModifiedBy(String modifiedBy);

  @CdsName(ID)
  String getId();

  @CdsName(ID)
  void setId(String id);

  @CdsName(BOOK_ID)
  Integer getBookId();

  @CdsName(BOOK_ID)
  void setBookId(Integer bookId);
}
