package workFlows;

import extentions.UIActions;
import extentions.Verifications;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class WebFlows extends CommonOps {

    @Step("business flow: login")
    public static void login(String user, String pass){
        UIActions.updateText(grafanaLogin.txt_userName, user);
        UIActions.updateText(grafanaLogin.txt_password, pass);
        UIActions.click(grafanaLogin.btn_Login);
        UIActions.click(grafanaLogin.btn_Skip);
    }

    @Step("business flow: create new user")
    public static void createNewUser(String name, String email, String username, String password){
        UIActions.click(grafanaServerAdminMain.btn_new_user);
        UIActions.updateText(grafanaAddNewUserPage.txt_name, name);
        UIActions.updateText(grafanaAddNewUserPage.txt_email, email);
        UIActions.updateText(grafanaAddNewUserPage.txt_username, username);
        UIActions.updateText(grafanaAddNewUserPage.txt_password, password);
        UIActions.click((grafanaAddNewUserPage.btn_create));
    }

    @Step("business flow: delete last user")
    public static void deleteLastUser(){
        UIActions.click(grafanaServerAdminMain.rows.get(grafanaServerAdminMain.rows.size()-1));
        UIActions.click(grafanaEditUserPage.btn_delete_user);
        UIActions.click(grafanaEditUserPage.btn_confirm_delete_user);
    }

    @Step("business flow: search and verify user")
    public static void searchAndVerifyUser(String user, String shouldExist){
        UIActions.updateTextHuman(grafanaServerAdminMain.txt_search, user);
        if (shouldExist.equalsIgnoreCase("exist"))
            Verifications.existenceOfElements(grafanaServerAdminMain.rows);
        else if (shouldExist.equalsIgnoreCase("not-exist"))
        Verifications.nontExistenceOfElements(grafanaServerAdminMain.rows);
        else
            throw new RuntimeException("invalid expected output in data driven testing, should been exists or not exists");

    }
}
