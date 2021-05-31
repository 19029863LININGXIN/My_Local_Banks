package sg.edu.rp.c346.id19029863.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {
    TextView DBS;
    TextView OCBC;
    TextView UOB;
    String wordclicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBS = findViewById(R.id.DBS);
        OCBC = findViewById(R.id.OCBC);
        UOB = findViewById(R.id.UOB);
        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.language, menu);
        return true;
    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, R.string.website);
        menu.add(0, 1, 1, R.string.contact);
        menu.add(0, 2, 2, R.string.toggle_favourite);

        if (v == DBS){
            wordclicked = "DBS";
        }else if (v == OCBC){
            wordclicked = "OCBC";
        }else if (v == UOB){
            wordclicked = "UOB";
        }

    }

    public boolean onContextItemSelected(MenuItem item) {

        if (wordclicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.DBSweb)));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.dbsCall)));
                startActivity(intentCall);
            }else if (item.getItemId() == 2) {
                if (DBS.getCurrentTextColor() == Color.BLACK) {
                    DBS.setTextColor(Color.RED);
                } else if (DBS.getCurrentTextColor() == Color.RED) {
                    DBS.setTextColor(Color.BLACK);
                }
            }
            return true;
        }
        else if (wordclicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.OCBCweb)));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.ocbcCall)));
                startActivity(intentCall);
            } else if (item.getItemId() == 2){
                if(OCBC.getCurrentTextColor() == Color.BLACK){
                    OCBC.setTextColor(Color.RED);
                }
                else if(OCBC.getCurrentTextColor() == Color.RED){
                    OCBC.setTextColor(Color.BLACK);
                }
            }
            return true;
        }
        else if (wordclicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.UOBweb)));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.uobCall)));
                startActivity(intentCall);
            }else if (item.getItemId() == 2){
                if(UOB.getCurrentTextColor() == Color.BLACK){
                    UOB.setTextColor(Color.RED);
                }
                else if(UOB.getCurrentTextColor() == Color.RED){
                    UOB.setTextColor(Color.BLACK);
                }
            }
            return true;
        }
        return super.onContextItemSelected(item);
    }

        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here.
            int id = item.getItemId();
            if (id == R.id.EnglishSelection) {
                Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
                DBS.setText(R.string.dbs);
                OCBC.setText(R.string.ocbc);
                UOB.setText(R.string.uob);
                return true;
            } else if (id == R.id.ChineseSelection) {
                Toast.makeText(MainActivity.this, "切换中文模式", Toast.LENGTH_SHORT).show();
                DBS.setText(R.string.cDBS);
                OCBC.setText(R.string.cOCBC);
                UOB.setText(R.string.cUOB);
                return true;
            } else {
                Toast.makeText(MainActivity.this, "Error Translation", Toast.LENGTH_SHORT).show();
            }
            return super.onOptionsItemSelected(item);
        }
    }

