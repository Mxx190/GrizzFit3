package com.example.maximus.grizzfit;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class LogViewModel extends AndroidViewModel {

    public final LiveData<List<FoodLog>> logList;
    private LogDatabase logDatabase;

    public LogViewModel(Application application) {
        super(application);

        logDatabase = LogDatabase.getLogDatabase(this.getApplication());
        logList = logDatabase.logDao().getAll();
    }

    public LiveData<List<FoodLog>> getLogList(){
        return logList;
    }

    /*public void deleteItem(FoodLog log) {
        new endAsyncTask(logDatabase).execute(log);
    }

    private static class endAsyncTask extends AsyncTask<FoodLog, Void, Void> {

        private LogDatabase db;

        deleteAsyncTask(LogDatabase logDatabase) {
            db = logDatabase;
        }

        @Override
        protected Void doInBackground(final BorrowModel... params) {
            db.LogViewModel().deleteBorrow(params[0]);
            return null;
        }

    }*/



}
