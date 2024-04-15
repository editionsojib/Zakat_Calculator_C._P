import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.editions.zakat.R;

public class ActionBar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                // হোম আইটেমের ক্লিক হ্যান্ডল করুন
                Toast.makeText(this, "হোম ক্লিক করা হয়েছে", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_about:
                // সম্পর্কে আইটেমের ক্লিক হ্যান্ডল করুন
                Toast.makeText(this, "সম্পর্কে ক্লিক করা হয়েছে", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
