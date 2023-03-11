package com.kartik.evidya.app;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class ChatApplicationApp extends Application {
    public static ChatApplicationApp mInstance;
    public static String currentFragment;

    public static final String BASE_ROOT = "http://157.245.97.87/vidhyastra";

    public static final String BASE_URL = BASE_ROOT + "/api/";

    public static final String MY_SESSION = "MySession";

    //Service Related Session Variables
    private static final String LOGIN_SESSION = "LoginSession";

    public static void setCurrentUser(UserResultEntity userResultEntity)
    {
        SharedPreferences mPrefs = mInstance.getSharedPreferences(MY_SESSION,MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();

        Gson gson =  new Gson();

        String json = gson.toJson(userResultEntity);
        prefsEditor.putString(LOGIN_SESSION,json);
        prefsEditor.commit();
    }

    public static UserResultEntity getCurrentUser(){
        SharedPreferences mPrefs = mInstance.getSharedPreferences(MY_SESSION, MODE_PRIVATE);
        Type type = new TypeToken<UserResultEntity>() {
        }.getType();
        Gson gson = new Gson();
        String json = mPrefs.getString(LOGIN_SESSION, "");
        return gson.fromJson(json, type);
    }



    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    //send bundle data with fragments
    public static void loadFragment(String fragment, Bundle bundle, FragmentManager fragmentManager)
    {
        try{
            fragmentManager.beginTransaction()
                    .replace(R.id.main_content_fragment,getInstances(fragment,bundle),fragment)
                    .addToBackStack(fragment)
                    .commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Fragment getInstances(String fragment, Bundle bundle) {
        Fragment fragmentInstance = null;
        switch (fragment)
        {
            case "SplashFragment":
                fragmentInstance = new SplashFragment();
                fragmentInstance.setArguments(bundle);
                break;

            case "TeacherFragment":
                fragmentInstance = new TeacherDashboardFragment();
                fragmentInstance.setArguments(bundle);
                break;

            case "ChatFragment":
                fragmentInstance = new ChatFragment();
                fragmentInstance.setArguments(bundle);
                break;
            case "TeacherProfile":
                fragmentInstance = new TeacherProfileFragment();
                fragmentInstance.setArguments(bundle);
                break;

            case "StudentFragment":
                fragmentInstance = new StudentDashboardFragment();
                fragmentInstance.setArguments(bundle);
                break;

            case "StudentProfile":
                fragmentInstance = new StudentProfileFragment();
                fragmentInstance.setArguments(bundle);
                break;

            default:
                break;
        }

        return fragmentInstance;
    }


    //load Fragment
    public static void loadFragment(String fragment, FragmentManager fragmentManager)
    {
        try{
            fragmentManager.beginTransaction()
                    .replace(R.id.main_content_fragment,getInstance(fragment),fragment)
                    .addToBackStack(fragment)
                    .commit();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Fragment getInstance(String fragment)
    {
        Fragment fragmentInstances = null;
        switch (fragment)
        {
            case "SplashFragment":
                fragmentInstances = new SplashFragment();
                break;

            case "LoginFragment":
                fragmentInstances = new LoginFragment();
                break;

            case "TeacherFragment":
                fragmentInstances = new TeacherDashboardFragment();
                break;

            case "StudentFragment":
                fragmentInstances = new StudentDashboardFragment();
                break;

            case "ChatFragment":
                fragmentInstances = new ChatFragment();
                break;
            case "TeacherProfile":
                fragmentInstances = new TeacherProfileFragment();
                break;

            case "StudentProfile":
                fragmentInstances = new StudentProfileFragment();
                break;
        }
        return fragmentInstances;
    }


    /***    ***/
    public static void getTitleWithBackButton(FragmentActivity activity, Toolbar toolbar, String title) {

        ((AppCompatActivity) activity).setSupportActionBar(toolbar);
        ((AppCompatActivity) activity).setTitle(title);
        ((AppCompatActivity) activity).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) activity).getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(v -> {

            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            Fragment currentFragment = fragmentManager.findFragmentById(R.id.main_content_fragment);
            if (fragmentManager.getBackStackEntryCount() == 1) {
                activity.finish();
            }/* else if(currentFragment.getTag().equals("CustomerListFragment")){
                searchView.clearFocus();
                fragmentManager.popBackStack();
            } */ else {
                fragmentManager.popBackStack();
            }

        });
    }

}
