package com.example.tapapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.util.ArrayList;
import java.util.List;


import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HistoryFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */





public class HistoryFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public int iday1=150,
               iday2=200,
               iday3=300,
               iday4=250,
               iday5=350,
               iday6=500,
               iday7=450;

    private OnFragmentInteractionListener mListener;

    final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    final DatabaseReference day1 = firebaseDatabase.getReference("Water Saving/Last 7 Days Saving/1st Day");
    final DatabaseReference day2 = firebaseDatabase.getReference("Water Saving/Last 7 Days Saving/2nd Day");
    final DatabaseReference day3 = firebaseDatabase.getReference("Water Saving/Last 7 Days Saving/3rd Day");
    final DatabaseReference day4 = firebaseDatabase.getReference("Water Saving/Last 7 Days Saving/4th Day");
    final DatabaseReference day5 = firebaseDatabase.getReference("Water Saving/Last 7 Days Saving/5th Day");
    final DatabaseReference day6 = firebaseDatabase.getReference("Water Saving/Last 7 Days Saving/6th Day");
    final DatabaseReference day7 = firebaseDatabase.getReference("Water Saving/Last 7 Days Saving/7th Day");




    public HistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       View view = inflater.inflate(R.layout.fragment_history, container, false);


        PieChartView pieChartView = view.findViewById(R.id.chart);

        PieChartView pieChartView2 = view.findViewById(R.id.chart2);

        final SwipeRefreshLayout swipe_refresh_history_fragment = view.findViewById(R.id.swipe_refresh_history_fragment);



        day1.setValue(iday1);
        day2.setValue(iday2);
        day3.setValue(iday3);
        day4.setValue(iday4);
        day5.setValue(iday5);
        day6.setValue(iday6);
        day7.setValue(iday7);














        final GraphView graphView = view.findViewById(R.id.water_usage_history_graph);

        day1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                iday1 = dataSnapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        day2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                iday2 = dataSnapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        day3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                iday3 = dataSnapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        day4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                iday4 = dataSnapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        day5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                iday5 = dataSnapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        day6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                iday6 = dataSnapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        day7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                iday7 = dataSnapshot.getValue(Integer.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        final LineGraphSeries<DataPoint> lineGraphSeries = new LineGraphSeries<DataPoint>(new DataPoint[] {


                new DataPoint(1, iday1+50),
                new DataPoint(2, iday2+50),
                new DataPoint(3, iday3+50),
                new DataPoint(4, iday4+50),
                new DataPoint(5, iday5+50),
                new DataPoint(6, iday6+50),
                new DataPoint(7, iday7+50)

        });




        final PointsGraphSeries<DataPoint> pointsGraphSeries = new PointsGraphSeries<DataPoint>(new DataPoint[] {

                new DataPoint(1, iday1+50),
                new DataPoint(2, iday2+50),
                new DataPoint(3, iday3+50),
                new DataPoint(4, iday4+50),
                new DataPoint(5, iday5+50),
                new DataPoint(6, iday6+50),
                new DataPoint(7, iday7+50)

        });

        final BarGraphSeries<DataPoint> barGraphSeries = new BarGraphSeries<DataPoint>(new DataPoint[]{

                new DataPoint(1, iday1),
                new DataPoint(2, iday2),
                new DataPoint(3, iday3),
                new DataPoint(4, iday4),
                new DataPoint(5, iday5),
                new DataPoint(6, iday6),
                new DataPoint(7, iday7)


        });



        graphView.getViewport().setMinX(0);
        graphView.getViewport().setMaxX(7.5);
        graphView.getViewport().setMinY(0);
        graphView.getViewport().setMaxY(650);

        graphView.getViewport().setYAxisBoundsManual(true);
        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getGridLabelRenderer().setHorizontalAxisTitle("Past Day Number");


        graphView.getGridLabelRenderer().setNumVerticalLabels(6);
        graphView.getGridLabelRenderer().setNumHorizontalLabels(8);

        graphView.setTitle("Last Week Water Usage Analytics");
        graphView.setTitleTextSize(45);




        lineGraphSeries.setAnimated(false);
        lineGraphSeries.setColor(Color.GRAY);
        graphView.addSeries(lineGraphSeries);

        barGraphSeries.setColor(Color.parseColor("#0bcce6"));
        barGraphSeries.setDataWidth(0.6);
        graphView.addSeries(barGraphSeries);
        barGraphSeries.setAnimated(true);

        pointsGraphSeries.setColor(Color.parseColor("#0bcce6"));

        graphView.addSeries(pointsGraphSeries);













        List<SliceValue> pieData = new ArrayList<>();

        pieData.add(new SliceValue(30, Color.GRAY).setLabel("Saved : 30%L"));
        pieData.add(new SliceValue(70, Color.parseColor("#0bcce6")).setLabel("Used : 70%"));



        PieChartData pieChartData = new PieChartData(pieData);

        pieChartData.setHasLabels(true).setValueLabelTextSize(8);

        pieChartData.setHasCenterCircle(true).setCenterText1("Weekly").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));

        pieChartView.setPieChartData(pieChartData);




        List<SliceValue> pieData2 = new ArrayList<>();

        pieData2.add(new SliceValue(36, Color.GRAY).setLabel("Saved : 36%L"));
        pieData2.add(new SliceValue(64, Color.parseColor("#0bcce6")).setLabel("Used : 64%"));



        PieChartData pieChartData2 = new PieChartData(pieData2);

        pieChartData2.setHasLabels(true).setValueLabelTextSize(8);

        pieChartData2.setHasCenterCircle(true).setCenterText1("Monthly").setCenterText1FontSize(20).setCenterText1Color(Color.parseColor("#0097A7"));

        pieChartView2.setPieChartData(pieChartData2);




        swipe_refresh_history_fragment.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        swipe_refresh_history_fragment.setRefreshing(false);
                    }
                },400);
            }
        });






























        return view;
    }



   /* private void horBarChart(int count , int range)
    {

        ArrayList<BarEntry> yVal =new ArrayList<>();
        float barWidth = 6f;
        float spacebar = 18f;

        //yVal.add(new BarEntry(0*spacebar,300));
        yVal.add(new BarEntry(1*spacebar,600));
        yVal.add(new BarEntry(2*spacebar,0));


        BarDataSet set1;
        set1 = new BarDataSet(yVal,"Data Set1");

        BarData data2 = new BarData(set1);
        data2.setBarWidth(barWidth);
        horizontalBarChart.setData(data2);




    }

*/



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
