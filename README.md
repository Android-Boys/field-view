# field-view
封装的控件，用于信息采集
``` xml
<declare-styleable name="FieldView" tools:ignore="ResourceName">
        <attr name="comm_labelTextSize" format="dimension"/> <!--左边文字的大小-->
        <attr name="comm_labelWidth" format="dimension"/>    <!--左边文字的宽度-->
        <attr name="comm_labelTextColor" format="reference"/><!--左边文字颜色-->
        <attr name="comm_labelBgColor" format="reference"/><!--左边文字背景-->
        <attr name="comm_label_name" format="string"/><!--左边文字内容-->

        <attr name="comm_line_half_show" format="boolean"/><!--左边文字 和右边文字  中间竖线-->
        <attr name="comm_field_index" format="integer"/> <!--这个控件的上下排序  大的在后-->
        <attr name="comm_edittext_hint" format="string"/> <!--右边editText的提示-->
        <attr name="comm_edittext_line" format="integer"/><!--右边editText的行数-->
        <attr name="comm_must" format="boolean"/><!--右边editText是否必填-->
        <attr name="comm_showMustInput" format="boolean"/>
        <attr name="comm_field_name" format="string"/> <!--key-->
        <attr name="comm_init_content" format="string"/>
        <attr name="comm_warnMessager" format="string"/>
        <attr name="comm_textIcon" format="reference"/> <!--右边控件  右边的小图标-->
        <attr name="comm_contentType" format="enum">  <!--右边控件的类型。TextView/EditText/RadioButton-->
            <enum name="TYPE_EDITTEXT" value="1"/>
            <enum name="TYPE_TEXTVIEW" value="2"/>
            <enum name="TYPE_RADIOGROUP" value="3"/>
            <enum name="TYPE_SPINNER" value="4"/>
            <enum name="TYPE_HIDDENVIEW" value="5"/>
        </attr>
        <attr name="comm_labelWithMustIcon" format="boolean"/> <!--左边控件 会带有一个*，表示必填-->
        <attr name="comm_fieldViewBgColor" format="reference"/>
        <attr name="comm_valueTextSize" format="dimension"/>
        <attr name="comm_valueBgColor" format="reference"/>
        <attr name="comm_valueTextColor" format="reference"/>
        <attr name="comm_dividedColor" format="reference"/> <!-- FieldView地步分割线的颜色-->
        <attr name="comm_fieldDivided" format="boolean"/><!-- 右边控件底部 是否需要横线-->
        <attr name="comm_formDivided" format="boolean"/> <!--true FieldView控件底部整个都要有横线，false 底部没得横线-->
        <attr name="comm_formHorizontal" format="boolean"/>
    </declare-styleable>

```
以上就是支持的属性。


一般提交数据会进行校对是否有些字段没有填写，通过遍历layout的子view，进而逐个检查。方法如下：
``` java


checkMustInput(findViewById(android.R.id.content)

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
    ```
