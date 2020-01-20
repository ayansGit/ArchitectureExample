package com.architectureexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;

public class AddNoteActivity extends AppCompatActivity {

    public static final String EXTRA_TITLE = "com.architectureexample.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION = "com.architectureexample.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY = "com.architectureexample.EXTRA_PRIORITY";
    private EditText etTitle;
    private EditText etDescription;
    private NumberPicker npPriority;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        etTitle = findViewById(R.id.etTitle);
        etDescription = findViewById(R.id.eDescription);
        npPriority = findViewById(R.id.npPriority);

        npPriority.setMinValue(1);
        npPriority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Notes");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.note_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_note:
                setNote();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setNote(){
        String title = etTitle.getText().toString().trim();
        String desc = etDescription.getText().toString().trim();
        int priority = npPriority.getValue();

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, desc);
        data.putExtra(EXTRA_PRIORITY, priority);

        setResult(RESULT_OK, data);
        finish();
    }
}
