from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from  webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

     driver.get("https://training-support.net/selenium/drag-drop")
     act = ActionChains(driver)
     ballimage = driver.find_element(By.XPATH,"//img[contains(@src,'ball')]")
     dropZone1 = driver.find_element(By.XPATH,"//div[@id='droppable']")
     dropZone2 = driver.find_element(By.XPATH,"//div[@id='dropzone2']")

     act.drag_and_drop(ballimage,dropZone1).perform()
     act.drag_and_drop(ballimage,dropZone2).perform()

     driver.quit()



