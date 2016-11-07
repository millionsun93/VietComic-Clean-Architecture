package com.quanlt.vietcomicclean.presentation.view.adapter;

import android.content.Context;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.florent37.glidepalette.GlidePalette;
import com.quanlt.vietcomicclean.R;
import com.quanlt.vietcomicclean.presentation.model.ComicModel;
import com.quanlt.vietcomicclean.presentation.view.util.OnItemClickListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by quanlt on 06/11/2016.
 */

public class ComicsAdapter extends RecyclerView.Adapter<ComicsAdapter.ComicViewHolder> {
    private List<ComicModel> comicList;
    private final LayoutInflater inflater;
    private final Context context;

    private OnItemClickListener onItemClickListener;

    @Inject
    public ComicsAdapter(Context context) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.comicList = new ArrayList<>();
        this.context = context;
    }

    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = inflater.inflate(R.layout.view_item_comic, parent, false);
        return new ComicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComicViewHolder holder, final int position) {
        holder.comicTitleTextView.setText(comicList.get(position).getTitle());
        holder.latestChapterTextView.setText(comicList.get(position).getLatestChapter());
        Glide.with(context).load(comicList.get(position).getThumbnail())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .listener(GlidePalette.with(comicList.get(position).getThumbnail())
                        .intoCallBack(palette -> {
                            Palette.Swatch swatch = palette.getVibrantSwatch();
                            if (swatch != null) {
                                holder.footerView.setBackgroundColor(swatch.getRgb());
                                holder.comicTitleTextView.setTextColor(swatch.getBodyTextColor());
                                holder.latestChapterTextView.setTextColor(swatch.getBodyTextColor());
                            }
                        }))
                .into(holder.comicThumbnailImageView);
        holder.itemView.setOnClickListener(view -> onItemClickListener.onItemClickListener(comicList.get(position)));
    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setComicList(Collection<ComicModel> comicList) {
        int idx = comicList.size();
        this.comicList.addAll(comicList);
        notifyItemRangeInserted(idx, comicList.size());

    }

    public class ComicViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_comic_title)
        TextView comicTitleTextView;
        @BindView(R.id.tv_latest_chapter)
        TextView latestChapterTextView;
        @BindView(R.id.iv_comic_thumbnail)
        ImageView comicThumbnailImageView;
        @BindView(R.id.rl_footer_view)
        RelativeLayout footerView;

        public ComicViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
