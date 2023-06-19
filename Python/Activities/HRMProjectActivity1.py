from selenium import webdriver
from selenium.webdriver.firefox.service import Service as Firefoxservice
from webdriver_manager.firefox import GeckoDriverManager

service = Firefoxservice(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get("http://alchemy.hguy.co/orangehrm")
    title =driver.title
    print(title)
    assert("OrangeHRM",title)
    driver.quit()