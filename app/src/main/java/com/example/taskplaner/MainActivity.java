package com.example.taskplanner;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText taskInput;
    private Button addTaskButton;
    private ListView taskListView;

    private ArrayList<String> taskList;
    private ArrayAdapter<String> taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация UI элементов
        taskInput = findViewById(R.id.taskInput);
        addTaskButton = findViewById(R.id.addTaskButton);
        taskListView = findViewById(R.id.taskListView);

        // Инициализация списка задач
        taskList = new ArrayList<>();
        taskAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        taskListView.setAdapter(taskAdapter);

        // Обработчик кнопки добавления задачи
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = taskInput.getText().toString().trim();
                if (!task.isEmpty()) {
                    taskList.add(task);
                    taskAdapter.notifyDataSetChanged();
                    taskInput.setText(""); // Очистка поля ввода
                } else {
                    Toast.makeText(MainActivity.this, "Task cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
