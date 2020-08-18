package com.example.tapapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;



    public TextView tv_name,tv_email,tv_dob,tv_phone,tv_address;

    String first_name, last_name,e_mail,dob,gender,phone,address;


    private TextView mTextMessage,name,emailid;

    final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    final DatabaseReference user_fname = firebaseDatabase.getReference("Profile/F_Name");
    final DatabaseReference user_lname = firebaseDatabase.getReference("Profile/L_Name");
    final DatabaseReference user_dob = firebaseDatabase.getReference("Profile/DOB");
    final DatabaseReference user_email = firebaseDatabase.getReference("Profile/Email");
    final DatabaseReference user_phone_no = firebaseDatabase.getReference("Profile/Phone");
    final DatabaseReference user_gender = firebaseDatabase.getReference("Profile/Gender");
    final DatabaseReference user_address = firebaseDatabase.getReference("Profile/Address");



    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_profile, container,false);

        final TextView name,emailid;

        tv_name = view.findViewById(R.id.user_name);
        tv_email = view.findViewById(R.id.user_email_id);
        tv_phone = view.findViewById(R.id.user_phone_number);
        tv_address = view.findViewById(R.id.user_address);




        /*Bundle bundle = getArguments();
        tv_name.setText(String.valueOf(bundle.getString("f_name","Sumit"))+" "+String.valueOf(bundle.getString("l_name","Verma")));
        tv_email.setText(String.valueOf(bundle.getString("email","sumitverma7@gmail.com")));*/




        user_fname.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);

                first_name = value;



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        user_lname.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);

                last_name = value;
                
                tv_name.setText(first_name+" "+last_name);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        user_email.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);

                tv_email.setText(value);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        user_phone_no.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);

                tv_phone.setText(value);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        user_address.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);

                tv_address.setText(value);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });







        return view;



    }

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
