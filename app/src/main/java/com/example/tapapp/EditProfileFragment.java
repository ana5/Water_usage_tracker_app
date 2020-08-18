package com.example.tapapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
 * {@link EditProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EditProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;



    public EditText et_fname,et_lname,et_email,et_dob,et_phone,et_address;

    String first_name, last_name,e_mail,dob,gender="Male",phone,address;

    Button save_profile;

    Button gender_male, gender_female, gender_others;


    private TextView mTextMessage,name,emailid;

    final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    final DatabaseReference user_fname = firebaseDatabase.getReference("Profile/F_Name");
    final DatabaseReference user_lname = firebaseDatabase.getReference("Profile/L_Name");
    final DatabaseReference user_dob = firebaseDatabase.getReference("Profile/DOB");
    final DatabaseReference user_email = firebaseDatabase.getReference("Profile/Email");
    final DatabaseReference user_phone_no = firebaseDatabase.getReference("Profile/Phone");
    final DatabaseReference user_gender = firebaseDatabase.getReference("Profile/Gender");
    final DatabaseReference user_address = firebaseDatabase.getReference("Profile/Address");





    public EditProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditProfileFragment newInstance(String param1, String param2) {
        EditProfileFragment fragment = new EditProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_edit_profile, container,false);


        et_fname = view.findViewById(R.id.firstname);
        et_lname = view.findViewById(R.id.lastname);
        et_email = view.findViewById(R.id.email);
        et_dob = view.findViewById(R.id.date_of_birth);
        et_phone = view.findViewById(R.id.Phone_number);
        et_address = view.findViewById(R.id.Address);

        name = view.findViewById(R.id.user_name);
        emailid = view.findViewById(R.id.user_email_id);


        gender_female = view.findViewById(R.id.gender_female);
        gender_male = view.findViewById(R.id.gender_male);
        gender_others = view.findViewById(R.id.gender_others);








        user_fname.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);

                et_fname.setText(value);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        user_lname.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);

                et_lname.setText(value);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        user_email.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);

                et_email.setText(value);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        user_phone_no.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);

                et_phone.setText(value);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        user_address.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);

                et_address.setText(value);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        user_dob.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);

                et_dob.setText(value);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        user_gender.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);

                if(value.equals("Male"))
                {
                    gender_male.setBackgroundResource(R.drawable.buttonstyledark);

                }


                else if(value.equals("Female"))
                {
                    gender_female.setBackgroundResource(R.drawable.buttonstyledark);

                }

                else if(value.equals("Others"))
                {
                    gender_others.setBackgroundResource(R.drawable.buttonstyledark);

                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });




        save_profile = view.findViewById(R.id.save_profile);


        gender_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                gender_female.setBackgroundResource(R.drawable.buttonstyledark);

                gender_others.setBackgroundResource(R.drawable.buttonstyle);
                gender_male.setBackgroundResource(R.drawable.buttonstyle);

                gender = "Female";

                user_gender.setValue("Female");



            }
        });

        gender_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gender_male.setBackgroundResource(R.drawable.buttonstyledark);

                gender_others.setBackgroundResource(R.drawable.buttonstyle);
                gender_female.setBackgroundResource(R.drawable.buttonstyle);

                gender = "Male";
                user_gender.setValue("Male");

            }
        });

        gender_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gender_others.setBackgroundResource(R.drawable.buttonstyledark);

                gender_female.setBackgroundResource(R.drawable.buttonstyle);
                gender_male.setBackgroundResource(R.drawable.buttonstyle);

                gender = "Others";

                user_gender.setValue("Others");



            }
        });


        save_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveProfile();



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






    public void saveProfile() {


        first_name = et_fname.getText().toString();
        last_name =  et_lname.getText().toString();
        e_mail =  et_email.getText().toString();
        address = et_address.getText().toString();
        phone = et_phone.getText().toString();
        dob = et_dob.getText().toString();

        FragmentTransaction ft=getFragmentManager().beginTransaction();
        ProfileFragment profileFragment =new ProfileFragment();
//using Bundle to send data
        Bundle bundle=new Bundle();
        bundle.putString("f_name",first_name);
        bundle.putString("l_name",last_name);
        bundle.putString("email",e_mail);
        profileFragment.setArguments(bundle); //data being send to SecondFragment
        ft.replace(R.id.fragment_container, profileFragment );
        ft.commit();



        user_fname.setValue(first_name);
        user_lname.setValue(last_name);
        user_dob.setValue(dob);
        user_email.setValue(e_mail);
        user_phone_no.setValue(phone);
        user_address.setValue(address);
        user_gender.setValue(gender);














    }

}
