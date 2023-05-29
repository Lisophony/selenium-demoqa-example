# demoqa.com test examples
This project provides examples of UI testing in Selenium.

## Test cases
### 1 Test Alerts
This example represents handling different types of alerts. Such as simple alert, prompt alert and confirm box.

| Test steps                                                                                        | Expected result                                                   |
|---------------------------------------------------------------------------------------------------|-------------------------------------------------------------------|
| 1. Navigate to main page                                                                          | Main page is open                                                 |
| 2. Navigate to Alerts page by clicking on card "Alerts, Frame & Windows" and selecting "Alerts"   | Alerts page is open                                               |
| 3. Click button labeled "Click Button to see alert" to open alert                                 | Alert with message "You clicked a button" is presented            |
| 4. Accept alert                                                                                   | Alert closed                                                      |
| 5. Click button labeled "On button click, confirm box will appear" to open alert with confirm box | Alert with message "Do you confirm action?" is presented          |
| 6. Confirm alert                                                                                  | Alert closed. A message "You selected Ok" appeared on Alerts page |
| 7. Click button labeled "On button click, prompt box will appear" to open prompt alert            | Alert with message "Please enter your name" is presented          |
| 8. Enter random text and accept alert                                                             | Alert closed. Entered data is presented on Alerts page            |

### 2 Test web tables
This example shows how to handle multiple data sets with DDT. In this case, a web table is used to fill in the data. Test runs as many times as there are elements in data set.

| Test steps                                                                              | Expected result           |
|-----------------------------------------------------------------------------------------|---------------------------|
| 1. Navigate to main page                                                                | Main page is open         |
| 2. Navigate to WebTables page by clicking on card "Elements" and selecting "Web Tables" | WebTable page is open     |
| 3. Open registration form by clicking "Add"                                             | Registration form is open |
|4. Fill in the registration form with test data and submit | Registration form is closed. Entered data appeared in the table|
|5. Delete row with entered data in previous step | Table row has been removed|

Test data to fill in registration form :

| №   |Firstname|Lastname|Email|Age|Salary|Department|
|-----|---|---|---|---|---|---|
| 1   |Anna|Smith|annsmith@gmail.com|29|66666|hell|
|2|Sasha|Ivanova|sashaiva@gmail.com|33|100000|Nails|