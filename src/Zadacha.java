import java.time.LocalDateTime;
import java.util.Objects;

public class Zadacha {
    private int id;
    private String taskName;
    private String description;
    private boolean typeTask;
    private LocalDateTime dateTask;

    private LocalDateTime nextDate;
    static int counterId;
    private EnRepeatability repeatability;



    private boolean delete;
//конструктор

    public Zadacha(int id, String taskName, String description, boolean typeTask, LocalDateTime dateTask) {
        this.id = counterId;
        setTaskName(taskName);
        setDescription(description);
        this.typeTask = typeTask;
        this.dateTask = LocalDateTime.now();
        Zadacha.counterId++;
    }

    public Zadacha(String inputTaskName, String taskName, EnRepeatability inputRepeatability, boolean typeTask) {
    }


    // геттеры/сеттеры
    public EnRepeatability getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(EnRepeatability repeatability) {
        this.repeatability = repeatability;
    }
    public LocalDateTime getNextDate() {
        return nextDate;
    }

    public void setNextDate(LocalDateTime localDateTime) {
        this.nextDate = nextDate;
    }
    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isTypeTask() {
        return typeTask;
    }

    public void setTypeTask(boolean typeTask) {
        this.typeTask = typeTask;
    }

    public LocalDateTime getDateTask() {
        return dateTask;
    }

    public void setDateTask(LocalDateTime dateTask) {
        this.dateTask = dateTask;
    }

    // хэшкод и эквилс


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zadacha zadacha = (Zadacha) o;
        return id == zadacha.id && typeTask == zadacha.typeTask && taskName.equals(zadacha.taskName) && description.equals(zadacha.description) && dateTask.equals(zadacha.dateTask);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, taskName, description, typeTask, dateTask);
    }
}
