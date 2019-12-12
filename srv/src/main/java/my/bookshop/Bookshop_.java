package my.bookshop;

import com.sap.cds.ql.CdsName;
import java.lang.Class;
import java.lang.String;

@CdsName("my.bookshop")
public interface Bookshop_ {
  String CDS_NAME = "my.bookshop";

  Class<Orders_> ORDERS = Orders_.class;

  Class<Authors_> AUTHORS = Authors_.class;

  Class<BooksTexts_> BOOKS_TEXTS = BooksTexts_.class;

  Class<Books_> BOOKS = Books_.class;
}
