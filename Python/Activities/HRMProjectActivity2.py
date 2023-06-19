from selenium import webdriver
from selenium.webdriver.firefox.service import Service as Firefoxservice
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By


service = Firefoxservice(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get("http://alchemy.hguy.co/orangehrm")
    url = driver.find_element(By.XPATH,"//div[@id='divLogo']/img").get_attribute("src")
    print("page image url is", url)
    driver.quit()