package com.app.goodbusinessappsurvey;

import com.app.goodbusinessappsurvey.SkillsPOJO.skillsBean;
import com.app.goodbusinessappsurvey.brandDetailsPOJO.brandDetailsBean;
import com.app.goodbusinessappsurvey.contractorPOJO.contractorBean;
import com.app.goodbusinessappsurvey.samplePOJO.sampleBean;
import com.app.goodbusinessappsurvey.sectorPOJO.sectorBean;
import com.app.goodbusinessappsurvey.verifyPOJO.verifyBean;

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
    @POST("roshni/api/getSkills.php")
    Call<skillsBean> getSkills1(
            @Part("sector_id") String sector_id
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
            @Part("location") String location,
            @Part("bank") String bank
    );

    @Multipart
    @POST("roshni/api/getContractorById.php")
    Call<contractorBean> getContractorById(
            @Part("id") String id
    );

    @Multipart
    @POST("roshni/api/uploadSample.php")
    Call<sampleBean> uploadSample(
            @Part("user_id") String user_id,
            @Part MultipartBody.Part file1
    );

    @Multipart
    @POST("roshni/api/getSamples.php")
    Call<sampleBean> getSamples(
            @Part("user_id") String user_id
    );

    @Multipart
    @POST("roshni/api/submit_contactor.php")
    Call<com.app.goodbusinessappsurvey.contractorPOJO.contractorBean> submit_contactor(
            @Part("survey_id") String survey_id
    );

    @Multipart
    @POST("roshni/api/submit_brand.php")
    Call<com.app.goodbusinessappsurvey.contractorPOJO.contractorBean> submit_brand(
            @Part("survey_id") String survey_id
    );

    @Multipart
    @POST("roshni/api/reject_contactor.php")
    Call<com.app.goodbusinessappsurvey.contractorPOJO.contractorBean> reject_contactor(
            @Part("survey_id") String survey_id,
            @Part("reason") String reason
    );

    @Multipart
    @POST("roshni/api/reject_brand.php")
    Call<com.app.goodbusinessappsurvey.contractorPOJO.contractorBean> reject_brand(
            @Part("survey_id") String survey_id,
            @Part("reason") String reason
    );

    @Multipart
    @POST("roshni/api/deleteSample.php")
    Call<sampleBean> deleteSample(
            @Part("id") String id
    );

    @Multipart
    @POST("roshni/api/update_worker_professional3.php")
    Call<verifyBean> rejectWorkerProfessional(
            @Part("survey_id") String user_id,
            @Part("sector") String sector,
            @Part("skills") String skills,
            @Part("experience") String experience,
            @Part("employment") String employment,
            @Part("employer") String employer,
            @Part("home") String home,
            @Part("workers") String workers,
            @Part("tools") String tools,
            @Part("location") String location,
            @Part("reason") String reason,
            @Part("bank") String bank
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
            @Part("age") String age,
            @Part MultipartBody.Part file1
    );


    @Multipart
    @POST("roshni/api/update_contractor2.php")
    Call<verifyBean> update_contractor(
            @Part("user_id") String user_id,
            @Part("name") String name,
            @Part("id_proof") String id_proof,
            @Part("id_number") String id_number,
            @Part("firm_type") String firm_type,
            @Part("firm_registration_type") String firm_registration_type,
            @Part("registration_no") String registration_no,
            @Part("lat") String lat,
            @Part("lng") String lng,
            @Part("dob") String dob,
            @Part("gender") String gender,
            @Part("business_name") String business_name,
            @Part("establishment_year") String establishment_year,
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
            @Part("home_units") String home_units,
            @Part("home_location") String home_location,
            @Part("workers_male") String workers_male,
            @Part("workers_female") String workers_female,
            @Part("experience") String experience,
            @Part("work_type") String work_type,
            @Part("availability") String availability,
            @Part("employer") String employer,
            @Part("about") String about,
            @Part("sector") String sector,
            @Part MultipartBody.Part file1
    );

    @Multipart
    @POST("roshni/api/update_brand.php")
    Call<verifyBean> updateBrand(
            @Part("user_id") String user_id,
            @Part("name") String name,
            @Part("firm_type") String firm_type,
            @Part("firm_registration_type") String firm_registration_type,
            @Part("registration_number") String registration_number,
            @Part("lat") String lat,
            @Part("lng") String lng,
            @Part("sector") String sector,
            @Part("contact_details") String contact_details,
            @Part("contact_person") String contact_person,
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
            @Part("manufacturing_units") String manufacturing_units,
            @Part("factory_outlet") String factory_outlet,
            @Part("products") String products,
            @Part("country") String country,
            @Part("workers") String workers,
            @Part("certification") String certification,
            @Part("expiry") String expiry,
            @Part("website") String website,
            @Part("email") String email,
            @Part MultipartBody.Part file1
    );

    @Multipart
    @POST("roshni/api/getBrandById.php")
    Call<brandDetailsBean> getBrandById(
            @Part("id") String id
    );

}
