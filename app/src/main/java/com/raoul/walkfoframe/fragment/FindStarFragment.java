package com.raoul.walkfoframe.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;


import com.raoul.walkfoframe.R;


import java.util.ArrayList;
import java.util.List;


public class FindStarFragment extends Fragment {
//    ProgressDialog mProgressDialog;
//    private EventAdapter adapter;
//    public List<Event> data = null;
//    ListView eventlistView;
//    Button createevent;
//    List<ParseObject> ob;
//    ArrayList<String> users;
//    String userString;
    Spinner filterspinner;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_findstar_layout, container, false);
        filterspinner=(Spinner)v.findViewById(R.id.filter_spinner);
        List<String> list = new ArrayList<String>();
        list.add("First Name");
        list.add("Last Name");
        list.add("Birthday");
        list.add("Education");
        list.add("Induction Date");
        list.add("Favorites");
        list.add("Live Performance");
        list.add("Motion Pictures");
        list.add("Radio");
        list.add("Recording");
        list.add("Television");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.spinner_values, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        filterspinner.setAdapter(dataAdapter);
        setRetainInstance(true);
//        new RemoteDataTask().execute();
        return v;
    }



//    private class RemoteDataTask extends AsyncTask<Void, Void, Void> {
//        @Override
//        protected void onPreExecute() {
//            super.onPreExecute();
//            // Create a progressdialog
//            mProgressDialog = new ProgressDialog(getActivity());
//            // Set progressdialog title
//            mProgressDialog.setTitle("Message");
//            // Set progressdialog message
//            mProgressDialog.setMessage("Loading...");
//            mProgressDialog.setIndeterminate(false);
//            // Show progressdialog
//            mProgressDialog.show();
//        }
//
//        @Override
//        protected Void doInBackground(Void... params) {
//            // Create the array
//            data = new ArrayList<Event>();
//
//            try {
//                ParseQuery<ParseObject> eventQuery = ParseQuery.getQuery("Event");
////                photosFromCurrentUserQuery.whereEqualTo("user", ParseUser.getCurrentUser());
////                photosFromCurrentUserQuery.whereExists("image");
//                eventQuery.orderByDescending("createdAt");
//                eventQuery.include("user");
//                ob = eventQuery.find();
//                for (ParseObject event : ob) {
//                    // Locate images in flag column
//
//                    users= (ArrayList<String>) event.get("users");
//                    userString=users.toString();
//                    if (userString.contains(ParseUser.getCurrentUser().getObjectId())){
//
//                        final Event eventlist = new Event();
//                        ParseUser eventuser=event.getParseUser("user");
//                        ParseFile image = (ParseFile) eventuser.get("userphoto");
//                        eventlist.setUserid(eventuser.getObjectId());
//                        eventlist.setEventID(event.getObjectId());
//                        eventlist.setEventNmae((String) event.get("name"));
//                        eventlist.setEventContente((String) event.get("contente"));
//                        //eventlist.setEventLocation((String) event.get("location"));
//                        eventlist.setEventPosition((String) event.get("position"));
//                        eventlist.setEventTimestart((String) event.get("Starttime"));
//                        eventlist.setEventTimeend((String) event.get("Endtime"));
//                        if(image==null){
//
//                            eventlist.setEventUserimage("");
//
//                        }
//                        else {
//                            eventlist.setEventUserimage(image.getUrl());
//                        }
//
//
//
//
//
//
//
//
//
//
//                        data.add(eventlist);
//
//
//                    }
//
//                }
//            } catch (ParseException e) {
//                Log.e("Error", e.getMessage());
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void result) {
//            // Locate the listview in listview_main.xml
//
//            // Pass the results into ListViewAdapter.java
//            adapter = new EventAdapter(getActivity(),
//                    data);
//            // Binds the Adapter to the ListView
//            eventlistView.setAdapter(adapter);
//            eventlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view,
//                                        int position, long id) {
//                    if (ParseUser.getCurrentUser().getObjectId().equals(data.get(position).getUserid())){
//                        data.get(position).getEventID();
//                        Intent zoom = new Intent(getActivity(), DetailsEventActivity.class);
//                        zoom.putExtra("eventID", data.get(position).getEventID());
//                        startActivity(zoom);
//                    }
//
//                    else {
//
//                        data.get(position).getEventID();
//                        Intent zoom = new Intent(getActivity(), DetailsEventpublicActivity.class);
//                        zoom.putExtra("eventID", data.get(position).getEventID());
//                        startActivity(zoom);
//
//                    }
//
////                    overridePendingTransition(R.anim.right_in, R.anim.left_out);
//                }
//            });
//            // Close the progressdialog
//            mProgressDialog.dismiss();
//        }
//    }
//
//
//    public class EventAdapter extends BaseAdapter {
//        boolean flag = true;
//        Context context;
//        LayoutInflater inflater;
//        ImageLoader imageLoader;
//        private ParseFile image;
//        private List<Event> worldpopulationlist = null;
//        private ArrayList<Event> arraylist;
//
//        /**
//         * Constructor from a list of items
//         */
//        public EventAdapter(Context context, List<Event> worldpopulationlist) {
//
//            this.context = context;
//            this.worldpopulationlist = worldpopulationlist;
//            inflater = LayoutInflater.from(context);
//            this.arraylist = new ArrayList<Event>();
//            this.arraylist.addAll(worldpopulationlist);
//            imageLoader = new ImageLoader(context);
//        }
//
//        @Override
//        public View getView(final int position, View view, ViewGroup parent) {
//            final ViewHolder holder;
//
//            if (view == null) {
//                holder = new ViewHolder();
//                view = inflater.inflate(R.layout.evnt_list_item_layout, null);
//
//                holder.userimageview = (ImageView) view.findViewById(R.id.event_imageView);
//                holder.eventnametextview=(TextView)view.findViewById(R.id.event_name_textView);
//                holder.eventtimetextview=(TextView)view.findViewById(R.id.event_time_event_list_textView);
//
//                view.setTag(holder);
//            } else {
//                holder = (ViewHolder) view.getTag();
//            }
//
//            if(worldpopulationlist.get(position).getEventUserimage().equals("")){
//                holder.userimageview.setImageResource(R.drawable.people);
//            }
//            else {
//
//                imageLoader.DisplayImage(worldpopulationlist.get(position).getEventUserimage(), holder.userimageview);
//            }
//            holder.eventnametextview.setText(worldpopulationlist.get(position).getEventNmae());
//            holder.eventtimetextview.setText("Event Start/End: "+worldpopulationlist.get(position).getEventTimestart()+"-"+worldpopulationlist.get(position).getEventTimeend());
//
//
//
//            // Restore the checked state properly
//            final ListView lv = (ListView) parent;
////        holder.layout.setChecked(lv.isItemChecked(position));
//
//            return view;
//        }
//
//        @Override
//        public int getCount() {
//            return worldpopulationlist.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return worldpopulationlist.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        private class ViewHolder {
//
//            public ImageView userimageview;
//            public TextView eventnametextview;
//            public TextView eventtimetextview;
//
//        }
//    }



}
