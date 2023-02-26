package tests.apptests;

import org.testng.annotations.Test;
import pages.todo.CreateTask;
import pages.todo.TasksList;
import tests.base.BaseTest;

public class ToDoTest extends BaseTest {

    @Test
    public void testAddTask() {
        var tasksList = new TasksList(driver);
        var createTask = new CreateTask(driver);
        tasksList.clickAddTaskBtn();
        createTask.enterTaskTitle("Finish Appium Course");
        createTask.enterTaskText("Finishing my course ASAP");
        driver.hideKeyboard();
        createTask.clickSaveBtn();
        tearDown();
    }
}