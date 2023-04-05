import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void searchTestWhenCoincidence() {
        SimpleTask simpleTask = new SimpleTask(55, "Позвонить родителям");
        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchTestWhenNoCoincidence() {
        SimpleTask simpleTask = new SimpleTask(55, "Позвонить родителям");
        boolean expected = false;
        boolean actual = simpleTask.matches("набрать");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void searchTestEpicWhenCoincidence() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(78, subtasks);
        boolean expected = true;
        boolean actual = epic.matches("Яйца");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchTestEpicWhenNoCoincidence() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(78, subtasks);
        boolean expected = false;
        boolean actual = epic.matches("Виски");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchTestMeetingWhenCoincidenceTopic() {
        Meeting meeting = new Meeting(78,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");
        boolean expected = true;
        boolean actual = meeting.matches("3й");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchTestMeetingWhenCoincidenceProject() {
        Meeting meeting = new Meeting(78,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");
        boolean expected = true;
        boolean actual = meeting.matches("Приложение");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchTestMeetingWhenNoCoincidenceTopic() {
        Meeting meeting = new Meeting(78,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");
        boolean expected = false;
        boolean actual = meeting.matches("Выкатка 4й");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchTestMeetingWhenNoCoincidenceProject() {
        Meeting meeting = new Meeting(78,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда");
        boolean expected = false;
        boolean actual = meeting.matches("Альфабанка");
        Assertions.assertEquals(expected, actual);
    }
}
