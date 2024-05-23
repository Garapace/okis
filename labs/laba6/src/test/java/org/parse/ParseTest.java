package org.parse;

import org.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParseTest extends BaseTest {
    @Test (groups = "parse")
    void parseMenu() {
        String expectedResult = "Mail.ru\nПочта\nОблако\nОдноклассники\n" +
                "ВКонтакте\nНовости\nЗнакомства\nИгры";

        String actualResult = HomePage.parseMenu();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test (groups = "parse")
    void parseProjects() {
        String expectedResult = "Почта\nОблако\nКалендарь\nЗаметки\nЗвонки\n" +
                "Skillbox\nGeekBrains\nVK Почта\nМаруся\nУчи.ру";

        String actualResult = HomePage.parseProjects();

        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test (groups = "parse")
    void parseAllProjects() {
        String expectedResult = "СоцсетиМедиа и развлеченияОбразованиеПродуктивностьМагазин приложений" +
                "ИгрыУстройстваМессенджерыБлаготворительностьТовары и услугиЭкосистемные сервисы";

        String actualResult = HomePage.parseAllProjects();

        Assert.assertEquals(expectedResult, actualResult);
    }
}
