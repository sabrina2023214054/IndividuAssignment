package com.example.individuassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbar = findViewById(R.id.customToolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("About");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        if (toolbar.getNavigationIcon() != null) {
            toolbar.getNavigationIcon().setTint(getColor(android.R.color.black));
        }


        TextView githubLink = findViewById(R.id.txtGithub);
        githubLink.setOnClickListener(view -> {
            String repoUrl = "https://github.com/sabrina2023214054/IndividuAssignment";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(repoUrl));
            startActivity(intent);
        });
    }

    // --- Enable 3-dot menu & make it black ---
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        Toolbar toolbar = findViewById(R.id.customToolbar);

        // 🔥 MAKE 3 DOTS BLACK
        if (toolbar.getOverflowIcon() != null) {
            toolbar.getOverflowIcon().setTint(getColor(android.R.color.black));
        }

        return true;
    }

    // --- Menu Actions ---
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        if (item.getItemId() == R.id.menu_home) {
            startActivity(new Intent(this, MainActivity.class));
            return true;
        }

        if (item.getItemId() == R.id.menu_about) {
            Toast.makeText(this, "You are already on the About page", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

