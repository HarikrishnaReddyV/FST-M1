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
  driver.find_Element(By.ID,"about-link").click()  
  driver.quit()
