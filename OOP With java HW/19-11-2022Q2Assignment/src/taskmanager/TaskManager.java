package taskmanager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import enums.STATUS;

public class TaskManager {
	private int taskId;
	private String taskName;
	private String description;
	private LocalDate taskDate;
	private STATUS status;
	private boolean active;
	public static int counter;
	static {
		counter = 1;
	}

	public TaskManager(int taskId) {
		super();
		this.taskId = taskId;
	}

	public TaskManager(String taskName, String description, LocalDate taskDate) {
		super();
		this.taskId = counter;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = taskDate;
		this.status = STATUS.PENDING;
		this.active = true;
		counter = counter + 1;
	}
	
	@Override
	public boolean equals(Object anotherObject) {
		if(anotherObject instanceof TaskManager) {
			TaskManager t=(TaskManager) anotherObject;
			return this.getTaskId()==t.getTaskId();
	//return this.getTaskId().equals(((TaskManager)anotherObject).getTaskId());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "TaskManager [taskId=" + taskId + ", taskName=" + taskName + ", description=" + description
				+ ", taskDate=" + taskDate.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")) + ", status=" + status + ", active=" + active + "]";
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
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

	public LocalDate getTaskDate() {
		return taskDate;
	}

	public void setTaskDate(LocalDate taskDate) {
		this.taskDate = taskDate;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
