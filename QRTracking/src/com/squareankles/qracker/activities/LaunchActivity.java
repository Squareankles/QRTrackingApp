package com.squareankles.qracker.activities;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.qrtracking.R;
import com.squareankles.qracker.fragments.MembershipFragment;
import com.squareankles.qracker.fragments.OpeningFragment;
import com.squareankles.qracker.ui.model.DrawerItem;
import com.squareankles.qracker.ui.model.DrawerItem.IMenuItem;
import com.squareankles.qracker.ui.model.DrawerItem.MenuView;
import com.squareankles.qracker.ui.model.MenuArrayAdapter;

import java.util.ArrayList;

public class LaunchActivity extends ActionBarActivity {
	private Fragment mCurrentFragment;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launch);
		setUpNavDrawerItems();
		setIntialFragment();
		setUpActionBar();

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		getMenuInflater().inflate(R.menu.launch, menu);
		// restoreActionBar();
		return true;
	}

	private void setUpActionBar() {
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeButtonEnabled(true);
		actionBar.setBackgroundDrawable(getResources().getDrawable(
				R.color.orange));
		actionBar.setIcon(new ColorDrawable(getResources().getColor(
				android.R.color.transparent)));
		this.mDrawerToggle = new ActionBarDrawerToggle(this,
				this.mDrawerLayout, R.drawable.ic_drawer,
				R.string.navigation_drawer_open,
				R.string.navigation_drawer_close) {
		};

		this.mDrawerLayout.setDrawerListener(this.mDrawerToggle);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@SuppressWarnings("unchecked")
	private void setUpNavDrawerItems() {
		mDrawerLayout = ((DrawerLayout) findViewById(R.id.drawer_layout));
		mDrawerList = ((ListView) findViewById(R.id.left_drawer));
		@SuppressWarnings("rawtypes")
		ArrayList drawerItems = new ArrayList();
		drawerItems.add(new DrawerItem("Opening Fragment", 0,OpeningFragment.class, R.drawable.white_launcher));
		drawerItems.add(new DrawerItem("Memberships", 1, MembershipFragment.class, R.drawable.member_icon));
		
		MenuArrayAdapter localMenuArrayAdapter = new MenuArrayAdapter(
				drawerItems, this);
		this.mDrawerList.setAdapter(localMenuArrayAdapter);
		this.mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (this.mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return true;

	}

	private void setIntialFragment() {
		try {

			mCurrentFragment = new OpeningFragment();

			FragmentManager fragmentManager = getSupportFragmentManager();
			android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager
					.beginTransaction().replace(R.id.content_frame,
							mCurrentFragment);
			fragmentTransaction.commit();
		} catch (Exception e) {
			e.toString();
		}
	}

	class DrawerItemClickListener implements AdapterView.OnItemClickListener {
		DrawerItemClickListener() {
		}

		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {

			IMenuItem drawerItemMV = (IMenuItem) view;
			
			LaunchActivity.this.mCurrentFragment = drawerItemMV.getItemFragment();
			drawerItemMV.setItemSelected();
			LaunchActivity.this.getSupportFragmentManager().beginTransaction()
					.replace(R.id.content_frame, mCurrentFragment).commit();
			LaunchActivity.this.mDrawerLayout
					.closeDrawer(LaunchActivity.this.mDrawerList);
		}
	}

}
