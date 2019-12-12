package com.example.prptypedemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.example.prptypedemo.fragment.EntryFormFragment;
import com.example.prptypedemo.fragment.HomeFragment;
import com.example.prptypedemo.listener.OnFragmentInteractionListener;
import com.example.prptypedemo.model.HeaderData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {
    private FragmentManager mFragmentManager;
    private String mFragmentTag;
    private int mCurrentFragment;
    Toolbar toolbar_home;
    TextView textheader;

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar_home = findViewById(R.id.toolbar_home);
        textheader = findViewById(R.id.toolbar_title);
        onFragmentInteraction(Constant.HOME_FRAGMENT,null);


    }
    @Override
    public void onFragmentInteraction(int fragmentId, Object data) {
        mFragmentManager = getSupportFragmentManager();
        mCurrentFragment = fragmentId;
        mFragmentTag = String.valueOf(fragmentId);
        switch (fragmentId) {
            case Constant.HOME_FRAGMENT:
                mFragmentManager.beginTransaction().addToBackStack(mFragmentTag).replace(R.id.fragment_main, new HomeFragment(), mFragmentTag).commitAllowingStateLoss();
                break;
            case Constant.ENTRY_FORM_FRAGNMENT:
                mFragmentManager.beginTransaction().addToBackStack(mFragmentTag).replace(R.id.fragment_main, new EntryFormFragment(), mFragmentTag).commitAllowingStateLoss();
                break;
        }

    }

    @Override
    public void onFragmentUpdate(int type, Object data) {
        switch (type) {
            case Constant.setTitle:
                HeaderData headerData = (HeaderData) data;
                textheader.setVisibility(View.VISIBLE);
                textheader.setText(headerData.getText());
                break;
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count <= 1) {
            closeApp();
        } else
            super.onBackPressed();

    }

    public void closeApp() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(getString(R.string.exit_message));

        alertDialogBuilder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public  Boolean copyFile(File sourceFile, File destFile)
            throws IOException {
        //        if (!destFile.exists()) {
        destFile.createNewFile();

        FileChannel source = null;
        FileChannel destination = null;
        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        } finally {
            if (source != null)
                source.close();
            if (destination != null)
                destination.close();
        }
        return true;
        //        }
        //        return false;
    }

   /* public void gotoHomePage() {
        try {
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            onFragmentInteraction(Constant.HOME_FRAGMENT, false);
        } catch (Exception e) {
        }
    }*/

   /* private void copyDatabase() throws IOException {

        File actualFile = new File(new SugarDb(MainActivity.this).getDB().getPath());
        File cuurentfile = new File(actualFile.toString());
        Log.e("actualPath", "vsfkvsk" + actualFile.toString());


        File newFile = createTempFile("sugarFiles", ".db", Environment.getExternalStorageDirectory());

        Log.e("newPath", "gbgkjfdk" + newFile.toString());

        boolean yes = copyFile(cuurentfile, newFile);

        if (yes) {
            Log.e("result", "" + true);
        }

    }*/

}
