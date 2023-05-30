# demoqa.com test examples
The project contains examples of UI testing in Selenium. Test cases show examples of testing different types of elements, including alerts, iframes, calendars, etc. Page object pattern is used in the test cases. Testing is carried out using TestNG framework.

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

| Test steps                                                                              | Expected result                                                 |
|-----------------------------------------------------------------------------------------|-----------------------------------------------------------------|
| 1. Navigate to main page                                                                | Main page is open                                               |
| 2. Navigate to WebTables page by clicking on card "Elements" and selecting "Web Tables" | WebTable page is open                                           |
| 3. Open registration form by clicking "Add"                                             | Registration form is open                                       |
| 4. Fill in the registration form with test data and submit                              | Registration form is closed. Entered data appeared in the table |
| 5. Delete row with entered data in previous step                                        | Table row has been removed                                      |

Test data to fill in registration form :

| №   | Firstname | Lastname | Email              | Age | Salary | Department |
|-----|-----------|----------|--------------------|-----|--------|------------|
| 1   | Anna      | Smith    | annsmith@gmail.com | 29  | 66666  | hell       |
| 2   | Sasha     | Ivanova  | sashaiva@gmail.com | 33  | 100000 | Nails      |

### 3 Test iframes
This test case shows how to switch between iframes.

| Test steps                                                                                                   | Expected result                                                                          |
|--------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------|
| 1. Navigate to main page                                                                                     | Main page is open                                                                        |
| 2. Navigate to NestedFrames page by clicking on card "Alerts, Frame & Windows" and selecting "Nested Frames" | NestedFrames page is open                                                                |
| 3. Switch to parent iframe form                                                                              | Driver has been switched to Parent frame. Label "Parent frame" can be found by WebDriver |
| 4. Switch to child iframe form                                                                               | Driver has been switched to Child frame. Lable "Child frame" can be found by WebDriver   |
| 5. Switch to default page                                                                                    | NestedFrames page is open                                                                |
| 6. Navigate to Frames page by selecting "Frames" from the menu                                               | Frames form is open                                                                      |
| 7. Switch to iframe1 and get text of the iframe1                                                             | WebDriver has been switched to iframe1                                                   |
| 8. Switch to default page and then to iframe2. Get text of the iframe2. Switch to default page again         | Frames page is open. Text from iframe1 and iframe2 matches                               |