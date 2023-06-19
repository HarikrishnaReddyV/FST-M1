from selenium import webdriver
from selenium.webdriver.firefox.service import Service as Firefoxservice
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By



service = Firefoxservice(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get("http://alchemy.hguy.co/orangehrm")
    userName = driver.find_element(By.ID,"txtUsername")
    passWord = driver.find_element(By.ID,"txtPassword")
    loginButton = driver.find_element(By.ID,"btnLogin")
    userName.send_keys("orange")
    passWord.send_keys("orangepassword123")
    loginButton.click()
    dashBoard = driver.find_element(By.ID,"menu_dashboard_index").is_displayed    
    print("Dashbiard element is visible upon login")
    driver.quit()