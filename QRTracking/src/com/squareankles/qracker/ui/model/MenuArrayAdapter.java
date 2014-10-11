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
  
  public MenuArrayAdapter(List<DrawerItem> paramList, Context paramContext)
  {
    this.mMenuItems = paramList;
    this.mContext = paramContext;
  }
  
  public int getCount()
  {
    if (this.mMenuItems != null) {
      return this.mMenuItems.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return this.mMenuItems.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = ((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(R.layout.menu_list_item, paramViewGroup, false);
    TextView localTextView = (TextView)localView.findViewById(2131034178);
    ((ImageView)localView.findViewById(R.id.menu_list_image)).setImageResource(((DrawerItem)this.mMenuItems.get(paramInt)).getImageResource());
    localTextView.setText(((DrawerItem)this.mMenuItems.get(paramInt)).getItemName());
    localView.setTag(this.mMenuItems.get(paramInt));
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
  }
}
