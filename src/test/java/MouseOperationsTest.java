import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MouseOperationsTest {

    @BeforeAll
    static void setUp () {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    //Task1
    //На главной странице GitHub выберите меню Solutions -> Enterprise
    // с помощью команды hover для Solutions.
    // Убедитесь что загрузилась нужная страница (например что заголовок - "Build like the best."
    @Test
    void testHoverUsage() {

        //Open github
        open("https://github.com");

        //Open Solutions menu
        $("header").$(withText("Solutions")).hover();

        //Open Enterprise
        $("[aria-labelledby=solutions-for-heading]").$(withText("Enterprise")).click();

        //Check the page
        $(byText("To build, scale, and deliver secure software.")).shouldBe(visible);

        //sleep(5000);
    }

    //Task2
    //(опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()
    //- Откройте https://the-internet.herokuapp.com/drag_and_drop
    //- Перенесите прямоугольник А на место В
    //- Проверьте, что прямоугольники действительно поменялись
    //- В Selenide есть команда $(element).dragAndDrop($(to-element)),
    // проверьте работает ли тест, если использовать её вместо actions()
}
