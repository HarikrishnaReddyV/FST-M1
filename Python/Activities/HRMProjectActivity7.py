from selenium import webdriver
from selenium.webdriver.firefox.service import Service as Firefoxservice
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
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
    #add qulaifications
    myInfoTab = driver.find_element(By.XPATH,"//a[@id='menu_pim_viewMyDetails']")
    myInfoTab.click()
    sideNavigationMenu = driver.find_elements(By.XPATH,"//ul[@id='sidenav']/li")
    for menus in  sideNavigationMenu:
        menuList = menus.text
        if menuList.__eq__("Qualifications"):
            menus.click()
            break
    driver.find_element(By.XPATH,"//p[@id='actionWorkExperience']/input").click()
    driver.find_element(By.XPATH,"//input[@name='experience[employer]']").send_keys("IBM")
    driver.find_element(By.XPATH,"//input[@name='experience[jobtitle]']").send_keys("QA")
    driver.find_element(By.XPATH," //input[@id='btnWorkExpSave']").click()
    driver.quit()
