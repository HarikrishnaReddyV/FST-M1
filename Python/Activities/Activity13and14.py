from selenium import webdriver
from selenium.webdriver.firefox.service import Service as FireforxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support import wait

service = FireforxService(GeckoDriverManager().install())

with webdriver.Firefox(service=service) as driver:
    driver.get("https://training-support.net/selenium/tables")
    print("title of the page is ",driver.title)
    tablerows = driver.find_elements(By.XPATH,"//table[contains(@class,'striped ')]/tbody/tr")
    print("no.of rows in the table are ",len(tablerows))
    tablecolumns =driver.find_elements(By.XPATH,"//table[contains(@class,'striped ')]/tbody/tr[1]/td")
    print("no.of columns in the table are ",len(tablecolumns))
    # print cell values for 3rd row
    thirdRow = driver.find_elements(By.XPATH,"//table[contains(@class,'striped ')]/tbody/tr[3]")
    for row in thirdRow:
        print("value in 3rd row is", row.text)
    # Get cell value from the second row and second column
    SecondCellValue = driver.find_element(By.XPATH,"//table[contains(@class,'striped ')]/tbody/tr[2]/td[2]")    
    print("Second row second cell vale is ",SecondCellValue.text)
    second_row_second_cell_before_sort = driver.find_element(By.XPATH, "//table[@id='sortableTable']/tbody/tr[2]/td[2]")
    # Print the cell value
    print("Cell value at second row and second column: ", second_row_second_cell_before_sort.text)

    # Find and click the first heading in the table
    driver.find_element(By.XPATH, "//table[@id='sortableTable']/thead/tr/th[1]").click()

    # Get cell value from the second row and second column after sorting
    second_row_second_cell_after_sort = driver.find_element(By.XPATH, "//table[@id='sortableTable']/tbody/tr[2]/td[2]")
    # Print the cell value
    print("Cell value at second row and second column: ", second_row_second_cell_after_sort.text)
    driver.quit()

