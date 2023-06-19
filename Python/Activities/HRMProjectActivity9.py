import selectors
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as Firefoxservice
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.ui import Select


service = Firefoxservice(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    wait= WebDriverWait(driver,10)
    driver.get("http://alchemy.hguy.co/orangehrm")
    username = driver.find_element(By.ID,"txtUsername")
    password = driver.find_element(By.ID,"txtPassword")
    button = driver.find_element(By.ID,"btnLogin")
    username.send_keys("orange")
    password.send_keys("orangepassword123")
    button.click()

    driver.find_element(By.XPATH,"//a[contains(@href,'viewMyDetails')]").click()
    sideNavigationMenu = driver.find_elements(By.XPATH,"//ul[@id='sidenav']/li")
    for  menuitems in sideNavigationMenu :
             MenuList = menuitems.text
             if MenuList.__eq__("Emergency Contacts"):
                menuitems.click()
                break
   
    tableRows = driver.find_elements(By.XPATH,"//table[@id='emgcontact_list']/tbody/tr")
    for  rowData in tableRows :
             contactList = rowData.text
             print("Contents in Emergency contact list is " , contactList)
    driver.quit()         
        
