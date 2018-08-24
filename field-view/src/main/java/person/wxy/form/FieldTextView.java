package person.wxy.form;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;


/**
 * Created by Fracesuit on 2017/8/8.
 */

public class FieldTextView extends AppCompatTextView implements IFormField {
    public FieldTextView(FieldView.Builder builder, Context context) {
        super(context);
        FormInitUtil.initTextView(this, builder);
        this.setPadding(10,0,0,0);
    }

    public FieldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public String getValue() {
        return getText().toString();
    }

    @Override
    public void setVaule(String value) {
        setText(value);
    }
}
