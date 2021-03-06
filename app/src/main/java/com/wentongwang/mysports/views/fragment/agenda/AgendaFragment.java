package com.wentongwang.mysports.views.fragment.agenda;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.wentongwang.mysports.R;
import com.wentongwang.mysports.custome.CircleImageView;
import com.wentongwang.mysports.custome.MyProgressBarHorizontal;
import com.wentongwang.mysports.views.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Wentong WANG on 2016/9/17.
 */
public class AgendaFragment extends BaseFragment implements AgendaView {

    @BindView(R.id.root_view)
    protected View rootView;
    @BindView(R.id.agenda_events_list)
    protected ListView listView;

    private MyAdapter adapter;

    private AgendaPresenter mPresenter = new AgendaPresenter(this);

    @Override
    public int getLayoutId() {
        return R.layout.agenda_fragment_layout;
    }

    @Override
    public void initDatas() {
        mPresenter.init(getActivity());

        adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }

    @Override
    public void initEvents() {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showPersonInfoPopupWindow(PopupWindow popupWindow) {
        popupWindow.showAtLocation(rootView, Gravity.CENTER, 0, 0);
    }

    @Override
    public void setBackGroundAlpha(float alpha) {
        WindowManager.LayoutParams windowlp = getActivity().getWindow().getAttributes();
        windowlp.alpha = alpha;
        getActivity().getWindow().setAttributes(windowlp);
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 11;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_agenda_event_list, null);
                viewHolder = new ViewHolder(convertView);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.event_place.setText("UTT");
            viewHolder.event_time.setText("12:00");
            viewHolder.event_type.setText("BASKETBALL");
            viewHolder.event_progress.setProgress(position * 10);

            viewHolder.user_head.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPresenter.showPopupWindow();
                }
            });

            return convertView;
        }

        class ViewHolder {
            @BindView(R.id.user_head)
            CircleImageView user_head;
            @BindView(R.id.tv_event_type)
            TextView event_type;
            @BindView(R.id.tv_event_time)
            TextView event_time;
            @BindView(R.id.tv_event_place)
            TextView event_place;
            @BindView(R.id.event_progress_bar)
            MyProgressBarHorizontal event_progress;

            public ViewHolder(View v) {
                ButterKnife.bind(this, v);

            }
        }
    }


}
