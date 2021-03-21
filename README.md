# Interesting pages
http://the-internet.herokuapp.com
https://practicetestautomation.com/practice-test-login/

# Selenium-Template
# Intall plugin "Create testNG XML"
## Configuration of testNG
    Menu **Run/Edit configuraion...**
        In **Templates/testNG**
            in **VM options** add -Dtestng.dtd.http=true after -ea
            
# Create a directory for TestNG suites
    in src/test/resources
        Create directory: TestSuites
    Let maven that we want to use these tests suites.
        In maven Surfire plugin add
            <configuration>
                <suiteXmlFiles>
                    <suiteXmlFile>
                        src/test/resources/TestSuites/AllTests.xml
                    </suiteXmlFile>
                </suiteXmlFiles>
            <configuration>

    Execute:
        mvn -Dtestng.dtd.http=true clean test
                                
                                   
