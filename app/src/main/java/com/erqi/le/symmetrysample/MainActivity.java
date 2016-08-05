package com.erqi.le.symmetrysample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.erqi.le.symmetry.SymmetryLayout;

public class MainActivity extends AppCompatActivity {
    private SymmetryLayout symmetry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        symmetry = (SymmetryLayout) findViewById(R.id.symmetry);
        // 颜色,位置,大小文字相关属性太多,所以直接不规范的返回对象本体便于炒作了...
        // 获取左侧的TextView
        TextView tvLeft = symmetry.getTvLeft();
        // 获取右侧的TextView
        TextView tvRight = symmetry.getTvRight();

        // 设计布局的对齐方式
        symmetry.setLayoutGravity(SymmetryLayout.RIGHT);
    }
}
