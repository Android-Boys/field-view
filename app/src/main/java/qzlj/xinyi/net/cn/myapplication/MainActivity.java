package qzlj.xinyi.net.cn.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import person.wxy.form.FieldView;

public class MainActivity extends AppCompatActivity {


    FieldView mFieldView1;
    FieldView mFieldView2;
    FieldView mRadioButton;
    Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFieldView1 = findViewById(R.id.mFieldView3);
        mFieldView2 = findViewById(R.id.mFieldView4);

        mButton=findViewById(R.id.mButton);

       mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("4577155",String.valueOf(checkMustInput(findViewById(android.R.id.content))));
            }
        });
    }

    /**
     * 递归遍历整个layout，发现有FieldView 就toast
     *
     * @param view
     */
    public boolean checkMustInput(View view) {
        if (view instanceof FieldView) {
            FieldView m = (FieldView) view;
            if (m.isMustInput() && m.getValue() == null || "".equals(m.getValue())) {
                Toast.makeText(MainActivity.this, m.getWarnMessager(), Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;
        } else if (view instanceof ViewGroup) {
            ViewGroup mViewGroup = (ViewGroup) view;
            int childCount = mViewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childView = mViewGroup.getChildAt(i);
                boolean b = checkMustInput(childView);
                if (!b)
                    return false;
            }
        }
        return true;
    }
}
