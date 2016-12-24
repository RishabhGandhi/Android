package silentmodetoggle.android.dummies.com.secondapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.security.PublicKey;

/**
 * Created by ADMINN on 05-10-2016.
 */

public class Hotornot {

    private static final String DATABASE_NAME="HotOrNot";
    private static final String DATABASE_TABLE="peopleTable";
    private static final int DATABASE_VERSION=1;

    public static final String KEY_ROWID="_id";
    public static final String KEY_NAME="persons_name";
    public static final String KEY_HOTNESS="persons_hotness";

    private SQLiteDatabase ourdatabse;
    private final Context ourcontext;
    private DbHelper ourhelper;



    public static class DbHelper extends SQLiteOpenHelper{


        public DbHelper(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" + KEY_ROWID +
                    " INTEGER PRIMARY KEY AUTOINCREMENT, " +KEY_NAME + " text not null, " + KEY_HOTNESS + " text not null);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists "+DATABASE_TABLE);
            onCreate(db);

        }
    }
    public Hotornot(Context c) {
        ourcontext=c;

    }
    public Hotornot open() throws SQLException{
        ourhelper=new DbHelper(ourcontext);
        ourdatabse=ourhelper.getWritableDatabase();
        return this;
    }
    public Hotornot close(){
        ourhelper.close();
        return this;
    }
    public long entry(String name,String hotness){
        ContentValues cv=new ContentValues();
        cv.put(KEY_NAME,name);
        cv.put(KEY_HOTNESS,hotness);
        return ourdatabse.insert(DATABASE_TABLE,null,cv);
    }
    public String getdata() {

        String[] colom=new String[]{KEY_ROWID,KEY_NAME,KEY_HOTNESS};
        Cursor c=ourdatabse.query(DATABASE_TABLE,colom,null,null,null,null,null);
        String result="";
        int iRow=c.getColumnIndex(KEY_ROWID);
        int iName=c.getColumnIndex(KEY_NAME);
        int iHotness=c.getColumnIndex(KEY_HOTNESS);

        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            result=result+c.getString(iRow)+" "+c.getString(iName)+" "+c.getString(iHotness)+"\n";
        }
        return result;
    }
    public String getname(Long l) {
        String[] colom=new String[]{KEY_ROWID,KEY_NAME,KEY_HOTNESS};
        Cursor c=ourdatabse.query(DATABASE_TABLE,colom,KEY_ROWID+"="+l,null,null,null,null);
        if(c!=null)
        {
            c.moveToFirst();
            String name=c.getString(1);
            return name;
        }
        return null;
    }

    public String gethotness(Long l) {
        String[] colom=new String[]{KEY_ROWID,KEY_NAME,KEY_HOTNESS};
        Cursor c=ourdatabse.query(DATABASE_TABLE,colom,KEY_ROWID+"="+l,null,null,null,null);
        if(c!=null)
        {
            c.moveToFirst();
            String hotness=c.getString(2);
            return hotness;
        }
        return null;
    }
    public void updateentry(Long l1, String names, String hotnes1) {
        ContentValues cv1=new ContentValues();
        cv1.put(KEY_NAME,names);
        cv1.put(KEY_HOTNESS,hotnes1);
        ourdatabse.update(DATABASE_TABLE,cv1,KEY_ROWID+"="+l1,null);
    }
    public void deleteentry(Long l11) {
        ourdatabse.delete(DATABASE_TABLE,KEY_ROWID+"="+l11,null);
    }




}
