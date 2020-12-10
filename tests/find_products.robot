*** Settings ***
Documentation   Tests for storefront search feature.
Library         SeleniumLibrary   
Test Setup      Open Browser To Front Page
Test Teardown   Close Browser  
Test Template   Template Find Product

*** Variables ***
${URL}=    http://localhost:3000

# main-menu__right
${search_icon}=             //*[@data-test="menuSearchOverlayLink"]
${search_field}=            //input[@placeholder="search"]
${first_search_result}=     //*[@class="search__products__item"][1]

*** Test Cases ***

#Test case name                             #Full product name 
Find Audiobook Product With Full Name       LAKE TUNES
Find Grocery Product With Full Name         SEAMAN LAGER
Find Apparel Product With Full Name         POLO SHIRT
Find Audiobook product with partial name    LAGER
Find Paint Product with partial name        LIGHT SPEED
Find Homeware Product with partial name     PARROT CUSHION

*** Keywords ***

Template Find Product  
    [Arguments]  ${product_name}
    Search product  ${product_name}
    Verify first search result  ${product_name}

Open Browser To Front Page
    Open Browser    ${URL}   browser=chrome

Search product
    [Arguments]  ${product_name}
    Wait Until Element Is Visible  ${search_icon}
    Click Element  ${search_icon}
    Wait Until Element Is Visible  ${search_field}  timeout=2 seconds
    Input Text  ${search_field}   ${product_name}
    Sleep  2 seconds  Wait for search to finnish
    
Verify first search result
    [Arguments]  ${product_name}
    Wait Until Element Is Visible  ${first_search_result}  timeout=5 seconds
    Element Should Contain  ${first_search_result}//h4  ${product_name}










