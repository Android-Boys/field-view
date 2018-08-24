package person.wxy.form;

import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by zhiren.zhang on 2017/11/30.
 */

public class FormInitUtil {

    public static void initTextView(TextView textView, FieldView.Builder builder) {
        if (builder != null) {
            if ((null!=builder.getValueInitContent()&&!builder.getValueInitContent().equals(""))) {
                textView.setText(builder.getValueInitContent());
            }
            if ((null!=builder.getEdittextHint()&&!builder.getEdittextHint().equals(""))) {
                textView.setHint(builder.getEdittextHint());
            }
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, builder.getValueTextSize());
            textView.setTextColor(ContextCompat.getColor(textView.getContext(), builder.getValueTextColor()));
        }
    }

    public static void initEditText(EditText editText, FieldView.Builder builder) {
        if (builder != null) {
            if ((null!=builder.getValueInitContent()&&!builder.getValueInitContent().equals(""))) {
                int length = builder.getValueInitContent().length();
                editText.setText(builder.getValueInitContent());
                editText.setSelection(length);
            }
            editText.setTextSize(TypedValue.COMPLEX_UNIT_PX, builder.getValueTextSize());
            if ((null!=builder.getEdittextHint()&&!builder.getEdittextHint().equals(""))) {
                editText.setHint(builder.getEdittextHint());
            }
            if (builder.getEdittextLine() != -1) {
                editText.setLines(builder.getEdittextLine());
            }
            editText.setTextColor(ContextCompat.getColor(editText.getContext(), builder.getValueTextColor()));
            editText.setBackground(null);
        }
    }
}
