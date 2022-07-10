@OPC-1042
Feature: Default

	Background:
		#@OPC-1033
		    Given user is on the activity stream menu
		    And user clicks the message box
		

	#US01A_As a user, I should be able to send messages by clicking on Message tab under Active Stream.
	#
	#1. User should be able to send a message by filling in the mandatory fields.
	@OPC-1032
	Scenario: User should be able to send a message by filling in the mandatory fields.
		When user writes "Do not give up" to the message tab
		    And user able to press send key
		    Then user should be able to send the message "Do not give up"	

	#US01A_As a user, I should be able to send messages by clicking on Message tab under Active Stream.
	#
	#2.The message delivery should be to 'All employees' by default and should be changeable.
	@OPC-1038
	Scenario: The message delivery should be to 'All employees' by default
		Then user should verify that default recipient is "All employees"	

	#US01A_As a user, I should be able to send messages by clicking on Message tab under Active Stream.
	#
	#1. User should be able to send a message by filling in the mandatory fields.
	@OPC-1036
	Scenario: User should get an error message when the recipient is empty
		When user writes "Do not give up" to the message tab
		And user deletes the default recipient and click the send button
		Then error message "Please specify at least one person." is displayed	

	#US01A_As a user, I should be able to send messages by clicking on Message tab under Active Stream.
	#
	#2.The message delivery should be to 'All employees' by default and should be changeable.
	@OPC-1039
	Scenario: Recipients should be selectable from "Recent", "My Groups","Employees and departments"
		When user clicks to add more
		Then user should be able to add recipients from Recent, My Groups and Employees and departments tabs	

	#US01A_As a user, I should be able to send messages by clicking on Message tab under Active Stream.
	#
	#1. User should be able to send a message by filling in the mandatory fields.
	@OPC-1034
	Scenario: User should get an error message when the message text is empty
		When user leaves the message text empty and clicks the send button
		Then error message "The message text is empty" is displayed	

	#US01A_As a user, I should be able to send messages by clicking on Message tab under Active Stream.
	#
	#3. User should be able to cancel sending messages at any time before sending.
	@OPC-1041
	Scenario: User should be able to cancel sending messages at any time before sending
		When user writes "Last scenario" to the message tab
		And user clicks cancel button
		Then the message should be deleted and main screen should be monitored	

	#US01A_As a user, I should be able to send messages by clicking on Message tab under Active Stream.
	#
	#2.The message delivery should be to 'All employees' by default and should be changeable.
	@OPC-1040
	Scenario: Recipients can be added more than one and are deletable
		When user clicks to add more
		And user should be able to add recipients from Recent, My Groups and Employees and departments tabs
		Then user can delete a recipient