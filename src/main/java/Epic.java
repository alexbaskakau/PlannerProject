public class Epic extends Task {

    protected String[] subtasks = new String[0];

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // заполнение своих полей
    }

    public String[] getSubtask() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String task : subtasks) {

            if (task.contains(query)) {
                return true;

            }
        }
      return false;
    }

    }



