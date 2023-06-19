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
  driver.get("https://training-support.net")
  print(f"title of the page is" ,driver.title)
  driver.find_element(By.XPATH,"//a[@id='about-link']").click()  
  print(f"title of the about link page is" ,driver.title)
  driver.close()

  with webdriver.Firefox(service = service) as driver1:
   driver1.get("https://training-support.net/selenium/login-form")
   username = driver1.find_element(By.XPATH,"//input[@name='Username']")
   username.send_keys("admin")
   password = driver1.find_element(By.XPATH,"//input[@name='Password']")
   password.send_keys("password")
   login = driver1.find_element(By.XPATH,"//button[@onclick='signIn()']") 
   login.click()
   driver1.close()