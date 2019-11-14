# FioriCAPApplication1
Demo Fiori Application with CAP 
* Use WEbIDE Template : SAP Cloud Platform Business Application
* 

Create Manually service instance UAA instance - FioriCAPApplication1-uaa  with application plan and following security setting

{
	"xsappname": "FioriCAPApplication1",
	"tenant-mode": "dedicated",
	"description": "Security Configuration for CAP application",
	"scopes": [
		{
			"name": "$XSAPPNAME.demouser",
			"description": "Demo Scope"
		},
		{
			"name": "uaa.user",
			"description": "UAA"
		}
	],
	"role-templates": [
		{
			"name": "demouser",
			"description": "Demo Role",
			"scope-references": [
				"$XSAPPNAME.demouser"
			]
		},
		{
			"name": "Token_Exchange",
			"description": "Token_Exchange",
			"scope-references": [
				"uaa.user"
			]
		}
	]
}

and update mta.yaml -> resource "FioriCAPApplication1-uaa"

From: 
  - name: FioriCAPApplication1-uaa
    type: org.cloudfoundry.managed-service
    parameters:
      service-plan: application
      service: xsuaa
      config:
        xsappname: FioriCAPApplication1-${space}
        tenant-mode: dedicated

to:
  - name: FioriCAPApplication1-uaa
    type: org.cloudfoundry.existing-service
    parameters:
      service-name: FioriCAPApplication1-uaa

-> Build CDS from Project level and Build DB module

UI Module

-> Add HTML Module with List Report Template and bind with existing CDS OData V2 Service in project
-> Tempalte added additional XSUAA Resource which need to replace with already created one.
-> Add CDS for Fiori Element inside your srv module app with file cat-service-fiori.cds
-> add same sample data in DB for test purpose using db/src/csv/Books.csv file

Fiori
 -> Add Navigation Semantic object inside html module "booklist"
 -> Add Fiori Module from templates with name FioriCAPApplication1-fiori
 -> Open CommonDataModel.json file add your UI application using WebIDE wizard
 -> Update MTA file reference  uaa_FioriCAPApplication1 with our existing xsuaa instance : FioriCAPApplication1-uaa
 -> Update MTA file reference portal_resources_FioriCAPApplication1 with name FioriCAPApplication1-portal
 -> Build your application and deply to cf space
 
 






