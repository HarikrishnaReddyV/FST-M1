import selectors
from selenium import webdriver
from selenium.webdriver.firefox.service import Service as Firefoxservice
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.ui import Select


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
    #apply Leave
    driver.find_element(By.XPATH,"//span[text()='Apply Leave']").click()
    LeaveType = driver.find_element(By.XPATH,"//select[@name='applyleave[txtLeaveType]']")
    select  = Select(LeaveType)
    select.select_by_visible_text("DayOff")
    fromDate = "2023-06-16"
    toDate = "2023-06-18"
    FromDate  =   driver.find_element(By.XPATH,"//input[@id='applyleave_txtFromDate']")
    ToDate  =   driver.find_element(By.XPATH,"//input[@id='applyleave_txtToDate']")
    FromDate.clear()
    FromDate.send_keys(fromDate)
    ToDate.clear()
    ToDate.send_keys(toDate)
    driver.find_element(By.XPATH,"//input[@id='applyBtn']").click()
    driver.find_element(By.XPATH,"//a[contains(@href,'MyLeaveList')]").click()
    status = driver.find_element(By.XPATH,"//table[@id='resultTable']/tbody/tr[1]/td[6]").text
    print("Status of My Leave Application is ", status)
    driver.quit()

