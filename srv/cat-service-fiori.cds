using CatalogService from '../srv/cat-service';

annotate CatalogService.Books with {
  ID 
    @Common.Label : 'Id';
  title 
    @Common.Label : 'Title';
  stock 
    @Common.Label : 'Stock';
  author
    @Common.Text: "author/name"
    @Common.Label : 'Author'
    @sap.value.list: 'fixed-values'
    @Common.ValueList: { 
      CollectionPath: 'Authors',
      Label: 'Authors',
      SearchSupported: 'true',
      Parameters: [
        { $Type: 'Common.ValueListParameterOut', LocalDataProperty: 'author_ID', ValueListProperty: 'ID'},
        { $Type: 'Common.ValueListParameterDisplayOnly', ValueListProperty: 'name'},
      ]
    };
    
};

annotate CatalogService.Books with @(
  UI.LineItem: [ 
    {$Type: 'UI.DataField', Value: ID},
    {$Type: 'UI.DataField', Value: title},
    {$Type: 'UI.DataField', Value: stock},
  ],
  
  UI.HeaderInfo: {
    Title: { Value: title },
    TypeName:'Book', 
        TypeNamePlural:'Books'
  },
  
  UI.Identification:
  [
    {$Type: 'UI.DataField', Value: ID},
    {$Type: 'UI.DataField', Value: title},
    {$Type: 'UI.DataField', Value: stock}
  ],
  
  UI.Facets:
  [
    {
      $Type:'UI.CollectionFacet', 
      Facets: [
            { $Type:'UI.ReferenceFacet', Label: 'General Info', Target: '@UI.Identification' }
          ],
      Label:'Book Details',		
    },
    {$Type:'UI.ReferenceFacet', Label: 'Orders', Target: 'orders/@UI.LineItem'},
  ]	
);
