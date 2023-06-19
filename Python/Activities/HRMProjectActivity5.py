from selenium import webdriver
from selenium.webdriver.firefox.service import Service as Firefoxservice
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions



service = Firefoxservice(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    
    firstname = "HRM"
    lastname = " User"
    wait= WebDriverWait(driver,10)
    driver.get("http://alchemy.hguy.co/orangehrm")
    # login
    username = driver.find_element(By.ID,"txtUsername")
    password = driver.find_element(By.ID,"txtPassword")
    button = driver.find_element(By.ID,"btnLogin")
    username.send_keys("orange")
    password.send_keys("orangepassword123")
    button.click()
    dashboard = driver.find_element(By.ID,"menu_dashboard_index").is_displayed()
    #assert True(dashboard,"Homepage is not displayed")
    driver.find_element(By.XPATH,"//a[@id='menu_pim_viewMyDetails']").click()
    driver.find_element(By.XPATH,"//input[@value='Edit']").click()
    edtFname = driver.find_element(By.XPATH,"//input[@title='First Name']")
    edtLname = driver.find_element(By.XPATH,"//input[@title='Last Name']")
    edtFname.clear()
    edtLname.clear()
    edtFname.send_keys("edt" + firstname)
    edtLname.send_keys("edt" + lastname)
    maleGender = driver.find_element(By.XPATH,"//li//input[@value='1']")
    femaleGender = driver.find_element(By.XPATH,"//li//input[@value='2']")
    if maleGender.is_selected:
        femaleGender.click()
    else:
        maleGender.click()
    driver.find_element(By.XPATH,"//input[@value='Save']")      
    driver.quit()


