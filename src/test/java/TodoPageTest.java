import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobject.TodoPage;
import java.util.List;
import static org.junit.Assert.*;

public class TodoPageTest extends BaseTest {

    private final String ELEMENT1 = "1";
    private final String ELEMENT2 = "2";
    private final String ELEMENT3 = "3";
    @Test
    public void testAdd3Elements() {
        TodoPage todoPage = new TodoPage(driver);
        todoPage.openPage(); // Перейти на сайт https://forhemer.github.io/React-Todo-List/
        todoPage.addElement(ELEMENT1); // Добавить 1 элемент в ToDo лист
        todoPage.addElement(ELEMENT2); // Добавить 2 элемент в ToDo лист
        todoPage.addElement(ELEMENT3); // Добавить 3 элемент в ToDo лист
        List<WebElement> list = driver.findElements(By.xpath(".//li"));
        assertEquals(3, list.size()); // Проверить, что элементов в листе стало действительно 3
        todoPage.clickCheckbox2(); // Пометить один из элементов как выполненный (галочкой в чекбоксе)
        assertTrue(todoPage.isElement2LineThrough(TodoPage.ELEMENT2_LINE_THROUGH)); // Проверить, что текст этого элемента стал зачёркнутым
        todoPage.deleteElement2(); // Удалить элемент из списка
        assertFalse(todoPage.isElement2isDisplayed(TodoPage.ELEMENT2)); // Проверить, что элемент больше не отображается в списке
    }
}
