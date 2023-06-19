from selenium import webdriver
from selenium.webdriver.firefox.service import Service as Firefoxservice
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions



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
    driver.find_element(By.XPATH,"//a[@id='menu_directory_viewDirectory']").click()
    Header = driver.find_element(By.XPATH,"//div[@class='head']/h1").text
    assert("Search Directory",Header)
    print("Header Exist as expected")
    driver.quit()