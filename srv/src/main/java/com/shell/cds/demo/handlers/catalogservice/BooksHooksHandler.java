package  com.shell.cds.demo.handlers.catalogservice; 

import com.sap.cloud.sdk.service.prov.api.*;
import com.sap.cloud.sdk.service.prov.api.annotations.*;
import com.sap.cloud.sdk.service.prov.api.exits.*;
import com.sap.cloud.sdk.service.prov.api.request.*;
import com.sap.cloud.sdk.service.prov.api.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import com.sap.cloud.sdk.hana.connectivity.handler.*;
import com.sap.cloud.sdk.hana.connectivity.cds.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
//
import java.util.*;

/***
 * Handler class for persisted entity "Books" of service "CatalogService".
 * This handler registers custom handlers for before / after operation hooks.
 * For more information, see: https://help.sap.com/viewer/65de2977205c403bbc107264b8eccf4b/Cloud/en-US/94c7b69cc4584a1a9dfd9cb2da295d5e.html
 */
public class BooksHooksHandler {
private final Logger log = LoggerFactory.getLogger(this.getClass());

//	@BeforeRead(entity = "Books", serviceName = "CatalogService")
//	public BeforeReadResponse beforeReadBooks(ReadRequest req, ExtensionHelper helper) {
		//TODO: add your custom logic / validations here...
		
		
	//	return BeforeReadResponse.setSuccess().response(); //use this API if validation checks are successful.
		//return BeforeReadResponse.setError(ErrorResponse.getBuilder().setMessage("You are not authorized to read this item").response()); //use this API if your validation checks fail
//	}
	
	@Function(serviceName = "CatalogService", Name = "GetBookDetails")
	public OperationResponse getBooks(OperationRequest functionRequest, ExtensionHelper extensionHelper) {
		OperationResponse opResponse;

		try {
			// Retrieve the parameters of the function from the
			// OperationRequest object
			Map<String, Object> parameters = functionRequest.getParameters();

			//Get the DataSourceHandler object from the ExtensionHelper. This is required
			//to execute operations on the local HANA database
			DataSourceHandler handler = extensionHelper.getHandler();

			//Retrieve the Order ID from the request
			Map<String, Object> booksKey = new HashMap<String, Object>();
			booksKey.put("ID", String.valueOf(parameters.get("id")));

			List<String> bookElements = Arrays.asList("ID","title","stock");

			//Read the Order information from the local HANA database
			EntityData bookData = handler.executeRead("Books", booksKey, bookElements);
			List<EntityData> bookList = new ArrayList<EntityData>();
			bookList.add(bookData);
			// Return an instance of OperationResponse containing the list of book data
			opResponse = OperationResponse.setSuccess().setEntityData(bookList).response();

		} catch (Exception e) {
			log.error("Error in GetBook: " + e.getMessage());
			// Return an instance of OperationResponse containing the error in
			// case of failure
			ErrorResponse errorResponse = ErrorResponse.getBuilder()
					.setMessage(e.getMessage())
					.setCause(e)
					.response();

			opResponse = OperationResponse.setError(errorResponse);
		}
		return opResponse;
	}

	@AfterRead(entity = "Books", serviceName = "CatalogService")
	public ReadResponse afterReadBooks(ReadRequest req, ReadResponseAccessor res, ExtensionHelper helper) {
		EntityData data = res.getEntityData();
		//TODO: add your custom logic / validations here...
		
		try{
		DataSourceHandler handler = helper.getHandler();
		CDSDataSourceHandler dsHandler = DataSourceHandlerFactory.getInstance().getCDSHandler(getConnection(), req.getEntityMetadata().getNamespace());
		
		CDSQuery cdsQuery = new CDSSelectQueryBuilder("CatalogService.Books")
            .top(2)
            .skip(1)
            .selectColumns("ID","title","stock")
            .build();
		CDSSelectQueryResult cdsSelectQueryResult = dsHandler.executeQuery(cdsQuery);
		data = cdsSelectQueryResult.getResult().get(0);
		}
		catch (Exception e) {
			
			log.error("Error in GetBook: " + e.getMessage());
			// Return an instance of OperationResponse containing the error in
			// case of failure
			ErrorResponse errorResponse = ErrorResponse.getBuilder()
					.setMessage(e.getMessage())
					.setCause(e)
					.response();

			return ReadResponse.setError(errorResponse);
		}
		

	//	return res.getOriginalResponse(); //use this API if no change is required and the original response can be returned as output.
	return ReadResponse.setSuccess().setData(data).response(); //use this API if the payload is modified.
		//return ReadResponse.setError(ErrorResponse.getBuilder().setMessage("Read Operation Failed").response()); //use this API if should return error response.
	}

//	@BeforeQuery(entity = "Books", serviceName = "CatalogService")
//	public BeforeQueryResponse beforeQueryBooks(QueryRequest req, ExtensionHelper helper) {
//		//TODO: add your custom logic / validations here...
//
//		return BeforeQueryResponse.setSuccess().response(); //use this API if validation checks are successful.
//		//return BeforeQueryResponse.setError(ErrorResponse.getBuilder().setMessage("You are not authorized to query this entity").response()); //use this API if any validation checks fail.
//	}

//	@AfterQuery(entity = "Books", serviceName = "CatalogService")
//	public QueryResponse afterQueryBooks(QueryRequest req, QueryResponseAccessor res, ExtensionHelper helper) {
//		List<EntityData> dataList = res.getEntityDataList(); //original list
//		//TODO: add your custom logic / validations here...
//
//		return res.getOriginalResponse(); //use this API if no change is required and the original response can be returned as output.
//		//return QueryResponse.setSuccess().setData(dataList).response(); //use this API if the payload is modified.
//		//return QueryResponse.setError(ErrorResponse.getBuilder().setMessage("Query Operation Failed").response()); //use this API if should return error response.
//	}

