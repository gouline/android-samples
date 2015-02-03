package net.gouline.drawablesources.app;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import net.gouline.drawablesources.model.Contact;
import net.gouline.drawablesources.model.Profile;
import net.gouline.drawablesources.model.User;
import net.gouline.drawablesources.widget.ProfileView;

public class MainActivity extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final PersonAdapter adapter = new PersonAdapter(this);
        adapter.add(new User("Green Robot", "https://cdn3.iconfinder.com/data/icons/picons-social/57/36-android-128.png"));
        adapter.add(new User("Shiny Fruit", "https://cdn3.iconfinder.com/data/icons/picons-social/57/16-apple-128.png"));
        adapter.add(new Contact("Some Dude"));
        setListAdapter(adapter);
    }

    private static class PersonAdapter extends ArrayAdapter<Profile> {
        public PersonAdapter(Context context) {
            super(context, 0);
        }

        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            final ProfileView profileView = (convertView == null) ?
                    new ProfileView(getContext()) :
                    (ProfileView) convertView;
            profileView.update(getItem(position));
            return profileView;
        }
    }
}
