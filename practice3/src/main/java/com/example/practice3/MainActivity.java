package com.example.practice3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Task> tasks = new ArrayList<>();
    private Button buttonAdd;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        fillTaskList();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TodoAdapter todoAdapter = new TodoAdapter(tasks);
        recyclerView.setAdapter(todoAdapter);
        recyclerView.setHasFixedSize(true);

        editText = findViewById(R.id.editTextText);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tasks.add(new Task(editText.getText().toString()));
                todoAdapter.notifyItemInserted(tasks.size() - 1);

                editText.setText("");
            }
        });
    }

    private void fillTaskList() {
        this.tasks.addAll(List.of(
                new Task("Вынести мусор"),
                new Task("Купить продукты"),
                new Task("Выгулять собаку"),
                new Task("Оплатить ЖКХ"),
                new Task("Позвонить сантехнику"),
                new Task("Доделать отчет"),
                new Task("Поздравить коллег"),
                new Task("Отвезти детей в школу"),
                new Task("Забрать детей из школы"),
                new Task("Отвезти детей на секцию"),
                new Task("Забрать детей с секции")
        ));
    }
}