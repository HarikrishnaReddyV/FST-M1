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
    driver.get("https://training-support.net/selenium/ajax")
    print("title of the page is :", driver.title)
    driver.find_element(By.XPATH,"//button[text()='Change Content']").click()
    wait = WebDriverWait(driver,5)
    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME,"h1"),"HELLO!"))
    helloText = driver.find_element(By.TAG_NAME,"h1")
    print("text on clicking context is ", helloText.text)
    wait.until(expected_conditions.text_to_be_present_in_element((By.TAG_NAME, "h3"), "I'm late!"))
    late_text = driver.find_element(By.TAG_NAME, "h3").text
    # Print the text
    print(late_text)
    driver.quit()
