package com.example.kdao.helloworldapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.content.Intent;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    static String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Application is running, yay!");
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        createListView(); //create list
        registerClickCallBack(); //handle list item click
        createButton(); //create button
        createViewMapButton(); //button navigate to map
        createCameraButton(); //navigate to camera activity
        createBarCodeButton(); //Navigate to barcode view page
    }

    private void createListView() {
        // Defined Array values to show in ListView
        String[] values = new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };
        //Action on listView
        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
        ListView listView = (ListView)findViewById(R.id.list);

        // Assign adapter to ListView
        listView.setAdapter(adapter);
    }

    private void registerClickCallBack() {
        ListView list = (ListView)findViewById(R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) parent.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

    //Button click navigate to settings page
    private void createButton() {
        //Action on button
        Button btnDoSomething = (Button) findViewById(R.id.dosomething);
        btnDoSomething.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked");
                //Create message popup on Android, which will disappear after a certain time
                Toast mytoast = Toast.makeText(getApplicationContext(), "Button was clicked", Toast.LENGTH_SHORT);
                mytoast.show();
                //Navigate to setting page
                Intent launchActivity1 = new Intent(MainActivity.this, ShareActivity.class);
                //Passing data among activity
                launchActivity1.putExtra("SESSION_ID", "1234");
                startActivity(launchActivity1);
            }
        });
    }

    //button click navigate to google map page
    private void createViewMapButton() {
        Button btnMap = (Button) findViewById(R.id.viewmap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "view map");
                Intent viewMap = new Intent(MainActivity.this, PlaceAPIActivity.class);
                startActivity(viewMap);
            }
        });
    }

    //button navigate to camera page
    private void createCameraButton() {
        Button btnMap = (Button) findViewById(R.id.camera_button);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Camera action");
                Intent cameraView = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(cameraView);
            }
        });
    }

    //button navigate to barcode button
    private void createBarCodeButton() {
        Button btnBarCode = (Button) findViewById(R.id.barcode);
        btnBarCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Barcode action");
                Intent barcodeView = new Intent(MainActivity.this, BarCodeActivity.class);
                startActivity(barcodeView);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, Setting.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
