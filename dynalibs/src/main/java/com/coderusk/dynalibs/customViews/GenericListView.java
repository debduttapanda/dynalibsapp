package com.coderusk.dynalibs.customViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GenericListView extends RecyclerView {

    MenuListAdapter adapter;
    LayoutManager layoutManager;
    public void removeItem(int index) {
        if(adapter!=null)
        {
            adapter.notifyItemRemoved(index);
        }
    }

    public void notifyDataSetChanged() {
        adapter.notifyDataSetChanged();
    }

    public void notifyItemRemoved(int index)
    {
        adapter.notifyItemRemoved(index);
    }

    public void notifyItemInserted(int index)
    {
        adapter.notifyItemInserted(index);
    }
    public void notifyItemChanged(int index)
    {
        adapter.notifyItemChanged(index);
    }

    public interface EventCallback
    {
        void onView(int position, View view);
        int getItemCount();

        int getViewId(int position);

        int getLayoutId(int position);

        boolean layoutGrid();

        int gridColumnCount();

        View getItemView(int position);

        boolean fromLayout();

        boolean isVertical();

        boolean isReverse();

        int getVisibility();

        void onViewRecycled(MenuListAdapter.MyViewHolder holder);

        void onFailedToRecycleView(MenuListAdapter.MyViewHolder holder);

        void onViewAttachedToWindow(MenuListAdapter.MyViewHolder holder);

        void onViewDetachedFromWindow(MenuListAdapter.MyViewHolder holder);

        void onAttachedToRecyclerView(RecyclerView recyclerView);

        void onDetachedFromRecyclerView(RecyclerView recyclerView);
    }

    private EventCallback callback = null;

    private Context context;
    private @IdRes int view_id = -1;
    private @LayoutRes int layout_id = -1;

    public void setup(EventCallback callback)
    {
        this.layout_id = layout_id;
        this.view_id = view_id;
        this.callback = callback;
        adjustVisibility();
        adapter = new MenuListAdapter(context);

        setupLayoutManager();
        //addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
        setAdapter(adapter);
    }

    private void adjustVisibility() {
        if(callback!=null)
        {
            setVisibility(callback.getVisibility());
        }
    }

    private void setupLayoutManager() {
        if(callback!=null)
        {
            if(callback.layoutGrid())
            {
                int span = callback.gridColumnCount();
                layoutManager = new GridLayoutManager(context,span);
            }
            else
            {
                layoutManager = getNewLayoutManager();
            }
        }
        else
        {
            layoutManager = getNewLayoutManager();
        }
        setLayoutManager(layoutManager);
    }

    private LayoutManager getNewLayoutManager() {
        boolean vertical = isVerticalLayout();
        if(!vertical)
        {
            boolean reverse = isReverse();
            new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,reverse);
        }
        return new LinearLayoutManager(context);
    }

    private boolean isReverse() {
        if(callback!=null)
        {
            return callback.isReverse();
        }
        return false;
    }

    private boolean isVerticalLayout() {
        if(callback!=null)
        {
            return callback.isVertical();
        }
        return true;
    }

    private void commonConstructor(Context context)
    {
        this.context = context;
    }

    public GenericListView(@NonNull Context context) {
        super(context);
        commonConstructor(context);
    }

    public GenericListView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        commonConstructor(context);
    }

    public GenericListView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        commonConstructor(context);
    }

    /****************************************************************/
    public class MenuListAdapter extends Adapter<MenuListAdapter.MyViewHolder> {
        private Context context;

        @Override
        public void onViewRecycled(@NonNull MyViewHolder holder) {
            super.onViewRecycled(holder);
            if(callback!=null)
            {
                callback.onViewRecycled(holder);
            }
        }

        @Override
        public boolean onFailedToRecycleView(@NonNull MyViewHolder holder) {
            if(callback!=null)
            {
                callback.onFailedToRecycleView(holder);
            }
            return super.onFailedToRecycleView(holder);
        }

        @Override
        public void onViewAttachedToWindow(@NonNull MyViewHolder holder) {
            super.onViewAttachedToWindow(holder);
            if(callback!=null)
            {
                callback.onViewAttachedToWindow(holder);
            }
        }

        @Override
        public void onViewDetachedFromWindow(@NonNull MyViewHolder holder) {
            super.onViewDetachedFromWindow(holder);
            if(callback!=null)
            {
                callback.onViewDetachedFromWindow(holder);
            }
        }

        @Override
        public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            if(callback!=null)
            {
                callback.onAttachedToRecyclerView(recyclerView);
            }
        }

        @Override
        public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
            super.onDetachedFromRecyclerView(recyclerView);
            if(callback!=null)
            {
                callback.onDetachedFromRecyclerView(recyclerView);
            }
        }

        public class MyViewHolder extends ViewHolder {
            public View anyViewItem;

            public MyViewHolder(View itemView) {
                super(itemView);
                if(callback!=null)
                {
                    if(callback.fromLayout())
                    {
                        anyViewItem = itemView.findViewById(view_id);
                        return;
                    }
                }
                anyViewItem = itemView;
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MenuListAdapter(Context context) {
            this.context = context;


        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if(callback!=null)
            {
                View view = callback.getItemView(viewType);
                if(view!=null)
                {
                    MyViewHolder vh = new MyViewHolder(view);
                    return vh;
                }
            }
            View v = LayoutInflater.from(parent.getContext()).inflate(getLayoutId(viewType), parent, false);
            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            if(callback!=null)
            {
                View view = holder.anyViewItem;
                callback.onView(position, view);
            }
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            if(callback!=null)
            {
                return callback.getItemCount();
            }
            return 0;
        }
    }

    private int getLayoutId(int position) {
        if(callback!=null)
        {
            view_id = callback.getViewId(position);
            return callback.getLayoutId(position);
        }
        return 0;
    }
}
