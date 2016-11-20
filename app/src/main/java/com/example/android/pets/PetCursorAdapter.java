package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract;

/**
 * Created by Kazlauskas on 20/11/2016.
 */

public class PetCursorAdapter extends CursorAdapter {
    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvName = (TextView) view.findViewById(R.id.name);
        TextView tvSummary = (TextView) view.findViewById(R.id.summary);

        String name = cursor.getString(cursor
                .getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_PET_NAME));
        String summary = cursor.getString(cursor
                .getColumnIndexOrThrow(PetContract.PetEntry.COLUMN_PET_BREED));

        tvName.setText(name);
        tvSummary.setText(summary);
    }

    private class ViewHolder {
        TextView name;
        TextView summary;
    }
}
