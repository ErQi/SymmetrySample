## SymmetryLayout ##
>一个简单的线性布局,两个TextView.被设计一会在左,一会在右,一会集体居中弄的很是蛋疼,于是有了这个小轮子.

**如何使用**
```
    <com.erqi.le.symmetry.SymmetryLayout
        android:id="@+id/symmetry"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:gravity="center"
        app:gravityLeft="right"
        app:gravityRight="left"
        app:layout_gravityLeft="center_vertical"
        app:backgroundRight="@color/colorPrimary"
        app:textColorLeft="@color/colorAccent"
        app:textColorRight="@color/colorPrimary"
        app:textLeft="我是左侧固定"
        app:textRight="我右侧变换距离"
        app:textSizeLeft="12sp"
        app:textSizeRight="18sp"/>
```
```
        symmetry = (SymmetryLayout) findViewById(R.id.symmetry);
        // 颜色,位置,大小文字相关属性太多,所以直接不规范的返回对象本体便于炒作了...
        // 获取左侧的TextView
        TextView tvLeft = symmetry.getTvLeft();
        // 获取右侧的TextView
        TextView tvRight = symmetry.getTvRight();

        // 设计布局的对齐方式
        symmetry.setLayoutGravity(SymmetryLayout.RIGHT);
```
**效果图**</br>
![](效果图.png)

**如何引用**
```
compile 'com.erqi.le:symmetry:1.0.1'
```