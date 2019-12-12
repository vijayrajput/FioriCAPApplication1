package model;

import com.sap.cds.CdsData;
import com.sap.cds.ql.CdsName;
import java.lang.String;

@CdsName("cuid")
public interface Cuid extends CdsData {
  String ID = "ID";

  @CdsName(ID)
  String getId();

  @CdsName(ID)
  void setId(String id);
}
