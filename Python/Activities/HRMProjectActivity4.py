from selenium import webdriver
from selenium.webdriver.firefox.service import Service as Firefoxservice
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions



service = Firefoxservice(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    empFirstName = "python"
    empLastName = " user"
    employeeName =""
    wait = WebDriverWait(driver,10)
    driver.get("http://alchemy.hguy.co/orangehrm")
    userName = driver.find_element(By.ID,"txtUsername")
    passWord = driver.find_element(By.ID,"txtPassword")
    loginButton = driver.find_element(By.ID,"btnLogin")
    userName.send_keys("orange")
    passWord.send_keys("orangepassword123")
    loginButton.click()    
    '''wait.until(expected_conditions.visibility_of_element_located(By.XPATH,"//a[@id='menu_pim_viewPimModule']"))'''
    pim = driver.find_element(By.XPATH,"//a[@id='menu_pim_viewPimModule']")   
    pim.click()
    addEmployeeButton = driver.find_element(By.XPATH,"//a[text()='Add Employee']")
    addEmployeeButton.click()
    fName =driver.find_element(By.ID,"firstName")
    lName =driver.find_element(By.ID,"lastName")
    save =driver.find_element(By.ID,"btnSave")
    fName.send_keys(empFirstName)
    lName.send_keys(empLastName)
    save.click()
    '''wait.until(expected_conditions.visibility_of_element_located(By.XPATH,"//a[@id='menu_pim_addEmployee']"))'''
    driver.find_element(By.XPATH,"//a[@id='menu_pim_addEmployee']").click()
    driver.find_element(By.XPATH,"//a[text()='Employee List']").click()
    driver.find_element(By.XPATH,"//input[@id='empsearch_employee_name_empName']").send_keys(empFirstName  + empLastName)
    fullName = empFirstName + empLastName
    '''wait.until(expected_conditions.visibility_of_element_located(By.XPATH,"//div[@class='ac_results']/ul/li"))'''
    names = driver.find_elements(By.XPATH,"//div[@class='ac_results']/ul/li")
    for empnames in names:
       print(empnames.text)       
    empnames.text.__contains__(empFirstName  + empLastName)     
    driver.quit()   
    


