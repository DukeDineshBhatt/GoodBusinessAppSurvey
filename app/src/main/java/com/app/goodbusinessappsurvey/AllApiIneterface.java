package com.app.goodbusinessappsurvey;

import com.app.goodbusinessappsurvey.sectorPOJO.sectorBean;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface AllApiIneterface {


    @Multipart
    @POST("roshni/api/login2.php")
    Call<verifyBean> login(
            @Part("username") String username,
            @Part("password") String password
    );

    @Multipart
    @POST("roshni/api/getOngoingSurveys.php")
    Call<OngoingListBean> getOngoingSurvey(
            @Part("officer_id") String officer_id

    );

    @Multipart
    @POST("roshni/api/getCompletedSurveys.php")
    Call<CompletedListBean> getCompletedSurvey(
            @Part("officer_id") String officer_id

    );

    @Multipart
    @POST("roshni/api/getWorkerById.php")
    Call<WorkerByIdListBean> getWorkerById(
            @Part("id") String id

    );

    @Multipart
    @POST("roshni/api/update_worker_professional2.php")
    Call<verifyBean> updateWorkerProfessional(
            @Part("survey_id") String user_id,
            @Part("sector") String sector,
            @Part("skills") String skills,
            @Part("experience") String experience,
            @Part("employment") String employment,
            @Part("employer") String employer,
            @Part("home") String home,
            @Part("workers") String workers,
            @Part("tools") String tools,
            @Part("location") String location
    );

    @GET("roshni/api/getSectors.php")
    Call<sectorBean> getSectors();

    @GET("roshni/api/getSkills.php")
    Call<sectorBean> getSkills();

    @GET("roshni/api/getLocations.php")
    Call<sectorBean> getLocations();


    @Multipart
    @POST("roshni/api/update_worker_personal.php")
    Call<verifyBean> updateWorkerPersonal(
            @Part("user_id") String user_id,
            @Part("name") String name,
            @Part("id_proof") String id_proof,
            @Part("id_number") String id_number,
            @Part("lat") String lat,
            @Part("lng") String lng,
            @Part("dob") String dob,
            @Part("gender") String gender,
            @Part("cpin") String cpin,
            @Part("cstate") String cstate,
            @Part("cdistrict") String cdistrict,
            @Part("carea") String carea,
            @Part("cstreet") String cstreet,
            @Part("ppin") String ppin,
            @Part("pstate") String pstate,
            @Part("pdistrict") String pdistrict,
            @Part("parea") String parea,
            @Part("pstreet") String pstreet,
            @Part("category") String category,
            @Part("religion") String religion,
            @Part("educational") String educational,
            @Part("marital") String marital,
            @Part("children") String children,
            @Part("belowsix") String belowsix,
            @Part("sixtofourteen") String sixtofourteen,
            @Part("fifteentoeighteen") String fifteentoeighteen,
            @Part("goingtoschool") String goingtoschool,
            @Part MultipartBody.Part file1
    );

}
