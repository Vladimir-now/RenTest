package ru.appline.framework.managers;


import ru.appline.framework.pages.DepositPage;
import ru.appline.framework.pages.StartPage;

public class PageManager {


    private static PageManager pageManager;

    private StartPage startPage;

    private DepositPage depositPage;


    private PageManager() {
    }

    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    public StartPage getStartPage() {
        if (startPage == null) {
            startPage = new StartPage();
        }
        return startPage;
    }

    public DepositPage getDepositPage() {
        if (depositPage == null) {
            depositPage = new DepositPage();
        }
        return depositPage;
    }
}




