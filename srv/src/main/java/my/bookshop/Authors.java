package my.bookshop;

import com.sap.cds.CdsData;
import com.sap.cds.ql.CdsName;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

@CdsName("my.bookshop.Authors")
public interface Authors extends CdsData {
  String BOOKS = "books";

  String NAME = "name";

  String ID = "ID";

  List<Books> getBooks();

  String getName();

  void setName(String name);

  @CdsName(ID)
  Integer getId();

  @CdsName(ID)
  void setId(Integer id);
}
