import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.DragAndDropOptions.to;
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
    @Test
    void testDragAndDrop () {
        //- Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //- Перенесите прямоугольник А на место В
        actions().moveToElement($("#column-a header")).clickAndHold()
                .moveByOffset(150, 0).release().perform();

        //- Проверьте, что прямоугольники действительно поменялись
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));

        //- В Selenide есть команда $(element).dragAndDrop($(to-element)),
        // проверьте работает ли тест, если использовать её вместо actions()
        $("#column-a header").dragAndDrop(to($("#column-b header")));

        //- Проверьте, что прямоугольники действительно поменялись
        $("#column-a header").shouldHave(text("A"));
        $("#column-b header").shouldHave(text("B"));
    }
}
