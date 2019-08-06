package com.getbase.floatingactionbutton.sample;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.pink_icon);
        floatingActionButton.setIconFill(true);
        floatingActionButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Clicked pink Floating Action Button", Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton button = (FloatingActionButton) findViewById(R.id.setter);
        button.setSize(FloatingActionButton.SIZE_MINI);
        button.setColorNormalResId(R.color.pink);
        button.setColorPressedResId(R.color.pink_pressed);
        button.setIcon(R.drawable.ic_fab_star);
        button.setStrokeVisible(false);

        final View actionB = findViewById(R.id.action_b);

        FloatingActionButton actionC = new FloatingActionButton(getBaseContext());
        actionC.setTitle("Hide/Show Action above");
        actionC.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                actionB.setVisibility(actionB.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });

        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
//        menuMultipleActions.addButton(actionC);
        int colorAdd = Color.parseColor("#16B2EC");
        menuMultipleActions.setAddButtonColorNormal(colorAdd);
        float[] hsv = new float[3];
        Color.colorToHSV(colorAdd, hsv);
        hsv[2] = hsv[2] * 0.9f;
        int pressColor = Color.HSVToColor(hsv);
        menuMultipleActions.setAddButtonColorPressed(pressColor);


        final FloatingActionButton removeAction = (FloatingActionButton) findViewById(R.id.button_remove);
        removeAction.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FloatingActionsMenu) findViewById(R.id.multiple_actions_down)).removeButton(removeAction);
            }
        });

        ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
        drawable.getPaint().setColor(getResources().getColor(R.color.white));
        ((FloatingActionButton) findViewById(R.id.setter_drawable)).setIconDrawable(drawable);


        FloatingActionButton actionButton = new FloatingActionButton(this);
        actionButton.setBackground(getDrawable(R.drawable.icon_float_publish_pai));
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        actionButton.setCircleSize(screenWidth/8);
        menuMultipleActions.addButton(actionButton);

        final FloatingActionButton actionButtonB = (FloatingActionButton) findViewById(R.id.action_b);

        final FloatingActionButton actionButtonC = (FloatingActionButton) findViewById(R.id.action_c);

        // Test that FAMs containing FABs with visibility GONE do not cause crashes
        findViewById(R.id.button_gone).setVisibility(View.GONE);

        final FloatingActionButton actionEnable = (FloatingActionButton) findViewById(R.id.action_enable);
        actionEnable.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                menuMultipleActions.setEnabled(!menuMultipleActions.isEnabled());
            }
        });

        FloatingActionsMenu rightLabels = (FloatingActionsMenu) findViewById(R.id.right_labels);
        FloatingActionButton addedOnce = new FloatingActionButton(this);
        addedOnce.setTitle("Added once");
        rightLabels.addButton(addedOnce);

        FloatingActionButton addedTwice = new FloatingActionButton(this);
        addedTwice.setTitle("Added twice");
        rightLabels.addButton(addedTwice);
        rightLabels.removeButton(addedTwice);
        rightLabels.addButton(addedTwice);
    }
}
