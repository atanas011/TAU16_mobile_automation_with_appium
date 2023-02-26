package tests.apptests;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.todo.CreateTask;
import pages.todo.TasksList;
import tests.base.BaseTest;
import util.JsonReader;

public class ToDoTest extends BaseTest {

    @DataProvider
    public Object[][] tasksData() throws IOException, ParseException {
        return JsonReader.getJsonData(System.getProperty("user.dir")
                + "/data/TasksData.json", "Tasks Data", 2);
    }

    @Test(dataProvider = "tasksData")
    public void testAddTask(String taskTitle, String taskText) {
        var tasksList = new TasksList(driver);
        var createTask = new CreateTask(driver);
        tasksList.clickAddTaskBtn();
        createTask.enterTaskTitle(taskTitle);
        createTask.enterTaskText(taskText);
        driver.hideKeyboard();
        createTask.clickSaveBtn();
    }
}