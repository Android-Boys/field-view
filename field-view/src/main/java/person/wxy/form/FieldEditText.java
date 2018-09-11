package person.wxy.form;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.TextUtils;
import android.util.AttributeSet;


/**
 * Created by Fracesuit on 2017/8/8.
 */

public class FieldEditText extends AppCompatEditText implements IFormField {

    public FieldEditText(FieldView.Builder builder, Context context) {
        super(context);
        FormInitUtil.initEditText(this, builder);
        setSingleLine(true);
         setEllipsize(TextUtils.TruncateAt.END);
        this.setPadding(10,0,0,0);
    }

    public FieldEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public String getValue() {
        return getText().toString();
    }

    @Override
    public void setVaule(String value) {
        setText(value);
        if (null!=value&&!value.equals("")) {
            setSelection(value.length());
        }
    }
}
