package com.example.prptypedemo.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TableLayout;

import androidx.annotation.NonNull;

import com.example.prptypedemo.Constant;
import com.example.prptypedemo.R;
import com.example.prptypedemo.model.HeaderData;

import java.util.ArrayList;
import java.util.Calendar;

public class EntryFormFragment extends BaseFragment {
    private View rootView;
    ImageView ivplus1, ivplus2, ivplus3, ivplus4, ivplus5, ivminus1, ivminus2, ivminus3, ivminus4, ivminus5,ivminus6,
     ivplus6;
    EditText editText1, editText2, editText3, editText4,editText5;
    TableLayout tableLayout;
    Spinner yearSppiner;
    Spinner monthSpiner;
    int year = 0, month = 0;
    Button buttonSave;
    private ArrayList<String> arrayListMonth;
    private ArrayList<String> arrayListYear;

    @Override
    public void onResume() {
        super.onResume();
        mListener.onFragmentUpdate(Constant.setTitle,new HeaderData(false,"सक्रिय महिला का मासिक कार्य प्रतिवेदन"));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.formenrty, container, false);
        setId();
        arrayListMonth = new ArrayList<String>();
        arrayListMonth.add("जनवरी");
        arrayListMonth.add("फ़रवरी");
        arrayListMonth.add("मार्च");
        arrayListMonth.add("अप्रैल");
        arrayListMonth.add("मई");
        arrayListMonth.add("जून");
        arrayListMonth.add("जुलाई");
        arrayListMonth.add("अगस्त");
        arrayListMonth.add("सितंबर");
        arrayListMonth.add("अक्टूबर");
        arrayListMonth.add("नवंबर");
        arrayListMonth.add("दिसंबर");
        arrayListYear = new ArrayList<>();
        arrayListYear.add("2019");
        arrayListYear.add("2020");
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        System.out.println("" + year + "fvhfdd" + month);

        ArrayAdapter<String> dataAdapterMonth = new ArrayAdapter<String>(getActivity(), R.layout.dialog_spinner_item, arrayListMonth);

        // Drop down layout style - list view with radio button
        dataAdapterMonth.setDropDownViewResource(R.layout.dialog_spinner_dropdown_item);

        // attaching data adapter to spinner
        monthSpiner.setAdapter(dataAdapterMonth);
        ArrayAdapter<String> dataAdapterYear = new ArrayAdapter<String>(getActivity(), R.layout.dialog_spinner_item, arrayListYear);

        // Drop down layout style - list view with radio button
        dataAdapterYear.setDropDownViewResource(R.layout.dialog_spinner_dropdown_item);

        // attaching data adapter to spinner
        yearSppiner.setAdapter(dataAdapterYear);
        if (year == 2019) {
            yearSppiner.setSelection(0);
        } else yearSppiner.setSelection(1);

        monthSpiner.setSelection(month);
        ivminus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setVisibility(View.GONE);
                editText2.setVisibility(View.GONE);
                editText3.setVisibility(View.GONE);
                editText4.setVisibility(View.GONE);

            }
        });
        ivminus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setVisibility(View.GONE);
                editText2.setVisibility(View.GONE);
                editText3.setVisibility(View.GONE);
                editText4.setVisibility(View.GONE);

            }
        });
        ivminus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setVisibility(View.GONE);
                editText2.setVisibility(View.GONE);
                editText3.setVisibility(View.GONE);
                editText4.setVisibility(View.GONE);
                tableLayout.setVisibility(View.GONE);

            }
        });
        ivminus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setVisibility(View.GONE);
                editText2.setVisibility(View.GONE);
                editText3.setVisibility(View.GONE);
                editText4.setVisibility(View.GONE);

            }
        });
        ivminus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setVisibility(View.GONE);
                editText2.setVisibility(View.GONE);
                editText3.setVisibility(View.GONE);
                editText4.setVisibility(View.GONE);

            }
        });

        ivplus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText1.setVisibility(View.VISIBLE);
                editText2.setVisibility(View.GONE);
                editText3.setVisibility(View.GONE);
                editText4.setVisibility(View.GONE);


            }
        });
        ivplus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText1.setVisibility(View.GONE);
                editText2.setVisibility(View.VISIBLE);
                editText3.setVisibility(View.GONE);
                editText4.setVisibility(View.GONE);


            }
        });

        ivplus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText1.setVisibility(View.GONE);
                editText2.setVisibility(View.GONE);
                editText3.setVisibility(View.GONE);
                editText4.setVisibility(View.GONE);
                tableLayout.setVisibility(View.VISIBLE);

            }
        });
        ivplus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText1.setVisibility(View.GONE);
                editText2.setVisibility(View.GONE);
                editText3.setVisibility(View.VISIBLE);
                editText4.setVisibility(View.GONE);
                tableLayout.setVisibility(View.GONE);


            }
        });
        ivplus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText1.setVisibility(View.GONE);
                editText2.setVisibility(View.GONE);
                editText3.setVisibility(View.GONE);
                editText4.setVisibility(View.VISIBLE);
                tableLayout.setVisibility(View.GONE);

            }
        });
         buttonSave.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                 builder.setCancelable(true);
                 builder.setMessage("क्या आप अपना प्रतिवेदन अंतिम रूप से दर्ज़ करना चाहते है ? ");
                 builder.setPositiveButton("हाँ", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         dialog.cancel();
                     }
                 });
                 builder.setNegativeButton("नहीं",  new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                      dialog.cancel();
                     }
                 });
                 builder.show();
             }
         });
        return rootView;
    }

    private void setId() {
        ivplus1 = rootView.findViewById(R.id.ivplus1);
        ivplus2 = rootView.findViewById(R.id.ivplus2);
        ivplus3 = rootView.findViewById(R.id.ivplus3);
        ivplus4 = rootView.findViewById(R.id.ivplus4);
        ivplus5 = rootView.findViewById(R.id.ivplus5);
        ivplus6 = rootView.findViewById(R.id.ivplus6);
        ivminus1 = rootView.findViewById(R.id.ivminus1);
        ivminus2 = rootView.findViewById(R.id.ivminus2);
        ivminus3 = rootView.findViewById(R.id.ivminus3);
        ivminus4 = rootView.findViewById(R.id.ivminus4);
        ivminus5 = rootView.findViewById(R.id.ivminus5);
        ivminus6 = rootView.findViewById(R.id.ivminus6);
        editText1 = rootView.findViewById(R.id.editText1);
        editText2 = rootView.findViewById(R.id.editText2);
        editText3 = rootView.findViewById(R.id.editText3);
        editText4 = rootView.findViewById(R.id.editText4);
        editText5 = rootView.findViewById(R.id.editText5);
        tableLayout = rootView.findViewById(R.id.tablelayout);
        monthSpiner = rootView.findViewById(R.id.sppinermonth);
        yearSppiner = rootView.findViewById(R.id.sppinerYear);
        buttonSave = rootView.findViewById(R.id.saveData);
    }

}
