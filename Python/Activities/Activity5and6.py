from selenium import webdriver
#from selenium.webdriver.firefox.service import service as FirefoxService
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.keys import Keys

service = FirefoxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:

    act = ActionChains(driver)
    driver.get("https://www.training-support.net/selenium/input-events")
    print("page title is", driver.title)

    act.click().perform()
    activeSide = driver.find_element(By.XPATH,"//div[@class='active']")
    print("text on click is ",activeSide.text)

    act.double_click().perform()
    activeSideonDC = driver.find_element(By.XPATH,"//div[@class='active']")
    print("text on double click is ",activeSideonDC.text)

    act.context_click().perform()
    activeSideonRC = driver.find_element(By.XPATH,"//div[@class='active']")
    print("text on right click is ",activeSideonRC.text)

    act.send_keys("H").perform()
    act.key_down(Keys.CONTROL).send_keys("a").send_keys("c").key_up(Keys.CONTROL).perform()
    driver.close()
