package medxpert.main.daniyal_medxpert.SessionManager;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static final String PREF_NAME = "AppSession";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_CNIC = "CNIC";
    private static final String KEY_password = "CNIC";


    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setLoggedIn(boolean isLoggedIn,String cnic, String password) {
        editor.putBoolean(KEY_IS_LOGGED_IN, isLoggedIn);
        editor.putString(KEY_CNIC,cnic);
        editor.putString(KEY_password,password);
        editor.apply();
    }

    public String getCNIC(){
        return sharedPreferences.getString(KEY_CNIC,null).toString();
    }

    public String getPassword(){
        return sharedPreferences.getString(KEY_password,null).toString();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false);
    }
}
