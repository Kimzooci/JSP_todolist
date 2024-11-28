
package kyungseo.poc.todo.jsp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import kyungseo.poc.todo.jsp.payload.TodoDto;

public class TodoServiceData {

    List<TodoDto> myTodoList;

    public TodoServiceData(List<TodoDto> todos) {
        this.myTodoList = todos;
    }

    public List<TodoDto> getActiveTodayTodos() {
        LocalDate today = LocalDate.now();
        Predicate<TodoDto> pending = todo -> today.isEqual(todo.getTargetDate()) && !todo.isDone();

        return myTodoList
                .stream()
                .filter(pending)
                .collect(Collectors.toList());
    }

    public List<TodoDto> getCompletedTodayTodos() {
        //LocalDate today = LocalDate.now();
        //Predicate<TodoDto> pending = todo -> (todo.getTargetDate()).isBefore(today.plusDays(1)) && todo.isDone();
        Predicate<TodoDto> pending = todo -> todo.isDone();

        return myTodoList
                .stream()
                .filter(pending)
                .collect(Collectors.toList());
    }

    public List<TodoDto> getPendingTodos() {
        Predicate<TodoDto> pending = todo -> !todo.isDone();

        return myTodoList
                .stream()
                .filter(pending)
                .collect(Collectors.toList());
    }

    public List<TodoDto> getAllTodayTodos() {
        LocalDate today = LocalDate.now();
        Predicate<TodoDto> pending = todo -> today.isEqual(todo.getTargetDate());

        return myTodoList
                .stream()
                .filter(pending)
                .collect(Collectors.toList());
    }

    public List<TodoDto> getAllTodos() {
        return myTodoList;
    }

}