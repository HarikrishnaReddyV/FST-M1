from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FireforxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support.select import Select

# Set up the Firefox Driver with WebDriverManger
service = FireforxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("https://training-support.net/selenium/javascript-alerts")
    print("page title is : ", driver.title)
    driver.find_element(By.ID,"prompt").click()
    confirmAlert = driver.switch_to.alert
    print("Confirm page text is " , confirmAlert.text)
    confirmAlert.send_keys("Awesome!")
    confirmAlert.accept()
    driver.quit()
    
