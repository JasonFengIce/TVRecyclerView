package cn.ismartv.tvrecyclerview.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.ismartv.tvrecyclerview.widget.GridLayoutManager;
import cn.ismartv.tvrecyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private String[] mSubItems;
    private EpisodeListAdapter mEpisodeListAdapter;

    @BindView(R.id.episode_list)
    public RecyclerView mEpisodeListLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSubItems = new String[100];

        for (int i = 0; i < 100; i++) {
            mSubItems[i] = "hello world " + i;
        }

        mEpisodeListLayout.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, false));
        mEpisodeListAdapter = new EpisodeListAdapter();
        mEpisodeListLayout.setAdapter(mEpisodeListAdapter);
    }

    public void left(View view) {
//        mEpisodeListLayout.

//        mEpisodeListLayout.get
    }

    public void right(View view) {

    }


    class EpisodeListAdapter extends RecyclerView.Adapter<EpisodeListAdapter.EpisodeListHolder> implements View.OnClickListener {

        @Override
        public EpisodeListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_episode, parent,
                    false);
            itemView.setOnClickListener(this);
            EpisodeListHolder holder = new EpisodeListHolder(itemView);
            return holder;
        }

        @Override
        public void onBindViewHolder(EpisodeListHolder holder, int position) {
            if (mSubItems != null && mSubItems.length != 0) {
                holder.itemView.setTag(mSubItems[position]);
                holder.title.setText("第" + (position + 1) + "集");
            }

            Log.i(TAG, "current position: " + position);
        }



        @Override
        public int getItemCount() {
            if (mSubItems != null) {
                return mSubItems.length;
            }
            return 0;
        }

        @Override
        public void onClick(View v) {
//            ItemEntity.SubItem subItem = (ItemEntity.SubItem) v.getTag();
//            ItemInfoManager.getInstance().fetchItemInfo(EpisodeListActivity.this, subItem.getUrl());
        }

        class EpisodeListHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.title)
            TextView title;

            View itemView;

            public EpisodeListHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
                itemView = view;
            }
        }
    }

}
