Feature: 3E Termi Chat
@LoginAndChat
  Scenario: Termi_3E launch and Authentication
    Given Launch Termi in Google Chrome
     When Enter Username and Password from excel at "./Excel_Data_3E/Login_Credentials.xlsx"
      And Click on Login Button
     When Click on Chat icon
     Then Verify that we are on chat page with page title "Termi - Helm 360"
     Then User enters Question and gets Answer from excel at "./Excel_Data_3E/Question_Answer.xlsx"
      #Then User runs payee reportfrom report section with payee as "Anchor Holdings" and report page title as "Reporting - Payee Report"
     Then close the browser
  #@ChatBot 
   #Scenario Outline: Termi Chat Bot Simple Questions
#	   Then User enters "<Question>" and gets "<Answer>" 
#	      Examples: 
      #| Question                                    | Answer                                                                                     | 
      #| Help                                        | To get help on what questions you can ask me, please select from the following categories: | 
      #| My Schedule                                 | You have no appointments scheduled today!                                                  | 
      #| Outstanding AP                              | Please enter Payee Company:                                                                | 
      #| Office Center                               | The Accounts Payable to Office Center is                                                   | 
      #| send me outstanding AR for Anchor Holdings  | You have not worked for this client                                                        | 
      #| AR for Anchor Holdings                      | You have not worked for this client                                                        | 
      #| Give me outstanding WIP for Anchor Holdings | You have not worked for this client                                                        | 
      #| Give me Write offs for Anchor Holdings      | You have not worked for this client                                                        | 
      #| send me Opened matters for Anchor Holdings  | 9999-001: Demo Matter1                                                                     | 
  	   
   
   #@Close_Browser
   #Scenario: Close the browser
   #Then close the browser 
