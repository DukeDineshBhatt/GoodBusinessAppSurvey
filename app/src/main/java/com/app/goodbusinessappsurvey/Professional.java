package com.app.goodbusinessappsurvey;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.goodbusinessappsurvey.SkillsPOJO.skillsBean;
import com.app.goodbusinessappsurvey.sectorPOJO.sectorBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Professional extends Fragment {

    Spinner sector, skills, experience, employment, home, workers, looms, location;

    String sect, skil, expe, empl, hhom, work, loom, loca;

    List<String> sec, ski, exp, emp, hom, wor, loc;
    List<String> sec1, ski1, loc1;

    ProgressBar progress;

    EditText employer;
    String id, profile_id;
    boolean loc_bool = false;

    Button reject, approve;
    EditText editTxtLoc;
    LinearLayout yes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.professional_layout, container, false);

        sec = new ArrayList<>();
        ski = new ArrayList<>();
        exp = new ArrayList<>();
        emp = new ArrayList<>();
        hom = new ArrayList<>();
        wor = new ArrayList<>();
        loc = new ArrayList<>();

        loc1 = new ArrayList<>();
        sec1 = new ArrayList<>();
        ski1 = new ArrayList<>();

        sector = view.findViewById(R.id.sector);
        skills = view.findViewById(R.id.skills);
        experience = view.findViewById(R.id.experience);
        employment = view.findViewById(R.id.employment);
        home = view.findViewById(R.id.home);
        workers = view.findViewById(R.id.workers);
        looms = view.findViewById(R.id.looms);
        location = view.findViewById(R.id.location);
        progress = view.findViewById(R.id.progress);
        employer = view.findViewById(R.id.employer);
        reject = view.findViewById(R.id.reject);
        approve = view.findViewById(R.id.approve);
        yes = view.findViewById(R.id.yes);
        editTxtLoc = view.findViewById(R.id.editTxtLoc);

        id = SharePreferenceUtils.getInstance().getString("user_id");
        profile_id = SharePreferenceUtils.getInstance().getString("profile_id");

        exp.add("Select one --- ");
        exp.add("0 to 2 years");
        exp.add("3 to 5 years");
        exp.add("5 to 10 years");
        exp.add("more than 10 years");

        emp.add("Select one --- ");
        emp.add("Employed");
        emp.add("Unemployed");

        hom.add("Select one --- ");
        hom.add("Yes");
        hom.add("No");

        wor.add("Select one --- ");
        wor.add("1");
        wor.add("2");
        wor.add("3");
        wor.add("4");
        wor.add("5");
        wor.add("6");
        wor.add("7");
        wor.add("8");
        wor.add("9");
        wor.add("10");
        wor.add("11");
        wor.add("12");
        wor.add("13");
        wor.add("14");
        wor.add("15");
        wor.add("16");
        wor.add("17");
        wor.add("18");
        wor.add("19");
        wor.add("20");


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getContext(),
                R.layout.spinner_model, exp);

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getContext(),
                R.layout.spinner_model, emp);

        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getContext(),
                R.layout.spinner_model, hom);

        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(getContext(),
                R.layout.spinner_model, wor);


        experience.setAdapter(adapter2);
        employment.setAdapter(adapter3);
        home.setAdapter(adapter4);
        workers.setAdapter(adapter5);
        looms.setAdapter(adapter5);


        experience.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i > 0) {
                    expe = exp.get(i);
                } else {
                    expe = "";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        skills.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i > 0) {
                    skil = ski1.get(i - 1);
                } else {
                    skil = "";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        employment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i > 0) {
                    empl = emp.get(i);
                } else {
                    empl = "";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        home.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i > 0) {
                    hhom = hom.get(i);

                    if (hhom.equals("Yes")) {

                        yes.setVisibility(View.VISIBLE);

                    } else {

                        yes.setVisibility(View.GONE);
                        work = "0";
                        loom = "0";
                    }

                } else {
                    hhom = "";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        workers.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i > 0) {
                    work = wor.get(i);
                } else {
                    work = "";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        looms.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i > 0) {
                    loom = wor.get(i);
                } else {
                    loom = "";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                loca = loc.get(i);

                if (i == 4) {

                    loc_bool = true;

                    editTxtLoc.setVisibility(View.VISIBLE);


                } else {

                    loc_bool = false;
                    editTxtLoc.setVisibility(View.GONE);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emplo = employer.getText().toString();

                if (loc_bool) {

                    loca = editTxtLoc.getText().toString();
                }

                if (sect.length() > 0) {

                    if (skil.length() > 0) {
                        if (expe.length() > 0) {
                            if (empl.length() > 0) {
                                if (hhom.length() > 0) {
                                    if (work.length() > 0) {
                                        if (loom.length() > 0) {
                                            if (loca.length() > 0) {


                                                progress.setVisibility(View.VISIBLE);

                                                Bean b = (Bean) getContext().getApplicationContext();

                                                Retrofit retrofit = new Retrofit.Builder()
                                                        .baseUrl(b.baseurl)
                                                        .addConverterFactory(ScalarsConverterFactory.create())
                                                        .addConverterFactory(GsonConverterFactory.create())
                                                        .build();

                                                AllApiIneterface cr = retrofit.create(AllApiIneterface.class);

                                                Call<verifyBean> call = cr.updateWorkerProfessional(
                                                        profile_id,
                                                        sect,
                                                        skil,
                                                        expe,
                                                        empl,
                                                        emplo,
                                                        hhom,
                                                        work,
                                                        loom,
                                                        loca
                                                );

                                                call.enqueue(new Callback<verifyBean>() {
                                                    @Override
                                                    public void onResponse(Call<verifyBean> call, Response<verifyBean> response) {

                                                        if (response.body().getStatus().equals("1")) {
                                                            Data item = response.body().getData();

                                                            Intent intent = new Intent(getContext(), Profile.class);
                                                            startActivity(intent);
                                                            getActivity().finish();


                                                            Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                                        } else {
                                                            Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                                        }


                                                        progress.setVisibility(View.GONE);

                                                    }

                                                    @Override
                                                    public void onFailure(Call<verifyBean> call, Throwable t) {
                                                        progress.setVisibility(View.GONE);
                                                    }
                                                });


                                            } else {
                                                Toast.makeText(getContext(), "Invalid location", Toast.LENGTH_SHORT).show();
                                            }
                                        } else {
                                            Toast.makeText(getContext(), "Invalid no. of looms", Toast.LENGTH_SHORT).show();
                                        }

                                    } else {
                                        Toast.makeText(getContext(), "Invalid no. of workers", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(getContext(), "Invalid home based unit", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getContext(), "Invalid employment status", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getContext(), "Invalid experience", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getContext(), "Invalid skill", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Invalid sector", Toast.LENGTH_SHORT).show();
                }

            }
        });


        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                forceOpen();


            }
        });


        return view;
    }

    public void forceOpen() {

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());

        alert.setTitle("Reason for rejecting this profile?");

        // Set an EditText view to get user input
        final EditText input = new EditText(getContext());
        input.setHint("tab to enter");
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                String value = input.getText().toString();

                if (value != null) {

                    progress.setVisibility(View.VISIBLE);


                    String emplo = employer.getText().toString();

                    if (loc_bool) {

                        loca = editTxtLoc.getText().toString();
                    }

                    if (sect.length() > 0) {
                        if (skil.length() > 0) {
                            if (expe.length() > 0) {
                                if (empl.length() > 0) {
                                    if (hhom.length() > 0) {
                                        if (work.length() > 0) {
                                            if (loom.length() > 0) {
                                                if (loca.length() > 0) {

                                                    progress.setVisibility(View.VISIBLE);

                                                    Bean b = (Bean) getContext().getApplicationContext();

                                                    Retrofit retrofit = new Retrofit.Builder()
                                                            .baseUrl(b.baseurl)
                                                            .addConverterFactory(ScalarsConverterFactory.create())
                                                            .addConverterFactory(GsonConverterFactory.create())
                                                            .build();

                                                    AllApiIneterface cr = retrofit.create(AllApiIneterface.class);

                                                    Call<verifyBean> call = cr.rejectWorkerProfessional(
                                                            profile_id,
                                                            sect,
                                                            skil,
                                                            expe,
                                                            empl,
                                                            emplo,
                                                            hhom,
                                                            work,
                                                            loom,
                                                            loca,
                                                            value
                                                    );

                                                    call.enqueue(new Callback<verifyBean>() {
                                                        @Override
                                                        public void onResponse(Call<verifyBean> call, Response<verifyBean> response) {

                                                            if (response.body().getStatus().equals("1")) {
                                                                Data item = response.body().getData();

                                                                Intent intent = new Intent(getContext(), Profile.class);
                                                                startActivity(intent);
                                                                getActivity().finish();


                                                                Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                                            } else {
                                                                Toast.makeText(getContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                                            }


                                                            progress.setVisibility(View.GONE);

                                                        }

                                                        @Override
                                                        public void onFailure(Call<verifyBean> call, Throwable t) {
                                                            progress.setVisibility(View.GONE);
                                                        }
                                                    });

                                                } else {
                                                    Toast.makeText(getContext(), "Invalid location", Toast.LENGTH_SHORT).show();
                                                }
                                            } else {
                                                Toast.makeText(getContext(), "Invalid no. of looms", Toast.LENGTH_SHORT).show();
                                            }

                                        } else {
                                            Toast.makeText(getContext(), "Invalid no. of workers", Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        Toast.makeText(getContext(), "Invalid home based unit", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(getContext(), "Invalid employment status", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getContext(), "Invalid experience", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getContext(), "Invalid skill", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getContext(), "Invalid sector", Toast.LENGTH_SHORT).show();
                    }

                } else {

                    Toast.makeText(getContext(), "Invalid Reason ", Toast.LENGTH_SHORT).show();

                }

            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
                progress.setVisibility(View.GONE);
            }
        });

        alert.show();
        progress.setVisibility(View.GONE);
    }


    @Override
    public void onResume() {
        super.onResume();

        progress.setVisibility(View.VISIBLE);

        Bean b = (Bean) getContext().getApplicationContext();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(b.baseurl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final AllApiIneterface cr = retrofit.create(AllApiIneterface.class);

        Call<sectorBean> call = cr.getSectors();

        call.enqueue(new Callback<sectorBean>() {
            @Override
            public void onResponse(Call<sectorBean> call, Response<sectorBean> response) {


                if (response.body().getStatus().equals("1"))
                {
                    sec.add("Select one --- ");

                    for (int i = 0; i < response.body().getData().size(); i++) {

                        sec.add(response.body().getData().get(i).getTitle());
                        sec1.add(response.body().getData().get(i).getId());

                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                            R.layout.spinner_model, sec);

                    sector.setAdapter(adapter);

                }

                progress.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<sectorBean> call, Throwable t) {
                progress.setVisibility(View.GONE);
            }
        });

        sector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i > 0) {

                    sect = sec1.get(i - 1);

                    Call<skillsBean> call2 = cr.getSkills1(sect);
                    call2.enqueue(new Callback<skillsBean>() {
                        @Override
                        public void onResponse(Call<skillsBean> call, Response<skillsBean> response) {


                            if (response.body().getStatus().equals("1")) {

                                ski.clear();

                                ski.add("Select one --- ");

                                for (int i = 0; i < response.body().getData().size(); i++) {

                                    ski.add(response.body().getData().get(i).getTitle());
                                    ski1.add(response.body().getData().get(i).getId());

                                }

                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                                        R.layout.spinner_model, ski);

                                skills.setAdapter(adapter);

                            }

                            progress.setVisibility(View.GONE);

                        }

                        @Override
                        public void onFailure(Call<skillsBean> call, Throwable t) {
                            progress.setVisibility(View.GONE);
                        }
                    });


                } else {

                    sect = "";
                    ski.clear();
                    ski.add("Select one --- ");
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                            R.layout.spinner_model, ski);


                    skills.setAdapter(adapter);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Call<sectorBean> call3 = cr.getLocations();

        call3.enqueue(new Callback<sectorBean>() {
            @Override
            public void onResponse(Call<sectorBean> call, Response<sectorBean> response) {

                if (response.body().getStatus().equals("1")) {

                    loc.add("Select one --- ");

                    for (int i = 0; i < response.body().getData().size(); i++) {

                        loc.add(response.body().getData().get(i).getTitle());
                        loc1.add(response.body().getData().get(i).getId());

                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                            R.layout.spinner_model, loc);

                    location.setAdapter(adapter);

                }

            }

            @Override
            public void onFailure(Call<sectorBean> call, Throwable t) {
                progress.setVisibility(View.GONE);
            }
        });

        setPrevious();

    }

    private void setPrevious() {

        progress.setVisibility(View.VISIBLE);

        Bean b = (Bean) getContext().getApplicationContext();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(b.baseurl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AllApiIneterface cr = retrofit.create(AllApiIneterface.class);

        Call<WorkerByIdListBean> call = cr.getWorkerById(id);

        call.enqueue(new Callback<WorkerByIdListBean>() {
            @Override
            public void onResponse(Call<WorkerByIdListBean> call, Response<WorkerByIdListBean> response) {

                List<WorkerByIdData> item = response.body().getData();

                employer.setText(item.get(0).getEmployer());

                int sc = 0;
                for (int i = 0; i < sec1.size(); i++) {
                    if (item.get(0).getSector().equals(sec1.get(i))) {
                        sc = i;
                    }
                }

                sector.setSelection(sc + 1);

             /*   int sk = 0;
                for (int i = 0; i < ski.size(); i++) {
                    if (item.get(0).getSkills().equals(ski.get(i))) {
                        sc = i;
                    }
                }
                skills.setSelection(sk);*/

                int rp = 0;
                for (int i = 0; i < exp.size(); i++) {
                    if (item.get(0).getExperience().equals(exp.get(i))) {
                        rp = i;
                    }
                }
                experience.setSelection(rp);

                int mp = 0;
                for (int i = 0; i < emp.size(); i++) {
                    if (item.get(0).getEmployment().equals(emp.get(i))) {
                        mp = i;
                    }
                }
                employment.setSelection(mp);

                int ep = 0;
                for (int i = 0; i < hom.size(); i++) {
                    if (item.get(0).getHome().equals(hom.get(i))) {
                        ep = i;
                    }
                }
                home.setSelection(ep);

                int chp = 0;
                for (int i = 0; i < wor.size(); i++) {
                    if (item.get(0).getWorkers().equals(wor.get(i))) {
                        chp = i;
                    }
                }
                workers.setSelection(chp);

                int bp = 0;
                for (int i = 0; i < wor.size(); i++) {
                    if (item.get(0).getTools().equals(wor.get(i))) {
                        bp = i;
                    }
                }
                looms.setSelection(bp);

                int sp = 0;
                for (int i = 0; i < loc1.size(); i++) {

                    if (item.get(0).getLocation().equals(loc1.get(i))) {
                        sp = i;
                        editTxtLoc.setText("");
                        editTxtLoc.setVisibility(View.GONE);
                        break;
                    } else {
                        editTxtLoc.setVisibility(View.VISIBLE);
                        editTxtLoc.setText(item.get(0).getLocation());
                        sp = 5;
                    }

                }
                location.setSelection(sp);

                progress.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<WorkerByIdListBean> call, Throwable t) {
                progress.setVisibility(View.GONE);
            }
        });


    }


}