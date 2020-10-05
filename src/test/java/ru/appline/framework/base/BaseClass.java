package ru.appline.framework.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.appline.framework.managers.InitManager;
import ru.appline.framework.managers.PageManager;

public class BaseClass {
    protected PageManager app = PageManager.getPageManager();

    @BeforeEach
    public void beforeEach() {
        InitManager.initFramework();
    }

    @AfterEach
    public void afterEach() {
        InitManager.quitFramework();
    }

}
