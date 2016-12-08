package com.social.mobile.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.social.mobile.R;
import com.social.mobile.fragment.AskShareFragment;
import com.social.mobile.fragment.GameFragment;
import com.social.mobile.fragment.ShareCarFragment;
import com.social.mobile.fragment.TradeFragment;

/**
 * Created by malijie on 2016/12/8.
 */

public class HomePageActivity extends Activity implements View.OnClickListener{
    /**
     * 用于展示消息的Fragment
     */
    private AskShareFragment mAskFragment;

    /**
     * 用于展示联系人的Fragment
     */
    private GameFragment mGameFragment;

    /**
     * 用于展示动态的Fragment
     */
    private ShareCarFragment mShareCarFragment;

    /**
     * 用于展示设置的Fragment
     */
    private TradeFragment mTradeFragment;

    /**
     * 消息界面布局
     */
    private View mAskShareLayout;

    /**
     * 联系人界面布局
     */
    private View mGameLayout;

    /**
     * 动态界面布局
     */
    private View mShareCarLayout;

    /**
     * 设置界面布局
     */
    private View mTradeLayout;

    /**
     * 在Tab布局上显示消息图标的控件
     */
    private ImageView mAskShareImage;

    /**
     * 在Tab布局上显示联系人图标的控件
     */
    private ImageView mGameImage;

    /**
     * 在Tab布局上显示动态图标的控件
     */
    private ImageView mShareCarImage;

    /**
     * 在Tab布局上显示设置图标的控件
     */
    private ImageView mTradeImage;

    /**
     * 在Tab布局上显示消息标题的控件
     */
    private TextView mAakShareText;

    /**
     * 在Tab布局上显示联系人标题的控件
     */
    private TextView mGameText;

    /**
     * 在Tab布局上显示动态标题的控件
     */
    private TextView mShareCarText;

    /**
     * 在Tab布局上显示设置标题的控件
     */
    private TextView mTradeText;

    /**
     * 用于对Fragment进行管理
     */
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.home_page);
        // 初始化布局元素
        initViews();
        fragmentManager = getFragmentManager();
        // 第一次启动时选中第0个tab
        setTabSelection(0);
    }

    /**
     * 在这里获取到每个需要用到的控件的实例，并给它们设置好必要的点击事件。
     */
    private void initViews() {
        mAskShareLayout = findViewById(R.id.message_layout);
        mGameLayout = findViewById(R.id.contacts_layout);
        mShareCarLayout = findViewById(R.id.news_layout);
        mTradeLayout = findViewById(R.id.setting_layout);
        mAskShareImage = (ImageView) findViewById(R.id.message_image);
        mGameImage = (ImageView) findViewById(R.id.contacts_image);
        mShareCarImage = (ImageView) findViewById(R.id.news_image);
        mTradeImage = (ImageView) findViewById(R.id.setting_image);
        mAakShareText = (TextView) findViewById(R.id.message_text);
        mGameText = (TextView) findViewById(R.id.contacts_text);
        mShareCarText = (TextView) findViewById(R.id.news_text);
        mTradeText = (TextView) findViewById(R.id.setting_text);
        mAskShareLayout.setOnClickListener(this);
        mGameLayout.setOnClickListener(this);
        mShareCarLayout.setOnClickListener(this);
        mTradeLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.message_layout:
                // 当点击了消息tab时，选中第1个tab
                setTabSelection(0);
                break;
            case R.id.contacts_layout:
                // 当点击了联系人tab时，选中第2个tab
                setTabSelection(1);
                break;
            case R.id.news_layout:
                // 当点击了动态tab时，选中第3个tab
                setTabSelection(2);
                break;
            case R.id.setting_layout:
                // 当点击了设置tab时，选中第4个tab
                setTabSelection(3);
                break;
            default:
                break;
        }
    }

    /**
     * 根据传入的index参数来设置选中的tab页。
     *
     * @param index
     *            每个tab页对应的下标。0表示消息，1表示联系人，2表示动态，3表示设置。
     */
    private void setTabSelection(int index) {
        // 每次选中之前先清楚掉上次的选中状态
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                // 当点击了消息tab时，改变控件的图片和文字颜色
                mAskShareImage.setImageResource(R.mipmap.tab_chactor_selected);
                mAakShareText.setTextColor(Color.WHITE);
                if (mAskFragment == null) {
                    // 如果MessageFragment为空，则创建一个并添加到界面上
                    mAskFragment = new AskShareFragment();
                    transaction.add(R.id.content, mAskFragment);
                } else {
                    // 如果MessageFragment不为空，则直接将它显示出来
                    transaction.show(mAskFragment);
                }
                break;
            case 1:
                // 当点击了联系人tab时，改变控件的图片和文字颜色
                mGameImage.setImageResource(R.mipmap.tab_huodong_selected);
                mGameText.setTextColor(Color.WHITE);
                if (mGameFragment == null) {
                    // 如果ContactsFragment为空，则创建一个并添加到界面上
                    mGameFragment = new GameFragment();
                    transaction.add(R.id.content, mGameFragment);
                } else {
                    // 如果ContactsFragment不为空，则直接将它显示出来
                    transaction.show(mGameFragment);
                }
                break;
            case 2:
                // 当点击了动态tab时，改变控件的图片和文字颜色
                mShareCarImage.setImageResource(R.mipmap.tab_pinche_selected);
                mShareCarText.setTextColor(Color.WHITE);
                if (mShareCarFragment == null) {
                    // 如果NewsFragment为空，则创建一个并添加到界面上
                    mShareCarFragment = new ShareCarFragment();
                    transaction.add(R.id.content, mShareCarFragment);
                } else {
                    // 如果NewsFragment不为空，则直接将它显示出来
                    transaction.show(mShareCarFragment);
                }
                break;
            case 3:
            default:
                // 当点击了设置tab时，改变控件的图片和文字颜色
                mTradeImage.setImageResource(R.mipmap.tab_buy_selected);
                mTradeText.setTextColor(Color.WHITE);
                if (mTradeFragment == null) {
                    // 如果SettingFragment为空，则创建一个并添加到界面上
                    mTradeFragment = new TradeFragment();
                    transaction.add(R.id.content, mTradeFragment);
                } else {
                    // 如果SettingFragment不为空，则直接将它显示出来
                    transaction.show(mTradeFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 清除掉所有的选中状态。
     */
    private void clearSelection() {
        mAskShareImage.setImageResource(R.mipmap.tab_chactor_normal);
        mAakShareText.setTextColor(Color.parseColor("#82858b"));
        mGameImage.setImageResource(R.mipmap.tab_huodong_normal);
        mGameText.setTextColor(Color.parseColor("#82858b"));
        mShareCarImage.setImageResource(R.mipmap.tab_pinche_normal);
        mShareCarText.setTextColor(Color.parseColor("#82858b"));
        mTradeImage.setImageResource(R.mipmap.tab_buy_normal);
        mTradeText.setTextColor(Color.parseColor("#82858b"));
    }

    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction
     *            用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (mAskFragment != null) {
            transaction.hide(mAskFragment);
        }
        if (mGameFragment != null) {
            transaction.hide(mGameFragment);
        }
        if (mShareCarFragment != null) {
            transaction.hide(mShareCarFragment);
        }
        if (mTradeFragment != null) {
            transaction.hide(mTradeFragment);
        }
    }
}
