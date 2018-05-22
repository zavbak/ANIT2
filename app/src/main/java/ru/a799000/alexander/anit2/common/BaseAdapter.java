package ru.a799000.alexander.anit2.common;


import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.a799000.alexander.anit2.model.view.BaseViewModel;
import ru.a799000.alexander.anit2.ui.holder.BaseViewHolder;

public class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder<BaseViewModel>> {

    private List<BaseViewModel> list = new ArrayList<>();

    private ArrayMap<Integer, BaseViewModel> mTypeInstances = new ArrayMap<>();

    private int fullSize;

    @Override
    public BaseViewHolder<BaseViewModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        return mTypeInstances.get(viewType).createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder<BaseViewModel> holder, int position) {
        holder.bindViewHolder(getItem(position));
    }

    @Override
    public void onViewRecycled(BaseViewHolder<BaseViewModel> holder) {
        super.onViewRecycled(holder);
        holder.unbindViewHolder();
    }

    public void registerTypeInstance(BaseViewModel item) {
        if (!mTypeInstances.containsKey(item.getType())) {
            mTypeInstances.put(item.getType().getValue(), item);
        }
    }


    public void setItems(List<BaseViewModel> items, int fullSize) {
        clearList();
        addItems(items,fullSize);

    }

    public void addItems(List<? extends BaseViewModel> newItems, int fullSize) {

        for (BaseViewModel newItem : newItems) {
            registerTypeInstance(newItem);
        }

        list.addAll(newItems);
        setFullSize(fullSize);

        notifyDataSetChanged();
    }


    public void clearList() {
        list.clear();
    }


    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType().getValue();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public BaseViewModel getItem(int position) {
        return list.get(position);
    }

    public int getRealItemCount() {
        int count = 0;
        for (int i = 0; i < getItemCount(); i++) {
            if (!getItem(i).isItemDecorator()) {
                count += 1;
            }
        }
        return count;
    }

    public int getFullSize() {
        return fullSize;
    }

    public void setFullSize(int fullSize) {
        this.fullSize = fullSize;
    }
}
