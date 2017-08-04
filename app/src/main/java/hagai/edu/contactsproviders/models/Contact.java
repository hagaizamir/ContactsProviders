package hagai.edu.contactsproviders.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Hagai Zamir on 04-Aug-17.
 */

public class Contact implements Parcelable {
    private  String name;
    private List <String> emails;
    private  List<String> phones;

    public Contact(String name, List<String> emails, List<String> phones) {
        this.name = name;
        this.emails = emails;
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", emails=" + emails +
                ", phones=" + phones +
                '}';
    }

    public String getName() {
        return name;
    }

    public List<String> getEmails() {
        return emails;
    }

    public List<String> getPhones() {
        return phones;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeStringList(this.emails);
        dest.writeStringList(this.phones);
    }

    protected Contact(Parcel in) {
        this.name = in.readString();
        this.emails = in.createStringArrayList();
        this.phones = in.createStringArrayList();
    }

    public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel source) {
            return new Contact(source);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
}
