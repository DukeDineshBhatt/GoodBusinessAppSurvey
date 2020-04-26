package com.app.goodbusinessappsurvey;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.goodbusinessappsurvey.sectorPOJO.sectorBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class CompletedProfessional extends Fragment {

    Spinner sector, skills, experience, employment, home, workers, looms, location;

    String sect, skil, expe, empl, hhom, work, loom, loca;

    List<String> sec, ski, exp, emp, hom, wor, loc;
    List<String> sec1, ski1, loc1;

    ProgressBar progress;

    String user_id;

    EditText employer;


    LinearLayout yes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_completed_professional, container, false);

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
        yes = view.findViewById(R.id.yes);

        user_id = SharePreferenceUtils.getInstance().getString("user_id");

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


        sector.setEnabled(false);
        skills.setEnabled(false);
        experience.setEnabled(false);
        employment.setEnabled(false);
        home.setEnabled(false);
        workers.setEnabled(false);
        looms.setEnabled(false);
        location.setEnabled(false);

        experience.setAdapter(adapter2);
        employment.setAdapter(adapter3);
        home.setAdapter(adapter4);
        workers.setAdapter(adapter5);
        looms.setAdapter(adapter5);


        Bean b = (Bean) getContext().getApplicationContext();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(b.baseurl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AllApiIneterface cr = retrofit.create(AllApiIneterface.class);

        Call<sectorBean> call = cr.getSectors();

        call.enqueue(new Callback<sectorBean>() {
            @Override
            public void onResponse(Call<sectorBean> call, Response<sectorBean> response) {

                if (response.body().getStatus().equals("1")) {

                    sec.add("Select one --- ");

                    for (int i = 0; i < response.body().getData().size(); i++) {

                        sec.add(response.body().getData().get(i).getTitle());
                        sec1.add(response.body().getData().get(i).getId());

                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                            R.layout.spinner_model, sec);

                    sector.setAdapter(adapter);

                    Log.d("sec", SharePreferenceUtils.getInstance().getString("sector"));

                    int gp = 0;
                    for (int i = 0; i < sec1.size(); i++) {
                        if (SharePreferenceUtils.getInstance().getString("sector").equals(sec1.get(i))) {
                            gp = i;
                        }
                    }


                    sector.setSelection(gp + 1);

                }

                progress.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<sectorBean> call, Throwable t) {
                progress.setVisibility(View.GONE);
            }
        });


        Call<sectorBean> call2 = cr.getSkills();

        call2.enqueue(new Callback<sectorBean>() {
            @Override
            public void onResponse(Call<sectorBean> call, Response<sectorBean> response) {


                if (response.body().getStatus().equals("1")) {

                    ski.add("Select one --- ");


                    for (int i = 0; i < response.body().getData().size(); i++) {

                        ski.add(response.body().getData().get(i).getTitle());
                        ski1.add(response.body().getData().get(i).getId());

                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                            R.layout.spinner_model, ski);

                    skills.setAdapter(adapter);

                    Log.d("sec", SharePreferenceUtils.getInstance().getString("skills"));

                    int gp = 0;
                    for (int i = 0; i < ski1.size(); i++) {
                        if (SharePreferenceUtils.getInstance().getString("skills").equals(ski1.get(i))) {
                            gp = i;
                        }
                    }


                    skills.setSelection(gp + 1);

                }

                progress.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<sectorBean> call, Throwable t) {
                progress.setVisibility(View.GONE);
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

                    Log.d("sec", SharePreferenceUtils.getInstance().getString("location"));

                    int gp = 0;
                    for (int i = 0; i < loc1.size(); i++) {
                        if (SharePreferenceUtils.getInstance().getString("location").equals(loc1.get(i))) {
                            gp = i;
                        }
                    }


                    location.setSelection(gp + 1);

                }

                progress.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<sectorBean> call, Throwable t) {
                progress.setVisibility(View.GONE);
            }
        });

        setPrevious();

        return view;
    }

    private void setPrevious() {

        /*
        int cp = 0;
        for (int i = 0; i < ski.size(); i++) {
            if (SharePreferenceUtils.getInstance().getString("skills").equals(ski.get(i))) {
                cp = i;
            }
        }
        skills.setSelection(cp);

*/
        progress.setVisibility(View.VISIBLE);

        Bean b = (Bean) getContext().getApplicationContext();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(b.baseurl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AllApiIneterface cr = retrofit.create(AllApiIneterface.class);

        Call<WorkerByIdListBean> call = cr.getWorkerById(user_id);

        call.enqueue(new Callback<WorkerByIdListBean>() {
            @Override
            public void onResponse(Call<WorkerByIdListBean> call, Response<WorkerByIdListBean> response) {

                List<WorkerByIdData> item = response.body().getData();

                employer.setText(item.get(0).getEmployer());

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
                for (int i = 0; i < loc.size(); i++) {
                    if (item.get(0).getLocation().equals(loc.get(i))) {
                        sp = i;
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