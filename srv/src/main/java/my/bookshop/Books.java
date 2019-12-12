package my.bookshop;

import com.sap.cds.CdsData;
import com.sap.cds.ql.CdsName;
import java.lang.Integer;
import java.lang.String;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@CdsName("my.bookshop.Books")
public interface Books extends CdsData {
  String CREATED_AT = "createdAt";

  String TEXTS = "texts";

  String CREATED_BY = "createdBy";

  String MODIFIED_AT = "modifiedAt";

  String AUTHOR = "author";

  String LOCALIZED = "localized";

  String MODIFIED_BY = "modifiedBy";

  String ID = "ID";

  String TITLE = "title";

  String STOCK = "stock";

  String AUTHOR_ID = "author_ID";

  Instant getCreatedAt();

  void setCreatedAt(Instant createdAt);

  List<BooksTexts> getTexts();

  String getCreatedBy();

  void setCreatedBy(String createdBy);

  Instant getModifiedAt();

  void setModifiedAt(Instant modifiedAt);

  Authors getAuthor();

  void setAuthor(Map<String, ?> author);

  BooksTexts getLocalized();

  void setLocalized(Map<String, ?> localized);

  String getModifiedBy();

  void setModifiedBy(String modifiedBy);

  @CdsName(ID)
  Integer getId();

  @CdsName(ID)
  void setId(Integer id);

  String getTitle();

  void setTitle(String title);

  Integer getStock();

  void setStock(Integer stock);

  @CdsName(AUTHOR_ID)
  Integer getAuthorId();

  @CdsName(AUTHOR_ID)
  void setAuthorId(Integer authorId);
}
