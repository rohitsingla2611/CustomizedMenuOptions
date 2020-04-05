package rohitsingla.rdrock.customizedmenuoptions;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String strCurrentDateTime = java.text.DateFormat.getDateTimeInstance().format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_demo, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch ((item.getItemId())) {
            case R.id.itemOne:
                Toast.makeText(this, "ITEM ONE", Toast.LENGTH_SHORT).show();
//                return true;
                break;
            case R.id.itemTwo:
                showToast();
                return true;
            case R.id.itemThree:
                return true;
            case R.id.item3_1:
                Toast.makeText(this, "SUB ITEM THREE_ONE", Toast.LENGTH_SHORT).show();
                onBackPressed();
                return true;
            case R.id.itemFour:
                Toast.makeText(this, "ITEM FOUR", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subItem4_1:
                Toast.makeText(this, "SUB ITEM FOUR_ONE", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.subItem4_2:
                Toast.makeText(this, strCurrentDateTime, Toast.LENGTH_SHORT).show();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    void showToast() {

        LayoutInflater layoutInflater = getLayoutInflater();
        View layout = layoutInflater.inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.custom_toast_layout));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }
}
