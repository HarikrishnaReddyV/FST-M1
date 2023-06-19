from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FirefoxService
from  webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions


service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get("https://training-support.net/selenium/dynamic-controls")
    act = ActionChains(driver)
    wait = WebDriverWait(driver,10)


    print("page title is ", driver.title)
    checkBox = driver.find_element(By.XPATH,"//div[@id='dynamicCheckbox']") 
    checkboxToggle = driver.find_element(By.XPATH,"//button[@id='toggleCheckbox']")
    checkboxToggle.click()
    print("checkbox is hidden")
    wait.until(expected_conditions.invisibility_of_element_located(checkBox))
    print("Check box is visible")
    driver.quit()
