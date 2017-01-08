package io.github.a0gajun.esareader.presentation.view.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.github.a0gajun.esareader.R;
import io.github.a0gajun.esareader.databinding.LayoutPostListRowBinding;
import io.github.a0gajun.esareader.domain.model.Post;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by Junya on 1/8/17.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.BindingHolder> {

    private List<Post> postList;
    private final LayoutInflater layoutInflater;

    @Inject
    public PostsAdapter(Context context) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.postList = Collections.emptyList();
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = this.layoutInflater.inflate(R.layout.layout_post_list_row, parent, false);
        return new BindingHolder(view);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, final int position) {
        final Post post = postList.get(position);
        holder.getBinding().setPost(post);

        final ImageView avatarImg = holder.getBinding().avatarImg;
        Glide.with(avatarImg.getContext())
                .load(post.getCreatedBy().getIconUrl())
                .bitmapTransform(new CropCircleTransformation(avatarImg.getContext()))
                .into(avatarImg);
    }

    @Override
    public int getItemCount() {
        return (this.postList != null) ? this.postList.size() : 0;
    }

    public void setPostsCollection(Collection<Post> postsCollection) {
        this.postList = (List<Post>) postsCollection;
        this.notifyDataSetChanged();
    }

    static final class BindingHolder extends RecyclerView.ViewHolder {
        private final LayoutPostListRowBinding binding;

        public BindingHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public LayoutPostListRowBinding getBinding() {
            return binding;
        }
    }
}
