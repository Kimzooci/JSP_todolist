
package kyungseo.poc.todo.jsp.persistence.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import kyungseo.poc.todo.common.base.BaseEntity;

/**
 * @author 박경서 (Kyungseo.Park@gmail.com)
 * @version 1.0
 */
@Entity
@Table(name = "TODO")
public class Todo extends BaseEntity {

	private static final long serialVersionUID = 1L;

    @Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

    @Column(name = "USERNAME")
	private String userName;

    @Column(name = "DESCRIPTION")
	private String description;

    @Column(name = "TARGET_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate targetDate;

    @Column(name = "IS_DONE")
	private boolean done;

	public Todo() {
		super();
	}

	public Todo(String user, String description, LocalDate targetDate, boolean done) {
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