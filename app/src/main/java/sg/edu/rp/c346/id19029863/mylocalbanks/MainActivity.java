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
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact");
        menu.add(0, 2, 2, "Toggle Favourite");

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
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18001111111L));
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
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com.sg"));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18003633333L));
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
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 18002222121L));
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
                DBS.setText("DBS");
                OCBC.setText("OCBC");
                UOB.setText("UOB");
                return true;
            } else if (id == R.id.ChineseSelection) {
                Toast.makeText(MainActivity.this, "切换中文模式", Toast.LENGTH_SHORT).show();
                DBS.setText("星展银行");
                OCBC.setText("华侨银行");
                UOB.setText("大华银行");
                return true;
            } else {
                Toast.makeText(MainActivity.this, "Error Translation", Toast.LENGTH_SHORT).show();
            }
            return super.onOptionsItemSelected(item);
        }
    }

