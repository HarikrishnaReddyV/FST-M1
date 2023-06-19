from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FireforxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support.select import Select

# Set up the Firefox Driver with WebDriverManger
service = FireforxService(GeckoDriverManager().install())

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    driver.get("https://www.training-support.net/selenium/popups")
    act = ActionChains(driver)
    print("page title is ", driver.title)
    button = driver.find_element(By.XPATH,"//button[@onclick='openModal()']")
    act.move_to_element(button).perform
    buttonText = button.get_attribute("data-tooltip")
    print("Button Hover Text is : ", buttonText)
    button.click()
    userName = driver.find_element(By.ID,"username")
    pwd = driver.find_element(By.ID,"password")
    login = driver.find_element(By.XPATH,"//button[@onclick='signIn()']")
    userName.send_keys("admin")
    pwd.send_keys("password")
    login.click()
    Text = driver.find_element(By.XPATH,"//div[@id='action-confirmation']").text
    print("Message on login is : " + Text)
    driver.quit()