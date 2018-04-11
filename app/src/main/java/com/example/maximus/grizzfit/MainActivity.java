package com.example.maximus.grizzfit;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment SetGoalFragment;
    private Fragment HomeFragment;
    private Fragment CurrentFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getFragmentManager();
        SetGoalFragment = new Set_Goal_Controller();
        HomeFragment = new Home();

        //setTitle("Home");
        fragmentManager.beginTransaction().add(R.id.fram, new Home()).commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_home) {

            ScreenPicker(new Home());


//            setTitle("Home");
//            Home HomeFragment = new Home();
//            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.fram, HomeFragment, "Home");
//            fragmentTransaction.commit();

        } else if (id == R.id.nav_bmi) {



            ScreenPicker(new BMI());


//            setTitle("BMI Calculator");
//            BMI BMIfragment = new BMI();
//            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.fram, BMIfragment, "BMI");
//            fragmentTransaction.commit();

        } else if (id == R.id.nav_f2) {

            ScreenPicker(new Enter_Body_Info());



//            setTitle("Body Info");
//            Enter_Body_Info Enter_Body_Info_fragment = new Enter_Body_Info();
//            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.fram, Enter_Body_Info_fragment, "Enter_Body_Info");
//            fragmentTransaction.commit();

        } else if (id == R.id.nav_f3) {


            if (!SetGoalFragment.isAdded()){

                fragmentManager.beginTransaction().add(R.id.fram, SetGoalFragment)
                        .hide(SetGoalFragment)
                        .commit();

                System.out.println("This is being called!!!!!!!");

            }

            if(CurrentFragment != null) {
                    fragmentManager.beginTransaction()
                            .show(SetGoalFragment)
                            .detach(CurrentFragment)
                            .commit();
                    CurrentFragment = null;
                }else{
                    fragmentManager.beginTransaction()
                            .show(SetGoalFragment)
                            .commit();
                }






//            Fragment frag = new Set_Goal_Controller();
//            setTitle("Set Goal");
//            Set_Goal_Controller SetGoalFragment = new Set_Goal_Controller();
//            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.fram, SetGoalFragment, "Set_Goal_Controller");
//            fragmentTransaction.commit();


        } else if (id == R.id.nav_f4) {

            ScreenPicker(new Steps_Counter());


//            setTitle("Step Counter");
//            Steps_Counter Step_Counter_fragment = new Steps_Counter();
//            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.fram, Step_Counter_fragment, "Step Counter");
//            fragmentTransaction.commit();

        } else if (id == R.id.nav_f5) {

            ScreenPicker(new Send_Feedback());


//            setTitle("Send Feedback");
//            Send_Feedback sendFeedbackFragment = new Send_Feedback();
//            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.fram, sendFeedbackFragment, "Send Feedback");
//            fragmentTransaction.commit();

        }
        else if (id == R.id.nav_view) {

            ScreenPicker(new Fragment_ViewLog());


//            setTitle("View Log");
//            Fragment_ViewLog ViewLogFragment = new Fragment_ViewLog();
//            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.fram, ViewLogFragment, "Fragment_ViewLog");
//            fragmentTransaction.commit();
        }

        else if (id == R.id.nav_food) {

            ScreenPicker(new AddFoodItem());


//            setTitle("Create Food");
//            AddFoodItem CreateFoodfragment = new AddFoodItem();
//            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.fram, CreateFoodfragment, "AddFoodItem");
//            fragmentTransaction.commit();
        }

        else if (id == R.id.nav_food) {

            ScreenPicker(new AddFoodItem());


//            setTitle("Create Food");
//            AddFoodItem CreateFoodfragment = new AddFoodItem();
//            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.fram, CreateFoodfragment, "AddFoodItem");
//            fragmentTransaction.commit();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void ScreenPicker(Fragment NewFrag){
        FragmentManager fragmentManager = getFragmentManager();

        if (!NewFrag.isAdded()){

            if (CurrentFragment == null) {
                fragmentManager.beginTransaction()
                        .add(R.id.fram, NewFrag)
                        .hide(SetGoalFragment)
                        .commit();
                CurrentFragment = NewFrag;
            } else {
                if (CurrentFragment != NewFrag) {
                    fragmentManager.beginTransaction()
                            .detach(CurrentFragment)
                            .add(R.id.fram, NewFrag)
                            .hide(SetGoalFragment)
                            .commit();
                    CurrentFragment = NewFrag;
                }
            }



        } else {


            System.out.println("Its running here");

            if (CurrentFragment == null) {
                fragmentManager.beginTransaction()
                        .show(NewFrag)
                        .hide(SetGoalFragment)
                        .commit();
                CurrentFragment = NewFrag;
            } else {
                if (CurrentFragment != NewFrag) {
                    System.out.println("Its running and here");
                    fragmentManager.beginTransaction()
                            .detach(CurrentFragment)
                            .show(NewFrag)
                            .hide(SetGoalFragment)
                            .commit();
                    CurrentFragment = NewFrag;
                }

                System.out.println("Its running right here");
            }






        }




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("resume");
        // resume tasks
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }


}
