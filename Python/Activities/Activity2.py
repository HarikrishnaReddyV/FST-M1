# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service = service) as driver:
  
  # Open the browser to the URL
  driver.get("https://training-support.net/selenium/login-form")

  username = driver.find_element(By.ID,"username")
  username.send_keys("admin")
  password = driver.find_element(By.ID,"password")
  password.send_keys("password")
  login = driver.find_element(By.CLASS_NAME,"ui") 
  login.click()
  driver.quit()