
package kyungseo.poc.todo.jsp.payload;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.ToString;

@ToString
public class TodoDto {

    @NotNull
	private long id;

    @NotEmpty(message = "{todo.username.valid.notmepty}")
	private String userName;

    @NotNull(message = "{todo.description.valid.notnull}")
    @Size(min = 5, message = "{todo.description.valid.size}")
	private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate targetDate;

	private boolean done;

	public TodoDto() {
	    super();
	}

	public TodoDto(String user, String description, LocalDate targetDate, boolean done) {
		super();
		this.userName = user;
		this.description = description;
		this.targetDate = targetDate;
		this.done = done;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}