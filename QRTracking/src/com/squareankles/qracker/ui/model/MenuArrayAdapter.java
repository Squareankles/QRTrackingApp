package com.squareankles.qracker.ui.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
import com.example.qrtracking.R;

@SuppressLint("ViewHolder")
public class MenuArrayAdapter
  extends BaseAdapter
{
  private Context mContext;
  List<DrawerItem> mMenuItems;
  
  public MenuArrayAdapter(List<DrawerItem> menuItems, Context context)
  {
    this.mMenuItems = menuItems;
    this.mContext = context;
  }
  
  public int getCount()
  {
    if (this.mMenuItems != null) {
      return this.mMenuItems.size();
    }
    return 0;
  }
  
  public Object getItem(int position)
  {
    return mMenuItems.get(position);
  }
  
  public long getItemId(int position)
  {
    return position;
  }
  
  public View getView(int position, View view, ViewGroup viewGroup)
  {
	DrawerItem mItem= (DrawerItem)mMenuItems.get(position);
    return  mItem.CreateView(mContext);
  }
  
  
}
