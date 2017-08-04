package hagai.edu.contactsproviders;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

/**
 * contacts content provider data
 */

public class ContactsDataSource {

    public  static void getContacts(Context context){
        Uri contactUri =ContactsContract.Contacts.CONTENT_URI;

        Cursor cursor = context.getContentResolver().query(contactUri , null , null , null , null);
        if (cursor == null || !cursor.moveToFirst()){
            //todo: notify listener - no result
            return;
        }
        do {
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            System.out.println(id + ")" + name);
        }while (cursor.moveToNext());

        cursor.close();



    }
    public static  void  getPhones (Context context , String id){
        //goto phones table -> aquire the phones
        Uri phonesUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
       String colNumber =  ContactsContract.CommonDataKinds.Phone.NUMBER;
        String colContactID =  ContactsContract.CommonDataKinds.Phone.CONTACT_ID;

        //string selection:
        String where = colContactID + "=?";

        //string [] selectionArgs
        String[] whereArgs = {id};

        Cursor phoneCursor = context.getContentResolver().query(
                phonesUri,
                null/*specific columns*/,
                where,
                whereArgs,
                null /*sort order */
        );

    }
    //uri
    //column names
    //object to query the uri
}
