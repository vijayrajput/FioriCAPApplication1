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
			"name": "demo",
			"description": "Demo Role",
			"scope-references": [
				"$XSAPPNAME.demouser","uaa.user"
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


