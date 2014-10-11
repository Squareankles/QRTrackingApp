package com.squareankles.qracker.ui.model;

import android.support.v4.app.Fragment;

import java.lang.reflect.InvocationTargetException;

public class DrawerItem
{
  @SuppressWarnings("rawtypes")
private Class mFragmentClass;
  private int mID;
  private int mImageResource;
  private String mItemName;
  
  public DrawerItem(String paramString, int paramInt1, @SuppressWarnings("rawtypes") Class paramClass, int paramInt2)
  {
    this.mItemName = paramString;
    this.mFragmentClass = paramClass;
    this.mID = paramInt1;
    this.mImageResource = paramInt2;
  }
  
  public Fragment getFragment()
  {
    try
    {
      Fragment localFragment = (Fragment)this.mFragmentClass.getConstructors()[0].newInstance(new Object[0]);
      return localFragment;
    }
    catch (InstantiationException localInstantiationException)
    {
      localInstantiationException.printStackTrace();
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      for (;;)
      {
        localInvocationTargetException.printStackTrace();
      }
    }
  }
  
  public int getImageResource()
  {
    return this.mImageResource;
  }
  
  public String getItemName()
  {
    return this.mItemName;
  }
  
  public int getid()
  {
    return this.mID;
  }
}