	@BeforeCreate(entity = "Books", serviceName = "CatalogService")
	public BeforeCreateResponse beforeCreateBooks(CreateRequest req, ExtensionHelper helper) {
		EntityData data = req.getData();
		//TODO: add your custom logic / validations here...
	//	DataSourceHandler handler = helper.getHandler();
	//	log.info("Entity:" + entityMetadata.getName().toString() + " :Keys:" + );
	//	EntityData data = handler.executeRead(entityMetadata.getName(),readRequest.getKeys(), entityMetadata.getFlattenedElementNames());
		return BeforeCreateResponse.setSuccess().response(); //use this API if the payload has not been modified.
		//return BeforeCreateResponse.setSuccess().setEntityData(data).response(); //use this API if the payload is modified.
	//	return BeforeCreateResponse.setError(ErrorResponse.getBuilder().setMessage("You are not authorized to add items.").response()); //use this API if any validation checks fail.
	}

//	@AfterCreate(entity = "Books", serviceName = "CatalogService")
//	public CreateResponse afterCreateBooks(CreateRequest req, CreateResponseAccessor res, ExtensionHelper helper) {
//		//TODO: add your custom logic / validations here...
//
//		return res.getOriginalResponse(); //use this API if operation succeeded and payload has not been modified.
//		//return CreateResponse.setError(ErrorResponse.getBuilder().setMessage("Create Operation Failed").response()); //use this API if should return error response.
//	}

//	@BeforeUpdate(entity = "Books", serviceName = "CatalogService")
//	public BeforeUpdateResponse beforeUpdateBooks(UpdateRequest req, ExtensionHelper helper) {
//		EntityData data = req.getData();
//		//TODO: add your custom logic / validations here...
//
//		return BeforeUpdateResponse.setSuccess().response(); //use this API if the payload has not been modified.
//		//return BeforeUpdateResponse.setSuccess().setEntityData(data).response(); //use this API if the payload is modified.
//		//return BeforeUpdateResponse.setError(ErrorResponse.getBuilder().setMessage("You are not authorized to update this item.").response()); //use this API if any validation checks fail.
//	}

//	@AfterUpdate(entity = "Books", serviceName = "CatalogService")
//	public UpdateResponse afterUpdateBooks(UpdateRequest req, UpdateResponseAccessor res, ExtensionHelper helper) {
//		//TODO: add your custom logic / validations here...
//
//		return res.getOriginalResponse(); //use this API if operation succeeded and payload has not been modified.
//		//return UpdateResponse.setError(ErrorResponse.getBuilder().setMessage("Update Operation Failed").response()); //use this API if should return error response.
//	}

//	@BeforeDelete(entity = "Books", serviceName = "CatalogService")
//	public BeforeDeleteResponse beforeDeleteBooks(DeleteRequest req, ExtensionHelper helper) {
//		//TODO: add your custom logic / validations here...
//
//		return BeforeDeleteResponse.setSuccess().response(); //use this API if validation checks are successful.
//		//return BeforeDeleteResponse.setError(ErrorResponse.getBuilder().setMessage("You are not authorized to delete this item.").response()); //use this API if your validation checks fail
//	}

//	@AfterDelete(entity = "Books", serviceName = "CatalogService")
//	public DeleteResponse afterDeleteBooks(DeleteRequest req, DeleteResponseAccessor res, ExtensionHelper helper) {
//		//TODO: add your custom logic / validations here...
//
//		return res.getOriginalResponse(); //use this API if operation succeeded and payload has not been modified.
//		//return DeleteResponse.setError(ErrorResponse.getBuilder().setMessage("Delete Operation Failed").response()); //use this API if should return error response.
//	}
 private static Connection getConnection() {
  Connection conn = null;
  InitialContext ctx;
  try {
    ctx = new InitialContext();
    conn = ((DataSource) ctx.lookup("java:comp/env/jdbc/java-hdi-container")).getConnection();
  } catch (Exception e) {
    e.printStackTrace();
  }
  return conn;
}
}