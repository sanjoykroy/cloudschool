package com.realtech.cloudschool.model.page;


import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {

    private static final HomePage HOME_PAGE = new HomePage();

    private HomePage(){
    }

    public static HomePage getInstance(){
        return HOME_PAGE;
    }

    public boolean isCurrentPage(){
        return isElementAvailable("user-name");
    }

    public void logout(){
        if(isCurrentPage()){
            WebElement logout = findElementById("logout");
            if(logout!=null){
                logout.click();
            }
        }
    }
}
