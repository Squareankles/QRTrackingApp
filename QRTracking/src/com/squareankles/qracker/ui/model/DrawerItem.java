package com.squareankles.qracker.ui.model;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.InvocationTargetException;
import java.util.jar.Attributes.Name;

import com.example.qrtracking.R;

public class DrawerItem {
	@SuppressWarnings("rawtypes")
	private Class mFragmentClass;
	private int mID;
	private int mImageResource;
	private String mItemName;

	public DrawerItem(String paramString, int paramInt1,
			@SuppressWarnings("rawtypes") Class paramClass, int paramInt2) {
		this.mItemName = paramString;
		this.mFragmentClass = paramClass;
		this.mID = paramInt1;
		this.mImageResource = paramInt2;
	}
	
	private Fragment getFragment() {
		try {
			Fragment localFragment = (Fragment) this.mFragmentClass
					.getConstructors()[0].newInstance(new Object[0]);
			return localFragment;
		} catch (InstantiationException localInstantiationException) {
			localInstantiationException.printStackTrace();
			return null;
		} catch (IllegalAccessException localIllegalAccessException) {
			for (;;) {
				localIllegalAccessException.printStackTrace();
			}
		} catch (IllegalArgumentException localIllegalArgumentException) {
			for (;;) {
				localIllegalArgumentException.printStackTrace();
			}
		} catch (InvocationTargetException localInvocationTargetException) {
			for (;;) {
				localInvocationTargetException.printStackTrace();
			}
		}
	}


	public View CreateView(Context context) {
		MenuView drawerView = new MenuView(context);

		return drawerView;

	}

	public interface IMenuItem{
		public Fragment getItemFragment();
		public void setItemSelected();
	}
	public class MenuView extends LinearLayout implements IMenuItem {

		private TextView mName;
		private ImageView mImage;
		private View mLayout;
		
		public MenuView(Context context) {
			super(context);
			initView();
		}

		
		
		
		private void initView() {
			// Inflate the view and set the variables
			mLayout = inflate(getContext(), R.layout.menu_list_item, null);
			mName = (TextView) mLayout.findViewById(R.id.item_name);
			mName.setText(mItemName);
			ImageView mImage=(ImageView) mLayout.findViewById(R.id.menu_list_image);
			mImage.setImageResource(mImageResource);
			addView(mLayout);
		}




		@Override
		public Fragment getItemFragment() {
			// TODO Auto-generated method stub
			return getFragment();
		}




		@Override
		public void setItemSelected() {
			mLayout.setBackgroundColor(getResources().getColor(R.color.grey));
			
		}

	}
}
